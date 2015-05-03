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
	JFrame fenetreRecette;
	JTextArea lstIngredientRecette;

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

		fenetreRecette = new JFrame();
		fenetreRecette.setTitle("Cr\u00E9ation d'une recette");
		fenetreRecette.setBounds(100, 100, 661, 424);
		fenetreRecette.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestion des recettes");
		fenetreRecette.getContentPane().setLayout(null);

		this.fenetreRecette.setVisible(true);

		JLabel lblRecette = new JLabel("Recette :");
		lblRecette.setBounds(10, 44, 70, 14);
		fenetreRecette.getContentPane().add(lblRecette);

		txtRecette = new JTextField();
		txtRecette.setBounds(80, 41, 224, 20);
		fenetreRecette.getContentPane().add(txtRecette);
		txtRecette.setColumns(10);

		lstIngredientRecette = new JTextArea();
		lstIngredientRecette.setBounds(350, 85, 220, 181);
		fenetreRecette.getContentPane().add(lstIngredientRecette);

		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(10, 85, 77, 14);
		fenetreRecette.getContentPane().add(lblDescription);

		txtDescription = new JTextField();
		txtDescription.setBounds(80, 85, 224, 181);
		fenetreRecette.getContentPane().add(txtDescription);
		txtDescription.setColumns(10);

		JLabel lblCrerUneRecette = new JLabel("Cr\u00E9er une recette :");
		lblCrerUneRecette.setBounds(10, 11, 184, 14);
		fenetreRecette.getContentPane().add(lblCrerUneRecette);

		JLabel lblListeDesIngrdients = new JLabel(
				"Liste des ingr\u00E9dients :");
		lblListeDesIngrdients.setBounds(350, 44, 158, 14);
		fenetreRecette.getContentPane().add(lblListeDesIngrdients);

		cblstIngredients = new JComboBox<IIngredient>();
		cblstIngredients.setBounds(80, 313, 166, 20);
		fenetreRecette.getContentPane().add(cblstIngredients);

		JLabel lblIngredient = new JLabel("Ingredient :");
		lblIngredient.setBounds(10, 316, 60, 14);
		fenetreRecette.getContentPane().add(lblIngredient);

		JLabel lblAjouterDesIngrdients = new JLabel(
				"Ajouter des ingr\u00E9dients :");
		lblAjouterDesIngrdients.setBounds(10, 287, 158, 14);
		fenetreRecette.getContentPane().add(lblAjouterDesIngrdients);

		JLabel lblQuantite = new JLabel("Quantit\u00E9 :");
		lblQuantite.setBounds(10, 351, 70, 14);
		fenetreRecette.getContentPane().add(lblQuantite);

		tquantite = new JTextField();
		tquantite.setBounds(80, 348, 166, 20);
		fenetreRecette.getContentPane().add(tquantite);
		tquantite.setColumns(10);

		// btnAjouterIngredient
		JButton btnAjouterIngredient = new JButton("");
		btnAjouterIngredient.setBounds(256, 313, 60, 52);
		fenetreRecette.getContentPane().add(btnAjouterIngredient);
		/**
		 * Ajout de l'ingredient sélectionné dans la combobox dans la liste des
		 * ingredients
		 */
		btnAjouterIngredient.setIcon(new ImageIcon(FenetreRecetteImpl.class
				.getResource("/img/btn-add-ico.png")));
		btnAjouterIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controler.ajoutIngredientRecette(getFenetre());
			}
		});

		// btnDelIngredient
		JButton btnDelIngredient = new JButton("");
		btnDelIngredient.setIcon(new ImageIcon(FenetreRecetteImpl.class
				.getResource("/img/btn-del-ico.png")));
		btnDelIngredient.setBounds(580, 85, 60, 52);
		fenetreRecette.getContentPane().add(btnDelIngredient);
		/**
		 * Suppression de l'ingredient sélectionné dans la liste des ingredients
		 * de cette même liste
		 */
		btnDelIngredient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controler.delIngredientRecette();
			}
		});

		// btnCreerRecette
		JButton btnCreerRecette = new JButton("Cr\u00E9er Recette");
		btnCreerRecette.setBounds(404, 313, 166, 47);
		fenetreRecette.getContentPane().add(btnCreerRecette);
		/**
		 * Creation de la recette avec tout les élements sélectionnés
		 */
		btnCreerRecette.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controler.gestionRecette();
			}
		});
	}

	public JTextArea getLstIngredientRecette() {
		return lstIngredientRecette;
	}

	public void setLstIngredientRecette(JTextArea lstIngredientRecette) {
		this.lstIngredientRecette = lstIngredientRecette;
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
	public JTextField gettIngredient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void settIngredient(JTextField tIngredient) {
		// TODO Auto-generated method stub
		
	}

}
