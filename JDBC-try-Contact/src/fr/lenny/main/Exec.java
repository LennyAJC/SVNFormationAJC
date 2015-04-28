/**
 * 
 */
package fr.lenny.main;

import fr.lenny.contact.factory.ContactFactory;
import fr.lenny.contact.impl.IContact;

/**
 * @author ajc
 *
 */
public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO DL mysqlconnector jar => OK
		// TODO trouver adress du driver à charger avec CLASS.Form(com.)
		// TODO connexion
		// TODO creation statement
		// TODO resultset
		// TODO Creer une table Contact (nom, prenom, telephone)
		// TODO 1 Classe pour insérer des contacts
		// TODO 1 Classe pour recupérer des contacts a afficher dans la console
		// TODO Structurer le code
		// TODO Hibernate

		ContactFactory cf = ContactFactory.getFactory();
		IContact ic = cf.getInstance();

		ic.setNom("Marqueteau");
		ic.setPrenom("Lenny");
		ic.setTelephone("0102030405");

		ic.enregistrer();
		
		ic.setNom("AAA");
		ic.setPrenom("AAAA");
		ic.setTelephone("22222");

		ic.enregistrer();
		
		
		ic.setNom("ZZZZZ");
		ic.setPrenom("ZZZ");
		ic.setTelephone("1111");

		ic.enregistrer();
		
		ic.recuperer();
	}
}
