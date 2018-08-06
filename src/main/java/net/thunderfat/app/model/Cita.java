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
@Table(name="/cita")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita;
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Paciente	paciente;
	@ManyToOne
	@JoinColumn(name = "id_nutricionista")
	private Nutricionista nutricionista_citado;
	private Date fecha;
	private String hora;
	

	
	public Cita() {
		super();
	}



	public int getIdCita() {
		return idCita;
	}



	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}



	public Nutricionista getNutricionista_citado() {
		return nutricionista_citado;
	}



	public void setNutricionista_citado(Nutricionista nutricionista_citado) {
		this.nutricionista_citado = nutricionista_citado;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", paciente=" + paciente + ", nutricionista_citado=" + nutricionista_citado
				+ ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
}