package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import controller.SportFacilityController;
import model.SportFacility;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FacilityMenuView {

	private JFrame frmFacilitiesPage;
	private SportFacility sportFacility = new SportFacility();
	private SportFacilityController sportFacilityController = new SportFacilityController();

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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 83, 206, 306);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-103, -14, 784, 409);
		panel_2.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("img/9e895763307ecfb3bb2d86f37bacea2b.jpg"));
		
		JButton btnSelect1 = new JButton("SELECT");
		btnSelect1.setBounds(53, 267, 98, 29);
		panel_2.add(btnSelect1);
		btnSelect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sportFacility.setFacilityId("1");
				
				try {
					sportFacilityController.getSportFacilityById(sportFacility);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				new FacilityView(sportFacility);
			}
		});
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(449, 83, 200, 306);
		panel.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(-195, -58, 675, 463);
		panel_2_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("img/1e124664217dda04b3ed9506b7cdc5e3.jpg"));
		
		JButton btnSelect2 = new JButton("SELECT");
		btnSelect2.setBounds(57, 267, 98, 29);
		panel_2_2.add(btnSelect2);
		btnSelect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sportFacility.setFacilityId("2");
				
				try {
					sportFacilityController.getSportFacilityById(sportFacility);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				new FacilityView(sportFacility);
			}
		});
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(226, 83, 213, 306);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("img/1ee2b111c43b9e3e0d7d4eb79736f3b7.jpg"));
		lblNewLabel_1.setBounds(-174, -636, 613, 1002);
		panel_2_1.add(lblNewLabel_1);
		
		JButton btnSelect3 = new JButton("SELECT");
		btnSelect3.setBounds(61, 267, 98, 29);
		panel_2_1.add(btnSelect3);
		btnSelect3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sportFacility.setFacilityId("3");
				
				try {
					sportFacilityController.getSportFacilityById(sportFacility);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				new FacilityView(sportFacility);
			}
		});
		
		JLabel lblFacilitySelectionMenu = new JLabel("Facility Selection Menu:");
		lblFacilitySelectionMenu.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblFacilitySelectionMenu.setBounds(10, 10, 363, 63);
		panel.add(lblFacilitySelectionMenu);
		frmFacilitiesPage.setBounds(100, 100, 693, 578);
		frmFacilitiesPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
