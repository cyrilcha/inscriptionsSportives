package ihm;

import javax.swing.*;
import ihm.fenetres.FenetrePrincipale;
import inscriptions.Inscriptions;

public class Interface extends JFrame
{
	private static final long serialVersionUID = -2424481175712954740L;
	private Inscriptions inscriptions;
	
	public Interface(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;
	}
	
	public static void main(String[] args)
	{
		FenetrePrincipale fenetreprincipale = new FenetrePrincipale(Inscriptions.getInscriptions());
		fenetreprincipale.setVisible(true);
	}
	
	
}
