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
public class IngredientDao {
	static private IngredientDao instance = null;
	String nomIngredient;
	ResultSet rst = null;

	public IngredientDao() {

	}

	public static IngredientDao getInstance() {
		if (instance == null) {
			instance = new IngredientDao();
		}
		return instance;
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

	/**
	 * Methode permettant d'enregistrer un ingrédient.
	 * 
	 * @param ingredient
	 */
	public void insererIngredient(IngredientDao ingredient) {

		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "INSERT INTO ingredients (nomIngredient) VALUES ('"
				+ ingredient.getNomIngredient() + "')";
		System.out.println(sql);

		sqlu.executeSQL(sql, "UPD");
	}

	/**
	 * Methode de recupérer une liste d'ingrédient.
	 * 
	 * @return
	 */
	public ArrayList<IngredientDao> recupererIngredient() {

		SQLUtils sqlu = SQLUtils.getInstance();
		ArrayList<IngredientDao> lstIngredient = new ArrayList<IngredientDao>();
		String sql = "SELECT nomingredient FROM ingredients";
		rst = sqlu.executeSQL(sql, "SEL");

		try {
			while (rst.next()) {
				IngredientDao idao = new IngredientDao();
				idao.setNomIngredient(rst.getString("nomIngredient"));
				lstIngredient.add(idao);
			}
		} catch (SQLException e) {
			System.out.println("La requete est incorrecte" + sql);
			System.out.println("Exception SQL : ");
			while (e != null) {
				String message = e.getMessage();
				String sqlState = e.getSQLState();
				int errorCode = e.getErrorCode();
				System.out.println("Message = " + message);
				System.out.println("SQLState = " + sqlState);
				System.out.println("ErrorCode = " + errorCode);
				e.printStackTrace();
				e = e.getNextException();
			}
		}

		return lstIngredient;

	}

	/**
	 * Methode permettant de supprimer un ingredient.
	 * 
	 * @param id
	 */
	public void supprimerIngredient(IngredientDao ingredient) {
		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "DELETE FROM ingredients WHERE nomIngredient ='"
				+ ingredient.getNomIngredient() + "'";
		System.out.println(sql);

		sqlu.executeSQL(sql, "UPD");
	}

}
