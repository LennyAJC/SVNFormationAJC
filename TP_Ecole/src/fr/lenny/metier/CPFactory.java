/**
 * 
 */
package fr.lenny.metier;

/**
 * @author ajc
 *
 */
@Deprecated
public class CPFactory {

	private static CPFactory factory = null;

	public static CPFactory getFactory() {
		if (factory == null) {
			factory = new CPFactory();
		}
		return factory;
	}

	public static IEleves getInstance() {

		return new CP();
	}
}
