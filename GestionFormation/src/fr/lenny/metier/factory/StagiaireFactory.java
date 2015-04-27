/**
 * 
 */
package fr.lenny.metier.factory;

import fr.lenny.metier.Stagiaire;

/**
 * @author Behelit
 *
 */
public class StagiaireFactory {

	static private StagiaireFactory instance = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and _factory is null.
	 */
	public static StagiaireFactory getFactory() {
		if (null == instance) {
			instance = new StagiaireFactory();
		}
		return instance;
	}

	/**
	 * This is the accessor for the Singleton.
	 * 
	 * @param age
	 * @param prenom
	 * @param nom
	 */
	public Stagiaire getInstance(String nom, String prenom, int age) {
		return new Stagiaire(nom, prenom, age);
	}
}
