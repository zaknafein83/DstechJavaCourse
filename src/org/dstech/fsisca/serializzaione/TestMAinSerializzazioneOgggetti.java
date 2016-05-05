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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author franksisca
 *
 */
public class TestMAinSerializzazioneOgggetti {
	
	private static final String FILEPATH = "esempioSerializzato.xxs";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		ItemSerializable item1 = new ItemSerializable("a", "b", "c");
//		ItemSerializable item2 = new ItemSerializable("ddddd", "21312312", "123124rdafa");
//		ItemSerializable item3 = new ItemSerializable("aaaaaa", "bcvvvv", "cccc");
//		
//		List<ItemSerializable> lista = new ArrayList<ItemSerializable>();
//		lista.add(item1);
//		lista.add(item3);
//		lista.add(item2);
//		
//		
//		LetturaScritturaItemSerializable.salvaListaOggetti(FILEPATH, lista);
		
		List<ItemSerializable> recuperaListaOggetti = LetturaScritturaItemSerializable.recuperaListaOggetti(FILEPATH);
		for (ItemSerializable itemSerializable : recuperaListaOggetti) {
			System.out.println(itemSerializable);
		}
	}

}
