/**
 * 
 */
package fr.lenny.presentation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.lenny.metier.Ecole;
import fr.lenny.metier.ElevesFactory;

/**
 * @author ajc
 *
 */
public class Fenetre extends JFrame implements IFenetre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Fenetre instance = null;

	JFrame frmGestionDesEleves;
	final JTextField tfnomEleve = new JTextField();
	final JTextField tfprenomEleve = new JTextField();
	final JTextField tfnote = new JTextField();
	final JTextField tfredoublant = new JTextField();

	final JButton btnajouter = new JButton("Ajouter");

	final JLabel labnom = new JLabel("Nom*");
	final JLabel labprenom = new JLabel("Prenom*");
	final JLabel labnote = new JLabel("Note*");
	final JLabel labredoublant = new JLabel("Redoublant ?");
	final JLabel labajouter = new JLabel("Ajouter un \u00E9l\u00E8ve");

	/**
	 * Construteur de la classe SQLUtils
	 */
	public Fenetre() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exec window = new Exec();
					window.frmGestionDesEleves.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Singleton de la classe SQLUtils
	 * 
	 * @return
	 */
	public static Fenetre getInstance() {
		if (instance == null) {
			instance = new Fenetre();
		}
		return instance;
	}

	public void initialize() {
		tfredoublant.setVisible(false);
		tfredoublant.setBounds(186, 159, 86, 20);
		tfredoublant.setColumns(10);
		tfnote.setBounds(186, 128, 86, 20);
		tfnote.setColumns(10);
		tfnomEleve.setBounds(186, 97, 86, 20);
		tfnomEleve.setColumns(10);

		frmGestionDesEleves = new JFrame();
		frmGestionDesEleves.setTitle("Gestion des eleves");
		frmGestionDesEleves.setBounds(100, 100, 450, 300);
		frmGestionDesEleves.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesEleves.getContentPane().setLayout(null);

		tfprenomEleve.setBounds(186, 66, 86, 20);
		tfprenomEleve.setColumns(10);
		btnajouter.setBounds(258, 209, 91, 23);
		labnom.setBounds(105, 72, 71, 14);
		labprenom.setBounds(105, 103, 71, 14);
		labnote.setBounds(105, 134, 71, 14);

		frmGestionDesEleves.getContentPane().add(btnajouter);
		frmGestionDesEleves.getContentPane().add(tfprenomEleve);
		frmGestionDesEleves.getContentPane().add(tfnomEleve);
		frmGestionDesEleves.getContentPane().add(tfnote);
		frmGestionDesEleves.getContentPane().add(tfredoublant);
		frmGestionDesEleves.getContentPane().add(labnom);
		frmGestionDesEleves.getContentPane().add(labprenom);
		frmGestionDesEleves.getContentPane().add(labnote);

		labredoublant.setVisible(false);
		labredoublant.setToolTipText("oui / non");
		labredoublant.setBounds(106, 162, 70, 14);
		frmGestionDesEleves.getContentPane().add(labredoublant);

		labajouter.setFont(new Font("Calibri", Font.PLAIN, 14));
		labajouter.setBounds(105, 21, 180, 20);
		frmGestionDesEleves.getContentPane().add(labajouter);

		btnajouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// launchProg();
				// System.out.println("Bonjour :" + tfnomEleve.getText());
			}
		});
	}
}
