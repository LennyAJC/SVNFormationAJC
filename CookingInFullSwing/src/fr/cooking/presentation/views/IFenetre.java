package fr.cooking.presentation.views;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import fr.cooking.metier.IIngredient;

public interface IFenetre {

	public void initialize();

	public JTextField getTextField();

	public void setTextField(JTextField textField);

	public JComboBox<IIngredient> getCblstIngredients();

	public void setCblstIngredients(JComboBox<IIngredient> cblstIngredients);

	public JTextField getTxtRecette();

	public void setTxtRecette(JTextField txtRecette);

	public JTextField getTxtDescription();

	public void setTxtDescription(JTextField txtDescription);

	public JTextField getTquantite();

	public void setTquantite(JTextField tquantite);

	public JTextField gettIngredient();

	public void settIngredient(JTextField tIngredient);

	public JTextArea getLstIngredientRecette();

	public void setLstIngredientRecette(String nomIngredient);

	public void lstIngredientRecetteClear();
}
