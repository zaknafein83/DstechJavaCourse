package org.dstech.vangelini.gestioneClasse;

import java.util.ArrayList;

public class Classe {
	private ArrayList<Studente> lista_studenti;
	private String docente_uno;
	private String docente_due;
	private Registro registro;
	private String nome_classe;
	
	public Classe(ArrayList<Studente> lista_studenti, String docente_uno, String docente_due, Registro registro, String nome_classe) {
		super();
		this.lista_studenti = lista_studenti;
		this.docente_uno = docente_uno;
		this.docente_due = docente_due;
		this.registro = registro;
		this.nome_classe = nome_classe;
	}
	
	public String getNome_classe() {
		return nome_classe;
	}

	public void setNome_classe(String nome_classe) {
		this.nome_classe = nome_classe;
	}

	public void stampaClasse(){
		ArrayList<Studente> lista_studenti = getLista_studenti();
		System.out.println("Classe: "+getNome_classe());
		System.out.println("Docenti: "+getDocente_uno()+" e "+getDocente_due());
		System.out.println("Lista Studenti: ");
		for(Studente studente : lista_studenti){
			System.out.println("Studente: "+studente.getCognome()+" "+studente.getNome()+" "+studente.getMatricola());
		}
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
