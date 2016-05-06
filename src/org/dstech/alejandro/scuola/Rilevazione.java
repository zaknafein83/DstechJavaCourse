/**
 * 
 */
package org.dstech.alejandro.scuola;

import java.io.Serializable;
import java.util.Date;

/**
 * @author franksisca
 *
 */
@SuppressWarnings("serial")
public class Rilevazione implements Serializable {
private Date data;
	private Studente studente;
	private boolean presente;

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public boolean getPresente() {
		return presente;
	}

	public Rilevazione(Studente studente, boolean presente, Date date) {
		super();
		this.studente = studente;
		this.presente = presente;
		this.data = date;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
