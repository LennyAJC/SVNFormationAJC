package fr.cooking.presentation.views;

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

	public IFenetre getInstance(String classe) {

		if (classe.equals("FI")) {
			instance = new FenetreIngredientImpl();
		} else if (classe.equals("FR")) {
			instance = new FenetreRecetteImpl();
		} else if (classe.equals("MF")) {
			instance = new MainFenetreImpl();
		}
		return instance;

	}
}