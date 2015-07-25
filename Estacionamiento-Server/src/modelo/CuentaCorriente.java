package modelo;

import java.util.List;

public class CuentaCorriente {

	private long idCuentaCorriente;
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
	
	
}
