package wow.model.race;

import wow.model.Personnage;

public class Orc extends Personnage {
	
	public Orc() {
		listeClasse.add("Chaman");
		listeClasse.add("Chasseur");
		listeClasse.add("Demoniste");
		listeClasse.add("Voleur");
		
		this.endurance 			= 22;
		this.force 				= 23;
		this.agilite			= 17;
		this.esprit				= 23;
		this.intelligence		= 17;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
	}

}
