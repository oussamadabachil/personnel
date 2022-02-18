package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import personnel.*;

class  testEmploye{ 

	GestionPersonnel gestionPersonnel = GestionPersonnel.getGestionPersonnel();
	
	@Test 
	
	void testGetNom() throws SauvegardeImpossible{
		
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
        assertEquals("dabachil",employe.getNom());
		
		
		
	}
	@Test 

void testSetNom() throws SauvegardeImpossible{
		
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
        employe.setNom("dachabil");
        assertEquals("dachabil",employe.getNom());
		
		
		
	}
	
	
	@Test 

	void testSetPrenom() throws SauvegardeImpossible{
			
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
	        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
	        employe.setNom("amassou");
	        assertEquals("amassou",employe.getPrenom());
			
			
			
		}
		
	@Test 

	void testGetPrenom() throws SauvegardeImpossible{
			
		Ligue ligue = gestionPersonnel.addLigue("Ligue1");
	        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
	        assertEquals("oussama",employe.getPrenom());
			
			
			
		}
	
	
@Test 

void testGetMail() throws SauvegardeImpossible{
		
	Ligue ligue = gestionPersonnel.addLigue("Ligue1");
        Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
        assertEquals("oussama@dabachil.fr",employe.getMail());
		
		
		
	}
	
@Test 

void testSetMail() throws SauvegardeImpossible{

Ligue ligue = gestionPersonnel.addLigue("Ligue1");
Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
employe.setMail("dabachil@ddd.fr");

assertEquals("54321",employe.getMail());



}


@Test 

void testSetPassword() throws SauvegardeImpossible{
	
Ligue ligue = gestionPersonnel.addLigue("Ligue1");
    Employe employe = ligue.addEmploye("oussama", "dabachil", "oussama@dabachil.fr", "12345", LocalDate.parse("2022-02-04"), LocalDate.parse("2022-02-06"));
    employe.setPassword("54321");

    assertEquals("oussama@dabaxchil.fr",employe.checkPassword("54321"));
	
	
	
}





		
	
}