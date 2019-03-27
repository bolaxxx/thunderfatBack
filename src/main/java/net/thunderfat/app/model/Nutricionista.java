package net.thunderfat.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="nutricionista")
public class Nutricionista extends User {
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String localidad;
	private String provincia;
	private String dni;
	private String direccion;
//	@OneToMany(mappedBy="nutricionista",fetch=FetchType.EAGER)
//		private Set<Paciente> pacientes;
//	@Transient
//	@OneToMany(mappedBy="nutricionista",fetch=FetchType.EAGER)
//	private Set<Cita> citas;
//	@OneToMany(mappedBy="nutricionista",fetch=FetchType.EAGER)
//	private Set<PlanDieta> planesdietas;
//	@OneToMany(mappedBy="nutricionnista")
//	private Set<FiltroAlimentario>filtros;
//	
	public Nutricionista() {
		super();
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
//	public Set<Paciente> getPacientes() {
//		return pacientes;
//	}
//	public void setPacientes(Set<Paciente> pacientes) {
//		this.pacientes = pacientes;
//	}
//	public Set<Cita> getCitas() {
//		return citas;
//	}
//	public void setCitas(Set<Cita> citas) {
//		this.citas = citas;
//	}
//	public Set<PlanDieta> getPlanesdietas() {
//		return planesdietas;
//	}
//	public void setPlanesdietas(Set<PlanDieta> planesdietas) {
//		this.planesdietas = planesdietas;
//	}
//	public Set<FiltroAlimentario> getFiltros() {
//		return filtros;
//	}
//	public void setFiltros(Set<FiltroAlimentario> filtros) {
//		this.filtros = filtros;
//	}
//	@Override
//	public String toString() {
//		return "Nutricionista [id_nutricionista=" + id_nutricionista + ", nombre=" + nombre + ", apellidos=" + apellidos
//				+ ", telefono=" + telefono + ", localidad=" + localidad + ", provincia=" + provincia + ", dni=" + dni
//				+ "]";
//	}
//	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Nutricionista [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", dni=" + dni + ", direccion=" + direccion
				+ ", getEmail()=" + getEmail() + ", getId_usuario()=" + getId_usuario() + "]";
	}
	
	
	

}
