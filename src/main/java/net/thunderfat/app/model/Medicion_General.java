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
@Table(name="medicion_general")
public class Medicion_General {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_medicion_general;
	private Date fecha;
	private double peso_ideal;
	private double peso_actual;
	private double brazo;
	private double icc;
	private double porcentajegrasas;
	private double IMC;
	private double tension_min	;
	private double tension_max	;
	private double cadera;
	private double cintura;
	@ManyToOne
	@JoinColumn(name="fkidpaciente")
	private Paciente paciente;
	public Medicion_General() {
		super();
	}
	public int getId_medicion_general() {
		return id_medicion_general;
	}
	public void setId_medicion_general(int id_medicion_general) {
		this.id_medicion_general = id_medicion_general;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getPeso_ideal() {
		return peso_ideal;
	}
	public void setPeso_ideal(double peso_ideal) {
		this.peso_ideal = peso_ideal;
	}
	public double getPeso_actual() {
		return peso_actual;
	}
	public void setPeso_actual(double peso_actual) {
		this.peso_actual = peso_actual;
	}
	public double getBrazo() {
		return brazo;
	}
	public void setBrazo(double brazo) {
		this.brazo = brazo;
	}
	public double getIcc() {
		return icc;
	}
	public void setIcc(double icc) {
		this.icc = icc;
	}
	public double getPorcentajegrasas() {
		return porcentajegrasas;
	}
	public void setPorcentajegrasas(double porcentajegrasas) {
		this.porcentajegrasas = porcentajegrasas;
	}
	public double getIMC() {
		return IMC;
	}
	public void setIMC(double iMC) {
		IMC = iMC;
	}
	public double getTension_min() {
		return tension_min;
	}
	public void setTension_min(double tension_min) {
		this.tension_min = tension_min;
	}
	public double getTension_max() {
		return tension_max;
	}
	public void setTension_max(double tension_max) {
		this.tension_max = tension_max;
	}
	public double getCadera() {
		return cadera;
	}
	public void setCadera(double cadera) {
		this.cadera = cadera;
	}
	public double getCintura() {
		return cintura;
	}
	public void setCintura(double cintura) {
		this.cintura = cintura;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	@Override
	public String toString() {
		return "Medicion_General [id_medicion_general=" + id_medicion_general + ", fecha=" + fecha + ", peso_ideal="
				+ peso_ideal + ", peso_actual=" + peso_actual + ", brazo=" + brazo + ", icc=" + icc
				+ ", porcentajegrasas=" + porcentajegrasas + ", IMC=" + IMC + ", tension_min=" + tension_min
				+ ", tension_max=" + tension_max + ", cadera=" + cadera + ", cintura=" + cintura + ", paciente="
				+ paciente + "]";
	}
	
}
