/**
 * 
 */
package org.dstech.fsisca.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultButtonModel;

/**
 * @author franksisca
 *
 */
public class ReadTableName {

	private static final String CR = "\n";
	private static final String LINE = ",";
	private static final Object INTEGER = " INTEGER NOT NULL ";
	private static final Object KEY = " PRIMARY KEY ";
	private static final Object VAR = " VARCHAR(10) ";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		List<String> leggiFile = leggiFile(ReadTableName.class.getResource("/resources/estrazionidellotto.csv").getPath());
		String firstRow = leggiFile.get(0);
		String[] splitRow = firstRow.split(";");
		createTableScript(splitRow);
	}

	/**
	 * @param splitRow
	 */
	private static void createTableScript(String[] splitRow) {
		String[] onlyTableName = Arrays.copyOfRange(splitRow, 2, splitRow.length);
		for (int i = 5; i < onlyTableName.length; i += 5) {
			createSingleTableStatemente(splitRow[0], splitRow[1], Arrays.copyOfRange(onlyTableName, i - 5, i));

		}

	}

	/**
	 * @param string
	 * @param string2
	 * @param copyOfRange
	 */
	private static void createSingleTableStatemente(String firstColumn, String secondColumn, String[] parameters) {
		StringBuilder script = new StringBuilder("CREATE TABLE IF NOT EXIST ").
				append(parameters[0].substring(0, 2)).append(CR).
				append("(").append(CR).
				append(firstColumn).append(VAR).append(LINE).append(CR).
				append(secondColumn).append(INTEGER).append(LINE).append(CR);
		for (int i = 0; i < parameters.length; i++) {
			script.append(parameters[i]).append(INTEGER).append(LINE).append(CR);
		}
		script.append(KEY).append(firstColumn).append(")").append(CR);
		System.out.println(script);
	}

	private static List<String> leggiFile(String fileUrl) throws FileNotFoundException, IOException {
		List<String> lista = new ArrayList<String>();
		File file = new File(fileUrl);
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		while (readLine != null) {
			lista.add(readLine);
			readLine = buffereReader.readLine();
		}
		buffereReader.close();
		return lista;
	}

}
