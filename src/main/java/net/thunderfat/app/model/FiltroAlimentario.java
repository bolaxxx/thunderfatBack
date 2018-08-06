package net.thunderfat.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="filtroalimentario")
public class FiltroAlimentario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_filtroalimentario;	
	private String nombre;
	@ManyToOne
	@JoinColumn(name="id_nutricionnista")
	private Nutricionista nutricionnista;
	
	
	@ManyToMany
	@JoinTable(name="alimentos_en_filtro",
	joinColumns=@JoinColumn (name="id_filtroalimentario",referencedColumnName="id_filtroalimentario"),
	inverseJoinColumns=@JoinColumn(name="id_alimentofk",referencedColumnName="id_alimento"))
	private List<Alimento>alimentos;
	@ManyToMany(mappedBy="filtros_aplicados")
	private List<PlanDieta> planes;
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
	public Nutricionista getNutricionnista() {
		return nutricionnista;
	}
	public void setNutricionnista(Nutricionista nutricionnista) {
		this.nutricionnista = nutricionnista;
	}
	public List<Alimento> getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(List<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	public List<PlanDieta> getPlanes() {
		return planes;
	}
	public void setPlanes(List<PlanDieta> planes) {
		this.planes = planes;
	}
	@Override
	public String toString() {
		return "FiltroAlimentario [id_filtroalimentario=" + id_filtroalimentario + ", nombre=" + nombre
				+ ", nutricionnista=" + nutricionnista + ", alimentos=" + alimentos + ", planes=" + planes + "]";
	}
	

}
