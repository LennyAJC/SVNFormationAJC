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
		System.out.println("Lancement :" + fenetre + "\n");
		ffa = FenetreFactory.getFactory();
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					if (fenetre.equals("FR")) {
						rb = RecetteBean.getInstance();
						window = ffa.getInstance(fenetre, rb, getInstance());
					} else if (fenetre.equals("FI")) {
						ib = IngredientBean.getInstance();
						System.out.println(fenetre + "," + ib + ","
								+ getInstance());
						window = ffa.getInstance(fenetre, ib, getInstance());
					} else if (fenetre.equals("MF")) {
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

		ii.setNomIngredient(ib.getNomIngredient());
		ii.enregistrer(ii);

	}

	/*
	 * Création de la recette avec les ingrédients choisis.
	 */
	public void gestionRecette() {
		RecetteFactory rf = RecetteFactory.getFactory();
		IRecette ir = rf.getInstance();

		ir.setNomRecette(rb.getNomRecette());

		ir.enregistrer(ir);
	}

	/*
	 * Ajouter l'ingrédient sélection à une liste d'ingrédient avant
	 * d'enregistrer la recette.
	 */
	public void ajoutIngredientRecette(IFenetre fenetre) {

		lstIngredient.add((IIngredient) ib);
		
		fenetre.lstIngredientRecetteClear();
		
		for (IIngredient iIngredient : lstIngredient) {
			fenetre.setLstIngredientRecette(iIngredient.getNomIngredient());
		}
		
	}

	/*
	 * Ajouter l'ingrédient sélection à une liste d'ingrédient avant
	 * d'enregistrer la recette.
	 */
	public void delIngredientRecette() {

		int compteur = 0;
		for (IIngredient iIngredient : lstIngredient) {
			compteur++;
			if (iIngredient.getNomIngredient().equals(ib.getNomIngredient()));
			lstIngredient.remove(compteur);
		}

	}
}