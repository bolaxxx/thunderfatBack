package net.thunderfat.app.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "comidas")
public class Comida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_comida;
	@ManyToOne
	@JoinColumn(name = "plandieta_id")
	private PlanDieta plandieta;
	
	
	@DateTimeFormat(iso= ISO.DATE)
	private LocalDate fecha;
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime hora;
	private int  valoracion;
	//private double cantidad;
	@OneToMany(fetch = FetchType.LAZY,mappedBy="comida")
	private List<PlatoPlanDieta> platos=new ArrayList<PlatoPlanDieta>();
	
	public Comida() {
		super();
	}

	

	

	public PlanDieta getPlandieta() {
		return plandieta;
	}

	public void setPlandieta(PlanDieta plandieta) {
		this.plandieta = plandieta;
	}






	public LocalDate getFecha() {
		return fecha;
	}





	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}





	public int getId_comida() {
		return id_comida;
	}





	public void setId_comida(int id_comida) {
		this.id_comida = id_comida;
	}





	




	public int getValoracion() {
		return valoracion;
	}





	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}





	




	public LocalTime getHora() {
		return hora;
	}





	public void setHora(LocalTime hora) {
		this.hora = hora;
	}





	public List<PlatoPlanDieta> getPlatos() {
		return platos;
	}





	public void setPlatos(List<PlatoPlanDieta> platos) {
		this.platos = platos;
	}








}
