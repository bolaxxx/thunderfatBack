/**
 * 
 */
package net.thunderfat.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Date fecha;
	private double bdporcetanjegrasas;	
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
	@JoinColumn(name="fkid_paciente_segmental")
	private Paciente paciente_segmental;
	
	
	public Medicion_Segmental() {
		super();
	}
	public int getId_medicion_segmental() {
		return id_medicion_segmental;
	}
	public void setId_medicion_segmental(int id_medicion_segmental) {
		this.id_medicion_segmental = id_medicion_segmental;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getBdporcetanjegrasas() {
		return bdporcetanjegrasas;
	}
	public void setBdporcetanjegrasas(double bdporcetanjegrasas) {
		this.bdporcetanjegrasas = bdporcetanjegrasas;
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
	public Paciente getPaciente_segmental() {
		return paciente_segmental;
	}
	public void setPaciente_segmental(Paciente paciente_segmental) {
		this.paciente_segmental = paciente_segmental;
	}
	@Override
	public String toString() {
		return "Medicion_Segmental [id_medicion_segmental=" + id_medicion_segmental + ", fecha=" + fecha
				+ ", bdporcetanjegrasas=" + bdporcetanjegrasas + ", bd_musculo=" + bd_musculo + ", bimusculo="
				+ bimusculo + ", piporcentajegrasas=" + piporcentajegrasas + ", pdmusculo=" + pdmusculo
				+ ", pdporcentajegrasas=" + pdporcentajegrasas + ", tporcentajegrasa=" + tporcentajegrasa
				+ ", tmusculo=" + tmusculo + ", pimusculo=" + pimusculo + ", biporcentajegrasas=" + biporcentajegrasas
				+ ", paciente_segmental=" + paciente_segmental + "]";
	}
	
}
