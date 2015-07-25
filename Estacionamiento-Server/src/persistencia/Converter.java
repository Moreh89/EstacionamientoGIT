package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import modelo.Ticket;
import modelo.Usuario;
import modelo.Usuario.PERMISOS;
import modelo.Vehiculo;
import persistencia.clases.*;
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

//revisar porque Cliente trae Strings, no trabaja con la clase PersonaAutorizada.
		
//		List<persistencia.clases.PersonaAutorizada> personasAutorizadasARetirarP = new ArrayList<persistencia.clases.PersonaAutorizada>();
//		for (modelo.PersonaAutorizada personasAutorizadasARetirarM : clienteM.getPersonasAutorizadasARetirar()) {
//			personasAutorizadasARetirarP.add(convertPersonaAutorizadaModeloToPersistencia(personasAutorizadasARetirarM));
//		}
//		personasAutorizadasARetirarP.setMovimientos(personasAutorizadasARetirarP);
		
//TODO		
		
		List<persistencia.clases.Cochera> cocherasP = new ArrayList<persistencia.clases.Cochera>();
		for (modelo.Cochera cocheraM : clienteM.getCocheras()) {
			cocherasP.add(convertCocheraModeloToPersistencia(cocheraM));
		}
		clienteP.setCocheras(cocherasP);

		List<persistencia.clases.Vehiculo> vehiculosP = new ArrayList<persistencia.clases.Vehiculo>();
		for (modelo.Vehiculo vehiculoM : clienteM.getVehiculos()) {
			vehiculosP.add(convertVehiculoModeloToPersistencia(vehiculoM));
		}
		clienteP.setVehiculos(vehiculosP);
		

		return clienteP;
	}

	



	public static modelo.Cliente convertClienteModeloToPersistencia (persistencia.clases.Cliente clienteP)
	{
		modelo.Cliente clienteM = new modelo.Cliente();

		clienteM.setCorreoElectronico(clienteP.getCorreoElectronico());
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

//revisar porque Cliente trae Strings, no trabaja con la clase PersonaAutorizada.
		
//		List<persistencia.clases.PersonaAutorizada> personasAutorizadasARetirarP = new ArrayList<persistencia.clases.PersonaAutorizada>();
//		for (modelo.PersonaAutorizada personasAutorizadasARetirarM : clienteM.getPersonasAutorizadasARetirar()) {
//			personasAutorizadasARetirarP.add(convertPersonaAutorizadaModeloToPersistencia(personasAutorizadasARetirarM));
//		}
//		personasAutorizadasARetirarP.setMovimientos(personasAutorizadasARetirarP);
		
//TODO		
		
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


	public static persistencia.clases.CuentaCorriente convertCuentaCorrienteModeloToPersistencia (modelo.CuentaCorriente cuentaCorrienteM)
	{
		persistencia.clases.CuentaCorriente cuentaCorrienteP = new persistencia.clases.CuentaCorriente();

		cuentaCorrienteP.setIdCuentaCorriente(cuentaCorrienteM.getIdCuentaCorriente());
		
		List<persistencia.clases.MovimientoCC> movimientosCCP = new ArrayList<persistencia.clases.MovimientoCC>();
		for (modelo.MovimientoCC movimientoCCM : cuentaCorrienteM.getMovimientos()) {
			movimientosCCP.add(convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoCCM));
		}
		cuentaCorrienteP.setMovimientos(movimientosCCP);

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
		movimientoCCP.setTicket(convertTicketModeloToPersistencia(movimientoCCM.getTicket()));


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



	private static persistencia.clases.Ticket convertTicketModeloToPersistencia(modelo.Ticket ticketM) {
		persistencia.clases.Ticket ticketP= new persistencia.clases.Ticket();
		//TODO		
		return ticketP;
	}

	private static modelo.Ticket convertTicketPersistenciaToModelo(persistencia.clases.Ticket ticketP) {
		modelo.Ticket ticketM=new modelo.Ticket();
		// TODO Auto-generated method stub
		return ticketM;
	}

	private static persistencia.clases.Cochera convertCocheraModeloToPersistencia(modelo.Cochera cocheraM) {
		persistencia.clases.Cochera cocheraP = new persistencia.clases.Cochera();
		
		cocheraP.setCosto(cocheraM.getCosto());
		cocheraP.setCostoCochera(cocheraM.getCostoCochera());
		cocheraP.setIdCochera(cocheraM.getIdCochera());
		
		String estadoCochera=cocheraM.getEstado().toString();
		if(estadoCochera.equals("ACTIVO"))
			cocheraP.setEstado(persistencia.clases.Cochera.ESTADO.ACTIVO);
		if(estadoCochera.equals("INACTIVO"))
			cocheraP.setEstado(persistencia.clases.Cochera.ESTADO.INACTIVO);

//TODO - Revisar porque se vuelve ciclico
		cocheraP.setCliente(null);
		
		return cocheraP;
	}
	
	private static modelo.Cochera convertCocheraPersistenciaToModelo(persistencia.clases.Cochera cocheraP) {
		modelo.Cochera cocheraM = new modelo.Cochera();
		
		cocheraM.setCosto(cocheraP.getCosto());
		cocheraM.setCostoCochera(cocheraP.getCostoCochera());
		cocheraM.setIdCochera(cocheraP.getIdCochera());
		
		String estadoCochera=cocheraP.getEstado().toString();
		if(estadoCochera.equals("ACTIVO"))
			cocheraM.setEstado(modelo.Cochera.ESTADO.ACTIVO);
		if(estadoCochera.equals("INACTIVO"))
			cocheraM.setEstado(modelo.Cochera.ESTADO.INACTIVO);

//TODO - Revisar porque se vuelve ciclico
		cocheraM.setCliente(null);
		
		return cocheraM;
	}

	
	
}
