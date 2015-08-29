package modelo;

import java.util.Date;

public class MovimientoCC 
{
	private long idMovimiento;
	private Date fecha;
	private String descripcion;
	private double montoCobrado;
	private String estado;
	private Ticket ticket;
	private LiquidacionExpensas liquidacionExpensas;
	public long getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getMontoCobrado() {
		return montoCobrado;
	}
	public void setMontoCobrado(double montoCobrado) {
		this.montoCobrado = montoCobrado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public LiquidacionExpensas getLiquidacionExpensas() {
		return liquidacionExpensas;
	}

	public void setLiquidacionExpensas(LiquidacionExpensas liquidacionExpensas) {
		this.liquidacionExpensas = liquidacionExpensas;
	}
	
	
}
