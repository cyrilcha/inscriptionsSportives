package dialogueUtilisateur.Personnes;

import inscriptions.Inscriptions;
import utilitaires.ligneCommande.Action;
import utilitaires.ligneCommande.Menu;
import utilitaires.ligneCommande.Option;

public class MenuPersonne extends Menu
{
	private Inscriptions inscriptions;
	
	public MenuPersonne(Inscriptions inscriptions)
	{
		super("Gestion des personnes");
		this.inscriptions=inscriptions;
	}

}
