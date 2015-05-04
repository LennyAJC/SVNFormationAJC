/**
 * 
 */
package fr.cooking.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.cooking.data.IRecetteData;

/**
 * @author ajc
 *
 */
public class RecetteDao {

	static private RecetteDao instance = null;
	ResultSet rst = null;

	public RecetteDao() {

	}

	public static RecetteDao getInstance() {
		if (instance == null) {
			instance = new RecetteDao();
		}
		return instance;
	}

	public void insererRecette(IRecetteData recette) {

		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "INSERT INTO recettes (nomRecette, description) VALUES ('"
				+ recette.getNomRecette() + "','" + recette.getDescription()
				+ "')";
		System.out.println(sql);

		rst = sqlu.executeSQL(sql, "UPD");
	}

	public IRecetteData recupererRecette() {
		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "SELECT * FROM Contact";
		rst = sqlu.executeSQL(sql, "SEL");

		try {
			while (rst.next()) {
				// System.out.println(rst.getnomIngredient("nomIngredient"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
