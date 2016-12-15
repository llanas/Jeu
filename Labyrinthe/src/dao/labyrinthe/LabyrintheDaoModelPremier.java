package dao.labyrinthe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Case;
import model.Labyrinthe;

public class LabyrintheDaoModelPremier implements LabyrintheDao {

	private List<List<Case>> chemins = new ArrayList<List<Case>>();
	
	@Override
	public void generateurChemin(Labyrinthe labyrinthe) {

		initialiserChemin(labyrinthe);
		List<Integer> portesPossible = new ArrayList<>(labyrinthe.getTaille());
		while(!portesPossible.isEmpty()) {
			Random rand = new Random();
			int porteATraiter = rand.nextInt(portesPossible.size());
			System.out.println("Porte à traiter    :               " + porteATraiter);
			int positionCaseX = (int) Math.floor(porteATraiter/2);
			Case caseX = labyrinthe.getCase(positionCaseX);
			System.out.println("VALEUR             :               " + caseX.getNumero());
			int choixPorteCase = ( porteATraiter % 2);
			if(choixPorteCase==0) {
				//PORTE BASSE A OUVRIR
				Case caseY = labyrinthe.getCase( positionCaseX + labyrinthe.getTaille() );
				if( caseX.getNumero() < caseY.getNumero() ) {
					caseY.setNumero(caseX.getNumero());
				} else {
					caseX.setNumero(caseY.getNumero());
				}
				caseX.setB();
			} else {
				//PORTE DROITE A OUVRIR
				Case caseY = labyrinthe.getCase( positionCaseX + 1 );
				if( caseX.getNumero() < caseY.getNumero() ) {
					caseY.setNumero(caseX.getNumero());
				} else {
					caseX.setNumero(caseY.getNumero());
				}
				caseX.setD();
			}
//			int y = 0;
//			int test = rand.nextInt(2);
//			if( test == 0 && caseX.getColonne() != labyrinthe.getTaille()-1 ) {
//				y = x + labyrinthe.getTaille();
//				Case caseY = labyrinthe.getCase(y);
//				System.out.println("Case à comparer :                 " + caseY.getPosition());
//				System.out.println("VALEUR          :                 " + caseY.getNumero());
//				if(caseX.getNumero() != caseY.getNumero()) {
//					comparerCase(caseX, caseY);
//					caseX.setB();
//				}
//				
//			} else if (test == 1 && caseX.getLigne() != labyrinthe.getTaille()-1 ) {
//				y = x + 1;
//				Case caseY = labyrinthe.getCase(y);
//				System.out.println("Case à comparer :                 " + caseY.getPosition());
//				System.out.println("VALEUR          :                 " + caseY.getNumero());
//				if(caseX.getNumero() != caseY.getNumero()) {
//					comparerCase(caseX, caseY);
//					caseX.setD();
//				}
//			}
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
			System.out.println("La case " + y.getPosition() + " devient : " + x.getNumero());
			chemins.get(x.getNumero()).addAll(chemins.get(y.getNumero()));
			chemins.get(x.getNumero()).forEach(p -> p.setNumero(x.getNumero()));
			chemins.remove(y.getPosition());
		} else {
			System.out.println("La case " + x.getPosition() + " devient : " + y.getNumero());
			chemins.get(y.getNumero()).addAll(chemins.get(x.getNumero()));
			chemins.get(y.getNumero()).forEach(p -> p.setNumero(y.getNumero()));
			chemins.remove(x.getPosition());
		}
	}
	
	/*
	 * NOUVEAU MODEL:
	 * 
	 * int T = taille; //largeur du labyrinthe;
	 * 
	 * private List<Integer> portePossible = new ArrayList<Integer>(2T²);
	 * 
	 * Random rand = new Random();
	 * 
	 * int porteATraiter = rand.nextInt(portePossible.length());
	 * 
	 * Case caseATraiter = labyrinthe.getCase(Math.floor(porteATraiter)) //Arondie inférieur
	 * 
	 * if(porteATraiter % 2 = 0 ) {
	 * 		traiterPorteBasse(caseATraiter);
	 * } else {
	 * 		traiterPorteDroite(caseATraiter);
	 * }
	 * 
	 * 
	 * 
	 * 
	 */

}
