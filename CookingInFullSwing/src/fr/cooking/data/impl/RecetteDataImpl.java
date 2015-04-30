/**
 * 
 */
package fr.cooking.data.impl;

import fr.cooking.data.IRecetteData;
import fr.cooking.data.dao.RecetteDao;

/**
 * @author ajc
 *
 */
public class RecetteDataImpl implements IRecetteData {
	String nomRecette;
	String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	public RecetteDataImpl() {

	}

	
	/**
	 * Constructeur IngredientData
	 * @param nomIngredient
	 */
	public RecetteDataImpl(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	/**
	 * @return the nomIngredient
	 */
	public String getNomRecette() {
		return nomRecette;
	}

	/**
	 * @param nomIngredient
	 *            the nomIngredient to set
	 */
	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}
	

	public void enregistrer(RecetteDataImpl recette) {
		RecetteDao rd = RecetteDao.getInstance();
		rd.insererRecette(recette);
	}
	
	public IRecetteData recupererIngredient() {

		RecetteDao ird = RecetteDao.getInstance();
		return ird.recupererRecette();
	}

}
