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
		System.out.println("0 - Esci");
		System.out.println("1 - Aggiungi un contatto");
		System.out.println("2 - Stampa lista dei contatti");
		System.out.println("3 - Modifica contatto");
		System.out.println("4 - Rimuove un contatto");
		System.out.println("5 - Ricerca per nome");
		System.out.println("6 - Ricerca per telefono");
		System.out.println("7 - Stampa la lista dei contatti in ordine alfabetico");
		System.out.println("8 - Salva lista");
		
	}

	public static void menu() throws IOException {
		Scanner scanner = new Scanner(System.in);
		while (true)
			try {
				showMenu();
				int nextInt = Integer.parseInt(scanner.next());
				while (nextInt != 0) {
					showMenu();
					nextInt = scanner.nextInt();
					switch (nextInt) {
					case 1:
						Agendina.addPersona();
					case 2:
						Agendina.stampListPersone();
					case 3:
						Agendina.modifica();
					case 4:
						Agendina.removePersona();
					case 5:
						Agendina.searchForNome();
					case 6:
						Agendina.searchForTelefono();
					case 7:
						Agendina.stampListPersoneAlpha();
					case 8:
						Agendina.salvaAgendina();;
					

					}
				}
			} catch (InputMismatchException exp) {
				System.out.println("Only int");

			} catch (NumberFormatException exp) {
				System.out.println("Only int");

			}
	}

}
