package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
public class Interes {
	
	private long idInteres;
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
