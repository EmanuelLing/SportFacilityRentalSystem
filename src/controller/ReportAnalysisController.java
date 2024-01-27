package controller;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.MyDatabase;

public class ReportAnalysisController {

	public CategoryDataset createDataset() throws ClassNotFoundException, SQLException
	{
		Connection conn = MyDatabase.doConnection();
		
        String sql = "SELECT PaymentDate, SUM(Amount) AS rental_cost " +
                "FROM payment " +
                "GROUP BY YEAR(PaymentDate), MONTH(PaymentDate)";
        
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        while (resultSet.next())
        {
            Date rentalDate = resultSet.getDate(1);
            double rentalCost = resultSet.getDouble(2);

            String monthYear = new SimpleDateFormat("MMM yyyy").format(rentalDate);
            dataset.addValue(rentalCost, "Total Rental Cost", monthYear);
        }
		conn.close();
		return dataset;
	}
}
