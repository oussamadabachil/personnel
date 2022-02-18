package personnel;

public interface Passerelle 
{
	public GestionPersonnel getGestionPersonnel();
	public void sauvegarderGestionPersonnel(GestionPersonnel gestionPersonnel)  throws SauvegardeImpossible;
	public int insert(Ligue ligue) throws SauvegardeImpossible;
	public int select(Ligue ligue) throws SauvegardeImpossible;
	public int update(Ligue ligue) throws SauvegardeImpossible;
	public int delete(Ligue ligue) throws SauvegardeImpossible;
}
