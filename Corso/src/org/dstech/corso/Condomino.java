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
package org.dstech.corso;

/**
 * @author franksisca
 *
 */
public class Condomino implements Animale, Persona {

	private String nome;

	public String getNome() {
		return nome;
	}

	/**
 * 
 */
	public Condomino(String nome) {
		this.nome = nome;
	}
}
