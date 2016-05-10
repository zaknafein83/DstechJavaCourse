/**
 * 
 */
package org.dstech.lulizi.contapositivi;

/**
 * @author luca
 *
 */
import java.util.Scanner;

/**
 * @author luca
 *
 */
public class ContaPositivi {

	public static void main(String[] args) {
		int num = 0;
		int contatoreNumPos = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("***********CONTA POSITIVI************");
		System.out.println();
		System.out.println(
				"Inserisci una sequenza di numeri interi separati da spazi e terminati da un carattere, es. X):");

		do {
			num = input.nextInt();
			if ((num > 0) && (num == (int) num)) {
				++contatoreNumPos;
			}

		} while (input.hasNextInt());

		System.out.println("Hai inserito " + contatoreNumPos + " numeri interi positivi");

	}

}

