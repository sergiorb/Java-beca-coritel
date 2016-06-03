/**
 * 	@file DB.java
 *	@author Sergio Romero Barra
 *
 */

package com.sergiorb.java_beca_coritel.ud12.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Main class */
public class DB {
	
	private String controllerString; // Stores mysql driver string.
	private String hostURL; // DB server url: Ex.: 192.168.1.2.
	private String databaseName; // DB name.
	private String url; // Final DB url connection string.
	private String dbUser; // DB user name.
	private String dbPassword; // DB password name.
	private int verbosityLevel; // DB object verbosity.
	private Connection connection; // DB connection object.
	
	/** @constructor Main constructor */
	public DB(String hostURL, String databaseName, String dbUser, String dbPassword) throws 
	InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		this.setControllerString("com.mysql.jdbc.Driver");
		this.setHostURL(hostURL);
		this.setDatabaseName(databaseName);
		this.setDbUser(dbUser);
		this.setDbPassword(dbPassword);
		this.setHostURL(hostURL);
		this.setVerbosityLevel(3);
		// Generates and sets db connection url.
		this.setUrl(String.format("jdbc:mysql://%s/%s", this.getHostURL(), this.getDatabaseName()));
	}
	
	/** @constructor Main constructor */
	public DB(String hostURL, String databaseName, String dbUser, String dbPassword, int verbosityLevel) throws 
	InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		this.setControllerString("com.mysql.jdbc.Driver");
		this.setHostURL(hostURL);
		this.setDatabaseName(databaseName);
		this.setDbUser(dbUser);
		this.setDbPassword(dbPassword);
		this.setHostURL(hostURL);
		this.setVerbosityLevel(verbosityLevel);
		// Generates and sets db connection url.
		this.setUrl(String.format("jdbc:mysql://%s/%s", this.getHostURL(), this.getDatabaseName()));
	}
	
	/* Find a way to pass any type of controller
	public DB(String controler, String hostURL, String databaseName) throws 
	InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		this.setControllerString("com.mysql.jdbc.Driver");
		this.setHostURL(hostURL);
		this.setDatabaseName(databaseName);
		this.setDbUser(dbUser);
		this.setDbPassword(dbPassword);
		this.setHostURL(hostURL);
		
		// Generates and sets db connection url.
		this.setUrl(String.format("jdbc:mysql://%s/%s", this.getHostURL(), this.getDatabaseName()));
	}*/

	/** @return the controller */
	public String getControllerString() {
		return controllerString;
	}

	/** @param controller the controller to set */
	private void setControllerString(String controllerString) {
		this.controllerString = controllerString;
	}

	/** @return the dbHost */
	public String getHostURL() {
		return hostURL;
	}

	/** @param dbHost the dbHost to set */
	private void setHostURL(String hostURL) {
		this.hostURL = hostURL;
	}

	/** @return the databaseName */
	public String getDatabaseName() {
		return databaseName;
	}

	/** @param databaseName the databaseName to set */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	/** return the url */
	public String getUrl() {
		return url;
	}
	
	/** @param url the url to set */
	private void setUrl(String url) {
		this.url = url;
	}
	
	/** @return the dbUser */
	public String getDbUser() {
		return dbUser;
	}

	/** @param dbUser the dbUser to set */
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	
	/** @return the password */
	public String getDbPassword() {
		return dbPassword;
	}

	/** @param password the password to set */
	public void setDbPassword(String password) {
		this.dbPassword = password;
	}
	
	/** @return the verbosityLevel */
	public int getVerbosityLevel() {
		return verbosityLevel;
	}

	/** @param verbosityLevel the verbosityLevel to set */
	public void setVerbosityLevel(int verbosityLevel) {
		this.verbosityLevel = verbosityLevel;
	}

	/** @return the connection*/
	public Connection getConnection() {
		return connection;
	}

	/** @param connection the connection to set */
	private void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	/** @method Connects to db */
	public void Connect() throws SQLException, ClassNotFoundException {
		
		// If there is no connection object...
		if(this.getConnection() == null) {
			
			if(this.getVerbosityLevel()>=3){System.out.print("Connecting...");};
			
			// Saves a new connection object.
			this.setConnection(DriverManager.getConnection(this.getUrl(), this.getDbUser(), this.getDbPassword()));
	
			if(this.getVerbosityLevel()>=3){System.out.println("Connected!");};
		
		// A connection exists!!
		} else {
			if(this.getVerbosityLevel()>=3){System.out.println("Already connected!");};
		}
	}
	
	/** @method disconnects from db */
	public void Disconnect() throws SQLException {
		
		if(this.getConnection() != null) {
		
			if(this.getVerbosityLevel()>=3){System.out.printf("Disconecting...");};
		
			// Closes db connection.
			this.getConnection().close();
			this.setConnection(null);
			if(this.getVerbosityLevel()>=3){System.out.println("Disconected!");};
		} else {
			if(this.getVerbosityLevel()>=3){System.out.println("[DB][Warning] DB already disconected!!");};
		}
	}
}
