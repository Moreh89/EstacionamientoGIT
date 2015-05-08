package modelo;


public class Cochera {
	private long idCochera;
	private double costoCochera;
	private Cliente cliente;
	private ESTADO estado;
	private float costo;
	
	public enum ESTADO {
		ACTIVO,
		INACTIVO;
	}
	
}
