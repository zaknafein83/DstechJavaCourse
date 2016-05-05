/**
 * 
 */
package org.dstech.alejandro.scuola;

/**
 * @author Alejandro
 *
 */
public class Docente extends Persona{

	/* (non-Javadoc)
	 * @see org.dstech.alejandro.scuola.Persona#getMatricola()
	 */
	@Override
	public String getMatricola() {
		// TODO Auto-generated method stub
		return this.getCognome()+this.getDataNascita().getMonth()+this.getCodfiscale();
	}

}
