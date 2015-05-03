/**
 * 
 */
package fr.cooking.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author ajc
 *
 */
public class SQLUtils {

	Connection connection = null;

	Statement stmt = null;
	ResultSet rst = null;
	static private SQLUtils instance = null;

	public Scanner sc = new Scanner(System.in);

	/**
	 * Constructeur de la classe Utils
	 */
	public SQLUtils() {

	}

	/**
	 * Singleton de la classe Utils.
	 */
	public static SQLUtils getInstance() {
		if (null == instance) {
			instance = new SQLUtils();
		}
		return instance;
	}

	/**
	 * @return
	 */
	private Connection connexionbdd() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver introuvable.");
		}

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/CookingInFullSwing", "root", "");
		} catch (SQLException e) {
			System.out.println("Base de données introuvable ! ");
		}
		return connection;
	}

	/**
	 * 
	 * @param sql
	 * @param type
	 * @return
	 */
	public ResultSet executeSQL(String sql, String type) {

		connection = connexionbdd();

		try {
			stmt = connection.createStatement();
			if (type.equals("INS")) {
				stmt.executeUpdate(sql);
				System.out.println("insertion ok!");
			} else if (type.equals("SEL")) {
				rst = stmt.executeQuery(sql);
			}
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La requete est incorrecte" + sql);
			   System.out.println("Exception SQL : ");
			   while (e != null) {
			      String message = e.getMessage();
			      String sqlState = e.getSQLState();
			      int errorCode = e.getErrorCode();
			      System.out.println("Message = "+message);
			      System.out.println("SQLState = "+sqlState);
			      System.out.println("ErrorCode = "+errorCode);
			      e.printStackTrace();
			      e = e.getNextException();
			   }
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de fermer la connection");
		}
		return rst;
	}
}
