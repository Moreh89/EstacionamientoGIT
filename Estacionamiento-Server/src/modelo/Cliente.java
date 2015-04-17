package modelo;

import java.util.ArrayList;


public class Cliente {
	
	//justifica herencia?

	long idCliente;
	TIPO_CLIENTE tipoCliente;
	String nombre;
	String apellido;
	TIPO_DOC tipoDocumento;
	String numeroDocumento;
	String telefono1;
	String telefono2;
	String direccion;
	String direccion2;
	//campo para comentarios
	String descripcion;
	String correoElectronico;
	ESTADO estado;
	ArrayList <String> personasAutorizadasARetirar;
	String razonSocial;
	ArrayList <Cochera> cocheras; 
	
	private enum TIPO_CLIENTE {
		FIJO_PERSONA,
		FIJO_EMPRESA,
		TEMPORAL;
	}
	
	private enum TIPO_DOC {
		DNI,
		LU,
		PASS,
		OTRO;
	}
	
	private enum ESTADO {
		ACTIVO,
		INACTIVO;
	}
	
	CuentaCorriente cuentaCorriente;
	ArrayList<Vehiculo> vehiculos;
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public TIPO_CLIENTE getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TIPO_CLIENTE tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public TIPO_DOC getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TIPO_DOC tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDireccion2() {
		return direccion2;
	}
	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public ESTADO getEstado() {
		return estado;
	}
	public void setEstado(ESTADO estado) {
		this.estado = estado;
	}
	public ArrayList<String> getPersonasAutorizadasARetirar() {
		return personasAutorizadasARetirar;
	}
	public void setPersonasAutorizadasARetirar(
			ArrayList<String> personasAutorizadasARetirar) {
		this.personasAutorizadasARetirar = personasAutorizadasARetirar;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}
	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}
	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public ArrayList<Cochera> getCocheras() {
		return cocheras;
	}
	public void setCocheras(ArrayList<Cochera> cocheras) {
		this.cocheras = cocheras;
	}
	public Cliente(long idCliente, TIPO_CLIENTE tipoCliente, String nombre,
			String apellido, TIPO_DOC tipoDocumento, String numeroDocumento,
			String telefono1, String telefono2, String direccion,
			String direccion2, String descripcion, String correoElectronico,
			ESTADO estado, ArrayList<String> personasAutorizadasARetirar,
			String razonSocial, ArrayList<Cochera> cocheras,
			CuentaCorriente cuentaCorriente, ArrayList<Vehiculo> vehiculos) {
		super();
		this.idCliente = idCliente;
		this.tipoCliente = tipoCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.direccion = direccion;
		this.direccion2 = direccion2;
		this.descripcion = descripcion;
		this.correoElectronico = correoElectronico;
		this.estado = estado;
		this.personasAutorizadasARetirar = personasAutorizadasARetirar;
		this.razonSocial = razonSocial;
		this.cocheras = cocheras;
		this.cuentaCorriente = cuentaCorriente;
		this.vehiculos = vehiculos;
	}
	
	
	
	
}