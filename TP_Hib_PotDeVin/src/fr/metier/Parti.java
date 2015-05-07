package fr.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name = "Parti")
public class Parti {

    @Id
    @Column(name = "idParti", nullable = false, length = 3)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idParti;

    @Column(name = "Version", nullable = false)
    @Version
    private int Version;

    @Column(name = "nomParti", nullable = false, length = 50, unique = true)
    private String nomParti;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "parti", nullable = false)
    private Set<Politique> lstpolitiques = new HashSet<Politique>();

    public Parti() {

    }

    public Parti(String nomParti) {
	this.nomParti = nomParti;
    }

    public int getIdParti() {
	return idParti;
    }

    public void setIdParti(int idParti) {
	this.idParti = idParti;
    }

    public int getVersion() {
	return Version;
    }

    public void setVersion(int version) {
	Version = version;
    }

    public String getNomParti() {
	return nomParti;
    }

    public void setNomParti(String nomParti) {
	this.nomParti = nomParti;
    }

    public Set<Politique> getLstPolitique() {
	return lstpolitiques;
    }

    public void setLstPolitique(Set<Politique> politique) {
	this.lstpolitiques = politique;
    }

    public String toString() {
	return String.format("Parti [%d,%s]", idParti, nomParti);
    }

    public void addPolitique(Politique politique) {
	lstpolitiques.add(politique);

	politique.setParti(this);

    }

}
