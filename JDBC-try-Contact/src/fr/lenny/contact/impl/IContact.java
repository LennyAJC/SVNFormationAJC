/**
 * 
 */
package fr.lenny.contact.impl;

/**
 * @author ajc
 *
 */
public interface IContact {

	public void enregistrer();
	
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
