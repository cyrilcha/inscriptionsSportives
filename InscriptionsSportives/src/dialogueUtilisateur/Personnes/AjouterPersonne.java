package dialogueUtilisateur.Personnes;

import inscriptions.Inscriptions;

import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;
import dialogueUtilisateur.Personnes.MenuPersonne;
import es.EntreesSorties;

public class AjouterPersonne implements Action 
{
	public AjouterPersonne(MenuPersonne menu)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
	}
	public void optionSelectionnee()
	{
		String nomPersonne = EntreesSorties.getString("Saisissez le nom de la personne");
		String prenomPersonne = EntreesSorties.getString("Saisissez le prénom de la personne");
		String mailPersonne = EntreesSorties.getString("Saisissez le mail de la personne");
		
	}

}
