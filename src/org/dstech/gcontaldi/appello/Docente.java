package org.dstech.gcontaldi.appello;

public class Docente extends Persona {

	private String matricola;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola() {

		matricola = (getCognome() + getDataNascita() + getCodFiscale());

	}

	@Override
	public String matricola() {
		return null;
	}

}
