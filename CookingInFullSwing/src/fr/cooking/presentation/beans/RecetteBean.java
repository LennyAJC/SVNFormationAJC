package fr.cooking.presentation.beans;

public class RecetteBean implements IBean{
	String nomRecette;
	String description;
	String quantite;

	static RecetteBean instance = null;

	static public RecetteBean getInstance() {
		if (instance == null) {
			instance = new RecetteBean();
		}
		return instance;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getNomRecette() {
		return nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
