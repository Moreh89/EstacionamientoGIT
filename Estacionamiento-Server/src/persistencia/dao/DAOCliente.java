package persistencia.dao;
import persistencia.Converter;
import persistencia.HibernateDAO;

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

}
