package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cochera")
public class Cochera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCochera;
	private double costoCochera;
	@OneToOne
	@JoinColumn(name="Cliente")
	private Cliente cliente;
	private ESTADO estado;
	private float porcentajeExpensas;
	private String ubicacion;
	
	public enum ESTADO {
		INACTIVO,
		ACTIVO;
	}

	public long getIdCochera() {
		return idCochera;
	}

	public void setIdCochera(long idCochera) {
		this.idCochera = idCochera;
	}

	public double getCostoCochera() {
		return costoCochera;
	}

	public void setCostoCochera(double costoCochera) {
		this.costoCochera = costoCochera;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ESTADO getEstado() {
		return estado;
	}

	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}
	

	public float getPorcentajeExpensas() {
		return porcentajeExpensas;
	}

	public void setPorcentajeExpensas(float costo) {
		this.porcentajeExpensas = costo;
	}

	public Cochera(long idCochera, double costoCochera, Cliente cliente,
			ESTADO estado, String ubicacion) {
		super();
		this.idCochera = idCochera;
		this.costoCochera = costoCochera;
		this.cliente = cliente;
		this.estado = estado;
		this.ubicacion=ubicacion;
	}

	public Cochera() {
		// TODO Auto-generated constructor stub
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
}
