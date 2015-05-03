/**
 * 
 */
package fr.cooking.metier.impl;

import fr.cooking.data.IIngredientData;
import fr.cooking.data.IngredientDataFactory;
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
	
	public void enregistrer(IIngredient ingredient){
		IngredientDataFactory idf = IngredientDataFactory.getFactory();
		IIngredientData id = idf.getInstance();
		id.setNomIngredient(ingredient.getNomIngredient());
		id.enregistrer(id);
	}
}
