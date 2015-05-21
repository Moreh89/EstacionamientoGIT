package persistencia.dao;

import modelo.Ticket;

public class DAOTicket {
	
	private static DAOTicket ins = null;
	
	public static DAOTicket getInstance(){
		if (ins == null) ins = new DAOTicket();
		
		return ins;
	}

	public long persistir(Ticket tck) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
