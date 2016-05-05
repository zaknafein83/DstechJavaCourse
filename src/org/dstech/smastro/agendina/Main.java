package org.dstech.smastro.agendina;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dstech.fsisca.LetturaSalvataggioFile;



public class Main{

	

	public static void main(String args[]){
		ArrayList<Persona>lista=new ArrayList<Persona>();
	
		
	    int risp=0;
		do{
			
		System.out.println("\n\n Menu Agenda");
		System.out.println(" 1) : Visualizza l'intera agenda");
		System.out.println(" 2) : Aggiunta di una persona");
		System.out.println(" 3) : Ordinamento dell'agenda per cognome");
		System.out.println(" 4) : Modifica di una persona");
		System.out.println(" 5) : Rimozione di una persona");
		System.out.println(" 6) : Ricerca di una persona per numero di telefono");
		System.out.println(" 7) : Uscire dal programma");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Quale operazione vuoi effettuare?");
		int n=sc.nextInt();

	
	switch(n){
	case 1:
			agenda.stampaAgenda();
		
			break;
	case 2:
			agenda.AggiungiNuovaPersona();
			break;
	case 3:
		   agenda. OrdinamentoPerCognome();
		   break;
	case 4:
			agenda
			break;
	case 5:
		   agenda.Rimuovi();
		   break;
	case 6:
		   agenda.RicercaPerTelefono();
		   break;
	case 7:
		   System.out.println("Uscita dal programma");
	default:
		   System.out.println("Errore");
		   break;
	}
		 
			System.out.println("Vuoi fare un'altra operazione? (S/N");
		  }while(risp =='S');
			
		

	}

	
	}

