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
	private String espressioneRegolareTelefono="^+39 \\d{3} \\d{7}|^+39 \\d{10}|\\d{13}|^+39 \\d{3} \\d{3} \\d{4} ";
	private String espressioneRegolareE_mail=" ^[_A-Za-z0-9\\+]+(\\.[_A-Za-z0-9]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]*)$";
	private Date data;
	
	public Persona(String nome, String cognome, int eta, String espressioneRegolareTelefono, String espressioneRegolareE_mail, Date data){
		Pattern pattern=Pattern.compile(espressioneRegolareE_mail);
		Pattern pattern1=Pattern.compile(espressioneRegolareTelefono);
		Matcher matcher=pattern.matcher(espressioneRegolareE_mail);
		this.nome=nome;
		this.cognome=cognome;
		this.eta=eta;
		this.data=data;
		if(matcher.find()){
			this.espressioneRegolareE_mail=espressioneRegolareE_mail;
		}
		Matcher matcher1=pattern.matcher(espressioneRegolareTelefono);
		if(matcher1.find()){
			this.espressioneRegolareTelefono=espressioneRegolareTelefono;
		}
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
		return espressioneRegolareTelefono;
	}

	public void setTelefono(String telefono) {
		this.espressioneRegolareTelefono = telefono;
	}

	public String getEmail() {
		return espressioneRegolareE_mail;
	}

	public void setEmail(String email) {
		this.espressioneRegolareE_mail = espressioneRegolareE_mail;
	}
	@Override
	public String toString() {
		return "Persona [Nome=" + nome + ", Cognome= " + cognome + ", Eta'= " + eta + ", Numero di telefono= " + espressioneRegolareTelefono + ", email= "
				+ espressioneRegolareE_mail + ", data=" + data + "]";
	}
	
	public boolean modificaPersona(String nome, String cognome, Integer eta, String numero_telefono, String email, Date data){
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.espressioneRegolareTelefono = numero_telefono;
		this.espressioneRegolareE_mail = email;
		this.data = data;
		return true;
	}


	
}

