package ihm.fenetres;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import inscriptions.Inscriptions;
import inscriptions.Competition;

import java.time.LocalDate;

public class FenetreAjoutComp extends JFrame
{
	
	private JTextField nomcomp = new JTextField(20);
	private JTextField jourcomp = new JTextField(2);
	private JTextField moiscomp = new JTextField(2);
	private JTextField anneecomp = new JTextField(3);
	
	private JRadioButton radiobtnind = new JRadioButton("inscriptions indivuelles");
	private JRadioButton radiobtnequ = new JRadioButton("inscriptions en équipe");
	

	private ListModel getCompetitionsListModel()
	{
		final List<Competition> competitions = new ArrayList<>(inscriptions.getCompetitions());
		
		ListModel listModel = new AbstractListModel<Competition>() {

			@Override
			public int getSize() 
			{
				return inscriptions.getCompetitions().size();
			}

			@Override
			public Competition getElementAt(int index) 
			{
				return competitions.get(index);
			}
		};
		
		return listModel;
	}
	
	
	private JList getCompetitionList()
	{
		JList list = new JList(getCompetitionsListModel());
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		return list;
	}
	
	
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
	
private Inscriptions inscriptions;
	
	public FenetreAjoutComp(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;
		setTitle("Ajout d'une compétition");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		setContentPane(getConteneurPrincipal());
		
		
		
		
	}

;}
