package view;

import model.Staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;


public class MainMenuView extends JFrame 
{

	private JFrame frmSfrsMenu;
	private JButton btnFacilityReservation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuView window = new MainMenuView(new Staff());
					window.frmSfrsMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public MainMenuView(Staff staff) {
		initialize(staff);
		frmSfrsMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Staff staff) {
		frmSfrsMenu = new JFrame();
		frmSfrsMenu.getContentPane().setBackground(Color.DARK_GRAY);
		frmSfrsMenu.getContentPane().setLayout(null);
		frmSfrsMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmSfrsMenu.setTitle("SFRS MENU");
		frmSfrsMenu.setBounds(100, 100, 811, 389);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 772, 521);
		frmSfrsMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 180, 321);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Customer Registration");
		btnNewButton.setBounds(10, 269, 153, 42);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new CustomerMenuView();
			}
		});
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(200, 10, 180, 321);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnFacilityReservation = new JButton("Facility Reservation");
		btnFacilityReservation.setBounds(10, 269, 153, 42);
		panel_1_1.add(btnFacilityReservation);
		btnFacilityReservation.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new ReservationMenuView(staff);
			}
		});
		
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(390, 10, 180, 321);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnFacilityStatus = new JButton("Facility Status / Update");
		btnFacilityStatus.setBounds(10, 269, 153, 42);
		panel_1_2.add(btnFacilityStatus);
		btnFacilityStatus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new FacilityMenuView();
			}
		});
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(580, 10, 180, 321);
		panel.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JButton btnMonthlyReport = new JButton("Monthly Report");
		btnMonthlyReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new ReportAnalysisView();
			}
		});
		btnMonthlyReport.setBounds(10, 269, 153, 42);
		panel_1_3.add(btnMonthlyReport);
	}
}
