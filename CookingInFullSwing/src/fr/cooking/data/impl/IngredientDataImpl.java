/**
 * 
 */
package fr.cooking.data.impl;

import fr.cooking.data.IIngredientData;
import fr.cooking.data.dao.IngredientDao;

/**
 * @author ajc
 *
 */
public class IngredientDataImpl implements IIngredientData {

	String nomIngredient;

	public IngredientDataImpl() {

	}

	/**
	 * Constructeur IngredientData
	 * 
	 * @param nomIngredient
	 */
	public IngredientDataImpl(String nomIngredient) {
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

	public void enregistrer(IIngredientData ingredient) {
		IngredientDao id = IngredientDao.getInstance();
		id.insererIngredient(ingredient);
	}

	public IIngredientData recupererIngredient() {

		IngredientDao id = IngredientDao.getInstance();
		return id.recupererIngredient();
	}

}
