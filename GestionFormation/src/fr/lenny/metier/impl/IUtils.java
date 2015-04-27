/**
 * 
 */
package fr.lenny.metier.impl;

import java.util.Scanner;

import org.w3c.dom.Document;

/**
 * @author Behelit
 *
 */
public interface IUtils {

	// public void afficher(int reponse);

	Scanner sc = new Scanner(System.in);

	/**
	 * Affiche sur la console
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public void afficher(String reponse);

	/**
	 * Affiche sur la console
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public String lireString(String str);

	/**
	 * Affiche sur la console et renvoi une chaine saisi par l'utilisateur
	 * 
	 * @param str
	 *            : l'information passée en paramètre
	 * @return lu : chaine saisie par l'utilisateur
	 */
	public int lireInt(String str);

	// public SimpleDateFormat lireDate();

	/**
	 * Affiche sur la console et renvoi un entier saisi par l'utilisateur
	 * 
	 * @param str
	 *            : l'information passée en paramètre
	 * @return lu : entier saisi par l'utilisateur
	 */
	public Document createDomDocument();
}
