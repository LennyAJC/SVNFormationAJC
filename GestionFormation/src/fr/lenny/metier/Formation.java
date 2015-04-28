/**
 * 
 */
package fr.lenny.metier;

import java.util.ArrayList;

import fr.lenny.metier.impl.IFormation;

/**
 * @author ajc
 *
 */
public class Formation implements IFormation {
	String nomFormation;
	String dateFormation;
	int nbSta;
	ArrayList<Stagiaire> lstStagiaire;

	public Formation(String nomFormation, String dateFormation, int nbSta,
			ArrayList<Stagiaire> lstStagiaires) {
		this.nomFormation = nomFormation;
		this.dateFormation = dateFormation;
		this.nbSta = nbSta;
		this.lstStagiaire = lstStagiaires;
	}

	public Formation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nbSta
	 */
	public int getNbSta() {
		return nbSta;
	}

	/**
	 * @param nbSta
	 *            the nbSta to set
	 */
	public void setNbSta(int nbSta) {
		this.nbSta = nbSta;
	}

	// Getterz & Setterz
	/**
	 * @return the nomFormation
	 */
	public String getNomFormation() {
		return nomFormation;
	}

	/**
	 * @param nomFormation
	 *            the nomFormation to set
	 */
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	/**
	 * @return the dateFormation
	 */
	public String getDateFormation() {
		return dateFormation;
	}

	/**
	 * @param dateFormation
	 *            the dateFormation to set
	 */
	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}

	/**
	 * @return the lstStagiaire
	 */
	public ArrayList<Stagiaire> getLstStagiaire() {
		return lstStagiaire;
	}

	/**
	 * @param lstStagiaire
	 *            the lstStagiaire to set
	 */
	public void setLstStagiaire(ArrayList<Stagiaire> lstStagiaire) {
		this.lstStagiaire = lstStagiaire;
	}

}
