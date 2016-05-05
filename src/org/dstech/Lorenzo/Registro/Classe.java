package org.dstech.Lorenzo.Registro;

import java.util.ArrayList;
import java.util.List;

public class Classe {

	private List<Studente> listaStudente = new ArrayList<Studente>();
	private List<Docente> listaDocente = new ArrayList<Docente>();

	public List<Studente> getListaStudente() {
		return listaStudente;
	}

	public void setListaStudente(List<Studente> listaStudente) {
		this.listaStudente = listaStudente;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}

	public void stampaListaStudente(ArrayList<Studente> listaStudente){
			for(Studente studente : listaStudente);
				System.out.println("la lista studenti è;"+ listaStudente);
	}
	public void stampaListaDocente(ArrayList<Docente> listaDocente) {
		for (Studente studente : listaStudente)
			;
		System.out.println("la lista docenti è;" + listaDocente);

	}

}
