package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "CategoriaVehiculo")
public class CategoriaVehiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCategoria;
	private String descripcion;
	
	
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public CategoriaVehiculo(long idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}
	public CategoriaVehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
