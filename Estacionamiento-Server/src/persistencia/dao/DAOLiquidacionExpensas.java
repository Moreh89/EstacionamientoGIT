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

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.LiquidacionExpensas> getLiquidacionesRecientes() {
		//cantDias = Reciente
		int cantDias = 30;
		ArrayList<modelo.LiquidacionExpensas> liquidacionesRecientesM;
		ArrayList<persistencia.clases.LiquidacionExpensas> liquidacionesRecientesP = new ArrayList<persistencia.clases.LiquidacionExpensas>();
		liquidacionesRecientesP=(ArrayList<persistencia.clases.LiquidacionExpensas>) HibernateDAO.getInstancia().getListLiquidacionesDatediff("LiquidacionExpensas", "fechaEmision", cantDias);
		liquidacionesRecientesM = Converter.convertLiquidacionesExpensasPersistenciaToNegocio(liquidacionesRecientesP);
		
		return liquidacionesRecientesM;
	}

	public long anularLiquidacion(modelo.LiquidacionExpensas liquidacionSeleccionado) {
		long codigoReturn=-1;
		persistencia.clases.LiquidacionExpensas liquidacionP = new persistencia.clases.LiquidacionExpensas();
		liquidacionP= (LiquidacionExpensas) HibernateDAO.getInstancia().getObjectWithLong("LiquidacionExpensas", "idLiquidacionExpensas", liquidacionSeleccionado.getIdLiquidacionExpensas());
		liquidacionP.setEstado(persistencia.clases.LiquidacionExpensas.Estado.ANULADO);
		liquidacionP=(LiquidacionExpensas) HibernateDAO.getInstancia().update(liquidacionP);
		codigoReturn=liquidacionP.getIdLiquidacionExpensas();
		return codigoReturn;
	}

}
