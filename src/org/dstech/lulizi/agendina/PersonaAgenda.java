package org.dstech.lulizi.agendina;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PersonaAgenda implements Serializable {

	private String nome;
	private String cognome;
	private int eta;
	private String numeroTelefono;
	private String email;
	private Date dataInserimento;

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public static Comparator<PersonaAgenda> getCOMPARE_BY_NOME() {
		return COMPARE_BY_NOME;
	}

	public static void setCOMPARE_BY_NOME(Comparator<PersonaAgenda> cOMPARE_BY_NOME) {
		COMPARE_BY_NOME = cOMPARE_BY_NOME;
	}

	public static Comparator<PersonaAgenda> getCOMPARE_BY_COGNOME() {
		return COMPARE_BY_COGNOME;
	}

	public static void setCOMPARE_BY_COGNOME(Comparator<PersonaAgenda> cOMPARE_BY_COGNOME) {
		COMPARE_BY_COGNOME = cOMPARE_BY_COGNOME;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public static Comparator<PersonaAgenda> COMPARE_BY_NOME = new Comparator<PersonaAgenda>() {
		public int compare(PersonaAgenda one, PersonaAgenda other) {
			return one.nome.compareTo(other.nome);
		}
	};

	public static Comparator<PersonaAgenda> COMPARE_BY_COGNOME = new Comparator<PersonaAgenda>() {
		public int compare(PersonaAgenda one, PersonaAgenda other) {
			return one.cognome.compareTo(other.cognome);
		}
	};

	public PersonaAgenda() {

	}

	public PersonaAgenda(int id, String nome, String cognome, int eta, String numeroTelefono, String email,
			Date dataInserimento) {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", numeroTelefono=" + numeroTelefono
				+ ", email=" + email + ", dataInserimento=" + dataInserimento + "]";
	}

	public PersonaAgenda(String nome, String cognome, int eta, String numeroTelefono, String email,
			Date dataInserimento) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.numeroTelefono = numeroTelefono;
		this.email = email;
		this.dataInserimento = dataInserimento;

	}

}
