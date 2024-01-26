package view;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import model.Reservation;
import model.Staff;
import model.Customer;
import model.SportFacility;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import controller.CustomerController;
import java.util.Iterator;
import controller.SportFacilityController;
import java.util.List;
import controller.ReservationController;


public class ReservationAddView extends JFrame
{

	private JFrame frmNewReservationPage;
	private JComboBox<String> sportFacilityComboBox;
	private JComboBox<String> customerComboBox;
	private JSpinner reservationIdSpinner;
	private JSpinner dateSpinner;
	private JSpinner startTimeSpinner;
	private JSpinner endTimeSpinner;
	private JTextField staffTextField;
	private JSpinner paymentIdSpinner;
	
	private JButton btnConfirm;
	private JButton btnCancel;
	private JButton btnPay;
	
	private Reservation reservation;
	private SportFacilityController sportFacilityController;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ReservationAddView(Staff staff) {
		initialize(staff);
		frmNewReservationPage.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(Staff staff) 
	{
		frmNewReservationPage = new JFrame();
		frmNewReservationPage.setTitle("NEW RESERVATION PAGE");
		frmNewReservationPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmNewReservationPage.getContentPane().setLayout(null);
		frmNewReservationPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNewReservationPage.setBounds(100, 100, 868, 497);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 834, 440);
		frmNewReservationPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 408, 119);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFacilityReference = new JLabel("Facility:");
		lblFacilityReference.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblFacilityReference.setBounds(10, 10, 197, 34);
		panel_1.add(lblFacilityReference);
		
		DefaultComboBoxModel<String> facilityToString = new DefaultComboBoxModel<>();
		sportFacilityController = new SportFacilityController();
		try {	
			ArrayList<SportFacility> sportFacilities = sportFacilityController.ListoutSportFacility();
			for (SportFacility s : sportFacilities)
			{
				facilityToString.addElement(s.getFacilityId() + " - " + s.getFacilityName() + 
						" - RM" + s.getRentalCost() + " per hour");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sportFacilityComboBox = new JComboBox(facilityToString);
		sportFacilityComboBox.setBounds(10, 75, 378, 34);
		panel_1.add(sportFacilityComboBox);
		//comboBox.setColumns(10);
		
		JLabel lblFacilityName = new JLabel("Facility ID:");
		lblFacilityName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblFacilityName.setBounds(10, 40, 197, 34);
		panel_1.add(lblFacilityName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(426, 10, 398, 119);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCustomerReference = new JLabel("Customer:");
		lblCustomerReference.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblCustomerReference.setBounds(10, 10, 226, 34);
		panel_2.add(lblCustomerReference);
		
		JLabel lblFacilityName_1 = new JLabel("Customer ID:");
		lblFacilityName_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblFacilityName_1.setBounds(10, 38, 197, 34);
		panel_2.add(lblFacilityName_1);
		
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
		customerComboBox.setBounds(10, 75, 378, 34);
		panel_2.add(customerComboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 139, 556, 245);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblReservationDetails = new JLabel("Reservation Details:");
		lblReservationDetails.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblReservationDetails.setBounds(10, 10, 197, 34);
		panel_3.add(lblReservationDetails);
		
		SpinnerModel idModel = new SpinnerNumberModel(1, 1, 999, 1);
		reservationIdSpinner = new JSpinner(idModel);
		reservationIdSpinner.setBounds(155, 57, 96, 33);
		panel_3.add(reservationIdSpinner);
		
		JLabel lblReservationId = new JLabel("Reservation ID:");
		lblReservationId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblReservationId.setBounds(10, 54, 197, 34);
		panel_3.add(lblReservationId);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDate.setBounds(10, 100, 197, 34);
		panel_3.add(lblDate);
		
        // Create a SpinnerDateModel
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(dateModel);

        // Configure the date format
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setBounds(155, 100, 224, 33);
        panel_3.add(dateSpinner);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTime.setBounds(10, 144, 197, 34);
		panel_3.add(lblTime);
		
        // Create a SpinnerDateModel for time values
        SpinnerDateModel spinnerModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);

		startTimeSpinner = new JSpinner(spinnerModel);
		
        // Set a custom editor to display only the time portion
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);
		startTimeSpinner.setBounds(155, 144, 96, 33);
		panel_3.add(startTimeSpinner);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTo.setBounds(261, 143, 197, 34);
		panel_3.add(lblTo);
		
		spinnerModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
		endTimeSpinner = new JSpinner(spinnerModel);
		
        // Set a custom editor to display only the time portion
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);
		endTimeSpinner.setBounds(281, 144, 96, 33);
		panel_3.add(endTimeSpinner);	
		
		JLabel lblStaffInCharge = new JLabel("Staff in charge:");
		lblStaffInCharge.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblStaffInCharge.setBounds(10, 188, 197, 34);
		panel_3.add(lblStaffInCharge);
		
		staffTextField = new JTextField();
		staffTextField.setColumns(10);
		staffTextField.setBounds(155, 188, 224, 33);
		panel_3.add(staffTextField);
		staffTextField.setText(staff.getName());
		staffTextField.setEditable(false);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(576, 139, 248, 245);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details:");
		lblPaymentDetails.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPaymentDetails.setBounds(10, 10, 197, 34);
		panel_4.add(lblPaymentDetails);
		
		idModel = new SpinnerNumberModel(1, 1, 999, 1);
		paymentIdSpinner = new JSpinner(idModel);
		paymentIdSpinner.setBounds(10, 90, 228, 34);
		panel_4.add(paymentIdSpinner);
		
		JLabel lblPaymentId = new JLabel("Payment ID:");
		lblPaymentId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPaymentId.setBounds(10, 54, 197, 34);
		panel_4.add(lblPaymentId);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(57, 196, 150, 39);
		panel_4.add(btnPay);
		btnPay.setEnabled(false);
		btnPay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frmNewReservationPage.dispose();
				
				Object selectedValue = paymentIdSpinner.getValue();
				String paymentId = String.valueOf(selectedValue);
				new PaymentAddView(reservation, paymentId);
			}
		});
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(10, 393, 150, 39);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				String[] parts;
				reservation = new Reservation();
				ReservationController reservationController = new ReservationController();
				
				reservation.setStaff(staff);
				
				Object selectedValue = reservationIdSpinner.getValue();
				String reservationId = String.valueOf(selectedValue);
				reservation.setReservationId(reservationId);
				
				String selectedFacility = (String) sportFacilityComboBox.getSelectedItem();
				parts = selectedFacility.split("-");
				String facilityId = parts[0].trim();
				try {
					ArrayList<SportFacility> sportFacilities = sportFacilityController.ListoutSportFacility();
					for (SportFacility s : sportFacilities)
					{
						if (facilityId.equals(s.getFacilityId()))
						{
							reservation.setSportFacility(s);
							break;
						}
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
					reservationController.addReservation(reservation);
					JOptionPane.showMessageDialog(null, "Add Reservation Success");
					btnPay.setEnabled(true);
					reservationIdSpinner.setEnabled(false);
					sportFacilityComboBox.setEnabled(false);
					customerComboBox.setEnabled(false);
					dateSpinner.setEnabled(false);
					startTimeSpinner.setEnabled(false);
					endTimeSpinner.setEnabled(false);
					btnConfirm.setEnabled(false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 394, 150, 39);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{			
				frmNewReservationPage.dispose();
				new MainMenuView(staff);
			}
		});
	}
}
