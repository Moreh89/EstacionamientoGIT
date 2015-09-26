package modelo;

import java.util.Comparator;

public class CategoriaVehiculo {
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
	
	  public static class CompDescripcion implements Comparator<CategoriaVehiculo>
	 {
		public int compare(CategoriaVehiculo o1, CategoriaVehiculo o2) {
			return o1.getDescripcion().compareToIgnoreCase(o2.getDescripcion());
		}
	}
	
}
