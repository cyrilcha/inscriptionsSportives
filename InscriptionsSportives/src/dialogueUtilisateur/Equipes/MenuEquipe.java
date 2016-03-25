package dialogueUtilisateur.Equipes;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;


public class MenuEquipe extends Menu 
{
	public MenuEquipe(Inscriptions inscriptions)
	{
		super("Gestion des équipes", "e");
		ajoute(new AjouterEquipe(inscriptions));
	}

}
