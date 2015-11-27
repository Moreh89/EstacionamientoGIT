package controlador;



import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import jxl.write.WriteException;
import net.sf.jasperreports.crosstabs.fill.JRPercentageCalculatorFactory.DoublePercentageCalculator;
import net.sf.jasperreports.engine.virtualization.SqlDateSerializer;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.dao.*;
import vista.PrintTicketCobroExtraordinario;
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
	private double resumenCuentaMovimientosClienteActual=0;
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

			if(password.equals(u.getPassword()) && u.getEstado().equals(Usuario.ESTADO.ACTIVO)){
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

		//SORTS
		Collections.sort(descuentos, new Descuento.CompDescripcion());
		Collections.sort(coloresVehiculos, new ColorVehiculo.CompDescripcion());
		Collections.sort(modelosVehiculos, new ModeloVehiculo.CompDescripcion());
		Collections.sort(categoriasVehiculos, new CategoriaVehiculo.CompDescripcion());
		Collections.sort(clientes, new Cliente.CompApellido());


		this.aplicarInteres();
		return true;

	}

	public void actualizarClientes(){
		clientes=DAOCliente.getInstance().getClientes();
		Collections.sort(clientes, new Cliente.CompApellido());
	}


	public void altaCliente(String nombre, String apellido, String telefono1,
			String telefono2, String direccion1, String direccion2,
			String email, String razonSocial, ArrayList<PersonaAutorizada> listPersonasAutorizadas,
			ArrayList<Vehiculo> listVehiculos, ArrayList<Cochera> listCocheras, String tipoDoc, String numeroDoc, String tipoCliente, String cuil, String tipoFactura, String descripcion) 
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
		cliente.setDescripcion(descripcion);

		if(tipoFactura.equals("1. NO APLICA"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.NA);
		if(tipoFactura.equals("2. A"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.A);
		if(tipoFactura.equals("3. B"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.B);
		if(tipoFactura.equals("4. C"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.C);

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

		for (Cochera cochera : listCocheras){
			cochera.setCliente(cliente);
		}
		cliente.setCocheras(listCocheras);
		cliente.setPersonasAutorizadasARetirar(listPersonasAutorizadas);
		cliente.setVehiculos(listVehiculos);

		cliente.setCuentaCorriente(new modelo.CuentaCorriente());

		long idCliente = DAOCliente.getInstance().persistir(cliente);
		cliente.setIdCliente(idCliente);
		this.clientes.add(cliente);

	}


	public Ticket generarTicket(String tipoVehiculo, String modelo,
			String color, String descuento, String patente,
			String cliente, String prepago, String obsevacion, boolean pagoTarjeta) {

		CategoriaVehiculo catve= buscarCategoriaVehiulo(tipoVehiculo);

		ModeloVehiculo modve = buscarModeloVehiulo(modelo);

		Cliente cl = this.clienteActual;

		Descuento des = buscarDescuento(descuento);

		ColorVehiculo col = buscarColor(color);

		double prepT = 0;
		if (!prepago.equals("")){
			prepT = Double.valueOf(prepago);
		}

		Ticket tck = new Ticket( catve, modve, cl, des, col,usuarioActual, prepT, obsevacion, patente, pagoTarjeta);
		this.ticket = tck;

		long numeroTck = DAOTicket.getInstance().persistir(tck);
		tck.setIdTicket(numeroTck);
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

	//	public boolean probarConexion() {
	//		return true;
	//	}

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

	public ArrayList<modelo.Descuento> getDescuentosActuales() 
	{

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
				movCC.setEstado("Credito");
				movCC.setFecha(GregorianCalendar.getInstance().getTime());
				movCC.setIdMovimiento(0);
				movCC.setMontoCobrado(ticket.getMontoCobrado() * -1);
				movCC.setTicket(this.ticket);
				movCC.setUsuario(usuarioActual);
				//TO DO medio de pago
				// AGREGADO POR DAMIAN PARA MEDIOPAGO... NO LLEGA A LO VISUAL, POR DEFECTO ES NO APLICA SI SON MOVIMIENTOS INTERNOS DEL SISTEMA,
				//				SI MUEVEN CAJA EL DEFECTO ES EFECTIVO A MENOS QUE SEA LO CONTRARIO.
				movCC.setMedioPago(modelo.MovimientoCC.MEDIOPAGO.EFECTIVO);

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
			String cliente, String prepago, String obsevacion, boolean pagoTarjeta) {

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
		this.ticket.setPagotarjeta(pagoTarjeta);

		DAOTicket.getInstance().actualizar(this.ticket);

	}

	public long generarCobroExtraordinario(String tipoCobro, double monto,
			modelo.Cliente cliente, String impresora, String comentario) {
		modelo.MovimientoCC movimientoM = new MovimientoCC();
		movimientoM.setTicket(null);
		movimientoM.setDescripcion(tipoCobro.substring(2) +" "+ comentario);

		if(tipoCobro.equals("3. TARJETA"))
		{
			movimientoM.setEstado("TARJETA");
		}
		else
		{
			movimientoM.setEstado("PAGADO");
		}
		movimientoM.setFecha(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		movimientoM.setIdMovimiento(0);
		movimientoM.setMontoCobrado(monto);
		movimientoM.setUsuario(usuarioActual);
		movimientoM.setMedioPago(modelo.MovimientoCC.MEDIOPAGO.NOAPLICA);

		DAOCliente.getInstance().agregarMovimientoCC(cliente.getIdCliente(), movimientoM);
		new PrintTicketCobroExtraordinario(movimientoM, impresora, cliente);
		return 0;
	}

	public double liquidarExpensas(double importeLiquidar, String periodoLiquidar, String descripcion) 
	{
		ArrayList<modelo.Cliente> clientes = new ArrayList<modelo.Cliente>();
		clientes=DAOCliente.getInstance().getClientesPropietarios();
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
						movimientoNuevo.setMedioPago(modelo.MovimientoCC.MEDIOPAGO.NOAPLICA);


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
			excel.exportarExcelLiquidacion(expensasImprimir);
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DecimalFormat dF = new DecimalFormat("#.###");
		return Double.parseDouble(dF.format(porcentajeTotalCobrado));
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

	public ArrayList<modelo.LiquidacionExpensas> getLiquidacionesExpensasRecientes() 
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
						movimientoNuevo.setMedioPago(modelo.MovimientoCC.MEDIOPAGO.NOAPLICA);

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

	public ArrayList<modelo.Usuario> getUsuarios() 
	{
		ArrayList<modelo.Usuario> usuariosReturn = DAOUsuario.getInstance().getUsuarios();
		Collections.sort(usuariosReturn, new Usuario.CompApellido());
		return usuariosReturn;
	}

	public long modificarUsuario(String apellido, String dni, String nombre, String tipoDoc, String tipoUsuario,String estado, modelo.Usuario usuarioM) {
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
		if(estado.equals("ACTIVO"))
		{
			usuarioM.setEstado(Usuario.ESTADO.ACTIVO);
		}
		if(estado.equals("INACTIVO"))
		{
			usuarioM.setEstado(Usuario.ESTADO.INACTIVO);
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
		usuarioM.setEstado(Usuario.ESTADO.ACTIVO);

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
						movimientoNuevo.setMedioPago(modelo.MovimientoCC.MEDIOPAGO.NOAPLICA);

						interesM.setIdInteres(DAOCliente.getInstance().agregarMovimientoCC_Interes(clienteM.getIdCliente(), movimientoNuevo));
					}
				}

			}
		}
		return 0;

	}

	@SuppressWarnings("deprecation")
	public ArrayList<MovimientoCC> getMovimientosCliente(Date fechaDesde, Date fechaHasta) {
		resumenCuentaMovimientosClienteActual=0;
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
					resumenCuentaMovimientosClienteActual=resumenCuentaMovimientosClienteActual+Math.round(movimientoAct.getMontoCobrado());
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

	public long liquidarAlquileres(String descripcion) 
	{
		long codigoReturn=0;
		ArrayList<modelo.Cliente> clientes = new ArrayList<modelo.Cliente>();
		clientes=DAOCliente.getInstance().getClientesInquilinos();
		ArrayList<String> alquileresImprimir = new ArrayList<String>();
		alquileresImprimir.add("Cochera;Periodo a Liquidar;Nombre;Apellido;Monto");
		new GregorianCalendar();
		Date fecha= GregorianCalendar.getInstance().getTime();
		String fechaLiquidacion = new SimpleDateFormat("MM-dd-yyyy").format(fecha);

		modelo.LiquidacionAlquileres liquidacionAlquileres = new LiquidacionAlquileres();
		liquidacionAlquileres.setIdLiquidacionAlquileres(0);
		liquidacionAlquileres.setEstado(modelo.LiquidacionAlquileres.Estado.LIQUIDADO);
		liquidacionAlquileres.setFechaEmision(fecha);


		for(modelo.Cliente clienteM : clientes)
		{
			if(!clienteM.getCocheras().isEmpty())
			{
				if(clienteM.getCuentaCorriente()!=null)
				{
					for(modelo.Cochera cocheraActual : clienteM.getCocheras())
					{
						codigoReturn++;
						double montoMovimiento=cocheraActual.getCostoCochera();

						modelo.MovimientoCC movimientoNuevo= new modelo.MovimientoCC();
						movimientoNuevo.setIdMovimiento(0);
						movimientoNuevo.setFecha(fecha);
						movimientoNuevo.setDescripcion(descripcion+" - "+cocheraActual.getUbicacion());
						movimientoNuevo.setEstado("Liquidado");
						movimientoNuevo.setTicket(null);
						movimientoNuevo.setMontoCobrado((-1)*montoMovimiento);
						movimientoNuevo.setLiquidacionExpensas(null);
						movimientoNuevo.setUsuario(usuarioActual);
						movimientoNuevo.setLiquidacionAlquileres(liquidacionAlquileres);
						movimientoNuevo.setMedioPago(modelo.MovimientoCC.MEDIOPAGO.NOAPLICA);
						liquidacionAlquileres.setIdLiquidacionAlquileres(DAOCliente.getInstance().agregarMovimientoCC_Alquileres(clienteM.getIdCliente(), movimientoNuevo));

						alquileresImprimir.add(cocheraActual.getUbicacion()+";"+fechaLiquidacion +";"+ clienteM.getNombre()+";"+clienteM.getApellido()+";"+ montoMovimiento);

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
			excel.exportarExcelLiquidacion(alquileresImprimir);
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codigoReturn;
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

	public ArrayList<modelo.LiquidacionAlquileres> getLiquidacionesAlquileresRecientes() 
	{
		//Liquidaciones generadas en los últimos 30 días.
		return DAOLiquidacionAlquileres.getInstance().getLiquidacionesRecientes();
	}

	public long anularLiquidacionAlquileres(LiquidacionAlquileres liquidacionSeleccionado) {

		long codigoReturn=-1;

		liquidacionSeleccionado.setEstado(modelo.LiquidacionAlquileres.Estado.ANULADO);
		DAOLiquidacionAlquileres.getInstance().anularLiquidacion(liquidacionSeleccionado);

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
					if(movimientoActual.getLiquidacionAlquileres()!=null && movimientoActual.getLiquidacionAlquileres().getIdLiquidacionAlquileres()==liquidacionSeleccionado.getIdLiquidacionAlquileres())
					{
						modelo.MovimientoCC movimientoNuevo= new modelo.MovimientoCC();
						movimientoNuevo.setIdMovimiento(0);
						movimientoNuevo.setFecha(fecha);
						movimientoNuevo.setDescripcion("ANULADO - "+movimientoActual.getDescripcion());
						movimientoNuevo.setEstado("Anulado");
						movimientoNuevo.setTicket(null);
						movimientoNuevo.setMontoCobrado((-1)*movimientoActual.getMontoCobrado());
						movimientoNuevo.setLiquidacionAlquileres(null);
						movimientoNuevo.setUsuario(usuarioActual);
						movimientoNuevo.setMedioPago(modelo.MovimientoCC.MEDIOPAGO.NOAPLICA);
						DAOCliente.getInstance().agregarMovimientoCC(clienteM.getIdCliente(), movimientoNuevo);
						codigoReturn=movimientoNuevo.getIdMovimiento();

					}
				}
			}
		}


		return codigoReturn;
	}
	public double getResumenCuentaMovimientosClienteActual()
	{
		return Math.round(this.resumenCuentaMovimientosClienteActual);
	}

	public long exportarDeudoresExcel()
	{
		//		clientesConDeuda
		Date fecha= GregorianCalendar.getInstance().getTime();

		ArrayList<String> deudoresImprimir = new ArrayList<String>();
		deudoresImprimir.add("Fecha;Nombre;Apellido;Monto;Tipo Cliente;Cochera");
		String cocherasCte="";
		for(modelo.Cliente clienteAct : clientesConDeuda)
		{
			for(modelo.Cochera cocheraM:clienteAct.getCocheras())
			{
				if(cocherasCte.equalsIgnoreCase(""))
				{
					cocherasCte=cocheraM.getUbicacion();
				}
				else
				{
					cocherasCte.concat(" - ");
					cocherasCte.concat(cocheraM.getUbicacion());
				}
			}
			deudoresImprimir.add(new SimpleDateFormat("dd-MM-yyyy").format(fecha)+";"+clienteAct.getNombre()+";"+clienteAct.getApellido()+";"+clienteAct.getEstadoCrediticio()+";"+ clienteAct.getTipoCliente().toString()+";"+cocherasCte);

		}

		Excel excel = new Excel();
		File theDir = new File("C:\\SIGE\\Deudores\\");
		if (!theDir.exists())
		{ 
			boolean result = theDir.mkdirs();    
		}
		String path= "'"+theDir.getPath()+"\\";
		//		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		//		Date date = new Date(); 
		excel.setOutputFile(theDir+"\\Deudores_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(fecha)+".xls");

		try {
			excel.writeList(deudoresImprimir);
			return 1;
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public ArrayList<CategoriaVehiculo> getCategoriasVehiculosActuales() {
		return this.categoriasVehiculos;
	}

	public void actualizarCliente(String nombre, String apellido,
			String telefono1, String telefono2, String direccion1,
			String direccion2, String email, String razonSocial,
			ArrayList<PersonaAutorizada> listPersonasAutorizadas,
			ArrayList<Vehiculo> listVehiculos, ArrayList<Cochera> listCocheras,
			String tipoDoc, String numeroDoc, String tipoCliente, String cuil,
			String tipoFactura, String descripcion, String estado) {

		Cliente cliente=this.clienteActual;
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setTelefono1(telefono1);
		cliente.setTelefono2(telefono2);
		cliente.setDireccion(direccion1);
		cliente.setDireccion2(direccion2);
		cliente.setCorreoElectronico(email);
		cliente.setRazonSocial(razonSocial);
		cliente.setCuil(cuil);
		cliente.setDescripcion(descripcion);

		if(tipoFactura.equals("1. NO APLICA"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.NA);
		if(tipoFactura.equals("2. A"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.A);
		if(tipoFactura.equals("3. B"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.B);
		if(tipoFactura.equals("4. C"))
			cliente.setTipoFactura(modelo.Cliente.TIPO_FACTURA.C);

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

		if (estado.equals("ACTIVO"))
			cliente.setEstado(modelo.Cliente.ESTADO.ACTIVO);
		if (estado.equals("INACTIVO"))
			cliente.setEstado(modelo.Cliente.ESTADO.INACTIVO);

		for (Cochera cochera : listCocheras){
			cochera.setCliente(cliente);
		}
		cliente.setCocheras(listCocheras);
		cliente.setPersonasAutorizadasARetirar(listPersonasAutorizadas);
		cliente.setVehiculos(listVehiculos);

		long idCliente = DAOCliente.getInstance().actualizar(cliente);

	}

	public ArrayList<Ticket> getTicketsCobradosTarjeta(Date fechaDesde, Date fechaHasta) {
		ArrayList<Ticket> ticketsTarjeta = new ArrayList<Ticket>();
		ticketsTarjeta = DAOTicket.getInstance().getTicketsTarjeta(fechaDesde, fechaHasta);
		return ticketsTarjeta;
	}

	public double exportarTicketsAbonadosTarjeta(ArrayList<Ticket> ticketsTarjeta) {
		double codigoReturn = -1;

		Date fecha= GregorianCalendar.getInstance().getTime();
		ArrayList<String> ticketsTarjetaImprimir = new ArrayList<String>();
		ticketsTarjetaImprimir.add("Fecha;Numero Ticket;Monto");

		for(Ticket ticketActual : ticketsTarjeta)
		{
			ticketsTarjetaImprimir.add(ticketActual.getFechaSalida()+";"+ ticketActual.getIdTicket()+";"+ticketActual.getMontoCobrado());

		}

		Excel excel = new Excel();
		File theDir = new File("C:\\SIGE\\TicketsTarjeta\\");
		if (!theDir.exists())
		{ 
			boolean result = theDir.mkdirs();    
		}
		String path= "'"+theDir.getPath()+"\\";
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
		Date date = new Date(); 
		excel.setOutputFile(theDir+"\\TicketsTarjeta_"+new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(fecha)+".xls");

		try {
			excel.writeList(ticketsTarjetaImprimir);
			codigoReturn=1;
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codigoReturn;

	}

	public long eliminarTickets(Date fechaDesde, Date fechaHasta) {
		long codReturn= -1;
		codReturn=HibernateDAO.getInstancia().eliminarTickets(fechaDesde, fechaHasta);

		return codReturn;
	}

	public ArrayList<Cochera> getCocheras() {

		return DAOCochera.getInstance().getCocheras();

	}

}