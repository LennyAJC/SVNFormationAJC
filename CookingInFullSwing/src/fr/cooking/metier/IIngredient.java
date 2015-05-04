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
	
	public void enregistrer(IIngredient ingredient);
	
	public ArrayList<IIngredient> recupererIngredient();
	
	public void supprimer(IIngredient ingredient);

}
