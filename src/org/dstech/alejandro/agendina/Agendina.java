package org.dstech.alejandro.agendina;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agendina implements Serializable {
	/**
	 * (+39 338 1234567 | +39 3381234567 | 3381234567 | +39 338 123 4567)
	 * (\+\\d{2,3}
	 */
	private static final long serialVersionUID = 1L;
	private static List<Persona> listaPersone = new ArrayList<Persona>();
	private static final String NUM_TEL = "[+]\\d{2}[\\s]\\d{3}[\\s]\\d{7}|[+]\\d{2}[\\s]\\d{10}|\\d{10}|[+]\\d{2}[\\s]\\d{3}[\\s]\\d{3}[\\s]\\d{4}";
	private static final String EMAIL = "\\w\\w\\w[@]\\w\\w[.]\\w\\w";

	private static boolean telefonoCheck(String telefono) {
		Pattern pattern = Pattern.compile(NUM_TEL);
		Matcher matcher = pattern.matcher(telefono);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public static void addPersona() {

		Persona p = new Persona();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il nome");
		p.setNome(scanner.nextLine());
		System.out.println("Inserisci il cognome");
		p.setCognome(scanner.nextLine());
		System.out.println("Inserisci il età");
		p.setEta(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Inserisci il telefono");
		while (true) {
			String telefono = scanner.nextLine();
			if (telefonoCheck(telefono)) {
				p.setTelefono(telefono);
				System.out.println("Formato giusto");
				break;
			}
			System.out.println("Fromato sbagliato,riprova");
		}
		System.out.println("Inserisci il email");
		p.setEmail(scanner.nextLine());

		listaPersone.add(p);
		stampListPersone();
	}

	public static void stampListPersone() {
		List<String> nomi = new ArrayList<String>();
		for (Persona p : listaPersone)
			nomi.add(p.getNome() + " " + p.getCognome());
		System.out.println(nomi);
	}

	public static void modifica() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il nome del contatto da modificare");
		String s = scanner.nextLine();
		for (Persona p : listaPersone)
			if (p.getNome() == s)
				try {
					System.out.println("Premi 0 per uscire o premi un numero per andare al menu modifica");
					int nextInt = scanner.nextInt();
					while (nextInt != 0) {
						showMenuModifica();
						nextInt = scanner.nextInt();
						switch (nextInt) {
						case 1:
							System.out.println("Aggiorna il nome");
							p.setNome(scanner.nextLine());
							break;
						case 2:
							System.out.println("Aggiorna il cognome");
							p.setCognome(scanner.nextLine());
							break;
						case 3:
							System.out.println("Aggiorna l'età");
							p.setEta(scanner.nextInt());
							break;
						case 4:
							System.out.println("Aggiorna il telefono");
							p.setTelefono(scanner.nextLine());
							break;
						case 5:
							System.out.println("Aggiorna l'email");
							p.setEmail(scanner.nextLine());
							break;
						}
					}
				} catch (InputMismatchException exp) {
					System.out.println("Only int");

				} catch (NumberFormatException exp) {
					System.out.println("Only int");

				}
	}

	public static void removePersona() {
		System.out.println("Inserisci il nome della persona da rimuovere");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		for (Persona p : listaPersone)
			if (s == p.getNome())
				listaPersone.remove(p);
	}

	public static void searchForTelefono() {
		System.out.println("Inserisci il telefono della persona da cercare");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		for (Persona i : listaPersone) {
			if (i.getTelefono() == s)
				System.out.println(i);
		}

	}

	public static void searchForNome() {
		System.out.println("Inserisci il nome della persona da cercare");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();

		for (Persona i : listaPersone) {
			if (i.getNome() == s)
				System.out.println(i);
		}

	}

	public static void stampListPersoneAlpha() {
		System.out.println("Digita 1 se vuoi ordinare per nome o digita 2 per ordinare per cognome");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<String> nomi = new ArrayList<String>();
		List<String> cognomi = new ArrayList<String>();
		switch (n) {
		case 1:
			for (Persona p : listaPersone)
				nomi.add(p.getNome());
			Collections.sort(nomi, String.CASE_INSENSITIVE_ORDER);
			System.out.println(nomi);
		case 2:
			for (Persona p : listaPersone)
				cognomi.add(p.getCognome());
			Collections.sort(cognomi, String.CASE_INSENSITIVE_ORDER);
			System.out.println(cognomi);
		}
	}

	public static void salvaAgendina() throws IOException {
		Agendina agendina = new Agendina();
		try {
			LetturaScritturaItemSerializable.salvaListaOggetti("C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj",listaPersone);
			System.out.println("Agendina salvata con successo");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void leggiAgendina() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			listaPersone = (LetturaScritturaItemSerializable.recuperaListaOggetti(
					"C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj"));
		} catch (FileNotFoundException exc) {
			System.out.println(exc);
			FileOutputStream file = new FileOutputStream(
					"C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj");
			System.out.println("agendina.jjj ora è stata creata");
		}
	}

	private static void showMenuModifica() {
		System.out.println("################################");
		System.out.println("Menu modifica :");
		System.out.println("################################");
		System.out.println("0 - Esci");
		System.out.println("1 - Modifica nome");
		System.out.println("2 - Modifica cognome");
		System.out.println("3 - Modifica età");
		System.out.println("4 - Modifica telefono");
		System.out.println("5 - Modifica email");
		System.out.println("################################");
	}

}
