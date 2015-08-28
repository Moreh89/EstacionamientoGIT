package controlador;



import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import jxl.write.WriteException;
import net.sf.jasperreports.engine.virtualization.SqlDateSerializer;
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
	private ArrayList<Cliente> clientes;

	//fin carga inicial
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
		clientes=DAOCliente.getInstance().getClientes();
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

		cliente.setCuentaCorriente(new modelo.CuentaCorriente());

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


	public Ticket generarTicket(String tipoVehiculo, String modelo,
			String color, String descuento, String patente,
			String cliente, String prepago, String obsevacion) {

		CategoriaVehiculo catve= buscarCategoriaVehiulo(tipoVehiculo);

		ModeloVehiculo modve = buscarModeloVehiulo(modelo);

		Cliente cl = this.clienteActual;

		Descuento des = buscarDescuento(descuento);

		ColorVehiculo col = buscarColor(color);

		double prepT = 0;
		if (!prepago.equals("")){
			prepT = Double.valueOf(prepago);
		}

		Ticket tck = new Ticket( catve, modve, cl, des, col,usuarioActual, prepT, obsevacion, patente);
		this.ticket = tck;

		long numeroTck = DAOTicket.getInstance().persistir(tck);
		tck.setIdTicket(numeroTck);
		//TODO IMPRIMIR TICKET
		return tck;

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

	private modelo.Cliente buscarCliente(String cliente) {
		if(cliente !=null){
			for (Cliente clienteTemp : this.clientes) {
				if(clienteTemp.toString().equals(cliente)) return clienteTemp;
			}
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

	public long altaTarifa(String categoriaVehiculo,double costoMinimo, double costoFraccion, double costoHora, double costoMediaEstadia, double costoEstadia,double tiempoMinimo,double tiempoFraccion, double tiempoMediaEstadia_minuto, double tiempoEstadia_minuto) 
	{

		modelo.CategoriaVehiculo categoriaVehiculoM = new CategoriaVehiculo();
		categoriaVehiculoM=DAOCategoriaVehiculo.getInstance().buscarCategoriaVehiculo(categoriaVehiculo);

		modelo.Tarifa tarifaM = new modelo.Tarifa(categoriaVehiculoM, costoMinimo, costoFraccion, costoHora, costoMediaEstadia, costoEstadia,
				tiempoMinimo,tiempoFraccion, tiempoMediaEstadia_minuto, tiempoEstadia_minuto);

		return DAOTarifa.getInstance().persistir(tarifaM);
	}

	public Vector<String> getColoresActualesString() {
		Vector<String> coloresActuales=new Vector<String>();
		for(ColorVehiculo color:coloresVehiculos)
		{
			coloresActuales.add(color.getDescripcion());
		}
		return coloresActuales;
	}

	public ArrayList<modelo.ColorVehiculo> getColoresActuales() {
		return coloresVehiculos;
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
		cochera.setPorcentajeExpensas(porcentajeExpensas);
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

	public ArrayList<modelo.Cliente> getCliente(String campoIdentificador, String tipoIdentificado)

	{
		ArrayList<Cliente> listaClietnes = new ArrayList<Cliente>();
		for (Cliente clienteTemp : clientes) {
			if (tipoIdentificado.equals("DNI/LU")){
				if (clienteTemp.getNumeroDocumento().contains(campoIdentificador)) {
					listaClietnes.add(clienteTemp);
				}
			}
			if (tipoIdentificado.equals("CUIT")){
				if (clienteTemp.getCuil().contains(campoIdentificador)) {
					listaClietnes.add(clienteTemp);
				}

			}
			if (tipoIdentificado.equals("NOMBRE")){
				if (clienteTemp.getNombre().toLowerCase().contains(campoIdentificador.toLowerCase())) {
					listaClietnes.add(clienteTemp);
				}
			}
			if (tipoIdentificado.equals("APELLIDO")){
				if (clienteTemp.getApellido().toLowerCase().contains(campoIdentificador.toLowerCase())) {
					listaClietnes.add(clienteTemp);
				}
			}

		}
		return listaClietnes;
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

	public boolean cancelarTicket(Ticket tck) {
		return DAOTicket.getInstance().borrar(tck);
	}

	public void actualizarTicket(String tipoVehiculo, String modelo,
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

		this.ticket.setCatergoriaVehiculo(catve);
		this.ticket.setModeloVehiculo(modve);
		this.ticket.setCliente(cl);
		this.ticket.setDescuento(des);
		this.ticket.setColor(col);
		this.ticket.setUsuario(usuarioActual);
		this.ticket.setPrepago(prepT);
		this.ticket.setObservacion(obsevacion);
		this.ticket.setPatente(patente);

		DAOTicket.getInstance().actualizar(this.ticket);

	}

	public long generarCobroExtraordinario(String tipoCobro, double monto,
			modelo.Cliente cliente) {
		modelo.MovimientoCC movimientoM = new MovimientoCC();
		movimientoM.setTicket(null);
		movimientoM.setDescripcion(tipoCobro.substring(2));
		movimientoM.setEstado("pagado");
		movimientoM.setFecha(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		movimientoM.setIdMovimiento(0);
		movimientoM.setMontoCobrado(monto);

		DAOMovimientoCC.getInstance().persistir(movimientoM);

		return 0;
	}

	public long liquidarExpensas(double importeLiquidar, String periodoLiquidar, String descripcion) 
	{
		ArrayList<modelo.Cliente> clientesConCocheraALiquidar = new ArrayList<modelo.Cliente>();
		clientesConCocheraALiquidar=DAOCliente.getInstance().getClientes();
		ArrayList<String> expensasImprimir = new ArrayList<String>();
		expensasImprimir.add("Cochera;Periodo a Liquidar;Nombre;Apellido;Porcentaje;Monto");
		long porcentajeTotalCobrado=0;
		new GregorianCalendar();
		Date fecha= GregorianCalendar.getInstance().getTime();
		for(modelo.Cliente clienteM : clientesConCocheraALiquidar)
		{
			if(!clienteM.getCocheras().isEmpty())
			{
				if(clienteM.getCuentaCorriente()!=null)
				{
					double montoCobrar = 0;
					for(modelo.Cochera cocheraActual : clienteM.getCocheras())
					{
						montoCobrar = montoCobrar + (cocheraActual.getPorcentajeExpensas() * importeLiquidar / 100); 
						porcentajeTotalCobrado=(long) (porcentajeTotalCobrado+cocheraActual.getPorcentajeExpensas());

						modelo.MovimientoCC movimientoNuevo= new modelo.MovimientoCC();
						movimientoNuevo.setIdMovimiento(0);

						movimientoNuevo.setFecha(fecha);
						movimientoNuevo.setDescripcion(descripcion);
						movimientoNuevo.setEstado("Liquidado");
						movimientoNuevo.setTicket(null);
						movimientoNuevo.setMontoCobrado((-1)*montoCobrar);

						DAOCliente.getInstance().agregarMovimientoCC(clienteM.getIdCliente(), movimientoNuevo);

						expensasImprimir.add(cocheraActual.getUbicacion()+";"+periodoLiquidar +";"+ clienteM.getNombre()+";"+clienteM.getApellido()+";"+cocheraActual.getPorcentajeExpensas() +";"+ montoCobrar);
					}

				}
			}
		}

		Excel excel = new Excel();
		//TODO GUARDA CON UN MES MENOR AL ACTUAL
		excel.setOutputFile("c:/temp/"+new SimpleDateFormat("yyyy_mm_dd_hh_mm").format(fecha)+".xls");

		try {
			excel.writeList(expensasImprimir);
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return porcentajeTotalCobrado;
	}

	public ArrayList<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClienteActual(Cliente cliente) {
		this.clienteActual = cliente;

	}

	public Cliente getClienteActual() {
		return this.clienteActual;

	}

	public long modificarColor(modelo.ColorVehiculo colorSeleccionado) {
		long codigoReturn=-1;
		codigoReturn=DAOColorVehiculo.getInstance().modificarColor(colorSeleccionado);
		coloresVehiculos=DAOColorVehiculo.getInstance().getColoresVehiculos();
		return codigoReturn;
	}

	public long altaColor(String descripcion) {
		long codigoReturn = -1;
		modelo.ColorVehiculo colorNuevo = new ColorVehiculo();
		colorNuevo.setIdColor(0);
		colorNuevo.setDescripcion(descripcion);
		codigoReturn= DAOColorVehiculo.getInstance().persistir(colorNuevo);
		if(codigoReturn!=-1)
		{
			colorNuevo.setIdColor(codigoReturn);
			coloresVehiculos.add(colorNuevo);
		}
		return codigoReturn;
	}


}