/**
 * 
 */
package fr.lenny.metier.factory;

import java.util.ArrayList;

import fr.lenny.metier.Formation;
import fr.lenny.metier.Stagiaire;

/**
 * @author Behelit
 *
 */
public class FormationFactory {

	static private FormationFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static FormationFactory getFactory() {
		if (null == factory) {
			factory = new FormationFactory();
		}
		return factory;
	}

	/**
	 * This is the accessor for the Singleton.
	 * 
	 * @param lstStagiaire
	 * @param nbSta
	 * @param dateFormation
	 * @param nomFormation
	 */
	public Formation getInstance(String nomFormation, String dateFormation,
			int nbSta, ArrayList<Stagiaire> lstStagiaire) {
		return new Formation(nomFormation, dateFormation, nbSta, lstStagiaire);
	}
}
