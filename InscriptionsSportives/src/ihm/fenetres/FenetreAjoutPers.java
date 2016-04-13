package ihm.fenetres;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Personne;
import inscriptions.Inscriptions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FenetreAjoutPers extends JFrame
{
	private static final long serialVersionUID = -2424481175712954740L;
	private JTextField nompers = new JTextField(10);
	private JTextField prenompers = new JTextField(10);
	private JTextField mailpers = new JTextField(20);
	private JList listequipepers;
	private JList listcomppers;
	
	private Inscriptions inscriptions;
	FenetrePers fenetrePers;
	
	private List<Competition> getCompetitions()
	{
		return new ArrayList<>(inscriptions.getCompetitions());
	}
	
	private List<Equipe> getEquipes()
	{
		return new ArrayList<>(inscriptions.getEquipes());
	}
	
	private ListModel getCompetitionsListModel(final List<Competition> competitions)
	{
		return new ListModel<Competition>() 
		{@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return competitions.size();
		}

		@Override
		public Competition getElementAt(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}
		};
	}
	
	private ListModel getEquipesListModel(final List<Equipe> equipes)
	{
		return new ListModel<Equipe>() 
		{@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getSize() {
			return equipes.size();
		}

		@Override
		public Equipe getElementAt(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}
		};
		
	}
	
	private JPanel getConteneurNom()
	{
		JPanel pnlnompers = new JPanel();
		pnlnompers.add(nompers);
		return pnlnompers;
	}
	
	private JPanel getConteneurPrenom()
	{
		JPanel pnlprenompers = new JPanel();
		pnlprenompers.add(prenompers);
		return pnlprenompers;
	}
	
	private JPanel getConteneurMail()
	{
		JPanel pnlmailpers = new JPanel();
		pnlmailpers.add(mailpers);
		return pnlmailpers;
	}
	
	private JPanel getConteneurEquipe()
	{
		JPanel pnlequipepers = new JPanel();
		pnlequipepers.add(listequipepers);
		return pnlequipepers;
	}
	
	private JPanel getConteneurComp()
	{
		JPanel pnlcomppers = new JPanel();
		pnlcomppers.add(listcomppers);
		return pnlcomppers;
	}
	
	private JPanel getConteneurPrincipal()
	{
		JPanel conteneur = new JPanel();
		JLabel labelnompers = new JLabel("Saisissez le nom de la personne :");
		JLabel labelprenompers = new JLabel("Saisissez le prénom de la personne :");
		JLabel labelmailpers = new JLabel("Saisissez le mail de la personne :");
		JLabel labelequipepers = new JLabel("Dans quelles équipes cette personne fait partie ?");
		JLabel labelcomppers = new JLabel("Dans quelles compétitions cette personne est inscrite ? :");
		
		
		conteneur.add(labelnompers);
		conteneur.add(getConteneurNom());
		conteneur.add(labelprenompers);
		conteneur.add(getConteneurPrenom());
		conteneur.add(labelmailpers);
		conteneur.add(getConteneurMail());
		conteneur.add(labelequipepers);
		conteneur.add(getConteneurEquipe());
		conteneur.add(labelcomppers);
		conteneur.add(getConteneurComp());
		
		JButton btnAjouterPersonne = new JButton("Ajouter");
		conteneur.add(btnAjouterPersonne);
		btnAjouterPersonne.addActionListener(ajouterPersonneAction());
		
		return conteneur;
		

	}
	
	private ActionListener ajouterPersonneAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				setVisible(false);
				String nompersonne = nompers.getText();
				String prenompersonne = prenompers.getText();
				String mailpersonne = mailpers.getText();
				
				Personne pers = inscriptions.createPersonne(nompersonne, prenompersonne, mailpersonne);
				
				fenetrePers.mettreAJourPersonnes();
				fenetrePers.setVisible(true);
				try 
				{
					inscriptions.sauvegarder();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		};
	}
	
	public FenetreAjoutPers(Inscriptions inscriptions, FenetrePers fenetrePers)
	{
		this.inscriptions = inscriptions;
		this.fenetrePers = fenetrePers;
		setTitle("Ajout d'une personne");
		setSize(800,400);
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
				fenetrePers.setVisible(true);
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
