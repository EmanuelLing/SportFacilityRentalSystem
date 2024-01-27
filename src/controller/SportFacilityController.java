package controller;

import model.SportFacility;
import database.MyDatabase;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SportFacilityController {
	
	public ArrayList<SportFacility> ListoutSportFacility() throws ClassNotFoundException, SQLException {
		ArrayList<SportFacility> sportFacilities = new ArrayList<SportFacility>();
		Connection conn = MyDatabase.doConnection();
		String sql = "SELECT FacilityID, FacilityName, RentalCost FROM sport_facility";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			SportFacility sportFacility = new SportFacility();
			sportFacility.setFacilityId(resultSet.getString(1));
			sportFacility.setFacilityName(resultSet.getString(2));
			sportFacility.setRentalCost(Double.valueOf(resultSet.getString(3)));
			
			sportFacilities.add(sportFacility);
		}
		
		conn.close();
		return sportFacilities;
	}
	
	public void getSportFacilityById(SportFacility facility) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "SELECT FacilityName, Location, Capacity, RentalCost, FacilityType "
				+ "FROM sport_facility WHERE FacilityID = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, facility.getFacilityId());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next())
		{
			facility.setFacilityName(resultSet.getString(1));
			facility.setLocation(resultSet.getString(2));
			facility.setCapacity(resultSet.getString(3));
			facility.setRentalCost(Double.valueOf(resultSet.getString(4)));
			facility.getFacilityType().setFacilityType(resultSet.getString(5));
		}
		
		conn.close();
	}
}
