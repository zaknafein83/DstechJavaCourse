package org.dstech.alejandro.agendina;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

	private static boolean emailCheck(String email) {
		Pattern pattern = Pattern.compile(EMAIL);
		Matcher matcher = pattern.matcher(email);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	public static void addPersona() {

		Persona p = new Persona();

		@SuppressWarnings("resource")
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

		while (true) {
			String email = scanner.nextLine();
			if (emailCheck(email)) {
				p.setTelefono(email);
				System.out.println("Formato giusto");
				break;
			}
			System.out.println("Fromato sbagliato,riprova");
		}

		listaPersone.add(p);

		stampListPersone();

	}

	public static void stampListPersone() {
		List<String> nomi = new ArrayList<String>();
		for (Persona p : listaPersone)
			nomi.add(p.getNome() + " " + p.getCognome());
		System.out.println(nomi);
	}

	public static void modificaPersona() {
		int choice = 10;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il nome del contatto da modificare");
		String s = scanner.nextLine();
		for (Persona p : listaPersone)
			if (p.getNome().equals(s))
				try {

					while (choice != 0) {
						showMenuModifica();
						choice = scanner.nextInt();
						switch (choice) {
						case 1:
							System.out.println("Aggiorna il nome");
							String nome = scanner.nextLine();
							p.setNome(nome);
							break;
						case 2:
							System.out.println("Aggiorna il cognome");
							String cognome = scanner.nextLine();
							p.setCognome(cognome);
							break;
						case 3:
							System.out.println("Aggiorna l'età");
							int eta = scanner.nextInt();
							p.setEta(eta);
							break;
						case 4:
							System.out.println("Aggiorna il telefono");
							String telefono = scanner.nextLine();
							p.setTelefono(telefono);
							break;
						case 5:
							System.out.println("Aggiorna l'email");
							String email = scanner.nextLine();
							p.setEmail(email);
							break;
						}
					}
				} catch (InputMismatchException exp) {
					System.out.println("Only int");

				} catch (NumberFormatException exp) {
					System.out.println("Only int");

				}
	}

	public static void removePersona() throws IOException {
		System.out.println("Inserisci il nome della persona da rimuovere");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		for (Persona p : listaPersone)
			if (s.equals(p.getNome())) {
				listaPersone.remove(p);
				System.out.println("rimosso con successo!");
			}
	}

	public static void searchForTelefono() {
		System.out.println("Inserisci il telefono della persona da cercare");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		for (Persona i : listaPersone) {
			if (i.getTelefono() == s)
				System.out.println(i);
		}

	}

	public static void searchForNome() {
		System.out.println("Inserisci il nome della persona da cercare");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();

		for (Persona i : listaPersone) {
			if (i.getNome() == s)
				System.out.println(i);
		}

	}

	public static void stampListPersoneAlpha() {
		System.out.println("Digita 1 se vuoi ordinare per nome o digita 2 per ordinare per cognome");
		@SuppressWarnings("resource")
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
			break;
		case 2:
			for (Persona p : listaPersone)
				cognomi.add(p.getCognome());
			Collections.sort(cognomi, String.CASE_INSENSITIVE_ORDER);
			System.out.println(cognomi);
			break;
		}
	}

	public static void salvaAgendina() throws IOException {
		new Agendina();
		try {
			LetturaScritturaItemSerializable.salvaListaOggetti(
					"C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj",
					listaPersone);
			System.out.println("Agendina salvata con successo");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void leggiAgendina() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			listaPersone = (LetturaScritturaItemSerializable.recuperaListaOggetti(
					"C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj"));
		} catch (FileNotFoundException exc) {
			System.out.println(exc);
			new FileOutputStream(
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
