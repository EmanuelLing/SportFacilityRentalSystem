package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import model.FacilityReservation;

public class FacilityStatusView {

    private JFrame frmFacilityStatusPage;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FacilityStatusView window = new FacilityStatusView();
                    window.frmFacilityStatusPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FacilityStatusView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmFacilityStatusPage = new JFrame();
        frmFacilityStatusPage.setTitle("FACILITY STATUS PAGE");
        frmFacilityStatusPage.getContentPane().setBackground(Color.DARK_GRAY);
        frmFacilityStatusPage.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(10, 10, 834, 440);
        frmFacilityStatusPage.getContentPane().add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 814, 319);
        panel.add(scrollPane);

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
                new FacilityUpdateView();
            }
        });
        btnUpdate.setBounds(315, 339, 150, 39);
        panel.add(btnUpdate);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmFacilityStatusPage.dispose();
                new MainMenuView();
            }
        });
        btnBack.setBounds(10, 339, 150, 39);
        panel.add(btnBack);

        JLabel lblFacilityStatus = new JLabel("FACILITY STATUS");
        lblFacilityStatus.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblFacilityStatus.setBounds(10, 369, 256, 40);
        panel.add(lblFacilityStatus);

        frmFacilityStatusPage.setBounds(100, 100, 863, 499);
        frmFacilityStatusPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setTableData(List<FacilityReservation> facilityList) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (FacilityReservation facility : facilityList) {
            model.addRow(new Object[] {
                    facility.getFacilityId(),
                    facility.getType(),
                    facility.getName(),
                    facility.getLocation(),
                    facility.getCapacity(),
                    facility.getRentalCost()
            });
        }
    }
}