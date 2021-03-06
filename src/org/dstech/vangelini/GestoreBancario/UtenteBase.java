package org.dstech.vangelini.GestoreBancario;

import java.util.ArrayList;

public class UtenteBase extends OperazioniUtente{
	private Integer id;
	private double saldo;
	private ArrayList<Muovimenti> muovimenti;
	
	public boolean addMovimento (Muovimenti muovimenti){
		this.muovimenti.add(muovimenti);
		return true;
	}
	public UtenteBase(Integer id, double saldo) {
		this.id = id;
		this.saldo = saldo;
		this.muovimenti = null;
	}

	public Integer getId() {
		return id;
	}

	public ArrayList<Muovimenti> getMuovimenti() {
		return muovimenti;
	}

	public void setMuovimenti(ArrayList<Muovimenti> muovimenti) {
		this.muovimenti = muovimenti;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
