package ihm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.Dimension;

import ihm.fenetres.FenetrePrincipale;
import inscriptions.Inscriptions;

public class Interface extends JFrame
{
	private Inscriptions inscriptions;
	
	public Interface(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;
	}
	
	public static void main(String[] args)
	{
		FenetrePrincipale fenetremainmenu = new FenetrePrincipale(Inscriptions.getInscriptions());
		fenetremainmenu.setVisible(true);
	}
	
	
}
