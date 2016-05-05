/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author franksisca
 *
 */
public class GestioneScuola {

	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
		
		Classe classe = GestioneArchivioClasse.recuperaClasse("classe.jjj");
		if (classe == null)
			classe = new Classe();
		
		for (int i = 0; i < 5; i++) {
			classe.aggiungiStudente(creaStudenteFromKeyboard());
		}
		for (int i = 0; i < 2; i++) {
			classe.aggiungiDocente(creaDocenteFromKeyboard());
		}

		classe.appello(new Date());

		GestioneArchivioClasse.salvaRegistro("registro.jjj", classe.getRegistro());
		GestioneArchivioClasse.salvaClasse("registro.jjj", classe);

	}

	/**
	 * @return
	 * @throws ParseException 
	 */
	private static Docente creaDocenteFromKeyboard() throws ParseException {
		// TODO Auto-generated method stub
		Docente docente = new Docente();
		

		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dimmi il nome del Docente:");
		String nome = scanner.next();
		System.out.println("Dimmi il cognome del Docente:");
		String cognome = scanner.next();
		System.out.println("Dimmi il codice fiscale del Docente:");
		String codice = scanner.next();
		System.out.println("Dimmi il data di nascita (" + Utils.DD_MM_YYYY + ") del Docente: ");
		String data = scanner.next();

		docente.setCodFiscale(codice);
		docente.setCognome(cognome);
		docente.setNome(nome);
		docente.setDataNascita(Utils.convertDateFromString(data));
	
		return docente;
	}

	/**
	 * @return
	 * @throws ParseException 
	 */
	private static Studente creaStudenteFromKeyboard() throws ParseException {
		// TODO Auto-generated method stub
		Studente studente = new Studente();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Dimmi il nome dello Studente:");
		String nome = scanner.next();
		System.out.println("Dimmi il cognome dello Studente:");
		String cognome = scanner.next();
		System.out.println("Dimmi il codice fiscale dello Studente:");
		String codice = scanner.next();
		System.out.println("Dimmi il data di nascita (" + Utils.DD_MM_YYYY + ") dello Studente: ");
		String data = scanner.next();

		studente.setCodFiscale(codice);
		studente.setCognome(cognome);
		studente.setNome(nome);
		studente.setDataNascita(Utils.convertDateFromString(data));
		return studente;
	}
}
