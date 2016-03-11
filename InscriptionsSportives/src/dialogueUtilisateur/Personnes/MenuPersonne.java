package dialogueUtilisateur.Personnes;

import inscriptions.Inscriptions;
import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;

public class MenuPersonne extends Menu
{
	private Inscriptions inscriptions;
	
	public MenuPersonne(Inscriptions inscriptions)
	{
		super("Gestion des personnes");
		this.inscriptions=inscriptions;
	}

}
