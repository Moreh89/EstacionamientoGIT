package persistencia;

import java.util.ArrayList;
import java.util.List;
import modelo.CategoriaVehiculo;
import modelo.ColorVehiculo;
import modelo.ModeloVehiculo;
import modelo.Usuario;
import modelo.Usuario.PERMISOS;
import modelo.Vehiculo;
import persistencia.clases.Cliente.ESTADO;
import persistencia.clases.Cliente.TIPO_CLIENTE;
import persistencia.clases.Cliente.TIPO_DOC;

public class Converter {

	public static modelo.Usuario convertUsuarioPersistenciaToModelo(persistencia.clases.Usuario usuarioPersistencia)
	{
		Usuario usuarioModelo=new modelo.Usuario();

		usuarioModelo.setIdUsuario(usuarioPersistencia.getIdUsuario());
		usuarioModelo.setUserName(usuarioPersistencia.getUserName());
		usuarioModelo.setPassword(usuarioPersistencia.getPassword());

		String permisoPersistencia=usuarioPersistencia.getPermisos().toString();
		if(permisoPersistencia.equals("ADMIN"))
			usuarioModelo.setPermisos(PERMISOS.ADMIN);
		if(permisoPersistencia.equals("CAJA"))
			usuarioModelo.setPermisos(PERMISOS.CAJA);


		usuarioModelo.setNombre(usuarioPersistencia.getNombre());
		usuarioModelo.setApellido(usuarioPersistencia.getApellido());
		usuarioModelo.setTipoDocumento(usuarioPersistencia.getTipoDocumento());
		usuarioModelo.setNumeroDocumento(usuarioPersistencia.getNumeroDocumento());
		return usuarioModelo;
	}

	public static persistencia.clases.Usuario convertUsuarioModeloToPersistencia(Usuario usuarioM) 
	{
		persistencia.clases.Usuario usuarioP=new persistencia.clases.Usuario();

		usuarioP.setIdUsuario(usuarioM.getIdUsuario());
		usuarioP.setUserName(usuarioM.getUserName());
		usuarioP.setPassword(usuarioM.getPassword());

		String permisoModelo=usuarioM.getPermisos().toString();
		if(permisoModelo.equals("ADMIN"))
			usuarioP.setPermisos(persistencia.clases.Usuario.PERMISOS.ADMIN);
		if(permisoModelo.equals("CAJA"))
			usuarioP.setPermisos(persistencia.clases.Usuario.PERMISOS.CAJA);


		usuarioP.setNombre(usuarioM.getNombre());
		usuarioP.setApellido(usuarioM.getApellido());
		usuarioP.setTipoDocumento(usuarioM.getTipoDocumento());
		usuarioP.setNumeroDocumento(usuarioM.getNumeroDocumento());


		return usuarioP;
	}

	public static persistencia.clases.Vehiculo convertVehiculoModeloToPersistencia (Vehiculo vehiculoM)
	{
		persistencia.clases.Vehiculo vehiculoP = new persistencia.clases.Vehiculo();
		vehiculoP.setIdVehiculo(vehiculoM.getIdVehiculo());
		vehiculoP.setPatente(vehiculoM.getPatente());
		vehiculoP.setCategoria(convertCategoriaVehiculoModeloToPersistencia(vehiculoM.getCategoria()));
		vehiculoP.setModelo(convertModeloVehiculoModeloToPersistencia(vehiculoM.getModelo()));
		vehiculoP.setColor(convertColorModeloToPersistencia(vehiculoM.getColor()));;
		vehiculoP.setComentario(vehiculoM.getComentario());
		return vehiculoP;
	}

	public static Vehiculo convertVehiculoPersistenciaToModelo (persistencia.clases.Vehiculo vehiculoP)
	{
		modelo.Vehiculo vehiculoM = new modelo.Vehiculo();
		vehiculoM.setIdVehiculo(vehiculoP.getIdVehiculo());
		vehiculoM.setPatente(vehiculoP.getPatente());
		vehiculoM.setCategoria(convertCategoriaVehiculoPersistenciaToModelo(vehiculoP.getCategoria()));
		vehiculoM.setModelo(convertModeloVehiculoPersistenciaToModelo(vehiculoP.getModelo()));
		vehiculoM.setColor(convertColorPersistenciaToModelo(vehiculoP.getColor()));
		vehiculoM.setComentario(vehiculoP.getComentario());
		return vehiculoM;
	}

