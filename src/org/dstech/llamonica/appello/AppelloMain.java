package org.dstech.llamonica.appello;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AppelloMain {

	public static void main(String[] args) {
		
		Classe classe=new Classe();
		SimpleDateFormat dateFormat =  new SimpleDateFormat("23-02-1991");
		Date newDate = new Date();
		
//		System.out.println(dateFormat.format(newDate));
		
		Studente studente =new Studente();
		studente.setNome("luca");
		studente.setCognome("rossi");
		studente.setCodFiscale("LMNSDJK234LL");
	    studente.setDataNascita(dateFormat.format(newDate));
		
	    SimpleDateFormat dateFormat1 =  new SimpleDateFormat("27-06-1990");
		Date newDate1 = new Date();
	    
		Studente studente1 =new Studente();
		studente1.setNome("franco");
		studente1.setCognome("verdi");
		studente1.setCodFiscale("fdf42ff");
		studente1.setDataNascita(dateFormat1.format(newDate1));
		
		 SimpleDateFormat dateFormat2 =  new SimpleDateFormat("14-05-1991");
			Date newDate2 = new Date();
		    
		
		Studente studente2 =new Studente();
		studente2.setNome("maurizio");
		studente2.setCognome("placidi");
		studente2.setCodFiscale("DHD737FFD");
		studente2.setDataNascita(dateFormat2.format(newDate2));
		classe.listaStudenti.add(studente);
		classe.listaStudenti.add(studente1);
		classe.listaStudenti.add(studente2);
		
		
		 SimpleDateFormat dateFormat3 =  new SimpleDateFormat("12-12-1965");
			Date newDate3 = new Date();
		    
		
		Docente docente =new Docente();
		docente.setNome("franco");
		docente.setCognome("verdi");
		docente.setCodFiscale("fdf42ff");
		docente.setDataNascita(dateFormat3.format(newDate3));
		
		 SimpleDateFormat dateFormat4 =  new SimpleDateFormat("13-05-1975");
			Date newDate4 = new Date();
		    
		
		Docente docente1 =new Docente();
		docente1.setNome("franco");
		docente1.setCognome("verdi");
		docente1.setCodFiscale("fdf42ff");
		docente1.setDataNascita(dateFormat4.format(newDate4));
		
		String data=dateFormat4.format(newDate4).toString().substring(3,10);
		System.out.println(data);
		classe.listaDocenti.add(docente);
		classe.listaDocenti.add(docente1);
		
	 
	  studente.matricola();
		Scanner scanner=new Scanner(System.in);
		
		for (int i = 0; i < 200; i++) {
		
		System.out.println("cosa vuoi fare?");
		System.out.println("1-Guarda liste");
		System.out.println("2-Fai appello");
		System.out.println("3-Registro");	
		System.out.println("9-esci");

		int scelta = scanner.nextInt();
		switch (scelta) {
		case 1:System.out.println("quale lista vuoi vedere?");
		System.out.println("1-docenti");
		System.out.println("2-studenti");
		System.out.println("3-esci");
		
		Scanner scanner1=new Scanner(System.in);
		        int lista= scanner1.nextInt();
		        if(lista==1){
			System.out.println("i docenti sono:"+classe.listaDocenti);
		       
			
		        }
			else{
			System.out.println("gli studenti sono:"+classe.listaStudenti);
			
			}
		        System.out.println("per tornare al menu:1");
				System.out.println("per chiudere applicazione:2 ");
			lista=scanner1.nextInt();
			if(lista==1){
				break;
			} else {
				i = 200;
				break;
			}
				
				
			
			
		case 9:
			i=200;
		        
			
		case 2:
			classe.appello();
			
			
		        	
		case 3: 
			Scanner scanner3=new Scanner(System.in);
			System.out.println("1-vuoi vedere registro presenze");
			System.out.println("2-vuoi vedere registro assenze");
			int scelta2= scanner3.nextInt();
			
			if(scelta2==1){
			System.out.println(classe.listaPresenze);
				
			}
			else{
				System.out.println(classe.listassenze);
			}
		
		
	
		
	  
		  
	  //classe.salvaRegistro();
		}
		}	
}
}