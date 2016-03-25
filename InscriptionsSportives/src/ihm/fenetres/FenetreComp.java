package ihm.fenetres;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreComp extends JFrame 
{
	private JButton btnaddcomp = new JButton("Ajouter une compétition");
	private JPanel conteneur = new JPanel();

	public FenetreComp()
	{
		setTitle("Menu des compétitions");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		conteneur.add(btnaddcomp);
		setContentPane(conteneur);
		
		btnaddcomp.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreAjoutComp fenetreajoutcomp = new FenetreAjoutComp();
				fenetreajoutcomp.setVisible(true);
			}
			
		});
		
	}

;}
