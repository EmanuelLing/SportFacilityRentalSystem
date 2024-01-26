package controller;

import model.Reservation;
import model.SportFacility;

import java.sql.Connection;
import java.util.*;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.MyDatabase;

public class ReservationController {
	
	public void addReservation(Reservation reservation) throws ClassNotFoundException, SQLException {
		Connection conn = MyDatabase.doConnection();
		
		String sql = "INSERT INTO reservation (ReservationID, CustomerID, FacilityID, "
				+ "ReservationDate, StartTime, EndTime, StaffID) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, Integer.parseInt(reservation.getReservationId()));
		preparedStatement.setInt(2, Integer.parseInt(reservation.getCustomer().getCustomerId()));
		preparedStatement.setString(3, reservation.getSportFacility().getFacilityId());
		preparedStatement.setDate(4, Date.valueOf(reservation.getReservationDate()));
		preparedStatement.setTime(5, Time.valueOf(reservation.getStartTime()));
		preparedStatement.setTime(6, Time.valueOf(reservation.getEndTime()));
		preparedStatement.setInt(7, Integer.parseInt(reservation.getStaff().getStaffId()));
		
		preparedStatement.executeUpdate();
		
		conn.close();
	}
	
	public Double calculateRentalCost(Reservation reservation)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		try {
			java.util.Date startTime = sdf.parse(reservation.getStartTime());
			java.util.Date endTime = sdf.parse(reservation.getEndTime());
			
            // Calculate the difference in milliseconds
            long timeDifferenceMillis = endTime.getTime() - startTime.getTime();

            // Convert milliseconds to hours
            long hoursDifference = TimeUnit.MILLISECONDS.toHours(timeDifferenceMillis);  
            
            return reservation.getSportFacility().getRentalCost() * hoursDifference;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return reservation.getSportFacility().getRentalCost();
		} 
	}
	
	public boolean searchReservation(Reservation reservation) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();

		String sql = "SELECT R.ReservationID, R.FacilityID, F.FacilityName, C.Name "
				+ "FROM customer C JOIN reservation R USING (CustomerID) JOIN sport_facility F "
				+ "USING (FacilityID) WHERE R.ReservationDate = ? AND R.CustomerID = ? "
				+ "AND R.StartTime = ? AND R.EndTime = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, reservation.getReservationDate());
		preparedStatement.setString(2, reservation.getCustomer().getCustomerId());
		preparedStatement.setString(3, reservation.getStartTime());
		preparedStatement.setString(4, reservation.getEndTime());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			reservation.setReservationId(resultSet.getString(1));
			reservation.getSportFacility().setFacilityId(resultSet.getString(2));
			reservation.getSportFacility().setFacilityName(resultSet.getString(3));
			reservation.getCustomer().setName(resultSet.getString(4));
			
			conn.close();
			return true;
		}
		else
		{
			conn.close();
			return false;
		}
	}
	
	public void updateReservation(Reservation reservation) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "UPDATE reservation SET ReservationDate = ?, "
				+ "StartTime = ?, EndTime = ? WHERE ReservationID = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, reservation.getReservationDate());
		preparedStatement.setString(2, reservation.getStartTime());
		preparedStatement.setString(3, reservation.getEndTime());
		preparedStatement.setString(4, reservation.getReservationId());
		preparedStatement.executeUpdate();
		
		conn.close();
	}
	
	public void deleteReservation(Reservation reservation) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "DELETE FROM reservation WHERE reservationID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, reservation.getReservationId());
		preparedStatement.executeUpdate();
		
		conn.close();
	}
}
