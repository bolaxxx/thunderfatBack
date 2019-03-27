package net.thunderfat.app.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

//declaracion de las anotaciones Para la persistenciaen base de datos indicamos que es una entidad y la tabla  a la que hace referencia 
@Entity
@Table(name = "paciente")
public class Paciente extends User {
	// declaracion de los atributos de la clase
	
	private String nombre;
	private String apellidos;
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate fechanacimiento;
	private String direccion;
	private String localidad;
	private String codigopostal;
	private String provincia;
	private String dni;
	private double altura;
	private String telefono;
	private String sexo ;

	@ManyToOne
	@JoinColumn(name = "id_nutricionista")
	private Nutricionista nutricionista;
//	@Transient
//	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
//	private Set<Cita> citas;
//
//	@OneToMany(mappedBy = "idpaciente", fetch = FetchType.EAGER)
//	private Set<Medicion_Especifica> mediciones_especificas;
//
//	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
//	private Set<Medicion_General> mediciones_generales;
//
//	@OneToMany(mappedBy = "paciente_segmental", fetch = FetchType.EAGER)
//	private Set<Medicion_Segmental> mediciones_segmentales;
//	
//	@OneToMany(mappedBy = "id_paciente", fetch = FetchType.EAGER)
//	private Set<Antecedentes_Clinicos> antecedentes_clinicos;
//
//	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
//	private Set<Antecedente_Tratamiento> antecedentes_tratamientos;
//	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
//	private Set<PlanDieta> planes_dietas;

	

	// Constructor
	public Paciente() {
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



	public LocalDate getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(LocalDate fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
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

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellidos=" + apellidos + ", fechanacimiento=" + fechanacimiento
				+ ", direccion=" + direccion + ", localidad=" + localidad + ", codigopostal=" + codigopostal
				+ ", provincia=" + provincia + ", dni=" + dni + ", altura=" + altura + ", telefono=" + telefono
				+ ", sexo=" + sexo + ", nutricionista=" + nutricionista + ", getEmail()=" + getEmail()
				+ ", getId_usuario()=" + getId_usuario() + "]";
	}

	




//	public Set<Medicion_Especifica> getMediciones_especificas() {
//		return mediciones_especificas;
//	}
//
//	public void setMediciones_especificas(Set<Medicion_Especifica> mediciones_especificas) {
//		this.mediciones_especificas = mediciones_especificas;
//	}
//
//	public Set<Medicion_General> getMediciones_generales() {
//		return mediciones_generales;
//	}
//
//	public void setMediciones_generales(Set<Medicion_General> mediciones_generales) {
//		this.mediciones_generales = mediciones_generales;
//	}
//
//	public Set<Medicion_Segmental> getMediciones_segmentales() {
//		return mediciones_segmentales;
//	}
//
//	public void setMediciones_segmentales(Set<Medicion_Segmental> mediciones_segmentales) {
//		this.mediciones_segmentales = mediciones_segmentales;
//	}
//
//	public Set<Antecedentes_Clinicos> getAntecedentes_clinicos() {
//		return antecedentes_clinicos;
//	}
//
//	public void setAntecedentes_clinicos(Set<Antecedentes_Clinicos> antecedentes_clinicos) {
//		this.antecedentes_clinicos = antecedentes_clinicos;
//	}
//
//	public Set<Antecedente_Tratamiento> getAntecedentes_tratamientos() {
//		return antecedentes_tratamientos;
//	}
//
//	public void setAntecedentes_tratamientos(Set<Antecedente_Tratamiento> antecedentes_tratamientos) {
//		this.antecedentes_tratamientos = antecedentes_tratamientos;
//	}
//
//	public Set<PlanDieta> getPlanes_dietas() {
//		return planes_dietas;
//	}
//
//	public void setPlanes_dietas(Set<PlanDieta> planes_dietas) {
//		this.planes_dietas = planes_dietas;
//	}
//
//	public Set<Cita> getCitas() {
//		return citas;
//	}
//
//	public void setCitas(Set<Cita> citas) {
//		this.citas = citas;
//	}

//	@Override
//	public String toString() {
//		return "Paciente [id_paciente=" + id_paciente + ", nombre=" + nombre + ", apellidos=" + apellidos
//				+ ", fechanacimiento=" + fechanacimiento + ", direccion=" + direccion + ", localidad=" + localidad
//				+ ", codigopostal=" + codigopostal + ", provincia=" + provincia + ", dni=" + dni + ", altura=" + altura
//				+ ", telefono=" + telefono + "]";
//	}


	

}
