package org.dstech.gcontaldi.agendina;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Persone persone = Operazioni.creaPersona();
		Operazioni operazioni = new Operazioni();

		for (int i = 0; i < 100; i++) {

			System.out.println("Cosa vuoi fare?");
			System.out.println("1 - Aggiungi contatto");
			System.out.println("2 - Visualizza agenda");
			System.out.println("3 - Modifica contatto");
			System.out.println("4 - Elimina contatto");
			System.out.println("5 - Ricerca per telefono");
			System.out.println("6 - Stampa agenda in ordine alfabetico");
			System.out.println("7 - Salva");

			Scanner scanner = new Scanner(System.in);
			int scelta = scanner.nextInt();
			switch (scelta) {
			case 1:
				Operazioni.creaPersona();
				System.out.println("Hai inserito un contatto!");
				System.out.println("Cosa vuoi fare?");
				System.out.println("1 = torna al menu");
				System.out.println("9 = chiudi app");
				int torna = scanner.nextInt();
				if (torna == 1) {
					break;
				} else {
					break;
				}

			case 2:
				// System.out.println(list);
				System.out.println("Cosa vuoi fare?");
				System.out.println("1 = torna al menu");
				System.out.println("9 = chiudi app");
				int stampa = scanner.nextInt();
				if (stampa == 1) {
					break;
				} else {
					break;
				}
			case 3:
				System.out.println("Chi vuoi modificare? Inserisci cognome.");
				operazioni.modificaPersona();
				System.out.println("Contatto modificato");
				System.out.println("Cosa vuoi fare?");
				System.out.println("1 = torna al menu");
				System.out.println("9 = chiudi app");
				int modifica = scanner.nextInt();
				if (modifica == 1) {
					break;
				} else {
					break;
				}
			case 4:
				System.out.println("Chi vuoi elimiare? Inserisci cognome.");
				operazioni.rimuoviPersona();
				System.out.println("Contatto eliminato");
				System.out.println("Cosa vuoi fare?");
				System.out.println("1 = torna al menu");
				System.out.println("9 = chiudi app");
				int rimuovi = scanner.nextInt();
				if (rimuovi == 1) {
					break;
				} else {
					break;
				}
			case 5:
				System.out.println("Chi vuoi cercare? Inserisci telefono.");
				operazioni.ricerca();
				System.out.println();
				int ricerca = scanner.nextInt();
				if (ricerca == 1) {
					break;
				} else {
					break;
				}

			}

		}
	}
}
