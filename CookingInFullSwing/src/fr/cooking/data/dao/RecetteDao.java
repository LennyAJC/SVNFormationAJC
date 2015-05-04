/**
 * 
 */
package fr.cooking.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author ajc
 *
 */
public class RecetteDao {

	static private RecetteDao instance = null;
	ResultSet rst = null;

	String nomRecette;
	String description;

	public RecetteDao() {

	}

	/**
	 * Singleton de la classe RecetteDao
	 * 
	 * @return
	 */
	public static RecetteDao getInstance() {
		if (instance == null) {
			instance = new RecetteDao();
		}
		return instance;
	}

	/**
	 * @return the nomRecette
	 */
	public String getNomRecette() {
		return nomRecette;
	}

	/**
	 * @param nomRecette
	 *            the nomRecette to set
	 */
	public void setNomRecette(String nomRecette) {
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
	 * Methode permettant d'enregistrer une recette (nom + description uniquement)
	 */
	public void insererRecette(RecetteDao recette) {

		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "INSERT INTO recettes (nomRecette, description) VALUES ('"
				+ recette.getNomRecette() + "','" + recette.getDescription()
				+ "')";
		System.out.println(sql);

		rst = sqlu.executeSQL(sql, "UPD");
	}

//	/**
//	 * 
//	 * @return
//	 */
//	public ArrayList<...> recuperer...() {
//		SQLUtils sqlu = SQLUtils.getInstance();
//
//		String sql = "SELECT * FROM ...";
//		rst = sqlu.executeSQL(sql, "SEL");
//
//		try {
//			while (rst.next()) {
//				// System.out.println(rst.getnomIngredient("nomIngredient"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * Methode permettant de récupérer la liste des recettes.
	 * @return
	 */
	public ArrayList<RecetteDao> recupererRecette() {

		SQLUtils sqlu = SQLUtils.getInstance();
		ArrayList<RecetteDao> lstIngredient = new ArrayList<RecetteDao>();
		String sql = "SELECT nomRecette, Description FROM recettes";
		rst = sqlu.executeSQL(sql, "SEL");

		try {
			while (rst.next()) {
				this.setNomRecette("nomRecette");
				this.setDescription("descrition");
				lstIngredient.add(this);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstIngredient;

	}
}
