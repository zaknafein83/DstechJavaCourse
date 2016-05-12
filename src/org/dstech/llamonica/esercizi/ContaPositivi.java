/**
 * 
 */
package org.dstech.llamonica.esercizi;

import java.util.Scanner;

/**
 * @author luca
 *
 */
public class ContaPositivi {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		

		// String variabile = "c";
		String nome = "x";

		int contapositivi=0;
		int numero;
	
		System.out.println("premere X per uscire");
		while(scanner.hasNextInt())
			{
			numero = scanner.nextInt();
			
				
				if ((numero > 0) && (numero == (int) numero)) {
					++contapositivi;
				
				}

			}
		System.out.println("totale numeri positivi interi " + contapositivi );

	}
			
}	
			
		
		
			
			
		

	


