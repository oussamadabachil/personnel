package commandLine;

import static commandLineMenus.rendering.examples.util.InOut.getString;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import commandLineMenus.List;
import commandLineMenus.Menu;
import commandLineMenus.Option;

import personnel.*;

public class LigueConsole 
{
	private GestionPersonnel gestionPersonnel;
	private EmployeConsole employeConsole;
	public LigueConsole(GestionPersonnel gestionPersonnel, EmployeConsole employeConsole)
	{
		this.gestionPersonnel = gestionPersonnel;
		this.employeConsole = employeConsole;
	}

	Menu menuLigues()
	{
		Menu menu = new Menu("GÃ©rer les ligues", "l");
		menu.add(afficherLigues());
		menu.add(ajouterLigue());
		menu.add(selectionnerLigue());
		menu.addBack("q");
		return menu;
	}

	private Option afficherLigues()
	{
		return new Option("Afficher les ligues", "l", () -> {System.out.println(gestionPersonnel.getLigues());});
	}

	private Option afficher(final Ligue ligue)
	{
		return new Option("Afficher la ligue", "l", 
				() -> 
				{
					System.out.println(ligue);
					System.out.println("AdministrÃ© par " + ligue.getAdministrateur());
				}
		);
	}
	private Option afficherEmployes(final Ligue ligue)
	{
		return new Option("Afficher les employÃ©s", "l", () -> {System.out.println(ligue.getEmployes());});
	}

	private Option ajouterLigue()
	{
		return new Option("Ajouter une ligue", "a", () -> 
		{
			try
			{
				gestionPersonnel.addLigue(getString("nom : "));
			}
			catch(SauvegardeImpossible exception)
			{
				System.err.println("Impossible de sauvegarder cette ligue");
			}
		});
	}
	
	private Menu editerLigue(Ligue ligue)
	{
		Menu menu = new Menu("Editer " + ligue.getNom());
		menu.add(afficher(ligue));
		menu.add(gererEmployes(ligue));
		menu.add(changerAdministrateur(ligue));
		menu.add(changerNom(ligue));
		menu.add(supprimer(ligue));
		menu.addBack("q");
		return menu;
	}

	private Option changerNom(final Ligue ligue)
	{
		return new Option("Renommer", "r", 
				() -> {
					ligue.setNom(getString("Nouveau nom : "));
					try {
						ligue.updateLigue(ligue);
					} catch (SauvegardeImpossible | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				);
	}

	private List<Ligue> selectionnerLigue()
	{
		return new List<Ligue>("SÃ©lectionner une ligue", "e", 
				() -> new ArrayList<>(gestionPersonnel.getLigues()),
				(element) -> editerLigue(element)
				);
	}

	private Option ajouterEmploye(final Ligue ligue)
	{
		return new Option("Ajouter un employé", "a", 
				() -> 
				{
					/* int essai = 0;
					int essaiMax = 3; */
					String nom, prenom, mail, password;
					LocalDate dArrivee, dDepart;
					
					nom = getString("Nom : ");
					prenom = getString("Prénom : ");
					mail = getString("Mail : ");
					password = getString("Mot de passe : ");
					try {
						dArrivee = LocalDate.parse(getString("Date arrivée (YYYY-MM-DD) : "));
						dDepart = LocalDate.parse(getString("Date départ (YYYY-MM-DD) : "));
						ligue.addEmploye(nom, prenom, mail, password, dArrivee, dDepart);
					} catch (Exception e) {
						System.out.println("Les dates ont mal été saisies, veuillez réessayez ...");
					}
				}
		);
	}
	
	
	private Menu gererEmployes(Ligue ligue)
	{
		Menu menu = new Menu("Gérer les employés de " + ligue.getNom(), "e");
		menu.add(afficherEmployes(ligue));
		menu.add(ajouterEmploye(ligue));
		menu.add(modifierEmploye(ligue));
		menu.add(supprimerEmploye(ligue));
		menu.addBack("q");
		return menu;
	}

	private List<Employe> supprimerEmploye(final Ligue ligue)
	{
		return new List<>("Supprimer un employé", "s", 
				() -> new ArrayList<>(ligue.getEmployes()),
				(index, element) -> {element.remove();}
				);
	}
	
	private List<Employe> changerAdministrateur(final Ligue ligue)
	{
		return new List<>("Changer l'administrateur de la ligue", "o", 
				() -> new ArrayList<>(ligue.getEmployes()), 
				(index, element) -> {ligue.setAdministrateur(element);}
				);
	}		

	private List<Employe> modifierEmploye(final Ligue ligue)
	{
		return new List<>("Modifier un employÃ©", "e", 
				() -> new ArrayList<>(ligue.getEmployes()),
				employeConsole.editerEmploye()
				);
	}
	
	private Option supprimer(Ligue ligue)
	{
		return new Option("Supprimer", "d", () -> {try {
			ligue.remove();
		} catch (SauvegardeImpossible e) {
			e.printStackTrace();
		}});
	}
	
}