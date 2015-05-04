/**
 * 
 */
package fr.cooking.metier;

import java.util.ArrayList;

/**
 * @author ajc
 *
 */
public interface IRecette {

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description);

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * @return the NomRecette
	 */
	public String getNomRecette();

	/**
	 * @param NomRecette
	 *            the NomRecette to set
	 */
	public void setNomRecette(String nomRecette);

	/**
	 * @param Recette
	 *            Methode permettant d'enregistrer une recette.
	 */
	public void enregistrer(IRecette recette);

	/**
	 * Methode permettant de récupérer une liste de recette.
	 */
	public ArrayList<IRecette> recupererRecette();
}
