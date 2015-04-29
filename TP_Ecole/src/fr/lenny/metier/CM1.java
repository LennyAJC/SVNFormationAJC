/**
 * 
 */
package fr.lenny.metier;

/**
 * @author ajc
 *
 */
public class CM1 extends Eleves implements IEleves {

	String nom;
	String prenom;
	double note;
	String redoublant;

	public CM1() {
		super();
	}

	public CM1(String nom, String prenom, double note, String redoublant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.note = note;
		this.redoublant = redoublant;
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

	/**
	 * @return the redoublant
	 */
	public String getRedoublant() {
		return redoublant;
	}

	/**
	 * @param redoublant the redoublant to set
	 */
	public void setRedoublant(String redoublant) {
		this.redoublant = redoublant;
	}

//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see fr.lenny.metier.Eleves#elevesFactory()
//	 */
//	protected IEleves elevesFactory() {
//		// TODO Auto-generated method stub
//		return new CM1();
//	}


}
