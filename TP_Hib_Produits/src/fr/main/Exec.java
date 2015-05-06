package fr.main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.metier.Categories;
import fr.metier.Produits;

public class Exec {

	static Utils u = Utils.getInstance();

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpa");
	private static EntityManager em = null;
	static EntityTransaction transaction;

	public static void main(String[] args) {
		int reponse;

		u.sc = new Scanner(System.in);

		u.afficher("###############################################################");
		u.afficher("#                                                             #");
		u.afficher("# Bienvenue dans le système d'enregistrement des produits !   #");
		u.afficher("#                                                             #");
		u.afficher("###############################################################");

		menu();
		reponse = u.lireInt("Quel est votre choix ?");

		while (reponse != 10) {

			if (reponse == 1) {
				u.afficher("Ajouter un nouveau produit");
				ajouterProduit();
			} else if (reponse == 2) {
				u.afficher("Ajouter une nouvelle categorie");
				ajouterCategorie();
			} else if (reponse == 3) {
				u.afficher("\n Supprimer un produit");
				supprimerProduit();
			} else if (reponse == 4) {
				u.afficher("\n Liste des produit");
				afficherProduit();
			} else if (reponse == 5) {
				u.afficher("\n Categorie d'un produit");
				afficherCategorieProduit();
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
		u.afficher(" 1) Ajouter un produit");
		u.afficher(" 2) Ajouter une catégorie");
		u.afficher(" 3) Supprimer un produit");
		u.afficher(" 4) Liste des produits");
		u.afficher(" 5) Categorie d'un produit");
		u.afficher(" 10) Quitter l'application");

	}

	public static void ajouterProduit() {
		String nomProduit = u.lireString("Nom du produit :");
		int numCategorie = u.lireInt("numero de categorie :");
		Produits p = new Produits(nomProduit);
		
		p.setCategorie(new Categories(numCategorie));
		em = getEntityManager();

		transaction = em.getTransaction();
		transaction.begin();

		em.persist(p);
		transaction.commit();
	}

	public static void ajouterCategorie() {

		int idCategorie = u.lireInt("Nom de la catégorie :");

		Categories c = new Categories(idCategorie);
		em = getEntityManager();

		transaction = em.getTransaction();
		transaction.begin();

		em.persist(c);
		transaction.commit();
	}

	public static void supprimerProduit() {
		int id = u.lireInt("Code du produit à supprimer: ");
		em = getEntityManager();

		transaction = em.getTransaction();
		transaction.begin();

		Produits p = new Produits();
		p = (Produits) em.createQuery(
				"select p from Produit p where p.idProduit='" + id + "'")
				.getSingleResult();

		em.remove(p);
		transaction.commit();
	}

	public static void afficherProduit() {
		em = getEntityManager();

		transaction = em.getTransaction();
		transaction.begin();
		
		ArrayList<Produits> p = new ArrayList<Produits>();
		p = (ArrayList<Produits>) em.createQuery("select p from Produits p")
				.getResultList();

		for (Produits produits : p) {
			u.afficher("Nom du produit :" + produits.getIdProduit() + " | "
					+ produits.getNomProduit());
		}
		transaction.commit();
	}
	
	public static void afficherCategorieProduit() {
		em = getEntityManager();

		transaction = em.getTransaction();
		transaction.begin();
		
		int id = u.lireInt("Code du produit à rechercher: ");
		
		Categories c = new Categories();
		c =  (Categories) em.createQuery("select c from Categories c,Produits p join c.produits WHERE p.idProduit='" + id + "'" )
				.getSingleResult();

			u.afficher("Nom du produit :" + c.getIdCategorie() + " | "
					+ c.getNomCategorie());
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