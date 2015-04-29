/**
 * 
 */
package fr.lenny.donnees.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ajc
 *
 */
public class SQLUtils {

	Connection connection = null;

	private static SQLUtils instance = null;

	/**
	 * Construteur de la classe SQLUtils
	 */
	public SQLUtils() {

	}

	/**
	 * Singleton de la classe SQLUtils
	 * 
	 * @return
	 */
	public static SQLUtils getInstance() {
		if (instance == null) {
			instance = new SQLUtils();
		}
		return instance;
	}

	/**
	 * Methode de connexion au SGBD
	 * @return
	 */
	public Connection connexionbdd() {
		// TODO Auto-generated method stub
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver introuvable.");
		}

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/Contact", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Base de données introuvable ! ");
		}
		return connection;
	}
}
