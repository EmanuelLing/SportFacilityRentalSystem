package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.MyDatabase;
import model.Customer;
import model.Reservation;

public class CustomerController {

	public ArrayList<Customer> ListoutCustomer() throws ClassNotFoundException, SQLException {
		ArrayList<Customer> customers = new ArrayList<Customer>(); 
		Connection conn = MyDatabase.doConnection();
		String sql = "SELECT CustomerID, Name FROM customer";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			Customer customer = new Customer();
			customer.setCustomerId(resultSet.getString(1));
			customer.setName(resultSet.getString(2));
			customers.add(customer);
		}
		
		conn.close();
		return customers;
	}
	
	public void registerNewCustomer(Customer customer) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "INSERT INTO customer (CustomerID, Name, PhoneNum, EmailAddress) VALUES (?, ?, ?, ?)";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, customer.getCustomerId());
		preparedStatement.setString(2, customer.getName());
		preparedStatement.setString(3, customer.getPhoneNum());
		preparedStatement.setString(4, customer.getEmailAddress());
		preparedStatement.executeUpdate();
		
		conn.close();
	}
	
	public boolean searchCustomer(Customer customer) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();

		String sql = "SELECT Name, PhoneNum, EmailAddress FROM customer WHERE CustomerID = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, customer.getCustomerId());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			customer.setName(resultSet.getString(1));
			customer.setPhoneNum(resultSet.getString(2));
			customer.setEmailAddress(resultSet.getString(3));
			
			conn.close();
			return true;
		}
		else
		{
			conn.close();
			return false;
		}
	}
	
	public void updateCustomer(Customer customer) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "UPDATE customer SET Name = ?, "
				+ "PhoneNum = ?, EmailAddress = ? WHERE CustomerID = ?";
		
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, customer.getName());
		preparedStatement.setString(2, customer.getPhoneNum());
		preparedStatement.setString(3, customer.getEmailAddress());
		preparedStatement.setString(4, customer.getCustomerId());
		preparedStatement.executeUpdate();
		
		conn.close();
	}
	
	public void deleteCustomer(Customer customer) throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
		String sql = "DELETE FROM customer WHERE CustomerID = ?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, customer.getCustomerId());
		preparedStatement.executeUpdate();
		
		conn.close();
	}
}
