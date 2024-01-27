package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomerAddView {

	private JFrame frmMemberPage;
	private JTextField txtLast;
	private JTextField txtFirstName;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField txtStreetAddress;
	private JTextField txtPostalZip;
	private JLabel lblNewLabel_1_2_1_2;
	private JTextField txtMemberId;
	private JLabel lblNewLabel_1_2_1_8;
	private JLabel lblNewLabel_1_2_1_9;
	private JButton btnNewButton;
	private JButton btnCancel;
	private JLabel lblNewLabel_1_2_1_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAddView window = new CustomerAddView();
					window.frmMemberPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerAddView() {
		initialize();
		frmMemberPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMemberPage = new JFrame();
		frmMemberPage.setTitle("CUSTOMER REGISTRATION PAGE");
		frmMemberPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmMemberPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 684, 532);
		frmMemberPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Profile Form");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 412, 63);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 73, 664, 398);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setForeground(Color.LIGHT_GRAY);
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(166, 20, 239, 33);
		panel_1.add(txtFirstName);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 28, 133, 13);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtLast = new JTextField();
		txtLast.setForeground(Color.LIGHT_GRAY);
		txtLast.setBounds(415, 20, 239, 33);
		panel_1.add(txtLast);
		txtLast.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(166, 69, 488, 33);
		panel_1.add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 77, 133, 13);
		panel_1.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setColumns(10);
		textField_3.setBounds(166, 121, 488, 33);
		panel_1.add(textField_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Phone:");
		lblNewLabel_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 129, 133, 13);
		panel_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Address:");
		lblNewLabel_1_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(10, 177, 133, 13);
		panel_1.add(lblNewLabel_1_2_1_1);
		
		txtStreetAddress = new JTextField();
		txtStreetAddress.setForeground(Color.LIGHT_GRAY);
		txtStreetAddress.setColumns(10);
		txtStreetAddress.setBounds(166, 177, 488, 101);
		panel_1.add(txtStreetAddress);
		
		txtPostalZip = new JTextField();
		txtPostalZip.setForeground(Color.LIGHT_GRAY);
		txtPostalZip.setColumns(10);
		txtPostalZip.setBounds(166, 298, 488, 33);
		panel_1.add(txtPostalZip);
		
		lblNewLabel_1_2_1_2 = new JLabel("Customer ID:");
		lblNewLabel_1_2_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2.setBounds(10, 363, 133, 13);
		panel_1.add(lblNewLabel_1_2_1_2);
		
		txtMemberId = new JTextField();
		txtMemberId.setForeground(Color.LIGHT_GRAY);
		txtMemberId.setColumns(10);
		txtMemberId.setBounds(166, 355, 488, 33);
		panel_1.add(txtMemberId);
		
		lblNewLabel_1_2_1_8 = new JLabel("FIRST");
		lblNewLabel_1_2_1_8.setForeground(Color.GRAY);
		lblNewLabel_1_2_1_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel_1_2_1_8.setBounds(166, 10, 133, 13);
		panel_1.add(lblNewLabel_1_2_1_8);
		
		lblNewLabel_1_2_1_9 = new JLabel("LAST");
		lblNewLabel_1_2_1_9.setForeground(Color.GRAY);
		lblNewLabel_1_2_1_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
		lblNewLabel_1_2_1_9.setBounds(413, 10, 133, 13);
		panel_1.add(lblNewLabel_1_2_1_9);
		
		lblNewLabel_1_2_1_3 = new JLabel("Password:");
		lblNewLabel_1_2_1_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1_3.setBounds(10, 308, 133, 13);
		panel_1.add(lblNewLabel_1_2_1_3);
		
		btnNewButton = new JButton("Register");
		btnNewButton.setBounds(10, 481, 150, 39);
		panel.add(btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 481, 148, 39);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add the search here
				new CustomerMenuView();
				frmMemberPage.dispose();
			}
		});
		
		
		frmMemberPage.setBounds(100, 100, 718, 589);
		frmMemberPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
