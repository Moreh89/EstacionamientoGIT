package persistencia.dao;
import java.util.ArrayList;
import java.util.List;

import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.Tarifa;

public class DAOTarifa {

	private static DAOTarifa ins = null;

	public static DAOTarifa getInstance(){
		if (ins == null) ins = new DAOTarifa();

		return ins;
	}

	public long persistir(modelo.Tarifa tarifaM) {
		persistencia.clases.Tarifa tarifaP = new persistencia.clases.Tarifa();
		tarifaP=Converter.convertTarifaModeloToPersistencia(tarifaM);
		tarifaP = (Tarifa) HibernateDAO.getInstancia().save(tarifaP);
		return tarifaP.getIdTarifa();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Tarifa> getTarifas(){
		List<Tarifa> tarifasP = (List<Tarifa>) HibernateDAO.getInstancia().getList("Tarifa");
		ArrayList<modelo.Tarifa> tarifasM = new ArrayList<modelo.Tarifa>();
		for (Tarifa tarifaTemp : tarifasP) {
			tarifasM.add(Converter.convertTarifaPersistenciaToModelo(tarifaTemp));
		}
		return tarifasM;
	}

}
