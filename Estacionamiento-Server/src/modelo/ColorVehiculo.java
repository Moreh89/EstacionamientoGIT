package modelo;

import java.util.Comparator;

public class ColorVehiculo {
	
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
	
	public String toString(){
		return this.descripcion;
	}
	
	  public static class CompDescripcion implements Comparator<ColorVehiculo>
	 {
		public int compare(ColorVehiculo o1, ColorVehiculo o2) {
			return o1.getDescripcion().compareToIgnoreCase(o2.getDescripcion());
		}
	}
}
