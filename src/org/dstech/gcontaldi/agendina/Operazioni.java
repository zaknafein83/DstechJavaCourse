package org.dstech.gcontaldi.agendina;

import java.util.Scanner;

public class Operazioni {

	public static void inserisciPersona() {

		Persone persone = new Persone();

		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci nome");
		String nome = sc.nextLine();
		System.out.println("Inserisci cognome");
		String cognome = sc.nextLine();
		System.out.println("Inserisci eta'");
		String eta = sc.nextLine();
		System.out.println("Inserisci telefono");
		String telefono = sc.nextLine();
		System.out.println("Inserisci mail");
		String mail = sc.nextLine();

		persone.setNome(nome);
		persone.setCognome(cognome);
		persone.setEta(eta);
		persone.setTelefono(telefono);
		persone.setMail(mail);

		Main main = new Main();
		main.list.add(persone);
	}

	public static void modificaPersona() {

		Scanner scanner = new Scanner(System.in);
		String inserimento = scanner.nextLine();

		for (Persone elemento : Main.list) {
			if (inserimento == elemento.getCognome()) {
				System.out.println("Che campi vuoi modificare?");
				System.out.println("1 - Modifica nome");
				System.out.println("2 - Modifica cognome");
				System.out.println("3 - Modifica eta");
				System.out.println("4 - Modifica telefono");
				System.out.println("5 - Modifica mail");

				Scanner scanner2 = new Scanner(System.in);
				String modifica = scanner.nextLine();
				int modificaCampo = scanner2.nextInt();
				switch (modificaCampo) {
				case 1:
					elemento.setNome(modifica);
					break;
				case 2:
					elemento.setCognome(modifica);
					break;
				case 3:
					elemento.setEta(modifica);
					break;
				case 4:
					elemento.setTelefono(modifica);
					break;
				case 5:
					elemento.setMail(modifica);
					break;
				}
			}

		}
	}

	public static void rimuoviPersona() {

		Scanner scanner3 = new Scanner(System.in);
		String inserimento = scanner3.nextLine();

		for (Persone elemento : Main.list) {
			if (inserimento == elemento.getCognome()) {
				Main.list.remove(inserimento)

			}
		}

	}
}