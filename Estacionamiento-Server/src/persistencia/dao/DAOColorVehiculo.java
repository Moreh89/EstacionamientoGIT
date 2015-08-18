package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;


public class DAOColorVehiculo {

	private static DAOColorVehiculo ins = null;

	public static DAOColorVehiculo getInstance(){
		if (ins == null) ins = new DAOColorVehiculo();

		return ins;
	}

	public long persistir(DAOColorVehiculo colorVehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.ColorVehiculo> getColoresVehiculos() {
		ArrayList<persistencia.clases.ColorVehiculo> coloresVehiculosP=(ArrayList<persistencia.clases.ColorVehiculo>) HibernateDAO.getInstancia().getList("ColorVehiculo");
		ArrayList<modelo.ColorVehiculo> coloresVehiculosM = Converter.convertColoresVehiculosPersistenciaToModelo(coloresVehiculosP);
		return coloresVehiculosM;
	}

	public modelo.ColorVehiculo getColorVehiculo(String descripcion)
	{
		modelo.ColorVehiculo colorVehiculoM=Converter.convertColorPersistenciaToModelo((persistencia.clases.ColorVehiculo) HibernateDAO.getInstancia().getObjectWithString("ColorVehiculo", "descripcion", descripcion));
		return colorVehiculoM;
	}
}
