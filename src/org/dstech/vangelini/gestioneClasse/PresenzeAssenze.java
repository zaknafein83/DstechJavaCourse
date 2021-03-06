package org.dstech.vangelini.gestioneClasse;

import java.util.ArrayList;

public class PresenzeAssenze {
	private Docente docente;
	private ArrayList<Studente> presenze;
	private ArrayList<Studente> assenze;
	
	public PresenzeAssenze(Docente docente, ArrayList<Studente> presenze, ArrayList<Studente> assenze) {
		super();
		this.docente = docente;
		this.presenze = presenze;
		this.assenze = assenze;
	}
	
	public PresenzeAssenze() {
		super();
		this.presenze = new ArrayList<Studente>();
		this.assenze = new ArrayList<Studente>();
	}	

	public ArrayList<Studente> getPresenze() {
		return presenze;
	}

	public void setPresenze(ArrayList<Studente> presenze) {
		this.presenze = presenze;
	}

	public ArrayList<Studente> getAssenze() {
		return assenze;
	}

	public void setAssenze(ArrayList<Studente> assenze) {
		this.assenze = assenze;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
}
