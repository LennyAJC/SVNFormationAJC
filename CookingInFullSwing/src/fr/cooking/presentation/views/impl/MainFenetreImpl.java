package fr.cooking.presentation.views.impl;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.cooking.presentation.beans.IngredientBean;
import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.FenetreFactory;
import fr.cooking.presentation.views.IFenetre;

public class MainFenetreImpl extends JFrame implements IFenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static FenetreFactory ffa = null;
	static IFenetre window = null;

	public MainFenetreImpl() {

	}

	public MainFenetreImpl(ControleurCooking cc, IngredientBean mi) {
		initialize();

	}

	public IFenetre getFenetre() {
		return this;
	}

	public void initialize() {
		setTitle("Cooking In Full Swing");
		getContentPane().setLayout(null);

		JButton btnRecette = new JButton("Gestion Recettes");
		btnRecette.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ffa = FenetreFactory.getFactory();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							window = ffa.getInstance("FR");

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btnRecette.setBounds(42, 66, 129, 23);
		getContentPane().add(btnRecette);

		JButton btnIngredient = new JButton("Gestion Ingredients");
		btnIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ffa = FenetreFactory.getFactory();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							window = ffa.getInstance("FI");

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnIngredient.setBounds(42, 114, 129, 23);
		getContentPane().add(btnIngredient);

		JLabel lblMenuPrincipal = new JLabel("Menu principal");
		lblMenuPrincipal.setBounds(69, 36, 82, 14);
		getContentPane().add(lblMenuPrincipal);

	}
}