	public static persistencia.clases.CategoriaVehiculo convertCategoriaVehiculoModeloToPersistencia (modelo.CategoriaVehiculo categoriaM)
	{
		persistencia.clases.CategoriaVehiculo categoriaP = new persistencia.clases.CategoriaVehiculo();

		categoriaP.setIdCategoria(categoriaM.getIdCategoria());
		categoriaP.setDescripcion(categoriaM.getDescripcion());

		return categoriaP;

	}

	public static modelo.CategoriaVehiculo convertCategoriaVehiculoPersistenciaToModelo (persistencia.clases.CategoriaVehiculo categoriaP)
	{

		modelo.CategoriaVehiculo categoriaM=new modelo.CategoriaVehiculo();
		categoriaM.setDescripcion(categoriaP.getDescripcion());
		categoriaM.setIdCategoria(categoriaP.getIdCategoria());
		return categoriaM;

	}

	public static persistencia.clases.ModeloVehiculo convertModeloVehiculoModeloToPersistencia (modelo.ModeloVehiculo modeloVehiculoM)
	{
		persistencia.clases.ModeloVehiculo modeloVehiculoP = new persistencia.clases.ModeloVehiculo();

		modeloVehiculoP.setIdModelo(modeloVehiculoM.getIdModelo());
		modeloVehiculoP.setDescripcion(modeloVehiculoM.getDescripcion());
		return modeloVehiculoP;
	}
	public static modelo.ModeloVehiculo convertModeloVehiculoPersistenciaToModelo (persistencia.clases.ModeloVehiculo modeloVehiculoP)
	{
		modelo.ModeloVehiculo modeloVehiculoM = new modelo.ModeloVehiculo();
		modeloVehiculoM.setDescripcion(modeloVehiculoP.getDescripcion());
		modeloVehiculoM.setIdModelo(modeloVehiculoP.getIdModelo());
		return modeloVehiculoM;
	}

	public static persistencia.clases.ColorVehiculo convertColorModeloToPersistencia (modelo.ColorVehiculo colorVehiculoM)
	{
		persistencia.clases.ColorVehiculo colorVehiculoP = new persistencia.clases.ColorVehiculo();
		colorVehiculoP.setDescripcion(colorVehiculoM.getDescripcion());
		colorVehiculoP.setIdColor(colorVehiculoM.getIdColor());

		return colorVehiculoP;
	}

	public static modelo.ColorVehiculo convertColorPersistenciaToModelo (persistencia.clases.ColorVehiculo colorVehiculoP)
	{
		modelo.ColorVehiculo colorVehiculoM = new modelo.ColorVehiculo();
		colorVehiculoM.setDescripcion(colorVehiculoP.getDescripcion());
		colorVehiculoM.setIdColor(colorVehiculoP.getIdColor());

		return colorVehiculoM;
	}

