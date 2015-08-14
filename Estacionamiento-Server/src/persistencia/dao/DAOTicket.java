package persistencia.dao;

import persistencia.Converter;
import persistencia.HibernateDAO;
import modelo.Ticket;

public class DAOTicket {
	
	private static DAOTicket ins = null;
	
	public static DAOTicket getInstance(){
		if (ins == null) ins = new DAOTicket();
		
		return ins;
	}

	public long persistir(Ticket tck) {

		persistencia.clases.Ticket tckDao = Converter.convertTicketModeloToPersistencia(tck);
		
		HibernateDAO.getInstancia().save(tckDao);
		
		return tckDao.getIdTicket();
	}
	

}
