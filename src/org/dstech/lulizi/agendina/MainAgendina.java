package org.dstech.lulizi.agendina;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.dstech.fsisca.Utente;
import org.dstech.fsisca.serializzaione.ItemSerializable;
import org.dstech.fsisca.serializzaione.LetturaScritturaItemSerializable;

public class MainAgendina {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		  PersonaAgenda persona;
		    persona = new PersonaAgenda();
		    PersonaAgenda p = persona;
		    List<PersonaAgenda> listaPersona = new ArrayList<PersonaAgenda>();
		    
		    

		    Scanner menu = new Scanner(System.in);
		    String scelta = "";
		    while(true){
		    	System.out.println("----------------------------RUBRICA------------------------\n");
		        System.out.println("\n[1] Aggiungi contatto");
		        System.out.println("[2] Visualizza lista");
		        System.out.println("[3] Ricerca per telefono");
		        System.out.println("[4] Stampa alfabetica nome");
		        System.out.println("[5] Stampa alfabetica cognome");
		        System.out.println("[6] Salva");
		        System.out.println("[7] Esci");
		        System.out.print("Quale scegli di fare? : ");
		        

		        try{
		            scelta = menu.nextLine(); 
		            }catch(Exception e){


		                System.out.println("Errore");
		            }


		        if(scelta.equals("1")) {
		        Agenda.aggiungiContatto(listaPersona);
		        }else if(scelta.equals("2")) {
		        	Agenda.visualizzaLista(listaPersona);
		        } else if(scelta.equals("3")) {
		        	Agenda.ricercaTelefono(listaPersona);
		        }else if(scelta.equals("4")) {
		        	Agenda.stampaListaAlfabeticaNome(listaPersona);
		        }else if(scelta.equals("5")) {
		        	Agenda.stampaListaAlfabeticaCognome(listaPersona);
		        }else if(scelta.equals("9")) {
		        	LetturaScrittura.salvaListaOggetti("agendinalucaulizi.jjj", listaPersona);  }      
		     else if(scelta.equals("10")) {
		        System.exit(0);
		      
		        }else {
		        System.out.println
		        ("Errore");
		        }

		    }
	}



	
}

	    

