package modelo;


public class TasaInteres {

	private long idTasaInteres;
	private double montoDescuento;
	private ESTADO estado;

	public enum ESTADO {
		INACTIVO,
		ACTIVO,
	}
	public long getIdTasaInteres() {
		return idTasaInteres;
	}
	public void setIdTasaInteres(long idTasaInteres) {
		this.idTasaInteres = idTasaInteres;
	}
	public double getMontoDescuento() {
		return montoDescuento;
	}
	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}
	public ESTADO getEstado() {
		return estado;
	}
	public void setEstado(ESTADO estado) {
		this.estado = estado;
	} 

	public TasaInteres(long idTI, double montoDescuento, ESTADO estado)
	{
		this.idTasaInteres=idTI;
		this.montoDescuento=montoDescuento;
		this.estado=estado;
	}
	
	public TasaInteres()
	{
		
	}
	
	

	
	
	
}
