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
@Table(name = "comida")
public class Comida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComida;
	@ManyToOne
	@JoinColumn(name = "id_plandietafk")
	private PlanDieta plandieta;

	private Date fecha;
	
	private String valoracion;
	
	
	public Comida() {
		super();
	}

	public int getIdComida() {
		return idComida;
	}

	public void setIdComida(int idComida) {
		this.idComida = idComida;
	}

	

	public PlanDieta getPlandieta() {
		return plandieta;
	}

	public void setPlandieta(PlanDieta plandieta) {
		this.plandieta = plandieta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Comida [idComida=" + idComida + ", plandieta=" + plandieta + ", fecha=" + fecha + ", valoracion="
				+ valoracion + "]";
	}
 
}
