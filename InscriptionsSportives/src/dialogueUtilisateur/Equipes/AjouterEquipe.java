package dialogueUtilisateur.Equipes;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.Action;
import utilitaires.EntreesSorties;
import dialogueUtilisateur.Equipes.MenuEquipe;


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
