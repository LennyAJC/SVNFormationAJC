package test;

import org.junit.Test;

import fr.cooking.presentation.controlers.ControleurCooking;

public class TestControleurCooking {
	@Test
	// public static ControleurCooking getInstance()
	public void testGetInstance() {
		ControleurCooking e0 = ControleurCooking.getInstance();

	}

	@Test
	// public void gestionIngredient()
	public void testGestionIngredient() {
		ControleurCooking e0Obj = new ControleurCooking();
		e0Obj.gestionIngredient();

	}

	@Test
	// public void delIngredientRecette()
	public void testDelIngredientRecette() {
		ControleurCooking e0Obj = new ControleurCooking();
		e0Obj.delIngredientRecette();

	}

	@Test
	// public void ajoutIngredientRecette()
	public void testAjoutIngredientRecette() {
		ControleurCooking e0Obj = new ControleurCooking();
		e0Obj.ajoutIngredientRecette();

	}

	@Test
	// public void launch(String)
	public void testLaunch() {
		ControleurCooking e0Obj = new ControleurCooking();
		e0Obj.launch("<L!vT;'");

	}

	@Test
	// public void gestionRecette()
	public void testGestionRecette() {
		ControleurCooking e0Obj = new ControleurCooking();
		e0Obj.gestionRecette();

	}

	@Test
	public void testSequence() {
		ControleurCooking e0Obj = new ControleurCooking();
		e0Obj.gestionRecette();

		e0Obj.ajoutIngredientRecette();

		e0Obj.launch("2q6h57x+v8$llMmZ/");

		e0Obj.delIngredientRecette();

		e0Obj.gestionIngredient();

		e0Obj.gestionRecette();

		e0Obj.ajoutIngredientRecette();

		e0Obj.ajoutIngredientRecette();

		ControleurCooking e8 = ControleurCooking.getInstance();

		ControleurCooking e9 = ControleurCooking.getInstance();

	}
}