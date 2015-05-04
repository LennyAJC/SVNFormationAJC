/**
 * 
 */
package fr.cooking.metier.impl;

import java.util.ArrayList;

import fr.cooking.data.IRecetteData;
import fr.cooking.data.RecetteDataFactory;
import fr.cooking.metier.IRecette;

/**
 * @author ajc
 *
 */
public class RecetteImpl implements IRecette {

	String nomRecette;
	String description;

	public RecetteImpl() {

	}

	/**
	 * Constructeur IngredientData
	 * 
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
	 * Methode permettant d'enregistrer une recette.
	 */
	public void enregistrer(IRecette recette) {
		RecetteDataFactory rdf = RecetteDataFactory.getFactory();
		IRecetteData ird = rdf.getInstance();

		ird.setNomRecette(recette.getNomRecette());
		ird.setDescription(recette.getDescription());
		ird.enregistrer(ird);
	}

	/**
	 * Methode permettant de récupérer une liste de recette.
	 */
	public ArrayList<IRecette> recupererRecette() {
		ArrayList<IRecette> lstRecette = new ArrayList<IRecette>();
		ArrayList<IRecetteData> lstRecetteData = new ArrayList<IRecetteData>();

		RecetteDataFactory rDataF = RecetteDataFactory.getFactory();
		IRecetteData rData = rDataF.getInstance();
		lstRecetteData = rData.recupererRecette();

		for (IRecetteData recetteData : lstRecetteData) {
			lstRecette.add((IRecette) recetteData);
		}
		// lstIngredientData = (ArrayList<IIngredientData>) (ArrayList<?>)
		// lstIngredientDao;

		return lstRecette;
	}

}
