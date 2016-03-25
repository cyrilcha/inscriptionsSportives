package dialogueUtilisateur.Competitions;

import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.*;
import utilitaires.EntreesSorties;
import java.time.LocalDate;

import dialogueUtilisateur.Equipes.MenuEquipe;

public class AjouterCompetition extends Option implements Action
{
	private Inscriptions inscriptions;

	public AjouterCompetition( Inscriptions inscriptions) {
		super("Ajouter une compétition", "a");
		this.inscriptions = inscriptions;
		setAction(this);
	}


	@Override
	public void optionSelectionnee() {
		String nomCompetition = EntreesSorties.getString("Saisissez le nom de la compétition \n");
		LocalDate dateCloture = LocalDate.parse(EntreesSorties.getString("Mettez la date de clôture de la compétition (aaaa-mm-jj) \n"));
		String enEquipe = EntreesSorties.getString("Compétition en équipe ? 'o' pour oui, 'n' pour non \n");
		Boolean Equipe = false;
		if(enEquipe == "o")
		{
			Equipe = true;
		}
		else if(enEquipe == "n")
		{
			Equipe = false;
		}
	    inscriptions.createCompetition(nomCompetition, (LocalDate)dateCloture, Equipe);
	    System.out.println("La compétition a bien été créee");

	}
		

}
