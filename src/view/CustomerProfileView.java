package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.CustomerController;
import model.Customer;

import javax.swing.JButton;

public class CustomerProfileView {

	private JFrame frmMemberProfilePage;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumTextField;
	private JTextField customerIdTextField;
	private JLabel lblNewLabel_1_2_1_2;
	private JButton btnCancel;
	private JButton btnDelete;
	private JButton btnUpdate;

	private CustomerController customerController = new CustomerController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					CustomerProfileView window = new CustomerProfileView(new Customer());
					window.frmMemberProfilePage.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerProfileView(Customer customer) {
		initialize(customer);
		frmMemberProfilePage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Customer customer) {
		frmMemberProfilePage = new JFrame();
		frmMemberProfilePage.setTitle("MEMBER PROFILE PAGE");
		frmMemberProfilePage.getContentPane().setBackground(Color.DARK_GRAY);
		frmMemberProfilePage.getContentPane().setLayout(null);
		frmMemberProfilePage.setBounds(100, 100, 855, 653);
		frmMemberProfilePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 684, 532);
		frmMemberProfilePage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Profile");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 10, 308, 63);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 73, 664, 398);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(166, 20, 488, 33);
		panel_1.add(nameTextField);
		nameTextField.setText(customer.getName());
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 28, 133, 13);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(166, 69, 488, 33);
		panel_1.add(emailTextField);
		emailTextField.setText(customer.getEmailAddress());
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 77, 133, 13);
		panel_1.add(lblNewLabel_1_2);
		
		phoneNumTextField = new JTextField();
		phoneNumTextField.setColumns(10);
		phoneNumTextField.setBounds(166, 121, 488, 33);
		panel_1.add(phoneNumTextField);
		phoneNumTextField.setText(customer.getPhoneNum());
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Phone:");
		lblNewLabel_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 129, 133, 13);
		panel_1.add(lblNewLabel_1_2_1);

		customerIdTextField = new JTextField();
		customerIdTextField.setBounds(166, 173, 488, 33);
		panel_1.add(customerIdTextField);
		customerIdTextField.setText(customer.getCustomerId());
		customerIdTextField.setEditable(false);
			
		lblNewLabel_1_2_1_2 = new JLabel("Customer ID:");
		lblNewLabel_1_2_1_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2.setBounds(10, 181, 133, 13);
		panel_1.add(lblNewLabel_1_2_1_2);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 481, 150, 39);
		panel.add(btnCancel);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(531, 481, 143, 39);
		panel.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this customer?", 
                        "Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                	try {
                		customerController.deleteCustomer(customer);
    					JOptionPane.showMessageDialog(null, "Customer Deleted");
    					frmMemberProfilePage.dispose();
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
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 481, 150, 39);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				customer.setEmailAddress(emailTextField.getText());
				
				customer.setName(nameTextField.getText());
				
				customer.setPhoneNum(phoneNumTextField.getText());
				
				try {
					customerController.updateCustomer(customer);
					JOptionPane.showMessageDialog(null, "Update Customer Success");
					frmMemberProfilePage.dispose();
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		frmMemberProfilePage.setBounds(100, 100, 718, 589);
		
	}

}
