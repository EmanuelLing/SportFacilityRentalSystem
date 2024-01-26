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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-158, 0, 419, 321);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MainMenuView.class.getResource("/view/img/34c3332cb8eb6c448bb4544cd7df4bcd.jpg")));
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MainMenuView.class.getResource("/view/img/5f42fa577d615e58b4ba2d4d54795f01.jpg")));
		lblNewLabel_1.setBounds(-129, -85, 613, 496);
		panel_1_1.add(lblNewLabel_1);
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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(MainMenuView.class.getResource("/view/img/37a5a812f7bd4e6a8174757dce3472cb.jpg")));
		lblNewLabel_2.setBounds(-195, -121, 613, 564);
		panel_1_2.add(lblNewLabel_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBounds(580, 10, 180, 321);
		panel.add(panel_1_3);
		
		JButton btnMonthlyReport = new JButton("Monthly Report");
		btnMonthlyReport.setBounds(10, 269, 153, 42);
		btnMonthlyReport.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{}
		});
		panel_1_3.setLayout(null);
		panel_1_3.add(btnMonthlyReport);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(MainMenuView.class.getResource("/view/img/1474dd76d20d2bd7f997c4741cff0484.jpg")));
		lblNewLabel_3.setBounds(-154, 0, 444, 331);
		panel_1_3.add(lblNewLabel_3);
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
