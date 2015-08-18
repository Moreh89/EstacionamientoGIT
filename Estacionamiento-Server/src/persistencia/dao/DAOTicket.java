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

	public Ticket getTicket(long ticketNumber) {

		persistencia.clases.Ticket tck = (persistencia.clases.Ticket) HibernateDAO.getInstancia().get(persistencia.clases.Ticket.class, ticketNumber);
		return Converter.convertTicketPersistenciaToModelo(tck);
	}
	

}
