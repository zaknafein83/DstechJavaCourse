/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author franksisca
 *
 */
public class Classe implements Serializable{

	private List<Studente> listaStudenti;
	private List<Docente> listaDocenti;
	private Registro registro;
	
	/**
	 * 
	 */
	public Classe() {
		// TODO Auto-generated constructor stub
		this.listaStudenti = new ArrayList<Studente>();
		this.listaDocenti = new ArrayList<Docente>();
		this.registro = new Registro();
	}
	/**
	 * @return the registro
	 */
	public Registro getRegistro() {
		return registro;
	}
	
	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	public List<Docente> getListaDocenti() {
		return listaDocenti;
	}

	public void setListaDocenti(List<Docente> listaDocenti) {
		this.listaDocenti = listaDocenti;
	}

	public boolean aggiungiStudente(Studente studente) {
		return this.listaStudenti.add(studente);
	}

	public boolean aggiungiDocente(Docente docente) {
		return this.listaDocenti.add(docente);
	}
	
	public void appello(Date data){
		int docente = (int) (Math.random() * this.getListaDocenti().size());
		System.out.println("È stato scelto il docente: " + this.getListaDocenti().get(docente) + " per fare l'appello nella data " + Utils.formatDateAppello(data));
		for (Studente studente : listaStudenti) {
			System.out.println("Lo studente " + studente.getNome() + " " + studente.getCognome() + " è presente? [Y/N]: ");
			boolean presente = readBoolean();
			Rilevazione rilevazione = new Rilevazione(studente, presente, data);
			registro.aggiungiRilevazione(rilevazione );
		}
	}

	/**
	 * @return
	 */
	@SuppressWarnings("resource")
	private boolean readBoolean() {
		Scanner scanner = new Scanner(System.in);
		String next = scanner.next();
		Pattern pattern = Pattern.compile("y|Y|S|s");
		Matcher matcher = pattern.matcher(next.substring(0, 1));
		return matcher.find();
	}
}
