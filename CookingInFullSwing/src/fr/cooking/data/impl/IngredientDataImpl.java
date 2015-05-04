/**
 * 
 */
package fr.cooking.data.impl;

import java.util.ArrayList;

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
		id.setNomIngredient(this.getNomIngredient());
		id.insererIngredient(id);
	}

	public ArrayList<IIngredientData> recupererIngredient() {
		ArrayList<IIngredientData> lstIngredientData = new ArrayList<IIngredientData>();
		ArrayList<IngredientDao> lstIngredientDao = new ArrayList<IngredientDao>();
		
		IngredientDao iDao = IngredientDao.getInstance();
		lstIngredientDao = iDao.recupererIngredient();
		
		for (IngredientDao ingredientDao : lstIngredientDao) {
			lstIngredientData.add((IIngredientData) ingredientDao);
		}
		//lstIngredientData = (ArrayList<IIngredientData>) (ArrayList<?>) lstIngredientDao;
		
		return lstIngredientData;
	}

	/* (non-Javadoc)
	 * @see fr.cooking.data.IIngredientData#supprimer(fr.cooking.data.IIngredientData)
	 */
	@Override
	public void supprimer(IIngredientData ingredient) {
		IngredientDao id = IngredientDao.getInstance();
		id.setNomIngredient(this.getNomIngredient());
		id.supprimerIngredient(id);
		
	}

}
