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
@Table(name = "Ticket")
public class Ticket {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idTicket;
	private double montoCobrado;
	private String estado;
	//Time puede cambiarse si no es compatible con hibernate
	private Date fechaLlegada;
	private Date fechaSalida;

	@OneToOne
	@JoinColumn(name="Vehiculo")
	private Vehiculo vehiculo;
	@OneToOne
	@JoinColumn(name="Cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="Descuento")
	private Descuento descuento;
	@OneToOne
	@JoinColumn(name="Usuario")
	private Usuario usuario; //usuario del sistema (util para arqueo caja)
	
	private String tipoIngreso; //si hay que cobrar por hora o por estadia.
	
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
	public Ticket(long idTicket, double montoCobrado, String estado,
			Date fechaLlegada, Date fechaSalida, Vehiculo vehiculo,
			Cliente cliente, Descuento descuento, Usuario usuario,
			String tipoIngreso) {
		super();
		this.idTicket = idTicket;
		this.montoCobrado = montoCobrado;
		this.estado = estado;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.descuento = descuento;
		this.usuario = usuario;
		this.tipoIngreso = tipoIngreso;
	}




}
