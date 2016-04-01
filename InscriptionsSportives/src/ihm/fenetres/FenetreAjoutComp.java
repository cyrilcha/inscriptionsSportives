package ihm.fenetres;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import inscriptions.Inscriptions;
import inscriptions.Competition;

import java.time.LocalDate;

public class FenetreAjoutComp extends JFrame
{
	
	private JPanel conteneur = new JPanel();
	
	private JTextField nomcomp = new JTextField(20);
	private JLabel labelnomcomp = new JLabel("Saisissez le nom de la compétition :");
	
	private JLabel labeldatecomp = new JLabel("Saisissez la date de clôture de la compétition :");
	private JTextField jourcomp = new JTextField(2);
	private JTextField moiscomp = new JTextField(2);
	private JTextField anneecomp = new JTextField(3);
	private JPanel pnldatecomp = new JPanel();
	
	private JRadioButton radiobtnind = new JRadioButton("inscriptions indivuelles");
	private JRadioButton radiobtnequ = new JRadioButton("inscriptions en équipe");
	private JPanel pnlequipecomp = new JPanel();
	
	private JButton btnvalid = new JButton("Ajouter");

	private Inscriptions inscriptions;
	
	public FenetreAjoutComp(Inscriptions inscriptions)
    {
		this.inscriptions = inscriptions;
    }
	

	public FenetreAjoutComp()
	{
		setTitle("Ajout d'une compétition");
		setSize(400,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		conteneur.add(labelnomcomp);
		conteneur.add(nomcomp);
		
		conteneur.add(labeldatecomp);
		pnldatecomp.add(jourcomp);
		pnldatecomp.add(new JLabel("/"));
		pnldatecomp.add(moiscomp);
		pnldatecomp.add(new JLabel("/"));
		pnldatecomp.add(anneecomp);
		conteneur.add(pnldatecomp);
		
		pnlequipecomp.add(radiobtnind);
		pnlequipecomp.add(radiobtnequ);
		conteneur.add(pnlequipecomp);
		ButtonGroup equipebtn = new ButtonGroup();
		equipebtn.add(radiobtnind);
		equipebtn.add(radiobtnequ);
		

		conteneur.add(btnvalid);
		
		setContentPane(conteneur);
		
		btnvalid.addActionListener(new ActionListener()
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
				
				DefaultListModel listModel = new DefaultListModel();
				
				listModel.addElement(comp);
				
				JList list = new JList(listModel);
				list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
				list.setVisibleRowCount(-1);
				JScrollPane listScroller = new JScrollPane(list);
				listScroller.setPreferredSize(new Dimension(250, 80));
			}
			
		});
		
	}

;}
