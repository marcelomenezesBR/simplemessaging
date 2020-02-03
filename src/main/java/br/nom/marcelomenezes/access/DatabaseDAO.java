package br.nom.marcelomenezes.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import br.nom.marcelomenezes.core.ConfigurationHelper;
import br.nom.marcelomenezes.model.Message;

public class DatabaseDAO {
	
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
