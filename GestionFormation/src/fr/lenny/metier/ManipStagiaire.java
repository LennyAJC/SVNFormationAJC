/**
 * 
 */
package fr.lenny.metier;

import java.util.ArrayList;
import java.util.Collections;

import fr.lenny.metier.impl.IManipStagiaire;
import fr.lenny.metier.impl.IStagiaire;

/**
 * Classe permettant de manipuler les listes de stagiaires
 * 
 * @author ajc
 *
 */
public class ManipStagiaire implements IManipStagiaire {

	protected ArrayList<Stagiaire> lstStagiaire;

	// static private ManipStagiaire instance = null;

	// public ManipStagiaire getInstance() {
	// if (null == instance) {
	// instance = new ManipStagiaire();
	// }
	// return instance;
	// }

	/**
	 * Constructor de la Classe ManipStagiaire
	 */
	public ManipStagiaire() {
		super();
		lstStagiaire = new ArrayList<Stagiaire>();
	}

	/**
	 * Method qui retourne une liste de Stagiaire
	 * 
	 * @return lstStagiaire : une liste de stagiaires
	 */
	public ArrayList<Stagiaire> getStagiaire() {
		return lstStagiaire;

	}

	/**
	 * Method qui permet d'afficher la liste des stagiaires (nom, prenom, age)
	 */
	public void afficherlst() {
		for (Stagiaire Stagiaire : getStagiaire()) {
			StringBuffer st = new StringBuffer();
			st.append(" Nom : ");
			st.append(Stagiaire.getNom());
			st.append(" Prenom :");
			st.append(Stagiaire.getPrenom());
			st.append(" Age : ");
			st.append(Stagiaire.getAge());
			st.append(" ");
			System.out.println(st);

		}

	}

	/**
	 * Method permettant d'ajouter un stagiaire à la liste des stagiaires
	 */
//	public void ajouterStagiaire(Stagiaire stag) {
//
//		getStagiaire().add(stag);
//	}

	/**
	 * Method permettant de trier la liste des stagiaires (ordre croissant de
	 * l'age) cf. compareTo de Stagiaire
	 */
	public void trier() {
		Collections.sort(getStagiaire());
	}

	/**
	 * Method permettant de faire la moyenne des ages des stagiaires
	 * 
	 * @return moyenne : la moyenne des ages des stagiaires
	 */
	public int moyenneAge() {
		int agetot = 0;
		int compteur = 0;

		int moyenne;

		for (Stagiaire stagiaire : lstStagiaire) {
			agetot = agetot + stagiaire.getAge();
			compteur++;
		}
		moyenne = agetot / compteur;
		return moyenne;
	}

	/**
	 * Method permettant d'ajouter un stagiaire à la liste des stagiaires
	 */
	public void ajouterStagiaire(IStagiaire istag) {
		getStagiaire().add((Stagiaire) istag);
	}

}
