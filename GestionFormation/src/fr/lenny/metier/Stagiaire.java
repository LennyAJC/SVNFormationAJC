/**
 * 
 */
package fr.lenny.metier;

import fr.lenny.metier.impl.IStagiaire;

/**
 * @author ajc
 *
 */
public class Stagiaire implements Comparable<Stagiaire>, IStagiaire {
	String nom;
	String prenom;
	int age;

	/**
	 * Constructor de Stagiaire
	 * 
	 * @param nom
	 * @param prenom
	 * @param age
	 */
	public Stagiaire(String nom, String prenom, int age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	// Getterz & Setterz
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Stagiaire sta) {
		int result = 0;
		if (this.getAge() < sta.getAge()) {
			result = -1;
		} else if (this.getAge() > sta.getAge()) {
			result = 1;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Stagiaire sta) {
		boolean result = false;
		if (this.getAge() == sta.getAge()) {
			result = true;
		}
		// TODO Auto-generated method stub
		return result;
	}

}
