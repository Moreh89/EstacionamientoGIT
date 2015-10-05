package persistencia.dao;
import java.util.ArrayList;
import java.util.List;

import modelo.Cochera;
import modelo.MovimientoCC;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.CategoriaVehiculo;
import persistencia.clases.Cliente;
import persistencia.clases.ColorVehiculo;
import persistencia.clases.Interes;
import persistencia.clases.LiquidacionAlquileres;
import persistencia.clases.LiquidacionExpensas;
import persistencia.clases.ModeloVehiculo;
import persistencia.clases.PersonaAutorizada;
import persistencia.clases.Vehiculo;

public class DAOCliente {

	private static DAOCliente ins = null;

	public static DAOCliente getInstance(){
		if (ins == null) ins = new DAOCliente();

		return ins;
	}

	public long persistir(modelo.Cliente clienteM) {
		persistencia.clases.Cliente clienteP = new persistencia.clases.Cliente();
		clienteP=Converter.convertClienteModeloToPersistencia(clienteM);
		HibernateDAO.getInstancia().save(clienteP);
		clienteM.setIdCliente(clienteP.getIdCliente());
		return clienteP.getIdCliente();
	}

	public Cliente getCliente(long idCliente) {
		persistencia.clases.Cliente cli = new persistencia.clases.Cliente();
		cli = (persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);
		return cli;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Cliente> getClientes() {
		ArrayList<modelo.Cliente> clientesReturn;
		ArrayList<persistencia.clases.Cliente> clientesP = new ArrayList<persistencia.clases.Cliente>();
		clientesP=(ArrayList<Cliente>) HibernateDAO.getInstancia().getList("Cliente");
		clientesReturn = Converter.convertClientesPersistenciaToModelo(clientesP);
		return clientesReturn;
	}

	public long agregarMovimientoCC(long idCliente, modelo.MovimientoCC movimientoNuevoM)
	{
		persistencia.clases.Cliente clienteP = new persistencia.clases.Cliente();
		long codigoReturn = -1;
		persistencia.clases.MovimientoCC movimientoNuevoP = new persistencia.clases.MovimientoCC();
		movimientoNuevoP = Converter.convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoNuevoM);
		persistencia.clases.Usuario usuTemp = DAOUsuario.getInstance().getUsuario(movimientoNuevoM.getUsuario().getIdUsuario());
		movimientoNuevoP.setUsuario(usuTemp);

		clienteP=(persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);
		clienteP.getCuentaCorriente().addMovimientoCC(movimientoNuevoP);
		clienteP=(Cliente) HibernateDAO.getInstancia().update(clienteP);

		codigoReturn=clienteP.getIdCliente();		
		return codigoReturn;
	}

	public long removerMovimientoCC(long idCliente,
			MovimientoCC movimientoActual) {
		persistencia.clases.Cliente clienteP = new persistencia.clases.Cliente();
		long codigoReturn = -1;
		persistencia.clases.MovimientoCC movimientoP = new persistencia.clases.MovimientoCC();
		movimientoP = Converter.convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoActual);

		clienteP=(persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);

		clienteP.getCuentaCorriente().removeMovimientoCC(movimientoP);

		clienteP=(Cliente) HibernateDAO.getInstancia().update(clienteP);

