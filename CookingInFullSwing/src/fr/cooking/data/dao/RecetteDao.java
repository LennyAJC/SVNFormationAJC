/**
 * 
 */
package fr.cooking.data.dao;

import fr.cooking.data.IRecetteData;

/**
 * @author ajc
 *
 */
public class RecetteDao {

	static private RecetteDao instance = null;

	public RecetteDao() {

	}

	public static RecetteDao getInstance() {
		if (instance == null) {
			instance = new RecetteDao();
		}
		return instance;
	}

	public void insererRecette(IRecetteData recette) {

	}

	public IRecetteData recupererRecette() {
		IRecetteData recette = null;
		return recette;
	}
}
