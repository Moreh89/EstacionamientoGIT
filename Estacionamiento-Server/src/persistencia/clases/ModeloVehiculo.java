package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ModeloVehiculo")
public class ModeloVehiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idModelo;
	private String descripcion;
	
	public long getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(long idModelo) {
		this.idModelo = idModelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ModeloVehiculo(long idModelo, String descripcion) {
		super();
		this.idModelo = idModelo;
		this.descripcion = descripcion;
	}
	public ModeloVehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
