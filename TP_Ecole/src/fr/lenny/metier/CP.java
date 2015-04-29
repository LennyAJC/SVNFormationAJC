/**
 * 
 */
package fr.lenny.metier;

/**
 * @author ajc
 *
 */
public class CP extends Eleves implements IEleves {

	String nom;
	String prenom;
	double note;

	public CP() {
		super();
	}

	public CP(String nom, String prenom, double note) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
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
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the note
	 */
	public double getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(double note) {
		this.note = note;
	}

	

}
