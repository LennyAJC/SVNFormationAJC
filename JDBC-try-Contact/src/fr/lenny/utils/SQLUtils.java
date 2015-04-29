/**
 * 
 */
package fr.lenny.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author ajc
 *
 */
public class SQLUtils {

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

	public ResultSet executeSQL(String sql, String type) {
		Utils u = Utils.getInstance();
		Connection connection = u.connexionbdd();

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
