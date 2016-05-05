package org.dstech.Lorenzo.Registro;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Classe classe = new Classe();
		Studente lorenzo=new Studente();
	    lorenzo.setNome("lorenzo");
	    lorenzo.setCognome("croce");
	    lorenzo.setCodFisc("crclnz");
	    SimpleDateFormat dateFormat =  new SimpleDateFormat("29/04/1992");
		Date newDate = new Date();
		lorenzo.setDataNascita(dateFormat.format(newDate));
		lorenzo.setMatricola();                    
		String matricola = lorenzo.getMatricola(); //metodo get
		System.out.println(matricola);
		
	    Studente simone=new Studente();
	    simone.setNome("simone");
	    simone.setCognome("mastro");
	    simone.setCodFisc("smnmst");
	    SimpleDateFormat dateFormat1 =  new SimpleDateFormat("12/08/1995");
		Date newDate1 = new Date();
	    simone.setDataNascita(dateFormat.format(newDate));
	    simone.setMatricola();                    
		//String matricola1 = simone.getMatricola(); //metodo get
		//System.out.println(matricola);
		
	    Studente valerio=new Studente();
	    valerio.setNome("valerio");
	    valerio.setCognome("ang");
	    valerio.setCodFisc("vlnngl");
	    SimpleDateFormat dateFormat2 =  new SimpleDateFormat("30/10/1994");
		Date newDate2 = new Date();
		valerio.setDataNascita(dateFormat.format(newDate));
		valerio.setMatricola();                    
		//String matricola2 = lorenzo.getMatricola(); //metodo get
		//System.out.println(matricola);
	    
	    classe.getListaStudente().add(lorenzo);
	    classe.getListaStudente().add(simone);
	    classe.getListaStudente().add(valerio);
	    
	    System.out.println(classe.getListaStudente());
	    
	    Docente doc=new Docente();
	    doc.setNome("Batman");
	    doc.setCognome("croce");
	    doc.setCodFisc("crclnz");
	    SimpleDateFormat dateFormat3 =  new SimpleDateFormat("01/01/2001");
		Date newDate3 = new Date();
		doc.setDataNascita(dateFormat.format(newDate));
		doc.setMatricola();                    
		//String matricola3 = doc.getMatricola(); //metodo get
		//System.out.println(matricola);
		
		Docente doc2=new Docente();
	    doc2.setNome("Superman");
	    doc2.setCognome("croce");
	    doc2.setCodFisc("crclnz");
	    SimpleDateFormat dateFormat4 =  new SimpleDateFormat("29/04/1992");
		Date newDate4 = new Date();
		doc2.setDataNascita(dateFormat.format(newDate));
		lorenzo.setMatricola();                    
		//String matricola4 = doc2.getMatricola(); //metodo get
		//System.out.println(matricola);
		
		 classe.getListaDocente().add(doc);
		 classe.getListaDocente().add(doc2);
		 
		System.out.println(classe.getListaDocente());
	   
	}

	
	}


