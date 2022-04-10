package interfaceGraphique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JLabel;
import personnel.GestionPersonnel;
import java.awt.ComponentOrientation;
import java.awt.Cursor;


public class loginPage extends JFrame implements ActionListener{

	private static final long serialVersionUID = -796577401366748943L;
	private JPasswordField passwordField;

	public loginPage(){
		super("M2L - Gestion des Ligues");
		this.setIconImages(getIconImages());
		setResizable(false);
		
		// Processus se coupe quand on ferme la fenêtre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		/* On gère la taille et la position 
		 * de la fenêtre au centre par rapport
		 * à la résolution de l'écran
		*/
		this.setSize(800, 600);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
	    this.setLocation(x, y);
	    getContentPane().setLayout(null);
	    
	    passwordField = new JPasswordField();
	    passwordField.setBounds(252, 268, 284, 28);
	    getContentPane().add(passwordField);
	    
	    JTextPane passwordText = new JTextPane();
	    passwordText.setEditable(false);
	    passwordText.setText("Ins\u00E9rer le mot de passe");
	    passwordText.setBounds(252, 231, 284, 24);
	    getContentPane().add(passwordText);
	    
	    JTextPane headerLogin = new JTextPane();
	    headerLogin.setMinimumSize(new Dimension(20, 20));
	    headerLogin.setFont(new Font("Agency FB", Font.PLAIN, 11));
	    headerLogin.setAutoscrolls(false);
	    headerLogin.setBackground(Color.CYAN);
	    headerLogin.setText("Bienvenue sur le PGI de M2L");
	    headerLogin.setEditable(false);
	    headerLogin.setDropMode(DropMode.INSERT);
	    headerLogin.setBounds(252, 101, 284, 40);
	    getContentPane().add(headerLogin);
	    
	    // Initialisation du texte pour afficher une erreur en cas non connexion.
	    
	    JLabel errorMessage = new JLabel("");
	    errorMessage.setBounds(252, 312, 284, 16);
	    getContentPane().add(errorMessage);
	    
	    JButton loginButton = new JButton("Se connecter");
	    loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	    loginButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		// TODO : Traiter le champ pour connecter l'utilisateur root
		    if (GestionPersonnel.getGestionPersonnel().getRoot().checkPassword(passwordText.getText())) {
		    		
		    	}
		    	else {
		    		errorMessage.setText("Veuillez réesayez ");
		    	}
	    	}
	    });
	    loginButton.setBounds(252, 432, 284, 28);
	    getContentPane().add(loginButton);
	    
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		loginPage loginPage = new loginPage();
		loginPage.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	