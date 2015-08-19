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
		persistencia.clases.Usuario usuarioP = new persistencia.clases.Usuario();
		usuarioP=(persistencia.clases.Usuario) HibernateDAO.getInstancia().getObjectWithString("Usuario", "userName", userName);
		Usuario usuario=Converter.convertUsuarioPersistenciaToModelo(usuarioP);
		
		return usuario;
	}
	
	public boolean cambiarContrasenia(Usuario usuarioM)
	{

		persistencia.clases.Usuario usuarioP=(persistencia.clases.Usuario) HibernateDAO.getInstancia().getObjectWithLong("Usuario", "idUsuario", usuarioM.getIdUsuario());
		usuarioP.setPassword(usuarioM.getPassword());
		persistencia.clases.Usuario usuarioDevuelto=(persistencia.clases.Usuario) HibernateDAO.getInstancia().update(usuarioP);
		if(usuarioDevuelto.getPassword().equals(usuarioM.getPassword()))
		{
			return true;
		}
		else
			return false;
	}

	public persistencia.clases.Usuario getUsuario(long idUsuario) {
		persistencia.clases.Usuario usu = new persistencia.clases.Usuario();
		usu = (persistencia.clases.Usuario) HibernateDAO.getInstancia().get(persistencia.clases.Usuario.class, idUsuario);
		return usu;
	}

}
