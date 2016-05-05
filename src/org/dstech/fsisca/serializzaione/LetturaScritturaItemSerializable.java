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
package org.dstech.fsisca.serializzaione;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public static List<ItemSerializable> recuperaListaOggetti(String filePath) throws ClassNotFoundException, IOException {
		List<ItemSerializable> listaOggetti = new ArrayList<ItemSerializable>();
		File fileSource = new File(filePath);
		FileInputStream inputStream = new FileInputStream(fileSource);
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		ItemSerializable readObject;
		try {
			while ((readObject = (ItemSerializable) objectInputStream.readObject()) != null) {

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

	public static boolean salvaListaOggetti(String filePath, List<ItemSerializable> listaOggetti) throws IOException {
		File fileSource = new File(filePath);
		FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		for (ItemSerializable itemSerializable : listaOggetti) {
			objectOutputStream.writeObject(itemSerializable);
		}
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();
		return true;

	}

	/**
 * 
 */
	public static void main(String[] args) {
		met(5);
	}
	private static void met(int val) {
		// TODO Auto-generated method stub
		switch (val) {
		case 1:
			System.out.println("siamo nel case 1");
			break;
		case 3: 
			System.out.println("siamo nel case 3");
			break;
		case 4:
			System.out.println("siamo nel case 4");
			break;
			
//		default:
//			System.out.println("siamo nel case default");
//
//			break;

		}
	}
}
