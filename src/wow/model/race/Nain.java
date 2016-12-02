package wow.model.race;

import wow.model.Personnage;

public class Nain extends Personnage {
	
	public Nain() {
		listeClasse.add("Chasseur");
		listeClasse.add("Mage");
		listeClasse.add("Paladin");
		listeClasse.add("Pretre");
		listeClasse.add("Voleur");
		
		this.endurance 			= 23;
		this.force 				= 22;
		this.agilite			= 16;
		this.esprit				= 19;
		this.intelligence		= 19;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
	}

}
