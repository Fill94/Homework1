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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;
@Entity
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	@Column(nullable = false)
	private String partitaIva;
	/*
	 * politica di fetch Lazy, un docente gestisce più corsi se si vogliono ottenere le informazioni di un docente non c'è bisogno di caricare tutti i corsi che tiene
	 * politica di cascade, un corso non può esistere senza un docente, se si aggiunge un corso bisogna associargli un docente, se si elimina un docente bisogna eliminare tutti i corsi ad esso collegati
	 */
	@OneToMany(mappedBy = "docente", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Corso> corsi;
	public Docente() {
		
	}
	public Docente(String nome, String cognome, String partitaIva) {
		this.nome = nome;
		this.cognome = cognome;
		this.partitaIva = partitaIva;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
	
}
