package org.dstech.Lorenzo.Registro;

import java.util.Date;

public abstract class Persona {
	private String nome;
	private String cognome;
	private String codFisc;
	private String dataNascita;
    private String matricola;
	
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

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public Date getDataNascita() {
		return getDataNascita();
	}

	public void setDataNascita(String string) {
		this.dataNascita = string;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome +
				", cognome=" + cognome +
				", codFisc=" + codFisc + 
				", dataNascita="+ dataNascita +
				", matricola=" + matricola + "]";
	}

	

}
