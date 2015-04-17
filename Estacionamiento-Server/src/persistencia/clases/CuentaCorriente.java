package persistencia.clases;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CuentaCorriente")
public class CuentaCorriente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idCuentaCorriente;
	@OneToMany
	@JoinColumn(name="CuentaCorriente")
	private List<MovimientoCC> movimientos;
	
	
	public long getIdCuentaCorriente() {
		return idCuentaCorriente;
	}
	public void setIdCuentaCorriente(long idCuentaCorriente) {
		this.idCuentaCorriente = idCuentaCorriente;
	}
	public List<MovimientoCC> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<MovimientoCC> movimientos) {
		this.movimientos = movimientos;
	}
	public CuentaCorriente(long idCuentaCorriente,
			List<MovimientoCC> movimientos) {
		super();
		this.idCuentaCorriente = idCuentaCorriente;
		this.movimientos = movimientos;
	}
	
	
}
