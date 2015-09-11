package persistencia.clases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "LiquidacionAlquileres")
public class LiquidacionAlquileres {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idLiquidacionAlquileres;
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaEmision;
	private Estado estado;
	
	public enum Estado {
		ANULADO,
		LIQUIDADO;
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
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	
}
