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
package org.dstech.fsisca.banca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author franksisca
 *
 */
public class UtenteGenerico implements Persona {
	private String id;

	public UtenteGenerico(String id) {
		super();
		
	
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utente [id=").append(id).append("]");
		return builder.toString();
	}
	
	public void stampaListaUtenti(String url, List<Persona> listaUtenti) throws IOException{
		File file = new File(url);
		FileWriter fileWriter = new FileWriter(file);
		
		for (Persona persona : listaUtenti) {
			fileWriter.append(persona.toString());
			fileWriter.append("\r\n");
		}
		fileWriter.flush();
		fileWriter.close();

	}

	

}
