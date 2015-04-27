/**
 * 
 */
package fr.lenny.main;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import fr.lenny.metier.Formation;
import fr.lenny.metier.Stagiaire;
import fr.lenny.metier.impl.IManipStagiaire;
import fr.lenny.metier.impl.IManipStagiaireFactory;
import fr.lenny.utils.Utils;

/**
 * @author ajc
 *
 */
public class Exec {

	static String nomFormation = "";
	static String dateFormation;
	static ArrayList<Stagiaire> lstStagiaire;
	static int nbSta;
	static Stagiaire stag;

	Formation form;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Saisie d'une formation
		// TODO Saisie des stagiaires
		// TODO lien entre les stagiaires et formation
		// TODO Affichage d'une moyenne d'age
		// TODO Affichage d'une liste ordonnée par age
		// TODO Sauvegarde du modèle ==> fichier .txt (Machin suit la formation
		// toto à telle date)

		Utils.sc = new Scanner(System.in);

		IManipStagiaireFactory mstagf = IManipStagiaireFactory.getFactory();
		IManipStagiaire mstag = mstagf.getInstance();
		
		nomFormation = Utils.lireString("Saisissez une formation");
		dateFormation = Utils
				.lireString("A quelle date aura lieu cette formation ?");

		nbSta = Utils.lireInt("Combien de Stagiaire suivent cette formation?");
		Utils.afficher("\n");

		for (int i = 1; i < nbSta+1; i++) {

			String nom;
			String prenom;
			int age;

			// Utils.afficher();
			nom = Utils.lireString("Saisissez le nom du stagiaire n°" + i);
			prenom = Utils.lireString("Saisissez le prenom du stagiaire n°" + i);
			age = Utils.lireInt("Saisissez l'age du stagiaire n°" + i);

			stag = new Stagiaire(nom, prenom, age);
			mstag.ajouterStagiaire(stag);
		}

		
		Utils.afficher("\n");
		Utils.afficher("Affichage de la liste des stagiaires saisis : ");
		mstag.afficherlst();

		Utils.afficher("\n");
		Utils.afficher("Affichage de la liste des stagiaires triés : ");
		mstag.trier();
		mstag.afficherlst();
		Utils.afficher("\n");
		Utils.afficher("Affichage de la moyenne d'age des stagiaires saisis : ");
		System.out.println(mstag.moyenneAge());

		// recuperation de la liste des stagiaires
		ArrayList<Stagiaire> lstStagiaire = mstag.getStagiaire();

		// Creation de la formation avec ajout des stagiaires
		Formation form = new Formation(nomFormation, dateFormation, nbSta,
				lstStagiaire);
		FileWriter fichier = null;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder db = dbf.newDocumentBuilder();
		      Document doc = db.newDocument();
		      
		      Element noeud0 = doc.createElement("Formation");
		      doc.appendChild(noeud0);
		      Element noeud1 = doc.createElement("NomFormation");
		      Text text1 = doc.createTextNode(form.getNomFormation());
		      noeud1.appendChild(text1);
		      noeud0.appendChild(noeud1);
		      Element noeud2 = doc.createElement("Date");
		      Text text2 = doc.createTextNode(form.getDateFormation());
		      noeud2.appendChild(text2);
		      noeud0.appendChild(noeud2);
		      
		      Element noeud3 = doc.createElement("ListeStagiaires");
		      //noeud3.appendChild(text3);
		      noeud0.appendChild(noeud3);

		      
		      TransformerFactory tf = TransformerFactory.newInstance();
		      Transformer transformer = tf.newTransformer();
		      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		      StringWriter sw = new StringWriter();
		      StreamResult sr = new StreamResult(sw);
		      DOMSource source = new DOMSource(doc);
		      transformer.transform(source, sr);
		      String xmlString = sw.toString();
		      System.out.println(xmlString);
		    }catch(ParserConfigurationException pce) {
		      pce.printStackTrace();
		    } catch (TransformerConfigurationException e) {
		      e.printStackTrace();
		    } catch (TransformerException e) {
		      e.printStackTrace();
		    }
	}
//		      
//		      
//			fichier = new FileWriter("file.xml");
//			fichier.write("<Formation>");
//			fichier.write("<NomFormation>" + form.getNomFormation() +"</NomFormation>");
//					fichier.write( "<date>" + form.getDateFormation() + "</date>");
//			fichier.write("<ListeStagiaires>");
//			int compteur =0;
//			for (Stagiaire Stagiaire : lstStagiaire) {
//				compteur++;
//				fichier.write("<Stagiaire numero=" + compteur + ">");
//				fichier.write("<Nom>" + Stagiaire.getNom() + "</Nom>");
//				fichier.write("<Prenom>" + Stagiaire.getPrenom() + "</Prenom>");
//				fichier.write("<Age>" + Stagiaire.getAge() + "</Age>");
//				fichier.write("</Stagiaire>");
//
//			}
//			fichier.write("</ListeStagiaires>");
//			fichier.write("</Formation>");
//			fichier.close();
//		}
//
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Le fichier est introuvable");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Impossible d'écrire dans le flux");
//		} catch (ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				fichier.close();
//			} catch (IOException ex) {
//				System.out.println("Impossible de fermer le flux");
//			}
//
//		}
//	}
	
	 public static Document createDomDocument() {
	        try {
	            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	            Document doc = builder.newDocument();
	            return doc;
	        } catch (ParserConfigurationException e) {
	        }
	        return null;
	    }
}
