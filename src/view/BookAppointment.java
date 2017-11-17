package view;

import controller.DateListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private JTextField patientIDTextField;

    /**
     * Create the dialog.
     */
    public BookAppointment() {
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

        // Date label
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(42, 74, 39, 15);
        contentPanel.add(dateLabel);

        //calendar object to create date combobox
        Calendar tempCal = new GregorianCalendar();

        // ComboBox for day
        JComboBox comboDay = new JComboBox();
        comboDay.setBounds(123, 69, 50, 24);
        contentPanel.add(comboDay);
        int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboDay.addItem(i);
        }
        comboDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));

        // ComboBox for month
        JComboBox comboMonth = new JComboBox();
        comboMonth.setBounds(185, 69, 50, 24);
        contentPanel.add(comboMonth);
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        comboMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);

        // ComboBox for year
        JComboBox comboYear = new JComboBox();
        comboYear.setBounds(247, 69, 76, 24);
        contentPanel.add(comboYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 2; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedItem(tempCal.get(Calendar.YEAR));

        comboMonth.addActionListener(new DateListener(comboDay, comboMonth, comboYear));
        comboYear.addActionListener(new DateListener(comboDay, comboMonth, comboYear));
        // Label for Start Time
        JLabel startTimeLabel = new JLabel("Start time:");
        startTimeLabel.setBounds(42, 114, 76, 15);
        contentPanel.add(startTimeLabel);

        // ComboBox for start time, 20 minutes interval
        JComboBox comboStartTime = new JComboBox();
        comboStartTime.setBounds(123, 109, 68, 24);
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

        // Label for type
        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(42, 154, 39, 15);
        contentPanel.add(typeLabel);

        // Label for Check-up / hygiene
        JRadioButton checkUpRadioButton = new JRadioButton("Check-up");
        checkUpRadioButton.setBounds(123, 150, 90, 23);
        contentPanel.add(checkUpRadioButton);

        // Label for treatment
        JRadioButton treatmentRadioButton = new JRadioButton("Treatment");
        treatmentRadioButton.setBounds(218, 150, 99, 23);
        contentPanel.add(treatmentRadioButton);

        ButtonGroup treatmentGroup = new ButtonGroup();
        treatmentGroup.add(checkUpRadioButton);
        treatmentGroup.add(treatmentRadioButton);

        // Label for patient ID
        JLabel patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setBounds(42, 194, 75, 15);
        contentPanel.add(patientIDLabel);

        // Text field for patient ID input
        patientIDTextField = new JTextField();
        patientIDTextField.setBounds(123, 190, 194, 23);
        patientIDTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        contentPanel.add(patientIDTextField);
        patientIDTextField.setColumns(10);

        // Button panel
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        // OK button, create a new appointment
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            // insert SQL query here

            // Check if appointment date is valid
            String inputDay = comboDay.getSelectedItem().toString();
            String inputMonth = comboMonth.getSelectedItem().toString();
            String inputYear = comboYear.getSelectedItem().toString();
            String inputDate = inputDay + "-" + inputMonth + "-" + inputYear;

            if (isValidDate(inputDate)) {
                // insert SQL query here

            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid date");
            }

            dispose();
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
        setBounds(100, 100, 395, 306);
        setResizable(false);
    }

    /**
     * Check if the input date is valid
     *
     * @param date The date to check
     * @return True if the date is valid
     */
    private boolean isValidDate(String date) {
        // set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            // parse the inDate parameter
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }

        return true;
    }
}
