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
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String nome;
	private  LocalDate dataInizio;
	private int duarata;
	/*
	 * politica di fetch lazy perch� un corso pu� avere molti allievi, non � efficiente caricare in memoria tutti gli allievi
	 * politica di cascade per eventi persist perch� se si crea un nuovo corso presumibilmente avr� degli allievi, mentre se si cancella un corso non � detto che bisogna cancellare dal sistema gli allievi iscritti ad esso
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Allievo> allieviIscritti;
	/*
	 * politica di fetch, eager perch� un corso ha solo un docente se si cercano le informazioni del corso � probabile che si cerchino anche le informazioni del docente associato ad esso
	 * politica cascade : solo su eventi persist perch� se aggiungo un corso dovr� avere un docente ad esso associato, ma se elimino un corso non � detto che debba essere cancellato anche il docente associato ad esso
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	private Docente docente;
	
	
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
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public int getDuarata() {
		return duarata;
	}
	public void setDuarata(int duarata) {
		this.duarata = duarata;
	}
	public List<Allievo> getAllieviIscritti() {
		return allieviIscritti;
	}
	public void setAllieviIscritti(List<Allievo> allieviIscritti) {
		this.allieviIscritti = allieviIscritti;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
}
