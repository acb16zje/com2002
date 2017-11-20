package view;

import controller.DateListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BookAppointment extends JDialog {
	private JTextField patientID;

    /**
     * Create the dialog.
     */
    public BookAppointment(String radioButton) {
        // Main content panel
        JPanel contentPanel = new JPanel();
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // Main label for "Book Appointment" in the top middle
        JLabel mainLabel = new JLabel("Book Appointment");
        mainLabel.setBounds(110, 23, 165, 19);
        mainLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        contentPanel.add(mainLabel);
        patientID = new JTextField();
        patientID.setFont(new Font("Dialog", Font.PLAIN, 16));
        patientID.setColumns(10);
        patientID.setBounds(105, 88, 194, 23);
        contentPanel.add(patientID);
        
        JLabel lblPatientID = new JLabel("Patient ID:");
        lblPatientID.setBounds(24, 95, 75, 15);
        contentPanel.add(lblPatientID);
        
        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(24, 57, 39, 15);
        contentPanel.add(lblType);
        
        JRadioButton checkUpRadioButton = new JRadioButton(radioButton);
        checkUpRadioButton.setBounds(105, 53, 90, 23);
        contentPanel.add(checkUpRadioButton);
        
        JRadioButton treatmentRadioButton = new JRadioButton("Treatment");
        treatmentRadioButton.setBounds(197, 53, 76, 23);
        contentPanel.add(treatmentRadioButton);
        
        JRadioButton holidayRadioButton = new JRadioButton("Holiday");
        holidayRadioButton.setBounds(289, 53, 76, 23);
        contentPanel.add(holidayRadioButton);
        
        // Date label
        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(34, 135, 39, 15);
        contentPanel.add(lblDate);

        //calendar object to create date combobox
        Calendar tempCal = new GregorianCalendar();

        // ComboBox for day
        JComboBox comboDay = new JComboBox();
        comboDay.setBounds(115, 130, 50, 24);
        contentPanel.add(comboDay);
        int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboDay.addItem(i);
        }
        comboDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));

        // ComboBox for month
        JComboBox comboMonth = new JComboBox();
        comboMonth.setBounds(177, 130, 50, 24);
        contentPanel.add(comboMonth);
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        comboMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);

        // ComboBox for year
        JComboBox comboYear = new JComboBox();
        comboYear.setBounds(239, 130, 76, 24);
        contentPanel.add(comboYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 2; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedItem(tempCal.get(Calendar.YEAR));

        comboMonth.addActionListener(new DateListener(comboDay, comboMonth, comboYear));
        comboYear.addActionListener(new DateListener(comboDay, comboMonth, comboYear));
        // Label for Start Time
        JLabel lblStartTime = new JLabel("Start Time:");
        lblStartTime.setBounds(34, 175, 76, 15);
        contentPanel.add(lblStartTime);

        // ComboBox for start time, 20 minutes interval
        JComboBox comboStartTime = new JComboBox();
        comboStartTime.setBounds(115, 170, 68, 24);
        comboStartTime.setEditable(false);
        for (int hour = 9; hour < 17; hour++) {
            for (int min = 0; min < 6; min += 2) {
                if (hour == 9) {
                    comboStartTime
                        .addItem("0" + String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                } else {
                    comboStartTime.addItem(String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                }
            }
        }
        contentPanel.add(comboStartTime);
       
        JLabel lblEndDate = new JLabel("End Date:");
        lblEndDate.setBounds(34, 215, 50, 15);
        lblEndDate.setVisible(false);
        lblEndDate.setEnabled(false);
        contentPanel.add(lblEndDate);
        
        JComboBox comboEndDay = new JComboBox();
        comboEndDay.setBounds(115, 210, 50, 24);
        comboEndDay.setVisible(false);
        comboEndDay.setEnabled(false);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboEndDay.addItem(i);
        }
        comboEndDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));
        contentPanel.add(comboEndDay);
        
        JComboBox comboEndMonth = new JComboBox();
        comboEndMonth.setBounds(177, 210, 50, 24);
        comboEndMonth.setVisible(false);
        comboEndMonth.setEnabled(false);
        for (int i = 1; i <= 12; i++) {
            comboEndMonth.addItem(i);
        }
        comboEndMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);
        contentPanel.add(comboEndMonth);
        
        JComboBox comboEndYear = new JComboBox();
        comboEndYear.setBounds(239, 210, 76, 24);
        comboEndYear.setVisible(false);
        comboEndYear.setEnabled(false);
        int currentEndYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentEndYear; i <= currentYear + 2; i++) {
            comboEndYear.addItem(i);
        }
        comboYear.setSelectedItem(tempCal.get(Calendar.YEAR));
        contentPanel.add(comboEndYear);
        
        JLabel lblEndTime = new JLabel("End Time:");
        lblEndTime.setBounds(34, 254, 76, 15);
        lblEndTime.setVisible(false);
        lblEndTime.setEnabled(false);
        contentPanel.add(lblEndTime);
        
        JComboBox comboEndTime = new JComboBox();
        comboEndTime.setEditable(false);
        comboEndTime.setBounds(115, 249, 68, 24);
        comboEndTime.setVisible(false);
        comboEndTime.setEnabled(false);
        for (int hour = 9; hour <= 17; hour++) {
        	if (hour == 9) {
        		for (int min = 2; min < 6; min += 2) {
        			comboEndTime.addItem("0" + String.valueOf(hour) + ":" + String.valueOf(min) + "0");
        		}
        	}
        	else if (hour == 17 ) {
        		comboEndTime.addItem("17:00");
        	}
        	else {
	            for (int min = 0; min < 6; min += 2) {
	                    comboEndTime.addItem(String.valueOf(hour) + ":" + String.valueOf(min) + "0");
	                }
	        }
        }
           
        contentPanel.add(comboEndTime);
        
        comboEndMonth.addActionListener(new DateListener(comboEndDay, comboEndMonth, comboEndYear));
        comboEndYear.addActionListener(new DateListener(comboEndDay, comboEndMonth, comboEndYear));
        
        holidayRadioButton.addActionListener(e ->{
        	lblEndDate.setVisible(true);
        	lblEndDate.setEnabled(true);
        	comboEndDay.setVisible(true);
        	comboEndDay.setEnabled(true);
        	comboEndMonth.setVisible(true);
        	comboEndMonth.setEnabled(true);
        	comboEndYear.setVisible(true);
        	comboEndYear.setEnabled(true);
        	lblEndTime.setVisible(true);
        	lblEndTime.setEnabled(true);
        	comboEndTime.setVisible(true);
        	comboEndTime.setEnabled(true);
        });
        treatmentRadioButton.addActionListener(e ->{
        	lblEndDate.setVisible(false);
        	lblEndDate.setEnabled(false);
        	comboEndDay.setVisible(false);
        	comboEndDay.setEnabled(false);
        	comboEndMonth.setVisible(false);
        	comboEndMonth.setEnabled(false);
        	comboEndYear.setVisible(false);
        	comboEndYear.setEnabled(false);
        	lblEndTime.setVisible(false);
        	lblEndTime.setEnabled(false);
        	comboEndTime.setVisible(false);
        	comboEndTime.setEnabled(false);
        });
        checkUpRadioButton.addActionListener(e ->{
        	lblEndDate.setVisible(false);
        	lblEndDate.setEnabled(false);
        	comboEndDay.setVisible(false);
        	comboEndDay.setEnabled(false);
        	comboEndMonth.setVisible(false);
        	comboEndMonth.setEnabled(false);
        	comboEndYear.setVisible(false);
        	comboEndYear.setEnabled(false);
        	lblEndTime.setVisible(false);
        	lblEndTime.setEnabled(false);
        	comboEndTime.setVisible(false);
        	comboEndTime.setEnabled(false);
        });
        
        ButtonGroup treatmentGroup = new ButtonGroup();
        treatmentGroup.add(checkUpRadioButton);
        treatmentGroup.add(treatmentRadioButton);
        treatmentGroup.add(holidayRadioButton);
        
        // Button panel
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        // OK button, create a new appointment
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            // insert SQL query here

            // Check if appointment date is valid
            Calendar inputDate = new GregorianCalendar((int) comboYear.getSelectedItem(),
                ((int) comboMonth.getSelectedItem()) - 1, (int) comboDay.getSelectedItem());

            if (isValidDate(inputDate)) {
                // insert SQL query here
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "We're closed on Saturday and Sunday");
            }


        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        // Cancel button, dispose the dialog
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        // Basic settings
        setTitle("Book Appointment");
        setBounds(100, 100, 395, 406);
        setResizable(false);
    }

    /**
     * Check if the input date is valid
     *
     * @param date The date to check
     * @return True if the date is valid
     */
    private boolean isValidDate(Calendar date) {
        return !(date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
            || date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
    }
}
