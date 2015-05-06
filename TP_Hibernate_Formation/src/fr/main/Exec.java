package fr.main;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.entity.Formation;
import fr.utils.HUtils;
import fr.utils.Utils;

public class Exec {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpa");
	private static EntityManager em = null;
	static EntityTransaction transaction;
	private static Formation formation;
	static Utils u = Utils.getInstance();
	static HUtils hu = HUtils.getInstance();

	public static void main(String[] args) throws Exception {
		int reponse;

		u.sc = new Scanner(System.in);
		u.afficher("###############################################################");
		u.afficher("#                                                             #");
		u.afficher("# Bienvenue dans le système d'enregistrement des formations ! #");
		u.afficher("#                                                             #");
		u.afficher("###############################################################");

		menu();
		reponse = u.lireInt("Quel est votre choix ?");

		while (reponse != 10) {

			if (reponse == 1) {
				u.afficher("Ajouter une nouvelle formation");
				creerFormation();
			} else if (reponse == 2) {
				u.afficher("Supprimer une formation");
				supprimerFormation();
			} else if (reponse == 3) {
				u.afficher("Modifier une formation");
				ajouterStagiaire();
			} else if (reponse == 4) {
				u.afficher("Ajouter des stagiaires");
				ajouterStagiaire();
			} else if (reponse == 5) {
				u.afficher("\n Liste des formations");
				afficherFormation();
			} else {
				u.afficher("Je n'ai compris votre choix");
			}
			menu();
			reponse = u.lireInt("Quel est votre choix ?");
		}
		u.afficher(" Au revoir !");
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

		String nomFormation = u.lireString("Nom de la formation :");
		Date dateFormation = u.lireDate("Date de la formation : ");
		int nbStagiaireMax = u.lireInt("Nombre de stagiaire maximum : ");
		formation = new Formation(nomFormation, dateFormation, nbStagiaireMax);

		hu.execute(formation, 0, "PER");

		// em = getEntityManager();
		// transaction = em.getTransaction();
		//
		// transaction.begin();
		//
		// em.persist(formation);
		//
		// transaction.commit();

	}

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
	 * Methode permettant d'ajouter un stagiaire à une formation
	 */
	public static void ajouterStagiaire() {


		int idFormation = u.lireInt("Numéro de formation :");
		int nbStagiaire = u.lireInt("Nombre de stagiaire à ajouter :");
		formation = hu.execute(formation, idFormation, "SEL");
		
		formation.setNbStagiaire(formation.getNbStagiaire() + nbStagiaire);
	}

	/**
	 * Methode permettant de supprimer une formation
	 * 
	 * @param formation
	 */
	public static void supprimerFormation() {

		EntityManager em = getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		int idFormation = u
				.lireInt("Indiquer le numéro de formation que vous souhaitez supprimer :");

		formation = (Formation) em.createQuery(
				"select f from Formation f WHERE f.idFormation='" + idFormation
						+ "'").getSingleResult();
		em.remove(formation);

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
