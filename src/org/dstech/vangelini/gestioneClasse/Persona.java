package org.dstech.vangelini.gestioneClasse;

import java.util.Date;

public abstract class Persona {
	private String nome;
	private String cognome;
	private String codFiscale;
	private Date data;

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public Date getDataNascita() {
		return data;
	}

	public abstract String getMatricola();

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

}
