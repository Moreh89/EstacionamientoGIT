package modelo;

import java.sql.Date;
import java.sql.Time;

public class Ticket {
	
	//Rodrigo estuva aca

	long idTicket;
	double montoCobrado;
	String estado;
	//Time puede cambiarse si no es compatible con hibernate
	Date fechaLlegada;
	Date fechaSalida;

	Vehiculo vehiculo;
	Cliente cliente;
	Descuento descuento;
	Usuario usuario; //usuario del sistema (util para arqueo caja)
	
	String tipoIngreso; //si hay que cobrar por hora o por estadia.
	
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
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
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
