package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;

import java.time.LocalDate;

import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;

import es.EntreesSorties;

public class AjouterCompetition implements Action 
{
	
	public AjouterCompetition(MenuCompetition menu)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	}
	
	public void optionSelectionnee()
	{
		String nomCompetition = EntreesSorties.getString("Saisissez le nom de la compétition");
		//LocalDate Datecloture = EntreesSorties.getString("Mettez la date de clôture de la compétition");
		
	}
		

}
