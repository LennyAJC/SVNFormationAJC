/**
 * 
 */
package fr.lenny.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author ajc
 *
 */
import java.util.Scanner;

/**
 * @author ajc
 *
 */
public class Utils {

	public static Scanner sc;

	/**
	 * Affiche l'information passée en paramètre.
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public static void afficher(int reponse) {
		System.out.println(reponse);
	}
	/**
	 * Affiche l'information passée en paramètre.
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public static void afficher(double reponse) {
		System.out.println(reponse);
	}
	/**
	 * Affiche l'information passée en paramètre.
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public static void afficher(String reponse) {
		System.out.println(reponse);
	}
	
	/**
	 * @param taille
	 * @return 
	 */
	public static String lireString(String str) {
		Utils.afficher(str);
		String lu = sc.next();
		return lu;
		
	}

	/**
	 * @param taille
	 * @return 
	 */
	public static int lireInt(String str) {
		Utils.afficher(str);
		int lu = sc.nextInt();
		return lu;
		
	}
	
	public static SimpleDateFormat lireDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = sc.next();
		try {
	         Date date = sdf.parse(dateStr); 
	 
	         sdf = new SimpleDateFormat("EEE, d MMM yyyy");
	         sdf.format(date);
	      } catch (ParseException e) { 
	         System.out.println("Parse Exception");
	      }
		return sdf;
		
	}
	
	
	/**
	 * 
	 */

}
