package org.dstech.alejandro.agendina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Agendina {
	private static List<Persona> listaPersone = new ArrayList<Persona>();
	private static final String NUM_TEL = "+*\\d{2} \\d{3} \\d{7}|+*\\d{2} \\d{10}|\\d{10}|+*\\d{2} \\d{3} \\d{3} \\d{4}";
	private static final String EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public void addPersona(Persona p) {
		listaPersone.add(p);
	}

	public void stampListPersone() {
		List<String> nomi = new ArrayList<String>();
		for (Persona p : listaPersone)
			nomi.add(p.getNome() + " " + p.getCognome());
		System.out.println(nomi);
	}

	// public void modifica(Persona p){
	// Scanner in = new Scanner(System.in);
	// System.out.println("Inserisci il nome");
	// String n = in.nextLine();
	// }

	public void removePersona(Persona p) {
		listaPersone.remove(p);
	}

	public Persona searchForTelefono(String telefono) {
		for (Persona i : listaPersone) {
			if (i.getTelefono() == telefono)
				return i;
		}
		return null;

	}

	public Persona searchForNome(String nome) {
		for (Persona i : listaPersone) {
			if (i.getNome() == nome)
				return i;
		}
		return null;

	}

	public void stampListPersoneAlpha(String s) {
		List<String> nomi = new ArrayList<String>();
		List<String> cognomi = new ArrayList<String>();
		if (s == "nome") {
			for (Persona p : listaPersone)
				nomi.add(p.getNome());
			Collections.sort(nomi, String.CASE_INSENSITIVE_ORDER);
			System.out.println(nomi);
		} else if (s == "cognome") {
			for (Persona p : listaPersone)
				cognomi.add(p.getCognome());
			Collections.sort(cognomi, String.CASE_INSENSITIVE_ORDER);
			System.out.println(cognomi);
		}
	}

	public static void salvaAgendina() throws IOException {
		try{
		FileOutputStream file = new FileOutputStream("C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj");
		ObjectOutputStream ob = new ObjectOutputStream(file);
		for(Persona p : listaPersone)
			ob.writeObject(p);
		ob.close();
		System.out.println("Lista salvata con successo");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void leggiAgendina() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			
			FileInputStream file = new FileInputStream("C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj");
			ObjectInputStream ob = new ObjectInputStream(file);
			Persona persona = (Persona) ob.readObject();
		} catch (FileNotFoundException exc) {
			System.out.println(exc);
			FileOutputStream file = new FileOutputStream("C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\agendina\\agendina.jjj");
			System.out.println("agendina.jjj ora è stata creata");
		}
	}
}
