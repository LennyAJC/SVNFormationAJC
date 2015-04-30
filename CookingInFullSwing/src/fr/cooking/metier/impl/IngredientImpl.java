/**
 * 
 */
package fr.cooking.metier.impl;

import fr.cooking.metier.IIngredient;

/**
 * @author ajc
 *
 */
public class IngredientImpl implements IIngredient {

	String nomIngredient;
	
	public IngredientImpl(){
		
	}
	
	public IngredientImpl(String nomIngredient){
		super();
		this.nomIngredient=nomIngredient;
	}

	/**
	 * @return the nomIngredient
	 */
	public String getNomIngredient() {
		return nomIngredient;
	}

	/**
	 * @param nomIngredient the nomIngredient to set
	 */
	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}
}
