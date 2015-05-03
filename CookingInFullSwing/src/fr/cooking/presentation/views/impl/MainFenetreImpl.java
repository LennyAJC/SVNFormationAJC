package fr.cooking.presentation.views.impl;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.IFenetre;

public class MainFenetreImpl extends JFrame implements IFenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControleurCooking controler;

	public MainFenetreImpl() {

	}

	public MainFenetreImpl(ControleurCooking cc) {
		this.controler = cc;
		initialize();

	}

	public IFenetre getFenetre() {
		return this;
	}

	public void initialize() {
		setTitle("Cooking In Full Swing");
		getContentPane().setLayout(null);

		JLabel lblMenuPrincipal = new JLabel("Menu principal");
		lblMenuPrincipal.setBounds(69, 36, 82, 14);
		getContentPane().add(lblMenuPrincipal);

		JButton btnRecette = new JButton("Gestion Recettes");
		btnRecette.setBounds(42, 66, 129, 23);
		getContentPane().add(btnRecette);

		btnRecette.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						controler.launch("FR");
					}

				});
			}
		});

		JButton btnIngredient = new JButton("Gestion Ingredients");
		btnIngredient.setBounds(42, 114, 129, 23);
		getContentPane().add(btnIngredient);

		btnIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						controler.launch("FI");
					}
				});
			}
		});

	}
}
