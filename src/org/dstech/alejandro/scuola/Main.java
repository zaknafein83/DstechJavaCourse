/**
 * 
 */
package org.dstech.alejandro.scuola;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.dstech.alejandro.agendina.Agendina;

/**
 * @author Alejandro
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		menu();
	}
	public static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("################################");
		System.out.println("M E N U :");
		System.out.println("################################");
		System.out.println("0 - Esci");
		System.out.println("1 - Aggiungi uno studente a una classe");
		System.out.println("2 - Fai l'appello");
		System.out.println("3 - Stampa gli alunni della classe");
		System.out.println("4 - Stampa le presenze di una data");
		System.out.println("5 - Salva dati");
		System.out.println("################################");

	}

	public static void menu() throws IOException {
		Date data = new Date();
		int choice = 9;
		Classe c = new Classe();
		Registro r = new Registro();
		
		Scanner scanner = new Scanner(System.in);

		while (choice != 0) {
			showMenu();
			try {
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					c.addStudente();
					break;
				case 2:
					r.appello(c, data);
					break;
				case 3:
					System.out.println(c.getListaStudenti());
					break;
				case 4:
					System.out.println(r.getPresenze(data));
					break;
				case 5:
					c.save();
					r.save();
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
