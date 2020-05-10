package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utility.ConnectionManager;

public class Databasedao {
	
	
   public void getAllUsers() throws ClassNotFoundException, SQLException {
		
		Statement st = ConnectionManager.getConnection().createStatement();

		ResultSet rs = st.executeQuery("select * from users");
		
		System.out.println("id"+"\t\t\t"+"name"+"\t\t\t"+"city"+"\t\t\t"+"contact"+"\t\t\t");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t\t\t");

		

		}

		
	}
}
