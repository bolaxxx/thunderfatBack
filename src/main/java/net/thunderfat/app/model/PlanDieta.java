package net.thunderfat.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity	
@Table(name="planDieta")
public class PlanDieta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_plandieta;	
	@ManyToOne
	@JoinColumn(name="id_nutricionista")
	private Nutricionista nutricionista;
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Paciente paciente;	
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate fecha_ini;
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate fecha_fin;
	private double cal_rango_min;
	private double cal_rango_max;
	private double ingesta_cal_diaria;
	private double reparto_glucido_diario;
	private double reparto_lipido_diario;
	private double reparto_protido_diario	;
	private int comidas_diarias;
	private short visible;
	private short intercambiable;
	@OneToMany(mappedBy="plandieta")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Comida> comidas;
	
//	@ManyToMany
//	@JoinTable(name="filtros_aplicados",
//	joinColumns=@JoinColumn (name="id_plandieta",referencedColumnName="id_plandieta"),
//	inverseJoinColumns=@JoinColumn(name="id_filtroalimentario",referencedColumnName="id_filtroalimentario"))
	@ManyToOne
	@JoinColumn(name="filtro")
	private FiltroAlimentario filtros_aplicados;
	
	
	
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

	



	public FiltroAlimentario getFiltros_aplicados() {
		return filtros_aplicados;
	}

	public void setFiltros_aplicados(FiltroAlimentario filtros_aplicados) {
		this.filtros_aplicados = filtros_aplicados;
	}

	public LocalDate getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(LocalDate fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
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

	public int getComidas_diarias() {
		return comidas_diarias;
	}

	public void setComidas_diarias(int comidas_diarias) {
		this.comidas_diarias = comidas_diarias;
	}

	@Override
	public String toString() {
		return "PlanDieta [id_plandieta=" + id_plandieta + ", nutricionista=" + nutricionista + ", paciente=" + paciente
				+ ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", cal_rango_min=" + cal_rango_min
				+ ", cal_rango_max=" + cal_rango_max + ", ingesta_cal_diaria=" + ingesta_cal_diaria
				+ ", reparto_glucido_diario=" + reparto_glucido_diario + ", reparto_lipido_diario="
				+ reparto_lipido_diario + ", reparto_protido_diario=" + reparto_protido_diario + ", comidas_diarias="
				+ comidas_diarias + ", visible=" + visible + ", intercambiable=" + intercambiable + ", comidas="
				+ comidas + ", filtros_aplicados=" + filtros_aplicados + "]";
	}





	
	
	

}
