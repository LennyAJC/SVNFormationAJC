/**
 * 
 */
package fr.lenny.main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import fr.lenny.impl.IManipStagiaire;
import fr.lenny.impl.IManipStagiaireFactory;
import fr.lenny.metier.Formation;
import fr.lenny.metier.Stagiaire;
import fr.lenny.utils.Utils;

/**
 * @author ajc
 *
 */
public class Exec {

	static String nomFormation = "";
	static String dateFormation;
	static ArrayList<Stagiaire> lstStagiaire;
	static int nbSta;
	static Stagiaire stag;

	Formation form;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Saisie d'une formation
		// TODO Saisie des stagiaires
		// TODO lien entre les stagiaires et formation
		// TODO Affichage d'une moyenne d'age
		// TODO Affichage d'une liste ordonnée par age
		// TODO Sauvegarde du modèle ==> fichier .txt (Machin suit la formation
		// toto à telle date)

		Utils.sc = new Scanner(System.in);

		IManipStagiaireFactory mstagf = IManipStagiaireFactory.getFactory();
		IManipStagiaire mstag = mstagf.getInstance();
		
		nomFormation = Utils.lireString("Saisissez une formation");
		dateFormation = Utils
				.lireString("A quelle date aura lieu cette formation ?");

		nbSta = Utils.lireInt("Combien de Stagiaire suivent cette formation?");
		Utils.afficher("\n");

		for (int i = 0; i < nbSta; i++) {

			String nom;
			String prenom;
			int age;

			// Utils.afficher();
			nom = Utils.lireString("Saisissez le nom du stagiaire n°" + i);
			prenom = Utils
					.lireString("Saisissez le prenom du stagiaire n°" + i);
			age = Utils.lireInt("Saisissez l'age du stagiaire n°" + i);

			stag = new Stagiaire(nom, prenom, age);
			mstag.ajouterStagiaire(stag);
		}

		
		Utils.afficher("\n");
		Utils.afficher("Affichage de la liste des stagiaires saisis : ");
		mstag.afficherlst();

		Utils.afficher("\n");
		Utils.afficher("Affichage de la liste des stagiaires triés : ");
		mstag.trier();
		mstag.afficherlst();
		Utils.afficher("\n");
		Utils.afficher("Affichage de la moyenne d'age des stagiaires saisis : ");
		System.out.println(mstag.moyenneAge());

		// recuperation de la liste des stagiaires
		ArrayList<Stagiaire> lstStagiaire = mstag.getStagiaire();

		// Creation de la formation avec ajout des stagiaires
		Formation form = new Formation(nomFormation, dateFormation, nbSta,
				lstStagiaire);
		FileWriter fichier = null;
		try {

			fichier = new FileWriter("file.txt");

			fichier.write("La formation : " + form.getNomFormation()
					+ "aura lieu le : " + form.getNbSta());
			fichier.write("\n");
			fichier.write("\n");
			fichier.write("Liste des Stagiaires : ");
			fichier.write("\n");

			for (Stagiaire Stagiaire : lstStagiaire) {
				fichier.write(" Nom : " + Stagiaire.getNom());
				fichier.write(" Prenom :" + Stagiaire.getPrenom());
				fichier.write(" Age : " + Stagiaire.getAge());
				fichier.write("\n");

			}
			fichier.close();
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Le fichier est introuvable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible d'écrire dans le flux");
		} finally {
			try {
				fichier.close();
			} catch (IOException ex) {
				System.out.println("Impossible de fermer le flux");
			}

		}
	}
}
