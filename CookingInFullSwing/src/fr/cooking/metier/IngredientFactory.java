/**
 * 
 */
package fr.cooking.metier;

import fr.cooking.metier.impl.IngredientImpl;


/**
 * @author ajc
 *
 */
public class IngredientFactory {


	static private IngredientFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static IngredientFactory getFactory() {
		if (null == factory) {
			factory = new IngredientFactory();
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
	public IIngredient getInstance() {
		return new IngredientImpl();
	}
}
