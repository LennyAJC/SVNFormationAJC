/**
 * 
 */
package fr.lenny.utils;

import java.util.Scanner;

/**
 * @author ajc
 *
 */
public class Utils {

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

	/**
	 * Affiche sur la console et renvoi un entier saisi par l'utilisateur
	 * 
	 * @param str
	 *            : l'information passée en paramètre
	 * @return lu : entier saisi par l'utilisateur
	 */
	public double lireDouble(String str) {
		afficher(str);
		double lu = sc.nextInt();
		return lu;

	}

}
