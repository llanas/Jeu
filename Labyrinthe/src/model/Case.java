package model;

public class Case {
	
	private static int nombreCases = 0;
	private int numero;
	private int position;
	private int colonne;
	private int ligne;

	private boolean b, d;
	
	public Case(){
		
		
	}
	
	public Case( int colonne, int ligne ) {
		this.position = nombreCases++;
		this.numero = position;
		this.colonne = colonne;
		this.ligne = ligne;
	}
	
	public int getColonne() {
		return colonne;
	}

	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	
	public int getPosition() {
		return position;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setB() {
		this.b = true;
	}
	
	public void setD() {
		this.d = true;
	}

	public StringBuilder afficher(){
		
		StringBuilder c = new StringBuilder();
		if(!b){
			c.append("_");
		} else {
			c.append(" ");
		}
		if(!d){
			c.append("|");
		} else {
			c.append(",");
		}
		return c;
	}
}
