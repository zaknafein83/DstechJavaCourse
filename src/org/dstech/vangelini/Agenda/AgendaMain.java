package org.dstech.vangelini.Agenda;

import java.util.Date;

public class AgendaMain {

	public static void main(String[] args) {
		//Creazione oggetto data da inserire come attributo
		@SuppressWarnings("deprecation")
		Date data = new Date(2016, 02, 12);
		System.out.println(data);
		
		//Creazione persone
		Persona persona_1 = new Persona("Valerio", "Angelini", 22, "3482927183", "valerioangelini1@hotmail.it", data);
		Persona persona_2 = new Persona("Valeria", "Angelini", 22, "+348 2927183", "valerio@hotmail.it", data);
		Persona persona_3 = new Persona("Val", "Ange", 22, "+3482927183", "", data);
		Persona persona_4 = new Persona("Vale", "ini", 22, "348 2927183", "angelini1@hotmail.it", data);
		
		//Creazione oggetto agenda con riempimento
		Agenda agenda = new Agenda();
		agenda.aggiungiPersona(persona_1);
		agenda.aggiungiPersona(persona_2);
		agenda.aggiungiPersona(persona_3);
		agenda.aggiungiPersona(persona_4);
		agenda.aggiungiPersona(persona_1);
		
		//stampa lista agenda
		agenda.stampaListaPersone();
		
		//modifica persona
		if(persona_2.modificaPersona("Valerio2", "Angelini2", 23, "3482927183", "valerioangelini1@hotmail.it", data))
		
		//stampa lista agenda
		agenda.stampaListaPersone();
		
		//rimuovere persona
		agenda.rimuoviPersona(persona_2);
		
		//ristampa per visualizzare modifiche effettuate.
		agenda.stampaListaPersone();
		
		//ricerca per numero telefonico
		Persona persona_cercata = new Persona();
		persona_cercata = agenda.ricercaPerNumeroTelefonico("3482927183");
		if(persona_cercata == null){
			System.out.println("Nessuna persona trovata");
		} else {
			System.out.println(persona_cercata);
		}
		
		//ricerca ordine alfabetico
		Persona persona_cercata_per_nome = new Persona();
		persona_cercata_per_nome = agenda.ricercaPerOrdineAlfabetico("Valerio");
		if(persona_cercata_per_nome == null){
			System.out.println("Nessuna persona trovata");
		} else {
			System.out.println(persona_cercata_per_nome);
		}
		
		//stampa per ordine alfabetico cognome e poi nome
		agenda.stampaInOrdineAlfabeticoPerCognome();
		agenda.stampaInOrdineAlfabeticoPerNome();
		
	}

}
