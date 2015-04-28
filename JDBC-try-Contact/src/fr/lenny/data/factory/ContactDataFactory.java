/**
 * 
 */
package fr.lenny.data.factory;

import fr.lenny.data.ContactData;

/**
 * @author ajc
 *
 */
public class ContactDataFactory {

	static private ContactDataFactory factory = null;

	/**
	 * This is the default factory method. It is called to create a new
	 * Singleton when a new instance is needed and factory is null.
	 */
	public static ContactDataFactory getFactory() {
		if (null == factory) {
			factory = new ContactDataFactory();
		}
		return factory;
	}

	/**
	 * This is the accessor for the Singleton.
	 * 
	 */
	public ContactData getInstance() {
		return new ContactData();
	}
}
