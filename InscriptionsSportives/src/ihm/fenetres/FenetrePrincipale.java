package ihm.fenetres;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ihm.fenetres.FenetreComp;
import inscriptions.Inscriptions;

public class FenetrePrincipale extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424481175712954740L;
	private JButton btncomp = new JButton("Compétitions");
	private JButton btnequipe = new JButton("Equipes");
	private JButton btnpers = new JButton("Personnes");
	private JPanel conteneur = new JPanel();
	
	private Inscriptions inscriptions;
	
	public FenetrePrincipale(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;
		setTitle("Menu principal");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		conteneur.add(btncomp);
		conteneur.add(btnequipe);
		conteneur.add(btnpers);
		setContentPane(conteneur);
		
		btncomp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreComp fenetrecomp = new FenetreComp(inscriptions);
				fenetrecomp.setVisible(true);
			}
			
		});
		
		btnequipe.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreEquipe fenetreequipe = new FenetreEquipe();
				fenetreequipe.setVisible(true);
			}
			
		});
		
		btnpers.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetrePers fenetrepers = new FenetrePers();
				fenetrepers.setVisible(true);
			}
			
		});
		
	}

;}
