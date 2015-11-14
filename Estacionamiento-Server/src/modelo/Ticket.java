package modelo;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Calendar;
import controlador.Controlador;

public class Ticket {
	

	private long idTicket;
	private double montoCobrado;
	//Estado ABIERTO/PREPAGO/CERRADO/CREDITO
	private Estado estado;
	//Time puede cambiarse si no es compatible con hibernate
	private Date fechaLlegada;
	private Date fechaSalida;
	private CategoriaVehiculo catergoriaVehiculo;
	private ModeloVehiculo modeloVehiculo;
	private Cliente cliente;
	private Descuento descuento;
	private Usuario usuario; //usuario del sistema (util para arqueo caja)
	private double prepago; //Si ya pago algo
	private String observacion;
	private ColorVehiculo color;
	private String patente;
	private boolean pagotarjeta;
	
	
	public enum Estado {
		ABIERTO,
		PREPAGO,
		CERRADO,
		CREDITO;
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
	public double getTotalCobrado(){
		return montoCobrado + prepago;
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
			Descuento descuento, ColorVehiculo col, Usuario usuario,
			double prepago, String obsevacion, String patente, boolean pagoTarjeta) {
		super();
		
		this.fechaLlegada = Calendar.getInstance().getTime();
		this.fechaSalida = null;
		
		if(prepago == 0)	this.estado = Ticket.Estado.ABIERTO;
		else 				this.estado = Ticket.Estado.PREPAGO;
		
		this.montoCobrado = 0;
		this.catergoriaVehiculo = catvehiculo;
		this.modeloVehiculo = modVehiculo;
		this.cliente = cliente;
		this.descuento = descuento;
		this.usuario = usuario;
		this.prepago = prepago;
		this.observacion = obsevacion;
		this.color = col;
		this.setPatente(patente);
		this.pagotarjeta = pagoTarjeta;
	}
	public Ticket() {
	}
	
