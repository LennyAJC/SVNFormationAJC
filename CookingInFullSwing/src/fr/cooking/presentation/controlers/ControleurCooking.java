package fr.cooking.presentation.controlers;

import java.awt.EventQueue;
import java.util.ArrayList;

import fr.cooking.metier.IIngredient;
import fr.cooking.metier.IRecette;
import fr.cooking.metier.IngredientFactory;
import fr.cooking.metier.RecetteFactory;
import fr.cooking.presentation.beans.IngredientBean;
import fr.cooking.presentation.beans.RecetteBean;
import fr.cooking.presentation.views.FenetreFactory;
import fr.cooking.presentation.views.IFenetre;

public class ControleurCooking {

	static FenetreFactory ffa = null;
	static IFenetre window = null;
	private RecetteBean rb;
	private IngredientBean ib;

	ArrayList<IIngredient> lstIngredient = null;

	private static ControleurCooking instance = null;

	public static ControleurCooking getInstance() {
		if (instance == null) {
			instance = new ControleurCooking();
		}
		return instance;
	}

	public void launch(String fenetre) {

		ffa = FenetreFactory.getFactory();
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					if (fenetre.equals("FR")) {
						rb = RecetteBean.getInstance();
						window = ffa.getInstance(fenetre, rb, getInstance());
					}
					else if(fenetre.equals("FI")){
						ib = IngredientBean.getInstance();
						window = ffa.getInstance(fenetre, ib, getInstance());
					}
					else{
						window = ffa.getInstance(fenetre, null, getInstance());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void gestionIngredient() {
		IngredientFactory igf = IngredientFactory.getFactory();
		IIngredient ii = igf.getInstance();

		ii.setNomIngredient("Sel");
		ii.enregistrer(ii);

	}

	/*
	 * Création de la recette avec les ingrédients choisis.
	 */
	public void gestionRecette() {
		RecetteFactory rf = RecetteFactory.getFactory();
		IRecette ir = rf.getInstance();

		ir.setNomRecette("Gateau au sel");
		ir.setDescription("Gateau au sel");
		ir.enregistrer(ir);

	}

	/*
	 * Ajouter l'ingrédient sélection à une liste d'ingrédient avant
	 * d'enregistrer la recette.
	 */
	public void ajoutIngredientRecette() {
		IngredientBean ingredient = IngredientBean.getInstance();

		IngredientFactory igf = IngredientFactory.getFactory();
		IIngredient ii = igf.getInstance();

		ii.setNomIngredient(ingredient.getNomIngredient());
		lstIngredient.add(ii);
	}

	/*
	 * Ajouter l'ingrédient sélection à une liste d'ingrédient avant
	 * d'enregistrer la recette.
	 */
	public void delIngredientRecette() {
		RecetteFactory rf = RecetteFactory.getFactory();
		IRecette ir = rf.getInstance();

		ir.setNomRecette("Gateau au sel");
		ir.setDescription("Gateau au sel");
		ir.enregistrer(ir);

	}
}