package org.dstech.lulizi.agendina;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Agenda {
	private List<PersonaAgenda> listaPersone;

	public List<PersonaAgenda> getListaPersone() {
		return listaPersone;
	}

	public void setListaPersone(List<PersonaAgenda> listaPersone) {
		this.listaPersone = listaPersone;
	}

	public static void aggiungiContatto(List<PersonaAgenda> listaPersona) {
		Scanner ins = new Scanner(System.in);
		Scanner ins2 = new Scanner(System.in);
		Scanner ins3 = new Scanner(System.in);

		PersonaAgenda p = new PersonaAgenda();
		try {

			System.out.print("Inserisci Nome: ");
			p.setNome(ins2.nextLine());
			System.out.print("Inserisci Cognome: ");
			p.setCognome(ins3.nextLine());
			System.out.print("Inserisci Eta: ");
			p.setEta(ins.nextInt());
			System.out.print("Inserisci numero di telefono: ");
			p.setNumeroTelefono(ins2.nextLine());
			System.out.print("Inserisci email: ");
			p.setEmail(ins3.nextLine());
			p.setDataInserimento(Calendar.getInstance().getTime());

		} catch (Exception e) {
			e.printStackTrace();
		}

		listaPersona.add(p);

	}

	/*public static void rimuoviPersona(List<Persona> listaPersona) {
		System.out.println("Inserisci il cognome della persona da rimuovere");
		Scanner e = new Scanner(System.in);
		String ta = e.nextLine();
		for (Persona persona : listaPersona)
			if (ta == persona.getCognome())
				listaPersona.remove(persona);
	}
*/
	public static void visualizzaLista(List<PersonaAgenda> listaPersona) {
		for (PersonaAgenda person : listaPersona) {
			System.out.println(person);
		}
	}

	public static void stampaListaAlfabeticaNome(List<PersonaAgenda> listaPersona) {

		Collections.sort(listaPersona, PersonaAgenda.COMPARE_BY_NOME);
		System.out.println("-------------Ordinata per Nome------------");
		for (PersonaAgenda persona : listaPersona) {
			System.out.println(persona);

		}

	}

	public static void stampaListaAlfabeticaCognome(List<PersonaAgenda> listaPersona) {

		Collections.sort(listaPersona, PersonaAgenda.COMPARE_BY_COGNOME);
		System.out.println("-------------Ordinata per Cognome------------");
		for (PersonaAgenda persona : listaPersona) {
			System.out.println(persona);
		}
	}

	public static void ricercaTelefono(List<PersonaAgenda> listaPersona) {
		System.out.println("\nInserisci il numero di telefono da cercare");
		Scanner sceltaa = new Scanner(System.in);
		String ssceltaa = sceltaa.nextLine();
		for (PersonaAgenda persona : listaPersona) {
			if (persona.getNumeroTelefono() != null && persona.getNumeroTelefono().equals(ssceltaa)) {

				System.out.println(persona);

			} else if (persona.getNumeroTelefono() == null) {
				System.out.println("Telefono non trovato");
			}
		}
	}

	/*public static void ricercaNome(List<Persona> listaPersona) {
		System.out.println("Inserisci il nome da cercare");
		Scanner s = new Scanner(System.in);
		String ss = s.nextLine();
		for (Persona persona : listaPersona) {
			if (persona.getNome().equals(ss)) {

				System.out.println(persona);

			}
		}
	}

	public static void modificaPersona(List<Persona> listaPersona) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il cognome della persone da aggionare");
		String pm = scanner.nextLine();
		for (Persona p : listaPersona)
			if (p.getCognome() == pm)
			{Scanner ins = new Scanner(System.in);
			Scanner ins2 = new Scanner(System.in);
			Scanner ins3 = new Scanner(System.in);
				System.out.print("Inserisci Nome: ");
		p.setNome(ins2.nextLine());
		System.out.print("Inserisci Cognome: ");
		p.setCognome(ins3.nextLine());
		System.out.print("Inserisci Eta: ");
		p.setEta(ins.nextInt());
		System.out.print("Inserisci numero di telefono: ");
		p.setNumeroTelefono(ins2.nextLine());
		System.out.print("Inserisci email: ");
		p.setEmail(ins3.nextLine());
		p.setDataInserimento(Calendar.getInstance().getTime());
	}
	}*/
	
	
}
