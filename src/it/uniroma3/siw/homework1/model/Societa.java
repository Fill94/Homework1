package it.uniroma3.siw.homework1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	
public class Societa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String ragioneSociale;
	@Column(nullable = false)
	private String IndirizzoSede;
	private String numeroTelefonico;
	
	public Societa() {
		
	}
	public Societa(String ragioneSociale, String indirizzoSede) {
		this.ragioneSociale = ragioneSociale;
		this.IndirizzoSede = indirizzoSede;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getIndirizzoSede() {
		return IndirizzoSede;
	}
	public void setIndirizzoSede(String indirizzoSede) {
		IndirizzoSede = indirizzoSede;
	}
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Societa azienda = (Societa)obj;
		return this.ragioneSociale==azienda.ragioneSociale && this.IndirizzoSede == azienda.IndirizzoSede && this.numeroTelefonico==azienda.numeroTelefonico;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.numeroTelefonico.hashCode()+this.IndirizzoSede.hashCode();
	}
	
}
