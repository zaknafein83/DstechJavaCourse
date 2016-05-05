package org.dstech.gcontaldi.appello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppelloMain {

	public static void main(String[] args) throws ParseException {

		Classe classe = new Classe();

		Studente studente = new Studente();
		studente.setNome("Paolo");
		studente.setCognome("Rossi");
		studente.setCodFiscale("PALRSS91A15H501W");
		String data = "15-08-1991";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date parse = dateFormat.parse(data);
		studente.setDataNascita(dateFormat.format(parse));
		studente.setMatricola();

		Studente studente2 = new Studente();
		studente2.setNome("Rosa");
		studente2.setCognome("Pane");
		studente2.setCodFiscale("ROSPNN91G09F501H");
		String data2 = "09-01-1991";
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
		Date parse2 = dateFormat2.parse(data2);
		studente2.setDataNascita(dateFormat2.format(parse2));
		studente2.setMatricola();

		Studente studente3 = new Studente();
		studente3.setNome("Giovanni");
		studente3.setCognome("Magnotta");
		studente3.setCodFiscale("MGNGVN90F28H501W");
		String data3 = "28-02-1990";
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
		Date parse3 = dateFormat3.parse(data3);
		studente3.setDataNascita(dateFormat3.format(parse3));
		studente3.setMatricola();

		Studente studente4 = new Studente();
		studente4.setNome("Carlo");
		studente4.setCognome("Pincopallo");
		studente4.setCodFiscale("PNCCRL88O17V501W");
		String data4 = "17-10-1988";
		SimpleDateFormat dateFormat4 = new SimpleDateFormat("dd-MM-yyyy");
		Date parse4 = dateFormat4.parse(data4);
		studente4.setDataNascita(dateFormat4.format(parse4));
		studente4.setMatricola();

		classe.getListaStudenti().add(studente);
		classe.getListaStudenti().add(studente2);
		classe.getListaStudenti().add(studente3);
		classe.getListaStudenti().add(studente4);

		Docente docente = new Docente();
		docente.setNome("Alfonso");
		docente.setCognome("Pirelli");
		docente.setCodFiscale("PSLALF58M11F501W");
		String data5 = "11-02-1958";
		SimpleDateFormat dateFormat5 = new SimpleDateFormat("dd-MM-yyyy");
		Date parse5 = dateFormat5.parse(data5);
		docente.setDataNascita(dateFormat5.format(parse5));
		docente.setMatricola();

		Docente docente2 = new Docente();
		docente2.setNome("Sonia");
		docente2.setCognome("Fusco");
		docente2.setCodFiscale("FSCSNI62S24R804T");
		String data6 = "24-09-62";
		SimpleDateFormat dateFormat6 = new SimpleDateFormat("dd-MM-yyyy");
		Date parse6 = dateFormat6.parse(data6);
		docente2.setDataNascita(dateFormat6.format(parse6));
		docente2.setMatricola();

		classe.getListaDocenti().add(docente);
		classe.getListaDocenti().add(docente2);

		System.out.println(classe.getListaStudenti());
		System.out.println(classe.getListaDocenti());

	}

}
