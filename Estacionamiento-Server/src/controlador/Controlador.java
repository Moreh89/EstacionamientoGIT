package controlador;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.dao.*;
import modelo.*;

@SuppressWarnings("unused")
public class Controlador {

	private ArrayList<Tarifa> tarifas;
	private Cliente clienteActual = null;
	private Ticket ticket;
	private Usuario usuarioActual;
	private ArrayList<Cochera> cocheras;
	
	//carga inicial
	private ArrayList<ColorVehiculo> coloresVehiculos;
	private ArrayList<ModeloVehiculo> modelosVehiculos;
	private ArrayList<CategoriaVehiculo> categoriasVehiculos;
	private ArrayList<Descuento> descuentos;
	private modelo.TasaInteres tasaInteres;
	
	public ArrayList<Cochera> cocherasActuales;
	public ArrayList<Vehiculo> vehiculosActuales;
	public ArrayList<PersonaAutorizada> personasAutorizadasActuales;


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


	public boolean cargaInicial()
	{
		coloresVehiculos=DAOColorVehiculo.getInstance().getColoresVehiculos();
		modelosVehiculos=DAOModeloVehiculo.getInstance().getModelosVehiculos();
		categoriasVehiculos=DAOCategoriaVehiculo.getInstance().getCategoriasVehiculos();
		descuentos=DAODescuento.getInstance().getDescuentos();
		tasaInteres=DAOTasaInteres.getInstance().getTasaInteresActual();
		tarifas=DAOTarifa.getInstance().getTarifas();
		return true;
		
	}


