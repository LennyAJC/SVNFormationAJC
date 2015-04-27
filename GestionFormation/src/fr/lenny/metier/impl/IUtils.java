/**
 * 
 */
package fr.lenny.metier.impl;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author Behelit
 *
 */
public interface IUtils {

	//public void afficher(int reponse);

	Scanner sc = new Scanner(System.in);

	/**
	 * Affiche l'information pass�e en param�tre.
	 * 
	 * @param reponse
	 *            : l'information pass�e en param�tre
	 */
	public void afficher(double reponse);

	/**
	 * Affiche l'information pass�e en param�tre.
	 * 
	 * @param reponse
	 *            : l'information pass�e en param�tre
	 */
	public void afficher(String reponse);

	/**
	 * @param taille
	 * @return
	 */
	public String lireString(String str);

	/**
	 * @param taille
	 * @return
	 */
	public int lireInt(String str);

	public SimpleDateFormat lireDate();
}
