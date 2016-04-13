package ihm.fenetres;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ihm.fenetres.FenetreComp;
import inscriptions.Inscriptions;

public class FenetrePrincipale extends JFrame 
{
	private static final long serialVersionUID = -2424481175712954740L;
	
	private Inscriptions inscriptions;
	
	private ActionListener getFenetreCompetitionAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreComp fenetrecomp = new FenetreComp(inscriptions, FenetrePrincipale.this);
				fenetrecomp.setVisible(true);
			}
			
		};
	}
	
	private ActionListener getFenetreEquipeAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreEquipe fenetreequipe = new FenetreEquipe(inscriptions, FenetrePrincipale.this);
				fenetreequipe.setVisible(true);
			}
			
		};
	}
	
	private ActionListener getFenetrePersonneAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetrePers fenetrepers = new FenetrePers(inscriptions, FenetrePrincipale.this);
				fenetrepers.setVisible(true);
			}
			
		};
	}
	
	private JPanel getConteneurPrincipal()
	{
		JButton btncomp = new JButton("Compétitions");
		JButton btnequipe = new JButton("Equipes");
		JButton btnpers = new JButton("Personnes");
		JPanel conteneur = new JPanel();
		conteneur.add(btncomp);
		conteneur.add(btnequipe);
		conteneur.add(btnpers);
		btncomp.addActionListener(getFenetreCompetitionAction());
		btnequipe.addActionListener(getFenetreEquipeAction());
		btnpers.addActionListener(getFenetrePersonneAction());
		return conteneur;
	}
	
	public FenetrePrincipale(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;
		setTitle("Menu principal");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setContentPane(getConteneurPrincipal());
	}

;}
