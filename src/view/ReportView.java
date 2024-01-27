package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ReportView {

	private JFrame frmReportPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportView window = new ReportView();
					window.frmReportPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReportView() {
		initialize();
		frmReportPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReportPage = new JFrame();
		frmReportPage.setTitle("Report Page");
		frmReportPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmReportPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 593, 602);
		frmReportPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblReport.setBounds(10, 10, 308, 63);
		panel.add(lblReport);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(478, 550, 105, 42);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add the search here
				new MainMenuView();
				frmReportPage.dispose();
			}
		});
		
		frmReportPage.setBackground(Color.WHITE);
		frmReportPage.setBounds(100, 100, 627, 659);
		frmReportPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
