package net.thunderfat.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity	
@Table(name="planDieta")
public class PlanDieta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_plandieta;	
	@ManyToOne
	@JoinColumn(name="id_nutricionistafk")
	private Nutricionista nutricionista;
	@ManyToOne
	@JoinColumn(name="id_pacientefk")
	private Paciente paciente;	
	
	private Date fecha_ini;
	private Date fecha_fin;
	private double cal_rango_min;
	private double cal_rango_max;
	private double ingesta_cal_diaria;
	private double reparto_glucido_diario;
	private double reparto_lipido_diario;
	private double reparto_protido_diario	;
	private short visible;
	private short intercambiable;
	@OneToMany(mappedBy="plandieta",fetch=FetchType.EAGER)
	private List<Comida> comidas;
	
	@ManyToMany
	@JoinTable(name="filtros_aplicados",
	joinColumns=@JoinColumn (name="id_plandieta",referencedColumnName="id_plandieta"),
	inverseJoinColumns=@JoinColumn(name="id_filtroalimentario",referencedColumnName="id_filtroalimentario"))
	
	private List <FiltroAlimentario> filtros_aplicados;
	
	
	
	public PlanDieta() {
		super();
	}

	public int getId_plandieta() {
		return id_plandieta;
	}

	public void setId_plandieta(int id_plandieta) {
		this.id_plandieta = id_plandieta;
	}

	
	

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Comida> getComidas() {
		return comidas;
	}

	public void setComidas(List<Comida> comidas) {
		this.comidas = comidas;
	}

	public List<FiltroAlimentario> getFiltros_aplicados() {
		return filtros_aplicados;
	}

	public void setFiltros_aplicados(List<FiltroAlimentario> filtros_aplicados) {
		this.filtros_aplicados = filtros_aplicados;
	}

	public Date getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public double getCal_rango_min() {
		return cal_rango_min;
	}

	public void setCal_rango_min(double cal_rango_min) {
		this.cal_rango_min = cal_rango_min;
	}

	public double getCal_rango_max() {
		return cal_rango_max;
	}

	public void setCal_rango_max(double cal_rango_max) {
		this.cal_rango_max = cal_rango_max;
	}

	public double getIngesta_cal_diaria() {
		return ingesta_cal_diaria;
	}

	public void setIngesta_cal_diaria(double ingesta_cal_diaria) {
		this.ingesta_cal_diaria = ingesta_cal_diaria;
	}

	public double getReparto_glucido_diario() {
		return reparto_glucido_diario;
	}

	public void setReparto_glucido_diario(double reparto_glucido_diario) {
		this.reparto_glucido_diario = reparto_glucido_diario;
	}

	public double getReparto_lipido_diario() {
		return reparto_lipido_diario;
	}

	public void setReparto_lipido_diario(double reparto_lipido_diario) {
		this.reparto_lipido_diario = reparto_lipido_diario;
	}

	public double getReparto_protido_diario() {
		return reparto_protido_diario;
	}

	public void setReparto_protido_diario(double reparto_protido_diario) {
		this.reparto_protido_diario = reparto_protido_diario;
	}

	public short getVisible() {
		return visible;
	}

	public void setVisible(short visible) {
		this.visible = visible;
	}

	public short getIntercambiable() {
		return intercambiable;
	}

	public void setIntercambiable(short intercambiable) {
		this.intercambiable = intercambiable;
	}

	@Override
	public String toString() {
		return "PlanDieta [id_plandieta=" + id_plandieta + ", nutricionista=" + nutricionista + ", paciente=" + paciente
				+ ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", cal_rango_min=" + cal_rango_min
				+ ", cal_rango_max=" + cal_rango_max + ", ingesta_cal_diaria=" + ingesta_cal_diaria
				+ ", reparto_glucido_diario=" + reparto_glucido_diario + ", reparto_lipido_diario="
				+ reparto_lipido_diario + ", reparto_protido_diario=" + reparto_protido_diario + ", visible=" + visible
				+ ", intercambiable=" + intercambiable + ", comidas=" + comidas + ", filtros_aplicados="
				+ filtros_aplicados + "]";
	}
	
	
	

}
