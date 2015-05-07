package fr.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name = "Politique")
public class Politique {

    @Id
    @Column(name = "idPolitique", nullable = false, length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPolitique;

    @Column(name = "Version", nullable = false)
    @Version
    private int Version;

    @Column(name = "nomPolitique", nullable = false, length = 50, unique = true)
    private String nomPolitique;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idParti", nullable = false)
    private Parti parti;

    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(name = "Politique_PotDeVin", joinColumns = @JoinColumn(name = "idPolitique"), inverseJoinColumns = @JoinColumn(name = "idPotDeVin"))
    private Set<PotDeVin> potDeVins = new HashSet<PotDeVin>();

    public Politique() {
    }

    public Politique(String nomPolitique) {
	this.nomPolitique = nomPolitique;
    }

    public int getIdPolitique() {
	return idPolitique;
    }

    public void setIdPolitique(int idPolitique) {
	this.idPolitique = idPolitique;
    }

    public int getVersion() {
	return Version;
    }

    public void setVersion(int version) {
	Version = version;
    }

    public String getNomPolitique() {
	return nomPolitique;
    }

    public void setNomPolitique(String nomPolitique) {
	this.nomPolitique = nomPolitique;
    }

    public Parti getParti() {
	return parti;
    }

    public void setParti(Parti parti) {
	this.parti = parti;
    }

    public Set<PotDeVin> getPotDeVins() {
	return potDeVins;
    }

    public void setPotDeVins(Set<PotDeVin> potDeVins) {
	this.potDeVins = potDeVins;
    }
    
    public void addPotDeVin(PotDeVin pdv) {
	potDeVins.add(pdv);

	//politique.setPotDeVin(this);

    }
    
    public String toString() {
	return String.format("Politique [%d,%s]", idPolitique, nomPolitique);
    }

}
