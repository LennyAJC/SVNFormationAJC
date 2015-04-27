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

import fr.lenny.metier.impl.IUtils;

/**
 * @author ajc
 *
 */
public class Utils implements IUtils {

	public Scanner sc = new Scanner(System.in);

	public Utils() {

	}

	/**
	 * Affiche l'information passée en paramètre.
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public void afficher(int reponse) {
		System.out.println(reponse);
	}

	/**
	 * Affiche l'information passée en paramètre.
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public void afficher(double reponse) {
		System.out.println(reponse);
	}

	/**
	 * Affiche l'information passée en paramètre.
	 * 
	 * @param reponse
	 *            : l'information passée en paramètre
	 */
	public void afficher(String reponse) {
		System.out.println(reponse);
	}

	/**
	 * @param taille
	 * @return
	 */
	public String lireString(String str) {
		afficher(str);
		String lu = sc.next();
		return lu;

	}

	/**
	 * @param taille
	 * @return
	 */
	public int lireInt(String str) {
		afficher(str);
		int lu = sc.nextInt();
		return lu;

	}

	public SimpleDateFormat lireDate() {
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

}
