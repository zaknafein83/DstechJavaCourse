package org.dstech.alejandro.agendina;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Agendina.leggiAgendina();
		menu();

	}

	/**
	 * 
	 */
	public static void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("################################");
		System.out.println("M E N U :");
		System.out.println("################################");
		System.out.println("0 - Esci");
		System.out.println("1 - Aggiungi un contatto");
		System.out.println("2 - Stampa lista dei contatti");
		System.out.println("3 - Modifica contatto");
		System.out.println("4 - Rimuove un contatto");
		System.out.println("5 - Ricerca per nome");
		System.out.println("6 - Ricerca per telefono");
		System.out.println("7 - Stampa la lista dei contatti in ordine alfabetico");
		System.out.println("8 - Salva lista");
		System.out.println("################################");

	}

	public static void menu() throws IOException {
		int choice = 9;
		Scanner scanner = new Scanner(System.in);

		try {
			while (choice != 0) {
				showMenu();
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					Agendina.addPersona();
					break;
				case 2:
					Agendina.stampListPersone();
					break;
				case 3:
					Agendina.modifica();
					break;
				case 4:
					Agendina.removePersona();
					break;
				case 5:
					Agendina.searchForNome();
					break;
				case 6:
					Agendina.searchForTelefono();
					break;
				case 7:
					Agendina.stampListPersoneAlpha();
					break;
				case 8:
					Agendina.salvaAgendina();
					break;
				}

			}
		} catch (InputMismatchException exp) {
			System.out.println("Only int");

		} catch (NumberFormatException exp) {
			System.out.println("Only int");

		}
		
	}

}
