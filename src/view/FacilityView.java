package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.SportFacility;

public class FacilityView {

	private JFrame frmFacility;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1_2_1;
	private JTextField textField_4;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JButton btnNewButton;
	private JButton btnUpdate;
	private JTextField facilityNameTextField;
	private JTextField locationTextField;
	private JTextField capacityTextField;
	private JTextField rentalCostTextField;
	private JTextField facilityTypeTextField;
	private JTextField facilityIdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacilityView window = new FacilityView(new SportFacility());
					window.frmFacility.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FacilityView(SportFacility sportFacility) {
		initialize(sportFacility);
		frmFacility.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SportFacility sportFacility) {
		
		frmFacility = new JFrame();
		frmFacility.setTitle("FACILITY PAGE");
		frmFacility.getContentPane().setBackground(Color.DARK_GRAY);
		frmFacility.getContentPane().setLayout(null);
		frmFacility.setBounds(100, 100, 750, 540);
		frmFacility.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 691, 450);
		frmFacility.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddFacilityForm = new JLabel("Facility Information");
		lblAddFacilityForm.setBounds(10, 10, 308, 63);
		lblAddFacilityForm.setFont(new Font("SansSerif", Font.BOLD, 30));
		panel.add(lblAddFacilityForm);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 65, 671, 329);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Type:");
		lblNewLabel_1_4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 224, 133, 25);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Facility Name:");
		lblNewLabel_1_4_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_4_1.setBounds(10, 18, 133, 13);
		panel_2.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Rental Cost:");
		lblNewLabel_1_4_2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(10, 187, 133, 13);
		panel_2.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Capacity:");
		lblNewLabel_1_4_3.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_4_3.setBounds(10, 144, 133, 13);
		panel_2.add(lblNewLabel_1_4_3);
		
		JLabel lblNewLabel_1_4_4 = new JLabel("Location:");
		lblNewLabel_1_4_4.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_4_4.setBounds(10, 61, 133, 13);
		panel_2.add(lblNewLabel_1_4_4);
		
		facilityNameTextField = new JTextField();
		facilityNameTextField.setColumns(10);
		facilityNameTextField.setBounds(159, 10, 502, 33);
		panel_2.add(facilityNameTextField);
		facilityNameTextField.setText(sportFacility.getFacilityName());
		facilityNameTextField.setEditable(false);
		
		locationTextField = new JTextField();
		locationTextField.setColumns(10);
		locationTextField.setBounds(159, 53, 502, 73);
		panel_2.add(locationTextField);
		locationTextField.setText(sportFacility.getLocation()); 
		locationTextField.setEditable(false);
		
		capacityTextField = new JTextField();
		capacityTextField.setColumns(10);
		capacityTextField.setBounds(159, 136, 125, 33);
		panel_2.add(capacityTextField);
		capacityTextField.setText(sportFacility.getCapacity());
		capacityTextField.setEditable(false);
		
		rentalCostTextField = new JTextField();
		rentalCostTextField.setColumns(10);
		rentalCostTextField.setBounds(159, 179, 125, 33);
		panel_2.add(rentalCostTextField);
		rentalCostTextField.setText(String.valueOf(sportFacility.getRentalCost()));
		rentalCostTextField.setEditable(false);
		
		facilityTypeTextField = new JTextField();
		facilityTypeTextField.setColumns(10);
		facilityTypeTextField.setBounds(159, 222, 125, 33);
		panel_2.add(facilityTypeTextField);
		facilityTypeTextField.setText(sportFacility.getFacilityType().getFacilityType());
		facilityTypeTextField.setEditable(false);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Facility ID:");
		lblNewLabel_1_4_2_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1.setBounds(10, 283, 133, 13);
		panel_2.add(lblNewLabel_1_4_2_1);
		
		facilityIdTextField = new JTextField();
		facilityIdTextField.setColumns(10);
		facilityIdTextField.setBounds(159, 265, 502, 33);
		panel_2.add(facilityIdTextField);
		facilityIdTextField.setText(sportFacility.getFacilityId());
		facilityIdTextField.setEditable(false);
	}

}
