package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;

import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;

import es.EntreesSorties;

public class SupprimerCompetition implements Action 
{
	public SupprimerCompetition(MenuCompetition menu)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	}
	
	public void optionSelectionnee()
	{
		System.out.println("Compétition effacée.");
	}

}
