package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

class  testEmploye{ 

	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test 
	
	void testGetNom() throws SauvegardeImpossible{
		
		Ligue ligue = gestionPersonnel.addLigue("LigueA");
        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
        assertEquals("dabachil",employe.getNom());
		
		
		
	}
	@Test 

void testSetNom() throws SauvegardeImpossible{
		
		Ligue ligue = gestionPersonnel.addLigue("LigueA");
        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
        employe.setNom("dachabil");
        assertEquals("dachabil",employe.getNom());
		
		
		
	}
	
	
	@Test 

	void testSetPrenom() throws SauvegardeImpossible{
			
			Ligue ligue = gestionPersonnel.addLigue("LigueA");
	        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
	        employe.setNom("amassou");
	        assertEquals("amassou",employe.getPrenom());
			
			
			
		}
		
	@Test 

	void testGetPrenom() throws SauvegardeImpossible{
			
			Ligue ligue = gestionPersonnel.addLigue("LigueA");
	        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
	        assertEquals("oussama",employe.getPrenom());
			
			
			
		}
		
	
}
