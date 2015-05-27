package persistencia;

import modelo.Usuario;
import modelo.Usuario.PERMISOS;
import persistencia.clases.*;

public class Converter {

	public static modelo.Usuario convertUsuarioPersistenciaToModelo(persistencia.clases.Usuario usuarioPersistencia)
	{
		Usuario usuarioModelo=new modelo.Usuario();

		usuarioModelo.setIdUsuario(usuarioPersistencia.getIdUsuario());
		usuarioModelo.setUserName(usuarioPersistencia.getUserName());
		usuarioModelo.setPassword(usuarioPersistencia.getPassword());

		String permisoPersistencia=usuarioPersistencia.getPermisos().toString();
		if(permisoPersistencia.equals("ADMIN"))
			usuarioModelo.setPermisos(PERMISOS.ADMIN);
		if(permisoPersistencia.equals("CAJA"))
			usuarioModelo.setPermisos(PERMISOS.CAJA);


		usuarioModelo.setNombre(usuarioPersistencia.getNombre());
		usuarioModelo.setApellido(usuarioPersistencia.getApellido());
		usuarioModelo.setTipoDocumento(usuarioPersistencia.getTipoDocumento());
		usuarioModelo.setNumeroDocumento(usuarioPersistencia.getNumeroDocumento());
		return usuarioModelo;
	}

	public static persistencia.clases.Usuario convertUsuarioModeloToPersistencia(Usuario usuarioM) 
	{
		persistencia.clases.Usuario usuarioP=new persistencia.clases.Usuario();
		
		usuarioP.setIdUsuario(usuarioM.getIdUsuario());
		usuarioP.setUserName(usuarioM.getUserName());
		usuarioP.setPassword(usuarioM.getPassword());

		String permisoModelo=usuarioM.getPermisos().toString();
		if(permisoModelo.equals("ADMIN"))
			usuarioP.setPermisos(persistencia.clases.Usuario.PERMISOS.ADMIN);
		if(permisoModelo.equals("CAJA"))
			usuarioP.setPermisos(persistencia.clases.Usuario.PERMISOS.CAJA);


		usuarioP.setNombre(usuarioM.getNombre());
		usuarioP.setApellido(usuarioM.getApellido());
		usuarioP.setTipoDocumento(usuarioM.getTipoDocumento());
		usuarioP.setNumeroDocumento(usuarioM.getNumeroDocumento());
		
		
		return usuarioP;
	}
}
