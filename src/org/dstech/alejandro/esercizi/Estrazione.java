/**
 * 
 */
package org.dstech.alejandro.esercizi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alejandro
 *
 */
public class Estrazione {
	
	Date data = new Date();
	SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/mm/yyyy");
	Date newDate = new Date();
	SimpleDateFormat format = new SimpleDateFormat();
//	dateFormat.format(newDate);
	
	private SimpleDateFormat d = new SimpleDateFormat();
	private int[] estrazione;
	private static List<Estrazione> listEstrazioni = new ArrayList<Estrazione>();
	
	
	public Estrazione(){
		int o;
		for(int i=0;i<5;i++){
			for(int c=0;c<estrazione.length;c++){
				
			}
		}
		
	}
	
	
	public static void addEstrazione(){
		Estrazione e = new Estrazione();
		listEstrazioni.add(e);
	}
	
	@Override
	public String toString() {
		return "Estrazione [estrazione=" + estrazione + "]";
	}

	public static void stampListEstrazioni(){
			System.out.println(listEstrazioni);
	}
	
	public static void salvaEstrazioni(){
		
	}

}
