package view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.FacilityReservation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ReservationAddView implements ActionListener, KeyListener
{

	private JFrame frmNewReservationPage;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private JButton btnConfirm;
	private JButton btnCancel;
	private JButton btnPay;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ReservationAddView() {
		initialize();
		frmNewReservationPage.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() 
	{
		frmNewReservationPage = new JFrame();
		frmNewReservationPage.setTitle("NEW RESERVATION PAGE");
		frmNewReservationPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmNewReservationPage.getContentPane().setLayout(null);
		
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
		
		textField = new JTextField();
		textField.setBounds(10, 75, 378, 34);
		panel_1.add(textField);
		textField.setColumns(10);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 75, 378, 34);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 139, 556, 245);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblReservationDetails = new JLabel("Reservation Details:");
		lblReservationDetails.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblReservationDetails.setBounds(10, 10, 197, 34);
		panel_3.add(lblReservationDetails);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(155, 57, 391, 33);
		panel_3.add(textField_2);
		
		JLabel lblReservationId = new JLabel("Reservation ID:");
		lblReservationId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblReservationId.setBounds(10, 54, 197, 34);
		panel_3.add(lblReservationId);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDate.setBounds(10, 100, 197, 34);
		panel_3.add(lblDate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(155, 100, 224, 33);
		panel_3.add(textField_3);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTime.setBounds(10, 144, 197, 34);
		panel_3.add(lblTime);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(155, 144, 96, 33);
		panel_3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(283, 143, 96, 33);
		panel_3.add(textField_5);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTo.setBounds(261, 143, 197, 34);
		panel_3.add(lblTo);
		
		JLabel lblStaffInCharge = new JLabel("Staff in charge:");
		lblStaffInCharge.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblStaffInCharge.setBounds(10, 188, 197, 34);
		panel_3.add(lblStaffInCharge);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(155, 188, 224, 33);
		panel_3.add(textField_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(576, 139, 248, 245);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details:");
		lblPaymentDetails.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPaymentDetails.setBounds(10, 10, 197, 34);
		panel_4.add(lblPaymentDetails);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 90, 228, 34);
		panel_4.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPaymentId = new JLabel("Payment ID:");
		lblPaymentId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPaymentId.setBounds(10, 54, 197, 34);
		panel_4.add(lblPaymentId);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(57, 196, 150, 39);
		panel_4.add(btnPay);
		btnPay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new PaymentAddView();
			}
		});
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(10, 393, 150, 39);
		panel.add(btnConfirm);
		
		btnConfirm.addActionListener(this);
		
		
		textField.addKeyListener(this); // Register the KeyListener
        textField_1.addKeyListener(this);
        textField_2.addKeyListener(this);
        textField_3.addKeyListener(this);
        textField_4.addKeyListener(this);
        textField_5.addKeyListener(this);
        textField_6.addKeyListener(this);
        textField_7.addKeyListener(this);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 394, 150, 39);
		panel.add(btnCancel);
		
		
		
		frmNewReservationPage.setBounds(100, 100, 868, 497);
		frmNewReservationPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public void actionPerformed(ActionEvent e) //later change output to input into the database
	{
		if (e.getSource()== btnConfirm) 
		{
            // Handle Confirm button action
            System.out.println("Confirm button pressed");
            
            FacilityReservation newReservation = new FacilityReservation();
            
            // Retrieve text from text fields
            newReservation.setFacilityId(textField.getText());
            newReservation.setCustomerId(textField_1.getText());
            newReservation.setReservationId(textField_2.getText());
            newReservation.setDate(textField_3.getText());
            newReservation.setStartTime(textField_4.getText());
            newReservation.setEndTime(textField_5.getText());
            newReservation.setStaffId(textField_6.getText());
            newReservation.setPaymentId(textField_7.getText());
            

            // this is for testing..later remove
            System.out.println("Facility ID: " + newReservation.getFacilityId());
            System.out.println("Customer ID: " + newReservation.getCustomerId());
            System.out.println("Reservation ID: " + newReservation.getReservationId());
            System.out.println("Date: " + newReservation.getDate());
            System.out.println("Start Time: " + newReservation.getStartTime());
            System.out.println("End Time: " + newReservation.getEndTime());
            System.out.println("Staff ID: " + newReservation.getStaffId());
            System.out.println("Payment ID: " + newReservation.getPaymentId());
        }
		
		if (e.getSource()== btnCancel)
		{
			System.out.println("action is cancel...going back"); //this part can be change to go back to menu etc..
		}
		
		if (e.getSource()==btnPay)
		{
			System.out.println("Going to the pay module"); //this part change to go to the payment module menu etc..
		}
	}
}
