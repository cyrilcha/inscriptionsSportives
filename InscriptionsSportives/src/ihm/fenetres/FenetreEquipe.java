package ihm.fenetres;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import inscriptions.Equipe;
import inscriptions.Inscriptions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FenetreEquipe extends JFrame
{
	private static final long serialVersionUID = -2424481175712954740L;
	private Inscriptions inscriptions;
	private JTable table;
	JFrame fenetreParent;
	
	private List<Equipe> getEquipes()
	{
		return new ArrayList<>(inscriptions.getEquipes());
	}
	
	public void mettreAJourEquipes()
	{
		List<Equipe> equipes = getEquipes();
		table.setModel(getEquipesTableModel(equipes));
	}
	
	private TableModel getEquipesTableModel(final List<Equipe> equipes)
	{
		return new TableModel() 
		{
			@Override
			public int getRowCount() {
				return equipes.size();
			}

			@Override
			public int getColumnCount() {
				return 1;
			}

			@Override
			public String getColumnName(int columnIndex) {
				switch (columnIndex)
				{
					case 0 : return "Nom";
				}
				return null;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex)
				{
					case 0 : return String.class;
				}
				return null;
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch (columnIndex)
				{
					case 0 : return equipes.get(rowIndex).getNom();
				}
				return null;
				
			}

			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {				
			}

			@Override
			public void addTableModelListener(TableModelListener l) {
			}
			

			@Override
			public void removeTableModelListener(TableModelListener l) {
			}
		};
	}
	
	private JTable getEquipeTable()
	{
		table  = new JTable(getEquipesTableModel(getEquipes()));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(300, 250));	
		return table;
	}
	
	private ActionListener getFenetreAjouterEquipeAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreAjoutEquipe fenetreajoutequipe = new FenetreAjoutEquipe(inscriptions, FenetreEquipe.this);
				fenetreajoutequipe.setVisible(true);
			}
			
		};
	}
	
	private ActionListener SupprimerEquipeAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				inscriptions.remove(getEquipes().get(table.getSelectedRow()));
				mettreAJourEquipes();
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
		JButton btnaddequ = new JButton("Ajouter une équipe");
		JButton btnsupprequ = new JButton("Supprimer une équipe");
		JPanel conteneur = new JPanel();
		conteneur.add(btnaddequ);
		conteneur.add(btnsupprequ);
		conteneur.add(add(new JScrollPane(getEquipeTable())));
		btnaddequ.addActionListener(getFenetreAjouterEquipeAction());
		btnsupprequ.addActionListener(SupprimerEquipeAction());
		return conteneur;
	}
	
	public FenetreEquipe(Inscriptions inscriptions, JFrame fenetreParent)
	{
		this.inscriptions = inscriptions;
		this.fenetreParent = fenetreParent;
		setTitle("Menu des équipes");
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
	
}
