package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;
import java.time.LocalDate;

import dialogueUtilisateur.Equipes.MenuEquipe;

public class AjouterCompetition implements Action 
{
	
	public AjouterCompetition(MenuEquipe menu)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	}
	
	public void optionSelectionnee()
	{
		String nomCompetition = EntreesSorties.getString("Saisissez le nom de la compétition");
		//LocalDate Datecloture = EntreesSorties.getString("Mettez la date de clôture de la compétition");
		
	}
		

}
