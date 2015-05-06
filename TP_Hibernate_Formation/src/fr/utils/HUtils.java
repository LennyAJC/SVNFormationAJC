package fr.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.entity.Formation;

public class HUtils {

	private static HUtils instance = null;
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("jpa");
	private static EntityManager em = null;
	static EntityTransaction transaction;

	public HUtils() {

	}

	public static HUtils getInstance() {
		if (instance == null) {
			instance = new HUtils();
		}
		return instance;
	}

	public Formation execute(Formation formation, int idFormation, String mode) {
		EntityManager em = getEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		if (mode.equals("PER")) {
			em.persist(formation);
		}
		if (mode.equals("SEL")){
			formation = (Formation) em.createQuery(
					"select f from Formation f WHERE f.idFormation='" + idFormation
							+ "'").getSingleResult();
		}
		// remove

		transaction.commit();
		return formation;
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
