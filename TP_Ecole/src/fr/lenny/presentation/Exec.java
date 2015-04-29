/**
 * 
 */
package fr.lenny.presentation;

import java.awt.EventQueue;

/**
 * @author ajc
 *
 */
public class Exec {

	static FenetreFactory ffa = null ;
	static IFenetre window = null;

	public static void main(String[] args) {
		ffa = FenetreFactory.getFactory();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = ffa.getInstance("MF");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
