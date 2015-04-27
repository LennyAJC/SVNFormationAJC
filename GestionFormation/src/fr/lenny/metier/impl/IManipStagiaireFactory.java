/**
 * 
 */
package fr.lenny.metier.impl;

import fr.lenny.metier.ManipStagiaire;

/**
 * @author ajc
 *
 */
final public class IManipStagiaireFactory {

	 

	   /**
	    * This is the default factory method.
	    * It is called to create a new Singleton when
	    * a new instance is needed and _factory is null.
	    */
	   public static IManipStagiaireFactory getFactory() {
	      return new IManipStagiaireFactory();
	   }

	   /**
	    * This is the accessor for the Singleton.
	    */
	   public synchronized ManipStagiaire getInstance() {
	      return new ManipStagiaire();
	   }
}  