package fr.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name = "Categories")
public class Categories {

	@Id
	@Column(name = "idcategorie", nullable = false, length = 3)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCategorie;

	@Column(name = "version", nullable = false)
	@Version
	private int Version;

	@Column(name = "nomcategorie", nullable = false, length = 50, unique = true)
	private String nomCategorie;

	@OneToMany(mappedBy = "categories", fetch = FetchType.LAZY)
	private Set<Produits> produits = new HashSet<Produits>();

	public Categories() {

	}

	public Categories(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getVersion() {
		return Version;
	}

	public void setVersion(int version) {
		Version = version;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Set<Produits> getProduit() {
		return produits;
	}

	public void setProduits(Set<Produits> produits) {
		this.produits = produits;
	}

	public String toString() {
		return String.format("Categorie[%d,%d,%s]", idCategorie, Version,
				nomCategorie);
	}

}
