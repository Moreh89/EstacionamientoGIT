package modelo;


public class Cochera {
	private long idCochera;

//
	private double costoCochera;
	private Cliente cliente;
	private ESTADO estado;
//Representa el porcentaje de expensas
	private float costo;
	
	public enum ESTADO {
		ACTIVO,
		INACTIVO;
	}

	public long getIdCochera() {
		return idCochera;
	}

	public void setIdCochera(long idCochera) {
		this.idCochera = idCochera;
	}

	public double getCostoCochera() {
		return costoCochera;
	}

	public void setCostoCochera(double costoCochera) {
		this.costoCochera = costoCochera;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ESTADO getEstado() {
		return estado;
	}

	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	
	
}