	public void altaCliente(String nombre, String apellido, String telefono1,
			String telefono2, String direccion1, String direccion2,
			String email, String razonSocial, ArrayList<String> listPersonasAutorizadas,
			ArrayList<String> listVehiculos, String tipoDoc, String numeroDoc, String tipoCliente, String cuil) 
	{
		Cliente cliente=new Cliente();
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setTelefono1(telefono1);
		cliente.setTelefono2(telefono2);
		cliente.setDireccion(direccion1);
		cliente.setDireccion2(direccion2);
		cliente.setCorreoElectronico(email);
		cliente.setRazonSocial(razonSocial);
		cliente.setCuil(cuil);
		
		
		if(tipoDoc.equals("1. DNI"))
			cliente.setTipoDocumento(modelo.Cliente.TIPO_DOC.DNI);
		if(tipoDoc.equals("2. LU"))
			cliente.setTipoDocumento(modelo.Cliente.TIPO_DOC.LU);
		if(tipoDoc.equals("3. PASAPORTE"))
			cliente.setTipoDocumento(modelo.Cliente.TIPO_DOC.PASS);
		if(tipoDoc.equals("4. OTRO"))
			cliente.setTipoDocumento(modelo.Cliente.TIPO_DOC.OTRO);
		
		cliente.setNumeroDocumento(numeroDoc);
		
		if(tipoCliente.equals("1. FIJO_PERSONA"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.FIJO_PERSONA);
		if(tipoCliente.equals("2. FIJO_EMPRESA"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.FIJO_EMPRESA);
		if(tipoCliente.equals("3. TEMPORAL"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.TEMPORAL);
		
		cliente.setEstado(modelo.Cliente.ESTADO.ACTIVO);
		
		cliente.setCocheras(cocherasActuales);
		cliente.setPersonasAutorizadasARetirar(personasAutorizadasActuales);
		cliente.setVehiculos(vehiculosActuales);
		
		DAOCliente.getInstance().persistir(cliente);
	}

	public void agregarVehiculo(String categoriaVehiculo, String patente,
			String color, String modelo, String observacion, String comentario) {

		if (clienteActual == null) {
			if (vehiculosActuales == null) 
			{
				vehiculosActuales = new ArrayList<Vehiculo>();
			}

			Vehiculo vehiculo = new Vehiculo();

//			modelo.CategoriaVehiculo categoriaVehiculo = new modelo.CategoriaVehiculo();
			for(modelo.CategoriaVehiculo categoriaVehiculoM : categoriasVehiculos)
			{
				if(categoriaVehiculo.equals(categoriaVehiculoM.getDescripcion()))
				{
					vehiculo.setCategoria(categoriaVehiculoM);
					break;
				}
			}

			vehiculo.setPatente(patente);
			vehiculo.setComentario(comentario);
			//TODO BUSQUEDA EN MEMORIA, ya están por carga inicial
			
			for(modelo.ColorVehiculo colorVehiculo : coloresVehiculos)
			{
				if(color.equals(colorVehiculo.getDescripcion()))
				{
					vehiculo.setColor(colorVehiculo);
					break;
				}
			}
//			modelo.ColorVehiculo colorVehiculo = DAOColorVehiculo.getInstance().getColorVehiculo(color);


//			ModeloVehiculo modeloVehiculo = DAOModeloVehiculo.getInstance().getModeloVehiculo(modelo);
	
			for(ModeloVehiculo modeloVehiculo : modelosVehiculos)
			{
				if(modelo.equals(modeloVehiculo.getDescripcion()))
				{
					vehiculo.setModelo(modeloVehiculo);
					break;
				}
			}
			vehiculosActuales.add(vehiculo);
			// TODO PENDIENTE AGREGAR OBSERVACION

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
			String cliente, String prepago, String obsevacion) {

		CategoriaVehiculo catve= buscarCategoriaVehiulo(tipoVehiculo);
		
		ModeloVehiculo modve = buscarModeloVehiulo(modelo);
		
		Cliente cl = buscarCliente(cliente);
		
		Descuento des = buscarDescuento(descuento);
		
		ColorVehiculo col = buscarColor(color);

		double prepT = 0;
		if (!prepago.equals("")){
			prepT = Double.valueOf(prepago);
			}
		
		Ticket tck = new Ticket( catve, modve, cl, des, col,usuarioActual, prepT, obsevacion, patente);
		this.ticket = tck;

		long numeroTck = DAOTicket.getInstance().persistir(tck);

		//TODO IMPRIMIR TICKET
		return String.valueOf(numeroTck);

	}


	private ColorVehiculo buscarColor(String color) {
		if(color !=null){
			for (ColorVehiculo col : this.coloresVehiculos) {
				if(col.getDescripcion().equals(color)) return col;
			}
		}
		return null;
	}

	private Descuento buscarDescuento(String descuento) {
		if(descuento !=null){
			for (Descuento desc : this.descuentos) {
				if(desc.getDescripcion().equals(descuento)) return desc;
			}
		}
		return null;
	}

	private Cliente buscarCliente(String cliente) {
		// TODO Auto-generated method stub
		if(cliente !=null){
			
		}
		return null;
	}

	private ModeloVehiculo buscarModeloVehiulo(String modelo) {
		for (ModeloVehiculo modeloV : modelosVehiculos) {
			if(modeloV.getDescripcion().equals(modelo)) return modeloV;
		}
		return null;
	}

	private CategoriaVehiculo buscarCategoriaVehiulo(String tipoVehiculo) {
		for (modelo.CategoriaVehiculo categoria : categoriasVehiculos) {
			if(categoria.getDescripcion().equals(tipoVehiculo)) return categoria;
		}
		return null;
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

	public Vector<String> getColoresActuales() {
		Vector<String> coloresActuales=new Vector<String>();
		for(ColorVehiculo color:coloresVehiculos)
		{
			coloresActuales.add(color.getDescripcion());
		}
		return coloresActuales;
	}
	
	public Vector<String> getDescuentosActuales() {
		Vector<String> descuentosActuales=new Vector<String>();
		for(Descuento descuento:descuentos)
		{
			descuentosActuales.add(descuento.getDescripcion());
		}
		return descuentosActuales;
	}
	
	
	
	public Vector<String> getModelosActuales() {
		Vector<String> modelosActuales=new Vector<String>();
		for(ModeloVehiculo modelo:modelosVehiculos)
		{
			modelosActuales.add(modelo.getDescripcion());
		}
		return modelosActuales;
	}

	public Vector<String> getCategoriasVehiculosActuales()
	{
		Vector<String> categoriasVehiculosActuales = new Vector<String>();
		for(modelo.CategoriaVehiculo categoriaVehiculo : categoriasVehiculos)
		{
			categoriasVehiculosActuales.add(categoriaVehiculo.getDescripcion());
		}
		return categoriasVehiculosActuales;
	}
	
	public void agregarCochera(String ubicacion, double costoMensual, float porcentajeExpensas,String piso) 
	{
		modelo.Cochera cochera = new modelo.Cochera();
		if (cocherasActuales == null) 
		{
			cocherasActuales = new ArrayList<Cochera>();
		}
		cochera.setCostoCochera(costoMensual);
		cochera.setCosto(porcentajeExpensas);
		cochera.setEstado(modelo.Cochera.ESTADO.ACTIVO);
		cochera.setUbicacion(ubicacion);
		cochera.setCliente(null);
		
		cocherasActuales.add(cochera);
	}

	public long altaDescuento(String descripcion,double montoDescuento)	
	{
		for(modelo.Descuento descuentoM : descuentos)
		{
			if(descuentoM.getDescripcion().equalsIgnoreCase(descripcion))
			{
				return -1;
			}
		}
		modelo.Descuento descuentoM = new Descuento();
		descuentoM.setDescripcion(descripcion);
		descuentoM.setDescuento(montoDescuento);
		descuentoM.setIdDescuento(0);
		
		return DAODescuento.getInstance().persistir(descuentoM);
		
		
	}
	
	public double getTasaInteres()
	{
		return tasaInteres.getMontoDescuento();
	}
	
	public long modificarTasaInteres(double montoTasaInteresNuevo)
	{
		modelo.TasaInteres tasaInteresNueva = new modelo.TasaInteres();
		tasaInteres.setEstado(modelo.TasaInteres.ESTADO.INACTIVO);
		long codigoReturn=DAOTasaInteres.getInstance().update(tasaInteres);
		if(codigoReturn!=-1)
		{
			tasaInteresNueva.setEstado(modelo.TasaInteres.ESTADO.ACTIVO);
			tasaInteresNueva.setMontoDescuento(montoTasaInteresNuevo);
			tasaInteresNueva.setIdTasaInteres(0);
			codigoReturn=DAOTasaInteres.getInstance().persistir(tasaInteresNueva);
			
			if(codigoReturn != -1)
			{
				tasaInteresNueva.setIdTasaInteres(codigoReturn);
				tasaInteres=tasaInteresNueva;
			}
		}
		return codigoReturn;
	}
	
	public modelo.Cliente getCliente(String campoIdentificador, String tipoIdentificado)

	{
		return null;
	}

	public Ticket buscarTicket(String numeroTicket) {
		persistencia.clases.Ticket tckP = DAOTicket.getInstance().getTicket(Long.parseLong(numeroTicket));
		
		if (tckP != null) {
			 modelo.Ticket tckM = Converter.convertTicketPersistenciaToModelo(tckP);
			 	if(tckM.getEstado()!= Ticket.Estado.CERRADO) tckM.calcularMontoACobrar();
			 
			 this.ticket = tckM;
			 return tckM;
		}
		this.ticket = null;
		return null;
	}

	public boolean cobrarTicket() {

		if(this.ticket.getEstado() != Ticket.Estado.CERRADO){
			this.ticket.setEstado(Ticket.Estado.CERRADO);
			this.ticket.setUsuario(usuarioActual);
			DAOTicket.getInstance().actualizar(this.ticket);
			return true;
		}
		return false;
	}

	public ArrayList<Tarifa> getTarifas() {
		return tarifas;
	}

}