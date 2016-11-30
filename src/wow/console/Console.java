package wow.console;

import wow.model.Personnage;
import wow.model.race.Elfe;

public class Console {
	
	public static void main(String[] args) {
		
		Personnage joueur = new Elfe();
		try {
			joueur.selectionClasse(0);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Vie maximum  : " + joueur.getPvMaximum() );
		System.out.println("Endurance    : " + joueur.getEndurance() );
		System.out.println("Force        : " + joueur.getForce() );
		System.out.println("Agilite      : " + joueur.getAgilite() );
		System.out.println("Esprit       : " + joueur.getEsprit() );
		System.out.println("Intelligence : " + joueur.getIntelligence() );
		joueur.getClasse().jeterSort();
	}	
}
