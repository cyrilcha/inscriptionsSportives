package bdd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.mysql.jdbc.PreparedStatement;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;


public class connect {

	private String host = "jdbc:mysql://mysql.m2l.local/jgautier";
	private String username = "jgautier";
	private String password = "e8jfUEsg";
	private Connection connec = null;
	private Statement statement = null;
	java.sql.PreparedStatement prepare = null;
	ResultSet resultat = null;
	String query;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


     //Créé connexion à la BD

	public connect() {
		try {
			connec = DriverManager.getConnection(host, username, password);
			System.out.println("Good");
			statement =  connec.createStatement();
		}
		catch (Exception e) {
			System.out.println("Problème de connexion");
		}
	}


	 //Initialise l'inscription avec BD

	public void getBaseD(Inscriptions inscription) throws SQLException {
		getPersonnes(inscription);
		getEquipes(inscription);
		getCompet(inscription);
		getPersonnesEquipes(inscription);
		getParticipCompet(inscription);
		System.out.println(Inscriptions.getInscriptions().toString());

	}



	private void getPersonnesEquipes(Inscriptions inscription) {
		try {
			resultat = statement.executeQuery("call SelectPersoEquipe() ");

			while(resultat.next()){
				for (Candidat candi : inscription.getCandidats()){
					if(candi.getNom().equals(resultat.getString("nompersonne"))&& candi instanceof Personne){
						for (Candidat equipe : inscription.getCandidats()){

							if(equipe.getNom().equals(resultat.getString("nomcandidat")) && equipe instanceof Equipe)
							 ((Equipe) equipe).add((Personne) candi);
						}
					}
				}
			}
		}


		catch (SQLException e) {
			e.printStackTrace();
		}
	}



	private void getPersonnes(Inscriptions inscription) throws SQLException{
		resultat = statement.executeQuery("call SelectCandiPerso()");
		while (resultat.next()) {
			inscription.createPersonne(resultat.getString("nomcandidat"), resultat.getString("nompersonne"), resultat.getString("mailpersonne"));
		}
	}


	private void getEquipes(Inscriptions inscription) throws SQLException{
		resultat = statement.executeQuery("call SelectCandiEquipe()");
		while (resultat.next()) {
			inscription.createEquipe(resultat.getString("nomcandidat"));
		}
	}



	private void getCompet(Inscriptions inscription) throws SQLException{
		resultat = statement.executeQuery("call SelectCompet()");
		while (resultat.next()) {
			LocalDate date = LocalDate.parse(resultat.getString("datecloture"), formatter);
			inscription.createCompetition(resultat.getString("nomcompet"), date, resultat.getBoolean("enequipe"));
		}
	}


	// Affiche toutes les compétitions ainsi que les participants des disciplines respectifs

