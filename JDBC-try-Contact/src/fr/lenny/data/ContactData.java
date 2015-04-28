/**
 * 
 */
package fr.lenny.data;

import java.sql.ResultSet;
import java.sql.Statement;

import fr.lenny.data.impl.IContactData;

/**
 * @author ajc
 *
 */
public class ContactData implements IContactData {

	String nom;
	String prenom;
	String telephone;

	Statement stmt = null;
	ResultSet rst = null;

	public ContactData() {

	}

	public ContactData(String nom, String prenom, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;

	}

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
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.lenny.dao.impl.IContactDao#enregistrer()
	 */
	@Override
	public void enregistrer() {
		
		ContactDao cd = ContactDao.getInstance();
		cd.insert(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.lenny.dao.impl.IContactDao#recuperer()
	 */
	@Override
	public void recuperer() {

		ContactDao cd = ContactDao.getInstance();
		cd.recuperer();
	}
}
