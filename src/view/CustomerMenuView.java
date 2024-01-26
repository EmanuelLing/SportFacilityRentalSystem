package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import controller.CustomerController;
import model.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class CustomerMenuView {

	private JFrame frmMemberMenu;
	private JComboBox<String> customerComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenuView window = new CustomerMenuView();
					window.frmMemberMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CustomerMenuView() {
		initialize();
		frmMemberMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMemberMenu = new JFrame();
		frmMemberMenu.setTitle("CUSTOMER MENU");
		frmMemberMenu.getContentPane().setBackground(Color.DARK_GRAY);
		frmMemberMenu.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 604, 410);
		frmMemberMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 584, 153);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewRegister = new JButton("New Registration");
		btnNewRegister.setBounds(10, 57, 140, 35);
		panel_1.add(btnNewRegister);
		btnNewRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CustomerAddView();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(300, 10, 274, 133);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("New Customer Registration");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 280, 50);
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 173, 584, 227);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(160, 152, 140, 37);
		panel_1_1.add(btnCancel);
		
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
		customerComboBox.setBounds(10, 113, 389, 29);
		panel_1_1.add(customerComboBox);
		
		JButton btnMemberSearch = new JButton("Search");
		btnMemberSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] parts;
				Customer customer = new Customer();
				
				String selectedCustomer = (String) customerComboBox.getSelectedItem();
				parts = selectedCustomer.split("-");
				String customerId = parts[0].trim();
				customer.setCustomerId(customerId);
				
				try {
					if (customerController.searchCustomer(customer))
					{
						new CustomerProfileView(customer);
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
		btnMemberSearch.setBounds(10, 152, 140, 37);
		panel_1_1.add(btnMemberSearch);
		
		JLabel lblMemberProfileSearch = new JLabel("Customer Profile Search ");
		lblMemberProfileSearch.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblMemberProfileSearch.setBounds(10, 10, 256, 50);
		panel_1_1.add(lblMemberProfileSearch);
		
		JLabel lblMemberId = new JLabel("Customer ID:");
		lblMemberId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMemberId.setBounds(10, 70, 256, 50);
		panel_1_1.add(lblMemberId);
		frmMemberMenu.setBounds(100, 100, 638, 467);
		frmMemberMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
