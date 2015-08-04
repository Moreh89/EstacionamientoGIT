package controlador;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JPasswordField;

import com.mysql.jdbc.Statement;

import persistencia.Converter;
import persistencia.HibernateDAO;
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
	private ArrayList<CategoriaVehiculo> categoriasVehiculos;

	public ArrayList<Vehiculo> vehiculosActuales;
	public ArrayList<PersonaAutorizada> personasAutorizadasActuales;

	private double tasaInteres;

	private static Controlador instancia;

	public static void main(String[] args) {

	}

	public static Controlador getInstancia() {
		if (instancia == null) 
		{
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


	public void cargaInicial()
	{
		//TODO checkear si va la carga de categorias, creo que no.
//		categoriasVehiculos=DAOCategoriaVehiculo.getInstance().getCategoriasVehiculos();
		coloresVehiculos=DAOColorVehiculo.getInstance().getColoresVehiculos();
		modelosVehiculos=DAOModeloVehiculo.getInstance().getModelosVehiculos();
	}


	public void altaCliente(String nombre, String apellido, String telefono1,
			String telefono2, String direccion1, String direccion2,
			String email, String razonSocial, ArrayList<String> listPersonasAutorizadas,
			ArrayList<String> listVehiculos) {
		Cliente cliente=new Cliente();
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setTelefono1(telefono1);
		cliente.setTelefono2(telefono2);
		cliente.setDireccion(direccion1);
		cliente.setDireccion2(direccion2);
		cliente.setCorreoElectronico(email);
		cliente.setRazonSocial(razonSocial);

	

		// TODO vehiculos patentes y personas autorizadas

	}

	public void agregarVehiculo(int idCategoriaVehiculo, String patente,
			String color, String modelo, String observacion) {

		if (clienteActual == null) {
			if (vehiculosActuales == null) 
			{
				vehiculosActuales = new ArrayList<Vehiculo>();
			}

			Vehiculo vehiculo = new Vehiculo();

			modelo.CategoriaVehiculo categoriaVehiculo = new modelo.CategoriaVehiculo();
			categoriaVehiculo.setIdCategoria(idCategoriaVehiculo);
			vehiculo.setCategoria(categoriaVehiculo);

			vehiculo.setPatente(patente);

			modelo.ColorVehiculo colorVehiculo = DAOColorVehiculo.getInstance().getColorVehiculo(color);
			vehiculo.setColor(colorVehiculo);
			
			
			ModeloVehiculo modeloVehiculo = DAOModeloVehiculo.getInstance().getModeloVehiculo(modelo);
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


	public boolean backUp(String letraDisco){
		//TODO ver como se puede generar el path si no existe.
		String path= "'" + letraDisco + ":/BackUp_Estacionamiento/";

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Date date = new Date(); 
		dateFormat.format(date); 

		String fileNameBackup = "backUp_"+dateFormat.format(date)+".BAK'"; 

		HibernateDAO.getInstancia().backUp("ESTACIONAMIENTO", path, fileNameBackup);

		return true;
	}

	public boolean cambiarContrasenia(String password) {
		usuarioActual.setPassword(password);
		return DAOUsuario.getInstance().cambiarContrasenia(usuarioActual);
	}

	public boolean probarConexion() {
		//TODO
		return true;
	}

	public void altaTarifa(String categoriaVehiculo,double costoMinimo, double costoFraccion, double costoHora, double costoMediaEstadia, double costoEstadia,double tiempoMinimo,double tiempoFraccion, double tiempoMediaEstadia_minuto, double tiempoEstadia_minuto) 
	{
		modelo.CategoriaVehiculo categoriaVehiculoM = new CategoriaVehiculo();
		categoriaVehiculoM=DAOCategoriaVehiculo.getInstance().buscarCategoriaVehiculo(categoriaVehiculo);
		
		modelo.Tarifa tarifaM = new modelo.Tarifa(categoriaVehiculoM, costoMinimo, costoFraccion, costoHora, costoMediaEstadia, costoEstadia,
		tiempoMinimo,tiempoFraccion, tiempoMediaEstadia_minuto, tiempoEstadia_minuto);
		
		DAOTarifa.getInstance().persistir(tarifaM);
	}

	public Vector getColoresActuales() {
		Vector coloresActuales=new Vector();
		for(ColorVehiculo color:coloresVehiculos)
		{
			coloresActuales.add(color.getDescripcion());
		}
		return coloresActuales;
	}
	
	public Vector getModelosActuales() {
		Vector modelosActuales=new Vector();
		for(ModeloVehiculo modelo:modelosVehiculos)
		{
			modelosActuales.add(modelo.getDescripcion());
		}
		return modelosActuales;
	}

//	public ArrayList<CategoriaVehiculo> getCategoriasVehiculos() {
//		
//		return DAOCategoriaVehiculo.getInstance().getCategoriasVehiculos();
//	}

}