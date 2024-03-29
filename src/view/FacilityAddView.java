package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

public class FacilityAddView {

	private JFrame frmFacilityAddPage;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacilityAddView window = new FacilityAddView();
					window.frmFacilityAddPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FacilityAddView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFacilityAddPage = new JFrame();
		frmFacilityAddPage.setTitle("FACILITY ADD PAGE");
		frmFacilityAddPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmFacilityAddPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 691, 450);
		frmFacilityAddPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAddFacilityForm = new JLabel("Add Facility Form ");
		lblAddFacilityForm.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblAddFacilityForm.setBounds(10, 10, 308, 63);
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
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(159, 10, 502, 33);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(159, 53, 502, 73);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(159, 136, 125, 33);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(159, 179, 125, 33);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(159, 222, 125, 33);
		panel_2.add(textField_9);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Facility ID:");
		lblNewLabel_1_4_2_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1.setBounds(10, 283, 133, 13);
		panel_2.add(lblNewLabel_1_4_2_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(159, 265, 502, 33);
		panel_2.add(textField_10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 404, 150, 39);
		panel.add(btnAdd);
		
		JButton btnUpdate_1_1 = new JButton("Cancel");
		btnUpdate_1_1.setBounds(170, 404, 150, 39);
		panel.add(btnUpdate_1_1);
		frmFacilityAddPage.setBounds(100, 100, 725, 507);
		frmFacilityAddPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
