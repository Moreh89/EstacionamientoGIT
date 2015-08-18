package persistencia.dao;
import persistencia.Converter;
import persistencia.HibernateDAO;

public class DAOTarifa {

	private static DAOTarifa ins = null;

	public static DAOTarifa getInstance(){
		if (ins == null) ins = new DAOTarifa();

		return ins;
	}

	public long persistir(modelo.Tarifa tarifaM) {
		persistencia.clases.Tarifa tarifaP = new persistencia.clases.Tarifa();
		tarifaP=Converter.convertTarifaModeloToPersistencia(tarifaM);
		HibernateDAO.getInstancia().save(tarifaP);
		return 0;
	}

}
