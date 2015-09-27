package modelo;

import java.util.Comparator;

public class Usuario 
{
	private long idUsuario;
	private String userName;
	private String password;
	private PERMISOS permisos;
	private String nombre;
	private String apellido;
	private String tipoDocumento;
	private String numeroDocumento;
	
	public enum PERMISOS {
		ADMIN,
		CAJA;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public PERMISOS getPermisos() {
		return permisos;
	}
	public void setPermisos(PERMISOS permisos) {
		this.permisos = permisos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Usuario(){}
	
	public String toString()
	{
		return this.apellido+", "+this.nombre;
	}
	  public static class CompApellido implements Comparator<Usuario>
	 {
		public int compare(Usuario o1, Usuario o2) {
			return o1.getApellido().compareToIgnoreCase(o2.getApellido());
		}
	}

}
