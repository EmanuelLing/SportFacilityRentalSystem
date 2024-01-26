package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase {
	static Connection conn=null;
	public static Connection doConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sport_facility_rental_system","root","");
		return conn;
	}
}
