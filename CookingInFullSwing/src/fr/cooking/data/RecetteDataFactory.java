/**
 * 
 */
package fr.cooking.data;

import fr.cooking.data.impl.RecetteDataImpl;

/**
 * @author ajc
 *
 */
public class RecetteDataFactory {


	static private RecetteDataFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static RecetteDataFactory getFactory() {
		if (null == factory) {
			factory = new RecetteDataFactory();
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
	public IRecetteData getInstance() {
		return new RecetteDataImpl();
	}
}
