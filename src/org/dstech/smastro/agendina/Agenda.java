package org.dstech.smastro.agendina;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Agenda {
	private ArrayList<Persona> listaPersone;

	public Agenda(ArrayList<Persona> listaPersone) {
		this.listaPersone = listaPersone;
	}

	public Agenda() {
		this.listaPersone = new ArrayList<Persona>();
	}

	public ArrayList<Persona> getListaPersone() {
		return listaPersone;
	}

	public void setListaPersone(ArrayList<Persona> listaPersone) {
		this.listaPersone = listaPersone;
	}

	public void stampaAgenda(ArrayList<Persona> lista) {

		for (Persona persona : lista) {
			System.out.println(persona);
		}
	}

	public boolean Aggiungi(Persona persona) {
		if (this.listaPersone.add(persona)) {
			return true;
		}
		return false;
	}

	public void AggiungiNuovaPersona(Persona p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Aggiungi i parametri alla nuova persona");
		String t = sc.nextLine();
		System.out.println("Inserisci il nome");
		p.setNome(t);
		System.out.println("Inserisci il cognome");
		p.setCognome(t);
		System.out.println("Inserisci l'eta' ");
		Integer t1 = sc.nextInt();
		p.setEta(t1);
		System.out.println("Inserisci il numero di telefono ");
		p.setTelefono(t);
		System.out.println("Inserisci l'e-mail");
		p.setEmail(t);

		if (this.listaPersone.add(p)) {
			System.out.println("La persona " + p + " e' stata aggiunta");
		}
		System.out.println("Non e' stata aggiunta nessuna persona alla lista");
	}

	public void Rimuovi(Persona p) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quale persona vuoi eliminare dall'agenda?");
		String t = sc.nextLine();
		if (this.listaPersone.remove(p)) {
			System.out.println("La persona " + p + " e' stata rimossa");
		}
		System.out.println("Non hai rimosso nessuna persona dalla lista");
	}

	public void OrdinamentoPerCognome(String cognome) {
		ArrayList<String> listaOrdinata = new ArrayList<String>();
		for (Persona persona : listaPersone) {
			listaOrdinata.add(persona.getCognome());
		}
		Collections.sort(listaOrdinata, String.CASE_INSENSITIVE_ORDER);
		System.out.println(cognome);
	}

	public Persona ricercaOrdine(String nome) {
		for (Persona persona : listaPersone) {
			if (persona.getNome() == nome) {
				return persona;
			}
		}
		return null;
	}

	public Persona RicercaPerTelefono(String espressioneRegolareTelefono) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserisci il numero di telefono ");
		String t = sc.nextLine();

		for (Persona persona : listaPersone) {
			if (persona.getTelefono() == espressioneRegolareTelefono) {
				return persona;
			}
		}
		return null;
	}

	/**
	 * 
	 */
	
}
