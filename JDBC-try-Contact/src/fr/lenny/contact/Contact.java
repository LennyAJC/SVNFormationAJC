/**
 * 
 */
package fr.lenny.contact;

import fr.lenny.contact.impl.IContact;
import fr.lenny.data.factory.ContactDataFactory;
import fr.lenny.data.impl.IContactData;

/**
 * @author ajc
 *
 */
public class Contact implements IContact {

	String nom;
	String prenom;
	String telephone;
	ContactDataFactory cdf = null;
	IContactData icd = null;

	public Contact() {

	}

	public Contact(String nom, String prenom, String telephone) {
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
	 * @see fr.lenny.contact.impl.IContact#enregistrer()
	 */
	@Override
	public void enregistrer() {
		cdf = ContactDataFactory.getFactory();
		icd = cdf.getInstance();

		icd.setNom(this.nom);
		icd.setPrenom(this.prenom);
		icd.setTelephone(this.telephone);
		
		icd.enregistrer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.lenny.contact.impl.IContact#recuperer()
	 */
	@Override
	public void recuperer() {
		cdf = ContactDataFactory.getFactory();
		icd = cdf.getInstance();
		
		icd.recuperer();
		

	}

}