	private void getParticipCompet(Inscriptions inscription) {
		try {
			Statement statement = connec.createStatement();
			ResultSet resultat = statement.executeQuery("call SelectPartiCompet()");
			while(resultat.next()){
				for (Competition compet : inscription.getCompetitions()) {
					//System.out.println(resultat.getString("nomcompet") + " " + compet.getNom() + " " + compet.getNom().equals(resultat.getString("nomcompet" )));
					if (compet.getNom().equals(resultat.getString("nomcompet"))){
						for (Candidat candi : inscription.getCandidats()){
							//System.out.println(resultat.getString("nomcandidat") + " " + candi.getNom() + " " + candi.getNom().equals(resultat.getString("nomcandidat")));
							//System.out.println(compet.getNom() + " " + compet.estEnEquipe());
							if (candi.getNom().equals(resultat.getString("nomcandidat"))){
								System.out.println(candi.getNom() + " " + compet.getNom());
								if (compet.estEnEquipe()) {
									compet.add((Equipe) candi);
								}
								else {
									compet.add((Personne) candi);
								}
							}
						}
					}
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}



	public void AjoutEquipe(String nomcandidat){
		try {
			query = "call AjoutEquipe(?)";
			prepare = connec.prepareStatement(query);
			prepare.setString(1, nomcandidat);
			prepare.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void AjoutPersonne(String nomcandidat, String nompersonne, String mailpersonne) {
		try {
			query = "call AjoutPersonne(?,?,?)";
			prepare = connec.prepareStatement(query);
			prepare.setString(1, nomcandidat);
			prepare.setString(2, nompersonne);
			prepare.setString(3, mailpersonne);
			prepare.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void AjoutCompetition(String nomcompet, LocalDate dateCloturec, boolean enEquipe) {
		try {
			query = "call AjoutCompet(?,?,?)";
			prepare = connec.prepareStatement(query);
			prepare.setString(1, nomcompet);
			prepare.setDate(2,Date.valueOf(dateCloturec));
			prepare.setBoolean(3,enEquipe);
			prepare.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void RetireCompet(String nomc) {
		try {
			query = "call SupprimeCompet('"+nomc+"')";
			statement.executeQuery(query);

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void RetirePersonne(String mailp) {

		query = "call SupprimePersonne('"+mailp+"')";
		try {
			statement.executeQuery(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void RetireEquipe(String nome) {

		query = "call SupprimeEquipe('"+nome+"')";
		try {
			statement.executeQuery(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void InscritCandidaCompet(Candidat candidat, Competition competition) {
		try {
					query = "call AjoutCandiCompet(?,?)";
					prepare = connec.prepareStatement(query);
					prepare.setString(1 ,candidat.getNom());
					prepare.setString(2, competition.getNom());
					prepare.executeQuery();

		}
		catch (SQLException e) {
			//e.printStackTrace();
		}
	}


	public void AjoutCandiDansEquipe(String nomp, String mailp) {
		try {
			query = "call AjoutPersonneEquipe(?,?)";
			prepare = connec.prepareStatement(query);
			prepare.setString(2,nomp);
			prepare.setString(1, mailp);
			prepare.executeQuery();
		}
		catch (SQLException e) {
			//e.printStackTrace();
		}
	}

	
	public void EnlevePersonneEquipe(Personne personne, Equipe equipe)
	{
		try
		{
			query = "call SupprimePersonneEquipe(?,?)";
			prepare = connec.prepareStatement(query);
			prepare.setString(1, personne.getNom());
			prepare.setString(2,equipe.getNom());

			prepare.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	
	public void EnleveCandidatCompetition(Candidat candidat, Competition competition) {
		try
		{
				query = "call SupprimeCandidatCompet(?,?)";
				prepare = connec.prepareStatement(query);
				prepare.setString(1, candidat.getNom() );
				prepare.setString(2,competition.getNom());
			prepare.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}



	public void ModificationNomCompet(Competition compet, String nomc) {
		try {
			query = "call ModifCompetition(?,?)";
			prepare = connec.prepareStatement(query);
			prepare.setString(2,compet.getNom());
			prepare.setString(1, nomc);
			prepare.executeQuery();
		}
		catch (SQLException e) {
			//e.printStackTrace();
		}
	}

	public void ModificationDateCompet(LocalDate dateclot, LocalDate dateclo, String nomco) {
		try {
			query = "call ModifDateCompetition(?,?,?)";
			prepare = connec.prepareStatement(query);
			prepare.setDate(1,Date.valueOf(dateclot));
			prepare.setDate(2, Date.valueOf(dateclo));
			prepare.setString(3, nomco);
			prepare.executeQuery();
		}
		catch (SQLException e) {
			//e.printStackTrace();
		}
	}


	public void ModificationMailCandidat(Candidat candidat, String mailp) {
		try {
			if (candidat instanceof Personne){
				query = "call ModifPersonne(?,?)";
				prepare = connec.prepareStatement(query);
				prepare.setString(2,((Personne)candidat).getMail());
				prepare.setString(1, mailp);
			}
			prepare.executeQuery();
		}
		catch (SQLException e) {
			//e.printStackTrace();
		}
	}


		public void ModificationNomPersonne(Candidat candidat, String nomp) {
			try {
				if (candidat instanceof Personne){
					query = "call ModificationNomPersonne(?,?)";
					prepare = connec.prepareStatement(query);
					prepare.setString(2,((Personne)candidat).getPrenom());
					prepare.setString(1, nomp);
				}
				prepare.executeQuery();
			}
			catch (SQLException e) {
				//e.printStackTrace();
			}
		}


		public void ModificationPrenomPersonne(Candidat candidat, String prenomp) {
			try {
				if (candidat instanceof Personne){
					query = "call ModificationNomPersonne(?,?)";
					prepare = connec.prepareStatement(query);
					prepare.setString(2,((Personne)candidat).getNom());
					prepare.setString(1, prenomp);
				}
					prepare.executeQuery();
				}
				catch (SQLException e) {
					//e.printStackTrace();
				}
				}
}
