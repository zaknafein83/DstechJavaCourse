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
package org.dstech.fsisca.banca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author franksisca
 *
 */
public class GestoreBAnca {

	public static void main(String[] args) throws IOException {
		UtenteBase antonio = new UtenteBase("antonio", 1500);
		UtenteBase fortunata = new UtenteBase("fortuna");
		UtentePremium giovanni = new UtentePremium("giovanni");
		UtentePremium maria = new UtentePremium("maria", 800);
		UtentePremium genoveffa = new UtentePremium("geno", 0, 400);
		
		Set<Persona> listaUtenti = new HashSet<Persona>();
		listaUtenti.add(genoveffa);
		listaUtenti.add(antonio);
		listaUtenti.add(giovanni);
		listaUtenti.add(fortunata);
		listaUtenti.add(maria);
		
		for (Persona persona : listaUtenti) {
			System.out.println(persona);
		}
		
		
		UtenteGenerico operatore = new UtenteGenerico("op");
		operatore.stampaListaUtenti("lista", new ArrayList<Persona>(listaUtenti));
		
		
	}
}
