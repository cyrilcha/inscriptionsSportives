package ihm.fenetres;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import inscriptions.Equipe;
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

public class FenetreAjoutEquipe extends JFrame 
{
	private static final long serialVersionUID = -2424481175712954740L;
	private JTextField nomequipe = new JTextField(20);
	
	private Inscriptions inscriptions;
	FenetreEquipe fenetreEquipe;
	
	public FenetreAjoutEquipe(Inscriptions inscriptions, FenetreEquipe fenetreEquipe)
	{
		this.inscriptions = inscriptions;
		this.fenetreEquipe = fenetreEquipe;
		setTitle("Ajout d'une équipe");
		setSize(800,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		//setContentPane(getConteneurPrincipal());
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
