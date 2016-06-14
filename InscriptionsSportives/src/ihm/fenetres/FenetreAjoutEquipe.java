package ihm.fenetres;

import javax.swing.*;

import inscriptions.Equipe;
import inscriptions.Inscriptions;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class FenetreAjoutEquipe extends JFrame 
{
	private static final long serialVersionUID = -2424481175712954740L;
	private JTextField nomequ = new JTextField(20);
	
	private Inscriptions inscriptions;
	FenetreEquipe fenetreEquipe;
	
	private ActionListener ajouterEquipeAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				setVisible(false);
				String nomequipe = nomequ.getText();
				
				inscriptions.createEquipe(nomequipe);
				
				fenetreEquipe.mettreAJourEquipes();
				fenetreEquipe.setVisible(true);
				try 
				{
					inscriptions.sauvegarder();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		};
	}
	
	private JPanel getConteneurPrincipal()
	{
		JPanel conteneur = new JPanel();
		JLabel labelnomequipe = new JLabel("Saisissez le nom de l'équipe :");
		conteneur.add(labelnomequipe);
		conteneur.add(nomequ);
		JButton btnAjouterEquipe = new JButton("Ajouter");
		conteneur.add(btnAjouterEquipe);
		btnAjouterEquipe.addActionListener(ajouterEquipeAction());
		return conteneur;
	}
	public FenetreAjoutEquipe(Inscriptions inscriptions, FenetreEquipe fenetreEquipe)
	{
		this.inscriptions = inscriptions;
		this.fenetreEquipe = fenetreEquipe;
		setTitle("Ajout d'une équipe");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setContentPane(getConteneurPrincipal());
		addWindowListener(getWindowListener());
	}
	
	private WindowListener getWindowListener()
	{
		return new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				fenetreEquipe.setVisible(true);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}

}
