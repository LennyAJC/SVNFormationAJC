/**
 * 
 */
package fr.lenny.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.lenny.data.impl.IContactData;
import fr.lenny.utils.Utils;

/**
 * @author ajc
 *
 */
public class ContactDao {

	String nom;
	String prenom;
	String telephone;

	Statement stmt = null;
	ResultSet rst = null;

	static ContactDao instance = null;
	
	public ContactDao() {

	}

	public ContactDao(String nom, String prenom, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;

	}

	public static ContactDao getInstance() {
		if (null == instance) {
			instance = new ContactDao();
		}
		return instance;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.lenny.dao.impl.IContactDao#enregistrer()
	 */
	public void insert(IContactData icd) {
		Utils u = Utils.getInstance();
		Connection connection = u.connexionbdd();

		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO "
					+ "Contact "
					+ "VALUES('" + icd.getNom() + "','" + icd.getPrenom() + "','" + icd.getTelephone() + "')");
			System.out.println("insertion ok!");
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La requete est incorrecte");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de fermer la connection");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.lenny.dao.impl.IContactDao#recuperer()
	 */
	public void recuperer() {
		Utils u = Utils.getInstance();
		Connection connection = u.connexionbdd();
		String sql = null;
		try {
			stmt = connection.createStatement();
			 sql ="SELECT * FROM Contact";
			rst = stmt.executeQuery("\""+ sql +"\"");
			while (rst.next()) {
				System.out.println(rst.getString("nom") + ":"
						+ rst.getString("prenom") + ":"
						+ rst.getString("telephone"));
				
				

			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("La requete est incorrecte" + sql);
		}
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de fermer la connection");
		}

	}
}
