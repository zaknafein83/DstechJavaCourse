package org.dstech.smastro.agendina;

import java.util.ArrayList;
import java.util.List;

import org.dstech.vangelini.Agenda.LetturaSalvataggioFile;
import org.dstech.vangelini.Agenda.Persona;

public class Main {
	public static void main(String args[]){
		LetturaSalvataggioFile file = new LetturaSalvataggioFile();
		file.leggiFile("agendina.jjj");
		
		
		
		Persona p=new Persona();
		p.setNome("Simone");
		p.setCognome("Mastro");
		p.setEta(20);
		p.setTelefono("+39 388 4697 182");
		p.setEmail("simonee1995@live.it");
		
		Persona p1=new Persona();
		p.setNome("Marco");
		p.setCognome("Marin");
		p.setEta(25);
		p.setTelefono("+39 392 5789675");
		p.setEmail("marin.m@hotmail.com");
		
		Persona p2=new Persona();
		p.setNome("Giovanni");
		p.setCognome("Fosco");
		p.setEta(34);
		p.setTelefono("3925789675");
		p.setEmail("giova.fo@yahoo.it");
		
		Agenda agenda=new Agenda();
		agenda.Aggiungi(p);
		agenda.Aggiungi(p1);
		agenda.Aggiungi(p2);
		
		agenda.StampaListaPersone();
		agenda.Rimuovi(p1);
		agenda.RicercaPerTelefono(numero);
		agenda.OrdinamentoPerCognome();
		
		Persona cercaTelefono = new Persona();
		cercaTelefono = agenda.RicercaPerTelefono("3925789675");
		if(cercaTelefono != null){
			System.out.println("La persona che stai cercando tramite il numero di telefono e' "+cercaTelefono);
		} else {
			System.out.println("Nessuna persona trovata");
		}
		
		
	}	
	}

