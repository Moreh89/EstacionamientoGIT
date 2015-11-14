package persistencia.dao;

import java.util.ArrayList;
import modelo.Usuario;
import persistencia.Converter;
import persistencia.HibernateDAO;

public class DAOUsuario {

	private static DAOUsuario ins = null;

	public static DAOUsuario getInstance(){
		if (ins == null) ins = new DAOUsuario();

		return ins;
	}

	public long persistir(Usuario usuarioM) {
		persistencia.clases.Usuario usuarioP=new persistencia.clases.Usuario();
		usuarioP=Converter.convertUsuarioModeloToPersistencia(usuarioM);
		usuarioP=(persistencia.clases.Usuario) HibernateDAO.getInstancia().save(usuarioP);
		
		return usuarioP.getIdUsuario();
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<modelo.Usuario> getUsuarios()
	{
		ArrayList<modelo.Usuario> usuariosReturn;
		ArrayList<persistencia.clases.Usuario> usuariosP = new ArrayList<persistencia.clases.Usuario>();
		usuariosP=(ArrayList<persistencia.clases.Usuario>) HibernateDAO.getInstancia().getList("Usuario");
		usuariosReturn = Converter.convertUsuariosPersistenciaToModelo(usuariosP);
		return usuariosReturn;
	}

	public long modificarUsuario(Usuario usuarioM) {
		persistencia.clases.Usuario usuarioP = new persistencia.clases.Usuario();
		usuarioP = (persistencia.clases.Usuario) HibernateDAO.getInstancia().get(persistencia.clases.Usuario.class, usuarioM.getIdUsuario());
		usuarioP.setApellido(usuarioM.getApellido());
		usuarioP.setNombre(usuarioM.getNombre());
		usuarioP.setNumeroDocumento(usuarioM.getNumeroDocumento());
		usuarioP.setTipoDocumento(usuarioM.getTipoDocumento());
		if(usuarioM.getPermisos().toString().equals("CAJA"))
		{
			usuarioP.setPermisos(persistencia.clases.Usuario.PERMISOS.CAJA);
		}
		if(usuarioM.getPermisos().toString().equals("ADMIN"))
		{
			usuarioP.setPermisos(persistencia.clases.Usuario.PERMISOS.ADMIN);
		}
		
		if(usuarioM.getEstado().toString().equals("ACTIVO"))
		{
			usuarioP.setEstado(persistencia.clases.Usuario.ESTADO.ACTIVO);
		}
		if(usuarioM.getEstado().toString().equals("INACTIVO"))
		{
			usuarioP.setEstado(persistencia.clases.Usuario.ESTADO.INACTIVO);
		}
		
		usuarioP=(persistencia.clases.Usuario) HibernateDAO.getInstancia().update(usuarioP);
		
		return usuarioP.getIdUsuario();
	}

}
