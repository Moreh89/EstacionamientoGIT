package persistencia.dao;
import modelo.Usuario;
import persistencia.Converter;
import persistencia.HibernateDAO;

public class DAOUsuario {

	private static DAOUsuario ins = null;

	public static DAOUsuario getInstance(){
		if (ins == null) ins = new DAOUsuario();

		return ins;
	}

	public long persistir(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Usuario buscarUsuario(String userName) {
		persistencia.clases.Usuario usuarioP=(persistencia.clases.Usuario) HibernateDAO.getInstancia().getObjectWithString("Usuario", "userName", userName);
		Usuario usuario=Converter.convertUsuarioPersistenciaToModelo(usuarioP);
		
		return usuario;
	}

}
