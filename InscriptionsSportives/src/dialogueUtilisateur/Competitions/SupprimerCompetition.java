package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;

import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;

public class SupprimerCompetition implements Action 
{
	public SupprimerCompetition(MenuEquipe menu)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	}
	
	public void optionSelectionnee()
	{
		System.out.println("Compétition effacée.");
	}

}
