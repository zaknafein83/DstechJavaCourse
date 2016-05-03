/**
 * Dear Maintainer:
 * 
 * When I wrote this code, only I and God knew what it was.
 * Now, only God knows!!!
 * 
 * So, if you are done trying to "optimeze" this routine (and failed), 
 * please increment the following counter as a warning to the next guy:
 * 
 * total_hours_wasted_here: 10
 * 
 */
package org.dstech.fsisca.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author franksisca
 *
 */
public class PatternRegExExample {

	/**
	 * 
	 */
	private static final String MESI = "gennaio|febbraio|marzo|arpile|maggio|giugno|luglio|agosto|settembre|ottobre|novembre|dicembre";
	private static final String PATTERN = "mes.*(\\d\\d)";
	private static final String STOP_WORD = "\\.|\\:|\\,|\\;";

	public static void main(String[] args) {
		String testo = "Il campionato mondiale di calcio 2014 o Coppa del Mondo FIFA del 2014 (portoghese: Copa do Mundo FIFA de 2014; inglese: 2014 FIFA World Cup), noto anche come Brasile 2014, è stata la 20ª edizione del campionato mondiale di calcio per squadre nazionali maggiori maschili organizzata dalla FIFA, svoltosi dal 12 giugno al 13 luglio 2014.La squadra nazionale campione in carica, la Spagna, è stata eliminata al primo turno, dopo aver perso le partite giocate contro i Paesi Bassi (1-5) e contro il Cile (0-2).[1] La Germania, superando senza sconfitte le diverse fasi e battendo per 1-0 l'Argentina ai tempi supplementari della finale, ha conquistato il suo 4º titolo mondiale.[2][3] È stata la prima volta che una squadra europea ha vinto un mondiale in America, e la seconda che una squadra europea vince un mondiale fuori dall'Europa (Spagna è stata la prima nel 2010 in Sudafrica).";
		Pattern pattern = Pattern.compile(MESI);
		Matcher matcher = pattern.matcher(testo);
		while (matcher.find()) {
			int start = previus(matcher.group(), matcher.start(), testo);
			int end = next(matcher.group(), matcher.end(), testo);
			System.out.println("Inizio della keyword: " + start);
			System.out.println("Fine della keyword: " + end);
			System.out.println(testo.substring(start, end));
		}

	}

	/**
	 * @param group
	 * @param testo
	 * @param start
	 * @return
	 */
	private static int next(String group, int end, String testo) {
		Pattern pattern = Pattern.compile(STOP_WORD);
		Matcher matcher = pattern.matcher(testo);
		while (matcher.find()) {
			if (matcher.end() > end) {
				return matcher.end();
			}
		}
		return 0;
	}

	/**
	 * @param group
	 * @param start
	 * @param testo
	 * @return
	 */
	private static int previus(String group, int start, String testo) {
		Pattern pattern = Pattern.compile(STOP_WORD);
		Matcher matcher = pattern.matcher(testo);
		int previus = 0;
		while (matcher.find()) {
			if (matcher.start() < start) {
				previus = matcher.start();
			}
		}
		return previus;
	}
}
