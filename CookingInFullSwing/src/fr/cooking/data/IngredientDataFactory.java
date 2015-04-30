/**
 * 
 */
package fr.cooking.data;

import fr.cooking.data.impl.IngredientDataImpl;


/**
 * @author ajc
 *
 */
public class IngredientDataFactory {


	static private IngredientDataFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static IngredientDataFactory getFactory() {
		if (null == factory) {
			factory = new IngredientDataFactory();
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
	public IIngredientData getInstance() {
		return new IngredientDataImpl();
	}
}
