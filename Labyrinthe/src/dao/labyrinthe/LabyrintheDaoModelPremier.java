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
		int tailleLab = labyrinthe.getTaille()*labyrinthe.getTaille();
		System.out.println(chemins.get(0).size());
		while(chemins.get(0).size() != tailleLab) {
			Random rand = new Random();
			int x = rand.nextInt(chemins.size()-1);
			System.out.println("Case à traiter    :               " + x);
			Case caseX = labyrinthe.getCase(x);
			System.out.println("VALEUR            :               " + caseX.getNumero());
			int y = 0;
			int test = rand.nextInt(2);
			if( test == 0 && caseX.getColonne() != labyrinthe.getTaille()-1 ) {
				y = x + labyrinthe.getTaille();
				Case caseY = labyrinthe.getCase(y);
				System.out.println("Case à comparer :                 " + caseY.getPosition());
				System.out.println("VALEUR          :                 " + caseY.getNumero());
				if(caseX.getNumero() != caseY.getNumero()) {
					comparerCase(caseX, caseY);
					caseX.setB();
				}
				
			} else if (test == 1 && caseX.getLigne() != labyrinthe.getTaille()-1 ) {
				y = x + 1;
				Case caseY = labyrinthe.getCase(y);
				System.out.println("Case à comparer :                 " + caseY.getPosition());
				System.out.println("VALEUR          :                 " + caseY.getNumero());
				if(caseX.getNumero() != caseY.getNumero()) {
					comparerCase(caseX, caseY);
					caseX.setD();
				}
			}
			chemins.forEach(c ->{
				c.forEach(l -> {
					System.out.print(l.getPosition() + "-");
				});
				System.out.print("\n");
			});
			
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

}
