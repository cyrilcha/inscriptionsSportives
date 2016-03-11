package dialogueUtilisateur.Personnes;

import inscriptions.Inscriptions;

import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;

import dialogueUtilisateur.Personnes.MenuPersonne;

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
