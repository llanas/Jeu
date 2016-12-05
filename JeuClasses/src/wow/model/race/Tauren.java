package wow.model.race;

import wow.model.Personnage;

public class Tauren extends Personnage {

	public Tauren() {
		listeClasse.add("Chaman");
		listeClasse.add("Chasseur");
		listeClasse.add("Druide");
		
		this.endurance 			= 22;
		this.force 				= 25;
		this.agilite			= 15;
		this.esprit				= 22;
		this.intelligence		= 15;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
	}
}
