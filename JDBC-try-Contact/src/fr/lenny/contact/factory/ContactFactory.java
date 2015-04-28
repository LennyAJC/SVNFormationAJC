/**
 * 
 */
package fr.lenny.contact.factory;

import fr.lenny.contact.Contact;

/**
 * @author ajc
 *
 */
public class ContactFactory {

	static private ContactFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static ContactFactory getFactory() {
		if (null == factory) {
			factory = new ContactFactory();
		}
		return factory;
	}

	/**
	 * This is the accessor for the Singleton.
	 * 
	 */
	public Contact getInstance() {
		return new Contact();
	}

}
