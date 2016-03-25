package dialogueUtilisateur;

import dialogueUtilisateur.Competitions.MenuCompetition;
import dialogueUtilisateur.Equipes.MenuEquipe;
import dialogueUtilisateur.Personnes.MenuPersonne;
import inscriptions.Inscriptions;
import utilitaires.ligneDeCommande.Menu;

public class MenuPrincipal extends Menu{

	public MenuPrincipal(Inscriptions inscriptions) {
		super("Gestionnaire d'inscriptions");
		ajoute(new MenuCompetition(inscriptions));
		ajoute(new MenuEquipe(inscriptions));
		ajoute(new MenuPersonne(inscriptions));
	}

	public static void main(String[] args) {
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		Menu menu = new MenuPrincipal(inscriptions);
		menu.start();
	}

}
