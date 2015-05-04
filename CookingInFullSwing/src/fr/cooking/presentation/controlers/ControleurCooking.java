package fr.cooking.presentation.controlers;

import java.awt.EventQueue;
import java.util.ArrayList;

import fr.cooking.metier.IIngredient;
import fr.cooking.metier.IRecette;
import fr.cooking.metier.IngredientFactory;
import fr.cooking.metier.RecetteFactory;
import fr.cooking.presentation.beans.IBean;
import fr.cooking.presentation.beans.IngredientBean;
import fr.cooking.presentation.beans.RecetteBean;
import fr.cooking.presentation.views.FenetreFactory;
import fr.cooking.presentation.views.IFenetre;

public class ControleurCooking {

	static FenetreFactory ffa = null;
	static IFenetre window = null;
	private RecetteBean rBean;
	private IngredientBean iBean;

	ArrayList<String> lstIngredient = null;

	private static ControleurCooking instance = null;

	public static ControleurCooking getInstance() {
		if (instance == null) {
			instance = new ControleurCooking();
		}
		return instance;
	}

	/**
	 * Methode permettant de lancer une fenêtre
	 * 
	 * @param fenetre
	 */
	public void launch(String fenetre) {
		System.out.println("Lancement :" + fenetre + "\n");
		ffa = FenetreFactory.getFactory();

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					if (fenetre.equals("FR")) {
						rBean = RecetteBean.getInstance();
						iBean = IngredientBean.getInstance();
						lstIngredient = new ArrayList<String>();
						window = ffa.getInstance(fenetre, rBean, iBean,
								getInstance());

					} else if (fenetre.equals("FI")) {
						rBean = RecetteBean.getInstance();
						iBean = IngredientBean.getInstance();

						window = ffa.getInstance(fenetre, null, iBean,
								getInstance());
					} else if (fenetre.equals("MF")) {
						window = ffa.getInstance(fenetre, null, null,
								getInstance());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Fenetre Ingredient : methode ajouterIngredient
	 */
	public void ajouterIngredient() {

		IngredientFactory igf = IngredientFactory.getFactory();
		IIngredient ii = igf.getInstance();

		ii.setNomIngredient(iBean.getNomIngredient());
		ii.enregistrer(ii);

	}

	/**
	 * Fenetre Ingredient : methode supprimerIngredient
	 */
	public void supprimerIngredient() {

		IngredientFactory igf = IngredientFactory.getFactory();
		IIngredient ii = igf.getInstance();

		ii.setNomIngredient(iBean.getNomIngredient());
		ii.supprimer(ii);

	}

	/*
	 * Création de la recette avec les ingrédients choisis.
	 */
	public void gestionRecette() {
		RecetteFactory rf = RecetteFactory.getFactory();
		IRecette ir = rf.getInstance();

		ir.setNomRecette(rBean.getNomRecette());
		ir.setDescription(rBean.getDescription());

		ir.enregistrer(ir);
	}

	/*
	 * Ajouter l'ingrédient sélection à une liste d'ingrédient avant
	 * d'enregistrer la recette.
	 */
	public void ajoutIngredientRecette(IFenetre fenetre, IBean bean) {

		lstIngredient.add(((IngredientBean) bean).getNomIngredient());

		fenetre.lstIngredientRecetteClear();

		for (String ingredient : lstIngredient) {
			fenetre.setLstIngredientRecette(ingredient);
		}

	}

	/*
	 * Ajouter l'ingrédient sélection à une liste d'ingrédient avant
	 * d'enregistrer la recette.
	 */
	public void delIngredientRecette() {

		int compteur = 0;
		for (String ingredient : lstIngredient) {
			compteur++;
			if (ingredient.equals(iBean.getNomIngredient())) {
				lstIngredient.remove(compteur);
			}
		}

	}
}