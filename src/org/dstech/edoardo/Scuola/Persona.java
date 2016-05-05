package org.dstech.edoardo.Scuola;

import java.util.Date;

public abstract class Persona {
	
	private String nome;
	private String cognome;
	private String codFiscale;
	private Date dataDiNascita;

	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getCodFiscale() {
		return codFiscale;
	}
	
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	
	public abstract String getMatricola();	

}
