/**
 * 
 */
package org.dstech.alejandro.scuola;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alejandro
 *
 */
public abstract class Persona implements Serializable{
	
	private String nome;
	private String cognome;
	private String codfiscale;
	private Date dataNascita;
	private String matricola;
	
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
	public String getCodfiscale() {
		return codfiscale;
	}
	public void setCodfiscale(String codfiscale) {
		this.codfiscale = codfiscale;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
//	public void setDataNascita(String s) {
//		SimpleDateFormat simple = new SimpleDateFormat();
//		this.dataNascita = simple.parseDate(s);
//	}
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + "]";
	}
	public abstract String getMatricola();
	
	
	

	
}
