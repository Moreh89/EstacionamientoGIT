package controlador;


import java.util.ArrayList;

import persistencia.dao.*;
import modelo.*;

public class Controlador {

	private ArrayList<Tarifa> tarifas;
	private Cliente clienteActual = null;
	private Ticket ticket;
	private Usuario usuarioActual;
	private ArrayList<ColorVehiculo> coloresVehiculos;
	private ArrayList<ModeloVehiculo> modelosVehiculos;
	private ArrayList<Descuento> descuentos;
	private ArrayList<Descuento> cocheras;

	public ArrayList<Vehiculo> vehiculosActuales;
	public ArrayList<PersonaAutorizada> personasAutorizadasActuales;

	private double tasaInteres;

	private static Controlador instancia;

	public static void main(String[] args) {

	}

	public static Controlador getInstancia() {
		if (instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}

	public boolean validarContrasenaActual(String userName, String psw) {

		Usuario u = buscarUsuario(userName);

		if (u != null) {
			if (psw.equals(u.getPassword())) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean validarLogin(String userName, String password) {
		// HARDCODEADO PARA INGRESAR CON CUALQUIER USUARIO Y CLAVE

		//		 String pswEnc = Encriptacion.Encriptar(password);

		Usuario u = this.buscarUsuario(userName);

		if (u!=null){

			if(password.equals(u.getPassword())){
				//		 usuarioActual = u.getView();
				usuarioActual= u;
				return true;
			}
			else
				return false;
		}
		return false;
	}

	public Usuario buscarUsuario(String userName) 
	{
		return DAOUsuario.getInstance().buscarUsuario(userName);
	}


	public Usuario getUsuarioActual() {
		return usuarioActual;
	}

	public boolean probarConexion() {
		// HARDCODEADO
		return true;
		// Connection con = PoolConnection.getPoolConnection().getConnection();
		// if (con == null){
		// return false;
		// }else
		// return true;
	}

	public boolean validarPermiso(String string) {
		// TODO Auto-generated method stub
		return true;
	}

	public void altaCliente(String nombre, String apellido, String telefono1,
			String telefono2, String direccion1, String direccion2,
			String email, String razonSocial, String vehiculosPantentes,
			String personasAutorizadas) {
		// TODO Auto-generated method stub

	}

	public void agregarVehiculo(int idCategoriaVehiculo, String patente,
			int idColor, int idModeloVehiculo, String observacion) {

		if (clienteActual == null) {
			if (vehiculosActuales == null) {
				vehiculosActuales = new ArrayList<Vehiculo>();
			}

			Vehiculo vehiculo = new Vehiculo();

			CategoriaVehiculo categoriaVehiculo = new CategoriaVehiculo();
			categoriaVehiculo.setIdCategoria(idCategoriaVehiculo);
			vehiculo.setCategoria(categoriaVehiculo);

			vehiculo.setPatente(patente);

			ColorVehiculo colorVehiculo = new ColorVehiculo();
			colorVehiculo.setIdColor(idColor);
			vehiculo.setColor(colorVehiculo);

			ModeloVehiculo modeloVehiculo = new ModeloVehiculo();
			modeloVehiculo.setIdModelo(idModeloVehiculo);
			vehiculo.setModelo(modeloVehiculo);

			vehiculosActuales.add(vehiculo);
			// PENDIENTE AGREGAR OBSERVACION

		}
	}

	public void agregarPersonaAutorizada(String nombre, String apellido) {
		if (clienteActual == null) {
			if (personasAutorizadasActuales == null) {
				personasAutorizadasActuales = new ArrayList<PersonaAutorizada>();
			}
			PersonaAutorizada personaAutorizada = new PersonaAutorizada();
			personaAutorizada.setNombre(nombre + " " + apellido);
			personasAutorizadasActuales.add(personaAutorizada);
		}

	}


	public String generarTicket(String tipoVehiculo, String modelo,
			String color, String descuento, String patente,
			String cliente, String prepago, String obsevacion, String usuario) {

		CategoriaVehiculo catve= new CategoriaVehiculo();
		ModeloVehiculo modve = new ModeloVehiculo();
		Cliente cl = new Cliente();
		Descuento des = new Descuento();

		//TODO buscar categoriaVe, modeloVe, cliente, descuento

		Ticket tck = new Ticket( catve, modve, cl, des, usuarioActual, Double.valueOf(prepago), obsevacion);
		this.ticket = tck;

		long numeroTck = DAOTicket.getInstance().persistir(tck);

		return String.valueOf(numeroTck);

	}

}
