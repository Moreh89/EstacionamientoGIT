package persistencia.dao;
import java.util.ArrayList;

import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.Interes;
import persistencia.clases.TasaInteres;

public class DAOInteres {

	private static DAOInteres ins = null;

	public static DAOInteres  getInstance(){
		if (ins == null) ins = new DAOInteres();

		return ins;
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Interes> getIntereses()
	{
		ArrayList<modelo.Interes> interesesM = new ArrayList<modelo.Interes>();
		ArrayList<persistencia.clases.Interes> interesesP=new ArrayList<persistencia.clases.Interes>();
		interesesP=(ArrayList<Interes>) HibernateDAO.getInstancia().getList("Interes");
		interesesM=Converter.convertInteresesPersistenciaToModelo(interesesP);
		return interesesM;
	}

}
