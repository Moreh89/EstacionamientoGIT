package modelo;

import java.util.Date;


public class IncrementoPrepago {
	
	private long idIncremento;
	private Date fecha;
	private long numeroTicket;
	private double prepago;
	private long numeroUsuario;

	public long getIdIncremento() {
		return idIncremento;
	}

	public void setIdIncremento(long idIncremento) {
		this.idIncremento = idIncremento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(long numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public double getPrepago() {
		return prepago;
	}

	public void setPrepago(double prepago) {
		this.prepago = prepago;
	}

	public long getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}


	
	public IncrementoPrepago(Date fecha, long numeroTicket, double prepago,
			long numeroUsuario) {
		super();
		this.idIncremento = 0;
		this.fecha = fecha;
		this.numeroTicket = numeroTicket;
		this.prepago = prepago;
		this.numeroUsuario = numeroUsuario;
	}

	public IncrementoPrepago(long idIncremento, Date fecha, long numeroTicket,
			double prepago, long numeroUsuario) {
		super();
		this.idIncremento = idIncremento;
		this.fecha = fecha;
		this.numeroTicket = numeroTicket;
		this.prepago = prepago;
		this.numeroUsuario = numeroUsuario;
	}

	public IncrementoPrepago() {
	}
	
	

}
