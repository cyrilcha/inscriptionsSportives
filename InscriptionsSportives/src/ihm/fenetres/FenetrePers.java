package ihm.fenetres;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import inscriptions.Inscriptions;
import inscriptions.Competition;

import java.time.LocalDate;

public class FenetrePers extends JFrame
{
	private JButton btnaddpers = new JButton("Ajouter une personne");
	private JButton btnsupprpers = new JButton("Supprimer une personne");
	private JPanel conteneur = new JPanel();
	
	public FenetrePers()
	{
		setTitle("Menu des équipes");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		conteneur.add(btnaddpers);
		conteneur.add(btnsupprpers);
		setContentPane(conteneur);
		
		btnaddpers.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreAjoutComp fenetreajoutpers = new FenetreAjoutComp();
				fenetreajoutpers.setVisible(true);
			}
			
		});
		
		btnsupprpers.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreAjoutComp fenetresupprpers = new FenetreAjoutComp();
				fenetresupprpers.setVisible(true);
			}
			
		});
	}

}
