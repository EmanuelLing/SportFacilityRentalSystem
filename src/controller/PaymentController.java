package controller;

import model.Payment;
import model.Reservation;
import database.MyDatabase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaymentController {

	public void addPayment(Payment payment) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "INSERT INTO payment (PaymentID, ReservationID, Amount, PaymentDate, PaymentMethod) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1,  Integer.parseInt(payment.getPaymentId()));
		preparedStatement.setInt(2, Integer.parseInt(payment.getReservation().getReservationId()));
		preparedStatement.setDouble(3, payment.getAmount());
		preparedStatement.setDate(4, Date.valueOf(payment.getPaymentDate()));
		preparedStatement.setString(5, payment.getPaymentMethod());
		
		preparedStatement.executeUpdate();
		
		conn.close();
	}
	
	public boolean checkPayment(Reservation reservation, Payment payment) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "SELECT PaymentId, Amount, PaymentDate, PaymentMethod "
				+ "FROM payment WHERE ReservationID = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, reservation.getReservationId());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if (resultSet.next())
		{
			payment.setPaymentId(resultSet.getString(1));
			payment.setReservation(reservation);
			payment.setAmount(Double.valueOf(resultSet.getString(2)));
			payment.setPaymentDate(resultSet.getString(3));
			payment.setPaymentMethod(resultSet.getString(4));
			
			conn.close();
			return true;
		}
		else
		{
			conn.close();
			return false;
		}
	}
	
	public void updatePayment(Payment payment) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "UPDATE payment SET Amount = ?, PaymentDate = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, String.valueOf(payment.getAmount()));
		preparedStatement.setString(2, payment.getPaymentDate());
		preparedStatement.executeUpdate();
		
		conn.close();
	}
	
	public void deletePayment(Payment payment) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "DELETE FROM payment WHERE PaymentID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, payment.getPaymentId());
		preparedStatement.executeUpdate();
		
		conn.close();
	}
}
