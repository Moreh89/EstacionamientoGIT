package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.Cliente;

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
		
		clienteP=(persistencia.clases.Cliente) HibernateDAO.getInstancia().get(persistencia.clases.Cliente.class, idCliente);
		
		
		clienteP.getCuentaCorriente().addMovimientoCC(movimientoNuevoP);
		
		clienteP=(Cliente) HibernateDAO.getInstancia().update(clienteP);
		
		codigoReturn=clienteP.getIdCliente();		
		return codigoReturn;
	}
	


}
