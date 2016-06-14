package inscriptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Set;
import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;

import bdd.connect;

/**
 * Point d'entrée dans l'application, un seul objet de type Inscription
 * permet de gérer les compétitions, candidats (de type equipe ou personne)
 * ainsi que d'inscrire des candidats à des compétition.
 */

public class Inscriptions implements Serializable
{
	private static final long serialVersionUID = -3095339436048473524L;
	private static final String FILE_NAME = "Inscriptions.srz";
	private static Inscriptions inscriptions;
	
	private SortedSet<Candidat> candidats = new TreeSet<>();
	
	
	/**
	 * Retourne les compétitions.
	 * @return
	 */
	
	public SortedSet<Competition> getCompetitions()
	{
		SortedSet<Competition> listComp = new TreeSet<Competition>();
		String request = "SELECT * FROM competition;";
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery(request);
			while (result.next()) {
				String nom = result.getString("nom");
				Date date = result.getDate("datecloture");
				LocalDate dateCloture = date.toLocalDate();
				boolean enEquipe = result.getBoolean("type");
				Competition comp = new Competition(this, nom, dateCloture, enEquipe);
				listComp.add(comp);
			}
			statement.close();
			result.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request);
		}
		connection.disconnect();
		return Collections.unmodifiableSortedSet(listComp);
	}
	
	/**
	 * Retourne tous les candidats (personnes et équipes confondues).
	 * @return
	 */
	
	public SortedSet<Candidat> getCandidats()
	{
		return Collections.unmodifiableSortedSet(candidats);
	}
	

	/**
	 * Retourne toutes les personnes.
	 * @return
	 */
	
	public SortedSet<Personne> getPersonnes()
	{
		SortedSet<Personne> listPers = new TreeSet<>();
		String request = "SELECT * FROM candidat, personne WHERE idCandidat = idPersonne;";
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery(request);
			while (result.next()) {
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String mail = result.getString("mail");
				Personne p = new Personne(this, nom, prenom, mail);
				for (Candidat c : getCandidats())
					listPers.add(p);
			}
			statement.close();
			result.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request);
		}
		connection.disconnect();
		
		return Collections.unmodifiableSortedSet(listPers);
	}


	/**
	 * Retourne toutes les équipes.
	 * @return
	 */
	
	public SortedSet<Equipe> getEquipes()
	{
		SortedSet<Equipe> listEquipes = new TreeSet<>();
		String request = "SELECT * FROM candidat, equipe WHERE idCandidat = idEquipe;";
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet result = statement.executeQuery(request);
			while (result.next()) {
				String nom = result.getString("nom");
				Equipe equ = new Equipe(this, nom);
				for (Candidat c : getCandidats())
					listEquipes.add(equ);
			}
			statement.close();
			result.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request);
		}
		connection.disconnect();
		return Collections.unmodifiableSortedSet(listEquipes);
	}
	
	

	/**
	 * Créée une compétition. Ceci est le seul moyen, il n'y a pas
	 * de constructeur public dans {@link Competition}.
	 * @param nom
	 * @param dateCloture
	 * @param enEquipe
	 * @return
	 */
	
	
	public void createCompetition(String nom, 
			LocalDate dateCloture, boolean enEquipe)
	{
		int equipe = 0;
		if (enEquipe)
			equipe = 1;
		String request = "INSERT INTO competition(nom, datecloture, type) VALUES (\""+nom+"\", \""+dateCloture+"\", \""+equipe+"\");";
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		System.out.println(request);
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request);
			System.out.println(exp);
		}
		connection.disconnect();
	}

	/**
	 * Créée une Candidat de type Personne. Ceci est le seul moyen, il n'y a pas
	 * de constructeur public dans {@link Personne}.

	 * @param nom
	 * @param prenom
	 * @param mail
	 * @return
	 */
	
	public void createPersonne(String nom, String prenom, String mail)
	{
		String request = "INSERT INTO candidat(nom) VALUES (\""+nom+"\");"
				+ " INSERT INTO personne(idPersonne, prenom, mail) VALUES ((SELECT idCandidat FROM candidat "
				+ "WHERE nom = \""+nom+"\"), \""+prenom+"\", \""+mail+"\");";
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		System.out.println(request);
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request);
			System.out.println(exp);
		}
		connection.disconnect();
	}
	
	/**
	 * Créée un Candidat de type équipe. Ceci est le seul moyen, il n'y a pas
	 * de constructeur public dans {@link Equipe}.
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @return
	 */
	
	public void createEquipe(String nom)
	{
		
		String request = "INSERT INTO candidat(nom) VALUES (\""+nom+"\");"
				+ " INSERT INTO equipe(idEquipe) (SELECT idCandidat FROM candidat WHERE nom = \""+nom+"\");";
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		System.out.println(request);
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request);
			System.out.println(exp);
		}
		connection.disconnect();
	}
	
	public void remove(Competition competition)
	{
		String nom = competition.getNom();
		String request = "DELETE FROM competition WHERE nom = \""+nom+"\";";
		System.out.println(request);
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request+" "+exp);
		}
		connection.disconnect();
	}
	
	public void remove(Equipe equipe)
	{
		String nom = equipe.getNom();
		String request = "DELETE FROM equipe WHERE idEquipe IN (SELECT idCandidat FROM Candidat WHERE nom = \""+nom+"\");"
				+ " DELETE FROM candidat WHERE nom = \""+nom+"\";";
		System.out.println(request);
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request+" "+exp);
		}
		connection.disconnect();
	}
	
	public void remove(Personne personne)
	{
		String nom = personne.getNom();
		String request = "DELETE FROM personne WHERE idPersonne IN (SELECT idCandidat FROM Candidat WHERE nom = \""+nom+"\");"
				+ " DELETE FROM candidat WHERE nom = \""+nom+"\";";
		System.out.println(request);
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request+" "+exp);
		}
		connection.disconnect();
	}
	
	public void modif(Competition competition)
	{
		String nom = competition.getNom();
		LocalDate dateCloture = competition.getDateCloture();
		boolean enEquipe = competition.estEnEquipe();
		String request = "UPDATE competition SET nom=  WHERE nom = \""+nom+"\" AND datecloture = \""+dateCloture+"\" "
				+ "AND type = \""+enEquipe+"\";";
		System.out.println(request);
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request+" "+exp);
		}
		connection.disconnect();
	}
	
	public void modif(Personne personne)
	{
		String nom = personne.getNom();
		String prenom = personne.getPrenom();
		String mail = personne.getMail();
		String request = "UPDATE competition SET nom=  WHERE nom = \""+nom+"\" AND prenom = \""+prenom+"\" "
				+ "AND mail = \""+mail+"\";";
		System.out.println(request);
		connect connection = new connect("mysql.m2l.local", "cchatin", "uEErXJ4b", "cchatin2");
		connection.connect();
		try {
			Statement myStatement = connection.getConnection().createStatement();
			myStatement.execute(request);
			myStatement.close();
		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requète : "+request+" "+exp);
		}
		connection.disconnect();
	}
	
	void remove(Candidat candidat)
	{
		candidats.remove(candidat);
	}
	
	/**
	 * Retourne l'unique instance de cette classe.
	 * Crée cet objet s'il n'existe déjà.
	 * @return l'unique objet de type {@link Inscriptions}.
	 */
	
	public static Inscriptions getInscriptions()
	{
		
		if (inscriptions == null)
		{
			inscriptions = readObject();
			if (inscriptions == null)
				inscriptions = new Inscriptions();
		}
		return inscriptions;
	}

	/**
	 * Retourne un object inscriptions vide. Ne modifie pas les compétitions
	 * et candidats déjà existants.
	 */
	
	public static Inscriptions reinitialiser()
	{
		inscriptions = new Inscriptions();
		return getInscriptions();
	}

	/**
	 * Efface toutes les modifications sur Inscriptions depuis la dernière sauvegarde.
	 * Ne modifie pas les compétitions et candidats déjà existants.
	 */
	
	public static Inscriptions recharger()
	{
		inscriptions = null;
		return getInscriptions();
	}
	
	private static Inscriptions readObject()
	{
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			return (Inscriptions)(ois.readObject());
		}
		catch (IOException | ClassNotFoundException e)
		{
			return null;
		}
		finally
		{
				try
				{
					if (ois != null)
						ois.close();
				} 
				catch (IOException e){}
		}	
	}
	
	/**
	 * Sauvegarde le gestionnaire pour qu'il soit ouvert automatiquement 
	 * lors d'une exécution ultérieure du programme.
	 * @throws IOException 
	 */
	
	public void sauvegarder() throws IOException
	{
		ObjectOutputStream oos = null;
		try
		{
			FileOutputStream fis = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fis);
			oos.writeObject(this);
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if (oos != null)
					oos.close();
			} 
			catch (IOException e){}
		}
	}
	
	/*public Set<Message> getMessages()
	{
		return Collections.unmodifiableSet(messages);
	}*/
	
	@Override
	public String toString()
	{
		return "Candidats : " + getCandidats().toString()
			+ "\nCompetitions  " + getCompetitions().toString();
	}
	
	public static void main(String[] args)
	{
		/*Inscriptions inscriptions = Inscriptions.getInscriptions();
		//Competition flechettes = inscriptions.createCompetition("Mondial de fléchettes", LocalDate.parse("2 016-12-31"), false);
		Personne cc = inscriptions.createPersonne("Chatin", "Cyril", "chatincyril@yahoo.fr"), 
				jb = inscriptions.createPersonne("Gautier", "Jean-Baptiste", "jeanbaptiste.odjango@gmail.com"),
				axel = inscriptions.createPersonne("Yahoudeou", "Axel", "axel.yahoudeou@gmail.com");
		//flechettes.add(tony);
		Equipe lesManouches = inscriptions.createEquipe("Les Manouches");
		lesManouches.add(boris);
		lesManouches.add(tony);
		System.out.println(inscriptions);
		lesManouches.delete();
		System.out.println(inscriptions);
		
		try
		{
			inscriptions.sauvegarder();
		} 
		catch (IOException e)
		{
			System.out.println("Sauvegarde impossible." + e);
		}*/
	}
}
