package dialogueUtilisateur.Equipes;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;
import dialogueUtilisateur.Equipes.MenuEquipe;


public class AjouterEquipe extends Option implements Action 
{
	private Inscriptions inscriptions;
	
	public AjouterEquipe(Inscriptions inscriptions) {
		super("Ajouter une equipe", "a");
		this.inscriptions = inscriptions;
		setAction(this);
	}
	public void optionSelectionnee()
	{
		String nomEquipe = EntreesSorties.getString("Saisissez le nom de l'équipe \n");
		inscriptions.createEquipe(nomEquipe);
		System.out.println("L'équipe " + nomEquipe + " a bien été créée");
	}

}
