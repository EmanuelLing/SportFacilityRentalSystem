import java.sql.SQLException;
import database.MyDatabase;
import java.sql.Connection;

public class MainProject {
	
	public static void main(String[] args) {
		try {
			Connection conn = MyDatabase.doConnection();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
	
	
}
