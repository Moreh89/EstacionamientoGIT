package persistencia.clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "PersonaAutorizada")

public class PersonaAutorizada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	public PersonaAutorizada() {
		
	}
	
	

}
