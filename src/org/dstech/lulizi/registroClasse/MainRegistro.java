package org.dstech.lulizi.registroClasse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;




public class MainRegistro {

	public static void main(String[] args) throws ParseException {
		
		
		
	     Classe classeDsTech= new Classe ();
	        
		Docente docente1=new Docente();
		docente1.setNome("Francesco");
		docente1.setCognome("Rossi");
		docente1.setCodiceFiscale("lzkdhbbej756748hgfd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	    docente1.setDataDiNascita(sdf.parse("29-05-1981"));
	    sdf.format(docente1.getDataDiNascita());	
	      
	    Calendar cal = Calendar.getInstance();
		cal.setTime(docente1.getDataDiNascita());
		int mese = cal.get(Calendar.MONTH)+1;
		docente1.setMatricola(docente1.getCognome()+mese+docente1.getCodiceFiscale());
		
		   
		
		
		
		Docente docente2=new Docente();
		docente2.setNome("Paolo");
		docente2.setCognome("Bianchi");
		docente2.setCodiceFiscale("paihnfmeih7554679nffed");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		
	    docente2.setDataDiNascita(sdf.parse("13-07-1959"));
	    sdf.format(docente2.getDataDiNascita());	
	      
	    Calendar cal2 = Calendar.getInstance();
		cal.setTime(docente2.getDataDiNascita());
		int mesee = cal.get(Calendar.MONTH)+1;
		docente2.setMatricola(docente2.getCognome()+mese+docente2.getCodiceFiscale());
		
		

		
		
		
		
		
		Studente studente1 = new Studente();
		studente1.setNome("Gianni");
		studente1.setCognome("Bo");
		studente1.setCodiceFiscale("gidsihf8654798boggfd");
         SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy");
		
	    studente1.setDataDiNascita(sdf.parse("05-05-1987"));
	    sdf.format(studente1.getDataDiNascita());	
	      
	    Calendar cal3 = Calendar.getInstance();
		cal.setTime(studente1.getDataDiNascita());
		int meseee = cal.get(Calendar.MONTH)+1;
		int anno = cal.get(Calendar.YEAR);
		studente1.setMatricola(studente1.getNome()+mese+anno);
		
		
		
		Studente studente2 = new Studente();
		studente2.setNome("Mirko");
		studente2.setCognome("Verdi");
		studente2.setCodiceFiscale("Miruryeshjgfd67548bgfd");
SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MM-yyyy");
		
	    studente2.setDataDiNascita(sdf.parse("11-11-1975"));
	    sdf.format(studente2.getDataDiNascita());	
	      
	    Calendar cal4 = Calendar.getInstance();
		cal.setTime(studente2.getDataDiNascita());
		int meseeee = cal.get(Calendar.MONTH)+1;
		int annoo = cal.get(Calendar.YEAR);
		studente2.setMatricola(studente2.getNome()+mese+anno);

		
		Studente studente3 = new Studente();
		studente3.setNome("Simone");
		studente3.setCognome("Bianchetti");
		studente3.setCodiceFiscale("sszirgfp8574894jhfgdj");
SimpleDateFormat sdf5 = new SimpleDateFormat("dd-MM-yyyy");
		
	    studente3.setDataDiNascita(sdf.parse("09-06-1989"));
	    sdf.format(studente3.getDataDiNascita());	
	      
	    Calendar cal5 = Calendar.getInstance();
		cal.setTime(studente3.getDataDiNascita());
		int meseeeee = cal.get(Calendar.MONTH)+1;
		int annooo = cal.get(Calendar.YEAR);
		studente3.setMatricola(studente3.getNome()+mese+anno);
		
		
		
		
		Studente studente4 = new Studente();
		studente4.setNome("Luigi");
		studente4.setCognome("Vanni");
		studente4.setCodiceFiscale("lugjgfdk67954ghgkfd");
        SimpleDateFormat sdf6 = new SimpleDateFormat("dd-MM-yyyy");
		
	    studente4.setDataDiNascita(sdf.parse("07-07-1983"));
	    sdf.format(studente4.getDataDiNascita());	
	      
	    Calendar cal6 = Calendar.getInstance();
		cal.setTime(studente4.getDataDiNascita());
		int meseeeeee = cal.get(Calendar.MONTH)+1;
		int annoooo = cal.get(Calendar.YEAR);
		studente4.setMatricola(studente4.getNome()+mese+anno);
		
		
		classeDsTech.getListaStudenti().add(studente1);
		classeDsTech.getListaStudenti().add(studente2);
		classeDsTech.getListaStudenti().add(studente3);
		classeDsTech.getListaStudenti().add(studente4);
		
      
             
        classeDsTech.getListaDocenti().add(docente1);
        classeDsTech.getListaDocenti().add(docente2);
        
        
        
        
        Scanner menu = new Scanner(System.in);
	    String scelta = "";
	    while(true){
	    	System.out.println();
	    	System.out.println("-------------------REGISTRO CLASSE---------------------");
	        System.out.println("\n[1] Visualizza composizione Classe ");
	        System.out.println("[2] Fai Appello");
	        System.out.println("[3] Visualizza Registro");
	        System.out.println("[4] Cerca nel Registro per giorno");
	        System.out.println("[5] Calcola giorni assenza studente");
	        System.out.println("[6] Calcola numeri Appelli docente");
	        System.out.println("[7] Cerca assenze/presenze studente giorno per giorno");
	        System.out.println("\n-----------------------------------------------------");
	        System.out.print("Quale scegli di fare? : PUOI SCEGLIERE SOLO 1 PECHE' GLI ALTRI SONO DA TERMINARE");
	        

	        try{
	            scelta = menu.nextLine(); 
	            }catch(Exception e){


	                System.out.println("Errore");
	            }

	        if(scelta.equals("1")) {
		        classeDsTech.stampaListaStudenti();
		        }
	}

	}}
