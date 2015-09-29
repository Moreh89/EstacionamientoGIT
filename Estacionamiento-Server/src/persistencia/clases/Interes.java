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
@Table(name = "Interes")
public class Interes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idInteres;
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fechaAplicado;
	
	public Interes() {
	
	}


	public long getIdInteres() {
		return idInteres;
	}


	public void setIdInteres(long idInteres) {
		this.idInteres = idInteres;
	}


	public Date getFechaAplicado() {
		return fechaAplicado;
	}


	public void setFechaAplicado(Date fechaAplicado) {
		this.fechaAplicado = fechaAplicado;
	}
	
	
	
}
