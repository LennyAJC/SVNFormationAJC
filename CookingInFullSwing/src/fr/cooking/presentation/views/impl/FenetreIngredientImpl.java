package fr.cooking.presentation.views.impl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.cooking.metier.IIngredient;
import fr.cooking.presentation.beans.IBean;
import fr.cooking.presentation.beans.IngredientBean;
import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.IFenetre;

public class FenetreIngredientImpl extends JFrame implements IFenetre {

	/**
	 * 
	 */
	IngredientBean bean;
	ControleurCooking controler;
	JFrame fenetreIngredient;

	private static final long serialVersionUID = 1L;
	private JTextField tIngredient;

	public FenetreIngredientImpl(IBean bean, ControleurCooking cc) {
		this.controler = cc;
		this.bean = (IngredientBean) bean;
		initialize();
	}

	public FenetreIngredientImpl() {
		initialize();
	}

	public IFenetre getFenetre() {
		return this;
	}

	@Override
	public void initialize() {
		fenetreIngredient = new JFrame();
		fenetreIngredient.setBounds(100, 100, 464, 299);
		fenetreIngredient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gestion des ingr\u00E9dients");
		fenetreIngredient.getContentPane().setLayout(null);

		this.fenetreIngredient.setVisible(true);

		JLabel lblIngredient = new JLabel("Ingredient :");
		lblIngredient.setBounds(35, 62, 69, 14);
		fenetreIngredient.getContentPane().add(lblIngredient);

		tIngredient = new JTextField();
		tIngredient.setBounds(114, 59, 86, 20);
		fenetreIngredient.getContentPane().add(tIngredient);
		tIngredient.setColumns(10);

		JTextArea taIngredients = new JTextArea();
		taIngredients.setBounds(230, 31, 202, 220);
		fenetreIngredient.getContentPane().add(taIngredients);

		JLabel lblIngredients = new JLabel("Inserer un nouvel ingredient :");
		lblIngredients.setBounds(35, 25, 165, 14);
		fenetreIngredient.getContentPane().add(lblIngredients);

		// btnAjouter
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(114, 101, 91, 23);
		fenetreIngredient.getContentPane().add(btnAjouter);
		/*
		 * Ajout de l'ingredient saisi
		 */
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				bean.setNomIngredient(tIngredient.getText());
				controler.gestionIngredient();
			}
		});

	}

	public JTextField gettIngredient() {
		return tIngredient;
	}

	public void settIngredient(JTextField tIngredient) {
		this.tIngredient = tIngredient;
	}

	public JTextField getTextField() {
		return tIngredient;
	}

	public void setTextField(JTextField textField) {
		this.tIngredient = textField;
	}

	@Override
	public JComboBox<IIngredient> getCblstIngredients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCblstIngredients(JComboBox<IIngredient> cblstIngredients) {
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
