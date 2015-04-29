/**
 * 
 */
package fr.lenny.contact;

import java.util.ArrayList;
import java.util.Collections;

import fr.lenny.contact.impl.ICarnetAdresse;
import fr.lenny.contact.impl.IContact;
import fr.lenny.data.factory.ContactDataFactory;
import fr.lenny.data.impl.IContactData;

/**
 * @author ajc
 *
 */
public class CarnetAdresse implements ICarnetAdresse {

	protected ArrayList<IContact> lstContact = null;

	ContactDataFactory cdf = null;
	IContactData icd = null;

	static private CarnetAdresse instance = null;

	/**
	 * Constructeur de la classe Utils
	 */
	public CarnetAdresse() {
		super();
		lstContact = new ArrayList<IContact>();
	}

	/**
	 * 
	 * @param lstStagiaire
	 * @return
	 */
	public ArrayList<IContact> getContact() {
		return lstContact;

	}

	/**
	 * Singleton CarnetAdresse.
	 */
	public static CarnetAdresse getInstance() {
		if (null == instance) {
			instance = new CarnetAdresse();
		}
		return instance;
	}

	/**
	 * Methode permettant d'afficher la liste des IContact
	 */
	public void afficherlst() {
		for (IContact icontact : lstContact) {
			StringBuffer st = new StringBuffer();
			st.append(" Nom : ");
			st.append(icontact.getNom());
			st.append(" Prenom :");
			st.append(icontact.getPrenom());
			st.append(" Telephone : ");
			st.append(icontact.getTelephone());
			st.append(" ");
			System.out.println(st);

		}

	}

	public void trier(ArrayList<IContact> contact) {
		Collections.sort(contact, IContact.NomContactComparator);
	}

	/**
	 * Methode permettant d'ajouter un IContact
	 */
	public void ajouterContact(IContact contact) {
		// TODO Auto-generated method stub
		getContact().add(contact);
	}


	/**
	 * Methode permettant d'enregistrer une liste de contacts
	 */
	public void enregistrerList() {
		cdf = ContactDataFactory.getFactory();
		icd = cdf.getInstance();

		for (IContact iContact : lstContact) {
			icd.setNom(iContact.getNom());
			icd.setPrenom(iContact.getPrenom());
			icd.setTelephone(iContact.getTelephone());

			icd.enregistrer(icd);
		}

	}
}
