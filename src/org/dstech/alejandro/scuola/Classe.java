/**
 * 
 */
package org.dstech.alejandro.scuola;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alejandro
 *
 */
public class Classe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Studente> listaStudenti = new ArrayList<Studente>();
	Docente a;
	Docente b;

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}

	public Docente getA() {
		return a;
	}

	public void setA(Docente a) {
		this.a = a;
	}

	public Docente getB() {
		return b;
	}

	public void setB(Docente b) {
		this.b = b;
	}

	public void addStudente() {

		Studente p = new Studente();

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inserisci il nome");
		p.setNome(scanner.nextLine());
		System.out.println("Inserisci il cognome");
		p.setCognome(scanner.nextLine());
		System.out.println("Inserisci il codice fiscale");
		p.setCodfiscale(scanner.nextLine());
		// System.out.println("Inserisci la data di nascita");
		// p.setDataNascita(scanner.nextLine());

		listaStudenti.add(p);
	}

	public void save() throws IOException {
		try {
			FileOutputStream fout = new FileOutputStream(
					"C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\scuola\\classe.jjj");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
			oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Classe read() {

		try {

			FileInputStream fin = new FileInputStream("C:\\Users\\Alejandro\\git\\DstechJavaCourse\\src\\org\\dstech\\alejandro\\scuola\\classe.jjj");
			ObjectInputStream ois = new ObjectInputStream(fin);
			Classe classe = (Classe) ois.readObject();
			ois.close();

			return classe;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