	public double calcularMontoACobrar()
	{
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		if(this.getEstado()!= Ticket.Estado.CERRADO && this.getEstado()!= Ticket.Estado.CREDITO){

		Date horaLlegada = this.fechaLlegada;
		Date horaSalida = Calendar.getInstance().getTime();
		this.fechaSalida = horaSalida;
		Tarifa tarifaUsada = null;
		
		for (Tarifa tarifaTemp : Controlador.getInstancia().getTarifas()) {
			if(tarifaTemp.getCategoria().getDescripcion().equals(this.catergoriaVehiculo.getDescripcion())){
				tarifaUsada = tarifaTemp;
				break;
			}
		} 
		double montoCobrar = 0.0;
			      
		
		long diff = horaSalida.getTime() - horaLlegada.getTime();
		
		double diffMinutes = diff / (60 * 1000);
		
		//Me quede menos del tiempo minimo
		if(tarifaUsada.getTiempoMinimo() >= diffMinutes ){
			
			montoCobrar = montoCobrar + tarifaUsada.getCostoMinimo();
			if(this.descuento!=null){
				double desc = montoCobrar / 100 * this.descuento.getDescuento();
				montoCobrar = montoCobrar - desc;
			}
			montoCobrar = montoCobrar - this.prepago;
			if (montoCobrar < 0) montoCobrar=0.0;
			else montoCobrar = Double.parseDouble(numberFormat.format(montoCobrar).replace(",", "."));
			this.montoCobrado = montoCobrar;
			return montoCobrar;
		}
			//Si me quede mas de una estadia
			else if(tarifaUsada.getTiempoEstadia_minuto() <= diffMinutes ){
				
				double estadias = 0;
				//Las estadias de 24hs
				while (diffMinutes >= 1440){
					estadias++;
					diffMinutes = diffMinutes - 1440;
				}//La estadia de entre 24hs y el inicio de la estadia
				if(diffMinutes >= tarifaUsada.getTiempoEstadia_minuto()){
					estadias++;
					diffMinutes = 0;
				}
				double restoEstadias = diffMinutes;
				
				//Media estadia
				double mediaEst = 0;
				if(restoEstadias >= tarifaUsada.getTiempoMediaEstadia_minuto()){
					mediaEst++;
					restoEstadias = restoEstadias - 720;
					if (restoEstadias < 0) restoEstadias = 0;
				}
				
				double restoMediaEst = restoEstadias;
				
				double restoHoras = restoMediaEst % 60;
				double horas = (restoMediaEst - restoHoras)/60;
				
				double restoFrac = restoHoras % tarifaUsada.getTiempoFraccion();
				double fracs = (restoHoras - restoFrac) / tarifaUsada.getTiempoFraccion();
				
				montoCobrar = montoCobrar + estadias * tarifaUsada.getCostoEstadia() + mediaEst * tarifaUsada.getCostoMediaEstadia() + horas * tarifaUsada.getCostoHora() + fracs * tarifaUsada.getCostoFraccion();

				if(this.descuento!=null){
					double desc = montoCobrar / 100 * this.descuento.getDescuento();
					montoCobrar = montoCobrar - desc;
				}
				montoCobrar = montoCobrar - this.prepago;
				if (montoCobrar < 0) montoCobrar=0.0;
				else montoCobrar = Double.parseDouble(numberFormat.format(montoCobrar).replace(",", "."));			
				this.montoCobrado = montoCobrar;
				
				return montoCobrar;
			}
				//Si me quede mas de media estadia pero menos de una estadia entera
				else if(tarifaUsada.getTiempoMediaEstadia_minuto() <= diffMinutes){
				
					double restoMediaEst = 0;
					double mediaEst = 0;
					if(diffMinutes >= tarifaUsada.getTiempoMediaEstadia_minuto()){
						mediaEst++;
						restoMediaEst = diffMinutes - 720;
						if (restoMediaEst < 0) restoMediaEst = 0;
					}
					
					double restoHoras = restoMediaEst % 60;
					double horas = (restoMediaEst - restoHoras)/60;
					
					double restoFrac = restoHoras % tarifaUsada.getTiempoFraccion();
					double fracs = (restoHoras - restoFrac) / tarifaUsada.getTiempoFraccion();
					
					montoCobrar = montoCobrar + mediaEst * tarifaUsada.getCostoMediaEstadia() + horas * tarifaUsada.getCostoHora() + fracs * tarifaUsada.getCostoFraccion();					
					if(this.descuento!=null){
						double desc = montoCobrar / 100 * this.descuento.getDescuento();
						montoCobrar = montoCobrar - desc;
					}
					montoCobrar = montoCobrar - this.prepago;
					if (montoCobrar < 0) montoCobrar=0.0;
					else montoCobrar = Double.parseDouble(numberFormat.format(montoCobrar).replace(",", "."));		
					this.montoCobrado = montoCobrar;
					
					return montoCobrar;
					
				}
					//Si me quede mas del minimo pero menos de media estadia
					else {
						
						double restoHoras = diffMinutes % 60;
						double horas = (diffMinutes - restoHoras)/60;
						
						double restoFrac = restoHoras % tarifaUsada.getTiempoFraccion();
						double fracs = (restoHoras - restoFrac) / tarifaUsada.getTiempoFraccion();
						if(restoFrac >= 1){
							fracs = fracs + 1;
						}
						
						montoCobrar = montoCobrar + horas * tarifaUsada.getCostoHora() + fracs * tarifaUsada.getCostoFraccion();
						
						if(this.descuento!=null){
							double desc = montoCobrar / 100 * this.descuento.getDescuento();
							montoCobrar = montoCobrar - desc;
						}
						montoCobrar = montoCobrar - this.prepago;
						if (montoCobrar < 0) montoCobrar=0.0;
						else montoCobrar = Double.parseDouble(numberFormat.format(montoCobrar).replace(",", "."));	
						this.montoCobrado = montoCobrar;
						
						
						return montoCobrar;
					}
		}
		return this.montoCobrado;
	}

