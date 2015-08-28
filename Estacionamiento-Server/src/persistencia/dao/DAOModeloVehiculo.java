package persistencia.dao;
import java.util.ArrayList;
import persistencia.Converter;
import persistencia.HibernateDAO;
import persistencia.clases.ModeloVehiculo;


public class DAOModeloVehiculo {

	private static DAOModeloVehiculo ins = null;

	public static DAOModeloVehiculo getInstance(){
		if (ins == null) ins = new DAOModeloVehiculo();

		return ins;
	}

	public long persistir(DAOModeloVehiculo ModeloVehiculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<modelo.ModeloVehiculo> getModelosVehiculos() {
		ArrayList<persistencia.clases.ModeloVehiculo> modeloesVehiculosP=(ArrayList<persistencia.clases.ModeloVehiculo>) HibernateDAO.getInstancia().getList("ModeloVehiculo");
		ArrayList<modelo.ModeloVehiculo> modelosVehiculosM = Converter.convertModelosVehiculosPersistenciaToModelo(modeloesVehiculosP);
		return modelosVehiculosM;
	}

	public modelo.ModeloVehiculo getModeloVehiculo(String descripcion)
	{
		modelo.ModeloVehiculo modeloVehiculoM=Converter.convertModeloVehiculoPersistenciaToModelo((persistencia.clases.ModeloVehiculo) HibernateDAO.getInstancia().getObjectWithString("ModeloVehiculo", "descripcion", descripcion));
		return modeloVehiculoM;
	}

	public ModeloVehiculo getModeloVehiculoPorId(long idModelo) {
		persistencia.clases.ModeloVehiculo mod = new persistencia.clases.ModeloVehiculo();
		mod = (persistencia.clases.ModeloVehiculo) HibernateDAO.getInstancia().get(persistencia.clases.ModeloVehiculo.class, idModelo);
		return mod;
	}

	public long modificarModelo(modelo.ModeloVehiculo modeloM) 
	{
		persistencia.clases.ModeloVehiculo modeloP = (persistencia.clases.ModeloVehiculo) HibernateDAO.getInstancia().getObjectWithLong("ModeloVehiculo", "idModelo",modeloM.getIdModelo());
		modeloP.setDescripcion(modeloM.getDescripcion());
		modeloP=(ModeloVehiculo) HibernateDAO.getInstancia().update(modeloP);
		return modeloP.getIdModelo();
	}
	
	public long persistir(modelo.ModeloVehiculo modeloM)
	{
		persistencia.clases.ModeloVehiculo modeloP = new persistencia.clases.ModeloVehiculo();
		modeloP=Converter.convertModeloVehiculoModeloToPersistencia(modeloM);
		modeloP=(ModeloVehiculo) HibernateDAO.getInstancia().save(modeloP);
		
		return modeloP.getIdModelo();
	}
	
	
}
