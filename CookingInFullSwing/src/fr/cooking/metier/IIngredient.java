/**
 * 
 */
package fr.cooking.metier;

import java.util.ArrayList;


/**
 * @author ajc
 *
 */
public interface IIngredient {


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
	 * Methode permettant d'enregistrer un ingredient
	 * @param ingredient
	 */
	public void enregistrer(IIngredient ingredient);
	
	/**
	 * Methode permettant de retourner une liste d'ingrédient.
	 * @return
	 */
	public ArrayList<IIngredient> recupererIngredient();
	
	/**
	 * Methode permettant de supprimer un ingredient. 
	 */
	public void supprimer(IIngredient ingredient);

}
