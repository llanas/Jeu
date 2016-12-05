package wow.model.race;

import wow.model.Personnage;

public class Humain extends Personnage {

	public Humain() {
		listeClasse.add("Chasseur");
		listeClasse.add("Mage");
		listeClasse.add("Paladin");
		listeClasse.add("Pretre");
		listeClasse.add("Voleur");
		
		this.endurance 			= 20;
		this.force 				= 20;
		this.agilite			= 20;
		this.esprit				= 21;
		this.intelligence		= 20;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
	}
}
