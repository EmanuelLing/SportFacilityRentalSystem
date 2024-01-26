package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import controller.PaymentController;
import model.Payment;

public class PaymentView {

	private JFrame frmPaymentPage;
	private JTextField paymentIdTextField;
	private JSpinner priceSpinner;
	private JSpinner dateSpinner;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	private PaymentController paymentController = new PaymentController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentView window = new PaymentView(new Payment());
					window.frmPaymentPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentView(Payment payment) {
		initialize(payment);
		frmPaymentPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Payment payment) {
		frmPaymentPage = new JFrame();
		frmPaymentPage.setTitle("Payment Page");
		
		frmPaymentPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmPaymentPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 542, 678);
		frmPaymentPage.getContentPane().add(panel);
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
		
		paymentIdTextField = new JTextField();
		paymentIdTextField.setColumns(10);
		paymentIdTextField.setBounds(121, 10, 391, 33);
		panel_1.add(paymentIdTextField);
		paymentIdTextField.setText(payment.getPaymentId());
		paymentIdTextField.setEditable(false);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblAmount.setBounds(10, 54, 197, 34);
		panel_1.add(lblAmount);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDate.setBounds(10, 98, 197, 34);
		panel_1.add(lblDate);
		
		SpinnerNumberModel priceModel = new SpinnerNumberModel(0.00, 0.00, 999.99, 1);
		
		priceSpinner = new JSpinner(priceModel);
		
		JSpinner.NumberEditor priceEditor = new JSpinner.NumberEditor(priceSpinner, "##0.00");
		priceSpinner.setEditor(priceEditor);
		
		priceSpinner.setBounds(121, 54, 197, 33);
		panel_1.add(priceSpinner);
		priceSpinner.setValue(Double.valueOf(payment.getAmount()));
		
        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(dateModel);
		
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setBounds(121, 98, 197, 33);
		panel_1.add(dateSpinner);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 493, 522, 129);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JCheckBox cashOrQrCheckBox = new JCheckBox("CASH/QR");
		cashOrQrCheckBox.setBounds(6, 6, 93, 21);
		panel_2.add(cashOrQrCheckBox);
		cashOrQrCheckBox.setEnabled(false);
		
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
		
		JCheckBox cardCheckBox = new JCheckBox("CARD");
		cardCheckBox.setBounds(6, 6, 93, 21);
		panel_3.add(cardCheckBox);
		cardCheckBox.setEnabled(false);
		
		if (payment.getPaymentMethod().equals("CARD"))
		{
			cardCheckBox.setSelected(true);
		}
		else
		{
			cashOrQrCheckBox.setSelected(true);
		}
		
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
		
		JButton btnConfirm = new JButton("Update");
		btnConfirm.setBounds(10, 632, 150, 39);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Object selectedAmount = priceSpinner.getValue();
				Double amount = Double.valueOf(String.valueOf(selectedAmount));
				payment.setAmount(amount);
				
				Date selectedDate = (Date) dateSpinner.getValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = dateFormat.format(selectedDate);        
				payment.setPaymentDate(formattedDate);
				
				try {
					paymentController.updatePayment(payment);
					frmPaymentPage.dispose();
					JOptionPane.showMessageDialog(null, "Update Payment Success");
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
		btnCancel.setBounds(170, 632, 150, 39);
		panel.add(btnCancel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(382, 632, 150, 39);
		panel.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this payment?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                	try {
						paymentController.deletePayment(payment);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
        });
		
		frmPaymentPage.setBounds(100, 100, 576, 735);
		frmPaymentPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
