package org.dstech.lulizi.registroClasse;

import java.util.ArrayList;
import java.util.List;


public class Classe {
	private List<Studente> listaStudenti = new ArrayList<Studente>();
	private List<Docente> listaDocenti = new ArrayList<Docente>();
	

	private Registro registro;
	
	
	
	
public List<Studente> getListaStudenti() {
		return listaStudenti;
	}




	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}




	public List<Docente> getListaDocenti() {
		return listaDocenti;
	}




	public void setListaDocenti(List<Docente> listaDocenti) {
		this.listaDocenti = listaDocenti;
	}




	public Registro getRegistro() {
		return registro;
	}




	public void setRegistro(Registro registro) {
		this.registro = registro;
	}




public  void stampaListaStudenti( ){
		
		System.out.println("-------CLASSE DSTECH----------");
		System.out.println();
	    System.out.println("I professori della classe sono:");
	    System.out.println();
	    for (Docente doc : listaDocenti)
	    {
		System.out.println("Nome :"+ doc.getNome()+" Cognome: "+doc.getCognome()+" Codice Fiscale: "+doc.getCodiceFiscale()+" Data di nascita: "+doc.getDataDiNascita()+ " Matricola: "+doc.getMatricola());
	    }
		System.out.println();
		System.out.println();
		System.out.println("Gli studenti della classe sono:");
		System.out.println();
		
		for (Studente stud : listaStudenti)
	    {
		System.out.println("Nome: "+stud.getNome()+" Cognome: "+stud.getCognome()+" Codice Fiscale: "+stud.getCodiceFiscale()+ " Data di nascita: "+stud.getDataDiNascita()+ " Matricola: "+stud.getMatricola());
	    }
		
	}
	
	
}