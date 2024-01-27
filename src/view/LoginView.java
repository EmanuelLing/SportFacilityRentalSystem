package view;

import model.Staff;
import controller.StaffController;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class LoginView extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmLoginpage;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frmLoginpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		frmLoginpage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginpage = new JFrame();
		frmLoginpage.setTitle("SFRS LOGIN\r\n");
		frmLoginpage.getContentPane().setBackground(new Color(255, 255, 255));
		frmLoginpage.setBounds(100, 100, 950, 419);
		frmLoginpage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginpage.getContentPane().setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 1057, 605);
		frmLoginpage.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 805, 359);
		panel_2.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff staff = new Staff();
				staff.setUsername(txtUsername.getText());
				staff.setPassword(txtPassword.getText());
				
				StaffController staffController = new StaffController();
				try {
					if (staffController.staffLogin(staff))
					{
						frmLoginpage.dispose();
						new MainMenuView(staff);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong username or password, please try again");
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
		btnNewButton.setBounds(48, 272, 100, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(158, 272, 100, 40);
		panel.add(btnNewButton_1);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("");
		txtUsername.setBounds(48, 133, 319, 39);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(48, 215, 319, 39);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Welcome to SFRS");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 44));
		lblNewLabel.setBounds(10, 10, 455, 57);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(504, 10, 291, 339);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME:");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblUsername.setBounds(49, 98, 130, 40);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblPassword.setBounds(48, 182, 130, 40);
		panel.add(lblPassword);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("img/8e6089cc83644af9bba70e8aca1c6e8a.jpg"));
		lblNewLabel_2.setBounds(10, 10, 271, 319);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("img/16e57efc9d56c29d4ab7a651bd082efd.jpg"));
		lblNewLabel_1.setBounds(392, -14, 563, 395);
		panel_2.add(lblNewLabel_1);
	}
}
