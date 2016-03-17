package persistencia.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistencia.Converter;
import persistencia.HibernateDAO;
import modelo.Ticket;
import modelo.Usuario;

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
		if(tck!=null)HibernateDAO.getInstancia().getSession().refresh(tck);
		return tck;
	}

	@SuppressWarnings("unchecked")
	public List<persistencia.clases.Ticket> getTicketsAbiertos() {

		 List<persistencia.clases.Ticket> listaTickets = (List<persistencia.clases.Ticket>) HibernateDAO.getInstancia().getListString("Ticket", "estado", "0");
		listaTickets.addAll((List<persistencia.clases.Ticket>) HibernateDAO.getInstancia().getListString("Ticket", "estado", "1"));
		
		return listaTickets;
	}
	
	public void actualizar(Ticket tckM) {
		
		//Obtengo el ticket de memoria y actualizo lo que sea necesario
		persistencia.clases.Ticket tckP = new persistencia.clases.Ticket();
		tckP = (persistencia.clases.Ticket) HibernateDAO.getInstancia().get(persistencia.clases.Ticket.class, tckM.getIdTicket());
		
		if(!tckP.getCatergoriaVehiculo().getDescripcion().equals(tckM.getCatergoriaVehiculo().getDescripcion())){
			tckP.setCatergoriaVehiculo(DAOCategoriaVehiculo.getInstance().getCategoria(tckM.getCatergoriaVehiculo().getIdCategoria()));
		}
		if((tckM.getCliente()!=null && tckP.getCliente()==null)||(tckM.getCliente()!=null && tckP.getCliente().getIdCliente()!=tckM.getCliente().getIdCliente())){
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
		if(tckM.getEstado() == modelo.Ticket.Estado.CREDITO) tckP.setEstado(persistencia.clases.Ticket.Estado.CREDITO);
		tckP.setFechaLlegada(tckM.getFechaLlegada());
		if(tckM.getEstado() != modelo.Ticket.Estado.ABIERTO && tckM.getEstado() != modelo.Ticket.Estado.PREPAGO) tckP.setFechaSalida(tckM.getFechaSalida());
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
		tckP.setPagotarjeta(tckM.isPagotarjeta());
		HibernateDAO.getInstancia().update(tckP);
		
	}

	public boolean borrar(Ticket tckM) {
		persistencia.clases.Ticket tckP = new persistencia.clases.Ticket();
		tckP = (persistencia.clases.Ticket) HibernateDAO.getInstancia().get(persistencia.clases.Ticket.class, tckM.getIdTicket());
		HibernateDAO.getInstancia().delete(tckP);
		return true;
	}
	@SuppressWarnings({ "unchecked" })
	public ArrayList<persistencia.clases.Ticket> getTicketsCobrados(Usuario usuario, Date fechaInicio, Date fechaFin) {

		String fechaL = new SimpleDateFormat("MM-dd-yyyy").format(fechaInicio);
		fechaL = fechaL + " 00:00:00";
		String fechaS = new SimpleDateFormat("MM-dd-yyyy").format(fechaFin);
		fechaS = fechaS + " 23:59:59";
		List<persistencia.clases.Ticket> listaTickets = (List<persistencia.clases.Ticket>) HibernateDAO.getInstancia().getListbetweenDates("Ticket", "estado", "1","fechaLlegada", fechaL, "fechaLlegada", fechaS);
		listaTickets.addAll((List<persistencia.clases.Ticket>) HibernateDAO.getInstancia().getListbetweenDates("Ticket", "estado", "2","fechaSalida", fechaL, "fechaSalida", fechaS));
		
		ArrayList<persistencia.clases.Ticket> listaPorUsuario = new ArrayList<persistencia.clases.Ticket>();
		
		if (usuario.getIdUsuario()>0) {
			for (persistencia.clases.Ticket ticketTemp : listaTickets) {
				if(ticketTemp.getUsuario().getIdUsuario() == usuario.getIdUsuario()){
					listaPorUsuario.add(ticketTemp);
				}
			}
		}else{
			for (persistencia.clases.Ticket ticketTemp : listaTickets) {
					listaPorUsuario.add(ticketTemp);
			}
		}
		
		return listaPorUsuario;
		
	}

	public ArrayList<modelo.Ticket> getTicketsTarjeta(Date fechaDesde, Date fechaHasta) {
		ArrayList<Ticket> ticketsTarjetaModelo;
		String fechaL = new SimpleDateFormat("MM-dd-yyyy").format(fechaDesde);
		fechaL = fechaL + " 00:00:00";
		String fechaS = new SimpleDateFormat("MM-dd-yyyy").format(fechaHasta);
		fechaS = fechaS + " 23:59:59";
		@SuppressWarnings("unchecked")
		ArrayList<persistencia.clases.Ticket> ticketsTarjetaPersistencia = (ArrayList<persistencia.clases.Ticket>) HibernateDAO.getInstancia().getListbetweenDates("Ticket", "estado", "2","pagoTarjeta",true,"fechaLlegada", fechaL, "fechaLlegada", fechaS);
		ticketsTarjetaModelo = Converter.convertTicketsPersistenciaToModelo(ticketsTarjetaPersistencia);
		return ticketsTarjetaModelo;
	}
	

}
