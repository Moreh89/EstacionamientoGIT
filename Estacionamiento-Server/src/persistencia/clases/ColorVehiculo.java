package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ColorVehiculo")

public class ColorVehiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idColor;
	private String descripcion;
	
	public long getIdColor() {
		return idColor;
	}
	public void setIdColor(long idColor) {
		this.idColor = idColor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ColorVehiculo(long idColor, String descripcion) {
		super();
		this.idColor = idColor;
		this.descripcion = descripcion;
	}
	public ColorVehiculo() {
	
	}
	
	
}
