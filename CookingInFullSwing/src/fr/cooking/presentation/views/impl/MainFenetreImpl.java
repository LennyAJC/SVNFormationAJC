package fr.cooking.presentation.views.impl;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.IFenetre;

public class MainFenetreImpl extends JFrame implements IFenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControleurCooking controler;

	JFrame mainfenetre;

	public MainFenetreImpl() {
		initialize();
	}

	public MainFenetreImpl(ControleurCooking cc) {
		this.controler = cc;
		System.out.println("Passage Constructeur");
		initialize();

	}

	public IFenetre getFenetre() {
		return this;
	}

	public void initialize() {

		mainfenetre = new JFrame();
		mainfenetre.setBounds(100, 100, 282, 221);
		mainfenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cooking In Full Swing");
		mainfenetre.getContentPane().setLayout(null);
		this.mainfenetre.setVisible(true);

		JLabel lblMenuPrincipal = new JLabel("Menu principal");
		lblMenuPrincipal.setBounds(89, 35, 82, 14);
		mainfenetre.getContentPane().add(lblMenuPrincipal);

		JButton btnRecette = new JButton("Gestion Recettes");
		btnRecette.setBounds(42, 66, 162, 23);
		mainfenetre.getContentPane().add(btnRecette);

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
		btnIngredient.setBounds(42, 114, 173, 23);
		mainfenetre.getContentPane().add(btnIngredient);

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

	@Override
	public JTextField getTextField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTextField(JTextField textField) {
		// TODO Auto-generated method stub

	}

	@Override
	public JComboBox getCblstIngredients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCblstIngredients(JComboBox cblstIngredients) {
		// TODO Auto-generated method stub

	}

	@Override
	public JTextField getTxtRecette() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTxtRecette(JTextField txtRecette) {
		// TODO Auto-generated method stub

	}

	@Override
	public JTextField getTxtDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTxtDescription(JTextField txtDescription) {
		// TODO Auto-generated method stub

	}

	@Override
	public JTextField getTquantite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTquantite(JTextField tquantite) {
		// TODO Auto-generated method stub

	}

	@Override
	public JTextField gettIngredient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void settIngredient(JTextField tIngredient) {
		// TODO Auto-generated method stub

	}

	@Override
	public JTextArea getLstIngredientRecette() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLstIngredientRecette(String nomIngredient) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lstIngredientRecetteClear() {
		// TODO Auto-generated method stub

	}
}
