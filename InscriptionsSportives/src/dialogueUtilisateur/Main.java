package dialogueUtilisateur;

import inscriptions.Inscriptions;
import dialogueUtilisateur.Action;
import dialogueUtilisateur.Menu;
import dialogueUtilisateur.Option;

import dialogueUtilisateur.Competitions.MenuCompetition;
import dialogueUtilisateur.Equipes.MenuEquipe;
import dialogueUtilisateur.Personnes.MenuPersonne;


public class Main 
{
	public static void main(String[] args)
	{
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		
		Menu menu = new Menu("Menu du gestionnaire des inscriptions aux compétitions de la M2L");
		Option gestionCompetitions = new Option("Gestion des compétitions", "c");
		Option gestionEquipes = new Option("Gestion des équipes", "e");
		Option gestionPersonnes = new Option("Gestion des personnes", "p");
		
		menu.ajoute(gestionCompetitions);
		menu.ajoute(gestionEquipes);
		menu.ajoute(gestionPersonnes);
		menu.ajouteQuitter("q");
		
		Action menuCompetition = new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				menu.ajoute(new MenuCompetition(inscriptions));
			}
		};
		
		Action menuEquipe = new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				menu.ajoute(new MenuEquipe(inscriptions));
			}
		};
		
		Action menuPersonne = new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				menu.ajoute(new MenuEquipe(inscriptions));
			}
		};
		
		gestionCompetitions.setAction(menuCompetition);
		gestionEquipes.setAction(menuEquipe);
		gestionPersonnes.setAction(menuPersonne);
		menu.start();
	}

}
