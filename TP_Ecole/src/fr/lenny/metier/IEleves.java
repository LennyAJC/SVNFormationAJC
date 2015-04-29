/**
 * 
 */
package fr.lenny.metier;

/**
 * @author ajc
 *
 */
public interface IEleves {
	

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
	 * @return the note
	 */
	public double getNote();

	/**
	 * @param note the note to set
	 */
	public void setNote(double note);

	
}
