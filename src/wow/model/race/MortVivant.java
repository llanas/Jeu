package wow.model.race;

import wow.model.Personnage;

public class MortVivant extends Personnage {

	public MortVivant() {
		listeClasse.add("Demoniste");
		listeClasse.add("Mage");
		listeClasse.add("Pretre");
		listeClasse.add("Voleur");
		
		this.endurance 			= 21;
		this.force 				= 19;
		this.agilite			= 18;
		this.esprit				= 25;
		this.intelligence		= 18;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
	}
}
