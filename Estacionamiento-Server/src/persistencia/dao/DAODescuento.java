package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.Descuento;

public class DAODescuento {

	private static DAODescuento ins = null;

	public static DAODescuento getInstance(){
		if (ins == null) ins = new DAODescuento();

		return ins;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Descuento> getDescuentos() {
		ArrayList<persistencia.clases.Descuento> descuentosP=(ArrayList<persistencia.clases.Descuento>) HibernateDAO.getInstancia().getListInt("Descuento", "estado", 1);
		ArrayList<modelo.Descuento> descuentosM = Converter.convertDescuentosPersistenciaToModelo(descuentosP);
		return descuentosM;
	}
	
	public long persistir(modelo.Descuento descuentoM) {
		persistencia.clases.Descuento descuentoP = new persistencia.clases.Descuento();
		descuentoP=Converter.convertDescuentoModeloToPersistencia(descuentoM);
		HibernateDAO.getInstancia().save(descuentoP);
		descuentoM.setIdDescuento(descuentoP.getIdDescuento());
		return descuentoP.getIdDescuento();
	}

	public Descuento getDescuento(long idDescuento) {
			persistencia.clases.Descuento des = new persistencia.clases.Descuento();
			des = (persistencia.clases.Descuento) HibernateDAO.getInstancia().get(persistencia.clases.Descuento.class, idDescuento);
			return des;
	}

	public long deshabilitarDescuento(long idDescuento) {
		long codigoReturn=-1;
		persistencia.clases.Descuento descuentoP = new persistencia.clases.Descuento();
		descuentoP = (persistencia.clases.Descuento) HibernateDAO.getInstancia().get(persistencia.clases.Descuento.class, idDescuento);
		descuentoP.setEstado(persistencia.clases.Descuento.ESTADO.INACTIVO);
		descuentoP=(Descuento) HibernateDAO.getInstancia().update(descuentoP);
		codigoReturn=descuentoP.getIdDescuento();
		return codigoReturn;
	}

	public long modificarDescuento(modelo.Descuento descuentoM) {
		long codigoReturn=-1;
		persistencia.clases.Descuento descuentoP = new persistencia.clases.Descuento();
		descuentoP = (persistencia.clases.Descuento) HibernateDAO.getInstancia().get(persistencia.clases.Descuento.class, descuentoM.getIdDescuento());
		descuentoP.setDescripcion(descuentoM.getDescripcion());
		descuentoP.setDescuento(descuentoM.getDescuento());
		descuentoP=(Descuento) HibernateDAO.getInstancia().update(descuentoP);
		codigoReturn=descuentoP.getIdDescuento();
		return codigoReturn;
	}


}
