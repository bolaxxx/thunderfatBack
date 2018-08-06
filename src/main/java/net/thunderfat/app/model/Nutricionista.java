package net.thunderfat.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="nutricionista")
public class Nutricionista {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_nutricionista;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String localidad;
	private String provincia;
	private String dni;
	@OneToMany(mappedBy="nutricionista",fetch=FetchType.EAGER)
		private Set<Paciente> pacientes;
//	@OneToMany(mappedBy="nutricionista_citado",fetch=FetchType.EAGER)
//	private Set<Cita> citas;
	@OneToMany(mappedBy="nutricionista",fetch=FetchType.EAGER)
	private Set<PlanDieta> planesdietas;
	@OneToMany(mappedBy="nutricionnista")
	private Set<FiltroAlimentario>filtros;
	
	public Nutricionista() {
		super();
	}
	public int getId_nutricionista() {
		return id_nutricionista;
	}
	public void setId_nutricionista(int id_nutricionista) {
		this.id_nutricionista = id_nutricionista;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Nutricionista [id_nutricionista=" + id_nutricionista + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", localidad=" + localidad + ", provincia=" + provincia + ", dni=" + dni
				+ ", pacientes=" + pacientes + ", planesdietas=" + planesdietas + ", filtros=" + filtros + "]";
	}
	
	

}
