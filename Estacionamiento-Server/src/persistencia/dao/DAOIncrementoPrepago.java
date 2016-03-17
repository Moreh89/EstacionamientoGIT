package persistencia.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.IncrementoPrepago;


public class DAOIncrementoPrepago {

	private static DAOIncrementoPrepago ins = null;

	public static DAOIncrementoPrepago  getInstance(){
		if (ins == null) ins = new DAOIncrementoPrepago();

		return ins;
	}

	public long persistir(modelo.IncrementoPrepago incrementoPrepago)
	{
		persistencia.clases.IncrementoPrepago incrementoPrepagoP = Converter.convertIncrementoPrepagoModeloToPersistencia(incrementoPrepago);
		long codigoReturn = -1;
		incrementoPrepagoP = (IncrementoPrepago) HibernateDAO.getInstancia().save(incrementoPrepagoP);
		codigoReturn = incrementoPrepagoP.getIdIncremento();
		return codigoReturn;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<modelo.IncrementoPrepago> getIncrementos(long idUsuario, Date fechaInicio, Date fechaFin)
	{
		ArrayList<modelo.IncrementoPrepago> interesesM = new ArrayList<modelo.IncrementoPrepago>();
		ArrayList<persistencia.clases.IncrementoPrepago> interesesP=new ArrayList<persistencia.clases.IncrementoPrepago>();
		String fechaL = new SimpleDateFormat("MM-dd-yyyy").format(fechaInicio);
		fechaL = fechaL + " 00:00:00";
		String fechaS = new SimpleDateFormat("MM-dd-yyyy").format(fechaFin);
		fechaS = fechaS + " 23:59:59";
		if(idUsuario>0)
		interesesP=(ArrayList<IncrementoPrepago>) HibernateDAO.getInstancia().getListbetweenDates("IncrementoPrepago", "numeroUsuario", idUsuario, "fecha", fechaL, "fecha", fechaS);
		else
		interesesP=(ArrayList<IncrementoPrepago>) HibernateDAO.getInstancia().getListbetweenDates("IncrementoPrepago", "fecha", fechaL, "fecha", fechaS);
		
		for (IncrementoPrepago incrementoPrepago : interesesP) {
			interesesM.add(Converter.convertIncrementoPrepagoPersistenciaToModelo(incrementoPrepago));
		}
		return interesesM;
	}

}
