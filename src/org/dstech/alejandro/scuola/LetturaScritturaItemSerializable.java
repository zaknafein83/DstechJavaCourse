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
package org.dstech.alejandro.scuola;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author franksisca
 *
 */
public class LetturaScritturaItemSerializable {

	public static List<Persona> recuperaListaOggetti(String filePath) throws ClassNotFoundException, IOException {
		List<Persona> listaOggetti = new ArrayList<Persona>();
		File fileSource = new File(filePath);
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Persona readObject;
		try {
			while ((readObject = (Persona) objectInputStream.readObject()) != null) {

				listaOggetti.add(readObject);
			}
		} catch (EOFException exp) {
			inputStream.close();
			objectInputStream.close();
			return listaOggetti;
		}
		inputStream.close();
		objectInputStream.close();
		return listaOggetti;
	}

	public static boolean salvaListaOggetti(String filePath, List<Persona> listaOggetti) throws IOException {
		File fileSource = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		for (Persona itemSerializable : listaOggetti) {
			objectOutputStream.writeObject(itemSerializable);
		}
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
		return true;

	}
}
