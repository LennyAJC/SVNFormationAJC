/**
 * 
 */
package fr.lenny.contact.impl;

import java.util.Comparator;

import fr.lenny.data.impl.IContactData;

/**
 * @author ajc
 *
 */
public interface IContact {

	Comparator<IContact> NomContactComparator = null;

	public void enregistrer(IContactData icd);
	
	public void recuperer();
	

	/**
	 * @return the nom
	 */
	public String getNom();

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom);

	/**
	 * @return the prenom
	 */
	public String getPrenom();

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom);

	/**
	 * @return the telephone
	 */
	public String getTelephone();

	/**
	 * @param string
	 */
	public void setTelephone(String string);
}
