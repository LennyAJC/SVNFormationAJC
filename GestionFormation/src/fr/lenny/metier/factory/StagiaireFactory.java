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

	static private StagiaireFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static StagiaireFactory getFactory() {
		if (null == factory) {
			factory = new StagiaireFactory();
		}
		return factory;
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
