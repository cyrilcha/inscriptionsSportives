package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;
import java.time.LocalDate;

import dialogueUtilisateur.Equipes.MenuEquipe;

public class AjouterCompetition extends Option implements Action
{
	

	public AjouterCompetition(Inscriptions inscriptions) {
		super("Ajouter une compétition", "a");
		setAction(this);
	}


	@Override
	public void optionSelectionnee() {
		String nomCompetition = EntreesSorties.getString("Saisissez le nom de la compétition");
		LocalDate dateCloture = LocalDate.parse(EntreesSorties.getString("Mettez la date de clôture de la compétition (aa-mm-jj)"));
		
	}
		

}
