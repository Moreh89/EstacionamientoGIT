package controlador;



import java.io.File;
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

import javax.swing.JOptionPane;

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
	ArrayList<modelo.Cliente> clientesConDeuda;

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
		this.aplicarInteres();
		this.liquidarAlquileres();
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

		if(tipoCliente.equals("1. PARTICULAR_PROPIETARIO"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.PARTICULAR_PROPIETARIO);
		if(tipoCliente.equals("2. PARTICULAR_INQUILINO"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.PARTICULAR_INQUILINO);
		if(tipoCliente.equals("3. PARTICULAR_FRECUENTE"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.PARTICULAR_FRECUENTE);
		if(tipoCliente.equals("4. EMPRESA_PROPIETARIO"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.EMPRESA_PROPIETARIO);
		if(tipoCliente.equals("5. EMPRESA_INQUILINO"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.EMPRESA_INQUILINO);
		if(tipoCliente.equals("6. EMPRESA_FRECUENTE"))
			cliente.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.EMPRESA_FRECUENTE);

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

	public String backUp(){
		File theDir = new File("C:\\SIGE\\BackUp\\");

		String stringReturn="";
		try{   
			if (!theDir.exists())
			{ 
				boolean result = theDir.mkdirs();    
				if(result==false){  
					return "";
				}  
			}
			String path= "'"+theDir.getPath()+"\\";
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
			Date date = new Date(); 
			String fileNameBackup = "backUp_"+dateFormat.format(date)+".BAK'"; 
			stringReturn=HibernateDAO.getInstancia().backUp("ESTACIONAMIENTO", path, fileNameBackup);

		}catch(Exception e){  

			return "";
		}  

		return stringReturn;

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

	public Vector<String> getDescuentosActualesString() {
		Vector<String> descuentosActuales=new Vector<String>();
		for(Descuento descuento:descuentos)
		{
			descuentosActuales.add(descuento.getDescripcion());
		}
		return descuentosActuales;
	}
	
	public ArrayList<modelo.Descuento> getDescuentosActuales() {
		return descuentos;
	}



	public Vector<String> getModelosActualesString() {
		Vector<String> modelosActuales=new Vector<String>();
		for(ModeloVehiculo modelo:modelosVehiculos)
		{
			modelosActuales.add(modelo.getDescripcion());
		}
		return modelosActuales;
	}


	public ArrayList<modelo.ModeloVehiculo> getModelosActuales() {
		return modelosVehiculos;
	}


	public Vector<String> getCategoriasVehiculosActualesString()
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
		descuentoM.setEstado(modelo.Descuento.ESTADO.ACTIVO);
		descuentoM.setIdDescuento(0);
		long codigoReturn=DAODescuento.getInstance().persistir(descuentoM);
		descuentos=DAODescuento.getInstance().getDescuentos();
		return codigoReturn;


	}

	public double getPorcentajeTasaInteres()
	{
		return tasaInteres.getMonto();
	}
	public int getDiaVencimientoInteres()
	{
		return tasaInteres.getDeadLine();
	}

	public long modificarTasaInteres(double montoTasaInteresNuevo, int deadLine)
	{
		modelo.TasaInteres tasaInteresNueva = new modelo.TasaInteres();
		tasaInteres.setEstado(modelo.TasaInteres.ESTADO.INACTIVO);
		long codigoReturn=DAOTasaInteres.getInstance().update(tasaInteres);
		if(codigoReturn!=-1)
		{
			tasaInteresNueva.setEstado(modelo.TasaInteres.ESTADO.ACTIVO);
			tasaInteresNueva.setMonto(montoTasaInteresNuevo);
			tasaInteresNueva.setIdTasaInteres(0);
			tasaInteresNueva.setDeadLine(deadLine);
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
			tckM.calcularMontoACobrar();

			this.ticket = tckM;
			return tckM;
		}
		this.ticket = null;
		return null;
	}

	public boolean cobrarTicket(Ticket.Estado estado) {

		if(this.ticket.getEstado() != estado){
			this.ticket.setEstado(estado);
			this.ticket.setUsuario(usuarioActual);
			this.ticket.setFechaSalida(GregorianCalendar.getInstance().getTime());
			DAOTicket.getInstance().actualizar(this.ticket);

			if(estado==modelo.Ticket.Estado.CREDITO){
				MovimientoCC movCC = new MovimientoCC();
				movCC.setDescripcion("Ticket");
				//TODO Que hace el estado??
				movCC.setEstado("CREDITO");
				movCC.setFecha(GregorianCalendar.getInstance().getTime());
				movCC.setIdMovimiento(0);
				movCC.setMontoCobrado(ticket.getMontoCobrado() * -1);
				movCC.setTicket(this.ticket);
				movCC.setUsuario(usuarioActual);
				DAOCliente.getInstance().agregarMovimientoCC(ticket.getCliente().getIdCliente(), movCC);
			}			
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
		movimientoM.setEstado("PAGADO");
		movimientoM.setFecha(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		movimientoM.setIdMovimiento(0);
		movimientoM.setMontoCobrado(monto);
		movimientoM.setUsuario(usuarioActual);
		DAOCliente.getInstance().agregarMovimientoCC(cliente.getIdCliente(), movimientoM);
		//		DAOMovimientoCC.getInstance().persistir(movimientoM);

		return 0;
	}

	public double liquidarExpensas(double importeLiquidar, String periodoLiquidar, String descripcion) 
	{
		ArrayList<modelo.Cliente> clientes = new ArrayList<modelo.Cliente>();
		clientes=DAOCliente.getInstance().getClientes();
		ArrayList<String> expensasImprimir = new ArrayList<String>();
		expensasImprimir.add("Cochera;Periodo a Liquidar;Nombre;Apellido;Porcentaje;Monto");
		double porcentajeTotalCobrado=0;
		new GregorianCalendar();
		Date fecha= GregorianCalendar.getInstance().getTime();

		modelo.LiquidacionExpensas liquidacionExpensas = new LiquidacionExpensas();
		liquidacionExpensas.setIdLiquidacionExpensas(0);
		liquidacionExpensas.setEstado(modelo.LiquidacionExpensas.Estado.LIQUIDADO);
		liquidacionExpensas.setFechaEmision(fecha);
		liquidacionExpensas.setMontoTotalLiquidado(importeLiquidar);

		for(modelo.Cliente clienteM : clientes)
		{
			if(!clienteM.getCocheras().isEmpty())
			{
				if(clienteM.getCuentaCorriente()!=null)
				{
					double montoCobrar = 0;
					for(modelo.Cochera cocheraActual : clienteM.getCocheras())
					{
						double montoMovimiento=cocheraActual.getPorcentajeExpensas() * importeLiquidar / 100;
						montoCobrar = montoCobrar + montoMovimiento; 
						porcentajeTotalCobrado=porcentajeTotalCobrado+cocheraActual.getPorcentajeExpensas();


						modelo.MovimientoCC movimientoNuevo= new modelo.MovimientoCC();
						movimientoNuevo.setIdMovimiento(0);
						movimientoNuevo.setFecha(fecha);
						movimientoNuevo.setDescripcion(descripcion);
						movimientoNuevo.setEstado("Liquidado");
						movimientoNuevo.setTicket(null);
						movimientoNuevo.setMontoCobrado((-1)*montoMovimiento);
						movimientoNuevo.setLiquidacionExpensas(liquidacionExpensas);
						movimientoNuevo.setUsuario(usuarioActual);


						liquidacionExpensas.setIdLiquidacionExpensas(DAOCliente.getInstance().agregarMovimientoCC_Expensas(clienteM.getIdCliente(), movimientoNuevo));

						expensasImprimir.add(cocheraActual.getUbicacion()+";"+periodoLiquidar +";"+ clienteM.getNombre()+";"+clienteM.getApellido()+";"+cocheraActual.getPorcentajeExpensas() +";"+ montoMovimiento);
					}

				}
			}
		}

		Excel excel = new Excel();
		File theDir = new File("C:\\SIGE\\Liquidaciones\\");
		if (!theDir.exists())
		{ 
			boolean result = theDir.mkdirs();    
		}
		String path= "'"+theDir.getPath()+"\\";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Date date = new Date(); 
		excel.setOutputFile(theDir+"\\Expensas_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(fecha)+".xls");

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
		if(codigoReturn!=-1)
		{
			coloresVehiculos=DAOColorVehiculo.getInstance().getColoresVehiculos();
		}
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

	public long altaModelo(String descripcion) {
		long codigoReturn = -1;
		modelo.ModeloVehiculo modeloNuevo = new ModeloVehiculo();
		modeloNuevo.setIdModelo(0);
		modeloNuevo.setDescripcion(descripcion);
		codigoReturn= DAOModeloVehiculo.getInstance().persistir(modeloNuevo);
		if(codigoReturn!=-1)
		{
			modeloNuevo.setIdModelo(codigoReturn);
			modelosVehiculos.add(modeloNuevo);
		}
		return codigoReturn;
	}

	public long modificarModelo(ModeloVehiculo modeloAct) {
		long codigoReturn = -1;
		codigoReturn= DAOModeloVehiculo.getInstance().modificarModelo(modeloAct);
		if(codigoReturn!=-1)
		{
			modelosVehiculos=DAOModeloVehiculo.getInstance().getModelosVehiculos();
		}

		return codigoReturn;
	}

	public ArrayList<modelo.LiquidacionExpensas> getLiquidacionesRecientes() 
	{
		//Liquidaciones generadas en los últimos 30 días.
		return DAOLiquidacionExpensas.getInstance().getLiquidacionesRecientes();
	}

	public long anularLiquidacionExpensas(LiquidacionExpensas liquidacionSeleccionado) {

		long codigoReturn=-1;

		liquidacionSeleccionado.setEstado(modelo.LiquidacionExpensas.Estado.ANULADO);
		DAOLiquidacionExpensas.getInstance().anularLiquidacion(liquidacionSeleccionado);

		ArrayList<modelo.Cliente> clientes = new ArrayList<modelo.Cliente>();
		clientes=DAOCliente.getInstance().getClientes();

		new GregorianCalendar();
		Date fecha= GregorianCalendar.getInstance().getTime();

		for(modelo.Cliente clienteM : clientes)
		{
			if(!clienteM.getCocheras().isEmpty() && clienteM.getCuentaCorriente()!=null && !clienteM.getCuentaCorriente().getMovimientos().isEmpty() )
			{
				for(modelo.MovimientoCC movimientoActual : clienteM.getCuentaCorriente().getMovimientos())
				{
					if(movimientoActual.getLiquidacionExpensas()!=null && movimientoActual.getLiquidacionExpensas().getIdLiquidacionExpensas()==liquidacionSeleccionado.getIdLiquidacionExpensas())
					{
						modelo.MovimientoCC movimientoNuevo= new modelo.MovimientoCC();
						movimientoNuevo.setIdMovimiento(0);
						movimientoNuevo.setFecha(fecha);
						movimientoNuevo.setDescripcion("ANULADO - "+movimientoActual.getDescripcion());
						movimientoNuevo.setEstado("Anulado");
						movimientoNuevo.setTicket(null);
						movimientoNuevo.setMontoCobrado((-1)*movimientoActual.getMontoCobrado());
						movimientoNuevo.setLiquidacionExpensas(null);
						movimientoNuevo.setUsuario(usuarioActual);

						DAOCliente.getInstance().agregarMovimientoCC(clienteM.getIdCliente(), movimientoNuevo);
						codigoReturn=movimientoNuevo.getIdMovimiento();

					}
				}
			}
		}


		return codigoReturn;
	}

	public long modificarTarifa(Tarifa tarifaSeleccionada, double costoMinimo,
			double costoFraccion, double costoHora, double costoMediaEstadia,
			double costoEstadia, double tiempoMinimo, double tiempoFraccion,
			double tiempoMediaEstadia_minuto, double tiempoEstadia_minuto) {


		long codigoReturn = -1;		
		codigoReturn=DAOTarifa.getInstance().modificarTarifa(tarifaSeleccionada.getIdTarifa(), costoMinimo,
				costoFraccion, costoHora, costoMediaEstadia,
				costoEstadia, tiempoMinimo, tiempoFraccion,
				tiempoMediaEstadia_minuto, tiempoEstadia_minuto);

		if(codigoReturn!=-1)
		{
			tarifas=DAOTarifa.getInstance().getTarifas();

		}

		return codigoReturn;
	}

	public ArrayList<Ticket> obtenerTicketsAbiertos (){
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (persistencia.clases.Ticket ticketTemp : DAOTicket.getInstance().getTicketsAbiertos()) {
			tickets.add(Converter.convertTicketPersistenciaToModelo(ticketTemp));
		} ;
		return tickets;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public ArrayList<modelo.Usuario> getUsuarios() {
		return DAOUsuario.getInstance().getUsuarios();
	}

	public long modificarUsuario(String apellido, String dni, String nombre, String tipoDoc, String tipoUsuario, modelo.Usuario usuarioM) {
		long codigoReturn=-1;
		usuarioM.setApellido(apellido);
		usuarioM.setNombre(nombre);
		usuarioM.setNumeroDocumento(dni);
		usuarioM.setTipoDocumento(tipoDoc);
		if(tipoUsuario.equals("ADMIN"))
		{
			usuarioM.setPermisos(Usuario.PERMISOS.ADMIN);
		}
		if(tipoUsuario.equals("CAJA"))
		{
			usuarioM.setPermisos(Usuario.PERMISOS.CAJA);
		}

		codigoReturn=DAOUsuario.getInstance().modificarUsuario(usuarioM);

		return codigoReturn;

	}

	public long altaUsuario(String apellido, String nombre, String nroDoc,
			String password, String tipoUsuario, String userName, String tipoDoc) {
		long codigoReturn=-1;
		modelo.Usuario usuarioM=new modelo.Usuario();
		usuarioM.setApellido(apellido);
		usuarioM.setNombre(nombre);
		usuarioM.setNumeroDocumento(nroDoc);
		usuarioM.setTipoDocumento(tipoDoc);
		usuarioM.setPassword(password);
		usuarioM.setUserName(userName);
		usuarioM.setIdUsuario(0);
		if(tipoUsuario.equals("ADMIN"))
		{
			usuarioM.setPermisos(Usuario.PERMISOS.ADMIN);
		}
		if(tipoUsuario.equals("CAJA"))
		{
			usuarioM.setPermisos(Usuario.PERMISOS.CAJA);
		}

		codigoReturn=DAOUsuario.getInstance().persistir(usuarioM);
		return codigoReturn;
	}

	public ArrayList<Ticket> obtenerTicketsCobrados(Usuario usuario, Date fechaInicio, Date fechaFin) {
		ArrayList<Ticket> listaTicketsM = new ArrayList<Ticket>();

		ArrayList<persistencia.clases.Ticket> listaTicketsP = DAOTicket.getInstance().getTicketsCobrados(usuario, fechaInicio,fechaFin);

		for (persistencia.clases.Ticket ticketP : listaTicketsP) {
			listaTicketsM.add(Converter.convertTicketPersistenciaToModelo(ticketP));
		}

		return listaTicketsM;
	}


	private long aplicarInteres()
	{	
		//aplica solo a clientes del tipo propietarios
		int deadLine = tasaInteres.getDeadLine();
		java.util.Date fechaActual= Calendar.getInstance().getTime();;
		DateFormat dateFormatDay = new SimpleDateFormat("dd"); 

		if(Integer.parseInt(dateFormatDay.format(fechaActual))==deadLine)
		{
			ArrayList<modelo.Interes> intereses = new ArrayList<modelo.Interes>();
			intereses=DAOInteres.getInstance().getIntereses();
			for(modelo.Interes interesM : intereses)
			{
				DateFormat dateFormatValidacion = new SimpleDateFormat("dd-MM-yyyy"); 
				if(dateFormatValidacion.format(interesM.getFechaAplicado()).equals(dateFormatValidacion.format(fechaActual)))
				{
					return -1;
				}
			}

			ArrayList<modelo.Cliente> clientes = new ArrayList<modelo.Cliente>();

			clientes=DAOCliente.getInstance().getClientesPropietarios();
			modelo.Interes interesM= new Interes();
			interesM.setIdInteres(0);
			interesM.setFechaAplicado(fechaActual);

			for(modelo.Cliente clienteM : clientes)
			{
				if(clienteM.getCuentaCorriente()!=null && !clienteM.getCuentaCorriente().getMovimientos().isEmpty() )
				{
					double estadoCrediticioCliente=0;
					estadoCrediticioCliente= clienteM.getEstadoCrediticio(clienteM);
					if(estadoCrediticioCliente<0)
					{
						modelo.MovimientoCC movimientoNuevo= new modelo.MovimientoCC();
						movimientoNuevo.setIdMovimiento(0);
						movimientoNuevo.setFecha(fechaActual);
						movimientoNuevo.setDescripcion("INTERES "+tasaInteres.getMonto()+"% - Deuda "+estadoCrediticioCliente);
						movimientoNuevo.setEstado("Liquidado");
						movimientoNuevo.setTicket(null);
						movimientoNuevo.setMontoCobrado((tasaInteres.getMonto()/100*estadoCrediticioCliente));
						movimientoNuevo.setLiquidacionExpensas(null);
						movimientoNuevo.setInteres(interesM);
						movimientoNuevo.setUsuario(usuarioActual);

						interesM.setIdInteres(DAOCliente.getInstance().agregarMovimientoCC_Interes(clienteM.getIdCliente(), movimientoNuevo));
					}
				}

			}
		}
		return 0;

	}

	public ArrayList<MovimientoCC> getMovimientosCliente(Date fechaDesde, Date fechaHasta) {
		ArrayList<MovimientoCC> movimientos= new ArrayList<MovimientoCC>();
		modelo.Cliente cteAct=DAOCliente.getInstance().getClienteModelo(clienteActual.getIdCliente());
		if(cteAct!=null)
		{
			fechaDesde.setHours(0);
			fechaDesde.setMinutes(0);
			fechaDesde.setSeconds(0);
			fechaHasta.setHours(23);
			fechaHasta.setMinutes(59);
			fechaHasta.setSeconds(59);
			for(MovimientoCC movimientoAct : cteAct.getCuentaCorriente().getMovimientos())
			{
				if(fechaDesde.compareTo(movimientoAct.getFecha())<=0&& fechaHasta.compareTo(movimientoAct.getFecha())>=0)
				{
					movimientos.add(movimientoAct);
				}
			}
		}
		return movimientos;
	}

	public ArrayList<Cliente> getClientesConDeuda() {
		ArrayList<modelo.Cliente> clientes = new ArrayList<Cliente>();
		clientesConDeuda = new ArrayList<Cliente>();
		clientes=DAOCliente.getInstance().getClientes();

		for(modelo.Cliente cliente : clientes)
		{
			double estadoCrediticio = cliente.getEstadoCrediticio(cliente);
			if(estadoCrediticio<0)
			{
				cliente.setEstadoCrediticio(estadoCrediticio);
				clientesConDeuda.add(cliente);

			}
		}
		return clientesConDeuda;
	}

	public ArrayList<MovimientoCC> obtenetMovimientosCobrados(Usuario usuario, Date fechaInicio,
			Date fechaFin) {
		ArrayList<MovimientoCC> movimientosM = new ArrayList<MovimientoCC>();

		ArrayList<persistencia.clases.MovimientoCC> movimientosP =  DAOMovimientoCC.getInstance().getMovimientosCobrados(usuario, fechaInicio, fechaFin);
		for (persistencia.clases.MovimientoCC movimientoCCTemp : movimientosP) {
			movimientosM.add(Converter.convertMovimientoCuentaCorrientePersistenciaToModelo(movimientoCCTemp));
		}

		return movimientosM;


	}

	public double incrementarPrepago (double monto){

		if(ticket!=null){
			ticket.incrementarPrepago(monto);
			ticket.setMontoCobrado(0);
			ticket.setEstado(Ticket.Estado.PREPAGO);
			IncrementoPrepago incremento = new IncrementoPrepago(
					GregorianCalendar.getInstance().getTime(),
					ticket.getIdTicket(), monto, usuarioActual.getIdUsuario());
			DAOIncrementoPrepago.getInstance().persistir(incremento);
			DAOTicket.getInstance().actualizar(ticket);
		}

		return ticket.getPrepago();
	}

	public ArrayList<IncrementoPrepago> obternerIncrementos(Usuario usuario, Date fechaInicio,Date fechaFin){


		return DAOIncrementoPrepago.getInstance().getIncrementos(usuario.getIdUsuario(), fechaInicio, fechaFin);


	}

	public void actualizarDescuentoTicket(Ticket tck, Descuento descuento) {
		if(tck.getEstado()==Ticket.Estado.ABIERTO || tck.getEstado()==Ticket.Estado.CREDITO || tck.getEstado()==Ticket.Estado.PREPAGO){
					tck.setDescuento(descuento);
					tck.setMontoCobrado(0);
					DAOTicket.getInstance().actualizar(tck);
		}
	}

	public double getClienteEstadoCrediticio(long idCliente)
	{
		double estadoCrediticio=0;
		for(modelo.Cliente cte : clientesConDeuda)
		{
			if(cte.getIdCliente()==idCliente)

			{
				estadoCrediticio=cte.getEstadoCrediticio();
			}
		}

		return estadoCrediticio;
	}

	private void liquidarAlquileres() 
	{

		int deadLine = 9;
		java.util.Date fechaActual= Calendar.getInstance().getTime();;
		DateFormat dateFormatDay = new SimpleDateFormat("dd"); 

		if(Integer.parseInt(dateFormatDay.format(fechaActual))==deadLine)
		{	

			ArrayList<modelo.Cliente> clientes = new ArrayList<modelo.Cliente>();
			clientes=DAOCliente.getInstance().getClientesInquilinos();
			ArrayList<String> alquileresImprimir = new ArrayList<String>();
			alquileresImprimir.add("Cochera;Periodo a Liquidar;Nombre;Apellido;Monto");
			new GregorianCalendar();
			Date fecha= GregorianCalendar.getInstance().getTime();
			for(modelo.Cliente clienteM : clientes)
			{
				if(!clienteM.getCocheras().isEmpty())
				{
					if(clienteM.getCuentaCorriente()!=null)
					{

						for(modelo.Cochera cocheraActual : clienteM.getCocheras())
						{
							double montoMovimiento=cocheraActual.getCostoCochera();

							modelo.MovimientoCC movimientoNuevo= new modelo.MovimientoCC();
							movimientoNuevo.setIdMovimiento(0);
							movimientoNuevo.setFecha(fecha);
							movimientoNuevo.setDescripcion("Alquiler Cochera "+cocheraActual.getUbicacion());
							movimientoNuevo.setEstado("Liquidado");
							movimientoNuevo.setTicket(null);
							movimientoNuevo.setMontoCobrado((-1)*montoMovimiento);
							movimientoNuevo.setLiquidacionExpensas(null);
							movimientoNuevo.setUsuario(null);

							DAOCliente.getInstance().agregarMovimientoCC_Alquileres(clienteM.getIdCliente(), movimientoNuevo);

							alquileresImprimir.add(cocheraActual.getUbicacion()+";"+fecha +";"+ clienteM.getNombre()+";"+clienteM.getApellido()+";"+ montoMovimiento);
						}

					}
				}
			}


			Excel excel = new Excel();
			File theDir = new File("C:\\SIGE\\Liquidaciones\\");
			if (!theDir.exists())
			{ 
				boolean result = theDir.mkdirs();    
			}
			String path= "'"+theDir.getPath()+"\\";
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
			Date date = new Date(); 
			excel.setOutputFile(theDir+"\\Alquileres_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(fecha)+".xls");

			try {
				excel.writeList(alquileresImprimir);
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public long deshabilitarDescuento(long idDescuento) {
		long codigoReturn= DAODescuento.getInstance().deshabilitarDescuento(idDescuento);
		descuentos=DAODescuento.getInstance().getDescuentos();
		return codigoReturn;
	}

	public long modificarDescuento(String descripcion, double porcentaje, modelo.Descuento descuentoM) {
		long codigoReturn=-1;
		descuentoM.setDescripcion(descripcion);
		descuentoM.setDescuento(porcentaje);
		codigoReturn=DAODescuento.getInstance().modificarDescuento(descuentoM);
		descuentos=DAODescuento.getInstance().getDescuentos();
		return codigoReturn;
	}
}