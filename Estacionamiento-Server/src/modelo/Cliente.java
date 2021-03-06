package modelo;

import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class Cliente {

	//justifica herencia?

	private long idCliente;
	private TIPO_CLIENTE tipoCliente;
	private String nombre;
	private String apellido;
	private TIPO_DOC tipoDocumento;
	private String numeroDocumento;
	private String telefono1;
	private String telefono2;
	private String direccion;
	private String direccion2;
	private String descripcion;
	private String correoElectronico;
	private ESTADO estado;
	private String cuil;	
	private double estadoCrediticio;
	private TIPO_FACTURA tipoFactura;
	private Date fechaAlta;

	private List <PersonaAutorizada> personasAutorizadasARetirar;

	String razonSocial;
	private List <Cochera> cocheras; 
	private CuentaCorriente cuentaCorriente;
	private List<Vehiculo> vehiculos;


	public enum TIPO_CLIENTE {
		PARTICULAR_PROPIETARIO,
		EMPRESA_PROPIETARIO,
		PARTICULAR_INQUILINO,
		EMPRESA_INQUILINO,
		PARTICULAR_FRECUENTE,
		EMPRESA_FRECUENTE;
	}

	public enum TIPO_DOC {
		DNI,
		LU,
		PASS,
		OTRO;
	}

	public enum TIPO_FACTURA {
		A,
		B,
		C,
		NA;
	}	

	public enum ESTADO {
		ACTIVO,
		INACTIVO,
		BORRADO;
	}


	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
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
	public List<PersonaAutorizada> getPersonasAutorizadasARetirar() {
		return personasAutorizadasARetirar;
	}
	public void setPersonasAutorizadasARetirar(
			List<PersonaAutorizada> personasAutorizadasARetirar) {
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
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public List<Cochera> getCocheras() {
		return cocheras;
	}
	public void setCocheras(List<Cochera> cocheras) {
		this.cocheras = cocheras;
	}
	public Cliente(long idCliente, TIPO_CLIENTE tipoCliente, String nombre,
			String apellido, TIPO_DOC tipoDocumento, String numeroDocumento,
			String telefono1, String telefono2, String direccion,
			String direccion2, String descripcion, String correoElectronico,
			ESTADO estado, List<PersonaAutorizada> personasAutorizadasARetirar,
			String razonSocial, List<Cochera> cocheras,
			CuentaCorriente cuentaCorriente, List<Vehiculo> vehiculos) {
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


	public Cliente() {}

	public String toString(){

		return this.apellido+ ", " + this.nombre; 
	}
	public double getEstadoCrediticio(modelo.Cliente clienteM) {

		//NO ANDA
		//		return DAOCliente.getInstance().getEstadoCrediticio(clienteM);
		double estadoCrediticio=0;
		if(clienteM.getCuentaCorriente().getMovimientos()!=null)
		{
			for(MovimientoCC movimientoM : clienteM.getCuentaCorriente().getMovimientos())
			{
				estadoCrediticio=estadoCrediticio+movimientoM.getMontoCobrado();
			}
		}
		return  Math.round(estadoCrediticio);
	}
	
	public double getEstadoCrediticio() {
		return estadoCrediticio;
	}
	public void setEstadoCrediticio(double estadoCrediticio) {
		this.estadoCrediticio = estadoCrediticio;
	}
	public TIPO_FACTURA getTipoFactura() {
		return tipoFactura;
	}
	public void setTipoFactura(TIPO_FACTURA tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public static class CompApellido implements Comparator<Cliente>
	{
		public int compare(Cliente o1, Cliente o2) {
			return o1.getApellido().compareToIgnoreCase(o2.getApellido());
		}
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}