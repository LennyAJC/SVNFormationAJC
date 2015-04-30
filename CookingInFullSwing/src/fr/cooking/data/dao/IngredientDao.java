/**
 * 
 */
package fr.cooking.data.dao;

import fr.cooking.data.IIngredientData;

/**
 * @author ajc
 *
 */
public class IngredientDao {
	static private IngredientDao instance = null;

	public IngredientDao() {

	}

	public static IngredientDao getInstance() {
		if (instance == null) {
			instance = new IngredientDao();
		}
		return instance;
	}
	
	public void insererIngredient(IIngredientData ingredient){
		
	}
	
	public IIngredientData recupererIngredient(){
		IIngredientData ingredient = null;
		return ingredient;
	}
}
