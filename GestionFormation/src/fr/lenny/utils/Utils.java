/**
 * 
 */
package fr.lenny.utils;

/**
 * @author ajc
 *
 */
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import fr.lenny.metier.impl.IUtils;

/**
 * Classe Utilitaire générale
 * 
 * @author ajc
 *
 */
public class Utils implements IUtils {

	public Scanner sc = new Scanner(System.in);

	/**
	 * Constructeur de la classe Utils
	 */
	public Utils() {

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

	// public SimpleDateFormat lireDate() {
	// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	// String dateStr = sc.next();
	// try {
	// Date date = sdf.parse(dateStr);
	//
	// sdf = new SimpleDateFormat("EEE, d MMM yyyy");
	// sdf.format(date);
	// } catch (ParseException e) {
	// System.out.println("Parse Exception");
	// }
	// return sdf;
	//
	// }

	/**
	 * Permet de créer un document de type DOM
	 */
	public Document createDomDocument() {
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.newDocument();
			return doc;
		} catch (ParserConfigurationException e) {
			System.out.println("Impossible de parser...");
		}
		return null;
	}

}
