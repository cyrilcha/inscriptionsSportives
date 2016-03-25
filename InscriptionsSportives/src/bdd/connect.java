package bdd;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class connect {
	
	private String url = "jdbc:mysql://mysql.m2l.local/jgautier";
	private String user = "jgautier";
	private String passwd = "";
	private Connection conn = null;
	private Statement statement = null;
	private boolean initialisation = false;
	java.sql.PreparedStatement prepare = null;
	ResultSet result = null;
	String query;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	public boolean getInitialisation()
	{
		return initialisation;
	}
    
	
	public connect() 
	{
		try 
		{
			conn = DriverManager.getConnection(url, user, passwd);
			statement =  conn.createStatement();
		} 
		catch (Exception e) 
		{
			System.out.println("problème de connexion à la base de données");
		}
	}
	

	public Inscriptions getBase(Inscriptions inscription)
	{
		this.initialisation = true;
		inscription = getPersonnes(inscription);
		inscription = getEquipes(inscription);
		inscription = getCompetitions(inscription);
		inscription = getJoueursEquipes(inscription);
		inscription = getParticipantsCompetitions(inscription);
		this.initialisation = false;
		return inscription;
		
	}
	
	private Inscriptions getParticipantsCompetitions(Inscriptions inscription) 
	{
	
	}
	
	private Inscriptions getJoueursEquipes(Inscriptions inscription) 
	{
		
	}
	
	private Inscriptions getPersonnes(Inscriptions inscription)
	{
		
	}
	
	private Inscriptions getEquipes(Inscriptions inscription)
	{
		
	}
	
	private Inscriptions getCompetitions(Inscriptions inscription)
	{
		
	}
	
	public void ajoutEquipe(String nom)
	{
		
	}

	public void ajoutPersonne(String nom, String prenom, String mail)
	{
		
	}
	
	public void ajoutCompetition(String nom, LocalDate dateCloture, boolean enEquipe)
	{
		
	}
	
	public void retirerCompetition(String nom) 
	{
		
	}
	
	public void retirerPersonne(String mail) 
	{
	
	}
	
	public void retirerEquipe(String nom) 
	{
		
	}
	
	public void retirerPersonneEquipe(String mail, String nom) 
	{
		
	}
	}
	
	}
}
		
	