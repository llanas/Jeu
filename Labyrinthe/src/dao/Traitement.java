package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Case;
import model.Labyrinthe;

public class Traitement {
	
	public List<Case> trouverSorti(Labyrinthe lab) {
		
		Case caseActuel = lab.getCase(0);
		int index = 0;
		Case oldPosition;
		List<Case> solution = new ArrayList<>();
		Random rand = new Random();
		System.out.println("Je traite la case " + caseActuel.getPosition() + " qui à " + caseActuel.getAdj().size() + " possibilités");
		solution.add(caseActuel);
		oldPosition = caseActuel;
		caseActuel = caseActuel.getAdj().get(rand.nextInt(caseActuel.getAdj().size()));
		System.out.println("Case Actuel      : " + caseActuel.getPosition());
		System.out.println("Ancienne Case    : " + oldPosition.getPosition() + "\n");
		do {
			System.out.println("Je traite la case " + caseActuel.getPosition() + " qui à " + caseActuel.getAdj().size() + " possibilités");
			
			if( caseActuel.getAdj().size() == 1 ) {
				// CUL DE SAC
				System.out.println("Cette case est un cul de sac.");
				solution.remove(caseActuel);
				oldPosition = caseActuel;
				caseActuel = solution.get(solution.size()-1);	
				solution.remove(caseActuel);
			} else {
				caseActuel.removeAdj(oldPosition);
				solution.add(caseActuel);
				oldPosition = caseActuel;
				caseActuel = caseActuel.getAdj().get(rand.nextInt(caseActuel.getAdj().size()));
				System.out.println("Case Actuel      : " + caseActuel.getPosition());
				System.out.println("Ancienne Case    : " + oldPosition.getPosition());
			}
			System.out.print("Solution : ");
			solution.stream().map(p -> p.getPosition()).forEach(p -> System.out.print(" " + p + " "));
			System.out.println("\n");
		} while(caseActuel.getPosition() < lab.getTaille()*lab.getTaille()-1 );
		return solution;
	}
}
