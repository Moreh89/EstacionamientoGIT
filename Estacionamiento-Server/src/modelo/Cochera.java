package modelo;


public class Cochera {
	private long idCochera;

//
	private double costoCochera;
	private Cliente cliente;
	private ESTADO estado;
//Representa el porcentaje de expensas
	private float porcentajeExpensas;
	private String ubicacion;
	
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

	public float getPorcentajeExpensas() {
		return porcentajeExpensas;
	}

	public void setPorcentajeExpensas(float costo) {
		this.porcentajeExpensas = costo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
}
