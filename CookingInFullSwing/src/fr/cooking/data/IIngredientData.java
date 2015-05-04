/**
 * 
 */
package fr.cooking.data;

import java.util.ArrayList;

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

	public ArrayList<IIngredientData> recupererIngredient();

	public void supprimer(IIngredientData ingredient);

}
