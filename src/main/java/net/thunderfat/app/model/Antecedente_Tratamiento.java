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

@Entity
@Table(name = "antecedente_tratamiento")
public class Antecedente_Tratamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_antecedente_tratamiento;
	private String antecedente;
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate fecha;
	private String observacion;
	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	public Antecedente_Tratamiento() {
		super();
	}

	public int getId_antecedente_tratamiento() {
		return id_antecedente_tratamiento;
	}

	public void setId_antecedente_tratamiento(int id_antecedente_tratamiento) {
		this.id_antecedente_tratamiento = id_antecedente_tratamiento;
	}

	
	

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getAntecedente() {
		return antecedente;
	}

	public void setAntecedente(String antecedente) {
		this.antecedente = antecedente;
	}

	@Override
	public String toString() {
		return "Antecedente_Tratamiento [id_antecedente_tratamiento=" + id_antecedente_tratamiento + ", antecedente="
				+ antecedente + ", fecha=" + fecha + ", observacion=" + observacion + ", paciente=" + paciente + "]";
	}

	
}
