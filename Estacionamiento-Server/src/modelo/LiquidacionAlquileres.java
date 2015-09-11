package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LiquidacionAlquileres{
	
	private long idLiquidacionAlquileres;
	private Date fechaEmision;
	private Estado estado;
	
	public enum Estado {
		LIQUIDADO,
		ANULADO;
	}
	


	public long getIdLiquidacionAlquileres() {
		return idLiquidacionAlquileres;
	}
	public void setIdLiquidacionAlquileres(long idLiquidacionAlquileres) {
		this.idLiquidacionAlquileres = idLiquidacionAlquileres;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaSalida) {
		this.fechaEmision = fechaSalida;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public String toString()
	{
		; 

		return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(this.fechaEmision).toString();
	}

	
	
}
