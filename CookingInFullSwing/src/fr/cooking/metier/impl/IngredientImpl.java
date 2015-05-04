/**
 * 
 */
package fr.cooking.metier.impl;

import java.util.ArrayList;

import fr.cooking.data.IIngredientData;
import fr.cooking.data.IngredientDataFactory;
import fr.cooking.metier.IIngredient;

/**
 * @author ajc
 *
 */
public class IngredientImpl implements IIngredient {

	String nomIngredient;

	public IngredientImpl() {

	}

	public IngredientImpl(String nomIngredient) {
		super();
		this.nomIngredient = nomIngredient;
	}

	/**
	 * @return the nomIngredient
	 */
	public String getNomIngredient() {
		return nomIngredient;
	}

	/**
	 * @param nomIngredient
	 *            the nomIngredient to set
	 */
	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	public void enregistrer(IIngredient ingredient) {
		IngredientDataFactory idf = IngredientDataFactory.getFactory();
		IIngredientData id = idf.getInstance();
		id.setNomIngredient(ingredient.getNomIngredient());
		id.enregistrer(id);
	}

	public ArrayList<IIngredient> recupererIngredient() {
		ArrayList<IIngredient> lstIngredient = new ArrayList<IIngredient>();
		ArrayList<IIngredientData> lstIngredientData = new ArrayList<IIngredientData>();

		IngredientDataFactory iDataF = IngredientDataFactory.getFactory();
		IIngredientData iData = iDataF.getInstance();
		lstIngredientData = iData.recupererIngredient();

		for (IIngredientData ingredientData : lstIngredientData) {
			lstIngredient.add((IIngredient) ingredientData);
		}
		// lstIngredientData = (ArrayList<IIngredientData>) (ArrayList<?>)
		// lstIngredientDao;

		return lstIngredient;
	}

	/* (non-Javadoc)
	 * @see fr.cooking.metier.IIngredient#supprimer(fr.cooking.metier.IIngredient)
	 */
	@Override
	public void supprimer(IIngredient ingredient) {
		// TODO Auto-generated method stub
		
	}

}
