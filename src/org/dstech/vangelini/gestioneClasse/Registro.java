package org.dstech.vangelini.gestioneClasse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Registro {
	private HashMap<Date, PresenzeAssenze> mappaRegistro;

	public Registro(HashMap<Date, PresenzeAssenze> mappaRegistro) {
		super();
		this.mappaRegistro = mappaRegistro;
	}

	public Registro() {
		super();
		this.mappaRegistro = new HashMap<Date, PresenzeAssenze>();
	}
	
	public HashMap<Date, PresenzeAssenze> getMappaRegistro() {
		return mappaRegistro;
	}

	public void setMappaRegistro(HashMap<Date, PresenzeAssenze> mappaRegistro) {
		this.mappaRegistro = mappaRegistro;
	}
	
	public void appello(Date data, Docente docente, Classe classe){
		System.out.println("Il docente "+docente.getCognome()+" sta facendo l'appello per il giorno '"+data+"'");
		ArrayList<Studente> lista_studenti = classe.getLista_studenti();
		@SuppressWarnings("resource")
		Scanner io = new Scanner(System.in);
		
		ArrayList<Studente> lista_presenze = new ArrayList<Studente>();
		ArrayList<Studente> lista_assenze = new ArrayList<Studente>();
		for (Studente studente : lista_studenti){
			String risposta = "";
			System.out.println("Studente: "+studente.getCognome()+" "+studente.getNome());
			boolean validazione = true;
			while(validazione){
				System.out.print("Inserisci risposta (Si/No): ");
				risposta = io.next();
				if(risposta.equals("No") || risposta.equals("Si")){
					validazione = false;
				} else {
					System.out.print("Risposta non valida, riprova");
				}
			}
			if(risposta.equals("Si")){
				lista_presenze.add(studente);
			} else {
				lista_assenze.add(studente);
			}
		}
		PresenzeAssenze lista_presenze_assenze = new PresenzeAssenze(docente, lista_presenze, lista_assenze);
		mappaRegistro.put(data, lista_presenze_assenze);
	}
	
	public void giorniDiAssenzaDelloStudente(Studente studente){
		int conta_assenze = 0;
		for(Date data : mappaRegistro.keySet()){
			PresenzeAssenze lista = mappaRegistro.get(data);
			ArrayList<Studente> studenti_assenti = lista.getAssenze();
			if(studenti_assenti.contains(studente)){
				conta_assenze = conta_assenze + 1;
			}
		}
		System.out.println("Lo studente: "+studente.getCognome()+" ha effettuato: "+conta_assenze+" assenze");
	}
	
	public void ConteggioAppelli(Docente docente){
		int conteggio_appello = 0;
		for(Date data : mappaRegistro.keySet()){
			PresenzeAssenze lista = mappaRegistro.get(data);
			Docente docente_che_ha_fatto_appello = lista.getDocente();
			if(docente_che_ha_fatto_appello.equals(docente)){
				conteggio_appello = conteggio_appello + 1;
			}
		}
		System.out.println("Il docente: "+docente.getCognome()+" ha effettuato: "+conteggio_appello+" appelli");
	}
	
	public void StampaGiornaliera(Studente studente){
		for(Date data : mappaRegistro.keySet()){
			PresenzeAssenze lista = mappaRegistro.get(data);
			ArrayList<Studente> studenti_assenti = lista.getAssenze();
			System.out.print("Nel giorno: "+data+" lo studente risultava: ");
			if(studenti_assenti.contains(studente)){
				System.out.println("PRESENTE");
			} else {
				System.out.println("ASSENTE");
			}
		}
	}
}