package bdd;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
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
	public static void main(String[] args) {      
	    try {
	      Class.forName("org.postgresql.Driver");
	      System.out.println("Driver O.K.");

	      String url = "jdbc:postgresql://http://mysql.m2l.local/jgautier";
	      String user = "jgautier";
	      String passwd = "";

	      Connection conn = (Connection) DriverManager.getConnection(url, user, passwd);
	      System.out.println("Connexion effective !");         
	         
	    } catch (Exception e) {
	      e.printStackTrace();
	    }      
	  }

}
