import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        mainLabel.setBounds(152, 12, 165, 19);
        mainLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        contentPanel.add(mainLabel);

        // Date label
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(41, 71, 39, 15);
        contentPanel.add(dateLabel);

        // ComboBox for day
        JComboBox comboDay = new JComboBox();
        comboDay.setBounds(142, 66, 50, 24);
        contentPanel.add(comboDay);
        int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= 31; i++) {
            comboDay.addItem(i);
        }
        comboDay.setSelectedIndex(today - 1);

        // ComboBox for month
        JComboBox comboMonth = new JComboBox();
        comboMonth.setBounds(204, 66, 50, 24);
        contentPanel.add(comboMonth);
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        comboMonth.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));

        // ComboBox for year
        JComboBox comboYear = new JComboBox();
        comboYear.setBounds(266, 66, 76, 24);
        contentPanel.add(comboYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i <= currentYear + 2; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedIndex(0);

        // Label for Start Time
        JLabel startTimeLabel = new JLabel("Start time:");
        startTimeLabel.setBounds(41, 111, 76, 15);
        contentPanel.add(startTimeLabel);

        // ComboBox for start time, 20 minutes interval
        JComboBox comboStartTime = new JComboBox();
        comboStartTime.setBounds(142, 106, 68, 24);
        comboStartTime.setEditable(true);
        contentPanel.add(comboStartTime);
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

        // Label for partner
        JLabel partnerLabel = new JLabel("Partner:");
        partnerLabel.setBounds(41, 151, 59, 15);
        contentPanel.add(partnerLabel);

        // Radio button for dentist
        JRadioButton dentistRadioButton = new JRadioButton("Dentist");
        dentistRadioButton.setBounds(142, 147, 77, 23);
        contentPanel.add(dentistRadioButton);

        // Radio button for hygienist
        JRadioButton hygienistRadioButton = new JRadioButton("Hygienist");
        hygienistRadioButton.setBounds(321, 147, 92, 23);
        contentPanel.add(hygienistRadioButton);

        // Label for type
        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(41, 191, 39, 15);
        contentPanel.add(typeLabel);

        // Label for Check-up / hygiene
        JRadioButton checkUpRadioButton = new JRadioButton("Check-up / hygiene");
        checkUpRadioButton.setBounds(142, 187, 159, 23);
        contentPanel.add(checkUpRadioButton);

        // Label for treatment
        JRadioButton treatmentRadioButton = new JRadioButton("Treatment");
        treatmentRadioButton.setBounds(321, 187, 99, 23);
        contentPanel.add(treatmentRadioButton);

        // Label for patient ID
        JLabel patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setBounds(41, 233, 75, 15);
        contentPanel.add(patientIDLabel);

        // Text field for patient ID input
        patientIDTextField = new JTextField();
        patientIDTextField.setBounds(142, 229, 83, 23);
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
        setBounds(100, 100, 474, 350);
        setResizable(false);
    }

    /**
     * Main method for creating the BookAppointment dialog
     *
     * @param args Command line arguments, not used
     */
    public static void main(String[] args) {
        try {
            BookAppointment dialog = new BookAppointment();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
