/**
 * 
 */
package org.dstech.alejandro.scuola;

/**
 * @author Alejandro
 *
 */
public class Studente extends Persona{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see org.dstech.alejandro.scuola.Persona#getMatricola()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return this.getNome()+this.getDataNascita().getMonth()+this.getDataNascita().getYear();
	}

}
