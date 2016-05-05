package org.dstech.smastro.Registro;

import java.util.Date;

public abstract class Persona {
	private String nome;
	private String cognome;
	private String codFisc;
	private String dataNascita;
	private String matricola;
	
	public  abstract String  getMatricola();
	
	
	@Override
	public String toString() {
		return "Persona [nome=" + nome + 
				", cognome=" + cognome + 
				", codFisc=" + codFisc +
				", dataNascita="+ dataNascita +
				", matricola="+matricola+"]";
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}


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

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String newData) {
		this.dataNascita = newData;
	}
}
