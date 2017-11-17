package view;

import controller.DateListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import util.IntegerFilter;

public class PatientEditor extends JDialog {

    private JPanel contentPane;
    private JTextField foreName;
    private JTextField surName;
    private JTextField phoneNo;
    private JTextField houseNo;
    private JTextField street;
    private JTextField district;
    private JTextField city;
    private JTextField postcode;

    /**
     * Create the frame.
     */
    public PatientEditor(String label) {
        // Main content panel
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        // Main label for Edit Patient
        JLabel mainLabel = new JLabel(label + " Patient");
        mainLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        mainLabel.setBounds(150, 12, 111, 15);
        panel.add(mainLabel);

        // Title label
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(30, 50, 36, 15);
        panel.add(titleLabel);

        // ComboBox for title, eg MR, MS, MISS
        JComboBox comboTitle = new JComboBox(title.values());
        comboTitle.setBounds(154, 45, 62, 24);
        panel.add(comboTitle);

        // Label for forename / first name
        JLabel forenameLabel = new JLabel("Forename:");
        forenameLabel.setBounds(30, 90, 76, 15);
        panel.add(forenameLabel);

        // Text field for forename
        foreName = new JTextField();
        foreName.setBounds(154, 86, 200, 23);
        foreName.setFont(new Font("Dialog", Font.PLAIN, 16));
        foreName.setColumns(10);
        panel.add(foreName);

        // Label for surname / last name
        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(30, 130, 68, 15);
        panel.add(surnameLabel);

        // Text field for surname
        surName = new JTextField();
        surName.setBounds(154, 126, 200, 23);
        surName.setFont(new Font("Dialog", Font.PLAIN, 16));
        surName.setColumns(10);
        panel.add(surName);

        // Label for date of birth
        JLabel dobLabel = new JLabel("Date Of Birth:");
        dobLabel.setBounds(30, 170, 97, 15);
        panel.add(dobLabel);

        // calendar object to create date combobox
        Calendar tempCal = new GregorianCalendar();

        // ComboBox for day
        JComboBox comboDay = new JComboBox();
        comboDay.setBounds(154, 165, 50, 24);
        panel.add(comboDay);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboDay.addItem(i);
        }
        comboDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));

        // ComboBox for month
        JComboBox comboMonth = new JComboBox();
        comboMonth.setBounds(216, 165, 50, 24);
        panel.add(comboMonth);
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        comboMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);

        // ComboBox for year
        JComboBox comboYear = new JComboBox();
        comboYear.setBounds(278, 165, 76, 24);
        panel.add(comboYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1930; i <= currentYear; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedIndex(comboYear.getItemCount() - 1);

        comboMonth.addActionListener(new DateListener(comboDay, comboMonth, comboYear));

        comboYear.addActionListener(new DateListener(comboDay, comboMonth, comboYear));

        // Label for phone number
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(30, 210, 73, 15);
        panel.add(phoneNoLabel);

        // Text field for phone number
        phoneNo = new JTextField();
        phoneNo.setBounds(154, 206, 200, 23);
        phoneNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        ((AbstractDocument) phoneNo.getDocument()).setDocumentFilter(new IntegerFilter());
        phoneNo.setColumns(13);
        panel.add(phoneNo);

        // Label for house number
        JLabel houseNoLabel = new JLabel("House No:");
        houseNoLabel.setBounds(30, 250, 73, 15);
        panel.add(houseNoLabel);

        // Text field for house number
        houseNo = new JTextField();
        houseNo.setBounds(154, 246, 200, 23);
        houseNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        ((AbstractDocument) houseNo.getDocument()).setDocumentFilter(new IntegerFilter());
        houseNo.setColumns(5);
        panel.add(houseNo);

        // Label for street
        JLabel streetLabel = new JLabel("Street:");
        streetLabel.setBounds(30, 290, 50, 15);
        panel.add(streetLabel);

        // Text field for street
        street = new JTextField();
        street.setBounds(154, 286, 200, 23);
        street.setFont(new Font("Dialog", Font.PLAIN, 16));
        street.setColumns(20);
        panel.add(street);

        // Label for district
        JLabel districtLabel = new JLabel("District:");
        districtLabel.setBounds(30, 330, 56, 15);
        panel.add(districtLabel);

        // Text field for district
        district = new JTextField();
        district.setBounds(154, 326, 200, 23);
        district.setFont(new Font("Dialog", Font.PLAIN, 16));
        district.setColumns(20);
        panel.add(district);

        // Label for city
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(30, 370, 32, 15);
        panel.add(cityLabel);

        // Text field for city
        city = new JTextField();
        city.setBounds(154, 366, 200, 23);
        city.setFont(new Font("Dialog", Font.PLAIN, 16));
        city.setColumns(20);
        panel.add(city);

        // Label for postcode
        JLabel postcodeLabel = new JLabel("Postcode:");
        postcodeLabel.setBounds(30, 410, 71, 15);
        panel.add(postcodeLabel);

        // Text field for postcode
        postcode = new JTextField();
        postcode.setBounds(154, 406, 200, 23);
        postcode.setFont(new Font("Dialog", Font.PLAIN, 16));
        postcode.setColumns(20);
        panel.add(postcode);

        // Label for healthcare plan
        JLabel planLabel = new JLabel("Healthcare Plan:");
        planLabel.setBounds(30, 450, 118, 15);
        panel.add(planLabel);

        // ComboBox for healthcare plan
        JComboBox healthcarePlan = new JComboBox();
        healthcarePlan.setBounds(154, 445, 200, 24);
        panel.add(healthcarePlan);

        // Check for update healthcare plan
        JCheckBox updatePlanCheckBox = new JCheckBox("Update Healthcare Plan");
        updatePlanCheckBox.setBounds(154, 488, 194, 23);
        updatePlanCheckBox.setForeground(new Color(128, 128, 128));
        panel.add(updatePlanCheckBox);

        // Bottom panel for Save and Cancel button
        JPanel confirmPanel = new JPanel();
        contentPane.add(confirmPanel, BorderLayout.SOUTH);

        // Save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            boolean completed = true;

            // Check if all field are filled in
            Component[] components = panel.getComponents();
            for (Component comp : components) {
                // Cast comp to JComboBox / JTextField to get the values
                if (comp instanceof JTextField) {
                    if (((JTextField) comp).getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please Complete");
                        completed = false;
                        break;
                    }
                }
            }

            if (completed) {
                dispose();
            }
        });
        confirmPanel.add(saveButton);

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        confirmPanel.add(cancelButton);

        // Settings for the frame
        setTitle(label + " Patient");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 411, 609);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private enum title {MR, MRS, MS, MISS}

}