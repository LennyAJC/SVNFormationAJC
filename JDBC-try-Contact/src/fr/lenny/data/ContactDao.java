/**
 * 
 */
package fr.lenny.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.lenny.data.impl.IContactData;
import fr.lenny.utils.SQLUtils;

/**
 * @author ajc
 *
 */
public class ContactDao {

	ResultSet rst = null;

	static ContactDao instance = null;

	/**
	 * Constructor de la classe ContactDao
	 */
	public ContactDao() {

	}

	/**
	 * Singleton de la classe ContactDao
	 */
	public static ContactDao getInstance() {
		if (null == instance) {
			instance = new ContactDao();
		}
		return instance;
	}

	/**
	 * Methode permettant d'inserer des contacts dans le SGBD
	 *
	 */
	public void insert(IContactData icd) {
		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "INSERT INTO " + "Contact (Nom,Prenom,Telephone)"
				+ "VALUES('" + icd.getNom() + "','" + icd.getPrenom() + "','"
				+ icd.getTelephone() + "')";
		 sqlu.executeSQL(sql, "INS");

	}

	/**
	 * Methode permettant de lister les contacts contenu dans le SGBD
	 * 
	 */
	public void recuperer() {

		SQLUtils sqlu = SQLUtils.getInstance();

		String sql = "SELECT * FROM Contact";
		rst = sqlu.executeSQL(sql, "SEL");

		try {
			while (rst.next()) {
				System.out.println(rst.getString("nom") + ":"
						+ rst.getString("prenom") + ":"
						+ rst.getString("telephone"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
