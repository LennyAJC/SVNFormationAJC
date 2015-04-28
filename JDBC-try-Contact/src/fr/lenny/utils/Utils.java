/**
 * 
 */
package fr.lenny.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ajc
 *
 */
public class Utils {

	Connection connection = null;
	static private Utils instance = null;

	/**
	 * Constructeur de la classe Utils
	 */
	public Utils() {

	}

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static Utils getInstance() {
		if (null == instance) {
			instance = new Utils();
		}
		return instance;
	}

	/**
	 * @return
	 */
	public Connection connexionbdd() {
		// TODO Auto-generated method stub
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/Contact", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}


	
}
