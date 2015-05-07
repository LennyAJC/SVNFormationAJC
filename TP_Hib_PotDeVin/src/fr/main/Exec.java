package fr.main;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.metier.Parti;
import fr.metier.Politique;
import fr.metier.PotDeVin;

public class Exec {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    private static EntityManager em = null;
    static EntityTransaction transaction;
    static Politique po1;
    static Politique po2;
    static Politique po3;
    static Politique po4;

    public static void main(String[] args) {

	test1();
	test2();
	test3();
    }

    /**
     * Création d'un parti et d'homme politique
     */
    public static void test1() {

	String parti1 = "PS";
	String parti2 = "UMP";
	String parti3 = "NOFUTURE";

	em = getEntityManager();

	transaction = em.getTransaction();
	transaction.begin();

	Parti p1 = new Parti(parti1);
	Parti p2 = new Parti(parti2);
	Parti p3 = new Parti(parti3);

	em.persist(p1);
	em.persist(p2);
	em.persist(p3);

	transaction.commit();

	transaction.begin();

	String pol1 = "Sarko";
	String pol2 = "Hollande";
	String pol3 = "TOTO";
	String pol4 = "Cervantes";

	po1 = new Politique(pol1);
	po2 = new Politique(pol2);
	po3 = new Politique(pol3);
	po4 = new Politique(pol4);

	p2.addPolitique(po1);
	p1.addPolitique(po2);
	p3.addPolitique(po3);
	p3.addPolitique(po4);

	em.persist(po1);
	em.persist(po2);
	em.persist(po3);
	em.persist(po4);

	transaction.commit();
    }

    /**
     * Selection des parti qui n'ont qu'un seul homme politique
     */
    static public void test2() {
	em = getEntityManager();

	transaction = em.getTransaction();
	transaction.begin();

	Query query = em.createQuery("SELECT p from Parti p");

	for (Object p : query.getResultList()) {
	    if (((Parti) p).getLstPolitique().size() == 1) {
		System.out.println("Liste" + ((Parti) p).getLstPolitique());
	    }
	}
	transaction.commit();
    }

    /**
     * Ajout pot de vin
     */
    static public void test3() {
	em = getEntityManager();

	transaction = em.getTransaction();
	transaction.begin();

	int mnt1 = 10000;
	int mnt2 = 20000;
	int mnt3 = 30000;
	int mnt4 = 40000;
	int mnt5 = 50000;
	int mnt6 = 60000;
	int mnt7 = 70000;
	int mnt8 = 80000;

	PotDeVin pdv1 = new PotDeVin(mnt1);
	PotDeVin pdv2 = new PotDeVin(mnt2);
	PotDeVin pdv3 = new PotDeVin(mnt3);
	PotDeVin pdv4 = new PotDeVin(mnt4);
	PotDeVin pdv5 = new PotDeVin(mnt5);
	PotDeVin pdv6 = new PotDeVin(mnt6);
	PotDeVin pdv7 = new PotDeVin(mnt7);
	PotDeVin pdv8 = new PotDeVin(mnt8);

//	Set<PotDeVin> lstpdv1 = new HashSet<PotDeVin>();
//	lstpdv1.add(pdv1);
//	lstpdv1.add(pdv2);
//	Set<PotDeVin> lstpdv2 = new HashSet<PotDeVin>();
//	lstpdv2.add(pdv3);
//	lstpdv2.add(pdv4);
//	Set<PotDeVin> lstpdv3 = new HashSet<PotDeVin>();
//	lstpdv3.add(pdv5);
//	lstpdv3.add(pdv6);
//	Set<PotDeVin> lstpdv4 = new HashSet<PotDeVin>();
//	lstpdv4.add(pdv7);
//	lstpdv4.add(pdv8);

	
	 po1.addPotDeVin(pdv1);
	 po1.addPotDeVin(pdv2);
	 po2.addPotDeVin(pdv3);
	 po2.addPotDeVin(pdv4);
	 po3.addPotDeVin(pdv5);
	 po3.addPotDeVin(pdv6);
	 po4.addPotDeVin(pdv7);
	 po4.addPotDeVin(pdv8);
	
	// pdv1.addPolitique(po1);
	// pdv2.addPolitique(po1);
	// pdv3.addPolitique(po2);
	// pdv4.addPolitique(po2);
	// pdv5.addPolitique(po3);
	// pdv6.addPolitique(po3);
	// pdv7.addPolitique(po4);
	// pdv8.addPolitique(po4);

//	po1.setPotDeVins(lstpdv1);
//	po2.setPotDeVins(lstpdv2);
//	po3.setPotDeVins(lstpdv3);
//	po4.setPotDeVins(lstpdv4);

	em.persist(po1);
	em.persist(po2);
	em.persist(po3);
	em.persist(po4);
	// em.persist(pdv1);
	// em.persist(pdv2);
	// em.persist(pdv3);
	// em.persist(pdv4);
	// em.persist(pdv5);
	// em.persist(pdv6);
	// em.persist(pdv7);
	// em.persist(pdv8);

	transaction.commit();
	
	//Politique pol1 = em.find(Politique.class, 1)
    }

    /**
     * Selectionner le montant total des pots de vin de chaque homme politique
     */

    public void test4() {
	em = getEntityManager();

	transaction = em.getTransaction();
	transaction.begin();

	transaction.commit();
    }

    /**
     * Singleton d'entityManager
     * 
     * @return
     */
    private static EntityManager getEntityManager() {
	if (em == null || !em.isOpen()) {
	    em = emf.createEntityManager();
	}
	return em;
    }

}
