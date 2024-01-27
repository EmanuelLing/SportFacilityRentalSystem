package view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;

import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.*;

import controller.ReportAnalysisController;

public class ReportAnalysisView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frmReportAnalysis;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportAnalysisView window = new ReportAnalysisView();
					window.frmReportAnalysis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReportAnalysisView()
	{
		initialize();
		frmReportAnalysis.setVisible(true);
	}
	
	public void initialize()
	{
		frmReportAnalysis = new JFrame();
		frmReportAnalysis.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReportAnalysis.setTitle("Monthly Rental Cost Chart");
		frmReportAnalysis.setSize(800, 600);
        
        ReportAnalysisController reportAnalysisController = new ReportAnalysisController();
        CategoryDataset dataset = null;
		try {
			dataset = reportAnalysisController.createDataset();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        JFreeChart barChart = createBarChart(dataset);

        ChartPanel chartPanel = new ChartPanel(barChart);
        frmReportAnalysis.getContentPane().add(chartPanel);
	}
	
    private JFreeChart createBarChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Monthly Rental Cost",
                "Month",
                "Total Cost",
                dataset
        );

        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return barChart;
    }
}
