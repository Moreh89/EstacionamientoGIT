package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.LiquidacionAlquileres;

public class DAOLiquidacionAlquileres {

	private static DAOLiquidacionAlquileres ins = null;

	public static DAOLiquidacionAlquileres getInstance(){
		if (ins == null) ins = new DAOLiquidacionAlquileres();

		return ins;
	}

	public long persistir(modelo.LiquidacionAlquileres liquidacionM) {
		persistencia.clases.LiquidacionAlquileres liquidacionP = new persistencia.clases.LiquidacionAlquileres();
		liquidacionP=Converter.convertLiquidacionAlquileresModeloToPersistencia(liquidacionM);
		liquidacionP = (LiquidacionAlquileres) HibernateDAO.getInstancia().save(liquidacionP);
		return liquidacionP.getIdLiquidacionAlquileres();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.LiquidacionAlquileres> getLiquidacionesRecientes() {
		//cantDias = Reciente
		int cantDias = 30;
		ArrayList<modelo.LiquidacionAlquileres> liquidacionesRecientesM;
		ArrayList<persistencia.clases.LiquidacionAlquileres> liquidacionesRecientesP = new ArrayList<persistencia.clases.LiquidacionAlquileres>();
		liquidacionesRecientesP=(ArrayList<persistencia.clases.LiquidacionAlquileres>) HibernateDAO.getInstancia().getListLiquidacionesDatediff("LiquidacionAlquileres", "fechaEmision", cantDias);
		liquidacionesRecientesM = Converter.convertLiquidacionesAlquileresPersistenciaToNegocio(liquidacionesRecientesP);
		
		return liquidacionesRecientesM;
	}

	public long anularLiquidacion(modelo.LiquidacionAlquileres liquidacionSeleccionado) {
		long codigoReturn=-1;
		persistencia.clases.LiquidacionAlquileres liquidacionP = new persistencia.clases.LiquidacionAlquileres();
		liquidacionP= (LiquidacionAlquileres) HibernateDAO.getInstancia().getObjectWithLong("LiquidacionAlquileres", "idLiquidacionAlquileres", liquidacionSeleccionado.getIdLiquidacionAlquileres());
		liquidacionP.setEstado(persistencia.clases.LiquidacionAlquileres.Estado.ANULADO);
		liquidacionP=(LiquidacionAlquileres) HibernateDAO.getInstancia().update(liquidacionP);
		codigoReturn=liquidacionP.getIdLiquidacionAlquileres();
		return codigoReturn;
	}

}
