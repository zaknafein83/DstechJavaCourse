package org.dstech.smastro.Registro;

import java.util.ArrayList;
import java.util.List;

public class Classe {
	private List<Studente> listaStudenti=new ArrayList<Studente>();
	private List<Docente> listaDocenti=new ArrayList<Docente>();
	
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
	
	public void stampaListaStudenti() {

		for (Studente studenti : listaStudenti) {
			System.out.println(listaStudenti);
		}
	}
	public void stampaListaDocenti(){
		for(Docente docenti: listaDocenti){
			System.out.println(listaDocenti);
		}
	}

}
