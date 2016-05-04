package org.dstech.vangelini.Agenda;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
	private String nome;
	private String cognome;
	private Integer eta;
	private String numero_telefono = "Non Impostato";
	private String email = "Non Impostata";
	private Date data;
	
	public Persona(String nome, String cognome, Integer eta, String numero_telefono, String email, Date data) {
		//regola per email
		String prima_regola = "(^\\w+@\\w+\\.\\w{2,6}$)";
		//regola per telefono (+39 338 1234567 | +39 3381234567 | 3381234567 | +39 338 123 4567)
		String seconda_regola = "(^\\d{10}$)";
		String terza_regola = "(^+39 \\d{3} \\d{3} \\d{4}$)";
		String quarta_regola = "(^+39 \\d{10}$)";
		String quinta_regola = "(^+39 \\d{3} \\d{7}$)";
		
		Pattern pattern = Pattern.compile(prima_regola);
		Pattern pattern2 = Pattern.compile(seconda_regola+"|"+terza_regola+"|"+quarta_regola+"|"+quinta_regola);
		Matcher matcher = pattern.matcher(email);
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.data = data;
		if(matcher.find()){
			this.email = email;
		}
		Matcher matcher2 = pattern2.matcher(numero_telefono);
		if(matcher2.find()){
			this.numero_telefono = numero_telefono;
		}
	}
	
	public Persona(){};
	
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
	public Integer getEta() {
		return eta;
	}
	public void setEta(Integer eta) {
		this.eta = eta;
	}
	public String getNumero_telefono() {
		return numero_telefono;
	}
	public void setNumero_telefono(String numero_telefono) {
		this.numero_telefono = numero_telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + ", Cognome: " + cognome + ", eta: "
				+ eta + ", Numero Telefonico: " + numero_telefono + ", email: "
				+ email + ", Data di aggiunta alla rubrica:" + data + "]";
	}
	
	public boolean modificaPersona(String nome, String cognome, Integer eta, String numero_telefono, String email, Date data){
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.numero_telefono = numero_telefono;
		this.email = email;
		this.data = data;
		return true;
	}
	
}
