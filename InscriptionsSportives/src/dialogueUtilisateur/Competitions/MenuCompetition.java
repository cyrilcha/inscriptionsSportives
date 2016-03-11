package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;

public class MenuCompetition extends Menu
{
	public MenuCompetition(Inscriptions inscriptions)
	{
		super("Gestion des équipes");
		ajoute(new AjouterCompetition(inscriptions));
	}
}

