package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PaymentAddView {

	private JFrame frmNewPaymentPage;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PaymentAddView() {
		initialize();
		frmNewPaymentPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewPaymentPage = new JFrame();
		frmNewPaymentPage.setTitle("NEW PAYMENT PAGE");
		frmNewPaymentPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmNewPaymentPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 542, 678);
		frmNewPaymentPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details");
		lblPaymentDetails.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblPaymentDetails.setBounds(10, 10, 308, 63);
		panel.add(lblPaymentDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 68, 522, 160);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPaymentId = new JLabel("Payment ID:");
		lblPaymentId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPaymentId.setBounds(10, 10, 197, 34);
		panel_1.add(lblPaymentId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 10, 391, 33);
		panel_1.add(textField);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblAmount.setBounds(10, 54, 197, 34);
		panel_1.add(lblAmount);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDate.setBounds(10, 98, 197, 34);
		panel_1.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 54, 197, 33);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(121, 98, 197, 33);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 493, 522, 129);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("CASH/QR");
		chckbxNewCheckBox_1.setBounds(6, 6, 93, 21);
		panel_2.add(chckbxNewCheckBox_1);
		
		JLabel lblPaymentReference = new JLabel("Payment Reference:");
		lblPaymentReference.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPaymentReference.setBounds(6, 33, 197, 34);
		panel_2.add(lblPaymentReference);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(6, 77, 506, 33);
		panel_2.add(textField_8);
		
		JLabel lblPayment = new JLabel("Payment:");
		lblPayment.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblPayment.setBounds(10, 231, 308, 63);
		panel.add(lblPayment);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 304, 522, 179);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("CARD");
		chckbxNewCheckBox.setBounds(6, 6, 93, 21);
		panel_3.add(chckbxNewCheckBox);
		
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblCardNumber.setBounds(6, 33, 197, 34);
		panel_3.add(lblCardNumber);
		
		JLabel lblPaymentId_1_1 = new JLabel("Expiry Date:");
		lblPaymentId_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPaymentId_1_1.setBounds(6, 77, 197, 34);
		panel_3.add(lblPaymentId_1_1);
		
		JLabel lblPaymentId_1_1_1 = new JLabel("Name on Card:");
		lblPaymentId_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPaymentId_1_1_1.setBounds(6, 121, 197, 34);
		panel_3.add(lblPaymentId_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 33, 277, 33);
		panel_3.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(121, 77, 93, 33);
		panel_3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(408, 33, 104, 33);
		panel_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(224, 77, 93, 33);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(121, 122, 391, 33);
		panel_3.add(textField_7);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(10, 632, 150, 39);
		panel.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 632, 150, 39);
		panel.add(btnCancel);
		frmNewPaymentPage.setBounds(100, 100, 576, 735);
		frmNewPaymentPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
