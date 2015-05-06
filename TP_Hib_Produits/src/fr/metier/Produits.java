package fr.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name = "Produits")
public class Produits {

	@Id
	@Column(name = "idProduit", nullable = false, length = 3)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduit;

	@Column(name = "version", nullable = false)
	@Version
	private int Version;

	@Column(name = "nomProduit", nullable = false, length = 50, unique = true)
	private String nomProduit;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategorie", nullable = false)
	private Categories categories;

	public Produits() {

	}

	public Produits(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getVersion() {
		return Version;
	}

	public void setVersion(int version) {
		Version = version;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public Categories getCategorie() {
		return categories;
	}

	public void setCategorie(Categories categories) {
		this.categories = categories;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public String toString() {
		return String.format("Produits[%d,%d,%s,%d]", idProduit, Version,
				nomProduit, categories.getIdCategorie());
	}

}
