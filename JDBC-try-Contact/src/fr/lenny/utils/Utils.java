/**
 * 
 */
package fr.lenny.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author ajc
 *
 */
public class Utils {

	Connection connection = null;
	static private Utils instance = null;

	public Scanner sc = new Scanner(System.in);

	/**
	 * Constructeur de la classe Utils
	 */
	public Utils() {

	}

	/**
	 * Singleton de la classe Utils.
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

	/**
	 * Affiche sur la console
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public void afficher(int reponse) {
		System.out.println(reponse);
	}

	/**
	 * Affiche sur la console
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public void afficher(String reponse) {
		System.out.println(reponse);
	}

	/**
	 * Affiche sur la console et renvoi une chaine saisi par l'utilisateur
	 * 
	 * @param str
	 *            : l'information passée en paramètre
	 * @return lu : chaine saisie par l'utilisateur
	 */
	public String lireString(String str) {
		afficher(str);
		String lu = sc.next();
		return lu;

	}

	/**
	 * Affiche sur la console et renvoi un entier saisi par l'utilisateur
	 * 
	 * @param str
	 *            : l'information passée en paramètre
	 * @return lu : entier saisi par l'utilisateur
	 */
	public int lireInt(String str) {
		afficher(str);
		int lu = sc.nextInt();
		return lu;

	}

}
