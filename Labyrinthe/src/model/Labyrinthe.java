package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Labyrinthe {
	
	private Map<Integer, List<Case>> map = new HashMap<Integer, List<Case>>();

	private int taille;

	public Labyrinthe(int taille) {
		this.taille = taille;
		initLaby();
	}
	
	public Map<Integer, List<Case>> getMap() {
		return map;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	private void initLaby() {
		for(int h = 0 ; h < this.taille ; h++ ) {
			List<Case> lignes = new ArrayList<Case>();
			for( int l = 0 ; l < this.taille ; l++ ) {
				Case caseCree = new Case(h,l);
				lignes.add(caseCree);
				System.out.print(lignes.get(l).afficher());
			}
			System.out.print("\n");
			map.put(h, lignes);
		}
	}
	
	public Case getCase(int numeroCase) {
		int ligne = (int) Math.floor(numeroCase / taille);
		int colone = ( numeroCase - ( ligne * taille));
		return map.get(ligne).get(colone);
	}
	
	public void afficherLabyrinthe(){
		sautDeLigne(taille);
		map.forEach((C,L) -> {
			L.forEach(p -> System.out.print(p.afficher()));
			System.out.print("\n");
		});
	}
	
	public void sautDeLigne(int taille) {
	
		for(int i = 0 ; i < taille ; i++ ) {
			System.out.print("_,");
		}
		System.out.print("\n");
	}
}