	public static persistencia.clases.Cliente convertClienteModeloToPersistencia (modelo.Cliente clienteM)
	{
		persistencia.clases.Cliente clienteP = new persistencia.clases.Cliente();

		clienteP.setCorreoElectronico(clienteM.getCorreoElectronico());
		clienteP.setCuil(clienteM.getCuil());
		clienteP.setIdCliente(clienteM.getIdCliente());
		clienteP.setNombre(clienteM.getNombre());
		clienteP.setApellido(clienteM.getApellido());
		clienteP.setNumeroDocumento(clienteM.getNumeroDocumento());
		clienteP.setDescripcion(clienteM.getDescripcion());
		clienteP.setDireccion(clienteM.getDireccion());
		clienteP.setDireccion2(clienteM.getDireccion2());
		clienteP.setTelefono1(clienteM.getTelefono1());
		clienteP.setTelefono2(clienteM.getTelefono2());
		clienteP.setRazonSocial(clienteM.getRazonSocial());

		String tipoDoc=clienteM.getTipoDocumento().toString();
		if(tipoDoc.equals("DNI"))
			clienteP.setTipoDocumento(TIPO_DOC.DNI);
		if(tipoDoc.equals("LU"))
			clienteP.setTipoDocumento(TIPO_DOC.LU);
		if(tipoDoc.equals("PASS"))
			clienteP.setTipoDocumento(TIPO_DOC.PASS);
		if(tipoDoc.equals("OTRO"))
			clienteP.setTipoDocumento(TIPO_DOC.OTRO);

		String tipoCliente=clienteM.getTipoCliente().toString();
		if(tipoCliente.equals("FIJO_PERSONA"))
			clienteP.setTipoCliente(TIPO_CLIENTE.FIJO_PERSONA);
		if(tipoCliente.equals("FIJO_EMPRESA"))
			clienteP.setTipoCliente(TIPO_CLIENTE.FIJO_EMPRESA);
		if(tipoCliente.equals("TEMPORAL"))
			clienteP.setTipoCliente(TIPO_CLIENTE.TEMPORAL);

		String estadoCliente=clienteM.getEstado().toString();
		if(estadoCliente.equals("ACTIVO"))
			clienteP.setEstado(ESTADO.ACTIVO);
		if(estadoCliente.equals("INACTIVO"))
			clienteP.setEstado(ESTADO.INACTIVO);

		if(clienteM.getCuentaCorriente()!=null)
		{
			persistencia.clases.CuentaCorriente cCP = new persistencia.clases.CuentaCorriente();
			cCP = convertCuentaCorrienteModeloToPersistencia(clienteM.getCuentaCorriente());
			clienteP.setCuentaCorriente(cCP);
		}

		if(clienteM.getPersonasAutorizadasARetirar()!=null)

		{
			List<persistencia.clases.PersonaAutorizada> personasAutorizadasARetirarP = new ArrayList<persistencia.clases.PersonaAutorizada>();

			for (modelo.PersonaAutorizada personasAutorizadasARetirarM : clienteM.getPersonasAutorizadasARetirar()) {
				personasAutorizadasARetirarP.add(convertPersonaAutorizadaModeloToPersistencia(personasAutorizadasARetirarM));
			}
			clienteP.setPersonasAutorizadasARetirar(personasAutorizadasARetirarP);
		}

		if(clienteM.getCocheras()!=null)
		{
			List<persistencia.clases.Cochera> cocherasP = new ArrayList<persistencia.clases.Cochera>();

			for (modelo.Cochera cocheraM : clienteM.getCocheras()) {
				cocherasP.add(convertCocheraModeloToPersistencia(cocheraM));
			}
			clienteP.setCocheras(cocherasP);
		}

		if(clienteM.getVehiculos()!=null)
		{
			List<persistencia.clases.Vehiculo> vehiculosP = new ArrayList<persistencia.clases.Vehiculo>();
			for (modelo.Vehiculo vehiculoM : clienteM.getVehiculos()) {
				vehiculosP.add(convertVehiculoModeloToPersistencia(vehiculoM));
			}
			clienteP.setVehiculos(vehiculosP);
		}

		return clienteP;
	}





