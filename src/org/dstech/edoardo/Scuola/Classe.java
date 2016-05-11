package org.dstech.edoardo.Scuola;

import java.util.ArrayList;

public class Classe {

	// Creo gli elementi che compongono la classe

	private ArrayList<Studente> listaStudendi;
	private String docenteUno;
	private String docenteDue;
	private Registro registro;

	// Creo il costruttore

	public Classe(ArrayList<Studente> listaStudente, String docenteUno, String docenteDue, Registro registro) {
		super();
		this.listaStudendi = listaStudente;
		this.docenteUno = docenteUno;
		this.docenteDue = docenteDue;
		this.registro = registro;
	}

	public Classe() {
		super();
		this.listaStudendi = new ArrayList<Studente>();
	}

	// Genero i Get e i set degli elementi passandogli gli elementi del
	// costruttore

	public ArrayList<Studente> getListaStudendi() {
		return listaStudendi;
	}

	public void setLista_studenti(ArrayList<Studente> listaStudente) {
		this.listaStudendi = listaStudente;
	}

	public String DocenteUno() {
		return docenteUno;
	}

	public void setDocenteUno(String docenteUno) {
		this.docenteUno = docenteUno;
	}

	public String getDocentedue() {
		return docenteDue;
	}

	public void setdocenteDue(String docenteDue) {
		this.docenteDue = docenteDue;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

}
