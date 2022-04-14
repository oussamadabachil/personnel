package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import commandLineMenus.ListOption;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import personnel.Employe;
import personnel.SauvegardeImpossible;
import personnel.Ligue;

public class EmployeConsole 
{
	private Option afficher(final Employe employe)
	{
		return new Option("Afficher l'employ�", "l", () -> {System.out.println(employe);});
	}

	ListOption<Employe> editerEmploye()
	{
		return (employe) -> editerEmploye(employe);		
	}

	Option editerEmploye(Employe employe)
	{
			Menu menu = new Menu("G�rer le compte " + employe.getNom(), "c");
			menu.add(afficher(employe));
			menu.add(changerNom(employe));
			menu.add(changerPrenom(employe));
			menu.add(changerMail(employe));
			menu.add(changerPassword(employe));
			menu.add(supprimerEmploye(employe));
			menu.add(mettreAdmin(employe));
			menu.addBack("q");
			return menu;
	}

	private Option changerNom(final Employe employe)
	{
		return new Option("Changer le nom", "n", 
				() -> {
					employe.setNom(getString("Nouveau nom : "));
					try {
						employe.update(employe);
					} catch (SauvegardeImpossible e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			);
	}
	
	private Option changerPrenom(final Employe employe)
	{
		return new Option("Changer le pr�nom", "p", () -> {
			employe.setPrenom(getString("Nouveau pr�nom : "));
			try {
				employe.update(employe);
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			;});
		
	}
	
	private Option changerMail(final Employe employe)
	{
		return new Option("Changer le mail", "e", () -> {
			employe.setMail(getString("Nouveau mail : "));
			try {
				employe.update(employe);
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}
	
	private Option changerPassword(final Employe employe)
	{
		return new Option("Changer le password", "x", () -> {
			employe.setPassword(getString("Nouveau password : "));
			try {
				employe.update(employe);
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	/*
	 public static void main(String [ ] arg) { 
		  JFrame f=new JFrame("Changer Nom");  
		    JButton b=new JButton("Changer Nom"); 
		    JFrame c=new JFrame("Changer Nom");  
		    JButton d=new JButton("Changer Prénom");  
		    b.setBounds(50,100,95,30);  
		    f.add(b); 
		    c.add(c);
		    f.setSize(400,400);  
		    f.setLayout(null);  
		    f.setVisible(true);   
		   } 
		   
		   */
	
	private Option supprimerEmploye(final Employe employe) {
		return new Option("supprimer", "r", () -> {
			try {
				employe.delete(employe);
			} catch (SauvegardeImpossible e) {
				e.printStackTrace();
			}
		});
	}
	
	private Option mettreAdmin(final Employe employe) {
		Ligue ligue = employe.getLigue();
		return new Option("D�finir l'admin de la ligue", "k", () -> {
			ligue.setAdministrateur(employe);
			try {
				employe.update(employe);
			} catch (SauvegardeImpossible e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			});
	}
}
