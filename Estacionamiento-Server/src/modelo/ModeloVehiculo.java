package modelo;

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

}
