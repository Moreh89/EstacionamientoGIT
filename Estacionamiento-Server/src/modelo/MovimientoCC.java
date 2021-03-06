package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	private Interes interes;
	private Usuario usuario;
	private LiquidacionAlquileres liquidacionAlquileres;
	private MEDIOPAGO medioPago;
	
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

	public Interes getInteres() {
		return interes;
	}

	public void setInteres(Interes interes) {
		this.interes = interes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public LiquidacionAlquileres getLiquidacionAlquileres() {
		return liquidacionAlquileres;
	}

	public void setLiquidacionAlquileres(LiquidacionAlquileres liquidacionAlquileres) {
		this.liquidacionAlquileres = liquidacionAlquileres;
	}

	public enum MEDIOPAGO{
		NOAPLICA,
		EFECTIVO,
		TARJETA;
	}
	
	public MEDIOPAGO getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(MEDIOPAGO medioPago) {
		this.medioPago = medioPago;
	}

	public String toString()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm"); 
		return dateFormat.format(this.fecha) + "  //  " + Math.round(this.montoCobrado) + "  //  " + this.descripcion;
	}
	
	
}
