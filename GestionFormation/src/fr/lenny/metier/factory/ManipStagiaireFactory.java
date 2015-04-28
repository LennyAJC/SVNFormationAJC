/**
 * 
 */
package fr.lenny.metier.factory;

import fr.lenny.metier.ManipStagiaire;

/**
 * @author ajc
 *
 */
public class ManipStagiaireFactory {

	static private ManipStagiaireFactory instance = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and _factory is null.
	 */
	public static ManipStagiaireFactory getFactory() {
		if (null == instance) {
			instance = new ManipStagiaireFactory();
		}
		return instance;
	}

	/**
	 * This is the accessor for the Singleton.
	 */
	public ManipStagiaire getInstance() {
		return new ManipStagiaire();
	}
}