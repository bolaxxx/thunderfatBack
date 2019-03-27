package net.thunderfat.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="receta")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_receta;
	private String nombre;
	private String detalle;
	@ManyToOne
	@JoinColumn (name="id_alimento")
	private Plato plato;
	@ManyToOne
	@JoinColumn(name="id_nutricionista")
	private Nutricionista nutricionista;
	
	public Receta() {
		super();
	}


	public int getId_receta() {
		return id_receta;
	}


	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	


	public Nutricionista getNutricionista() {
		return nutricionista;
	}


	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}


	


	public Plato getPlato() {
		return plato;
	}


	public void setPlato(Plato plato) {
		this.plato = plato;
	}


	@Override
	public String toString() {
		return "Receta [id_receta=" + id_receta + ", nombre=" + nombre + ", detalle=" + detalle + ", plato=" + plato
				+ ", nutricionista=" + nutricionista + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_receta;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (id_receta != other.id_receta)
			return false;
		return true;
	}

}
