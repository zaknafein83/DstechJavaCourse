package org.dstech.gcontaldi.appello;

import java.util.ArrayList;
import java.util.List;

public class Classe {

	private List<Studente> listaStudenti = new ArrayList<>();
	private List<Docente> listaDocenti = new ArrayList<>();

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

}
