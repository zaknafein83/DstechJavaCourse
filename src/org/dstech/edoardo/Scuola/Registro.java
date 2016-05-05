package org.dstech.edoardo.Scuola;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class Registro {
	
	// @copiato
	
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

	public void setMappaRegistro(HashMap<Date, PresenzeAssenze> mappadelRegistro) {
		this.mappaRegistro = mappadelRegistro;
	}
	
	
	public void appello(Date data, Docente docente, Classe classe){
		System.out.println("Docente "+docente.getCognome()+" appello del giorno '"+data+"'");
		
		ArrayList<Studente> lista_studenti = classe.getListaStudendi();
		@SuppressWarnings("resource")
		Scanner io = new Scanner(System.in);
		
		
		ArrayList<Studente> listaPresenze = new ArrayList<Studente>();
		ArrayList<Studente> listaAssenze = new ArrayList<Studente>();
		
		
		for (Studente studente : lista_studenti){
			String risultatoConferma = "";
			System.out.println("Studente: "+studente.getCognome()+" "+studente.getNome());
			boolean confermaPresenze = true;
			
			
			while(confermaPresenze){
				System.out.print("Presente? [Si/No]: ");
				risultatoConferma = io.next();
				
				
				if(risultatoConferma.equals("Si") || risultatoConferma.equals("No")){
					confermaPresenze = false;
					
					
				} else {
					System.out.print("Errore");
				}
			}
			
			
			if(risultatoConferma.equals("Si")){
				listaPresenze.add(studente);
			} else {
				listaAssenze.add(studente);
			}
		}
		
		PresenzeAssenze listaPresenzeAssenze = new PresenzeAssenze(docente, listaPresenze, listaAssenze);
		mappaRegistro.put(data, listaPresenzeAssenze);
	}
	
	
	public void giorniDiAssenza(Studente studente){
		int calcolaAssenze = 0;
		for(Date data : mappaRegistro.keySet()){
			PresenzeAssenze lista = mappaRegistro.get(data);
			ArrayList<Studente> studentiAssenti = lista.getAssenze();
			if(studentiAssenti.contains(studente)){
				calcolaAssenze = calcolaAssenze + 1;
			}
		}
		System.out.println("Lo studente: "+studente.getCognome()+" é stoto assente per: "+calcolaAssenze);
	}
	
	
	public void ConteggioAppelli(Docente docente){
		int calcoloAppello = 0;
		for(Date data : mappaRegistro.keySet()){
			PresenzeAssenze lista = mappaRegistro.get(data);
			Docente docenteAppello = lista.getDocente();
			if(docenteAppello.equals(docente)){
				calcoloAppello = calcoloAppello + 1;
			}
		}
		System.out.println("Il docente: "+docente.getCognome()+" ha effettuato: "+calcoloAppello+" appelli");
	}
	
	
	public void StampaGiornaliera(Studente studente){
		for(Date data : mappaRegistro.keySet()){
			PresenzeAssenze lista = mappaRegistro.get(data);
			ArrayList<Studente> studenteAssente = lista.getAssenze();
			System.out.print("Nel giorno: "+data+" lo studente risultava: ");
			if(studenteAssente.contains(studente)){
				System.out.println("PRESENTE");
			} else {
				System.out.println("ASSENTE");
			}
		
			}
		}
	}
