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
package org.dstech.fsisca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author franksisca
 *
 */
public class EsempioComparable {

	enum Giorni {
		LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI
	}

	public static void main(String[] args) {

		Utente primoUtente = new Utente("antonio");
		Utente secondoUtente = new Utente("luigi");
		Utente terzoUtente = new Utente("anacleto");
		Utente quartoUtente = new Utente("bernado");
		Utente quintoUtente = new Utente("merlino");

		List<Utente> listaUtenti = new ArrayList<Utente>();
		listaUtenti.add(primoUtente);
		listaUtenti.add(secondoUtente);
		listaUtenti.add(terzoUtente);
		listaUtenti.add(quartoUtente);
		listaUtenti.add(quintoUtente);
		for (Utente utente : listaUtenti) {
			System.out.println(utente);
		}

		System.out.println("#############");
		Collections.sort(listaUtenti);
		for (Utente utente : listaUtenti) {
			System.out.println(utente);
		}

		String pippo = "Ciao";

		pippo += " a tutti";

		StringBuilder stringa = new StringBuilder();

		stringa.append("cioa");
		stringa.append(" a tutti");

		System.out.println(stringa);

	}

}

class Pippo {
	private String nome;
	private String cognome;
	private int eta;

	public Pippo(String nome, String cognome, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	/**
	 * 
	 */
	public Pippo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pippo [nome=").append(nome).append(", Cognome=").append(cognome).append(", eta=").append(eta).append("]");
		return builder.toString();
	}

}
