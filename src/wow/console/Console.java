package wow.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import wow.model.Personnage;
import wow.model.race.*;

public class Console {
	
	public static void main(String[] args) {
		
		Personnage joueur = new Elfe();
		try {
			joueur.getListeClasse().forEach(System.out::println);
			Scanner sc = new Scanner(System.in);
			joueur.selectionClasse(sc.nextInt());
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
