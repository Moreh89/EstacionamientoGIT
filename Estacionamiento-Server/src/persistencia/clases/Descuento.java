package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Descuento")
public class Descuento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idDescuento;
	String descripcion;
	private double descuento;
	private ESTADO estado;
	
	public long getIdDescuento() {
		return idDescuento;
	}
	public void setIdDescuento(long idDescuento) {
		this.idDescuento = idDescuento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public Descuento(long idDescuento, String descripcion, double descuento) {
		super();
		this.idDescuento = idDescuento;
		this.descripcion = descripcion;
		this.descuento = descuento;
	}
	public Descuento() {
		
	}
	
	public enum ESTADO {
		INACTIVO,
		ACTIVO;
	}

	public ESTADO getEstado() {
		return estado;
	}
	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}
	
	
}