	public static modelo.Cliente convertClientePersistenciaToModelo (persistencia.clases.Cliente clienteP)
	{
		modelo.Cliente clienteM = new modelo.Cliente();

		if (clienteP.getCorreoElectronico() != null )clienteM.setCorreoElectronico(clienteP.getCorreoElectronico());
		clienteM.setCuil(clienteP.getCuil());
		clienteM.setIdCliente(clienteP.getIdCliente());
		clienteM.setNombre(clienteP.getNombre());
		clienteM.setApellido(clienteP.getApellido());
		clienteM.setNumeroDocumento(clienteP.getNumeroDocumento());
		clienteM.setDescripcion(clienteP.getDescripcion());
		clienteM.setDireccion(clienteP.getDireccion());
		clienteM.setDireccion2(clienteP.getDireccion2());
		clienteM.setTelefono1(clienteP.getTelefono1());
		clienteM.setTelefono2(clienteP.getTelefono2());
		clienteM.setRazonSocial(clienteP.getRazonSocial());

		String tipoDoc=clienteP.getTipoDocumento().toString();
		if(tipoDoc.equals("DNI"))
			clienteM.setTipoDocumento(modelo.Cliente.TIPO_DOC.DNI);
		if(tipoDoc.equals("LU"))
			clienteM.setTipoDocumento(modelo.Cliente.TIPO_DOC.LU);
		if(tipoDoc.equals("PASS"))
			clienteM.setTipoDocumento(modelo.Cliente.TIPO_DOC.PASS);
		if(tipoDoc.equals("OTRO"))
			clienteM.setTipoDocumento(modelo.Cliente.TIPO_DOC.OTRO);

		String tipoCliente=clienteP.getTipoCliente().toString();
		if(tipoCliente.equals("FIJO_PERSONA"))
			clienteM.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.FIJO_PERSONA);
		if(tipoCliente.equals("FIJO_EMPRESA"))
			clienteM.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.FIJO_EMPRESA);
		if(tipoCliente.equals("TEMPORAL"))
			clienteM.setTipoCliente(modelo.Cliente.TIPO_CLIENTE.TEMPORAL);

		String estadoCliente=clienteP.getEstado().toString();
		if(estadoCliente.equals("ACTIVO"))
			clienteM.setEstado(modelo.Cliente.ESTADO.ACTIVO);
		if(estadoCliente.equals("INACTIVO"))
			clienteM.setEstado(modelo.Cliente.ESTADO.INACTIVO);

		if(clienteP.getCuentaCorriente()!=null)
		{
			modelo.CuentaCorriente cCM = new modelo.CuentaCorriente();
			cCM = convertCuentaCorrientePersistenciaToModelo(clienteP.getCuentaCorriente());
			clienteM.setCuentaCorriente(cCM);
		}

		List<modelo.PersonaAutorizada> personasAutorizadasARetirarM = new ArrayList<modelo.PersonaAutorizada>();
		for (persistencia.clases.PersonaAutorizada personasAutorizadasARetirarP : clienteP.getPersonasAutorizadasARetirar()) {
			personasAutorizadasARetirarM.add(convertPersonaAutorizadaPersistenciaToModelo(personasAutorizadasARetirarP));
		}
		clienteM.setPersonasAutorizadasARetirar(personasAutorizadasARetirarM);

		List<modelo.Cochera> cocherasM = new ArrayList<modelo.Cochera>();
		for (persistencia.clases.Cochera cocheraP : clienteP.getCocheras()) {
			cocherasM.add(convertCocheraPersistenciaToModelo(cocheraP));
		}
		clienteM.setCocheras(cocherasM);

		List<modelo.Vehiculo> vehiculosM = new ArrayList<modelo.Vehiculo>();
		for (persistencia.clases.Vehiculo vehiculoP : clienteP.getVehiculos()) {
			vehiculosM.add(convertVehiculoPersistenciaToModelo(vehiculoP));
		}
		clienteM.setVehiculos(vehiculosM);

		return clienteM;
	}


	public  static modelo.PersonaAutorizada convertPersonaAutorizadaPersistenciaToModelo(persistencia.clases.PersonaAutorizada personasAutorizadaP) {
		modelo.PersonaAutorizada personaAutorizadaM = new modelo.PersonaAutorizada();
		personaAutorizadaM.setIdPersonaAut(personasAutorizadaP.getIdPersonaAut());
		personaAutorizadaM.setNombre(personasAutorizadaP.getNombre());

		return personaAutorizadaM;
	}

	public static persistencia.clases.PersonaAutorizada convertPersonaAutorizadaModeloToPersistencia (modelo.PersonaAutorizada personasAutorizadaM) {
		persistencia.clases.PersonaAutorizada personaAutorizadaP = new persistencia.clases.PersonaAutorizada();
		personaAutorizadaP.setIdPersonaAut(personasAutorizadaM.getIdPersonaAut());
		personaAutorizadaP.setNombre(personasAutorizadaM.getNombre());

		return personaAutorizadaP;
	}


	public static persistencia.clases.CuentaCorriente convertCuentaCorrienteModeloToPersistencia (modelo.CuentaCorriente cuentaCorrienteM)
	{
		persistencia.clases.CuentaCorriente cuentaCorrienteP = new persistencia.clases.CuentaCorriente();

		cuentaCorrienteP.setIdCuentaCorriente(cuentaCorrienteM.getIdCuentaCorriente());

		List<persistencia.clases.MovimientoCC> movimientosCCP = new ArrayList<persistencia.clases.MovimientoCC>();
		if(cuentaCorrienteM.getMovimientos()!=null)
		{
			for (modelo.MovimientoCC movimientoCCM : cuentaCorrienteM.getMovimientos()) {
				movimientosCCP.add(convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoCCM));
			}
			cuentaCorrienteP.setMovimientos(movimientosCCP);
		}
		return cuentaCorrienteP;

	}

	public static modelo.CuentaCorriente convertCuentaCorrientePersistenciaToModelo (persistencia.clases.CuentaCorriente cuentaCorrienteP)
	{
		modelo.CuentaCorriente cuentaCorrienteM = new modelo.CuentaCorriente();

		cuentaCorrienteM.setIdCuentaCorriente(cuentaCorrienteP.getIdCuentaCorriente());
		List<modelo.MovimientoCC> movimientosCCM = new ArrayList<modelo.MovimientoCC>();

		for (persistencia.clases.MovimientoCC movimientoCCP : cuentaCorrienteP.getMovimientos()) {
			movimientosCCM.add(convertMovimientoCuentaCorrientePersistenciaToModelo(movimientoCCP));
		}
		cuentaCorrienteM.setMovimientos(movimientosCCM);

		return cuentaCorrienteM;
	}

	public static persistencia.clases.MovimientoCC convertMovimientoCuentaCorrienteModeloToPersistencia (modelo.MovimientoCC movimientoCCM)
	{
		persistencia.clases.MovimientoCC movimientoCCP = new persistencia.clases.MovimientoCC();

		movimientoCCP.setIdMovimiento(movimientoCCM.getIdMovimiento());
		movimientoCCP.setFecha(movimientoCCM.getFecha());
		movimientoCCP.setDescripcion(movimientoCCM.getDescripcion());
		movimientoCCP.setMontoCobrado(movimientoCCM.getMontoCobrado());
		movimientoCCP.setEstado(movimientoCCM.getEstado());
		if(movimientoCCM.getTicket()!=null)
		{
			movimientoCCP.setTicket(convertTicketModeloToPersistencia(movimientoCCM.getTicket()));
		}

		return movimientoCCP;
	}



	public static modelo.MovimientoCC convertMovimientoCuentaCorrientePersistenciaToModelo (persistencia.clases.MovimientoCC movimientoCCP)
	{
		modelo.MovimientoCC movimientoCCM=new modelo.MovimientoCC();

		movimientoCCM.setIdMovimiento(movimientoCCP.getIdMovimiento());
		movimientoCCM.setEstado(movimientoCCP.getEstado());
		movimientoCCM.setFecha(movimientoCCP.getFecha());
		movimientoCCM.setIdMovimiento(movimientoCCP.getIdMovimiento());
		movimientoCCM.setMontoCobrado(movimientoCCP.getMontoCobrado());
		movimientoCCM.setTicket(convertTicketPersistenciaToModelo (movimientoCCP.getTicket()));

		return movimientoCCM;
	}



	public  static persistencia.clases.Ticket convertTicketModeloToPersistencia(modelo.Ticket ticketM) {
		persistencia.clases.Ticket ticketP= new persistencia.clases.Ticket();

		ticketP.setCatergoriaVehiculo(convertCategoriaVehiculoModeloToPersistencia(ticketM.getCatergoriaVehiculo()));
		if(ticketM.getCliente() != null) ticketP.setCliente(convertClienteModeloToPersistencia(ticketM.getCliente()));
		if(ticketM.getDescuento() != null) ticketP.setDescuento(convertDescuentoModeloToPersistencia(ticketM.getDescuento()));

		String estadoTicket=ticketM.getEstado().toString();
		if(estadoTicket.equals("ABIERTO"))
			ticketP.setEstado(persistencia.clases.Ticket.Estado.ABIERTO);
		if(estadoTicket.equals("PREPAGO"))
			ticketP.setEstado(persistencia.clases.Ticket.Estado.PREPAGO);
		if(estadoTicket.equals("CERRADO"))
			ticketP.setEstado(persistencia.clases.Ticket.Estado.CERRADO);

		ticketP.setFechaLlegada(ticketM.getFechaLlegada());
		ticketP.setFechaSalida(ticketM.getFechaSalida());
		ticketP.setIdTicket(ticketM.getIdTicket());
		ticketP.setModeloVehiculo(convertModeloVehiculoModeloToPersistencia(ticketM.getModeloVehiculo()));
		ticketP.setMontoCobrado(ticketM.getMontoCobrado());
		ticketP.setObservacion(ticketM.getObservacion());
		ticketP.setPrepago(ticketM.getPrepago());
		ticketP.setPatente(ticketM.getPatente());
		ticketP.setUsuario(convertUsuarioModeloToPersistencia(ticketM.getUsuario()));
		ticketP.setColor(convertColorModeloToPersistencia(ticketM.getColor()));

		return ticketP;
	}

	public static modelo.Ticket convertTicketPersistenciaToModelo(persistencia.clases.Ticket ticketP) {
		modelo.Ticket ticketM=new modelo.Ticket();

		ticketM.setCatergoriaVehiculo(convertCategoriaVehiculoPersistenciaToModelo(ticketP.getCatergoriaVehiculo()));
		if (ticketP.getCliente() != null) ticketM.setCliente(convertClientePersistenciaToModelo(ticketP.getCliente()));
		if (ticketP.getDescuento() != null) ticketM.setDescuento(convertDescuentoPersistenciaToModelo(ticketP.getDescuento()));

		String estadoTicket=ticketP.getEstado().toString();
		if(estadoTicket.equals("ABIERTO"))
			ticketM.setEstado(modelo.Ticket.Estado.ABIERTO);
		if(estadoTicket.equals("PREPAGO"))
			ticketM.setEstado(modelo.Ticket.Estado.PREPAGO);
		if(estadoTicket.equals("CERRADO"))
			ticketM.setEstado(modelo.Ticket.Estado.CERRADO);

		ticketM.setFechaLlegada(ticketP.getFechaLlegada());
		if (ticketP.getFechaSalida() != null) ticketM.setFechaSalida(ticketP.getFechaSalida());
		ticketM.setIdTicket(ticketP.getIdTicket());
		ticketM.setModeloVehiculo(convertModeloVehiculoPersistenciaToModelo(ticketP.getModeloVehiculo()));
		ticketM.setMontoCobrado(ticketP.getMontoCobrado());
		if (ticketP.getObservacion()!= null) ticketM.setObservacion(ticketP.getObservacion());
		ticketM.setPrepago(ticketP.getPrepago());
		ticketM.setPatente(ticketP.getPatente());
		ticketM.setUsuario(convertUsuarioPersistenciaToModelo(ticketP.getUsuario()));
		ticketM.setColor(convertColorPersistenciaToModelo(ticketP.getColor()));
		return ticketM;
	}

	public static persistencia.clases.Cochera convertCocheraModeloToPersistencia(modelo.Cochera cocheraM) {
		persistencia.clases.Cochera cocheraP = new persistencia.clases.Cochera();

		cocheraP.setPorcentajeExpensas(cocheraM.getPorcentajeExpensas());
		cocheraP.setCostoCochera(cocheraM.getCostoCochera());
		cocheraP.setIdCochera(cocheraM.getIdCochera());
		cocheraP.setUbicacion(cocheraM.getUbicacion());
		String estadoCochera=cocheraM.getEstado().toString();
		if(estadoCochera.equals("ACTIVO"))
			cocheraP.setEstado(persistencia.clases.Cochera.ESTADO.ACTIVO);
		if(estadoCochera.equals("INACTIVO"))
			cocheraP.setEstado(persistencia.clases.Cochera.ESTADO.INACTIVO);

		//TODO - Revisar porque se vuelve ciclico
		cocheraP.setCliente(null);

		return cocheraP;
	}

	public static modelo.Cochera convertCocheraPersistenciaToModelo(persistencia.clases.Cochera cocheraP) {
		modelo.Cochera cocheraM = new modelo.Cochera();

		cocheraM.setPorcentajeExpensas(cocheraP.getPorcentajeExpensas());
		cocheraM.setCostoCochera(cocheraP.getCostoCochera());
		cocheraM.setIdCochera(cocheraP.getIdCochera());
		cocheraM.setUbicacion(cocheraP.getUbicacion());
		String estadoCochera=cocheraP.getEstado().toString();
		if(estadoCochera.equals("ACTIVO"))
			cocheraM.setEstado(modelo.Cochera.ESTADO.ACTIVO);
		if(estadoCochera.equals("INACTIVO"))
			cocheraM.setEstado(modelo.Cochera.ESTADO.INACTIVO);

		//TODO - Revisar porque se vuelve ciclico
		cocheraM.setCliente(null);

		return cocheraM;
	}


	public static persistencia.clases.Tarifa convertTarifaModeloToPersistencia(modelo.Tarifa tarifaM) {
		persistencia.clases.Tarifa tarifaP = new persistencia.clases.Tarifa ();

		tarifaP.setIdTarifa(tarifaM.getIdTarifa());
		tarifaP.setCostoMinimo(tarifaM.getCostoMinimo());
		tarifaP.setCostoEstadia(tarifaM.getCostoEstadia());
		tarifaP.setCostoFraccion(tarifaM.getCostoFraccion());
		tarifaP.setCostoHora(tarifaM.getCostoHora());
		tarifaP.setCostoMediaEstadia(tarifaM.getCostoMediaEstadia());
		tarifaP.setTiempoEstadia_minuto(tarifaM.getTiempoEstadia_minuto());
		tarifaP.setTiempoFraccion(tarifaM.getTiempoFraccion());
		tarifaP.setTiempoMediaEstadia_minuto(tarifaM.getTiempoMediaEstadia_minuto());
		tarifaP.setTiempoMinimo(tarifaM.getTiempoMinimo());

		tarifaP.setCategoria(convertCategoriaVehiculoModeloToPersistencia(tarifaM.getCategoria()));

		return tarifaP;

	}
	public static modelo.Tarifa convertTarifaPersistenciaToModelo(persistencia.clases.Tarifa tarifaP) {

		modelo.Tarifa tarifaM=new modelo.Tarifa();

		tarifaM.setIdTarifa(tarifaP.getIdTarifa());
		tarifaM.setCostoMinimo(tarifaP.getCostoMinimo());
		tarifaM.setCostoEstadia(tarifaP.getCostoEstadia());
		tarifaM.setCostoFraccion(tarifaP.getCostoFraccion());
		tarifaM.setCostoHora(tarifaP.getCostoHora());
		tarifaM.setCostoMediaEstadia(tarifaP.getCostoMediaEstadia());
		tarifaM.setTiempoEstadia_minuto(tarifaP.getTiempoEstadia_minuto());
		tarifaM.setTiempoFraccion(tarifaP.getTiempoFraccion());
		tarifaM.setTiempoMediaEstadia_minuto(tarifaP.getTiempoMediaEstadia_minuto());
		tarifaM.setTiempoMinimo(tarifaP.getTiempoMinimo());

		tarifaM.setCategoria(convertCategoriaVehiculoPersistenciaToModelo(tarifaP.getCategoria()));

		return tarifaM;
	}

	public static persistencia.clases.Descuento convertDescuentoModeloToPersistencia(modelo.Descuento descuentoM) {

		persistencia.clases.Descuento descuentoP = new persistencia.clases.Descuento();

		descuentoP.setIdDescuento(descuentoM.getIdDescuento());
		descuentoP.setDescripcion(descuentoM.getDescripcion());
		descuentoP.setDescuento(descuentoM.getDescuento());

		return descuentoP;

	}
	public static modelo.Descuento convertDescuentoPersistenciaToModelo(persistencia.clases.Descuento descuentoP) {

		modelo.Descuento descuentoM = new modelo.Descuento();

		descuentoM.setIdDescuento(descuentoP.getIdDescuento());
		descuentoM.setDescripcion(descuentoP.getDescripcion());
		descuentoM.setDescuento(descuentoP.getDescuento());

		return descuentoM;
	}

	public static ArrayList<ColorVehiculo> convertColoresVehiculosPersistenciaToModelo(
			ArrayList<persistencia.clases.ColorVehiculo> coloresVehiculosP) {

		ArrayList<modelo.ColorVehiculo> coloresVehiculosM = new ArrayList<modelo.ColorVehiculo>();
		for(persistencia.clases.ColorVehiculo colorVehiculoP : coloresVehiculosP)
		{
			coloresVehiculosM.add(convertColorPersistenciaToModelo(colorVehiculoP));
		}
		return coloresVehiculosM;
	}



	public static ArrayList<ModeloVehiculo> convertModelosVehiculosPersistenciaToModelo(
			ArrayList<persistencia.clases.ModeloVehiculo> modelosVehiculosP) {

		ArrayList<modelo.ModeloVehiculo> modelosVehiculosM = new ArrayList<modelo.ModeloVehiculo>();
		for(persistencia.clases.ModeloVehiculo modeloVehiculoP : modelosVehiculosP)
		{
			modelosVehiculosM.add(convertModeloVehiculoPersistenciaToModelo(modeloVehiculoP));
		}
		return modelosVehiculosM;
	}

	public static ArrayList<CategoriaVehiculo> convertCategoriasVehiculosPersistenciaToModelo(ArrayList<persistencia.clases.CategoriaVehiculo> categoriasVehiculosP) 
	{
		ArrayList<modelo.CategoriaVehiculo> categoriasVehiculosM = new ArrayList<modelo.CategoriaVehiculo>();
		for(persistencia.clases.CategoriaVehiculo categoriaVehiculoP : categoriasVehiculosP)
		{
			categoriasVehiculosM.add(convertCategoriaVehiculoPersistenciaToModelo(categoriaVehiculoP));
		}
		return categoriasVehiculosM;
	}

	public static ArrayList<modelo.Descuento> convertDescuentosPersistenciaToModelo(
			ArrayList<persistencia.clases.Descuento> descuentosP) {

		ArrayList<modelo.Descuento> descuentosM = new ArrayList<modelo.Descuento>();
		for(persistencia.clases.Descuento descuentoP : descuentosP)
		{
			descuentosM.add(convertDescuentoPersistenciaToModelo(descuentoP));
		}
		return descuentosM;
	}

	public static persistencia.clases.TasaInteres convertTasaInteresModeloToPersistencia(modelo.TasaInteres tasaInteresM) {

		persistencia.clases.TasaInteres tasaInteresP = new persistencia.clases.TasaInteres();

		tasaInteresP.setIdTasaInteres(tasaInteresM.getIdTasaInteres());
		tasaInteresP.setMontoDescuento(tasaInteresM.getMontoDescuento());
		String estadoTasaInteres = tasaInteresM.getEstado().toString();

		if(estadoTasaInteres.equals("ACTIVO"))
			tasaInteresP.setEstado(persistencia.clases.TasaInteres.ESTADO.ACTIVO);
		if(estadoTasaInteres.equals("INACTIVO"))
			tasaInteresP.setEstado(persistencia.clases.TasaInteres.ESTADO.ACTIVO);


		return tasaInteresP;

	}
	public static modelo.TasaInteres convertTasaInteresPersistenciaToModelo(persistencia.clases.TasaInteres tasaInteresP) {

		modelo.TasaInteres tasaInteresM = new modelo.TasaInteres();
		tasaInteresM.setIdTasaInteres(tasaInteresP.getIdTasaInteres());
		tasaInteresM.setMontoDescuento(tasaInteresP.getMontoDescuento());

		String estadoTasaInteres = tasaInteresP.getEstado().toString();

		if(estadoTasaInteres.equals("ACTIVO"))
			tasaInteresM.setEstado(modelo.TasaInteres.ESTADO.ACTIVO);
		if(estadoTasaInteres.equals("INACTIVO"))
			tasaInteresM.setEstado(modelo.TasaInteres.ESTADO.ACTIVO);

		return tasaInteresM;
	}

	public static ArrayList<modelo.Cliente> convertClientesPersistenciaToModelo(
			ArrayList<persistencia.clases.Cliente> clientesP) {

		ArrayList<modelo.Cliente> clientesM = new ArrayList<modelo.Cliente>();
		for(persistencia.clases.Cliente clienteP : clientesP)
		{
			clientesM.add(convertClientePersistenciaToModelo(clienteP));
		}
		return clientesM;
	}
	public static ArrayList<persistencia.clases.Cliente> convertClientesModeloToPersistencia(
			ArrayList<modelo.Cliente> clientesM) {

		ArrayList<persistencia.clases.Cliente> clientesP = new ArrayList<persistencia.clases.Cliente>();
		for(modelo.Cliente clienteM : clientesM)
		{
			clientesP.add(convertClienteModeloToPersistencia(clienteM));
		}
		return clientesP;
	}

	public static ArrayList<persistencia.clases.MovimientoCC> convertMovimientosCuentaCorrienteModeloToPersistencia(
			ArrayList<modelo.MovimientoCC> movimientosCCM) {

		ArrayList<persistencia.clases.MovimientoCC> movimientosCCP = new ArrayList<persistencia.clases.MovimientoCC>();
		for(modelo.MovimientoCC movimientoCCM: movimientosCCM)
		{
			movimientosCCP.add(convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoCCM));
		}
		return movimientosCCP;
	}


	//	public static ArrayList<CategoriaVehiculo> convertCategoriasVehiculosPersistenciaToModelo(
	//			ArrayList<persistencia.clases.CategoriaVehiculo> categoriasVehiculosP) {
	//		ArrayList<modelo.CategoriaVehiculo> categoriasVehiculosM = new ArrayList<modelo.CategoriaVehiculo>();
	//		for(persistencia.clases.CategoriaVehiculo categoriaVehiculoP : categoriasVehiculosP)
	//		{
	//			categoriasVehiculosM.add(convertCategoriaVehiculoPersistenciaToModelo(categoriaVehiculoP));
	//		}
	//		return categoriasVehiculosM;
	//	}
}
