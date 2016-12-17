package console;
import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.ModelPremierDaoFactory;
import dao.Traitement;
import model.Case;
import model.Labyrinthe;

public class Main {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long debut = System.currentTimeMillis();
		System.out.println("Entrez la taille du labyrinthe : ");
		int taille = sc.nextInt();
		Labyrinthe labyrinthe = new Labyrinthe(taille);
		DaoFactory daoFactory = new ModelPremierDaoFactory();
		daoFactory.getLabyrintheDao().generateurChemin(labyrinthe);
		System.out.println("                                    ");
		System.out.println("            RESULTAT FINAL          ");
		labyrinthe.afficherLabyrinthe();
		System.out.println("\n");
		System.out.println((System.currentTimeMillis())-debut + " secondes d'executions");
		Traitement t = new Traitement();
		t.trouverSorti(labyrinthe).forEach(c -> System.out.print(c.getPosition()));
		sc.close();
	}

}
