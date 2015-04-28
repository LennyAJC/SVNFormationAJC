/**
 * 
 */
package fr.lenny.metier.impl;

import fr.lenny.metier.Stagiaire;

/**
 * @author Behelit
 *
 */
public interface IStagiaire {

	// Getterz & Setterz
	/**
	 * @return the nom
	 */
	public String getNom();

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom);

	/**
	 * @return the prenom
	 */
	public String getPrenom();

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom);

	/**
	 * @return the age
	 */
	public int getAge();

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Stagiaire sta);

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Stagiaire sta);
}
