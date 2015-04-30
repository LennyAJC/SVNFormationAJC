/**
 * 
 */
package fr.cooking.metier;

import fr.cooking.metier.impl.RecetteImpl;

/**
 * @author ajc
 *
 */
public class RecetteFactory {

	static private RecetteFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static RecetteFactory getFactory() {
		if (null == factory) {
			factory = new RecetteFactory();
		}
		return factory;
	}

	/**
	 * This is the accessor for the Singleton.
	 * 
	 * @param nom
	 * @param prenom
	 * @param telephone
	 */
	public IRecette getInstance() {
		return new RecetteImpl();
	}
}
