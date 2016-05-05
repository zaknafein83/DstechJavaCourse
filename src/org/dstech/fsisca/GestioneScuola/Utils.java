/**
 * 
 */
package org.dstech.fsisca.GestioneScuola;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author franksisca
 *
 */
public class Utils {

	/**
	 * 
	 */
	public static final String DD_MM_YYYY = "dd/mm/yyyy";

	/**
	 * @param data
	 * @return
	 */
	public static String formatDateAppello(Date data) {
		SimpleDateFormat dateFormat =  new SimpleDateFormat(DD_MM_YYYY);
		return dateFormat.format(data);
	}

	/**
	 * @param data
	 * @return
	 * @throws ParseException 
	 */
	public static Date convertDateFromString(String data) throws ParseException {
		SimpleDateFormat dateFormat =  new SimpleDateFormat(DD_MM_YYYY);
		return dateFormat.parse(data);
	}

}
