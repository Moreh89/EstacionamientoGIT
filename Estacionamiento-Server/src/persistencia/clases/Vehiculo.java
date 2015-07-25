package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idVehiculo;
	private String patente;
	@OneToOne
	@JoinColumn(name="Categoria")
	private CategoriaVehiculo categoria;
	@OneToOne
	@JoinColumn(name="Modelo")
	private ModeloVehiculo modelo;
	@OneToOne
	@JoinColumn(name="Color")
	private ColorVehiculo color;
	
	public long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public CategoriaVehiculo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaVehiculo categoria) {
		this.categoria = categoria;
	}
	public ModeloVehiculo getModelo() {
		return modelo;
	}
	public void setModelo(ModeloVehiculo modelo) {
		this.modelo = modelo;
	}
	public ColorVehiculo getColor() {
		return color;
	}
	public void setColor(ColorVehiculo color) {
		this.color = color;
	}
	public Vehiculo(long idVehiculo, String patente,
			CategoriaVehiculo categoria, ModeloVehiculo modelo,
			ColorVehiculo color) {
		super();
		this.idVehiculo = idVehiculo;
		this.patente = patente;
		this.categoria = categoria;
		this.modelo = modelo;
		this.color = color;
	}
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	
	
}
