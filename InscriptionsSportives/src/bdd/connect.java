package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connect {
	private String server, user, mdp, bdd;
	private Connection myConnection;
	
	public connect() {
	}
	
	public connect(String server, String user, String mdp, String bdd) {
		this.server = server;
		this.user = user;
		this.mdp = mdp;
		this.bdd = bdd;
	}
	
	public void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Absence de pilote.");
		}
	}
	
	public void connect() {
		this.loadDriver();
		String url = "mysql://"+this.server+"/"+this.bdd+"?allowMultiQueries=true";
		try {
			this.myConnection = DriverManager.getConnection("jdbc:"+url, this.user, this.mdp);
		} catch (SQLException exp) {
			System.out.println("Impossible de se connecter à "+url);
		}
	}
	
	public void disconnect() {
		try {
			if(this.myConnection != null)
				this.myConnection.close();
		} catch (SQLException exp) {
			System.out.println("Impossible de se déconnecter.");
		}
	}
	
	public Connection getConnection() {
		return this.myConnection;
	}

}