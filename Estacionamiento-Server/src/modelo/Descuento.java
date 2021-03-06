package modelo;

import java.util.Comparator;

public class Descuento {

	private long idDescuento;
	private String descripcion;
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
	
	public enum ESTADO {
		ACTIVO,
		INACTIVO;
	}

	public ESTADO getEstado() {
		return estado;
	}
	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}

	public String toString()
	{
		return this.getDescripcion();
	}

	

	  public static class CompDescripcion implements Comparator<Descuento>
	 {
		public int compare(Descuento o1, Descuento o2) {
			return o1.getDescripcion().compareToIgnoreCase(o2.getDescripcion());
		}
	}
	
}

