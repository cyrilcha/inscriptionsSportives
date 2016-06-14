package ihm.fenetres;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import inscriptions.Competition;
import inscriptions.Inscriptions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

public class FenetreComp extends JFrame
{
	private static final long serialVersionUID = -2424481175712954740L;
	private Inscriptions inscriptions;
	private JTable table;
	JFrame fenetreParent;
	
	private List<Competition> getCompetitions()
	{
		return new ArrayList<>(inscriptions.getCompetitions());
	}
	public void mettreAJourCompetitions()
	{
		List<Competition> competitions = getCompetitions();
		table.setModel(getCompetitionsTableModel(competitions));
	}
	
	private TableModel getCompetitionsTableModel(final List<Competition> competitions)
	{
		
		return new TableModel() 
		{

			@Override
			public int getRowCount() {
				return competitions.size();
			}

			@Override
			public int getColumnCount() {
				return 3;
			}

			@Override
			public String getColumnName(int columnIndex) {
				switch (columnIndex)
				{
					case 0 : return "Nom";
					case 1 : return "Date de clôture";
					case 2 : return "En équipe";
				}
				return null;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return true;
			}
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch (columnIndex)
				{
					case 0 : return competitions.get(rowIndex).getNom();
					case 1 : return competitions.get(rowIndex).getDateCloture().toString();
					case 2 : 
							if(competitions.get(rowIndex).estEnEquipe())
							{
								return "Oui";
							}
							else
							{
								return "Non";
							}
				}
				return null;
				
			}

			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
				switch(columnIndex)
				{
					case 1 : 
					{
						String pattern = "yyyy-MM-dd";
						DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
						LocalDate date = LocalDate.parse ((String)aValue, format);
						competitions.get(rowIndex).setDateCloture(date);
					}
				}	
			}

			@Override
			public void addTableModelListener(TableModelListener l) {
			}
			

			@Override
			public void removeTableModelListener(TableModelListener l) {
			}
		};
	}
	
	private JTable getCompetitionTable()
	{
		table  = new JTable(getCompetitionsTableModel(getCompetitions()));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(300, 250));	
		return table;
	}

	private ActionListener getFenetreAjouterCompetitionAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreAjoutComp fenetreajoutcomp = new FenetreAjoutComp(inscriptions, FenetreComp.this);
				fenetreajoutcomp.setVisible(true);
			}
			
		};
	}
	
	private ActionListener SupprimerCompetitionAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				inscriptions.remove(getCompetitions().get(table.getSelectedRow()));
				mettreAJourCompetitions();
			}
		};
	}
	
	
	private JPanel getConteneurPrincipal()
	{
		JButton btnaddcomp = new JButton("Ajouter une compétition");
		JButton btnsupprcomp = new JButton("Supprimer une compétition");
		JPanel conteneur = new JPanel();
		conteneur.add(btnaddcomp);
		conteneur.add(btnsupprcomp);
		conteneur.add(add(new JScrollPane(getCompetitionTable())));
		btnaddcomp.addActionListener(getFenetreAjouterCompetitionAction());
		btnsupprcomp.addActionListener(SupprimerCompetitionAction());
		return conteneur;
	}
	public FenetreComp(Inscriptions inscriptions, JFrame fenetreParent)
	{
		this.inscriptions = inscriptions;
		this.fenetreParent = fenetreParent;
		setTitle("Menu des compétitions");
		setSize(500,400);
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
				try {
					inscriptions.sauvegarder();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				fenetreParent.setVisible(true);
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

;}
