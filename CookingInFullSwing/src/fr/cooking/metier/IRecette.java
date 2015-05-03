/**
 * 
 */
package fr.cooking.metier;

import fr.cooking.data.IRecetteData;

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
	 *            enregistrer une recette
	 */
	public void enregistrer(IRecette recette);

	/**
	 * Recuperer une recette
	 */
	public IRecetteData recupererIngredient();
}
