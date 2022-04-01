
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import personnel.Employe;
import personnel.GestionPersonnel;
import personnel.Ligue;
import personnel.SauvegardeImpossible;



public class AjouterUnEmploye {
	
	public void AddEmploye() {
		
		framed().setVisible(true);
	}
	
	private JFrame framed()
	{
		JFrame employeAdd = new JFrame();
		employeAdd.setTitle("Ajouter un employe");
		employeAdd.setSize(1080,1920);
		employeAdd.setLocationRelativeTo(null);
		employeAdd.setJMenuBar(menuBar());
		employeAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return employeAdd;
	}
	
	 private JMenuBar menuBar()
	 {
		 JMenuBar menubar = new JMenuBar();
		 menubar.setPreferredSize(new Dimension(80,80));
		 JMenu menu = new JMenu("Quitter");
		 menubar.add(menu);
		return menubar;
	 }

	
	private JPanel panel()
	{
		JPanel panel = new JPanel();
		
		JLabel nomL = new JLabel("Nom :");
		JLabel prenomL = new JLabel("Prenom :");
		JLabel emailL = new JLabel("Email :");
		JLabel passwordL = new JLabel("Mot de passe :");
		JLabel dateArriveeL = new JLabel("Date d'arrivee :");
		JLabel dateDepartL = new JLabel("Date de depart :");

		
		
		return panel;
	}
}
	