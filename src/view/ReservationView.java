package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

import controller.PaymentController;
import controller.ReservationController;
import model.Payment;
import model.Reservation;

public class ReservationView {

	private JFrame frmReservationInfoPage;
	private JTextField customerTextField;
	private JTextField facilityTextField;
	private JTextField reservationIdTextField;
	private JSpinner dateSpinner;
	private JSpinner startTimeSpinner;
	private JSpinner endTimeSpinner;
	private JTextField staffTextField;
	private JSpinner paymentIdSpinner;
	
	private ReservationController reservationController = new ReservationController();
	private PaymentController paymentController = new PaymentController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationView window = new ReservationView(new Reservation());
					window.frmReservationInfoPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReservationView(Reservation reservation) {
		initialize(reservation);
		frmReservationInfoPage.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Reservation reservation) {
		frmReservationInfoPage = new JFrame();
		frmReservationInfoPage.setTitle("RESERVATION INFO PAGE");
		frmReservationInfoPage.getContentPane().setBackground(Color.DARK_GRAY);
		frmReservationInfoPage.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 10, 834, 440);
		frmReservationInfoPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 408, 119);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFacilityReference = new JLabel("Facility:");
		lblFacilityReference.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblFacilityReference.setBounds(10, 10, 197, 34);
		panel_1.add(lblFacilityReference);
		
		customerTextField = new JTextField();
		customerTextField.setBounds(10, 75, 378, 34);
		panel_1.add(customerTextField);
		customerTextField.setColumns(10);
		customerTextField.setText(reservation.getCustomer().getCustomerId() + " - " + 
		reservation.getCustomer().getName());
		customerTextField.setEditable(false);
		
		JLabel lblFacilityName = new JLabel("Facility ID:");
		lblFacilityName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblFacilityName.setBounds(10, 40, 197, 34);
		panel_1.add(lblFacilityName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(426, 10, 398, 119);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCustomerReference = new JLabel("Customer:");
		lblCustomerReference.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblCustomerReference.setBounds(10, 10, 226, 34);
		panel_2.add(lblCustomerReference);
		
		JLabel lblFacilityName_1 = new JLabel("Customer ID:");
		lblFacilityName_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblFacilityName_1.setBounds(10, 38, 197, 34);
		panel_2.add(lblFacilityName_1);
		
		facilityTextField = new JTextField();
		facilityTextField.setColumns(10);
		facilityTextField.setBounds(10, 75, 378, 34);
		panel_2.add(facilityTextField);
		facilityTextField.setText(reservation.getSportFacility().getFacilityId() + " - " + 
		reservation.getSportFacility().getFacilityName());
		facilityTextField.setEditable(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 139, 556, 245);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblReservationDetails = new JLabel("Reservation Details:");
		lblReservationDetails.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblReservationDetails.setBounds(10, 10, 197, 34);
		panel_3.add(lblReservationDetails);
		
		reservationIdTextField = new JTextField();
		reservationIdTextField.setColumns(10);
		reservationIdTextField.setBounds(155, 57, 391, 33);
		panel_3.add(reservationIdTextField);
		reservationIdTextField.setText(reservation.getReservationId());
		reservationIdTextField.setEditable(false);
		
		JLabel lblReservationId = new JLabel("Reservation ID:");
		lblReservationId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblReservationId.setBounds(10, 54, 197, 34);
		panel_3.add(lblReservationId);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblDate.setBounds(10, 100, 197, 34);
		panel_3.add(lblDate);
		
        // Create a SimpleDateFormat to parse the string date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Parse the string date to create a Date object
        Date initialDate;
        try {
            initialDate = dateFormat.parse(reservation.getReservationDate());
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
		
        // Create a SpinnerDateModel
        SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, null, null, Calendar.DAY_OF_MONTH);
        dateSpinner = new JSpinner(dateModel);

        // Configure the date format
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setBounds(155, 100, 224, 33);
        panel_3.add(dateSpinner);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTime.setBounds(10, 144, 197, 34);
		panel_3.add(lblTime);
		
        // Create a SimpleDateFormat to parse and format time
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
        // Parse the default time string to create a Date object
        Date defaultDate;
        try {
            defaultDate = timeFormat.parse(reservation.getStartTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
		
        // Create a SpinnerDateModel for time values
        SpinnerDateModel spinnerModel = new SpinnerDateModel(defaultDate, null, null, Calendar.HOUR_OF_DAY);

		startTimeSpinner = new JSpinner(spinnerModel);
		
        // Set a custom editor to display only the time portion
        JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(startTimeSpinner, "HH:mm");
        startTimeSpinner.setEditor(startTimeEditor);
		startTimeSpinner.setBounds(155, 144, 96, 33);
		panel_3.add(startTimeSpinner);
		
        try {
            defaultDate = timeFormat.parse(reservation.getEndTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
		
		spinnerModel = new SpinnerDateModel(defaultDate, null, null, Calendar.HOUR_OF_DAY);
		endTimeSpinner = new JSpinner(spinnerModel);
		
        // Set a custom editor to display only the time portion
        JSpinner.DateEditor endTimeEditor = new JSpinner.DateEditor(endTimeSpinner, "HH:mm");
        endTimeSpinner.setEditor(endTimeEditor);
		endTimeSpinner.setBounds(281, 144, 96, 33);
		panel_3.add(endTimeSpinner);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblTo.setBounds(261, 143, 197, 34);
		panel_3.add(lblTo);
		
		JLabel lblStaffInCharge = new JLabel("Staff in charge:");
		lblStaffInCharge.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblStaffInCharge.setBounds(10, 188, 197, 34);
		panel_3.add(lblStaffInCharge);
		
		staffTextField = new JTextField();
		staffTextField.setColumns(10);
		staffTextField.setBounds(155, 188, 224, 33);
		panel_3.add(staffTextField);
		staffTextField.setText(reservation.getStaff().getName());
		staffTextField.setEditable(false);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(576, 139, 248, 245);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details:");
		lblPaymentDetails.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPaymentDetails.setBounds(10, 10, 197, 34);
		panel_4.add(lblPaymentDetails);
		
		Payment payment = new Payment();
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(57, 154, 150, 39);
		panel_4.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frmReservationInfoPage.dispose();
				new PaymentView(payment);
			}
		});
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(57, 196, 150, 39);
		panel_4.add(btnPay);
		btnPay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frmReservationInfoPage.dispose();
				
				Object selectedValue = paymentIdSpinner.getValue();
				String paymentId = String.valueOf(selectedValue);
				new PaymentAddView(reservation, paymentId);
			}
		});
		
		int defaultPaymentId = 1;
		
		try {
			if (paymentController.checkPayment(reservation, payment))
			{
				defaultPaymentId = Integer.parseInt(payment.getPaymentId());
				
				SpinnerNumberModel idModel = new SpinnerNumberModel(defaultPaymentId, 1, 999, 1);
				paymentIdSpinner = new JSpinner(idModel);
				paymentIdSpinner.setBounds(10, 90, 228, 34);
				panel_4.add(paymentIdSpinner);
				
				paymentIdSpinner.setEnabled(false);
				btnPay.setEnabled(false);
			}
			else
			{
				SpinnerNumberModel idModel = new SpinnerNumberModel(defaultPaymentId, 1, 999, 1);
				paymentIdSpinner = new JSpinner(idModel);
				paymentIdSpinner.setBounds(10, 90, 228, 34);
				panel_4.add(paymentIdSpinner);
				
				btnUpdate.setEnabled(false);
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblPaymentId = new JLabel("Payment ID:");
		lblPaymentId.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblPaymentId.setBounds(10, 54, 197, 34);
		panel_4.add(lblPaymentId);
		
		JButton btnConfirm = new JButton("Update");
		btnConfirm.setBounds(10, 393, 150, 39);
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Date selectedDate = (Date) dateSpinner.getValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = dateFormat.format(selectedDate);        
				reservation.setReservationDate(formattedDate);
				
				Date startTime = (Date) startTimeSpinner.getValue();
				SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
				String formattedStartTime = timeFormat.format(startTime);	
				reservation.setStartTime(formattedStartTime + ":00");
				
				Date endTime = (Date) endTimeSpinner.getValue();
				String formattedEndTime = timeFormat.format(endTime);	
				reservation.setEndTime(formattedEndTime + ":00");
				
				try {
					reservationController.updateReservation(reservation);
					JOptionPane.showMessageDialog(null, "Update Reservation Success");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 394, 150, 39);
		panel.add(btnCancel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(674, 394, 150, 39);
		panel.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this reservation? "
                        + "If you delete this reservation, the payment related to it "
                        + "will also being deleted", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                	try {
						if (paymentController.checkPayment(reservation, payment))
						{
							paymentController.deletePayment(payment);
							reservationController.deleteReservation(reservation);
							JOptionPane.showMessageDialog(null, "Reservation and Payment Deleted");
						}
						else
						{
							reservationController.deleteReservation(reservation);
							JOptionPane.showMessageDialog(null, "Reservation Deleted");
						}
						frmReservationInfoPage.dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }
        });
		
		frmReservationInfoPage.setBounds(100, 100, 871, 499);
		frmReservationInfoPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}

}
