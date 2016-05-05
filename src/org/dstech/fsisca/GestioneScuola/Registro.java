/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author franksisca
 *
 */
@SuppressWarnings("serial")
public class Registro implements Serializable {
	private List<Rilevazione> lista;

	/**
	 * 
	 */
	public Registro() {
		// TODO Auto-generated constructor stub
		this.lista = new ArrayList<Rilevazione>();
	}
	public boolean aggiungiRilevazione(Rilevazione rilevazione) {
		return this.lista.add(rilevazione);
	}

	public List<Rilevazione> getLista() {
		return lista;
	}

	public void setLista(List<Rilevazione> lista) {
		this.lista = lista;
	}

}
