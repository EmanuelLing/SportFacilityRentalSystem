package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReservationView {

	private JFrame frmReservationInfoPage;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationView window = new ReservationView();
					window.frmReservationInfoPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReservationView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservationInfoPage = new JFrame();
		frmReservationInfoPage.setTitle("RESERVATION INFO PAGE");
		frmReservationInfoPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmReservationInfoPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 834, 440);
		frmReservationInfoPage.getContentPane().add(panel);
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
		
		JLabel lblFacilityName_1 = new JLabel("Facility ID:");
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
				new PaymentView(); //change to read payment details
				frmReservationInfoPage.dispose();
			}
		});
		
		JButton btnConfirm = new JButton("Update");
		btnConfirm.setBounds(10, 393, 150, 39);
		panel.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 394, 150, 39);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new ReservationMenuView();
				frmReservationInfoPage.dispose();
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(674, 394, 150, 39);
		panel.add(btnDelete);
		
		frmReservationInfoPage.setBounds(100, 100, 871, 499);
		frmReservationInfoPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
