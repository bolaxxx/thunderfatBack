package net.thunderfat.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filtroalimentario")
public class FiltroAlimentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_filtroalimentario;
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "id_nutricionista")
	private Nutricionista nutricionista;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name="alimentos_en_filtro", joinColumns= @JoinColumn
	 * (name="id_filtroalimentario",referencedColumnName="id_filtroalimentario"),
	 * inverseJoinColumns=@JoinColumn(name="id_alimentofk",referencedColumnName=
	 * "id_alimento")) private List<Alimento>alimentos;
	 */

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "alimentos_en_filtro", joinColumns = {
			@JoinColumn(name = "id_filtroalimentario", referencedColumnName = "id_filtroalimentario") }, inverseJoinColumns = {
					@JoinColumn(name = "id_alimentofk", referencedColumnName = "id_alimento") })
	private List<Alimento> alimentos = new ArrayList<Alimento>();

	/*
	 * @ManyToMany(mappedBy="filtros_aplicados") private List<PlanDieta> planes;
	 */
	public FiltroAlimentario() {
		super();
	}

	public int getId_filtroalimentario() {
		return id_filtroalimentario;
	}

	public void setId_filtroalimentario(int id_filtroalimentario) {
		this.id_filtroalimentario = id_filtroalimentario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	

	public List<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	@Override
	public String toString() {
		return "FiltroAlimentario [id_filtroalimentario=" + id_filtroalimentario + ", nombre=" + nombre
				+ ", nutricionista=" + nutricionista + ", alimentos=" + alimentos + "]";
	}

}
