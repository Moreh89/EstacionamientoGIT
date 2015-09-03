package persistencia.clases;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistencia.clases.ColorVehiculo;
import persistencia.clases.CategoriaVehiculo;
import persistencia.clases.ModeloVehiculo;

@Entity
@Table(name = "Ticket")
public class Ticket {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idTicket;
	private double montoCobrado;
	private Estado estado;
	//Time puede cambiarse si no es compatible con hibernate
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaLlegada;
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaSalida;

	@OneToOne
	@JoinColumn(name="CatergoriaVehiculo")
	private CategoriaVehiculo catergoriaVehiculo;
	@OneToOne
	@JoinColumn(name="ModeloVehiculo")
	private ModeloVehiculo modeloVehiculo;
	@OneToOne
	@JoinColumn(name="Cliente")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="Descuento")
	private Descuento descuento;
	@OneToOne
	@JoinColumn(name="Usuario")
	private Usuario usuario; //usuario del sistema (util para arqueo caja)
	
	
	private double prepago; //Si ya pago algo
	private String observacion;
	@OneToOne
	@JoinColumn(name="Color")
	private ColorVehiculo color;
	private String patente;
	
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
	public void setColor(ColorVehiculo colorVehiculo) {
		this.color = colorVehiculo;
	}
	public ColorVehiculo getColor() {
		return color;
	}
	public Ticket() {}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getPatente() {
		return patente;
	}
	





}
