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
import fr.cooking.presentation.beans.IBean;
import fr.cooking.presentation.beans.RecetteBean;
import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.IFenetre;

public class FenetreRecetteImpl extends JFrame implements IFenetre {

	/**
	 * 
	 */
	ControleurCooking controler;
	RecetteBean bean;

	private static final long serialVersionUID = 1L;
	private JTextField txtRecette;
	private JTextField txtDescription;
	JComboBox<IIngredient> cblstIngredients;
	private JTextField tquantite;

	public FenetreRecetteImpl() {
		initialize();
	}

	public FenetreRecetteImpl(IBean ib, ControleurCooking cc) {
		this.controler = cc;
		this.bean = (RecetteBean) ib;
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
		lstIngredientRecette.setBounds(350, 85, 220, 181);
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
				controler.gestionRecette();
			}
		});
		btnCreerRecette.setBounds(404, 409, 166, 47);
		getContentPane().add(btnCreerRecette);

		JButton btnAjouterIngredient = new JButton("");
		btnAjouterIngredient.setIcon(new ImageIcon(FenetreRecetteImpl.class
				.getResource("/img/btn-add-ico.png")));
		btnAjouterIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controler.ajoutIngredientRecette();
			}
		});
		btnAjouterIngredient.setBounds(256, 313, 60, 52);
		getContentPane().add(btnAjouterIngredient);

		JLabel lblCrerUneRecette = new JLabel("Cr\u00E9er une recette :");
		lblCrerUneRecette.setBounds(10, 11, 184, 14);
		getContentPane().add(lblCrerUneRecette);

		JLabel lblListeDesIngrdients = new JLabel(
				"Liste des ingr\u00E9dients :");
		lblListeDesIngrdients.setBounds(350, 44, 158, 14);
		getContentPane().add(lblListeDesIngrdients);

		cblstIngredients = new JComboBox<IIngredient>();
		cblstIngredients.setBounds(80, 313, 166, 20);
		getContentPane().add(cblstIngredients);

		JButton btnDelIngredient = new JButton("");
		btnDelIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controler.delIngredientRecette();
			}
		});
		btnDelIngredient.setIcon(new ImageIcon(FenetreRecetteImpl.class
				.getResource("/img/btn-del-ico.png")));
		btnDelIngredient.setBounds(580, 85, 60, 52);
		getContentPane().add(btnDelIngredient);

		JLabel lblIngredient = new JLabel("Ingredient :");
		lblIngredient.setBounds(10, 316, 60, 14);
		getContentPane().add(lblIngredient);

		JLabel lblAjouterDesIngrdients = new JLabel(
				"Ajouter des ingr\u00E9dients :");
		lblAjouterDesIngrdients.setBounds(10, 287, 158, 14);
		getContentPane().add(lblAjouterDesIngrdients);

		JLabel lblQuantite = new JLabel("Quantit\u00E9 :");
		lblQuantite.setBounds(10, 351, 70, 14);
		getContentPane().add(lblQuantite);

		tquantite = new JTextField();
		tquantite.setBounds(80, 348, 166, 20);
		getContentPane().add(tquantite);
		tquantite.setColumns(10);

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

	public JTextField getTquantite() {
		return tquantite;
	}

	public void setTquantite(JTextField tquantite) {
		this.tquantite = tquantite;
	}

}
