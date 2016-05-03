package org.dstech.smastro.agendina;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
	private String nome;
	private String cognome;
	private int eta;
	private String TELEFONO="^+39 \\d{3} \\d{7}|^+39 \\d{10}|\\d{13}|^+39 \\d{3} \\d{3} \\d{4} ";
	private String E_MAIL=" ^[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]*)$";
	private Date data;
	
	public Persona(String nome, String cognome, int eta, String TELEFONO, String E_MAIL, Date data){
		Pattern pattern=Pattern.compile(E_MAIL);
		Pattern pattern1=Pattern.compile(TELEFONO);
		Matcher matcher=pattern.matcher(E_MAIL);
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		this.data=data;
		if(matcher.find()){
			this.E_MAIL=E_MAIL;
		}
		Matcher matcher1=pattern.matcher(TELEFONO);
		if(matcher1.find()){
			this.TELEFONO=TELEFONO;
		}
	}
	@Override
	public String toString() {
		return "Persona [Nome=" + nome + ", Cognome= " + cognome + ", Eta'= " + eta + ", Numero di telefono= " + TELEFONO + ", email= "
				+ E_MAIL + ", data=" + data + "]";
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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getTelefono() {
		return TELEFONO;
	}

	public void setTelefono(String telefono) {
		this.TELEFONO = telefono;
	}

	public String getEmail() {
		return E_MAIL;
	}

	public void setEmail(String email) {
		this.E_MAIL = email;
	}
	
	
}

