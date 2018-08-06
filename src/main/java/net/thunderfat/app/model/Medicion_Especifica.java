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
@Table(name="medicion_especifica")
public class Medicion_Especifica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_medicionespecifica;
	private double grasavisceral;
	private double retencionliquidos;
	private double aguaid;
	private double litrosagua;
	private double musculo_idmax;
	private double mbi;
	private double metabolismo;
	private int edad_met;
	private double masa_osea;
	private double poxmus_max;
	private double poxmus_min; 
	private double grasas;
	private double grasasid_min;
	private double grasaid_max;
	private Date fecha	;
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private Paciente idpaciente;
	
	public Medicion_Especifica() {
		super();
	}
	
	@Override
	public String toString() {
		return "Medicion_Especifica [id_medicionespecifica=" + id_medicionespecifica + ", grasavisceral="
				+ grasavisceral + ", retencionliquidos=" + retencionliquidos + ", aguaid=" + aguaid + ", litrosagua="
				+ litrosagua + ", musculo_idmax=" + musculo_idmax + ", mbi=" + mbi + ", metabolismo=" + metabolismo
				+ ", edad_met=" + edad_met + ", masa_osea=" + masa_osea + ", poxmus_max=" + poxmus_max + ", poxmus_min="
				+ poxmus_min + ", grasas=" + grasas + ", grasasid_min=" + grasasid_min + ", grasaid_max=" + grasaid_max
				+ ", fecha=" + fecha + ", idpaciente=" + idpaciente + "]";
	}

	public int getId_medicionespecifica() {
		return id_medicionespecifica;
	}
	public void setId_medicionespecifica(int id_medicionespecifica) {
		this.id_medicionespecifica = id_medicionespecifica;
	}
	public double getGrasavisceral() {
		return grasavisceral;
	}
	public void setGrasavisceral(double grasavisceral) {
		this.grasavisceral = grasavisceral;
	}
	public double getRetencionliquidos() {
		return retencionliquidos;
	}
	public void setRetencionliquidos(double retencionliquidos) {
		this.retencionliquidos = retencionliquidos;
	}
	public double getAguaid() {
		return aguaid;
	}
	public void setAguaid(double aguaid) {
		this.aguaid = aguaid;
	}
	public double getLitrosagua() {
		return litrosagua;
	}
	public void setLitrosagua(double litrosagua) {
		this.litrosagua = litrosagua;
	}
	public double getMusculo_idmax() {
		return musculo_idmax;
	}
	public void setMusculo_idmax(double musculo_idmax) {
		this.musculo_idmax = musculo_idmax;
	}
	public double getMbi() {
		return mbi;
	}
	public void setMbi(double mbi) {
		this.mbi = mbi;
	}
	public double getMetabolismo() {
		return metabolismo;
	}
	public void setMetabolismo(double metabolismo) {
		this.metabolismo = metabolismo;
	}
	public int getEdad_met() {
		return edad_met;
	}
	public void setEdad_met(int edad_met) {
		this.edad_met = edad_met;
	}
	public double getMasa_osea() {
		return masa_osea;
	}
	public void setMasa_osea(double masa_osea) {
		this.masa_osea = masa_osea;
	}
	public double getPoxmus_max() {
		return poxmus_max;
	}
	public void setPoxmus_max(double poxmus_max) {
		this.poxmus_max = poxmus_max;
	}
	public double getPoxmus_min() {
		return poxmus_min;
	}
	public void setPoxmus_min(double poxmus_min) {
		this.poxmus_min = poxmus_min;
	}
	public double getGrasas() {
		return grasas;
	}
	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}
	public double getGrasasid_min() {
		return grasasid_min;
	}
	public void setGrasasid_min(double grasasid_min) {
		this.grasasid_min = grasasid_min;
	}
	public double getGrasaid_max() {
		return grasaid_max;
	}
	public void setGrasaid_max(double grasaid_max) {
		this.grasaid_max = grasaid_max;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Paciente getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(Paciente idpaciente) {
		this.idpaciente = idpaciente;
	}

}
