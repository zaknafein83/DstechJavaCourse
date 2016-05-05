package org.dstech.llamonica.agendina;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	//public  List<Persone> listaPersone = new ArrayList();

	

	public static void main(String[] args) {

		Persone persone = new Persone();
        Main main=new Main();
		Inserimento inserimento = new Inserimento();
		// Scanner scanner=new Scanner(System.in);
		// System.out.println("cosa vuoi fare?");
		// System.out.println("1-Aggiungi persona");
		// System.out.println("2-Visualizza agenda");
		// System.out.println("3-Modifica contatto");
		// System.out.println("4-Elimina contatto");
		// System.out.println("5-Ricarca ordine telefono");
		// System.out.println("6-Stampa per ordine alfabetico");
		// System.out.println("7-Salva");

		for (int i = 0; i < 200; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("cosa vuoi fare?");
			System.out.println("1-Aggiungi persona");
			System.out.println("2-Visualizza agenda");
			System.out.println("3-Modifica contatto");
			System.out.println("4-Elimina contatto");
			System.out.println("5-Ricarca ordine telefono");
			System.out.println("6-Stampa per ordine alfabetico");
			System.out.println("7-Salva");

			int scelta = scanner.nextInt();
			switch (scelta) {
			case 1:
				inserimento.inserisciPersona();
				System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione: 9");
				Scanner scanner4 = new Scanner(System.in);
				int scelta1 = scanner4.nextInt();
				if (scelta1 == 1) {
					break;
				} else {
					i = 200;
					
					break;
				}
			case 2:
				System.out.println(inserimento.listaPersone);
				System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione: ");
				Scanner scanner5 = new Scanner(System.in);
				int scelta2 = scanner5.nextInt();
				if (scelta2 == 1) {
					break;
				} else {
					i = 200;
					break;
				}

			case 3:
				System.out.println("inserisci cognome");
				inserimento.modificaPersona();
				System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione: 9");
				Scanner scanner6 = new Scanner(System.in);
				int scelta3 = scanner6.nextInt();
				if (scelta3 == 1) {
					break;
				} else {
					i = 200;
					break;
				}

			case 4:
               inserimento.rimuoverePersone();
				System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione: 9");
				Scanner scanner7 = new Scanner(System.in);
				int scelta4 = scanner7.nextInt();
				if (scelta4 == 1) {
					break;
				} else {
					i = 200;
					break;
				}
			case 5:
	               inserimento.numeroTelefono();
					System.out.println("per tornare al menu:1");
					System.out.println("per chiudere applicazione: 9");
					Scanner scanner8 = new Scanner(System.in);
					int scelta5 = scanner8.nextInt();
					if (scelta5 == 1) {
						break;
					} else {
						i = 200;
						break;
					}

			}
			System.out.println("ARRIVEDERCI!!!!!");

			// System.out.println(listaPersone);

			// persone.setNome("francesco");
			// persone.setTelefono("+39 338 1234895");

			// System.out.println(listaPersone);

			// listaPersone.remove(persone);
			// inserimento.numeroTelefono("+39 338 1234567");

			// inserimento.inserisciPersona();

	
		}
	}
}