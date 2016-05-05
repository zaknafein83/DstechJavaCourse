/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.io.Serializable;
import java.util.Date;

/**
 * @author franksisca
 *
 */
public abstract class Persona implements Serializable{
	private String nome;
	private String cognome;
	private String codFiscale;
	private Date dataNascita;

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * @param dataNascita
	 *            the dataNascita to set
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public abstract String getMatricola();

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

}
