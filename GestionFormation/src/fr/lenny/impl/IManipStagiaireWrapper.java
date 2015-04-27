/**
 * 
 */
package fr.lenny.impl;

import fr.lenny.metier.ManipStagiaire;

/**
 * @author ajc
 *
 */
final public class IManipStagiaireWrapper {

	   /**
	    * A reference to a possibly alternate factory.
	    */
	 
	   static private IManipStagiaire _factory = null;

	   /**
	    * A reference to the current instance.
	    */
	   static private ManipStagiaire _instance = null;
	 

	   /**
	    * This is the default factory method.
	    * It is called to create a new Singleton when
	    * a new instance is needed and _factory is null.
	    */
	   static private ManipStagiaire makeInstance() {
	      return new ManipStagiaire();
	   }

	   /**
	    * This is the accessor for the Singleton.
	    */
	   static public synchronized ManipStagiaire instance() {
	      if(null == _instance) {
	         _instance = (null == _factory) ? makeInstance() : _factory.makeInstance();
	      }
	      return _instance;
	   }
	 
	   /**
	    * Sets the factory method used to create new instances.
	    * You can set the factory method to null to use the default method.
	    * @param factory The Singleton factory
	    */
	   static public synchronized void setFactory(IManipStagiaire factory) {
	      _factory = factory;
	   }
	 
	   /**
	    * Sets the current Singleton instance.
	    * You can set this to null to force a new instance to be created the
	    * next time instance() is called.
	    * @param instance The Singleton instance to use.
	    */
	   static public synchronized void setInstance(ManipStagiaire instance) {
	      _instance = instance;
	   }
	   
}
