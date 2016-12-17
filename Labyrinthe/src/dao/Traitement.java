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
		while(caseActuel.getPosition() < lab.getTaille()*lab.getTaille()-1 ) {
			System.out.println("Je traite la case :" + caseActuel.getPosition());
			
			if( caseActuel.getAdj().size() == 1 && caseActuel.getAdj().contains(solution.get(index)) ) {
				// CUL DE SAC
				oldPosition = caseActuel;
				caseActuel = caseActuel.getAdj().get(0);
				List<Case> temp = caseActuel.getAdj();
				temp.remove(oldPosition);
			} else {
				solution.add(caseActuel);
				oldPosition = caseActuel;
				caseActuel = caseActuel.getAdj().get(rand.nextInt(caseActuel.getAdj().size()));
			}
		}
		return solution;
	}
}
