package org.dstech.vangelini;

public class Muovimenti {
	private double denaro;
	private String azione;
	private Long timeStamp;
	
	public Muovimenti(double denaro, String azione, Long timeStamp) {
		this.denaro = denaro;
		this.azione = azione;
		this.timeStamp = timeStamp;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getDenaro() {
		return denaro;
	}

	public void setDenaro(double denaro) {
		this.denaro = denaro;
	}

	public String getAzione() {
		return azione;
	}

	public void setAzione(String azione) {
		this.azione = azione;
	}
	
}
