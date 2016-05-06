package org.dstech.edoardo.esercizio1Test;

import java.util.Scanner;

class ContaPositii {
	
	public static void main(String[] args) {
		
		int numero=0;
		int positivi;
		
		Scanner utente = new Scanner(System.in);
		
		System.out.println("Scrivi numeri interi");
		
		int i = utente.nextInt();
		positivi = 0;
		
		while (utente.hasNext()){
			
			int x = utente.nextInt();
			if (numero > 0)
				positivi = positivi + 1;

		}
		
		System.out.print("La sequenza contiene ");
		System.out.print(positivi);
	}
	
}
