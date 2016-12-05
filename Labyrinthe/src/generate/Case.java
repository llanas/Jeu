package generate;

import java.util.ArrayList;
import java.util.List;

public class Case {
	
	private static int nombreCases = 0;
	private int numero;
	private int positionH, positionL;

	boolean b, d;
	
	public List<Case> listCase = new ArrayList<Case>();
	
	public Case(){
		
	}
	
	public Case(int h, int l) {

		numero = nombreCases;
		nombreCases++;
		this.positionH = h;
		this.positionL = l;
		this.listCase.add(this);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPositionH() {
		return positionH;
	}

	public int getPositionL() {
		return positionL;
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
			c.append(" ");
		}
		return c;
	}
	
}
