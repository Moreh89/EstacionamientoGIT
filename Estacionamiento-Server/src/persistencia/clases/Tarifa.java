package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tarifa")
public class Tarifa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idTarifa;
	@OneToOne
	@JoinColumn(name="Categoria")
	private CategoriaVehiculo categoria;

	private double costoMinimo=33;
	private double costoFraccion=2.75;
	private double costoHora=33;
	private double costoMediaEstadia=100;
	private double costoEstadia=133;
	
	private double tiempoMinimo=60;
	private double tiempoFraccion=5;
	private double tiempoMediaEstadia_minuto=720;
	private double tiempoEstadia_minuto=1440;

	
	public long getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(long idTarifa) {
		this.idTarifa = idTarifa;
	}
	public CategoriaVehiculo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaVehiculo categoria) {
		this.categoria = categoria;
	}
	public double getCostoMinimo() {
		return costoMinimo;
	}
	public void setCostoMinimo(double costoMinimo) {
		this.costoMinimo = costoMinimo;
	}
	public double getCostoFraccion() {
		return costoFraccion;
	}
	public void setCostoFraccion(double costoFraccion) {
		this.costoFraccion = costoFraccion;
	}
	public double getCostoHora() {
		return costoHora;
	}
	public void setCostoHora(double costoHora) {
		this.costoHora = costoHora;
	}
	public double getCostoMediaEstadia() {
		return costoMediaEstadia;
	}
	public void setCostoMediaEstadia(double costoMediaEstadia) {
		this.costoMediaEstadia = costoMediaEstadia;
	}
	public double getCostoEstadia() {
		return costoEstadia;
	}
	public void setCostoEstadia(double costoEstadia) {
		this.costoEstadia = costoEstadia;
	}
	public double getTiempoMinimo() {
		return tiempoMinimo;
	}
	public void setTiempoMinimo(double tiempoMinimo) {
		this.tiempoMinimo = tiempoMinimo;
	}
	public double getTiempoFraccion() {
		return tiempoFraccion;
	}
	public void setTiempoFraccion(double tiempoFraccion) {
		this.tiempoFraccion = tiempoFraccion;
	}
	public double getTiempoMediaEstadia_minuto() {
		return tiempoMediaEstadia_minuto;
	}
	public void setTiempoMediaEstadia_minuto(double tiempoMediaEstadia_min) {
		this.tiempoMediaEstadia_minuto = tiempoMediaEstadia_min;
	}
	public double getTiempoEstadia_minuto() {
		return tiempoEstadia_minuto;
	}
	public void setTiempoEstadia_minuto(double tiempoEstadia_min) {
		this.tiempoEstadia_minuto = tiempoEstadia_min;
	}
	public Tarifa(long idTarifa, CategoriaVehiculo categoria,
			double costoMinimo, double costoFraccion, double costoHora,
			double costoMediaEstadia, double costoEstadia, double tiempoMinimo,
			double tiempoFraccion, double tiempoMediaEstadia_minuto,
			double tiempoEstadia_minuto) {
		super();
		this.idTarifa = idTarifa;
		this.categoria = categoria;
		this.costoMinimo = costoMinimo;
		this.costoFraccion = costoFraccion;
		this.costoHora = costoHora;
		this.costoMediaEstadia = costoMediaEstadia;
		this.costoEstadia = costoEstadia;
		this.tiempoMinimo = tiempoMinimo;
		this.tiempoFraccion = tiempoFraccion;
		this.tiempoMediaEstadia_minuto = tiempoMediaEstadia_minuto;
		this.tiempoEstadia_minuto = tiempoEstadia_minuto;
	}
	public Tarifa() {
		
	}


	
	
}
