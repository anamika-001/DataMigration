package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		

				
		
		 
		        Connection conn = null;

		        try (FileInputStream f = new FileInputStream("db.properties")) {

		            // load the properties file
		            Properties pros = new Properties();
		            pros.load(f);

		            // assign db parameters
		            String url = pros.getProperty("url");
		            String user = pros.getProperty("user");
		            String password = pros.getProperty("password");
		            
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            // create a connection to the database
		            conn = DriverManager.getConnection(url, user, password);
		           // System.out.println("connected");
		        } catch (IOException e) {
		            System.out.println(e.getMessage());
		        }
		        return conn;
		    }


}
