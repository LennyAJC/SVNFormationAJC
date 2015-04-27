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

	static private FormationFactory instance = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and _factory is null.
	 */
	public static FormationFactory getFactory() {
		if (null == instance) {
			instance = new FormationFactory();
		}
		return instance;
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
