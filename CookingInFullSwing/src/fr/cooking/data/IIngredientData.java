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

	/**
	 * Methode d'enregistrer un ingredient
	 * 
	 * @param ingredient
	 */
	public void enregistrer(IIngredientData ingredient);

	/**
	 * Methode permettant de récupérer une liste d'ingrédient.
	 * 
	 * @return
	 */
	public ArrayList<IIngredientData> recupererIngredient();

	/**
	 * Methode permettant de supprimer un ingredient.
	 * 
	 * @param ingredient
	 */
	public void supprimer(IIngredientData ingredient);

}
