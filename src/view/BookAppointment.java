package view;

import controller.AppointmentQueries;
import controller.BookingListener;
import controller.PatientQueries;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.text.AbstractDocument;
import model.Appointment;
import util.DateHandler;
import util.IntegerFilter;

public class BookAppointment extends JDialog {

    /**
     * Create the dialog.
     */
    public BookAppointment(String radioButton, int partnerID) {
        // Calendar object to create date combobox
        Calendar tempCal = new GregorianCalendar();

        // Main content panel
        JPanel contentPanel = new JPanel();
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // Main label for "Book Appointment" in the top middle
        JLabel mainLabel = new JLabel("Book Appointment");
        mainLabel.setBounds(167, 22, 165, 19);
        mainLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        contentPanel.add(mainLabel);

        // Label for patient ID
        JLabel patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setBounds(46, 116, 75, 15);
        contentPanel.add(patientIDLabel);

        // Text field for patient ID
        JTextField patientID = new JTextField();
        ((AbstractDocument) patientID.getDocument()).setDocumentFilter(new IntegerFilter(10));
        patientID.setBounds(147, 112, 154, 23);
        patientID.setFont(new Font("Dialog", Font.PLAIN, 16));
        patientID.setColumns(10);
        contentPanel.add(patientID);

        // Date label
        JLabel startDateLabel = new JLabel("Date:");
        startDateLabel.setBounds(46, 157, 39, 15);
        contentPanel.add(startDateLabel);

        // ComboBox for day
        JComboBox comboDay = new JComboBox();
        comboDay.setBounds(147, 153, 50, 24);
        contentPanel.add(comboDay);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboDay.addItem(i);
        }
        comboDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));

        // ComboBox for month
        JComboBox comboMonth = new JComboBox();
        comboMonth.setBounds(209, 153, 50, 24);
        contentPanel.add(comboMonth);
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        comboMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);

        // ComboBox for year
        JComboBox comboYear = new JComboBox();
        comboYear.setBounds(271, 153, 76, 24);
        contentPanel.add(comboYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 2; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedItem(tempCal.get(Calendar.YEAR));

        // Label for Start Time
        JLabel startTimeLabel = new JLabel("Start Time:");
        startTimeLabel.setBounds(46, 198, 78, 15);
        contentPanel.add(startTimeLabel);

        // ComboBox for start time, 20 minutes interval
        JComboBox comboStartTime = new JComboBox();
        comboStartTime.setBounds(147, 193, 68, 24);
        comboStartTime.setEditable(false);
        contentPanel.add(comboStartTime);

        //get all available time
        Boolean[] avaibilityBoolean = AppointmentQueries.getAvailableTime(DateHandler
            .newDate((int) comboYear.getSelectedItem(), (int) comboMonth.getSelectedItem(),
                (int) comboDay.getSelectedItem()), partnerID);
        int cellValue = 0;
        for (int hour = 9; hour < 17; hour++) {
            for (int min = 0; min < 6; min += 2) {
                if (avaibilityBoolean[cellValue]) {
                    if (hour == 9) {
                        comboStartTime
                            .addItem("0" + String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                    } else {
                        comboStartTime
                            .addItem(String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                    }
                }
                cellValue++;
            }
        }

        // Label for end date
        JLabel endDateLabel = new JLabel("End Date:");
        endDateLabel.setBounds(46, 239, 69, 15);
        endDateLabel.setVisible(false);
        endDateLabel.setEnabled(false);
        contentPanel.add(endDateLabel);

        // ComboBox for end day
        JComboBox comboEndDay = new JComboBox();
        comboEndDay.setBounds(147, 234, 50, 24);
        comboEndDay.setVisible(false);
        comboEndDay.setEnabled(false);
        contentPanel.add(comboEndDay);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboEndDay.addItem(i);
        }
        comboEndDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));

        // ComboBox for end month
        JComboBox comboEndMonth = new JComboBox();
        comboEndMonth.setBounds(209, 234, 50, 24);
        comboEndMonth.setVisible(false);
        comboEndMonth.setEnabled(false);
        contentPanel.add(comboEndMonth);
        for (int i = 1; i <= 12; i++) {
            comboEndMonth.addItem(i);
        }
        comboEndMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);

        // ComboBox for end year
        JComboBox comboEndYear = new JComboBox();
        comboEndYear.setBounds(271, 234, 76, 24);
        comboEndYear.setVisible(false);
        comboEndYear.setEnabled(false);
        contentPanel.add(comboEndYear);
        int currentEndYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentEndYear; i <= currentYear + 2; i++) {
            comboEndYear.addItem(i);
        }
        comboYear.setSelectedItem(tempCal.get(Calendar.YEAR));

        // Label for end time
        JLabel endTimeLabel = new JLabel("End Time:");
        endTimeLabel.setBounds(46, 283, 68, 15);
        endTimeLabel.setVisible(false);
        endTimeLabel.setEnabled(false);
        contentPanel.add(endTimeLabel);

        // ComboBox for end time
        JComboBox comboEndTime = new JComboBox();
        comboEndTime.setBounds(147, 278, 68, 24);
        comboEndTime.setEditable(false);
        comboEndTime.setVisible(false);
        comboEndTime.setEnabled(false);
        contentPanel.add(comboEndTime);
        int cellEndValue = 0;
        Boolean[] endAvaibilityBoolean = AppointmentQueries.getAvailableTime(DateHandler
            .newDate((int) comboEndYear.getSelectedItem(), (int) comboEndMonth.getSelectedItem(),
                (int) comboEndDay.getSelectedItem()), partnerID);
        for (int hour = 9; hour <= 17; hour++) {
            if (hour == 9) {
                for (int min = 2; min < 6; min += 2) {
                    if (endAvaibilityBoolean[cellEndValue]) {
                        comboEndTime
                            .addItem("0" + String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                    }
                    cellEndValue++;
                }
            } else if (hour == 17) {
                if (endAvaibilityBoolean[cellEndValue]) {
                    comboEndTime.addItem("17:00");
                }
            } else {
                for (int min = 0; min < 6; min += 2) {
                    if (endAvaibilityBoolean[cellEndValue]) {
                        comboEndTime
                            .addItem(String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                    }
                    cellEndValue++;
                }
            }
        }

        // Listener for start month and year
        comboDay.addActionListener(
            new BookingListener(comboDay, comboMonth, comboYear, comboStartTime, "Start",
                partnerID));
        comboMonth.addActionListener(
            new BookingListener(comboDay, comboMonth, comboYear, comboStartTime, "Start",
                partnerID));
        comboYear.addActionListener(
            new BookingListener(comboDay, comboMonth, comboYear, comboStartTime, "Start",
                partnerID));

        // Listener for end month and year
        comboEndDay.addActionListener(
            new BookingListener(comboEndDay, comboEndMonth, comboEndYear, comboEndTime, "End",
                partnerID));
        comboEndMonth.addActionListener(
            new BookingListener(comboEndDay, comboEndMonth, comboEndYear, comboEndTime, "End",
                partnerID));
        comboEndYear.addActionListener(
            new BookingListener(comboEndDay, comboEndMonth, comboEndYear, comboEndTime, "End",
                partnerID));

        // Button group for check up, treatment. holiday
        ButtonGroup treatmentGroup = new ButtonGroup();

        // Label for type
        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(46, 75, 39, 15);
        contentPanel.add(typeLabel);

        // Radio button for check up
        JRadioButton checkUpRadioButton = new JRadioButton(radioButton);
        checkUpRadioButton.setBounds(147, 71, 117, 23);
        contentPanel.add(checkUpRadioButton);
        checkUpRadioButton.addActionListener(e -> {
            endDateLabel.setVisible(false);
            endDateLabel.setEnabled(false);
            comboEndDay.setVisible(false);
            comboEndDay.setEnabled(false);
            comboEndMonth.setVisible(false);
            comboEndMonth.setEnabled(false);
            comboEndYear.setVisible(false);
            comboEndYear.setEnabled(false);
            endTimeLabel.setVisible(false);
            endTimeLabel.setEnabled(false);
            comboEndTime.setVisible(false);
            comboEndTime.setEnabled(false);
            patientID.setVisible(true);
            patientID.setEnabled(true);
        });
        treatmentGroup.add(checkUpRadioButton);

        // Radio button for treatment
        JRadioButton treatmentRadioButton = new JRadioButton("Treatment");
        treatmentRadioButton.addActionListener(e -> {
            endDateLabel.setVisible(false);
            endDateLabel.setEnabled(false);
            comboEndDay.setVisible(false);
            comboEndDay.setEnabled(false);
            comboEndMonth.setVisible(false);
            comboEndMonth.setEnabled(false);
            comboEndYear.setVisible(false);
            comboEndYear.setEnabled(false);
            endTimeLabel.setVisible(false);
            endTimeLabel.setEnabled(false);
            comboEndTime.setVisible(false);
            comboEndTime.setEnabled(false);
            patientID.setVisible(true);
            patientID.setEnabled(true);
        });
        if (partnerID == 0) {
        	treatmentRadioButton.setBounds(260, 71, 99, 23);
            contentPanel.add(treatmentRadioButton);
        	treatmentGroup.add(treatmentRadioButton);
        }

        // Radio button for holiday
        JRadioButton holidayRadioButton = new JRadioButton("Holiday");
        holidayRadioButton.setBounds(377, 71, 78, 23);
        contentPanel.add(holidayRadioButton);
        holidayRadioButton.addActionListener(e -> {
            endDateLabel.setVisible(true);
            endDateLabel.setEnabled(true);
            comboEndDay.setVisible(true);
            comboEndDay.setEnabled(true);
            comboEndMonth.setVisible(true);
            comboEndMonth.setEnabled(true);
            comboEndYear.setVisible(true);
            comboEndYear.setEnabled(true);
            endTimeLabel.setVisible(true);
            endTimeLabel.setEnabled(true);
            comboEndTime.setVisible(true);
            comboEndTime.setEnabled(true);
            patientID.setVisible(false);
            patientID.setEnabled(false);
        });
        treatmentGroup.add(holidayRadioButton);

        // Button panel
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        // OK button, create a new appointment
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            // insert SQL query here

            boolean completed = false;
            // Check if all field are filled in
            Component[] components = contentPanel.getComponents();
            for (Component comp : components) {
                if (comp instanceof JRadioButton) {
                    completed = ((JRadioButton) comp).isSelected();
                    if (completed) {
                        break;
                    }
                }
            }

            components = contentPanel.getComponents();
            for (Component comp1 : components) {
                // Cast comp to JComboBox / JTextField to get the values
                if (comp1 instanceof JTextField) {
                    if (((JTextField) comp1).getText().isEmpty() && comp1.isShowing()) {
                        completed = false;
                        break;
                    } else if (comp1.isShowing() && Integer.parseInt(((JTextField) comp1).getText())
                        > PatientQueries.getNewPatientID() - 1) {
                        completed = false;
                        break;
                    }
                }
            }

            if (completed) {
                // Check if appointment date is valid
                int inputYear = (int) comboYear.getSelectedItem();
                int inputMonth = (int) comboMonth.getSelectedItem() - 1;
                int inputDay = (int) comboDay.getSelectedItem();
                Calendar inputDate = new GregorianCalendar(inputYear, inputMonth, inputDay);

                if (holidayRadioButton.isSelected()) {
                    SimpleDateFormat timeFormatCompare = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    try {
                        String startDateStr =
                            comboDay.getSelectedItem() + "/" + comboMonth.getSelectedItem() + "/"
                                + comboYear.getSelectedItem() + " " + comboStartTime
                                .getSelectedItem();
                        String endDateStr =
                            comboEndDay.getSelectedItem() + "/" + comboEndMonth.getSelectedItem()
                                + "/" + comboEndYear.getSelectedItem() + " " + comboEndTime
                                .getSelectedItem();
                        Date startDate = timeFormatCompare.parse(startDateStr);
                        Calendar startCal = Calendar.getInstance();
                        startCal.setTime(startDate);
                        Date endDate = timeFormatCompare.parse(endDateStr);
                        Calendar endCal = Calendar.getInstance();
                        endCal.setTime(endDate);
                        int diff = endDate.compareTo(startDate);
                        if (diff <= 0 || !isValidDate(startCal) || !isValidDate(endCal)) {
                            JOptionPane.showMessageDialog(null, "Invalid Time");
                        } else {
                            Calendar holCal = GregorianCalendar.getInstance();
                            holCal.setTime(startDate);
                            long totalDays = endDate.getTime() - startDate.getTime();
                            float daysBetween = (totalDays / (1000 * 60 * 60 * 24)) + 1;
                            if (daysBetween > 1) {
                                //check if whole holiday is valid
                                boolean validHol = true;
                                validHol = AppointmentQueries
                                    .validTime(new java.sql.Time(startDate.getTime()),
                                        Time.valueOf("17:00:00"),
                                        new java.sql.Date(holCal.getTime().getTime()), partnerID);
                                holCal.add(Calendar.DAY_OF_YEAR, 1);
                                for (int i = 1; i < daysBetween - 1 && validHol; i++) {
                                    validHol = AppointmentQueries
                                        .validTime(Time.valueOf("09:00:00"),
                                            Time.valueOf("17:00:00"),
                                            new java.sql.Date(holCal.getTime().getTime()),
                                            partnerID);
                                    holCal.add(Calendar.DAY_OF_YEAR, 1);
                                }
                                if (validHol) {
                                    validHol = AppointmentQueries
                                        .validTime(Time.valueOf("09:00:00"),
                                            new java.sql.Time(endDate.getTime()),
                                            new java.sql.Date(holCal.getTime().getTime()),
                                            partnerID);
                                }
                                //insert holiday is valid
                                if (validHol) {
                                    holCal.setTime(startDate);
                                    AppointmentQueries.insertAppointment(new Appointment(
                                        new java.sql.Date(holCal.getTime().getTime()),
                                        new java.sql.Time(startDate.getTime()),
                                        Time.valueOf("17:00:00"), 0, partnerID));
                                    holCal.add(Calendar.DAY_OF_YEAR, 1);
                                    for (int i = 1; i < daysBetween - 1; i++) {
                                        AppointmentQueries.insertAppointment(new Appointment(
                                            new java.sql.Date(holCal.getTime().getTime()),
                                            Time.valueOf("09:00:00"), Time.valueOf("17:00:00"), 0,
                                            partnerID));
                                        holCal.add(Calendar.DAY_OF_YEAR, 1);
                                    }
                                    AppointmentQueries.insertAppointment(new Appointment(
                                        new java.sql.Date(holCal.getTime().getTime()),
                                        Time.valueOf("09:00:00"),
                                        new java.sql.Time(endDate.getTime()), 0, partnerID));
                                    dispose();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid Time");
                                }
                            } else if (AppointmentQueries
                                .validTime(new java.sql.Time(startDate.getTime()),
                                    new java.sql.Time(endDate.getTime()),
                                    new java.sql.Date(holCal.getTime().getTime()), partnerID)) {
                                AppointmentQueries.insertAppointment(
                                    new Appointment(new java.sql.Date(holCal.getTime().getTime()),
                                        new java.sql.Time(startDate.getTime()),
                                        new java.sql.Time(endDate.getTime()), 0, partnerID));
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Time");
                            }

                        }
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    if (isValidDate(inputDate)) {

                        SimpleDateFormat timeFormatCompare = new SimpleDateFormat(
                            "dd/MM/yyyy HH:mm");
                        String startDateStr =
                            comboDay.getSelectedItem() + "/" + comboMonth.getSelectedItem() + "/"
                                + comboYear.getSelectedItem() + " " + comboStartTime
                                .getSelectedItem();
                        Date startDate;
                        try {
                            startDate = timeFormatCompare.parse(startDateStr);
                            Calendar startCal = Calendar.getInstance();
                            startCal.setTime(startDate);
                            if (treatmentRadioButton.isSelected()) {
                                startCal.add(Calendar.HOUR, 1);
                            } else if (checkUpRadioButton.isSelected()) {
                                startCal.add(Calendar.MINUTE, 20);
                            }
                            if (AppointmentQueries.validTime(new java.sql.Time(startDate.getTime()),
                                new java.sql.Time(startCal.getTime().getTime()),
                                new java.sql.Date(startCal.getTime().getTime()), partnerID)
                                && AppointmentQueries
                                .validPatientTime(new java.sql.Time(startDate.getTime()),
                                    new java.sql.Time(startCal.getTime().getTime()),
                                    new java.sql.Date(startCal.getTime().getTime()),
                                    Integer.parseInt(patientID.getText()), partnerID)) {
                                AppointmentQueries.insertAppointment(
                                    new Appointment(new java.sql.Date(startDate.getTime()),
                                        new java.sql.Time(startDate.getTime()),
                                        new java.sql.Time(startCal.getTime().getTime()),
                                        Integer.parseInt(patientID.getText()), partnerID));
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid Time");
                            }
                        } catch (ParseException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "We're closed on Saturday and Sunday");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Complete/Invalid Patient ID");
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
        setBounds(100, 100, 493, 406);
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
