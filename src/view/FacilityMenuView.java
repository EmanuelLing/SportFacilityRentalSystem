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
		panel.setBounds(10, 10, 659, 521);
		frmFacilitiesPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 399, 639, 112);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("NEW FACILITY");
		btnNewButton.setBounds(10, 63, 130, 34);
		panel_1.add(btnNewButton);
		
		JLabel lblAddNewFacility = new JLabel("Add New Facility");
		lblAddNewFacility.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblAddNewFacility.setBounds(10, 10, 329, 63);
		panel_1.add(lblAddNewFacility);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 83, 206, 306);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("SELECT");
		btnNewButton_1.setBounds(53, 267, 98, 29);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(449, 83, 200, 306);
		panel.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JButton btnNewButton_1_2 = new JButton("SELECT");
		btnNewButton_1_2.setBounds(57, 267, 98, 29);
		panel_2_2.add(btnNewButton_1_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(226, 83, 213, 306);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("SELECT");
		btnNewButton_1_1.setBounds(61, 267, 98, 29);
		panel_2_1.add(btnNewButton_1_1);
		
		JLabel lblFacilitySelectionMenu = new JLabel("Facility Selection Menu:");
		lblFacilitySelectionMenu.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblFacilitySelectionMenu.setBounds(10, 10, 363, 63);
		panel.add(lblFacilitySelectionMenu);
		frmFacilitiesPage.setBounds(100, 100, 693, 578);
		frmFacilitiesPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
