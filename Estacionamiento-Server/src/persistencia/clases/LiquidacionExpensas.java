package persistencia.clases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistencia.clases.Ticket.Estado;

@Entity
@Table(name = "LiquidacionExpensas")
public class LiquidacionExpensas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idLiquidacionExpensas;
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaEmision;
	private double montoTotalLiquidado;
	private Estado estado;
	
	public enum Estado {
		LIQUIDADO,
		CANCELADO;
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
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
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
	
}
