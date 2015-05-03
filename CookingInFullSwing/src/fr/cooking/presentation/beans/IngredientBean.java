package fr.cooking.presentation.beans;

public class IngredientBean implements IBean {

	String nomIngredient;
	static IngredientBean instance = null;


	static public IngredientBean getInstance() {
		if (instance == null) {
			instance = new IngredientBean();
		}
		return instance;
	}


	public String getNomIngredient() {
		return nomIngredient;
	}
	
	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

}
