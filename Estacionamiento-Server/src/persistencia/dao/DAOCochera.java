package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;

public class DAOCochera {

	private static DAOCochera ins = null;

	public static DAOCochera getInstance(){
		if (ins == null) ins = new DAOCochera();

		return ins;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Cochera> getCocheras() {
		ArrayList<persistencia.clases.Cochera> cocheraP =(ArrayList<persistencia.clases.Cochera>) HibernateDAO.getInstancia().getListInt("Cochera", "estado", 1);
		ArrayList<modelo.Cochera> cocherasM = new ArrayList<modelo.Cochera>();
		for (persistencia.clases.Cochera cochera : cocheraP) {
			modelo.Cochera cocheraTemp = Converter.convertCocheraPersistenciaToModelo(cochera);
			cocheraTemp.setCliente(Converter.convertClientePersistenciaToModelo(cochera.getCliente()));
			cocherasM.add(cocheraTemp);
		}
		return cocherasM;
	}

	public long generarAumentoAlquileres(double aumento) {
		return HibernateDAO.getInstancia().generarAumentoAlquileres(aumento);
		
	}

}
