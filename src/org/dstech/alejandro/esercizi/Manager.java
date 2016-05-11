/**
 * 
 */
package org.dstech.alejandro.esercizi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.dstech.alejandro.esercizi.Estrazione;
import org.dstech.alejandro.utility.Menu;

/**
 * @author Alejandro
 *
 */
public class Manager {

	/**
	 * @param args
	 */

	public static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("################################");
		System.out.println("M E N U :");
		System.out.println("################################");
		System.out.println("0 - Esci");
		System.out.println("1 - Nuova estrazione");
		System.out.println("2 - Stampa estrazione");
		System.out.println("3 - Salva estrazioni");
		System.out.println("################################");

	}

	public static void menu() throws IOException {
		int choice = 9;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		while (choice != 0) {
			showMenu();
			try {
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					Estrazione.addEstrazione();
					break;
				case 2:
					Estrazione.stampListEstrazioni();
					break;
				case 3:
					Estrazione.salvaEstrazioni();
					break;
				}

			} catch (InputMismatchException exp) {
				System.out.println("Only int");

			} catch (NumberFormatException exp) {
				System.out.println("Only int");

			}
		}

	}

}
