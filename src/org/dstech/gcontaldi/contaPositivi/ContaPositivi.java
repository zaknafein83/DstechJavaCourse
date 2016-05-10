/**
 * 
 */
package org.dstech.gcontaldi.contaPositivi;

import java.util.Scanner;

/**
 * @author Gianluca
 *
 */
public class ContaPositivi {

	public static void main(String[] args) {

		int num = 0;
		int contatorePos = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci una sequenza di numeri interi separati da spazi e terminati da un carattere");

		do {
			num = sc.nextInt();
			if ((num > 0) && (num == (int) num)) {
				++contatorePos;
			}

		} while (sc.hasNextInt());

		System.out.println("Hai inserito " + contatorePos + " numeri interi positivi");

	}

}
