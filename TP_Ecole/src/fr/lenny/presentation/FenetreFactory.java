package fr.lenny.presentation;

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

		if (classe.equals("FA")) {
			instance = new FenetreAjout();
		} else if (classe.equals("MF")) {
			instance = new MainFenetre();
		}
		return instance;

	}
}
