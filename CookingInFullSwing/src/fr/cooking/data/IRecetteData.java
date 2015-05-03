/**
 * 
 */
package fr.cooking.data;


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

	public void enregistrer(IRecetteData recette);

	public IRecetteData recupererIngredient();

}
