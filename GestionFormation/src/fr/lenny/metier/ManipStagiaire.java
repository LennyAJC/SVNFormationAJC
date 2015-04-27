/**
 * 
 */
package fr.lenny.metier;

import java.util.ArrayList;
import java.util.Collections;

import fr.lenny.impl.IManipStagiaire;

/**
 * @author ajc
 *
 */
public class ManipStagiaire implements IManipStagiaire {

	protected ArrayList<Stagiaire> lstStagiaire;
	// static private ManipStagiaire instance = null;

	// private static MyInterface instance = new MySingleton();
	
//	public ManipStagiaire getInstance() {
//		if (null == instance) {
//			instance = new ManipStagiaire();
//		}
//		return instance;
//	}
//	


	public ManipStagiaire() {
		super();
		lstStagiaire = new ArrayList<Stagiaire>();
	}


	/**
	 * 
	 * @param lstStagiaire
	 * @return
	 */
	public ArrayList<Stagiaire> getStagiaire() {
		return lstStagiaire;

	}

	/**
	 * 
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
	 * Methode permettant d'ajouter un stagiaire
	 */
	public void ajouterStagiaire(Stagiaire stag) {

		getStagiaire().add(stag);
	}

	public void trier() {
		Collections.sort(getStagiaire());
	}

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


}
