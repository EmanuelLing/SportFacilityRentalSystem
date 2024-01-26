package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import controller.CustomerController;
import model.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class CustomerAddView {

	private JFrame frmMemberPage;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumTextField;
	private JLabel lblNewLabel_1_2_1_2;
	private JSpinner customerIdSpinner;
	private JButton btnRegister;
	private JButton btnCancel;

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
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(166, 20, 488, 33);
		panel_1.add(nameTextField);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 28, 133, 13);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(166, 69, 488, 33);
		panel_1.add(emailTextField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 77, 133, 13);
		panel_1.add(lblNewLabel_1_2);
		
		phoneNumTextField = new JTextField();
		phoneNumTextField.setColumns(10);
		phoneNumTextField.setBounds(166, 121, 488, 33);
		panel_1.add(phoneNumTextField);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Phone:");
		lblNewLabel_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 129, 133, 13);
		panel_1.add(lblNewLabel_1_2_1);
		
		lblNewLabel_1_2_1_2 = new JLabel("Customer ID:");
		lblNewLabel_1_2_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2.setBounds(10, 181, 133, 13);
		panel_1.add(lblNewLabel_1_2_1_2);
		
		SpinnerModel idModel = new SpinnerNumberModel(1, 1, 999, 1);
		customerIdSpinner = new JSpinner(idModel);
		customerIdSpinner.setBounds(166, 173, 488, 33);
		panel_1.add(customerIdSpinner);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(10, 481, 150, 39);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Customer customer = new Customer();
				CustomerController customerController = new CustomerController();
				
				Object selectedValue = customerIdSpinner.getValue();
				String customerId = String.valueOf(selectedValue);
				customer.setCustomerId(customerId);
				
				customer.setName(nameTextField.getText());
				
				customer.setEmailAddress(emailTextField.getText());
				
				customer.setPhoneNum(phoneNumTextField.getText());
				
				try {
					customerController.registerNewCustomer(customer);
					JOptionPane.showMessageDialog(null, "Register Success");
					frmMemberPage.dispose();			
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				frmMemberPage.dispose();
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 481, 148, 39);
		panel.add(btnCancel);
		frmMemberPage.setBounds(100, 100, 718, 589);
		frmMemberPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
