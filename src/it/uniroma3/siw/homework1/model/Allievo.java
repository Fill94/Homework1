package it.uniroma3.siw.homework1.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Allievo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	private LocalDate dataDiNascita;
	
	private String luogoDiNascita;
	
	@Column(nullable = false)
	private Long matricola;
	
	private String eMail;
	
	/*
	 * cascade solo su persit perchè se si elimina un allievo non è detto che debba essere eliminata
	 * anche l'azienda a cui appartiene, ci potrebbero essere altri allievi appartenenti a quella azienda all'interno
	 * del db
	 * Politica di fetch eager perchè ogni allievo è dipendente di una sola azienda, non vi è impatto sulle prestazioni
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST) 
	private Societa azienda;
	
	@ManyToMany(mappedBy = "allieviIscritti", fetch = FetchType.EAGER )
	private List<Corso> corsi;
	public Allievo() {
		
	}
	public Allievo(String nome, String cognome, long matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
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
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public long getMatricola() {
		return matricola;
	}
	public void setMatricola(long matricola) {
		this.matricola = matricola;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Societa getAzienda() {
		return azienda;
	}
	public void setAzienda(Societa azienda) {
		this.azienda = azienda;
	}
	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		Allievo allievo = (Allievo)obj;
		return this.matricola == allievo.matricola;
	}
	@Override
	public int hashCode() {
		return this.matricola.hashCode();
	}
	
	
}
