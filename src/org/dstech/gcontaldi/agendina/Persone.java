package org.dstech.gcontaldi.agendina;

import java.util.Date;

public class Persone {

	private String nome;
	private String cognome;
	private String eta;
	private String telefono = "\\d{3} \\d{3} \\d{7}|\\d{3} \\d{10}|\\d{10}|\\d{3} \\d{3} \\d{3} \\d{4}";
	private String mail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Date date;

	@Override
	public String toString() {
		return "Persone [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", telefono=" + telefono + ", mail="
				+ mail + ", date=" + date + "]";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	

}
