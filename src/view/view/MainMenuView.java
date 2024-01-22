package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;


public class MainMenuView implements ActionListener, KeyListener 
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
					MainMenuView window = new MainMenuView();
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
	public MainMenuView() {
		initialize();
		frmSfrsMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSfrsMenu = new JFrame();
		frmSfrsMenu.getContentPane().setBackground(Color.DARK_GRAY);
		frmSfrsMenu.getContentPane().setLayout(null);
		
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
			{}
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
				new ReservationMenuView();
			}
		});
		
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(390, 10, 180, 321);
		panel.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JButton btnFacilityStatus = new JButton("Facility Status / Update");
		btnFacilityStatus.setBounds(10, 269, 153, 42);
		panel_1_2.add(btnFacilityStatus);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(580, 10, 180, 321);
		panel.add(panel_1_3);
		panel_1_3.setLayout(null);
		
		JButton btnMonthlyReport = new JButton("Monthly Report");
		btnMonthlyReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{}
		});
		btnMonthlyReport.setBounds(10, 269, 153, 42);
		panel_1_3.add(btnMonthlyReport);
		frmSfrsMenu.setTitle("SFRS MENU");
		frmSfrsMenu.setBounds(100, 100, 811, 389);
		frmSfrsMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	}
}
