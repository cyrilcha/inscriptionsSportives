package ihm.fenetres;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import inscriptions.Personne;
import inscriptions.Inscriptions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FenetrePers extends JFrame
{
	private static final long serialVersionUID = -2424481175712954740L;
	private Inscriptions inscriptions;
	private JTable table;
	JFrame fenetreParent;
	
	private List<Personne> getPersonnes()
	{
		return new ArrayList<>(inscriptions.getPersonnes());
	}
	
	public void mettreAJourPersonnes()
	{
		List<Personne> personnes = getPersonnes();
		table.setModel(getPersonnesTableModel(personnes));
	}
	
	private TableModel getPersonnesTableModel(final List<Personne> personnes)
	{
		return new TableModel() 
		{
			@Override
			public int getRowCount() {
				return personnes.size();
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
					case 1 : return "Prénom";
					case 2 : return "E-mail";
				}
				return null;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex)
				{
					case 0 : return String.class;
					case 1 : return String.class;
					case 2 : return String.class;
				}
				return null;
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return true;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch (columnIndex)
				{
					case 0 : return personnes.get(rowIndex).getNom();
					case 1 : return personnes.get(rowIndex).getPrenom();
					case 2 : return personnes.get(rowIndex).getMail();
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
	
	private JTable getPersonneTable()
	{
		table  = new JTable(getPersonnesTableModel(getPersonnes()));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(300, 250));	
		return table;
	}
	
	private ActionListener getFenetreAjouterPersonneAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				FenetreAjoutPers fenetreajoutpers = new FenetreAjoutPers(inscriptions, FenetrePers.this);
				fenetreajoutpers.setVisible(true);
			}
			
		};
	}
	
	private ActionListener SupprimerPersonneAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				inscriptions.remove(getPersonnes().get(table.getSelectedRow()));
				mettreAJourPersonnes();
				try 
				{
					inscriptions.sauvegarder();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
	}
	
	private ActionListener ModifierPersonneAction()
	{
		return new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mettreAJourPersonnes();
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
		JButton btnaddpers = new JButton("Ajouter une personne");
		JButton btnsupprpers = new JButton("Supprimer une personne");
		//JButton btnmodifpers = new JButton("Modifier une personne");
		JPanel conteneur = new JPanel();
		conteneur.add(btnaddpers);
		conteneur.add(btnsupprpers);
		//conteneur.add(btnmodifpers);
		conteneur.add(add(new JScrollPane(getPersonneTable())));
		btnaddpers.addActionListener(getFenetreAjouterPersonneAction());
		btnsupprpers.addActionListener(SupprimerPersonneAction());
		//btnmodifpers.addActionListener(ModifierPersonneAction());
		return conteneur;
	}
	
	public FenetrePers(Inscriptions inscriptions, JFrame fenetreParent)
	{
		this.inscriptions = inscriptions;
		this.fenetreParent = fenetreParent;
		setTitle("Menu des personnes");
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
