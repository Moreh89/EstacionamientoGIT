package modelo;


public class TasaInteres {

	private long idTasaInteres;
	private double monto;
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
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
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
		this.monto=montoDescuento;
		this.estado=estado;
	}
	
	public TasaInteres()
	{
		
	}
	
	

	
	
	
}
