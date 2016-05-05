package org.dstech.smastro.Registro;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Main {

		public static void main(String args[]){
			List<Studente> listaStudenti=new ArrayList<Studente>();
			List<Docente> listaDocenti=new ArrayList<Docente>();
			
			Classe classe=new Classe();
			
			Studente studente=new Studente();
			studente.setNome("Simone");
			studente.setCognome("Mastro");
			studente.setCodFisc("MSTSMN95P10H501U");
			SimpleDateFormat dateFormat=new SimpleDateFormat("10/09/1995");
			Date newData=new Date();
			studente.setDataNascita(dateFormat.format(newData));
			studente.getMatricola();
			
			Studente studente1=new Studente(); 
			studente1.setNome("Lorenzo");
			studente1.setCognome("Croce");
			studente1.setCodFisc("CRLNZ92DD29H501A");
			SimpleDateFormat dateFormat1=new SimpleDateFormat("29/04/1992");
			Date newData1=new Date();
			studente1.setDataNascita(dateFormat1.format(newData1));
			studente1.getMatricola();
			
			Studente studente2=new Studente(); 
			studente2.setNome("Pinco");
			studente2.setCognome("Pallino");
			studente2.setCodFisc("PLPNC34GHERH501T");
			SimpleDateFormat dateFormat2=new SimpleDateFormat("12/11/1987");
			Date newData2=new Date();
			studente2.setDataNascita(dateFormat2.format(newData2));
			studente2.getMatricola();
			
			Studente studente3=new Studente(); 
			studente3.setNome("Pippo");
			studente3.setCognome("Pluto");
			studente3.setCodFisc("PUPPO56I87H503E");
			SimpleDateFormat dateFormat3=new SimpleDateFormat("30/05/1998");
			Date newData3=new Date();
			studente3.setDataNascita(dateFormat3.format(newData3));
			studente3.getMatricola();
			
			classe.getListaStudenti().add(studente);
			classe.getListaStudenti().add(studente1);
			classe.getListaStudenti().add(studente2);
			classe.getListaStudenti().add(studente3);
			
			//classe.setListaStudenti(listaStudenti);
			
			System.out.println(classe.getListaStudenti());
			
			Docente docente=new Docente();
			docente.setNome("Domenico");
			docente.setCognome("Rullo");
			docente.setCodFisc("RLDMN45P34H501E");
			SimpleDateFormat dateFormat4=new SimpleDateFormat("24/03/1975");
			Date newData4=new Date();
			docente.setDataNascita(dateFormat4.format(newData4));
			docente.getMatricola();
			
			Docente docente1=new Docente();
			docente1.setNome("Francesco");
			docente1.setCognome("Mammo");
			docente1.setCodFisc("MMFRN45P23H501I");
			SimpleDateFormat dateFormat5=new SimpleDateFormat("19/07/1982");
			Date newData5=new Date();
			docente1.setDataNascita(dateFormat5.format(newData5));
			docente1.getMatricola();
			
			classe.getListaDocenti().add(docente);
			classe.getListaDocenti().add(docente1);
			
			
			System.out.println(classe.getListaDocenti());
			//classe.stampaListaStudenti(listaStudenti);
			//classe.stampaListaDocenti(listaDocenti);
		}
}
