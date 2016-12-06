package generate;

import java.util.ArrayList;
import java.util.List;

public class Case {
	
	private static int nombreCases = 0;
	private int numero;
	private int position;

	boolean b, d;
	
	public List<Case> listCase = new ArrayList<Case>();
	
	public Case(){
		numero = nombreCases;
		position = nombreCases;
		nombreCases++;
		this.listCase.add(this);
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
