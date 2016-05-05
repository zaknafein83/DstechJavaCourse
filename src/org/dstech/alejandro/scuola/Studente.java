/**
 * 
 */
package org.dstech.alejandro.scuola;

/**
 * @author Alejandro
 *
 */
public class Studente extends Persona{

	/* (non-Javadoc)
	 * @see org.dstech.alejandro.scuola.Persona#getMatricola()
	 */
	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return this.getNome()+this.getDataNascita().getMonth()+this.getDataNascita().getYear();
	}

}
