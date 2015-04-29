/**
 * 
 */
package fr.lenny.metier;

import java.util.ArrayList;

/**
 * @author ajc
 *
 */
public class Ecole {

	private static Ecole instance = null;
	ArrayList<IEleves> lstEleves = null;

	/**
	 * Constructeur de la classe Utils
	 */
	public Ecole() {
		super();
		lstEleves = new ArrayList<IEleves>();
	}

	/**
	 * Singleton de la classe Ecole
	 * 
	 * @return
	 */
	public static Ecole getInstance() {
		if (instance == null) {
			instance = new Ecole();
		}
		return instance;
	}

	public ArrayList<IEleves> getEleves() {
		return lstEleves;
	}

	public void ajouterEleves(IEleves Eleve) {
		getEleves().add(Eleve);
	}

	/**
	 * Methode permettant d'afficher la liste des IContact
	 */
	public void afficherlst() {
		for (IEleves ieleves : getEleves()) {
			StringBuffer st = new StringBuffer();
			st.append(" Nom : ");
			st.append(ieleves.getNom());
			st.append(" Prenom :");
			st.append(ieleves.getPrenom());
			st.append(" Telephone : ");
			st.append(ieleves.getNote());
			st.append(" ");
			if (ieleves instanceof CM1) {

				st.append(((CM1) ieleves).getRedoublant());
			}
			st.append(" ");
			System.out.println(st);

		}

	}

	public double moyenneEleves() {
		double cumulNote = 0;
		double moyenne = 0;
		double compteur = 0;
		
		for (IEleves ieleves : getEleves()) {
			cumulNote = cumulNote + ieleves.getNote();
			compteur++;
		}
		moyenne = cumulNote/compteur;
		
		return moyenne;
	}

	public String meilleurEleve() {
		String meilleurEleve = "";
		return meilleurEleve;
	}
}
