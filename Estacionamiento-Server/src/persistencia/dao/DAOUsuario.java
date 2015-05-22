package persistencia.dao;
import persistencia.Converter;
import modelo.Usuario;
import persistencia.HibernateDAO;
import persistencia.clases.UsuarioP;

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
		UsuarioP usuarioP=(UsuarioP) HibernateDAO.getInstancia().getObjectWithString("UsuarioP", "userName", userName);
		Usuario usuario=Converter.convertUsuarioPersistenciaToModelo(usuarioP);
		
		return usuario;
	}

}
