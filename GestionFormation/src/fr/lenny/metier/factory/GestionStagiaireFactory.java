/**
 * 
 */
package fr.lenny.metier.factory;

import fr.lenny.metier.GestionStagiaire;

/**
 * @author ajc
 *
 */
public class GestionStagiaireFactory {

	static private GestionStagiaireFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static GestionStagiaireFactory getFactory() {
		if (null == factory) {
			factory = new GestionStagiaireFactory();
		}
		return factory;
	}

	/**
	 * This is the accessor for the Singleton.
	 */
	public GestionStagiaire getInstance() {
		return new GestionStagiaire();
	}
}