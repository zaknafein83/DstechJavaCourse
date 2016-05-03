package org.dstech.vangelini.GestoreBancario;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Operatore extends Operazioni{
	private Integer id;

	public Operatore(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void StampaUtenti(String url) throws IOException{
		//System.out.println("Utente: "+utente.getId());
		File file = new File(url);
		//FileWriter file_writer = new FileWriter(file);
		
	}
}
