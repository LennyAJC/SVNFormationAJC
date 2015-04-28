/**
 * 
 */
package fr.lenny.metier.impl;

import java.util.ArrayList;

import fr.lenny.metier.Stagiaire;

/**
 * @author ajc
 *
 */
public interface IManipStagiaire {

	/**
	 * 
	 * @param lstStagiaire
	 * @return
	 */
	public ArrayList<Stagiaire> getStagiaire();

	public void afficherlst();

	/**
	 * Methode permettant d'ajouter un stagiaire
	 */
	public void ajouterStagiaire(IStagiaire istag);

	public void trier();

	public int moyenneAge();

}
