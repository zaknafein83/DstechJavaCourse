package org.dstech.gcontaldi.appello;

import java.util.Date;

public abstract class Persona {

	private String nome;
	private String cognome;
	private String codFiscale;
	private Date dataNascita;

	public abstract String matricola();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", codFiscale=" + codFiscale + ", dataNascita="
				+ dataNascita + "]";
	}

}