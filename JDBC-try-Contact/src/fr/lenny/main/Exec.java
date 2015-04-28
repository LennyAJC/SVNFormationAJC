/**
 * 
 */
package fr.lenny.main;

import java.util.ArrayList;

import fr.lenny.contact.CarnetAdresse;
import fr.lenny.contact.factory.ContactFactory;
import fr.lenny.contact.impl.IContact;
import fr.lenny.utils.Utils;

/**
 * @author ajc
 *
 */
public class Exec {

	static ArrayList<IContact> lstContact;
	static int nbcontact;
	static CarnetAdresse carnet;
	static IContact ic;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Hibernate

		ContactFactory cf = ContactFactory.getFactory();
		 
		carnet = CarnetAdresse.getInstance();

		Utils utils = Utils.getInstance();
		nbcontact = utils.lireInt("Combien de contact souhaitez-vous rentrer?");

		for (int i = 0; i < nbcontact; i++) {
			ic = cf.getInstance();
			ic.setNom(utils.lireString("Nom du contact ?"));
			ic.setPrenom(utils.lireString("Prenom du contact ?"));
			ic.setTelephone(utils.lireString("Numero de telephone ?"));
			carnet.ajouterContact(ic);
		}

		// ic.enregistrer();

		carnet.afficherlst();

		carnet.enregistrerList();
		
		//ic.recuperer();
	}
}
