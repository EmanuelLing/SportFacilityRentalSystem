package view;

import model.Customer;
import model.Reservation;
import model.Staff;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import controller.CustomerController;
import controller.ReservationController;


public class ReservationMenuView implements ActionListener, KeyListener 
{

	private JFrame frmReservationMenuPage;
	private JSpinner dateSpinner;
	private JComboBox<String> customerComboBox;
	private JSpinner startTimeSpinner;
	private JSpinner endTimeSpinner;
	private JButton newReservationButton;
	private JButton searchButton;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	ReservationMenuView(Staff staff) {
		initialize(staff);
		frmReservationMenuPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Staff staff) {
		frmReservationMenuPage = new JFrame();
		frmReservationMenuPage.setTitle("RESERVATION MENU PAGE");
		frmReservationMenuPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmReservationMenuPage.getContentPane().setLayout(null);
		frmReservationMenuPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReservationMenuPage.setBounds(100, 100, 643, 535);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 609, 478);
		frmReservationMenuPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 107, 589, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		newReservationButton = new JButton("New");
		newReservationButton.setBounds(10, 49, 98, 29);
		panel_1.add(newReservationButton);
		newReservationButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new ReservationAddView(staff);
			}
		});
		
		JLabel lblNewReservation = new JLabel("New Reservation");
		lblNewReservation.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewReservation.setBounds(10, 10, 183, 29);
		panel_1.add(lblNewReservation);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 217, 589, 251);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblReservations = new JLabel("Reservations");
		lblReservations.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblReservations.setBounds(10, 10, 155, 26);
		panel_2.add(lblReservations);
		
		JLabel lblReservationDate = new JLabel("Date:");
		lblReservationDate.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblReservationDate.setBounds(10, 52, 155, 26);
		panel_2.add(lblReservationDate);
		
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(dateModel);
		
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
		dateSpinner.setBounds(125, 52, 296, 33);
		panel_2.add(dateSpinner);
		
		JLabel lblCustomer = new JLabel("Customer:");
		lblCustomer.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblCustomer.setBounds(10, 94, 155, 26);
		panel_2.add(lblCustomer);
		
		DefaultComboBoxModel<String> customerToString = new DefaultComboBoxModel<>();
		CustomerController customerController = new CustomerController();
		try {
			ArrayList<Customer> customers = customerController.ListoutCustomer();
			
			for (Customer c : customers)
			{
				customerToString.addElement(c.getCustomerId() + " - " + c.getName());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		customerComboBox = new JComboBox<>(customerToString);
		//jList_1.setColumns(10);
		customerComboBox.setBounds(125, 94, 296, 33);
		panel_2.add(customerComboBox);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblTime.setBounds(10, 136, 155, 26);
		panel_2.add(lblTime);
		
        // Create a SpinnerDateModel for time values
        SpinnerDateModel spinnerModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);

		startTimeSpinner = new JSpinner(spinnerModel);
		
        // Set a custom editor to display only the time portion
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);
		startTimeSpinner.setBounds(125, 136, 96, 33);
		panel_2.add(startTimeSpinner);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTo.setBounds(231, 136, 197, 34);
		panel_2.add(lblTo);
		
		spinnerModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
		endTimeSpinner = new JSpinner(spinnerModel);
		
        // Set a custom editor to display only the time portion
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);
		endTimeSpinner.setBounds(251, 136, 96, 33);
		panel_2.add(endTimeSpinner);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.setBounds(10, 178, 98, 36);
		panel_2.add(searchButton);
		searchButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String[] parts;
				Reservation reservation = new Reservation();
				ReservationController reservationController = new ReservationController();
				
				reservation.setStaff(staff);
				
				String selectedCustomer = (String) customerComboBox.getSelectedItem();
				parts = selectedCustomer.split("-");
				String customerId = parts[0].trim();
				reservation.getCustomer().setCustomerId(customerId);
				
				Date selectedDate = (Date) dateSpinner.getValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = dateFormat.format(selectedDate);        
				reservation.setReservationDate(formattedDate);
				
				Date startTime = (Date) startTimeSpinner.getValue();
				SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
				String formattedStartTime = timeFormat.format(startTime);	
				reservation.setStartTime(formattedStartTime + ":00");
				
				Date endTime = (Date) endTimeSpinner.getValue();
				String formattedEndTime = timeFormat.format(endTime);	
				reservation.setEndTime(formattedEndTime + ":00");
				
				try {
					if (reservationController.searchReservation(reservation))
					{
						new ReservationView(reservation);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No Data Found");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblReservationMenu = new JLabel("Reservation Menu");
		lblReservationMenu.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblReservationMenu.setBounds(10, 10, 308, 63);
		panel.add(lblReservationMenu);
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
		if (e.getSource()== searchButton)
		{
			//new ReservationAddView(staff);//this part can be change to go back to menu etc..
		}
		
	}
}
