package view;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JTextField;


public class ReservationMenuView implements ActionListener, KeyListener 
{

	private JFrame frmReservationMenuPage;
	private JTextField textField;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ReservationMenuView() 
	{
		initialize();
		frmReservationMenuPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservationMenuPage = new JFrame();
		frmReservationMenuPage.setTitle("RESERVATION MENU PAGE");
		frmReservationMenuPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmReservationMenuPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 609, 348);
		frmReservationMenuPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 107, 589, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New");
		btnNewButton_1.setBounds(10, 49, 98, 29);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new ReservationAddView();
				frmReservationMenuPage.dispose();
			}
		});
		
		JLabel lblNewReservation = new JLabel("New Reservation");
		lblNewReservation.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewReservation.setBounds(10, 10, 183, 29);
		panel_1.add(lblNewReservation);
		
		JButton btnNewButton_1_2 = new JButton("Back");
		btnNewButton_1_2.setBounds(481, 53, 98, 29);
		panel_1.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add the search here
				new MainMenuView();
				frmReservationMenuPage.dispose();
			}
		});
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 217, 589, 121);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("SEARCH");
		btnNewButton_1_1.setBounds(481, 50, 98, 36);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblReservations = new JLabel("Reservations");
		lblReservations.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblReservations.setBounds(10, 10, 155, 26);
		panel_2.add(lblReservations);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 52, 461, 33);
		panel_2.add(textField);
		
		JLabel lblReservationMenu = new JLabel("Reservation Menu");
		lblReservationMenu.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblReservationMenu.setBounds(10, 10, 308, 63);
		panel.add(lblReservationMenu);
		frmReservationMenuPage.setBounds(100, 100, 643, 405);
		frmReservationMenuPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public void actionPerformed(ActionEvent e) 
	{
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


