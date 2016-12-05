package wow.model.race;

import wow.model.Personnage;

public class Elfe extends Personnage {
	
	public Elfe() {
		super.listeClasse.add("Pretre");
		super.listeClasse.add("Voleur");
		super.listeClasse.add("Druide");
		super.listeClasse.add("Chasseur");
		
		this.endurance 			= 19;
		this.force 				= 17;
		this.agilite			= 25;
		this.esprit				= 20;
		this.intelligence		= 20;
		
		super.caracUpdate();
		this.pv = this.pvMaximum;
		this.mana = this.manaMax;
		
	}
}