		codigoReturn=clienteP.getIdCliente();		
		return codigoReturn;		
	}

	public long agregarMovimientoCC_Interes(long idCliente, modelo.MovimientoCC movimientoNuevoM)
	{
		persistencia.clases.Cliente clienteP = new persistencia.clases.Cliente();
		long codigoReturn = -1;
		persistencia.clases.MovimientoCC movimientoNuevoP = new persistencia.clases.MovimientoCC();

		movimientoNuevoP = Converter.convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoNuevoM);

		clienteP=(persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);

		if(movimientoNuevoM.getInteres().getIdInteres()!=0)
		{
			movimientoNuevoP.setInteres((Interes) HibernateDAO.getInstancia().getObjectWithLong("Interes", "idInteres", movimientoNuevoM.getInteres().getIdInteres()));
		}
		movimientoNuevoP.setUsuario((persistencia.clases.Usuario) HibernateDAO.getInstancia().getObjectWithLong("Usuario", "idUsuario", movimientoNuevoM.getUsuario().getIdUsuario()));

		clienteP.getCuentaCorriente().addMovimientoCC(movimientoNuevoP);

		clienteP=(Cliente) HibernateDAO.getInstancia().update(clienteP);

		codigoReturn=clienteP.getCuentaCorriente().getMovimientos().get(clienteP.getCuentaCorriente().getMovimientos().size()-1).getInteres().getIdInteres();		
		return codigoReturn;
	}

	

	public double getEstadoCrediticio(modelo.Cliente clienteM) {
		double deuda=0;
		deuda=HibernateDAO.getInstancia().getEstadoCrediticio(clienteM.getCuentaCorriente().getIdCuentaCorriente());
		return deuda;
	}

	public modelo.Cliente getClienteModelo(long idCliente) {
		persistencia.clases.Cliente cli = new persistencia.clases.Cliente();
		cli = (persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);
		modelo.Cliente clienteM = new modelo.Cliente();
		clienteM=Converter.convertClientePersistenciaToModelo(cli);
		return clienteM;	
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Cliente> getClientesPropietarios() {
		ArrayList<modelo.Cliente> clientesReturn;
		ArrayList<persistencia.clases.Cliente> clientesP = new ArrayList<persistencia.clases.Cliente>();
		clientesP=(ArrayList<Cliente>) HibernateDAO.getInstancia().getListTwoInt("Cliente", "tipoCliente", 0, 3);
		clientesReturn = Converter.convertClientesPersistenciaToModelo(clientesP);
		return clientesReturn;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Cliente> getClientesInquilinos() {
		ArrayList<modelo.Cliente> clientesReturn;
		ArrayList<persistencia.clases.Cliente> clientesP = new ArrayList<persistencia.clases.Cliente>();
		clientesP=(ArrayList<Cliente>) HibernateDAO.getInstancia().getListTwoInt("Cliente", "tipoCliente", 1, 4);
		clientesReturn = Converter.convertClientesPersistenciaToModelo(clientesP);
		return clientesReturn;
	}
	public long agregarMovimientoCC_Expensas(long idCliente, modelo.MovimientoCC movimientoNuevoM)
	{
		persistencia.clases.Cliente clienteP = new persistencia.clases.Cliente();
		long codigoReturn = -1;
		persistencia.clases.MovimientoCC movimientoNuevoP = new persistencia.clases.MovimientoCC();
		movimientoNuevoP = Converter.convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoNuevoM);

		clienteP=(persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);
		if(movimientoNuevoM.getLiquidacionExpensas().getIdLiquidacionExpensas()!=0)
		{
			movimientoNuevoP.setLiquidacionExpensas((LiquidacionExpensas) HibernateDAO.getInstancia().getObjectWithLong("LiquidacionExpensas", "idLiquidacionExpensas", movimientoNuevoM.getLiquidacionExpensas().getIdLiquidacionExpensas()));
		}
		movimientoNuevoP.setUsuario((persistencia.clases.Usuario) HibernateDAO.getInstancia().getObjectWithLong("Usuario", "idUsuario", movimientoNuevoM.getUsuario().getIdUsuario()));


		clienteP.getCuentaCorriente().addMovimientoCC(movimientoNuevoP);

		clienteP=(Cliente) HibernateDAO.getInstancia().update(clienteP);
		codigoReturn=clienteP.getCuentaCorriente().getMovimientos().get(clienteP.getCuentaCorriente().getMovimientos().size()-1).getLiquidacionExpensas().getIdLiquidacionExpensas();

		return codigoReturn;
	}
	public long agregarMovimientoCC_Alquileres(long idCliente, modelo.MovimientoCC movimientoNuevoM)
	{
		persistencia.clases.Cliente clienteP = new persistencia.clases.Cliente();
		long codigoReturn = -1;
		persistencia.clases.MovimientoCC movimientoNuevoP = new persistencia.clases.MovimientoCC();
		movimientoNuevoP = Converter.convertMovimientoCuentaCorrienteModeloToPersistencia(movimientoNuevoM);
		if(movimientoNuevoM.getLiquidacionAlquileres().getIdLiquidacionAlquileres()!=0)
		{
			movimientoNuevoP.setLiquidacionAlquileres((LiquidacionAlquileres) HibernateDAO.getInstancia().getObjectWithLong("LiquidacionAlquileres", "idLiquidacionAlquileres", movimientoNuevoM.getLiquidacionAlquileres().getIdLiquidacionAlquileres()));
		}
		movimientoNuevoP.setUsuario((persistencia.clases.Usuario) HibernateDAO.getInstancia().getObjectWithLong("Usuario", "idUsuario", movimientoNuevoM.getUsuario().getIdUsuario()));
		clienteP=(persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);
		clienteP.getCuentaCorriente().addMovimientoCC(movimientoNuevoP);

		clienteP=(Cliente) HibernateDAO.getInstancia().update(clienteP);
		codigoReturn=clienteP.getCuentaCorriente().getMovimientos().get(clienteP.getCuentaCorriente().getMovimientos().size()-1).getLiquidacionAlquileres().getIdLiquidacionAlquileres();

		return codigoReturn;
	}

	public long actualizar(modelo.Cliente clienteM) {
		Cliente clienteP = (persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, clienteM.getIdCliente());
		
		clienteP.setNombre(clienteM.getNombre());
		clienteP.setApellido(clienteM.getApellido());
		clienteP.setTelefono1(clienteM.getTelefono1());
		clienteP.setTelefono2(clienteM.getTelefono2());
		clienteP.setDireccion(clienteM.getDireccion());
		clienteP.setDireccion2(clienteM.getDireccion2());
		clienteP.setCorreoElectronico(clienteM.getCorreoElectronico());
		clienteP.setRazonSocial(clienteM.getRazonSocial());
		clienteP.setCuil(clienteM.getCuil());
		clienteP.setDescripcion(clienteM.getDescripcion());

		if(clienteM.getTipoFactura() == modelo.Cliente.TIPO_FACTURA.NA)
			clienteP.setTipoFactura(persistencia.clases.Cliente.TIPO_FACTURA.NA);
		if(clienteM.getTipoFactura() == modelo.Cliente.TIPO_FACTURA.A)
			clienteP.setTipoFactura(persistencia.clases.Cliente.TIPO_FACTURA.A);
		if(clienteM.getTipoFactura() == modelo.Cliente.TIPO_FACTURA.B)
			clienteP.setTipoFactura(persistencia.clases.Cliente.TIPO_FACTURA.B);
		if(clienteM.getTipoFactura() == modelo.Cliente.TIPO_FACTURA.C)
			clienteP.setTipoFactura(persistencia.clases.Cliente.TIPO_FACTURA.C);

		if(clienteM.getTipoDocumento()==modelo.Cliente.TIPO_DOC.DNI)
			clienteP.setTipoDocumento(persistencia.clases.Cliente.TIPO_DOC.DNI);
		if(clienteM.getTipoDocumento()==modelo.Cliente.TIPO_DOC.LU)
			clienteP.setTipoDocumento(persistencia.clases.Cliente.TIPO_DOC.LU);
		if(clienteM.getTipoDocumento()==modelo.Cliente.TIPO_DOC.PASS)
			clienteP.setTipoDocumento(persistencia.clases.Cliente.TIPO_DOC.PASS);
		if(clienteM.getTipoDocumento()==modelo.Cliente.TIPO_DOC.OTRO)
			clienteP.setTipoDocumento(persistencia.clases.Cliente.TIPO_DOC.OTRO);

		clienteP.setNumeroDocumento(clienteM.getNumeroDocumento());

		if(clienteM.getTipoCliente()== modelo.Cliente.TIPO_CLIENTE.PARTICULAR_PROPIETARIO)
			clienteP.setTipoCliente(persistencia.clases.Cliente.TIPO_CLIENTE.PARTICULAR_PROPIETARIO);
		if(clienteM.getTipoCliente()== modelo.Cliente.TIPO_CLIENTE.PARTICULAR_INQUILINO)
			clienteP.setTipoCliente(persistencia.clases.Cliente.TIPO_CLIENTE.PARTICULAR_INQUILINO);
		if(clienteM.getTipoCliente()== modelo.Cliente.TIPO_CLIENTE.PARTICULAR_FRECUENTE)
			clienteP.setTipoCliente(persistencia.clases.Cliente.TIPO_CLIENTE.PARTICULAR_FRECUENTE);
		if(clienteM.getTipoCliente()== modelo.Cliente.TIPO_CLIENTE.EMPRESA_PROPIETARIO)
			clienteP.setTipoCliente(persistencia.clases.Cliente.TIPO_CLIENTE.EMPRESA_PROPIETARIO);
		if(clienteM.getTipoCliente()== modelo.Cliente.TIPO_CLIENTE.EMPRESA_INQUILINO)
			clienteP.setTipoCliente(persistencia.clases.Cliente.TIPO_CLIENTE.EMPRESA_INQUILINO);
		if(clienteM.getTipoCliente()== modelo.Cliente.TIPO_CLIENTE.EMPRESA_FRECUENTE)
			clienteP.setTipoCliente(persistencia.clases.Cliente.TIPO_CLIENTE.EMPRESA_FRECUENTE);

		if(clienteM.getEstado()==modelo.Cliente.ESTADO.ACTIVO)
		clienteP.setEstado(persistencia.clases.Cliente.ESTADO.ACTIVO);
		if(clienteM.getEstado()==modelo.Cliente.ESTADO.INACTIVO)
			clienteP.setEstado(persistencia.clases.Cliente.ESTADO.INACTIVO);
		
		List<persistencia.clases.Cochera> listCocheras = new ArrayList<persistencia.clases.Cochera>();
		
		for (Cochera cocheraM : clienteM.getCocheras()){
			//Nueva
			if(cocheraM.getIdCochera()==0){
				persistencia.clases.Cochera cocheraP = Converter.convertCocheraModeloToPersistencia(cocheraM);
				cocheraP.setCliente(clienteP);
				listCocheras.add(cocheraP);
			//las que ya tengo las actualizo
			}else{
				persistencia.clases.Cochera cocheraP = (persistencia.clases.Cochera) HibernateDAO.getInstancia().get(persistencia.clases.Cochera.class, cocheraM.getIdCochera());
				cocheraP.setCostoCochera(cocheraM.getCostoCochera());
				cocheraP.setPorcentajeExpensas(cocheraM.getPorcentajeExpensas());
				cocheraP.setUbicacion(cocheraM.getUbicacion());
				listCocheras.add(cocheraP);
			}
			//las que no esten es porque las borre
		}
		clienteP.setCocheras(listCocheras);
		
		
		List<PersonaAutorizada> listPersonasAutorizadas = new ArrayList<PersonaAutorizada>();
		for (modelo.PersonaAutorizada personaM : clienteM.getPersonasAutorizadasARetirar()){
			//Nueva
			if(personaM.getIdPersonaAut()==0){
				persistencia.clases.PersonaAutorizada personaP = Converter.convertPersonaAutorizadaModeloToPersistencia(personaM);
				listPersonasAutorizadas.add(personaP);
			//las que ya tengo las actualizo
			}else{
				persistencia.clases.PersonaAutorizada personaP = (persistencia.clases.PersonaAutorizada) HibernateDAO.getInstancia().get(persistencia.clases.PersonaAutorizada.class, personaM.getIdPersonaAut());
				personaP.setNombre(personaM.getNombre());
				listPersonasAutorizadas.add(personaP);
			}
			//las que no esten es porque las borre
		}
		clienteP.setPersonasAutorizadasARetirar(listPersonasAutorizadas);
		
		List<Vehiculo> listVehiculos = new ArrayList<Vehiculo>();
		for (modelo.Vehiculo vehiculoM : clienteM.getVehiculos()){
			//Nueva
			if(vehiculoM.getIdVehiculo()==0){
				persistencia.clases.Vehiculo vehiculoP = Converter.convertVehiculoModeloToPersistencia(vehiculoM);
				listVehiculos.add(vehiculoP);
			//los que ya tengo los actualizo
			}else{
				persistencia.clases.Vehiculo vehiculoP = (persistencia.clases.Vehiculo) HibernateDAO.getInstancia().get(persistencia.clases.Vehiculo.class, vehiculoM.getIdVehiculo());
				vehiculoP.setPatente(vehiculoM.getPatente());
				vehiculoP.setCategoria((CategoriaVehiculo) HibernateDAO.getInstancia().get(persistencia.clases.CategoriaVehiculo.class, vehiculoM.getCategoria().getIdCategoria()));
				vehiculoP.setColor((ColorVehiculo) HibernateDAO.getInstancia().get(persistencia.clases.ColorVehiculo.class, vehiculoM.getColor().getIdColor()));
				vehiculoP.setComentario(vehiculoM.getComentario());
				vehiculoP.setModelo((ModeloVehiculo) HibernateDAO.getInstancia().get(persistencia.clases.ModeloVehiculo.class, vehiculoM.getModelo().getIdModelo()));
				listVehiculos.add(vehiculoP);
			}
			//las que no esten es porque las borre
		}
		clienteP.setVehiculos(listVehiculos);

		HibernateDAO.getInstancia().update(clienteP);
		return clienteP.getIdCliente();
	}

}
