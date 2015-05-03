package fr.cooking.presentation.beans;

public class IngredientBean {

	String nomIngredient;
	static IngredientBean instance = null;

	public String getNomIngredient() {
		return nomIngredient;
	}

	static public IngredientBean getInstance() {
		if (instance == null) {
			instance = new IngredientBean();
		}
		return instance;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

}
