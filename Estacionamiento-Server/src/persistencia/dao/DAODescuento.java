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
		ArrayList<persistencia.clases.Descuento> descuentosP=(ArrayList<persistencia.clases.Descuento>) HibernateDAO.getInstancia().getList("Descuento");
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


}
