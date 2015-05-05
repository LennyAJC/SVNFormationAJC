package fr.main;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.entity.Formation;
import fr.utils.Utils;

public class Exec {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpa");
	private static EntityManager em = null;
	private static EntityTransaction transaction;
	private static Formation formation;
	static Utils u = Utils.getInstance();

	public static void main(String[] args) throws Exception {
		int reponse;

		u.sc = new Scanner(System.in);
		u.afficher("###############################################################");
		u.afficher("#                                                             #");
		u.afficher("# Bienvenue dans le syst�me d'enregistrement des formations ! #");
		u.afficher("#                                                             #");
		u.afficher("###############################################################");

		menu();
		reponse = u.lireInt("Quel est votre choix ?");

		while (reponse != 10) {

			if (reponse == 1) {
				u.afficher("Ajouter une nouvelle formation");
				creerFormation();
			} else if (reponse == 2) {
				u.afficher("Saisissez le num�ro de la formation que vous voulez supprimer");
				supprimerFormation(null);
			} else if (reponse == 3) {
				u.afficher("Saisissez le num�ro de la formation que vous voulez modifier");
				creerFormation();
			} else if (reponse == 4) {
				u.afficher("Saisissez le num�ro de la formation � laquelle vous souhaitez ajouter des stagiaires");
				creerFormation();
			} else if (reponse == 5) {
				u.afficher("\n Liste des formations");
				afficherFormation();
			} else {
				u.afficher("Je n'ai compris votre choix");
			}
			menu();
			reponse = u.lireInt("Quel est votre choix ?");
		}

	}

	private static void menu() {

		u.afficher(" Menu :");
		u.afficher(" 1) Ajouter une formation");
		u.afficher(" 2) Supprimer une formation");
		u.afficher(" 3) Modifier une formation");
		u.afficher(" 4) Ajouter Stagiaire");
		u.afficher(" 5) Afficher la liste des formations");
		u.afficher(" 10) Quitter l'application");

	}

	private static void creerFormation() throws ParseException {

		em = getEntityManager();
		transaction = em.getTransaction();

		transaction.begin();
		String nomFormation = u.lireString("Nom de la formation :");
		Date dateFormation = u.lireDate("Date de la formation : ");
		int nbStagiaireMax = u.lireInt("Nombre de stagiaire maximum : ");
		formation = new Formation(nomFormation, dateFormation, nbStagiaireMax);
		// formation = new Formation("Formation JAVA HIBERNATE", new
		// SimpleDateFormat(
		// "dd/MM/yy").parse("05/05/2015"), 0);

		em.persist(formation);

		transaction.commit();

	}

	// private static void findlast() {
	//
	// EntityManager em = getEntityManager();
	// transaction = em.getTransaction();
	//
	// transaction.begin();
	// f4 = em.find(Formation.class, 34);
	// transaction.commit();
	// dump();
	//
	// }

	/**
	 * Methode permettant de renvoyer la liste des formations
	 */
	private static void afficherFormation() {

		EntityManager em = getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		System.out.println("List des Formations =>");
		for (Object f : em.createQuery("select f from Formation f ")
				.getResultList()) {
			System.out.println(" -> " + f + " \n ");
		}

		transaction.commit();
	}

	/**
	 * Methode permettant d'ajouter un stagiaire � une formation
	 */
	public static void ajouterStagiaire() {

		EntityManager em = getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		formation.setNbStagiaire(formation.getNbStagiaire() + 3);

		transaction.commit();

		afficherFormation();
	}

	/**
	 * Methode permettant de supprimer une formation
	 * 
	 * @param formation
	 */
	public static void supprimerFormation(Formation formation) {

		EntityManager em = getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.remove(formation);

		transaction.commit();

		afficherFormation();
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
