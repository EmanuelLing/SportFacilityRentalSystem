package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class FacilityMenuView {

	private JFrame frmFacilitiesPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacilityMenuView window = new FacilityMenuView();
					window.frmFacilitiesPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FacilityMenuView() {
		initialize();
		frmFacilitiesPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFacilitiesPage = new JFrame();
		frmFacilitiesPage.setTitle("FACILITIES PAGE");
		frmFacilitiesPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmFacilitiesPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 659, 498);
		frmFacilitiesPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 83, 206, 357);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("SELECT"); //left select
		btnNewButton_1.setBounds(10, 297, 186, 50);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add the search here
				new FacilityView(); //change it to the facility later
				frmFacilitiesPage.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-195, -58, 675, 463);
		panel_2.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(FacilityMenuView.class.getResource("/view/img/1e124664217dda04b3ed9506b7cdc5e3.jpg")));
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(449, 83, 200, 357);
		panel.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JButton btnNewButton_1_2 = new JButton("SELECT");
		btnNewButton_1_2.setBounds(10, 299, 180, 48);
		panel_2_2.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add the search here
				new FacilityView(); //change it to the facility later
				frmFacilitiesPage.dispose();
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-174, -636, 613, 1002);
		panel_2_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(FacilityMenuView.class.getResource("/view/img/1ee2b111c43b9e3e0d7d4eb79736f3b7.jpg")));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(226, 83, 213, 357);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("SELECT");
		btnNewButton_1_1.setBounds(10, 298, 193, 49);
		panel_2_1.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add the search here
				new FacilityView(); //change it to the facility later
				frmFacilitiesPage.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(FacilityMenuView.class.getResource("/view/img/9e895763307ecfb3bb2d86f37bacea2b.jpg")));
		lblNewLabel_1.setBounds(-103, -14, 784, 409);
		panel_2_1.add(lblNewLabel_1);
		
		JLabel lblFacilitySelectionMenu = new JLabel("Facility Selection Menu:");
		lblFacilitySelectionMenu.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblFacilitySelectionMenu.setBounds(10, 10, 363, 63);
		panel.add(lblFacilitySelectionMenu);
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.setBounds(525, 460, 124, 28);
		panel.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//add the search here
				new MainMenuView(); //change it to the facility later
				frmFacilitiesPage.dispose();
			}
		});
		
		frmFacilitiesPage.setBounds(100, 100, 693, 555);
		frmFacilitiesPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
