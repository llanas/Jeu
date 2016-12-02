package wow.model.race;

import wow.model.Personnage;

public class Gnome extends Personnage {
	
	public Gnome() {
		listeClasse.add("Demoniste");
		listeClasse.add("Mage");
		listeClasse.add("Voleur");
		
		this.endurance 			= 19;
		this.force 				= 15;
		this.agilite			= 23;
		this.esprit				= 24;
		this.intelligence		= 20;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
	}

}
