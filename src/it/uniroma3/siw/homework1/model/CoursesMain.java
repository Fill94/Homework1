package it.uniroma3.siw.homework1.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class CoursesMain {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("courses-unit");
		EntityManager em = emf.createEntityManager(); 

		Allievo allievo1 = new Allievo("mario", "rossi", 0001);
		Allievo allievo2 = new Allievo("Filippo", "Musmeci", 479197);
		Allievo allievo3 = new Allievo("luca", "moretti", 652133);
		Societa azienda1 = new Societa("ragioneSocialeAzienda1", "Via talDeTali 12");
		Societa azienda2 = new Societa("ragioneSocialeAzienda2", "via roma 21");
		allievo1.setAzienda(azienda1);
		allievo2.setAzienda(azienda1);
		allievo3.setAzienda(azienda2);
		
		Corso corso1 = new Corso();
		corso1.setNome("siw");
		List<Allievo> allievi = Arrays.asList(allievo1,allievo2,allievo3);
		corso1.setAllieviIscritti(allievi);
		Docente docente1 = new Docente("paolo", "merialdo", "partitaIvaPaolo");
		List<Corso> corsi = new LinkedList<>();
		corsi.add(corso1);
		docente1.setCorsi(corsi);
		corso1.setDocente(docente1);

		EntityTransaction tx = em.getTransaction();

		
//		tx.begin();
//		em.persist(corso1);
//		em.persist(docente1);
//		tx.commit();
		
		tx.begin();
		em.persist(docente1);
		tx.commit();
		
		Allievo allievo4 = new Allievo("giorgio", "cognome", 348732);
		Corso corso2 = new Corso();
		corso2.setNome("APS");
		corso2.setAllieviIscritti(Arrays.asList(allievo4));
		corso2.setDocente(docente1);
		corsi = docente1.getCorsi();
		corsi.add(corso2);
		
		docente1.setNome("LUCA");
		tx.begin();
		em.persist(docente1);
		tx.commit();
		
//		tx.begin();
//		em.remove(docente1);
//		tx.commit();
		

		em.close();
		emf.close();
	}

}
