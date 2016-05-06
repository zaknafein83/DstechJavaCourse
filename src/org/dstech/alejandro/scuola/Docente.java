/**
 * 
 */
package org.dstech.alejandro.scuola;

/**
 * @author Alejandro
 *
 */
public class Docente extends Persona{

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
		return this.getCognome()+this.getDataNascita().getMonth()+this.getCodfiscale();
	}

}
