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
@Table(name = "antecedentes_clinicos")
public class Antecedentes_Clinicos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_antecedentes_clinicos;
	private Date fecha;
	private String antecedente_clinico;
	private String observacion;
	@ManyToOne
	@JoinColumn(name = "fkid_paciente")
	private Paciente id_paciente;

	public Antecedentes_Clinicos() {
		super();
	}

	public int getId_antecedentes_clinicos() {
		return id_antecedentes_clinicos;
	}

	public void setId_antecedentes_clinicos(int id_antecedentes_clinicos) {
		this.id_antecedentes_clinicos = id_antecedentes_clinicos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAntecedente_clinico() {
		return antecedente_clinico;
	}

	public void setAntecedente_clinico(String antecedente_clinico) {
		this.antecedente_clinico = antecedente_clinico;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Paciente getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Paciente id_paciente) {
		this.id_paciente = id_paciente;
	}

	@Override
	public String toString() {
		return "Antecedentes_Clinicos [id_antecedentes_clinicos=" + id_antecedentes_clinicos + ", fecha=" + fecha
				+ ", antecedente_clinico=" + antecedente_clinico + ", observacion=" + observacion + ", id_paciente="
				+ id_paciente + "]";
	}

	

	

}
