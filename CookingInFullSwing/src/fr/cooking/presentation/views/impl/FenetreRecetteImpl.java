package fr.cooking.presentation.views.impl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.cooking.metier.IIngredient;
import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.FenetreFactory;
import fr.cooking.presentation.views.IFenetre;

public class FenetreRecetteImpl extends JFrame implements IFenetre {

	/**
	 * 
	 */
	FenetreFactory ffa = null;
	IFenetre window = null;
	ControleurCooking cc = null;

	private static final long serialVersionUID = 1L;
	private JTextField txtRecette;
	private JTextField txtDescription;
	JComboBox<IIngredient> cblstIngredients;

	public FenetreRecetteImpl() {
		initialize();
	}

	public IFenetre getFenetre() {
		return this;
	}

	@Override
	public void initialize() {
		setTitle("Gestion des recettes");
		getContentPane().setLayout(null);

		JLabel lblRecette = new JLabel("Recette :");
		lblRecette.setBounds(10, 44, 70, 14);
		getContentPane().add(lblRecette);

		txtRecette = new JTextField();
		txtRecette.setBounds(80, 41, 224, 20);
		getContentPane().add(txtRecette);
		txtRecette.setColumns(10);

		JTextArea lstIngredientRecette = new JTextArea();
		lstIngredientRecette.setBounds(349, 85, 166, 181);
		getContentPane().add(lstIngredientRecette);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(10, 85, 77, 14);
		getContentPane().add(lblDescription);

		txtDescription = new JTextField();
		txtDescription.setBounds(80, 85, 224, 181);
		getContentPane().add(txtDescription);
		txtDescription.setColumns(10);

		JButton btnCreerRecette = new JButton("Cr\u00E9er Recette");
		btnCreerRecette.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cc = ControleurCooking.getInstance();
				cc.gestionRecette();
			}
		});
		btnCreerRecette.setBounds(349, 299, 166, 47);
		getContentPane().add(btnCreerRecette);

		JButton btnAjouterIngredient = new JButton("");
		btnAjouterIngredient.setIcon(new ImageIcon(FenetreRecetteImpl.class
				.getResource("/img/btn-add-ico.png")));
		btnAjouterIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				cc = ControleurCooking.getInstance();
				cc.ajoutIngredientRecette();
			}
		});
		btnAjouterIngredient.setBounds(526, 25, 44, 44);
		getContentPane().add(btnAjouterIngredient);

		JLabel lblCrerUneRecette = new JLabel("Cr\u00E9er une recette :");
		lblCrerUneRecette.setBounds(10, 11, 184, 14);
		getContentPane().add(lblCrerUneRecette);

		JLabel lblListeDesIngrdients = new JLabel(
				"Liste des ingr\u00E9dients :");
		lblListeDesIngrdients.setBounds(349, 11, 158, 14);
		getContentPane().add(lblListeDesIngrdients);

		cblstIngredients = new JComboBox<IIngredient>();
		cblstIngredients.setBounds(350, 41, 166, 20);
		getContentPane().add(cblstIngredients);

		JButton btnDelIngredient = new JButton("");
		btnDelIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cc = ControleurCooking.getInstance();
				cc.delIngredientRecette();
			}
		});
		btnDelIngredient.setIcon(new ImageIcon(FenetreRecetteImpl.class
				.getResource("/img/btn-del-ico.png")));
		btnDelIngredient.setBounds(526, 85, 44, 44);
		getContentPane().add(btnDelIngredient);

	}

	public JComboBox<IIngredient> getCblstIngredients() {
		return cblstIngredients;
	}

	public void setCblstIngredients(JComboBox<IIngredient> cblstIngredients) {
		this.cblstIngredients = cblstIngredients;
	}

	public JTextField getTxtRecette() {
		return txtRecette;
	}

	public void setTxtRecette(JTextField txtRecette) {
		this.txtRecette = txtRecette;
	}

	public JTextField getTxtDescription() {
		return txtDescription;
	}

	public void setTxtDescription(JTextField txtDescription) {
		this.txtDescription = txtDescription;
	}
}
