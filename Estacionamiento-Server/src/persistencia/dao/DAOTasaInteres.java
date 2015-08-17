package persistencia.dao;
import modelo.Usuario;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.TasaInteres;

public class DAOTasaInteres {

	private static DAOTasaInteres ins = null;

	public static DAOTasaInteres getInstance(){
		if (ins == null) ins = new DAOTasaInteres();

		return ins;
	}

	public modelo.TasaInteres getTasaInteresActual() {
		
		persistencia.clases.TasaInteres tasaInteresP = (TasaInteres) HibernateDAO.getInstancia().getObjectWithInt("TasaInteres", "estado", 1);
		modelo.TasaInteres TasaInteresM = Converter.convertTasaInteresPersistenciaToModelo(tasaInteresP);
		
		return TasaInteresM;
	}
	
	public long persistir(modelo.TasaInteres tasaInteresM)
	{
		persistencia.clases.TasaInteres tasaInteresP = new persistencia.clases.TasaInteres();
		tasaInteresP=Converter.convertTasaInteresModeloToPersistencia(tasaInteresM);
		long codigoReturn = -1;
		tasaInteresP = (TasaInteres) HibernateDAO.getInstancia().save(tasaInteresP);
		codigoReturn = tasaInteresP.getIdTasaInteres();
		return codigoReturn;
	}

	public long update(modelo.TasaInteres tasaInteresM)
	{
		persistencia.clases.TasaInteres tasaInteresP = new persistencia.clases.TasaInteres();
//		tasaInteresP=Converter.convertTasaInteresModeloToPersistencia(tasaInteresM);
		long codigoReturn = -1;
		tasaInteresP=(TasaInteres) HibernateDAO.getInstancia().getObjectWithLong("TasaInteres", "idTasaInteres", tasaInteresM.getIdTasaInteres());
		tasaInteresP.setEstado(persistencia.clases.TasaInteres.ESTADO.INACTIVO);
		tasaInteresP = (TasaInteres) HibernateDAO.getInstancia().update(tasaInteresP);
		codigoReturn = tasaInteresP.getIdTasaInteres();
		return codigoReturn;
	}
}
