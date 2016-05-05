package org.dstech.gcontaldi.appello;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppelloMain {

	public static void main(String[] args) {

		Classe classe = new Classe();
		
		Studente studente = new Studente();
		studente.setNome("Paolo");
		studente.setCognome("Rossi");
		studente.setCodFiscale("PALRSS91A15H501W");
		SimpleDateFormat dateFormat = new SimpleDateFormat("15-08-91");
		Date newDate = new Date();
		studente.setDataNascita(dateFormat.format(newDate));
		studente.getMatricola();

		Studente studente2 = new Studente();
		studente2.setNome("Rosa");
		studente2.setCognome("Pane");
		studente2.setCodFiscale("ROSPNN91G09F501H");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("09-01-91");
		Date newDate2 = new Date();
		studente2.setDataNascita (dateFormat2.format(newDate2));
		studente2.getMatricola();

		Studente studente3 = new Studente();
		studente3.setNome("Giovanni");
		studente3.setCognome("Magnotta");
		studente3.setCodFiscale("MGNGVN90F28H501W");
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("28-02-90");
		Date newDate3 = new Date();
		studente3.setDataNascita (dateFormat3.format(newDate3));
		studente3.getMatricola();

		Studente studente4 = new Studente();
		studente4.setNome("Carlo");
		studente4.setCognome("Pincopallo");
		studente4.setCodFiscale("PNCCRL88O17V501W");
		SimpleDateFormat dateFormat4 = new SimpleDateFormat("17-10-88");
		Date newDate4 = new Date();
		studente4.setDataNascita (dateFormat4.format(newDate4));
		studente4.getMatricola();

		classe.listaStudenti.add(studente);
		classe.listaStudenti.add(studente2);
		classe.listaStudenti.add(studente3);
		classe.listaStudenti.add(studente4);

		Docente docente = new Docente();
		docente.setNome("Alfonso");
		docente.setCognome("Pirelli");
		docente.setCodFiscale("PSLALF58M11F501W");
		SimpleDateFormat dateFormat5 = new SimpleDateFormat("11-02-58");
		Date newDate5 = new Date();
		docente.setDataNascita (dateFormat5.format(newDate5));
		docente.getMatricola();

		Docente docente2 = new Docente();
		docente2.setNome("Sonia");
		docente2.setCognome("Fusco");
		docente2.setCodFiscale("FSCSNI62s24R804T");
		SimpleDateFormat dateFormat6 = new SimpleDateFormat("24-09-62");
		Date newDate6 = new Date();
		docente2.setDataNascita (dateFormat6.format(newDate6));
		docente2.getMatricola();

		classe.listaDocenti.add(docente);
		classe.listaDocenti.add(docente2);

		System.out.println(classe.listaStudenti);
		System.out.println(classe.listaDocenti);

	}

}
