/**
 * 
 */
package fr.cooking.data;

import fr.cooking.data.impl.RecetteDataImpl;

/**
 * @author ajc
 *
 */
public interface IRecetteData {

	/**
	 * @return the nomIngredient
	 */
	public String getNomRecette();

	/**
	 * @param nomIngredient
	 *            the nomIngredient to set
	 */
	public void setNomRecette(String nomRecette);

	public void enregistrer(RecetteDataImpl recette);
	
	public IRecetteData recupererIngredient();
}
