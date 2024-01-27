package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controller.SportFacilityController;
import controller.StaffController;
import model.SportFacility;
import model.Staff;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
