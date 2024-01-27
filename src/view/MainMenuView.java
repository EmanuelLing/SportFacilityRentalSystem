package view;

import model.Staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class MainMenuView extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmSfrsMenu;

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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-158, 0, 419, 321);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("img/34c3332cb8eb6c448bb4544cd7df4bcd.jpg"));
		
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
			
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(-129, -85, 613, 496);
		panel_1_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("img/5f42fa577d615e58b4ba2d4d54795f01.jpg"));
		
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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("img/37a5a812f7bd4e6a8174757dce3472cb.jpg"));
		lblNewLabel_2.setBounds(-195, -121, 613, 564);
		panel_1_2.add(lblNewLabel_2);
		
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
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("img/1474dd76d20d2bd7f997c4741cff0484.jpg"));
		lblNewLabel_3.setBounds(-154, 0, 444, 331);
		panel_1_3.add(lblNewLabel_3);
		
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
