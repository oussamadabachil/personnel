package personnel;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	
	// G�rer les ligues
	
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public int select(Ligue ligue) throws SauvegardeImpossible;
	public void update(Ligue ligue) throws SauvegardeImpossible;
	public void delete(Ligue ligue) throws SauvegardeImpossible;
	
	// G�rer les employ�s
	
	public int selectEmp(Employe employe) throws SauvegardeImpossible;
	public int insertEmp(Employe employe) throws SauvegardeImpossible;
	public void updateEmp(Employe employe) throws SauvegardeImpossible;
	public void deleteEmp(Employe employe) throws SauvegardeImpossible;
}
