package fr.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity(name = "PotDevin")
public class PotDeVin {

    @Id
    @Column(name = "idPotDeVin", nullable = false, length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPotDeVin;

    @Column(name = "Version", nullable = false)
    @Version
    private int Version;

    @Column(name = "montant", nullable = false, length = 50, unique = true)
    private int montant;

    @ManyToMany(mappedBy = "potDeVins" ,cascade = { CascadeType.PERSIST })
    private Set<Politique> politiques = new HashSet<Politique>();

    public PotDeVin() {

    }

    public PotDeVin(int montant) {
	this.montant = montant;
    }

    public int getIdPotDeVin() {
	return idPotDeVin;
    }

    public void setIdPotDeVin(int idPolitique) {
	this.idPotDeVin = idPolitique;
    }

    public int getVersion() {
	return Version;
    }

    public void setVersion(int version) {
	Version = version;
    }

    public int getMontant() {
	return montant;
    }

    public void setMontant(int montant) {
	this.montant = montant;
    }

    public Set<Politique> getPolitique() {
	return politiques;
    }

    public void setPolitique(Set<Politique> politique) {
	this.politiques = politique;
    }

    public void addPolitique(Politique politique) {
	politiques.add(politique);

	//politique.setPotDeVin(this);

    }
}
