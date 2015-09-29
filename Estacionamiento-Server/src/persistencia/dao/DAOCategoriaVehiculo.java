package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.CategoriaVehiculo;

public class DAOCategoriaVehiculo {

	private static DAOCategoriaVehiculo ins = null;

	public static DAOCategoriaVehiculo getInstance(){
		if (ins == null) ins = new DAOCategoriaVehiculo();

		return ins;
	}

	public long persistir(DAOCategoriaVehiculo categoriaVehiculo) {
		// TODO persistir categoria vehiculo
		return 0;
	}

	public modelo.CategoriaVehiculo buscarCategoriaVehiculo(String descripcion) {
		persistencia.clases.CategoriaVehiculo CategoriaVehiculoP = new persistencia.clases.CategoriaVehiculo();
		CategoriaVehiculoP=(persistencia.clases.CategoriaVehiculo) HibernateDAO.getInstancia().getObjectWithString("CategoriaVehiculo", "descripcion", descripcion);
		modelo.CategoriaVehiculo categoriaVehiculoM=Converter.convertCategoriaVehiculoPersistenciaToModelo(CategoriaVehiculoP);
		
		return categoriaVehiculoM;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.CategoriaVehiculo> getCategoriasVehiculos() {
		ArrayList<persistencia.clases.CategoriaVehiculo> categoriasVehiculosP=(ArrayList<persistencia.clases.CategoriaVehiculo>) HibernateDAO.getInstancia().getList("CategoriaVehiculo");
		ArrayList<modelo.CategoriaVehiculo> categoriasVehiculosM = Converter.convertCategoriasVehiculosPersistenciaToModelo(categoriasVehiculosP);
		return categoriasVehiculosM;

	}

	public CategoriaVehiculo getCategoria(long idCategoria) {

		persistencia.clases.CategoriaVehiculo cat = new persistencia.clases.CategoriaVehiculo();
		cat = (persistencia.clases.CategoriaVehiculo) HibernateDAO.getInstancia().get(persistencia.clases.CategoriaVehiculo.class, idCategoria);
		return cat;
	}

//	public ArrayList<modelo.CategoriaVehiculo> getCategoriasVehiculos() {
//		ArrayList<persistencia.clases.CategoriaVehiculo> categoriasVehiculosP=(ArrayList<persistencia.clases.CategoriaVehiculo>) HibernateDAO.getInstancia().getList("CategoriaVehiculo");
//		ArrayList<modelo.CategoriaVehiculo> categoriasVehiculosM = Converter.convertCategoriasVehiculosPersistenciaToModelo(categoriasVehiculosP);
//		return categoriasVehiculosM;
//	}

}
