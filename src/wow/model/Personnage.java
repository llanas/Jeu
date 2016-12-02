package wow.model;

import java.util.ArrayList;
import java.util.List;

import wow.dao.Classe;

public class Personnage {

	protected Classe classe;
	
	private static final String CHEMIN_CLASSE 		= "wow.dao.classe.";

	protected List<String> listeClasse				= new ArrayList<String>();
	
	
	protected String race;
	protected String name;
	
	protected int pvMaximum = 100;
	protected int pv;
	protected int manaMax = 100;
	protected int mana;
	protected int puissanceAttaque;
	protected int puissanceSort;
	protected int critique;
	
	protected int endurance;
	protected int force;
	protected int agilite;
	protected int esprit;
	protected int intelligence;
	
	public Personnage() {
		listeClasse.add("Guerrier");
	}
	
	public void selectionClasse( int index ) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.classe = (Classe) Class.forName(CHEMIN_CLASSE + listeClasse.get(index)).newInstance();
	}
	
	public void caracUpdate() {
		
		this.pvMaximum 								+= this.endurance;
		this.manaMax								+= this.intelligence;
		this.puissanceAttaque 						= ( (this.puissanceAttaque + this.force) / 2 );
		this.puissanceSort							= ( (this.puissanceSort + this.intelligence ) / 2 );
		this.critique								= ( (this.critique + this.agilite) / 4 );
		
	}
	
	public List<String> getListeClasse() {
		return this.listeClasse;
	}
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPvMaximum() {
		return pvMaximum;
	}

	public void setPvMaximum(int pvMaximum) {
		this.pvMaximum = pvMaximum;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public int getManaMax() {
		return manaMax;
	}

	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getPuissanceAttaque() {
		return puissanceAttaque;
	}

	public void setPuissanceAttaque(int puissanceAttaque) {
		this.puissanceAttaque = puissanceAttaque;
	}

	public int getPuissanceSort() {
		return puissanceSort;
	}

	public void setPuissanceSort(int puissanceSort) {
		this.puissanceSort = puissanceSort;
	}

	public int getCritique() {
		return critique;
	}

	public void setCritique(int critique) {
		this.critique = critique;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getAgilite() {
		return agilite;
	}

	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	public int getEsprit() {
		return esprit;
	}

	public void setEsprit(int esprit) {
		this.esprit = esprit;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	
	
}
