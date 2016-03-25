package dialogueUtilisateur.Personnes;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;

public class MenuPersonne extends Menu
{
	private Inscriptions inscriptions;
	
	public MenuPersonne(Inscriptions inscriptions)
	{
		super("Gestion des personnes", "p");
		this.inscriptions=inscriptions;
	}

}
