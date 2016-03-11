package dialogueUtilisateur.Equipes;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;


public class MenuEquipe extends Menu 
{
	private Inscriptions inscriptions;
	
	public MenuEquipe(Inscriptions inscriptions)
	{
		super("Gestion des équipes");
		this.inscriptions=inscriptions;
	}

}
