package persistencia.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Usuario;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.MovimientoCC;

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

	@SuppressWarnings("unchecked")
	public ArrayList<MovimientoCC> getMovimientosCobrados(Usuario usuario, Date fechaInicio,
			Date fechaFin) {
		ArrayList<MovimientoCC> movimientosP = new ArrayList<MovimientoCC>();
		
		String fechaL = new SimpleDateFormat("MM-dd-yyyy").format(fechaInicio);
		fechaL = fechaL + " 00:00:00";
		String fechaS = new SimpleDateFormat("MM-dd-yyyy").format(fechaFin);
		fechaS = fechaS + " 23:59:59";
		List<persistencia.clases.MovimientoCC> movimientosT = new ArrayList<MovimientoCC>();
		if(usuario.getIdUsuario()>0){
			movimientosT = (List<MovimientoCC>) HibernateDAO.getInstancia().getListbetweenDates("MovimientoCC", "usuario", usuario.getIdUsuario(), "fecha", fechaL, "fecha", fechaS);
		}else{
			movimientosT = (List<MovimientoCC>) HibernateDAO.getInstancia().getListbetweenDates("MovimientoCC", "estado", "PAGADO","fecha", fechaL, "fecha", fechaS);
		}

		for (MovimientoCC movimientoCC : movimientosT) {
			if(movimientoCC.getMontoCobrado() >0 ) movimientosP.add(movimientoCC);
		}
		
		return movimientosP;
	}
	
	public String getNombreCliente (long idMovimiento){
	
		String nombre = (String) HibernateDAO.getInstancia().getSession().createSQLQuery("SELECT (ISNULL(apellido,'') + ', ' + ISNULL(nombre,'')) from Cliente cli INNER JOIN MovimientoCC mc on cli.CuentaCorriente = mc.CuentaCorriente WHERE  mc.idMovimiento =?").setLong(0, idMovimiento).uniqueResult();

	
		return nombre;
	
	}
}
