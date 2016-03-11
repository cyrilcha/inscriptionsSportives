package dialogueUtilisateur.Equipes;

import inscriptions.Inscriptions;

import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;
import dialogueUtilisateur.Equipes.MenuEquipe;
import es.EntreesSorties;

public class AjouterEquipe implements Action 
{
	public AjouterEquipe(MenuEquipe menu)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	}
	public void optionSelectionnee()
	{
		String nomEquipe = EntreesSorties.getString("Saisissez le nom de l'équipe");
	}

}
