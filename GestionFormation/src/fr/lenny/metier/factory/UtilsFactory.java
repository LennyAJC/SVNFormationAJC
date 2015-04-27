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

	static private UtilsFactory instance = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and _factory is null.
	 */
	public static UtilsFactory getFactory() {
		if (null == instance) {
			instance = new UtilsFactory();
		}
		return instance;
	}

	/**
	 * This is the accessor for the Singleton.
	 */
	public Utils getInstance() {
		return new Utils();
	}
}
