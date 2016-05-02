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
package org.dstech.corso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author franksisca
 *
 */
public class LetturaSalvataggioFile {

	public static void main(String[] args) throws IOException {
		leggiFile("esempio.txt");
		salvaFile("/Users/franksisca/Documents/DStech/salvataggio.txt");

	}

	private static void salvaFile(String pippo) throws IOException {
		String contenutoDaSalvare = "Stiamo salvando da codice";
		File file = new File(pippo);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.append(contenutoDaSalvare);
		fileWriter.flush();
		fileWriter.close();
	}

	private static void leggiFile(String fileUrl) throws FileNotFoundException, IOException {
		File file = new File(fileUrl);
		FileReader in = new FileReader(file);
		BufferedReader buffereReader = new BufferedReader(in);
		String readLine = buffereReader.readLine();
		while (readLine != null) {
			System.out.println(readLine);
			readLine = buffereReader.readLine();
		}

		buffereReader.close();
	}

}
