/**
 * 
 */
package fr.lenny.metier.factory;

import fr.lenny.metier.GestionFormation;

/**
 * @author Behelit
 *
 */
public class GestionFormationFactory {

	static private GestionFormationFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static GestionFormationFactory getFactory() {
		if (null == factory) {
			factory = new GestionFormationFactory();
		}
		return factory;
	}

	/**
	 * This is the accessor for the Singleton.
	 */
	public GestionFormation getInstance() {
		return new GestionFormation();
	}
}
