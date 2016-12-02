package wow.model.race;

import wow.model.Personnage;

public class Troll extends Personnage {
	
	public Troll() {
		listeClasse.add("Chaman");
		listeClasse.add("Chasseur");
		listeClasse.add("Mage");
		listeClasse.add("Pretre");
		listeClasse.add("Voleur");
		
		this.endurance 			= 21;
		this.force 				= 21;
		this.agilite			= 22;
		this.esprit				= 21;
		this.intelligence		= 16;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
	}
	
}
