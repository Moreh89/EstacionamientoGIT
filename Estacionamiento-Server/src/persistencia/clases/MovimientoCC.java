package persistencia.clases;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MovimientoCC")
public class MovimientoCC {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idMovimiento;
	private Date fecha;
	private String descripcion;
	private double montoCobrado;
	private String estado;
	@OneToOne
	@JoinColumn(name="Ticket")
	private Ticket ticket;
	
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
	public MovimientoCC(long idMovimiento, Date fecha, String descripcion,
			double montoCobrado, String estado, Ticket ticket) {
		super();
		this.idMovimiento = idMovimiento;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.montoCobrado = montoCobrado;
		this.estado = estado;
		this.ticket = ticket;
	}
	public MovimientoCC() {
		// TODO Auto-generated constructor stub
	}
	
	
}
