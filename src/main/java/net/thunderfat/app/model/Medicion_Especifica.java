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
@Table(name = "medicion_especifica")
public class Medicion_Especifica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_medicionespecifica;
	private double grasavisceral;
	private double retencionliquidos;
	private double aguaid;
	private double litrosagua;
	private double porcentajeagua;
	private double musculo_idmax;
	private double musculo_idmin;
	private double mbi;
	private double metabolismo;
	private int edad_met;
	private double musculo;
	private double masa_osea;
	private double poxmus_max;
	private double poxmus_min;
	private double porcentajegrasa;
	private double grasas;
	private double grasasid_min;
	private double grasaid_max;
	private double peso;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fecha;
	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	public Medicion_Especifica() {
		super();
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getMusculo() {
		return musculo;
	}

	public void setMusculo(double musculo) {
		this.musculo = musculo;
	}

	public double getMusculo_idmin() {
		return musculo_idmin;
	}

	public void setMusculo_idmin(double musculo_idmin) {
		this.musculo_idmin = musculo_idmin;
	}

	public double getPorcentajeagua() {
		return porcentajeagua;
	}

	public void setPorcentajeagua(double porcentajeagua) {
		this.porcentajeagua = porcentajeagua;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public double getPorcentajegrasa() {
		return porcentajegrasa;
	}

	public void setPorcentajegrasa(double procentajegrasa) {
		this.porcentajegrasa = procentajegrasa;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Medicion_Especifica [id_medicionespecifica=" + id_medicionespecifica + ", grasavisceral="
				+ grasavisceral + ", retencionliquidos=" + retencionliquidos + ", aguaid=" + aguaid + ", litrosagua="
				+ litrosagua + ", porcentajeagua=" + porcentajeagua + ", musculo_idmax=" + musculo_idmax
				+ ", musculo_idmin=" + musculo_idmin + ", mbi=" + mbi + ", metabolismo=" + metabolismo + ", edad_met="
				+ edad_met + ", musculo=" + musculo + ", masa_osea=" + masa_osea + ", poxmus_max=" + poxmus_max
				+ ", poxmus_min=" + poxmus_min + ", porcentajegrasa=" + porcentajegrasa + ", grasas=" + grasas
				+ ", grasasid_min=" + grasasid_min + ", grasaid_max=" + grasaid_max + ", peso=" + peso + ", fecha="
				+ fecha + ", paciente=" + paciente + "]";
	}

	//
	//

	// PesoOxMuscMax = Músculo * 100 / 72
	// PesoOxMuscMin = Músculo * 100 / 80
	
	

	public void calcularMBI() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.mbi = 66.5 + (13.75 * this.peso) + (500.3 * this.paciente.getAltura()) - (6.775 * this.calcularEdad());
		} else {
			this.mbi = 665.1 + (9.563 * this.peso) + (185 * (this.paciente.getAltura() * 100))
					- (4.676 * this.calcularEdad());

		}

	}

	public void calcularMusculoIdMax() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.musculo_idmax = 0.78 * 23 * Math.pow(this.paciente.getAltura(), 2);
		} else {
			this.musculo_idmax = 0.72 * 22 * Math.pow(this.paciente.getAltura(), 2);
		}
	}

	public void calcularMusculoIdMin() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.musculo_idmin = 0.85 * 23 * Math.pow(this.paciente.getAltura(), 2);
		} else {
			this.musculo_idmin = 0.8 * 22 * Math.pow(this.paciente.getAltura(), 2);
		}

	}

	public void calcularGrasaIdMin() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.grasasid_min = 0.22 * 23 * Math.pow(this.paciente.getAltura(), 2);
		} else {
			this.grasasid_min = 0.28 * 22 * Math.pow(this.paciente.getAltura(), 2);
		}
	}

	public void calcularGrasasIdMax() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.grasaid_max = 0.15 * 23 * Math.pow(this.paciente.getAltura(), 2);
		} else {

			this.grasaid_max = 0.2 * 22 * Math.pow(this.paciente.getAltura(), 2);
		}
	}

	public void calcularAguaId() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.aguaid = 55 * 23 * Math.pow(this.paciente.getAltura(), 2) / 100;
		} else {
			this.aguaid = 50 * 22 * Math.pow(this.paciente.getAltura(), 2) / 100;
			
		}
	}

	public void calcularLitrosAgua() {
		litrosagua = this.porcentajeagua * peso / 100;
	}

	public void calcularRetencionLiquidos() {
		this.retencionliquidos = this.litrosagua - this.aguaid;
	}

	public void calcularPesoOxMuscMax() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.poxmus_max = this.musculo * 100 / 78;
		} else {
			this.poxmus_max = this.musculo * 100 / 72;
		}

	}

	public void calcularPesoOxMuscMin() {
		if (this.paciente.getSexo().equals("hombre")) {
			this.poxmus_min = this.musculo * 100 / 85;
		} else {
			this.poxmus_min = this.musculo * 100 / 80;
		}
	}

	public void calcularGrasas() {
		this.grasas = porcentajegrasa * peso / 100;
	}

	public int calcularEdad() {
		int añonacimiento = this.paciente.getFechanacimiento().getYear();
		int anoactual = LocalDate.now().getYear();
		return anoactual - añonacimiento;
	}

}
