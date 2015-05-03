package fr.cooking.presentation.views.impl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.cooking.presentation.controlers.ControleurCooking;
import fr.cooking.presentation.views.FenetreFactory;
import fr.cooking.presentation.views.IFenetre;

public class FenetreIngredientImpl extends JFrame implements IFenetre {

	/**
	 * 
	 */
	FenetreFactory ffa = null;
	IFenetre window = null;
	ControleurCooking cc = null;

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public FenetreIngredientImpl() {
		initialize();
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public IFenetre getFenetre() {
		return this;
	}

	@Override
	public void initialize() {
		setTitle("Gestion des ingr\u00E9dients");
		getContentPane().setLayout(null);

		JLabel lblIngredient = new JLabel("Ingredient");
		lblIngredient.setBounds(35, 62, 69, 14);
		getContentPane().add(lblIngredient);

		textField = new JTextField();
		textField.setBounds(114, 59, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cc = ControleurCooking.getInstance();
				cc.gestionIngredient();
			}
		});
		btnAjouter.setBounds(114, 101, 91, 23);
		getContentPane().add(btnAjouter);

		JTextArea taIngredients = new JTextArea();
		taIngredients.setBounds(230, 31, 202, 220);
		getContentPane().add(taIngredients);

		JLabel lblIngredients = new JLabel("Inserer un nouvel ingredient");
		lblIngredients.setBounds(35, 25, 165, 14);
		getContentPane().add(lblIngredients);

	}
}
