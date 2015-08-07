package modelo;

public class Vehiculo 
{
	//para mi no justifica herencia
	private long idVehiculo;
	private String patente;
	private CategoriaVehiculo categoria;
	private ModeloVehiculo modelo;
	private ColorVehiculo color;
	private String comentario;
	
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public long getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public CategoriaVehiculo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaVehiculo categoria) {
		this.categoria = categoria;
	}
	public ModeloVehiculo getModelo() {
		return modelo;
	}
	public void setModelo(ModeloVehiculo modelo) {
		this.modelo = modelo;
	}
	public ColorVehiculo getColor() {
		return color;
	}
	public void setColor(ColorVehiculo color) {
		this.color = color;
	}
	
	//aplica solo a clientes del tipo mensual
	
	
	
	
}
