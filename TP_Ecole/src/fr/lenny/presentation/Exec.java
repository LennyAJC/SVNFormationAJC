/**
 * 
 */
package fr.lenny.presentation;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import fr.lenny.metier.CM1;
import fr.lenny.metier.Ecole;
import fr.lenny.metier.ElevesFactory;
import fr.lenny.metier.IEleves;
import fr.lenny.utils.Utils;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * @author ajc
 *
 */
public class Exec {

	static String nomEleve;
	static String prenomEleve;
	static double note;
	static String redoublant;

	static Ecole ecole = null;
	static ElevesFactory ef = null;


	// static IEleves eleves = null;
	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	//
	// launchProg();
	//
	// }

	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 */
	public Exec() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */


	/**
	 * 
	 */
	private static void launchProg() {

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

		e.setNom(tfnomEleve.getText());
		e.setPrenom(tfprenomEleve.getText());
		e.setNote(Double.valueOf(tfnote.getText()));
		if (e instanceof CM1) {
			((CM1) e).setRedoublant(u
					.lireString("L'eleves est-il redoublant ? oui ou non "));
		}
		ecole.ajouterEleves(e);

		// }

		u.afficher(String.valueOf(ecole.moyenneEleves()));

		ecole.afficherlst();
	}
}
