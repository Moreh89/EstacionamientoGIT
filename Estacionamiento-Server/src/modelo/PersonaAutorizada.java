package modelo;


public class PersonaAutorizada {
	

	private long idPersonaAut;
	private String nombre;
	public long getIdPersonaAut() {
		return idPersonaAut;
	}
	public void setIdPersonaAut(long idPersonaAut) {
		this.idPersonaAut = idPersonaAut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public PersonaAutorizada(long idPersonaAut, String nombre) {
		super();
		this.idPersonaAut = idPersonaAut;
		this.nombre = nombre;
	}
	
	

}