	public void setColor(ColorVehiculo color) {
		this.color = color;
	}
	public ColorVehiculo getColor() {
		return color;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getPatente() {
		return patente;
	}
	public String getTiempoEstadia(){
		
		if(this.fechaSalida == null){
			Date horaSalida = Calendar.getInstance().getTime();
			this.fechaSalida = horaSalida;
		}

		Tarifa tarifaUsada = null;
		
		for (Tarifa tarifaTemp : Controlador.getInstancia().getTarifas()) {
			if(tarifaTemp.getCategoria().getDescripcion().equals(this.catergoriaVehiculo.getDescripcion())){
				tarifaUsada = tarifaTemp;
				break;
			}
		}    
		
		long diff = this.fechaSalida.getTime() - this.fechaLlegada.getTime();
		
		long diffMinutes = diff / (60 * 1000);
//
//		//Me quede menos del tiempo minimo
//		if(tarifaUsada.getTiempoMinimo() >= diffMinutes ){
//			return "Minimo";
//		}
//			//Si me quede mas de una estadia
//			else if(tarifaUsada.getTiempoEstadia_minuto() <= diffMinutes ){
//				
//				double estadias = 0;
//				//Las estadias de 24hs
//				while (diffMinutes >= 1440){
//					estadias++;
//					diffMinutes = diffMinutes - 1440;
//				}//La estadia de entre 24hs y el inicio de la estadia
//				if(diffMinutes >= tarifaUsada.getTiempoEstadia_minuto()){
//					estadias++;
//					diffMinutes = 0;
//				}
//				double restoEstadias = diffMinutes;
//				
//				//Media estadia
//				double mediaEst = 0;
//				if(restoEstadias >= tarifaUsada.getTiempoMediaEstadia_minuto()){
//					mediaEst++;
//					restoEstadias = restoEstadias - 720;
//					if (restoEstadias < 0) restoEstadias = 0;
//				}
//				
//				double restoMediaEst = restoEstadias;
//				
//				double restoHoras = restoMediaEst % 60;
//				double horas = (restoMediaEst - restoHoras)/60;
//				
//				double restoFrac = restoHoras % tarifaUsada.getTiempoFraccion();
//				double fracs = (restoHoras - restoFrac) / tarifaUsada.getTiempoFraccion();
//				
//				String tiempoCobrar = (int)estadias + "Es " + (int)mediaEst + "Me " + (int)horas + "Hr " + (int)fracs + "Fr";
//
//				return tiempoCobrar;
//			}
//				//Si me quede mas de media estadia pero menos de una estadia entera
//				else if(tarifaUsada.getTiempoMediaEstadia_minuto() <= diffMinutes){
//				
//					
//					double restoMediaEst = 0;
//					double mediaEst = 0;
//					if(diffMinutes >= tarifaUsada.getTiempoMediaEstadia_minuto()){
//						mediaEst++;
//						restoMediaEst = diffMinutes - 720;
//						if (restoMediaEst < 0) restoMediaEst = 0;
//					}
//					
//					double restoHoras = restoMediaEst % 60;
//					double horas = (restoMediaEst - restoHoras)/60;
//					
//					double restoFrac = restoHoras % tarifaUsada.getTiempoFraccion();
//					double fracs = (restoHoras - restoFrac) / tarifaUsada.getTiempoFraccion();
//					
//					String tiempoCobrar = 0 + "Es " + (int)mediaEst + "Me " + (int)horas + "Hr " + (int)fracs + "Fr";
//
//					return tiempoCobrar;
//					
//				}
//					//Si me quede mas del minimo pero menos de media estadia
//					else {
//						
//						double restoHoras = diffMinutes % 60;
//						double horas = (diffMinutes - restoHoras)/60;
//						
//						double restoFrac = restoHoras % tarifaUsada.getTiempoFraccion();
//						double fracs = (restoHoras - restoFrac) / tarifaUsada.getTiempoFraccion();
//						if(restoFrac >= 1){
//							fracs = fracs + 1;
//						}
//						String tiempoCobrar = 0 + "Es " + 0 + "Me " + (int)horas + "Hr " + (int)fracs + "Fr";
//
//						return tiempoCobrar;
//					}
		
			String tiempoCobrar;
			
			double restoHoras = diffMinutes % 60;
			double horas = (diffMinutes - restoHoras)/60;
			
			
			tiempoCobrar = (int)horas + "Hrs " + (int)restoHoras +("Mins");
			return tiempoCobrar;
		
	}

	public String toString(){
		return this.patente;
	}
	public void incrementarPrepago(double monto) {
		this.prepago = this.prepago + monto;
		
	}
	public boolean isPagotarjeta() {
		return pagotarjeta;
	}
	public void setPagotarjeta(boolean pagotarjeta) {
		this.pagotarjeta = pagotarjeta;
	}
	
	

}
