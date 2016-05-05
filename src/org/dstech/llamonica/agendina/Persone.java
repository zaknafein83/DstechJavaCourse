package org.dstech.llamonica.agendina;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persone {
private String nome;
private String cognome;
private String eta;
private String telefono=("\\d{3} \\d{3} \\d{7}");
private String email=("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

private Date data;
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
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
public String getEta() {
	return eta;
}
public void setEta(String eta) {
	this.eta = eta;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Persone [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", telefono=" + telefono + ", email="
			+ email + ", data=" + data + "]";
}




	
	
}
