/**
 * 
 */
package fr.lenny.metier.impl;

import java.util.ArrayList;

import fr.lenny.metier.Stagiaire;

/**
 * @author Behelit
 *
 */
public interface IFormation {

	/**
	 * @return the nbSta
	 */
	public int getNbSta();

	/**
	 * @param nbSta
	 *            the nbSta to set
	 */
	public void setNbSta(int nbSta);

	// Getterz & Setterz
	/**
	 * @return the nomFormation
	 */
	public String getNomFormation();

	/**
	 * @param nomFormation
	 *            the nomFormation to set
	 */
	public void setNomFormation(String nomFormation);

	/**
	 * @return the dateFormation
	 */
	public String getDateFormation();

	/**
	 * @param dateFormation
	 *            the dateFormation to set
	 */
	public void setDateFormation(String dateFormation);

	/**
	 * @return the lstStagiaire
	 */
	public ArrayList<Stagiaire> getLstStagiaire();

	/**
	 * @param lstStagiaire
	 *            the lstStagiaire to set
	 */
	public void setLstStagiaire(ArrayList<Stagiaire> lstStagiaire);
}
