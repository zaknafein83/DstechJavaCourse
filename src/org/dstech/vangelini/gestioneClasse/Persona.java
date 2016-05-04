package org.dstech.vangelini.gestioneClasse;

import java.util.Date;

public abstract class Persona {
	private String nome;
	private String cognome;
	private String codFiscale;
	private Date data;
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public String getCodFiscale(){
		return codFiscale;
	}
	
	public Date getDataNascita(){
		return data;
	}
	
	public abstract String getMatricola();
}
