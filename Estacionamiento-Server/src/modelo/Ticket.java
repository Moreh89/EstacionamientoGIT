package modelo;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Ticket {
	

	private long idTicket;
	private double montoCobrado;
	//Estado ABIERTO/PREPAGO/CERRADO
	private Estado estado;
	//Time puede cambiarse si no es compatible con hibernate
	private Date fechaLlegada;
	private Date fechaSalida;
	private CategoriaVehiculo catergoriaVehiculo;
	private ModeloVehiculo modeloVehiculo;
	private Cliente cliente;
	private Descuento descuento;
	private Usuario usuario; //usuario del sistema (util para arqueo caja)
	//TODO Esto hay que sacarlo
	private String tipoIngreso; //si hay que cobrar por hora o por estadia.
	private double prepago; //Si ya pago algo
	private String observacion;
	
	public enum Estado {
		ABIERTO,
		PREPAGO,
		CERRADO;
	}
	
	
	public double getPrepago() {
		return prepago;
	}
	public void setPrepago(double prepago) {
		this.prepago = prepago;
	}
	public long getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(long idTicket) {
		this.idTicket = idTicket;
	}
	public double getMontoCobrado() {
		return montoCobrado;
	}
	public void setMontoCobrado(double montoCobrado) {
		this.montoCobrado = montoCobrado;
	}
	public Descuento getDescuento() {
		return descuento;
	}
	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTipoIngreso() {
		return tipoIngreso;
	}
	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public CategoriaVehiculo getCatergoriaVehiculo() {
		return catergoriaVehiculo;
	}
	public void setCatergoriaVehiculo(CategoriaVehiculo catergoriaVehiculo) {
		this.catergoriaVehiculo = catergoriaVehiculo;
	}
	public ModeloVehiculo getModeloVehiculo() {
		return modeloVehiculo;
	}
	public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}
	public Ticket(CategoriaVehiculo catvehiculo,ModeloVehiculo modVehiculo, Cliente cliente,
			Descuento descuento, Usuario usuario,
			double prepago, String obsevacion) {
		super();
		
		//TODO convertir el DATE como corresponde
		this.fechaLlegada = (Date) GregorianCalendar.getInstance().getTime();
		this.fechaSalida = null;
		
		if(prepago == 0)	this.estado = Ticket.Estado.ABIERTO;
		else 				this.estado = Ticket.Estado.PREPAGO;
		
		this.montoCobrado = 0;
		this.catergoriaVehiculo = catvehiculo;
		this.modeloVehiculo = modVehiculo;
		this.cliente = cliente;
		this.descuento = descuento;
		this.usuario = usuario;
		this.tipoIngreso = null;
		this.prepago = prepago;
		this.observacion = obsevacion;
	}
	public double cobrar(int cantidadMinutos, Tarifa tarifa)
	{
		double montoCobrar=0;        

		if(tipoIngreso.equals("porHora"))
		{
			montoCobrar=cobroPorHora(cantidadMinutos, tarifa);
		}
		else if(tipoIngreso.equals("porEstadia"))
		{
			montoCobrar=cobroPorEstadia(cantidadMinutos, tarifa);
		}
		return montoCobrar;
	}



	private static double cobroPorHora(double cantidadMinutos, Tarifa tarifa)
	{
		double montoCobrar=0;
		if(cantidadMinutos<60)
		{
			montoCobrar=tarifa.getCostoMinimo();
		}
		else
		{
			//Calculo Multiplo comun maximo -> puede que haya function.
			double countHs=(int)(cantidadMinutos/60);
			montoCobrar=montoCobrar+tarifa.getCostoHora()*countHs;
			cantidadMinutos=cantidadMinutos-countHs*60;
			//con el Math.ceil redondeo al techo.
			double countFracciones=(int)Math.ceil((cantidadMinutos)/tarifa.getTiempoFraccion());
			montoCobrar=montoCobrar+tarifa.getCostoFraccion()*countFracciones;
		}
		return montoCobrar;
	}

	private static double cobroPorEstadia(double cantidadMinutos, Tarifa tarifa)
	{
		double montoCobrar=0;

		if(cantidadMinutos<=tarifa.getTiempoMediaEstadia_minuto())
		{
			montoCobrar=tarifa.getCostoMediaEstadia();
		}
		else if(cantidadMinutos<=tarifa.getTiempoEstadia_minuto())
		{
			montoCobrar=tarifa.getCostoEstadia();
		}
		else
		{
			double cantidadHsEstadia=(int)(cantidadMinutos/tarifa.getTiempoEstadia_minuto());
			montoCobrar=montoCobrar+tarifa.getCostoEstadia()*cantidadHsEstadia;
			cantidadMinutos=cantidadMinutos-cantidadHsEstadia*tarifa.getTiempoEstadia_minuto();			
			double cantidadHsMediaEstadia=(int)(cantidadMinutos/tarifa.getTiempoMediaEstadia_minuto());
			if(cantidadHsMediaEstadia>=0)
			{
				montoCobrar=montoCobrar+tarifa.getCostoMediaEstadia()*cantidadHsMediaEstadia;
				cantidadMinutos=cantidadMinutos-cantidadHsMediaEstadia*tarifa.getTiempoMediaEstadia_minuto();
			}			
			//con el Math.ceil redondeo al techo.
			double countFracciones=(int)Math.ceil((cantidadMinutos)/tarifa.getTiempoFraccion());
			montoCobrar=montoCobrar+tarifa.getCostoFraccion()*countFracciones;
		}


		return montoCobrar;
	}


}
