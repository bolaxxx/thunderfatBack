package net.thunderfat.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity 
@Table(name="cita")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cita;
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Paciente	paciente;
	@ManyToOne
	@JoinColumn(name = "id_nutricionista")
	private Nutricionista nutricionista;
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime fecha_ini;
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime fecha_fin;
	

	
	public Cita() {
		super();
	}







	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}



	



	



	public Nutricionista getNutricionista() {
		return nutricionista;
	}



	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}









	public LocalDateTime getFecha_ini() {
		return fecha_ini;
	}







	public void setFecha_ini(LocalDateTime fecha_ini) {
		this.fecha_ini = fecha_ini;
	}







	public LocalDateTime getFecha_fin() {
		return fecha_fin;
	}







	public void setFecha_fin(LocalDateTime fecha_fin) {
		this.fecha_fin = fecha_fin;
	}







	public int getId_cita() {
		return id_cita;
	}







	public void setId_cita(int id_cita) {
		this.id_cita = id_cita;
	}







	@Override
	public String toString() {
		return "Cita [id_cita=" + id_cita + ", paciente=" + paciente + ", nutricionista=" + nutricionista
				+ ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + "]";
	}



	


	


	
	
}