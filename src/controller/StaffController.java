package controller;

import database.MyDatabase;
import model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StaffController {
	
	public StaffController() {}
	
	public boolean staffLogin(Staff staff) throws ClassNotFoundException, SQLException {
		Connection conn = MyDatabase.doConnection();
		
		String sql = "SELECT StaffId, Name, PhoneNum, EmailAddress "
				+ "FROM staff WHERE username = ? and password = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, staff.getUsername());
		preparedStatement.setString(2, staff.getPassword());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next())
		{
			staff.setStaffId(resultSet.getString(1));;
			staff.setName(resultSet.getString(2));
			staff.setPhoneNum(resultSet.getString(3));
			staff.setEmailAddress(resultSet.getString(4));
			conn.close();
			return true;
		}
		else
		{
			conn.close();
			return false;
		}
	}
}
