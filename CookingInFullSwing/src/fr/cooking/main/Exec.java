/**
 * 
 */
package fr.cooking.main;

import fr.cooking.presentation.controlers.ControleurCooking;

/**
 * @author ajc
 *
 */
public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ControleurCooking cc = ControleurCooking.getInstance();
		
		cc.launch("MF");
	}

}