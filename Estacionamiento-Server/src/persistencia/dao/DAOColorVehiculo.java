package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.ColorVehiculo;


public class DAOColorVehiculo {

	private static DAOColorVehiculo ins = null;

	public static DAOColorVehiculo getInstance(){
		if (ins == null) ins = new DAOColorVehiculo();

		return ins;
	}

	public long persistir(modelo.ColorVehiculo colorM) {
		persistencia.clases.ColorVehiculo colorP = new ColorVehiculo();
		colorP=Converter.convertColorModeloToPersistencia(colorM);
		colorP=(ColorVehiculo) HibernateDAO.getInstancia().save(colorP);
		return colorP.getIdColor();
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

	public ColorVehiculo getColorVehiculoPorID(long idColor) {
		persistencia.clases.ColorVehiculo col = new persistencia.clases.ColorVehiculo();
		col = (persistencia.clases.ColorVehiculo) HibernateDAO.getInstancia().get(persistencia.clases.ColorVehiculo.class, idColor);
		return col;
	}

	public long modificarColor(modelo.ColorVehiculo colorSeleccionado) {
		persistencia.clases.ColorVehiculo colorP=new ColorVehiculo();
		colorP=(ColorVehiculo) HibernateDAO.getInstancia().getObjectWithLong("ColorVehiculo", "idColor", colorSeleccionado.getIdColor());
		colorP.setDescripcion(colorSeleccionado.getDescripcion());
		HibernateDAO.getInstancia().update(colorP);
		return colorP.getIdColor();
	}
}
