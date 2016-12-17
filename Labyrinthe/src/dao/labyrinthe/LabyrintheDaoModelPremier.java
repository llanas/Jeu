package dao.labyrinthe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Case;
import model.Labyrinthe;

public class LabyrintheDaoModelPremier implements LabyrintheDao {

	private List<List<Case>> chemins = new ArrayList<List<Case>>();
	private List<Integer> portesPossible;
	
	@Override
	public void generateurChemin(Labyrinthe labyrinthe) {

		portesPossible = new ArrayList<>(labyrinthe.getTaille());
		initialiserChemin(labyrinthe);
		initPortesPossible(labyrinthe);
		while(!portesPossible.isEmpty()) {
			Random rand = new Random();
			Integer porteATraiter = portesPossible.get(rand.nextInt(portesPossible.size()));
			int positionCaseX = (int) Math.floor(porteATraiter/2);
			Case caseX = labyrinthe.getCase(positionCaseX);
			int choixPorteCase = ( porteATraiter % 2);
			if(choixPorteCase==0) {
				//PORTE BASSE A OUVRIR
				Case caseY = labyrinthe.getCase( positionCaseX + labyrinthe.getTaille() );
				if(caseX.getNumero() != caseY.getNumero()){ 
					comparerCase(caseX, caseY);
					caseX.setAdj(caseY);
					caseY.setAdj(caseX);
					caseX.setB();
				}
			} else {
				//PORTE DROITE A OUVRIR
				Case caseY = labyrinthe.getCase( positionCaseX + 1 );
				if (caseX.getNumero() != caseY.getNumero()) {
					comparerCase(caseX, caseY);
					caseX.setAdj(caseY);
					caseY.setAdj(caseX);
					caseX.setD();
				}
			}
			portesPossible.remove(porteATraiter);
		}
	}
	
	private void initPortesPossible(Labyrinthe lab) {
		int index = 0;
		for(int ligne = 0 ; ligne < lab.getTaille() ; ligne++ ) {
			for( int colonne = 0 ; colonne < lab.getTaille() ; colonne++ ) {
				if( ligne != lab.getTaille() - 1) {
					portesPossible.add(index); //PAIR
				}
				index++; //IMPAIR
				if( colonne != lab.getTaille() - 1 ) {
					portesPossible.add(index); //IMPAIR
				}
				index++; //PAIR
			}
		}
	}
	
	private void initialiserChemin(Labyrinthe labyrinthe) {
		labyrinthe.getMap().forEach((C,L) ->{
			L.forEach(p ->{
				List<Case> listChemin = new ArrayList<Case>();
 				listChemin.add(labyrinthe.getCase(chemins.size()));
 				chemins.add(listChemin);
			});
		});
	}
	
	private void comparerCase(Case x, Case y) {
		if( x.getNumero() < y.getNumero() ) {
			chemins.get(x.getNumero()).addAll(chemins.get(y.getNumero()));
			chemins.get(x.getNumero()).forEach(p -> p.setNumero(x.getNumero()));
			chemins.remove(y);
		} else {
			chemins.get(y.getNumero()).addAll(chemins.get(x.getNumero()));
			chemins.get(y.getNumero()).forEach(p -> p.setNumero(y.getNumero()));
			chemins.remove(x);
		}
	}
}
