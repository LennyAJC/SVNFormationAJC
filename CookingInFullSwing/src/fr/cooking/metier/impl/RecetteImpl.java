/**
 * 
 */
package fr.cooking.metier.impl;

import fr.cooking.data.IRecetteData;
import fr.cooking.data.dao.RecetteDao;
import fr.cooking.data.impl.RecetteDataImpl;
import fr.cooking.metier.IRecette;

/**
 * @author ajc
 *
 */
public class RecetteImpl implements IRecette{
	
	String nomRecette;
	String description;
	
	public RecetteImpl(){
		
	}


	
	/**
	 * Constructeur IngredientData
	 * @param nomIngredient
	 */
	public RecetteImpl(String nomRecette) {
		this.nomRecette = nomRecette;
	}
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
