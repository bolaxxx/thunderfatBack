/**
 * 
 */
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

/**
 * @author sergio
 *
 */
@Entity
@Table(name="medicion_segmental")
public class Medicion_Segmental {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_medicion_segmental;
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate fecha;
	private double bdporcentajegrasas;	
	private double bd_musculo;	
	private double bimusculo;	
	private double piporcentajegrasas;	
	private double pdmusculo;	
	private double pdporcentajegrasas;	
	private double tporcentajegrasa;	
	private double tmusculo;	
	private double pimusculo;	
	private double biporcentajegrasas;	
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Paciente paciente;
	
	
	public Medicion_Segmental() {
		super();
	}
	public int getId_medicion_segmental() {
		return id_medicion_segmental;
	}
	public void setId_medicion_segmental(int id_medicion_segmental) {
		this.id_medicion_segmental = id_medicion_segmental;
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public double getBdporcentajegrasas() {
		return bdporcentajegrasas;
	}
	public void setBdporcentajegrasas(double bdporcentajegrasas) {
		this.bdporcentajegrasas = bdporcentajegrasas;
	}
	public double getBd_musculo() {
		return bd_musculo;
	}
	public void setBd_musculo(double bd_musculo) {
		this.bd_musculo = bd_musculo;
	}
	public double getBimusculo() {
		return bimusculo;
	}
	public void setBimusculo(double bimusculo) {
		this.bimusculo = bimusculo;
	}
	public double getPiporcentajegrasas() {
		return piporcentajegrasas;
	}
	public void setPiporcentajegrasas(double piporcentajegrasas) {
		this.piporcentajegrasas = piporcentajegrasas;
	}
	public double getPdmusculo() {
		return pdmusculo;
	}
	public void setPdmusculo(double pdmusculo) {
		this.pdmusculo = pdmusculo;
	}
	public double getPdporcentajegrasas() {
		return pdporcentajegrasas;
	}
	public void setPdporcentajegrasas(double pdporcentajegrasas) {
		this.pdporcentajegrasas = pdporcentajegrasas;
	}
	public double getTporcentajegrasa() {
		return tporcentajegrasa;
	}
	public void setTporcentajegrasa(double tporcentajegrasa) {
		this.tporcentajegrasa = tporcentajegrasa;
	}
	public double getTmusculo() {
		return tmusculo;
	}
	public void setTmusculo(double tmusculo) {
		this.tmusculo = tmusculo;
	}
	public double getPimusculo() {
		return pimusculo;
	}
	public void setPimusculo(double pimusculo) {
		this.pimusculo = pimusculo;
	}
	public double getBiporcentajegrasas() {
		return biporcentajegrasas;
	}
	public void setBiporcentajegrasas(double biporcentajegrasas) {
		this.biporcentajegrasas = biporcentajegrasas;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	@Override
	public String toString() {
		return "Medicion_Segmental [id_medicion_segmental=" + id_medicion_segmental + ", fecha=" + fecha
				+ ", bdporcentajegrasas=" + bdporcentajegrasas + ", bd_musculo=" + bd_musculo + ", bimusculo="
				+ bimusculo + ", piporcentajegrasas=" + piporcentajegrasas + ", pdmusculo=" + pdmusculo
				+ ", pdporcentajegrasas=" + pdporcentajegrasas + ", tporcentajegrasa=" + tporcentajegrasa
				+ ", tmusculo=" + tmusculo + ", pimusculo=" + pimusculo + ", biporcentajegrasas=" + biporcentajegrasas
				+ ", paciente=" + paciente + "]";
	}
	
	
}
