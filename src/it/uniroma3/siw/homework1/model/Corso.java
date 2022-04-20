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
	 * politica di fetch lazy perchè un corso può avere molti allievi, non è efficiente caricare in memoria tutti gli allievi
	 * politica di cascade per eventi persist perchè se si crea un nuovo corso presumibilmente avrà degli allievi, mentre se si cancella un corso non è detto che bisogna cancellare dal sistema gli allievi iscritti ad esso
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Allievo> allieviIscritti;
	/*
	 * politica di fetch, eager perchè un corso ha solo un docente se si cercano le informazioni del corso è probabile che si cerchino anche le informazioni del docente associato ad esso
	 * politica cascade : solo su eventi persist perchè se aggiungo un corso dovrà avere un docente ad esso associato, ma se elimino un corso non è detto che debba essere cancellato anche il docente associato ad esso
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
