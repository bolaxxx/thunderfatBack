package net.thunderfat.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "antecedete_tratamiento")
public class Antecedente_Tratamiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_antecedente_tratamiento;
	private double antecedente;
	private Date fecha;
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

	public double getAntecedente() {
		return antecedente;
	}

	public void setAntecedente(double antecedente) {
		this.antecedente = antecedente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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

	@Override
	public String toString() {
		return "Antecedente_Tratamiento [id_antecedente_tratamiento=" + id_antecedente_tratamiento + ", antecedente="
				+ antecedente + ", fecha=" + fecha + ", observacion=" + observacion + ", paciente=" + paciente + "]";
	}

}
