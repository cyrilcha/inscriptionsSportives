package ihm.fenetres;

import javax.swing.*;

import inscriptions.Inscriptions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreComp extends JFrame 
{
	private JButton btnaddcomp = new JButton("Ajouter une compétition");
	private JButton btnsupprcomp = new JButton("Supprimer une compétition");
	private JPanel conteneur = new JPanel();
	
	private Inscriptions inscriptions;

	public FenetreComp(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;
		setTitle("Menu des compétitions");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		conteneur.add(btnaddcomp);
		conteneur.add(btnsupprcomp);
		setContentPane(conteneur);
		
		btnaddcomp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreAjoutComp fenetreajoutcomp = new FenetreAjoutComp(inscriptions);
				fenetreajoutcomp.setVisible(true);
			}
			
		});
		
//		btnsupprcomp.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				setVisible(false);
//				FenetreAjoutComp fenetresupprcomp = new FenetreAjoutComp();
//				fenetresupprcomp.setVisible(true);
//			}
//			
//		});
		
	}

;}
