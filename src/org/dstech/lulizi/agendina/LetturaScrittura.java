package org.dstech.lulizi.agendina;



	import java.io.EOFException;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.ArrayList;
	import java.util.List;

	/**
	 * @author franksisca
	 *
	 */
	public class LetturaScrittura {

		public static List<Persona> recuperaListaOggetti(String filePath) throws FileNotFoundException, ClassNotFoundException, IOException {
			List<Persona> listaPersonee = new ArrayList<Persona>();
			File fileSource = new File("agendinalucaulizi.jjj");
			FileInputStream inputStream = new FileInputStream(fileSource);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			Persona readObject;
			try {
				while ((readObject = (Persona) objectInputStream.readObject()) != null) {

					listaPersonee.add(readObject);
				}
			}catch (FileNotFoundException exc) {
				System.out.println(exc);
				FileOutputStream file = new FileOutputStream(
						"(agendinalucaulizi.jjj");
				System.out.println("agendina ora è stata creata");
			} catch (EOFException exp) {
				inputStream.close();
				objectInputStream.close();
				return listaPersonee;
			}
			inputStream.close();
			objectInputStream.close();
			return listaPersonee;
		}
		
		
		public static boolean salvaListaOggetti(String filePath, List<Persona> listaPersonee) throws IOException {
			File fileSource = new File(filePath);
			FileOutputStream fileOutputStream = new FileOutputStream(fileSource);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			for (Persona itemSerializable : listaPersonee) {
				objectOutputStream.writeObject(itemSerializable);
			}
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();
			return true;

		}
	}
