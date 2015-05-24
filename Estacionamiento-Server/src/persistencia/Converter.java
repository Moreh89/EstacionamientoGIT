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

		//		TODO verificar permisos que el enum de persistencia no coincide.
		String permisoPersistencia=usuarioPersistencia.getPermisos().toString();
		if(permisoPersistencia=="ADMIN")
			usuarioModelo.setPermisos(PERMISOS.ADMIN);
		if(permisoPersistencia=="CAJA")
			usuarioModelo.setPermisos(PERMISOS.CAJA);


		usuarioModelo.setNombre(usuarioPersistencia.getNombre());
		usuarioModelo.setApellido(usuarioPersistencia.getApellido());
		usuarioModelo.setTipoDocumento(usuarioPersistencia.getTipoDocumento());
		usuarioModelo.setNumeroDocumento(usuarioPersistencia.getNumeroDocumento());
		return usuarioModelo;
	}


}
