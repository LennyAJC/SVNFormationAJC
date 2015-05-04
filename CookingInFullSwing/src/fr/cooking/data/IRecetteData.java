/**
 * 
 */
package fr.cooking.data;

import java.util.ArrayList;

/**
 * @author ajc
 *
 */
public interface IRecetteData {

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description);

	/**
	 * @return the nomIngredient
	 */
	public String getNomRecette();

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * @param nomIngredient
	 *            the nomIngredient to set
	 */
	public void setNomRecette(String nomRecette);

	/**
	 * Methode permettant d'enregistrer une recette (nom + description
	 * uniquement)
	 */
	public void enregistrer(IRecetteData recette);

	/**
	 * Methode permettant de récupérer la liste des recettes.
	 * 
	 * @return
	 */
	public ArrayList<IRecetteData> recupererRecette();

}
