package br.nom.marcelomenezes.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import br.nom.marcelomenezes.core.ConfigurationHelper;

/**
 * Data Access class to MySQL.
 * Connection information is stored in properties file.
 * It is accessed by helper ConfigurationHelper.
 */
public class DatabaseDAO {
	

	/**
	 * Method to insert a message into database
	 * @param message - json string of message
	 */
	public void insertMessage(String message) {
	    try
	    {
	    	
	      Properties projectProps = ConfigurationHelper.getProperties();
	      // create a mysql database connection
	      String myDriver = projectProps.getProperty("databaseDriver");
	      String myUrl = "jdbc:mysql://" + projectProps.getProperty("databaseServer")+"/" + projectProps.getProperty("databaseSchema");
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, projectProps.getProperty("databaseUser"), projectProps.getProperty("databasePassword"));
	      
	      Statement st = conn.createStatement();

	      // insert statement
	      st.executeUpdate("INSERT INTO messages (message) "
	          +"VALUES ('" + message +"')");

	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
	}
}
