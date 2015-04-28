/**
 * 
 */
package fr.lenny.metier.factory;

import fr.lenny.utils.Utils;

/**
 * @author Behelit
 *
 */
public class UtilsFactory {

	static private UtilsFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static UtilsFactory getFactory() {
		if (null == factory) {
			factory = new UtilsFactory();
		}
		return factory;
	}

	/**
	 * This is the accessor for the Singleton.
	 */
	public Utils getInstance() {
		return new Utils();
	}
}
