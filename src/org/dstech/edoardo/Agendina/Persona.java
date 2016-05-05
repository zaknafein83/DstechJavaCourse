package org.dstech.edoardo.Agendina;

public class Persona {
	/*
	 * Creare gli elementi
	 */
	private String nome;
	private String cognome;
	private Integer eta;
	private String numero_telefono = "Non Impostato";
	private String email = "Non Impostata";
	private String data;
	/*
	 * Creare un metodo persona e passare gli elementi creati 
	 */
	public Persona(String nome, String cognome, Integer eta, String numero_telefono, String email, String data) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.data = data;
		this.email = email;
		this.numero_telefono = numero_telefono;
	}
	/*
	 * creare i get e set degli elemtni di persona
	 */
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	/*
	 * il toString serve per definire a  
	 */
	
	@Override
	public String toString() {
		return "Nome: " + nome + ", Cognome: " + cognome + ", eta: "
				+ eta + ", Numero Telefonico: " + numero_telefono + ", email: "
				+ email + ", Data di aggiunta alla rubrica:" + data + ".";
	}
	
	public String toStringFile() {
		return (nome + "," + cognome + "," + eta + "," + numero_telefono + "," + email + "," + data);
	}
	
	/*
	 * istanzia un nuovo metodo per la modifica della persona
	 */
	
	
	public boolean modificaPersona(String nome, String cognome, Integer eta, String numero_telefono, String email, String data){
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.numero_telefono = numero_telefono;
		this.email = email;
		this.data = data;
		return true;
	}
	
}
