/**
 * Dear Maintainer:
 * 
 * When I wrote this code, only I and God knew what it was.
 * Now, only God knows!!!
 * 
 * So, if you are done trying to "optimeze" this routine (and failed), 
 * please increment the following counter as a warning to the next guy:
 * 
 * total_hours_wasted_here: 10
 * 
 */
package org.dstech.fsisca.serializzaione;

import java.io.Serializable;

/**
 * @author franksisca
 *
 */
public class ItemSerializable implements Serializable {

	private String nome, cognome, codFiscale;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemSerializable [nome=").append(nome).append(", cognome=").append(cognome).append(", codFiscale=").append(codFiscale).append("]");
		return builder.toString();
	}

	public ItemSerializable(String nome, String cognome, String codFiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codFiscale = codFiscale;
	}
	
	
}
