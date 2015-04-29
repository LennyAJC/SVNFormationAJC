/**
 * 
 */
package fr.lenny.metier;

/**
 * @author ajc
 *
 */
public class ElevesFactory {

	private static ElevesFactory factory = null;
	private static IEleves instance = null;

	public static ElevesFactory getFactory() {
		if (factory == null) {
			factory = new ElevesFactory();
		}
		return factory;
	}

	public IEleves getInstance(String classe) {

		if (classe.equals("CP")) {
			instance = new CP();
		} else if (classe.equals("CM1")) {
			instance = new CM1();
		}
		return instance;

	}
}
