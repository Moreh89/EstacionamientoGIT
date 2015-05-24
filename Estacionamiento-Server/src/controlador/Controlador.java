package controlador;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Statement;

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
		// TODO HARDCODEADO
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


	public boolean backUp(String letraDisco){

//		TODO settear la letra de disco. Asegurarse que ande en el C primero, despues vemos como definir la letra.
		String path= "'" + letraDisco + ":/Temp/";

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Date date = new Date(); 
		dateFormat.format(date); 

		String fileNameBackup = "backUp_"+dateFormat.format(date)+".BAK'"; 
		
		HibernateDAO.getInstancia().backUp("ESTACIONAMIENTO", path, fileNameBackup);

		return true;
		
		//		String path = "C:/";
		//		
		//		if (con!=null){
		//			String dataBaseName =  PoolConnection.getPoolConnection().getDataBaseName();
		//			String comand ="BACKUP DATABASE " +  dataBaseName + " TO DISK = "; 
		//			
		//			
		//			 File miDir = new File (".");
		//			 try {
		//				  path = miDir.getCanonicalPath()+"/";
		//			} catch (IOException e1) {
		//				e1.printStackTrace();
		//			}
		//			
		//			
		//			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		//			Date date = new Date(); 
		//			dateFormat.format(date); 
		//			
		//			String nameBackup = dataBaseName+ "_"+dateFormat.format(date)+".BAK"; 
		//					
		//			String dbackup =comand + "'"+ path +nameBackup+"'";
		//		
		//			Statement callBackupDbase = null;
		//			
		//			try {
		//				con.setAutoCommit(true);
		//				callBackupDbase = con.createStatement();
		//			} catch (SQLException e) {
		//				e.printStackTrace();
		//			}
		//			
		//			if(callBackupDbase != null){
		//				try {
		//					callBackupDbase.execute(dbackup);
		//					return true;
		//				}catch (SQLException e) {
		//					e.printStackTrace();
		//					return false;
		//				}
		//			}else return false;
		//			
		//			
		//		}else
		//			return false;	
		//	}

	}

}