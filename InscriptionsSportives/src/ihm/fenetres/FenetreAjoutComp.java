package ihm.fenetres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreAjoutComp extends JFrame
{
	private JButton btnaddcomp = new JButton("Ajouter une compétition");
	private JPanel conteneur = new JPanel();

	public FenetreAjoutComp()
	{
		setTitle("Ajout d'une compétition");
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
