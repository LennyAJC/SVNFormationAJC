/**
 * 
 */
package fr.lenny.metier.impl;

import java.util.ArrayList;

import fr.lenny.metier.Formation;

/**
 * @author Behelit
 *
 */
public interface IGestionFormation {
	/**
	 * Method qui retourne une liste de Formation
	 * 
	 * @return lstStagiaire : une liste de formation
	 */
	public ArrayList<Formation> getFormation();

	/**
	 * Method qui permet d'afficher la liste des formations (nom, date, nbstag)
	 */
	public void afficherlst();

	/**
	 * Method permettant d'ajouter une formation à la liste des formation
	 */
	public void ajouterFormation(IFormation iform);

	/**
	 * Method permettant de trier la liste de formations (ordre croissant par
	 * date???) cf. compareTo de Stagiaire
	 */
	// public void trier();
}
