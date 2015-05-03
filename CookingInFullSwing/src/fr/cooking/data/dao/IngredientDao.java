/**
 * 
 */
package fr.cooking.data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.cooking.data.IIngredientData;

/**
 * @author ajc
 *
 */
public class IngredientDao {
	static private IngredientDao instance = null;
	String nomIngredient;
	ResultSet rst = null;

	public String getNomIngredient() {
		return nomIngredient;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	public IngredientDao() {

	}

	public static IngredientDao getInstance() {
		if (instance == null) {
			instance = new IngredientDao();
		}
		return instance;
	}

	public void insererIngredient(IngredientDao ingredient) {

		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "INSERT INTO ingredients (nomIngredient) VALUES ('"
				+ ingredient.getNomIngredient() + "')";
		System.out.println(sql);

		sqlu.executeSQL(sql, "INS");
	}

	public IIngredientData recupererIngredient() {

		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "SELECT * FROM Contact";
		rst = sqlu.executeSQL(sql, "SEL");

		try {
			while (rst.next()) {
				//System.out.println(rst.getnomIngredient("nomIngredient"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
