package modelo;


public class Cochera {
	long idCochera;
	double costoCochera;
	Cliente cliente;
	ESTADO estado;
	
	private enum ESTADO {
		ACTIVO,
		INACTIVO;
	}
	
}
