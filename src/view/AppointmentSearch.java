package view;

import controller.AppointmentQueries;
import controller.AppointmentTableListener;
import controller.DateListener;
import controller.PatientQueries;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.Appointment;
import util.WeekGenerator;

public class AppointmentSearch extends JDialog {

    /**
     * Create the dialog.
     */
    public AppointmentSearch(int partnerID, JTable partnerTable, JComboBox tableWeek,
        JComboBox tableMonth, JComboBox tableYear, JButton cancelPartnerButton,
        JButton viewPartnerButton) {
        // Main content panel
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{33, 52, 50, 50, 76, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{35, 25, 20, 24, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
            Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);

        // Label for search appointment title
        JLabel lblSearchAppointment = new JLabel("Search Appointment");
        lblSearchAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GridBagConstraints gbc_lblSearchAppointment = new GridBagConstraints();
        gbc_lblSearchAppointment.anchor = GridBagConstraints.NORTH;
        gbc_lblSearchAppointment.insets = new Insets(0, 0, 5, 5);
        gbc_lblSearchAppointment.gridwidth = 4;
        gbc_lblSearchAppointment.gridx = 1;
        gbc_lblSearchAppointment.gridy = 1;
        contentPanel.add(lblSearchAppointment, gbc_lblSearchAppointment);

        // Label for patient ID to search
        JLabel lblSearch = new JLabel("Patient ID:");
        GridBagConstraints gbc_lblSearch = new GridBagConstraints();
        gbc_lblSearch.anchor = GridBagConstraints.WEST;
        gbc_lblSearch.insets = new Insets(0, 0, 5, 5);
        gbc_lblSearch.gridx = 1;
        gbc_lblSearch.gridy = 2;
        contentPanel.add(lblSearch, gbc_lblSearch);

        // Text field to input patient ID
        JTextField textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.anchor = GridBagConstraints.NORTH;
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.gridwidth = 3;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 2;
        contentPanel.add(textField, gbc_textField);
        textField.setColumns(10);

        JLabel lblDate = new JLabel("Date:");
        GridBagConstraints gbc_lblDate = new GridBagConstraints();
        gbc_lblDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblDate.gridx = 1;
        gbc_lblDate.gridy = 3;
        contentPanel.add(lblDate, gbc_lblDate);

        Calendar tempCal = new GregorianCalendar().getInstance();
        // ComboBox for day
        JComboBox comboDay = new JComboBox();
        GridBagConstraints gbc_comboDay = new GridBagConstraints();
        gbc_comboDay.fill = GridBagConstraints.BOTH;
        gbc_comboDay.insets = new Insets(0, 0, 5, 5);
        gbc_comboDay.gridx = 2;
        gbc_comboDay.gridy = 3;
        contentPanel.add(comboDay, gbc_comboDay);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboDay.addItem(i);
        }
        comboDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));

        // ComboBox for month
        JComboBox comboMonth = new JComboBox();
        GridBagConstraints gbc_comboMonth = new GridBagConstraints();
        gbc_comboMonth.fill = GridBagConstraints.BOTH;
        gbc_comboMonth.insets = new Insets(0, 0, 5, 5);
        gbc_comboMonth.gridx = 3;
        gbc_comboMonth.gridy = 3;
        contentPanel.add(comboMonth, gbc_comboMonth);
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        comboMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);

        // ComboBox for year
        JComboBox comboYear = new JComboBox();
        GridBagConstraints gbc_comboYear = new GridBagConstraints();
        gbc_comboYear.insets = new Insets(0, 0, 5, 5);
        gbc_comboYear.fill = GridBagConstraints.BOTH;
        gbc_comboYear.gridx = 4;
        gbc_comboYear.gridy = 3;
        contentPanel.add(comboYear, gbc_comboYear);
        int currentYear = tempCal.get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 2; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedItem(currentYear);

        comboMonth.addActionListener(new DateListener(comboDay, comboMonth, comboYear));
        comboYear.addActionListener(new DateListener(comboDay, comboMonth, comboYear));

        // Button panel
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        // OK button
        JButton okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(e -> {
            if (textField.getText().isEmpty()
                || Integer.parseInt(textField.getText()) > PatientQueries.getNewPatientID() - 1) {
                JOptionPane.showMessageDialog(null, "Please Insert Valid Patient ID");
            } else {
            	SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            	String dateString = comboDay.getSelectedItem() + "/" + comboMonth.getSelectedItem() + "/" + comboYear.getSelectedItem()+" 09:00";
            	Date selectedDate;
            	try {
					selectedDate = new java.sql.Date(timeFormat.parse(dateString).getTime());
					Calendar loopCal = new GregorianCalendar();
					loopCal.setTime(selectedDate);
					boolean valid = false;
					for (int i=0; i<24; i++ ) {
						Appointment tempApp = AppointmentQueries.getAppointment(selectedDate,partnerID,Integer.parseInt(textField.getText()), new java.sql.Time(loopCal.getTime().getTime()));
						if (tempApp != null) {
								valid = true;
						}
						loopCal.add(Calendar.MINUTE, 20);
					}
					if (valid) {
						SimpleDateFormat weekTimeFormat = new SimpleDateFormat("dd-MM-yyyy");
						tableYear.setSelectedItem(comboYear.getSelectedItem());
						tableMonth.setSelectedItem(comboMonth.getSelectedItem());
						loopCal.set(Calendar.DAY_OF_WEEK, 2);
						String monday = weekTimeFormat.format(loopCal.getTime());
						loopCal.set(Calendar.DAY_OF_WEEK, 6);
						String friday = weekTimeFormat.format(loopCal.getTime());
						tableWeek.setModel(new DefaultComboBoxModel(WeekGenerator.weekList(loopCal)));
						System.out.println(monday+" - "+friday);
						tableWeek.setSelectedItem(monday+" - "+friday);
						AppointmentTableListener.refreshTable(partnerTable, monday, partnerID, cancelPartnerButton, viewPartnerButton);	
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No Appointment is available for the patient selected");
					}
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 		
            }
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        // Basic settings
        setTitle("Search Appointment");
        setBounds(100, 100, 332, 226);
        setResizable(false);
        setLocationRelativeTo(null);
        okButton.addActionListener(e -> {

        });
    }
}
