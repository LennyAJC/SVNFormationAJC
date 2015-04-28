package fr.lenny.metier;

import java.util.ArrayList;

import fr.lenny.metier.impl.IFormation;
import fr.lenny.metier.impl.IGestionFormation;

public class GestionFormation implements IGestionFormation {

	protected ArrayList<Formation> lstFormation;

	/**
	 * Constructor de la Classe GestionFormation
	 */
	public GestionFormation() {
		super();
		lstFormation = new ArrayList<Formation>();
	}

	/**
	 * Method qui retourne une liste de Formation
	 * 
	 * @return lstStagiaire : une liste de formations
	 */
	public ArrayList<Formation> getFormation() {
		return lstFormation;
	}

	/**
	 * Method qui permet d'afficher la liste des formations (nom, date, nbstag)
	 */
	public void afficherlst() {
		for (Formation formation : getFormation()) {
			StringBuffer st = new StringBuffer();
			st.append(" Nom : ");
			st.append(formation.getNomFormation());
			st.append(" Prenom :");
			st.append(formation.getDateFormation());
			st.append(" ");
			System.out.println(st);

		}

	}
	
	/**
	 * Method permettant de trier la liste des stagiaires (ordre croissant de
	 * l'age) cf. compareTo de Stagiaire
	 */
//	public void trier() {
//		Collections.sort(getStagiaire());
//	}

	public void ajouterFormation(IFormation iform) {
		getFormation().add((Formation) iform);
	}


}
