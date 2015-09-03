package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TasaInteres")
public class TasaInteres {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
