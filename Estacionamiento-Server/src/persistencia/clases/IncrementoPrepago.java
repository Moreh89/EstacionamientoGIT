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
@Table(name = "IncrementosPrepago")
public class IncrementoPrepago {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idIncremento;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date fecha;
	
	private long numeroTicket;
	
	private double prepago;
	
	private long numeroUsuario;

	public long getIdIncremento() {
		return idIncremento;
	}

	public void setIdIncremento(long idIncremento) {
		this.idIncremento = idIncremento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getNumeroTicket() {
		return numeroTicket;
	}

	public void setNumeroTicket(long numeroTicket) {
		this.numeroTicket = numeroTicket;
	}

	public double getPrepago() {
		return prepago;
	}

	public void setPrepago(double prepago) {
		this.prepago = prepago;
	}

	public long getNumeroUsuario() {
		return numeroUsuario;
	}

	public void setNumeroUsuario(long numeroUsuario) {
		this.numeroUsuario = numeroUsuario;
	}


	
	public IncrementoPrepago(Date fecha, long numeroTicket, double prepago,
			long numeroUsuario) {
		super();
		this.idIncremento = 0;
		this.fecha = fecha;
		this.numeroTicket = numeroTicket;
		this.prepago = prepago;
		this.numeroUsuario = numeroUsuario;
	}

	public IncrementoPrepago(long idIncremento, Date fecha, long numeroTicket,
			double prepago, long numeroUsuario) {
		super();
		this.idIncremento = idIncremento;
		this.fecha = fecha;
		this.numeroTicket = numeroTicket;
		this.prepago = prepago;
		this.numeroUsuario = numeroUsuario;
	}

	public IncrementoPrepago() {
	}
	

}
