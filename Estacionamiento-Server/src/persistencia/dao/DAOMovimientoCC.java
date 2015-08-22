package persistencia.dao;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.Cliente;

public class DAOMovimientoCC {

	private static DAOMovimientoCC ins = null;

	public static DAOMovimientoCC getInstance(){
		if (ins == null) ins = new DAOMovimientoCC();

		return ins;
	}

	public long persistir(modelo.MovimientoCC MovimientoCCM) {
		persistencia.clases.MovimientoCC MovimientoCCP = new persistencia.clases.MovimientoCC();
		MovimientoCCP=Converter.convertMovimientoCuentaCorrienteModeloToPersistencia(MovimientoCCM);
		HibernateDAO.getInstancia().save(MovimientoCCP);
		MovimientoCCM.setIdMovimiento(MovimientoCCP.getIdMovimiento());
		return MovimientoCCP.getIdMovimiento();
	}
}
