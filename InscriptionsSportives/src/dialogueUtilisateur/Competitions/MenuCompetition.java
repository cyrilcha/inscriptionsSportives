package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;
import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;

public class MenuCompetition extends Menu
{
	private Inscriptions inscriptions = Inscriptions.getInscriptions();
	
	public MenuCompetition(Inscriptions inscriptions)
	{
		super("Gestion des compétitions");
		this.inscriptions=inscriptions;
		this.ajoute(new Option("Ajouter une compétition", "a", new AjouterCompetition(this)));
		this.ajoute(new Option("Supprimer une compétition", "s", new SupprimerCompetition(this)));
		this.ajouteRevenir("r");
	}

}
