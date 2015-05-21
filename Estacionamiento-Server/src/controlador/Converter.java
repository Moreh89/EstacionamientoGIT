package controlador;

import persistencia.clases.*;

public class Converter {

	public modelo.Usuario convertUsuarioPersistenciaToModelo(persistencia.clases.Usuario usuarioPersistencia)
	{
		modelo.Usuario usuarioModelo;
		
		usuarioModelo.setIdUsuario(usuarioPersistencia.getIdUsuario());
		usuarioModelo.setUserName(usuarioPersistencia.getUserName());
		usuarioModelo.setPassword(usuarioPersistencia.getPassword());
//		TODO verificar permisos que el enum de persistencia no coincide.
		
		usuarioModelo.setPermisos(usuarioPersistencia.getPermisos());
		
		usuarioModelo.setNombre(usuarioPersistencia.getNombre());
		usuarioModelo.setApellido(usuarioPersistencia.getApellido());
		usuarioModelo.setTipoDocumento(usuarioPersistencia.getTipoDocumento());
		usuarioModelo.setNumeroDocumento(usuarioPersistencia.getNumeroDocumento());
		return usuarioModelo;
	}
}
