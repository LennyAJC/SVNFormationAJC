/**
 * 
 */
package fr.lenny.main;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import fr.lenny.metier.factory.FormationFactory;
import fr.lenny.metier.factory.ManipStagiaireFactory;
import fr.lenny.metier.factory.StagiaireFactory;
import fr.lenny.metier.factory.UtilsFactory;
import fr.lenny.metier.impl.IFormation;
import fr.lenny.metier.impl.IManipStagiaire;
import fr.lenny.metier.impl.IStagiaire;
import fr.lenny.metier.impl.IUtils;

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
		// TODO Sauvegarde du modèle ==> fichier .t (Machin suit la formation
		// toto à telle date)

		ManipStagiaireFactory mstagf = ManipStagiaireFactory.getFactory();
		IManipStagiaire mstag = mstagf.getInstance();

		UtilsFactory ufac = UtilsFactory.getFactory();
		IUtils iut = ufac.getInstance();

		FormationFactory ffac = FormationFactory.getFactory();

		StagiaireFactory sfac = StagiaireFactory.getFactory();

		IFormation ifor = null;
		IStagiaire istag = null;

		// iut.sc = new Scanner(System.in);
		nomFormation = iut.lireString("Saisissez une formation");
		dateFormation = iut
				.lireString("A quelle date aura lieu cette formation ?");

		nbSta = iut.lireInt("Combien de Stagiaire suivent cette formation?");
		iut.afficher("\n");

		for (int i = 1; i < nbSta + 1; i++) {

			String nom;
			String prenom;
			int age;

			// Utils.afficher();
			nom = iut.lireString("Saisissez le nom du stagiaire n°" + i);
			prenom = iut.lireString("Saisissez le prenom du stagiaire n°" + i);
			age = iut.lireInt("Saisissez l'age du stagiaire n°" + i);

			istag = sfac.getInstance(nom, prenom, age);
			mstag.ajouterStagiaire(istag);
		}

		iut.afficher("\n");
		iut.afficher("Affichage de la liste des stagiaires saisis : ");
		mstag.afficherlst();

		iut.afficher("\n");
		iut.afficher("Affichage de la liste des stagiaires triés : ");
		mstag.trier();
		mstag.afficherlst();
		iut.afficher("\n");
		iut.afficher("Affichage de la moyenne d'age des stagiaires saisis : ");
		System.out.println(mstag.moyenneAge());

		// recuperation de la liste des stagiaires
		

		// Creation de la formation avec ajout des stagiaires
		ifor = ffac.getInstance(nomFormation, dateFormation, nbSta,
				lstStagiaire);
		// Formation form = new Formation();
		// FileWriter fichier = null;

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			Element nform = doc.createElement("Formation");
			doc.appendChild(nform);
			Element nnomform = doc.createElement("NomFormation");
			Text tnomform = doc.createTextNode(ifor.getNomFormation());
			nnomform.appendChild(tnomform);
			nform.appendChild(nnomform);
			Element ndateform = doc.createElement("Date");
			Text tdateform = doc.createTextNode(ifor.getDateFormation());
			ndateform.appendChild(tdateform);
			nform.appendChild(ndateform);

			Element nlsttag = doc.createElement("ListeStagiaires");
			// nlsttag.appendChild(text3);
			nform.appendChild(nlsttag);
			int compteur = 1;
			ArrayList<Stagiaire> lstStagiaire = mstag.getStagiaire();
			for (Stagiaire stagiaire : lstStagiaire) {

				Element nstag = doc.createElement("Stagiaire");
				nstag.setAttribute("numero", String.valueOf(compteur));
				nlsttag.appendChild(nstag);

				Element nnomstag = doc.createElement("Stagiaire");
				Text tnomstag = doc.createTextNode(stagiaire.getNom());
				nnomstag.appendChild(tnomstag);
				nlsttag.appendChild(nnomstag);

				Element nprestag = doc.createElement("Stagiaire");
				Text tprestag = doc.createTextNode(stagiaire.getPrenom());
				nprestag.appendChild(tprestag);
				nlsttag.appendChild(nprestag);

				Element nagestag = doc.createElement("Stagiaire");
				Text tagestag = doc.createTextNode(String.valueOf(stagiaire
						.getAge()));
				nagestag.appendChild(tagestag);
				nlsttag.appendChild(nagestag);
				compteur++;

			}

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("file.xml"));

			transformer.transform(source, result);
			// }
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
