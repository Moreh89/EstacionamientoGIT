package persistencia.dao;

import persistencia.HibernateDAO;
import modelo.Ticket;

public class DAOTicket {
	
	private static DAOTicket ins = null;
	
	public static DAOTicket getInstance(){
		if (ins == null) ins = new DAOTicket();
		
		return ins;
	}

	public long persistir(Ticket tck) {

		persistencia.clases.Ticket tckDao = new persistencia.clases.Ticket();
	
//TODO
		
//		tckDao.setCatergoriaVehiculo(catVPer);
//		tckDao.setCliente(clientePer);
//		tckDao.setDescuento(descuentoPer);
//		tckDao.setEstado(estadoPer);
//		tckDao.setFechaLlegada(fechaLlegadaPer);
//		tckDao.setModeloVehiculo(modeloVehiculoPer);
//		tckDao.setMontoCobrado(montoCobradoPer);
//		tckDao.setObservacion(observacionPer);
//		tckDao.setPrepago(prepagoPer);
//		tckDao.setUsuario(usuarioPer);
		
		
		HibernateDAO.getInstancia().save(tckDao);
		
		return tckDao.getIdTicket();
	}
	

}
