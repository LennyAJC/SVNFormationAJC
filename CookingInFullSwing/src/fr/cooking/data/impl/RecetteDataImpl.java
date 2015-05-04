/**
 * 
 */
package fr.cooking.data.impl;

import java.util.ArrayList;

import fr.cooking.data.IRecetteData;
import fr.cooking.data.dao.RecetteDao;

/**
 * @author ajc
 *
 */
public class RecetteDataImpl implements IRecetteData {
	String nomRecette;
	String description;

	public RecetteDataImpl() {

	}

	/**
	 * Constructeur IngredientData
	 * 
	 * @param nomIngredient
	 */
	public RecetteDataImpl(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
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

	
	/**
	 * Methode permettant d'enregistrer une recette (nom + description uniquement)
	 */
	public void enregistrer(IRecetteData recette) {
		RecetteDao rd = RecetteDao.getInstance();

		rd.setNomRecette(recette.getNomRecette());
		rd.setDescription(recette.getDescription());
		rd.insererRecette(rd);
	}

	/**
	 * Methode permettant de récupérer la liste des recettes.
	 * @return
	 */
	public ArrayList<IRecetteData> recupererRecette() {
		ArrayList<IRecetteData> lstRecetteData = new ArrayList<IRecetteData>();
		ArrayList<RecetteDao> lstRecetteDao = new ArrayList<RecetteDao>();

		RecetteDao rDao = RecetteDao.getInstance();
		lstRecetteDao = rDao.recupererRecette();

		for (RecetteDao recetteDao : lstRecetteDao) {
			lstRecetteData.add((IRecetteData) recetteDao);
		}

		return lstRecetteData;
	}

}
