package org.dstech.vangelini.gestioneClasse;

import java.util.ArrayList;

public class Classe {
	private ArrayList<Studente> lista_studenti;
	private String docente_uno;
	private String docente_due;
	private Registro registro;
	
	public Classe(ArrayList<Studente> lista_studenti, String docente_uno, String docente_due, Registro registro) {
		super();
		this.lista_studenti = lista_studenti;
		this.docente_uno = docente_uno;
		this.docente_due = docente_due;
		this.registro = registro;
	}

	public Classe() {
		super();
		this.lista_studenti = new ArrayList<Studente>();
	}

	public ArrayList<Studente> getLista_studenti() {
		return lista_studenti;
	}

	public void setLista_studenti(ArrayList<Studente> lista_studenti) {
		this.lista_studenti = lista_studenti;
	}

	public String getDocente_uno() {
		return docente_uno;
	}

	public void setDocente_uno(String docente_uno) {
		this.docente_uno = docente_uno;
	}

	public String getDocente_due() {
		return docente_due;
	}

	public void setDocente_due(String docente_due) {
		this.docente_due = docente_due;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}
	
}
