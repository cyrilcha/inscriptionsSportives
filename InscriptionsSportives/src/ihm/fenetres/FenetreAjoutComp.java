package ihm.fenetres;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import inscriptions.Inscriptions;
import inscriptions.Competition;

import java.time.LocalDate;

public class FenetreAjoutComp extends JFrame
{
	private static final long serialVersionUID = -2424481175712954740L;
	private JTextField nomcomp = new JTextField(20);
	private JTextField jourcomp = new JTextField(2);
	private JTextField moiscomp = new JTextField(2);
	private JTextField anneecomp = new JTextField(3);
	
	private JRadioButton radiobtnind = new JRadioButton("inscriptions indivuelles");
	private JRadioButton radiobtnequ = new JRadioButton("inscriptions en équipe");
	
	private Inscriptions inscriptions;
	FenetreComp fenetreComp; 
	
	private ActionListener ajouterCompetitionAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				setVisible(false);
				String nomcompetition = nomcomp.getText();
				
				int jour = Integer.parseInt(jourcomp.getText());
				int mois = Integer.parseInt(moiscomp.getText());
				int annee = Integer.parseInt(anneecomp.getText());
				LocalDate dateCloture = LocalDate.of(annee, mois, jour);
				boolean equipe = radiobtnequ.isSelected();
				Competition comp = inscriptions.createCompetition(nomcompetition, dateCloture, equipe);
				fenetreComp.mettreAJourCompetitions();
				fenetreComp.setVisible(true);
				try 
				{
					inscriptions.sauvegarder();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		};
	}
	
	
	private JPanel getConteneurDate()
	{
		JPanel pnldatecomp = new JPanel();
		pnldatecomp.add(jourcomp);
		pnldatecomp.add(new JLabel("/"));
		pnldatecomp.add(moiscomp);
		pnldatecomp.add(new JLabel("/"));
		pnldatecomp.add(anneecomp);
		return pnldatecomp;
	}
	
	private JPanel getConteneurEquipe()
	{
		JPanel pnlequipecomp = new JPanel();
		pnlequipecomp.add(radiobtnind);
		pnlequipecomp.add(radiobtnequ);
		ButtonGroup equipebtn = new ButtonGroup();
		equipebtn.add(radiobtnind);
		equipebtn.add(radiobtnequ);
		return pnlequipecomp;
	}
	
	private JPanel getConteneurPrincipal()
	{
		JPanel conteneur = new JPanel();
		JLabel labelnomcomp = new JLabel("Saisissez le nom de la compétition :");
		
		JLabel labeldatecomp = new JLabel("Saisissez la date de clôture de la compétition :");
		conteneur.add(labelnomcomp);
		conteneur.add(nomcomp);

		conteneur.add(labeldatecomp);
		conteneur.add(getConteneurDate());
		conteneur.add(getConteneurEquipe());		
		JButton btnAjouterCompetition = new JButton("Ajouter");
		conteneur.add(btnAjouterCompetition);
		btnAjouterCompetition.addActionListener(ajouterCompetitionAction());
		return conteneur;

	}
	
	public FenetreAjoutComp(Inscriptions inscriptions, FenetreComp fenetreComp)
	{
		this.inscriptions = inscriptions;
		this.fenetreComp = fenetreComp;
		setTitle("Ajout d'une compétition");
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
				fenetreComp.setVisible(true);
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
