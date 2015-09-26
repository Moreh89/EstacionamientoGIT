package modelo;

import java.util.Comparator;

public class ModeloVehiculo {

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

	public String toString(){

		return this.getDescripcion();
	}
	  public static class CompDescripcion implements Comparator<ModeloVehiculo>
	 {
		public int compare(ModeloVehiculo o1, ModeloVehiculo o2) {
			return o1.getDescripcion().compareToIgnoreCase(o2.getDescripcion());
		}
	}
}
