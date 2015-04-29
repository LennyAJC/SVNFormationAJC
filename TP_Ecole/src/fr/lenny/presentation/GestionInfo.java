package fr.lenny.presentation;

import fr.lenny.metier.CM1;
import fr.lenny.metier.Ecole;
import fr.lenny.metier.ElevesFactory;
import fr.lenny.metier.IEleves;
import fr.lenny.utils.Utils;

public class GestionInfo {

	static Ecole ecole = null;
	static ElevesFactory ef = null;
	private static GestionInfo instance = null;

	public GestionInfo() {
		// TODO Auto-generated constructor stub
	}

	public static GestionInfo getInstance() {
		if (instance == null) {
			instance = new GestionInfo();
		}
		return instance;
	}

	public void launchProg(IFenetre window) {

		Utils u = Utils.getInstance();
		ecole = Ecole.getInstance();

		ElevesFactory ef = ElevesFactory.getFactory();

		// String classe = u
		// .lireString("Dans quelle classe souhaitez-vous ajouter des eleves ? CP ou CM1 ");
		String classe = "CP";
		// int nbEleve = u
		// .lireInt("Combien d'eleves souhaitez-vous ajouter a la classe "
		// + classe + " ?");
		//
		// for (int i = 0; i < nbEleve; i++) {
		IEleves e = ef.getInstance(classe);

		e.setNom(window.getTfnomEleve().getText());
		e.setPrenom(window.getTfprenomEleve().getText());
		e.setNote(Double.valueOf(window.getTfnote().getText()));
		if (e instanceof CM1) {
			((CM1) e).setRedoublant(u
					.lireString("L'eleves est-il redoublant ? oui ou non "));
		}
		ecole.ajouterEleves(e);

		u.afficher(String.valueOf(ecole.moyenneEleves()));

		ecole.afficherlst();
	}
}
