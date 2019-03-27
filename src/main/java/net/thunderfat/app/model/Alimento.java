package net.thunderfat.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="alimento")
public class Alimento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_alimento;
	private String nombre;	
	private String estado;
	private double cal	;
	private double hidratos_de_carbono	;
	private double h2o;	
	private double noespecifico;
	private double grasas	;
	private double proteinas;	
	private double vitamina_a;
	private double vitamina_b2;	
	private double vitamina_b1;	
	private double vitamina_c;	
	private double niah;	
	private double cobre;	
	private double potasio;	
	private double sodio;	
	private double azufre;	
	private double calcio;	
	private double fosforo;
	private double hierro;	
	private double magnesio;	
	private double cloro;	
	private double met; 	
	private double lis;	;
	private double leu	;
	private double illeu;	
	private double tre;
	private double tri;	
	private double fen	;
	private double val;
	
	
	public Alimento() {
		super();
	}
	
	public int getId_alimento() {
		return id_alimento;
	}
	public void setId_alimento(int id_alimento) {
		this.id_alimento = id_alimento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getCal() {
		return cal;
	}
	public void setCal(double cal) {
		this.cal = cal;
	}
	public double getHidratos_de_carbono() {
		return hidratos_de_carbono;
	}
	public void setHidratos_de_carbono(double hidratos_de_carbono) {
		this.hidratos_de_carbono = hidratos_de_carbono;
	}
	public double getH2o() {
		return h2o;
	}
	public void setH2o(double h2o) {
		this.h2o = h2o;
	}
	
	public double getNoespecifico() {
		return noespecifico;
	}

	public void setNoespecifico(double noespecifico) {
		this.noespecifico = noespecifico;
	}

	public double getGrasas() {
		return grasas;
	}
	public void setGrasas(double grasas) {
		this.grasas = grasas;
	}
	public double getProteinas() {
		return proteinas;
	}
	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}
	public double getVitamina_a() {
		return vitamina_a;
	}
	public void setVitamina_a(double vitamina_a) {
		this.vitamina_a = vitamina_a;
	}
	public double getVitamina_b2() {
		return vitamina_b2;
	}
	public void setVitamina_b2(double vitamina_b2) {
		this.vitamina_b2 = vitamina_b2;
	}
	public double getVitamina_b1() {
		return vitamina_b1;
	}
	public void setVitamina_b1(double vitamina_b1) {
		this.vitamina_b1 = vitamina_b1;
	}
	public double getVitamina_c() {
		return vitamina_c;
	}
	public void setVitamina_c(double vitamina_c) {
		this.vitamina_c = vitamina_c;
	}
	public double getNiah() {
		return niah;
	}
	public void setNiah(double niah) {
		this.niah = niah;
	}
	public double getCobre() {
		return cobre;
	}
	public void setCobre(double cobre) {
		this.cobre = cobre;
	}
	public double getPotasio() {
		return potasio;
	}
	public void setPotasio(double potasio) {
		this.potasio = potasio;
	}
	public double getSodio() {
		return sodio;
	}
	public void setSodio(double sodio) {
		this.sodio = sodio;
	}
	public double getAzufre() {
		return azufre;
	}
	public void setAzufre(double azufre) {
		this.azufre = azufre;
	}
	public double getCalcio() {
		return calcio;
	}
	public void setCalcio(double calcio) {
		this.calcio = calcio;
	}
	public double getFosforo() {
		return fosforo;
	}
	public void setFosforo(double fosforo) {
		this.fosforo = fosforo;
	}
	public double getHierro() {
		return hierro;
	}
	public void setHierro(double hierro) {
		this.hierro = hierro;
	}
	public double getMagnesio() {
		return magnesio;
	}
	public void setMagnesio(double magnesio) {
		this.magnesio = magnesio;
	}
	public double getCloro() {
		return cloro;
	}
	public void setCloro(double cloro) {
		this.cloro = cloro;
	}
	public double getMet() {
		return met;
	}
	public void setMet(double met) {
		this.met = met;
	}
	public double getLis() {
		return lis;
	}
	public void setLis(double lis) {
		this.lis = lis;
	}
	public double getLeu() {
		return leu;
	}
	public void setLeu(double leu) {
		this.leu = leu;
	}
	public double getIlleu() {
		return illeu;
	}
	public void setIlleu(double illeu) {
		this.illeu = illeu;
	}
	public double getTre() {
		return tre;
	}
	public void setTre(double tre) {
		this.tre = tre;
	}
	public double getTri() {
		return tri;
	}
	public void setTri(double tri) {
		this.tri = tri;
	}
	public double getFen() {
		return fen;
	}
	public void setFen(double fen) {
		this.fen = fen;
	}
	public double getVal() {
		return val;
	}
	public void setVal(double val) {
		this.val = val;
	}


	



	@Override
	public String toString() {
		return "Alimento [id_alimento=" + id_alimento + ", nombre=" + nombre + ", estado=" + estado + ", cal=" + cal
				+ ", hidratos_de_carbono=" + hidratos_de_carbono + ", h2o=" + h2o + ", noespecifico=" + noespecifico
				+ ", grasas=" + grasas + ", proteinas=" + proteinas + ", vitamina_a=" + vitamina_a + ", vitamina_b2="
				+ vitamina_b2 + ", vitamina_b1=" + vitamina_b1 + ", vitamina_c=" + vitamina_c + ", niah=" + niah
				+ ", cobre=" + cobre + ", potasio=" + potasio + ", sodio=" + sodio + ", azufre=" + azufre + ", calcio="
				+ calcio + ", fosforo=" + fosforo + ", hierro=" + hierro + ", magnesio=" + magnesio + ", cloro=" + cloro
				+ ", met=" + met + ", lis=" + lis + ", leu=" + leu + ", illeu=" + illeu + ", tre=" + tre + ", tri="
				+ tri + ", fen=" + fen + ", val=" + val + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_alimento;
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
		Alimento other = (Alimento) obj;
		if (id_alimento != other.id_alimento)
			return false;
		return true;
	}

	
}
