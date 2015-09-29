package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LiquidacionExpensas {
	
	private long idLiquidacionExpensas;
	private Date fechaEmision;
	private double montoTotalLiquidado;
	private Estado estado;
	
	public enum Estado {
		LIQUIDADO,
		ANULADO;
	}
	
	
	public long getIdLiquidacionExpensas() {
		return idLiquidacionExpensas;
	}
	public void setIdLiquidacionExpensas(long idLiquidacionExpensas) {
		this.idLiquidacionExpensas = idLiquidacionExpensas;
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
	public double getMontoTotalLiquidado() {
		return montoTotalLiquidado;
	}
	public void setMontoTotalLiquidado(double montoTotalLiquidado) {
		this.montoTotalLiquidado = montoTotalLiquidado;
	}

	public String toString()
	{
		return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(this.fechaEmision).toString();
	}

	
	
}
