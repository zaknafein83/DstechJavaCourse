package org.dstech.llamonica.appello;



public abstract class Persona {
	private String nome;
	private String cognome;
	private String codFiscale;
	private String dataNascita;
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



	

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Persona [Nome=" + nome + ", Cognome=" + cognome + ", CodFiscale=" + codFiscale + ", DataNascita="
				+ dataNascita + " ]";
	}
	
	
}
