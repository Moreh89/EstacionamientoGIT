package persistencia.dao;
import java.util.ArrayList;
import java.util.List;

import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.LiquidacionExpensas;
import persistencia.clases.Tarifa;

public class DAOLiquidacionExpensas {

	private static DAOLiquidacionExpensas ins = null;

	public static DAOLiquidacionExpensas getInstance(){
		if (ins == null) ins = new DAOLiquidacionExpensas();

		return ins;
	}

	public long persistir(modelo.LiquidacionExpensas liquidacionM) {
		persistencia.clases.LiquidacionExpensas liquidacionP = new persistencia.clases.LiquidacionExpensas();
		liquidacionP=Converter.convertLiquidacionExpensasModeloToPersistencia(liquidacionM);
		liquidacionP = (LiquidacionExpensas) HibernateDAO.getInstancia().save(liquidacionP);
		return liquidacionP.getIdLiquidacionExpensas();
	}

}
