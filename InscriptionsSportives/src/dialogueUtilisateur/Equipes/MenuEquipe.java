package dialogueUtilisateur.Equipes;

import inscriptions.Inscriptions;
import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;


public class MenuEquipe extends Menu 
{
	private Inscriptions inscriptions;
	
	public MenuEquipe(Inscriptions inscriptions)
	{
		super("Gestion des équipes");
		this.inscriptions=inscriptions;
	}

}
