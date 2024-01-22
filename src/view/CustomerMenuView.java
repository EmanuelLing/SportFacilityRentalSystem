package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class CustomerMenuView {

	private JFrame frmMemberMenu;
	private JTextField textField;

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
		
		JButton btnNewButton = new JButton("New Registration");
		btnNewButton.setBounds(10, 57, 140, 35);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(300, 10, 274, 133);
		panel_1.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("New Customer Registration");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 280, 50);
		panel_1.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 173, 584, 227);
		panel.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JButton btnMemberSearch = new JButton("Search");
		btnMemberSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMemberSearch.setBounds(10, 152, 140, 37);
		panel_1_1.add(btnMemberSearch);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(160, 152, 140, 37);
		panel_1_1.add(btnCancel);
		
		textField = new JTextField();
		textField.setBounds(10, 113, 389, 29);
		panel_1_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblMemberProfileSearch = new JLabel("Customer Profile Search ");
		lblMemberProfileSearch.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblMemberProfileSearch.setBounds(10, 10, 256, 50);
		panel_1_1.add(lblMemberProfileSearch);
		
		JLabel lblMemberId = new JLabel("Customer ID:");
		lblMemberId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblMemberId.setBounds(10, 70, 256, 50);
		panel_1_1.add(lblMemberId);
		frmMemberMenu.setBounds(100, 100, 638, 467);
		frmMemberMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
