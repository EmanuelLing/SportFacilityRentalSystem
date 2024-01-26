// FacilityUpdateView.java
package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FacilityUpdateView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField txtFacilityId;
    private JTextField txtType;
    private JTextField txtName;
    private JTextField txtLocation;
    private JTextField txtCapacity;
    private JTextField txtRentalCost;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FacilityUpdateView frame = new FacilityUpdateView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FacilityUpdateView() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 834, 440);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 814, 319);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Facility ID", "Type", "Name", "Location", "Capacity", "Rental Cost"
                }
        ));
        scrollPane.setViewportView(table);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle update button action
                String facilityId = txtFacilityId.getText();
                String type = txtType.getText();
                String name = txtName.getText();
                String location = txtLocation.getText();
                String capacity = txtCapacity.getText();
                String rentalCost = txtRentalCost.getText();

                // You can implement the update logic using the obtained values
                // For example, you can print them for now
                System.out.println("Facility ID: " + facilityId);
                System.out.println("Type: " + type);
                System.out.println("Name: " + name);
                System.out.println("Location: " + location);
                System.out.println("Capacity: " + capacity);
                System.out.println("Rental Cost: " + rentalCost);
            }
        });
        btnUpdate.setBounds(315, 339, 150, 39);
        contentPane.add(btnUpdate);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FacilityStatusView facilityStatusView = new FacilityStatusView();
                facilityStatusView.setVisible(true);
                dispose(); // Close the FacilityUpdateView window
            }
        });
        btnBack.setBounds(10, 339, 150, 39);
        contentPane.add(btnBack);

        JLabel lblFacilityUpdate = new JLabel("FACILITY UPDATE");
        lblFacilityUpdate.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblFacilityUpdate.setBounds(10, 369, 256, 40);
        contentPane.add(lblFacilityUpdate);

        JLabel lblFacilityId = new JLabel("Facility ID:");
        lblFacilityId.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblFacilityId.setBounds(10, 389, 197, 34);
        contentPane.add(lblFacilityId);

        txtFacilityId = new JTextField();
        txtFacilityId.setBounds(155, 392, 224, 33);
        contentPane.add(txtFacilityId);
        txtFacilityId.setColumns(10);

        JLabel lblType = new JLabel("Type:");
        lblType.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblType.setBounds(10, 423, 197, 34);
        contentPane.add(lblType);

        txtType = new JTextField();
        txtType.setBounds(155, 426, 224, 33);
        contentPane.add(txtType);
        txtType.setColumns(10);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblName.setBounds(10, 467, 197, 34);
        contentPane.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(155, 470, 224, 33);
        contentPane.add(txtName);
        txtName.setColumns(10);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblLocation.setBounds(10, 501, 197, 34);
        contentPane.add(lblLocation);

        txtLocation = new JTextField();
        txtLocation.setBounds(155, 504, 224, 33);
        contentPane.add(txtLocation);
        txtLocation.setColumns(10);

        JLabel lblCapacity = new JLabel("Capacity:");
        lblCapacity.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblCapacity.setBounds(10, 535, 197, 34);
        contentPane.add(lblCapacity);

        txtCapacity = new JTextField();
        txtCapacity.setBounds(155, 538, 224, 33);
        contentPane.add(txtCapacity);
        txtCapacity.setColumns(10);

        JLabel lblRentalCost = new JLabel("Rental Cost:");
        lblRentalCost.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblRentalCost.setBounds(10, 569, 197, 34);
        contentPane.add(lblRentalCost);

        txtRentalCost = new JTextField();
        txtRentalCost.setBounds(155, 572, 224, 33);
        contentPane.add(txtRentalCost);
        txtRentalCost.setColumns(10);
    }
}
