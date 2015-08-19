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

	public persistencia.clases.Ticket getTicket(long ticketNumber) {

		persistencia.clases.Ticket tck = new persistencia.clases.Ticket();
		tck = (persistencia.clases.Ticket) HibernateDAO.getInstancia().get(persistencia.clases.Ticket.class, ticketNumber);
		
		return tck;
	}

	public void actualizar(Ticket tckM) {
		
		//Obtengo el ticket de memoria y actualizo lo que sea necesario
		persistencia.clases.Ticket tckP = new persistencia.clases.Ticket();
		tckP = (persistencia.clases.Ticket) HibernateDAO.getInstancia().get(persistencia.clases.Ticket.class, tckM.getIdTicket());
		
		if(!tckP.getCatergoriaVehiculo().getDescripcion().equals(tckM.getCatergoriaVehiculo().getDescripcion())){
			tckP.setCatergoriaVehiculo(DAOCategoriaVehiculo.getInstance().getCategoria(tckM.getCatergoriaVehiculo().getIdCategoria()));
		}
		if(tckP.getCliente().getIdCliente()!=tckM.getCliente().getIdCliente()){
			tckP.setCliente(DAOCliente.getInstance().getCliente(tckM.getCliente().getIdCliente()));
		}
		if(!tckP.getColor().getDescripcion().equals(tckM.getColor().getDescripcion())){
			tckP.setColor(DAOColorVehiculo.getInstance().getColorVehiculoPorID(tckM.getColor().getIdColor()));
		}
		if(!tckP.getDescuento().getDescripcion().equals(tckM.getDescuento().getDescripcion())){
			tckP.setDescuento(DAODescuento.getInstance().getDescuento(tckM.getDescuento().getIdDescuento()));
		}
		if(tckM.getEstado() == modelo.Ticket.Estado.ABIERTO) tckP.setEstado(persistencia.clases.Ticket.Estado.ABIERTO);
		if(tckM.getEstado() == modelo.Ticket.Estado.CERRADO) tckP.setEstado(persistencia.clases.Ticket.Estado.CERRADO);
		if(tckM.getEstado() == modelo.Ticket.Estado.PREPAGO) tckP.setEstado(persistencia.clases.Ticket.Estado.PREPAGO);
		tckP.setFechaLlegada(tckM.getFechaLlegada());
		tckP.setFechaSalida(tckM.getFechaSalida());
		if(!tckP.getModeloVehiculo().getDescripcion().equals(tckM.getModeloVehiculo().getDescripcion())){
			tckP.setModeloVehiculo(DAOModeloVehiculo.getInstance().getModeloVehiculoPorId(tckM.getModeloVehiculo().getIdModelo()));
		}
		tckP.setMontoCobrado(tckM.getMontoCobrado());
		tckP.setObservacion(tckM.getObservacion());
		tckP.setPatente(tckM.getPatente());
		tckP.setPrepago(tckM.getPrepago());
		if(tckP.getUsuario().getIdUsuario()!=tckM.getUsuario().getIdUsuario()){
			tckP.setUsuario(DAOUsuario.getInstance().getUsuario(tckM.getUsuario().getIdUsuario()));
		}
		HibernateDAO.getInstancia().update(tckP);
		
	}
	

}
