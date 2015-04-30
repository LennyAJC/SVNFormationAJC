/**
 * 
 */
package fr.cooking.data;

/**
 * @author ajc
 *
 */
public interface IIngredientData {

	/**
	 * @return the nomIngredient
	 */
	public String getNomIngredient();

	/**
	 * @param nomIngredient
	 *            the nomIngredient to set
	 */
	public void setNomIngredient(String nomIngredient);

	public void enregistrer(IIngredientData ingredient);
	
	public IIngredientData recupererIngredient();
}
