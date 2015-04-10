package modelo;

public class Tarifa {

	long idTarifa;
	CategoriaVehiculo categoria;

	double costoMinimo=33;
	double costoFraccion=2.75;
	double costoHora=33;
	double costoMediaEstadia=100;
	double costoEstadia=133;
	
	double tiempoMinimo=60;
	double tiempoFraccion=5;
	double tiempoMediaEstadia_minuto=720;
	double tiempoEstadia_minuto=1440;
	
	
	
	
	
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


	
	
}
