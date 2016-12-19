package dao.labyrinthe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Case;
import model.Labyrinthe;

public class LabyrintheDaoModelPremier implements LabyrintheDao {

	private List<List<Case>> chemins = new ArrayList<>();
	private List<Integer> portesPossible;
	private int[] love = {
			482,484,486,490,492,494,500,502,504,508,512,514,516,520,524,528,532,534,536,
			541,547,549,555,559,565,567,569,571,577,579,581,583,585,587,589,591,597,
			542,546,552,554,560,564,574,580,84,586,594,596,
			603,605,609,611,621,627,629,623,631,633,635,637,643,649,651,653,
			612,628,634,640,646,654,
			663,665,669,673,681,683,691,697,699,701,703,709,705,707,711,715,
			672,694,714,
			723,725,729,731,741,743,751,753,755,757,759,761,763,765,767,769,771,773,
			722,732,734,774,776,
			781,785,789,795,801,803,811,813,815,817,819,821,823,825,827,829,831,837,
			782,784,790,792,794,802,812,816,820,824,828,832,834,836
	};
	
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
					caseX.addAdj(caseY);
					caseY.addAdj(caseX);
					caseX.setB();
				}
			} else {
				//PORTE DROITE A OUVRIR
				Case caseY = labyrinthe.getCase( positionCaseX + 1 );
				if (caseX.getNumero() != caseY.getNumero()) {
					comparerCase(caseX, caseY);
					caseX.addAdj(caseY);
					caseY.addAdj(caseX);
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
				if( ligne != lab.getTaille() - 1 && tabContains(index) ) {
					portesPossible.add(index); //PAIR
				}
				index++; //IMPAIR
				if( colonne != lab.getTaille() - 1 && tabContains(index)) {
					portesPossible.add(index); //IMPAIR
				}
				index++; //PAIR
			}
		}
	}
	
	private boolean tabContains(int index) {
		for (int i = 0; i < love.length ; i++) {
			if(index == love[i]){
				return false;
			}
		}
		return true;
	}

	private void initialiserChemin(Labyrinthe labyrinthe) {
		labyrinthe.getMap().forEach((C,L) ->{
			L.forEach(p ->{
				List<Case> listChemin = new ArrayList<>();
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
