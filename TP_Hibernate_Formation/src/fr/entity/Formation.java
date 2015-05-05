package fr.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Formation")
public class Formation {

	@Id
	@Column(name = "idFormation", nullable = false, length = 3)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFormation;

	@Column(name = "version", nullable = false)
	private int Version;

	@Column(name = "nomformation", nullable = false, length = 50, unique = true)
	private String nomFormation;

	@Column(name = "dateFormation", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFormation;

	@Column(name = "nbStagiaireMax", nullable = false, length = 3)
	private int nbStagiaireMax;

	@Column(name = "nbStagiaire", nullable = false, length = 3)
	private int nbStagiaire;

	public Formation() {

	}

	public Formation(String nomFormation, Date dateFormation, int nbStagiaireMax) {
		super();
		setNomFormation(nomFormation);
		setDateFormation(dateFormation);
		setNbStagiaireMax(nbStagiaireMax);

	}

	public int getNbStagiaireMax() {
		return nbStagiaireMax;
	}

	public void setNbStagiaireMax(int nbStagiaireMax) {
		this.nbStagiaireMax = nbStagiaireMax;
	}

	public String toString() {
		return String.format("[%d,%d,%s,%s,%d]", getIdFormation(),
				getVersion(), getNomFormation(), new SimpleDateFormat(
						"dd/MM/yyyy").format(getDateFormation()),
				getNbStagiaire());
	}

	/**
	 * Gettez and Setterz
	 * 
	 * @return
	 */
	public int getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
	}

	public int getVersion() {
		return Version;
	}

	public void setVersion(int version) {
		Version = version;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public Date getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(Date dateFormation) {
		this.dateFormation = dateFormation;
	}

	public int getNbStagiaire() {
		return nbStagiaire;
	}

	public void setNbStagiaire(int nbStagiaire) {
		this.nbStagiaire = nbStagiaire;
	}

}
