package controlador;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.Cliente;
import modelo.ColorVehiculo;
import modelo.Descuento;
import modelo.ModeloVehiculo;
import modelo.Tarifa;
import modelo.Ticket;
import modelo.Usuario;

public class Controlador {

	private ArrayList<Tarifa> tarifas;
	private Cliente cliente;
	private Ticket ticket;
	private Usuario usuarioActual;
	private ArrayList<ColorVehiculo> coloresVehiculos;
	private ArrayList<ModeloVehiculo> modelosVehiculos;
	private ArrayList<Descuento> descuentos;
	private ArrayList<Descuento> cocheras;
	
	private double tasaInteres;
	
	private static Controlador instancia;

	public static void main(String []args)
	{

	}

	public static Controlador getInstancia()
	{
		if(instancia==null)
		{
			instancia=new Controlador();
		}
		return instancia;
	}

	public boolean validarContrasenaActual(int dni , String psw){

		Usuario u = buscarUsuario(dni) ;

		if (u!=null){
			if(psw.equals(u.getPassword())){
				return true;
			}else
				return false;
		}else
			return false;
	}

	public boolean validarLogin(String userName, String password){
		return true;
//HARDCODEADO PARA INGRESAR CON CUALQUIER USUARIO Y CLAVE
		
		
//		String pswEnc = Encriptacion.Encriptar(password);
//
//		Usuario u = this.buscarUsuario(userName, pswEnc) ;
//
//		if (u!=null){
//
//			if(pswEnc.equals(u.getPassword())){
//				usuarioActual = u.getView();
//				return true;
//			}
//			else
//				return false;
//		}
//		return false;
	}




	public Usuario buscarUsuario(String userName, String password){

		return null;
	}


	public Usuario buscarUsuario(int dni){

		return null;
	}

	public Usuario getUsuarioActual() {
		return usuarioActual;
	}


	public boolean probarConexion(){
//HARDCODEADO	
		return true;
//		Connection con = PoolConnection.getPoolConnection().getConnection();
//		if (con == null){
//			return false;
//		}else
//			return true;
	}

	public boolean validarPermiso(String string) {
		// TODO Auto-generated method stub
		return true;
	}


}

