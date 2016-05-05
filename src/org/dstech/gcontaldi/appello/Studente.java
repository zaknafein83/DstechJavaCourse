package org.dstech.gcontaldi.appello;

public class Studente extends Persona {

	private String matricola;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola() {

		matricola = (getNome() + getDataNascita());

	}

	@Override
	public String matricola() {
		return null;
	}

}
