package ihm.fenetres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import inscriptions.Inscriptions;

import java.time.LocalDate;

public class FenetreEquipe extends JFrame
{
	private JButton btnaddequipe = new JButton("Ajouter une équipe");
	private JButton btnsupprequipe = new JButton("Supprimer une équipe");
	private JPanel conteneur = new JPanel();
	
	public FenetreEquipe()
	{
		setTitle("Menu des équipes");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		conteneur.add(btnaddequipe);
		conteneur.add(btnsupprequipe);
		setContentPane(conteneur);
		
//		btnaddequipe.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				setVisible(false);
//				FenetreAjoutComp fenetreajoutequipe = new FenetreAjoutComp();
//				fenetreajoutequipe.setVisible(true);
//			}
//			
//		});
//		
//		btnsupprequipe.addActionListener(new ActionListener()
//		{
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				setVisible(false);
//				FenetreAjoutComp fenetresupprequipe = new FenetreAjoutComp();
//				fenetresupprequipe.setVisible(true);
//			}
//			
//		});
	}

}
