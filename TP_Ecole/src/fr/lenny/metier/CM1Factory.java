/**
 * 
 */
package fr.lenny.metier;

/**
 * @author ajc
 *
 */
public class CM1Factory {
	
	private static CPFactory factory = null;

	public static CPFactory getFactory() {
		if (factory == null) {
			factory = new CPFactory();
		}
		return factory;
	}

	public static IEleves getInstance() {

		return new CM1();
	}
}
