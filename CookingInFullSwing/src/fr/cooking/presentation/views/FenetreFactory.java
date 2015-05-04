package fr.cooking.presentation.views;

import fr.cooking.presentation.beans.IBean;
import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.impl.FenetreIngredientImpl;
import fr.cooking.presentation.views.impl.FenetreRecetteImpl;
import fr.cooking.presentation.views.impl.MainFenetreImpl;

public class FenetreFactory {

	private static FenetreFactory factory = null;
	private static IFenetre instance = null;

	public static FenetreFactory getFactory() {
		if (factory == null) {
			factory = new FenetreFactory();
		}
		return factory;
	}

	public IFenetre getInstance(String classe, IBean rBean, IBean iBean, ControleurCooking controler) {

		if (classe.equals("FI")) {
			instance = new FenetreIngredientImpl(iBean, controler);
		} else if (classe.equals("FR")) {
			instance = new FenetreRecetteImpl(rBean, iBean, controler);
		} else if (classe.equals("MF")) {
			instance = new MainFenetreImpl(controler);
		}
		return instance;

	}
}