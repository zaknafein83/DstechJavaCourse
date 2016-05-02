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

/**
 * @author franksisca
 *
 */
public class Utente implements Animale, Comparable<Utente> {
	
	private String nome;
	/* (non-Javadoc)
	 * @see org.dstech.corso.Animale#getNome()
	 */
	
	/**
	 * 
	 */
	public Utente(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
	}

	/* (non-Javadoc)
	 * @see org.dstech.corso.Animale#getNome()
	 */
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Utente o) {
		// TODO Auto-generated method stub
		return nome.compareTo(o.getNome());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utente [nome=").append(nome).append("]");
		return builder.toString();
	}

}
