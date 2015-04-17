package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public Usuario(long idUsuario, String userName, String password,
			PERMISOS permisos, String nombre, String apellido,
			String tipoDocumento, String numeroDocumento) {
		super();
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.password = password;
		this.permisos = permisos;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}
	
	
	
}
