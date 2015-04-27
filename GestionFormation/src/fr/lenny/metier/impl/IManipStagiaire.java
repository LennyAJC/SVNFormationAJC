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
	 * Method qui retourne une liste de Stagiaire
	 * 
	 * @return lstStagiaire : une liste de stagiaires
	 */
	public ArrayList<Stagiaire> getStagiaire();

	/**
	 * Method qui permet d'afficher la liste des stagiaires (nom, prenom, age)
	 */
	public void afficherlst();

	/**
	 * Method permettant d'ajouter un stagiaire à la liste des stagiaires
	 */
	public void ajouterStagiaire(IStagiaire istag);

	/**
	 * Method permettant de trier la liste des stagiaires (ordre croissant de
	 * l'age) cf. compareTo de Stagiaire
	 */
	public void trier();

	/**
	 * Method permettant de faire la moyenne des ages des stagiaires
	 * @return moyenne : la moyenne des ages des stagiaires
	 */
	public int moyenneAge();

}
