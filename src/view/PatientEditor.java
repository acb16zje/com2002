package view;

import controller.AddressQueries;
import controller.DateListener;
import controller.HealthCarePlanQueries;
import controller.PatientQueries;
import controller.SubscriptionQueries;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import model.Address;
import model.HealthCarePlan;
import model.Patient;
import model.Subscription;
import util.CharLengthFilter;
import util.CharacterFilter;
import util.IntegerFilter;

public class PatientEditor extends JDialog {

    /**
     * Create the frame.
     */
    public PatientEditor(String label, JTable patientTable) {
        // Main content panel
        JPanel contentPane = new JPanel();
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
        JComboBox<String> comboTitle = new JComboBox<>(new String[]{"Mr", "Mrs", "Ms", "Miss"});
        comboTitle.setBounds(154, 45, 62, 24);
        panel.add(comboTitle);

        // Label for forename / first name
        JLabel forenameLabel = new JLabel("Forename:");
        forenameLabel.setBounds(30, 90, 76, 15);
        panel.add(forenameLabel);

        // Text field for forename
        JTextField foreName = new JTextField();
        ((AbstractDocument) foreName.getDocument()).setDocumentFilter(new CharacterFilter(20));
        foreName.setBounds(154, 86, 200, 23);
        foreName.setFont(new Font("Dialog", Font.PLAIN, 16));
        foreName.setColumns(10);
        panel.add(foreName);

        // Label for surname / last name
        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(30, 130, 68, 15);
        panel.add(surnameLabel);

        // Text field for surname
        JTextField surName = new JTextField();
        ((AbstractDocument) surName.getDocument()).setDocumentFilter(new CharacterFilter(30));
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
        JComboBox<Integer> comboDay = new JComboBox<>();
        comboDay.setBounds(154, 165, 50, 24);
        panel.add(comboDay);
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboDay.addItem(i);
        }
        comboDay.setSelectedItem(tempCal.get(Calendar.DAY_OF_MONTH));

        // ComboBox for month
        JComboBox<Integer> comboMonth = new JComboBox<>();
        comboMonth.setBounds(216, 165, 50, 24);
        panel.add(comboMonth);
        for (int i = 1; i <= 12; i++) {
            comboMonth.addItem(i);
        }
        comboMonth.setSelectedItem(tempCal.get(Calendar.MONTH) + 1);

        // ComboBox for year
        JComboBox<Integer> comboYear = new JComboBox<>();
        comboYear.setBounds(278, 165, 76, 24);
        panel.add(comboYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1930; i <= currentYear; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedIndex(comboYear.getItemCount() - 1);

        // Add listener for ComboBox month and year
        comboMonth.addActionListener(new DateListener(comboDay, comboMonth, comboYear));
        comboYear.addActionListener(new DateListener(comboDay, comboMonth, comboYear));

        // Label for phone number
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(30, 210, 73, 15);
        panel.add(phoneNoLabel);

        // Text field for phone number
        JTextField phoneNo = new JTextField();
        phoneNo.setBounds(154, 206, 200, 23);
        phoneNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        ((AbstractDocument) phoneNo.getDocument()).setDocumentFilter(new IntegerFilter(11));
        phoneNo.setColumns(13);
        panel.add(phoneNo);

        // Label for house number
        JLabel houseNoLabel = new JLabel("House No:");
        houseNoLabel.setBounds(30, 250, 73, 15);
        panel.add(houseNoLabel);

        // Text field for house number
        JTextField houseNo = new JTextField();
        ((AbstractDocument) houseNo.getDocument()).setDocumentFilter(new CharLengthFilter(10));
        houseNo.setBounds(154, 246, 200, 23);
        houseNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        houseNo.setColumns(5);
        panel.add(houseNo);

        // Label for street
        JLabel streetLabel = new JLabel("Street:");
        streetLabel.setBounds(30, 290, 50, 15);
        panel.add(streetLabel);

        // Text field for street
        JTextField street = new JTextField();
        ((AbstractDocument) street.getDocument()).setDocumentFilter(new CharLengthFilter(20));
        street.setBounds(154, 286, 200, 23);
        street.setFont(new Font("Dialog", Font.PLAIN, 16));
        street.setColumns(20);
        panel.add(street);

        // Label for district
        JLabel districtLabel = new JLabel("District:");
        districtLabel.setBounds(30, 330, 56, 15);
        panel.add(districtLabel);

        // Text field for district
        JTextField district = new JTextField();
        ((AbstractDocument) district.getDocument()).setDocumentFilter(new CharLengthFilter(20));
        district.setBounds(154, 326, 200, 23);
        district.setFont(new Font("Dialog", Font.PLAIN, 16));
        district.setColumns(20);
        panel.add(district);

        // Label for city
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(30, 370, 32, 15);
        panel.add(cityLabel);

        // Text field for city
        JTextField city = new JTextField();
        ((AbstractDocument) city.getDocument()).setDocumentFilter(new CharLengthFilter(20));
        city.setBounds(154, 366, 200, 23);
        city.setFont(new Font("Dialog", Font.PLAIN, 16));
        city.setColumns(20);
        panel.add(city);

        // Label for postcode
        JLabel postcodeLabel = new JLabel("Postcode:");
        postcodeLabel.setBounds(30, 410, 71, 15);
        panel.add(postcodeLabel);

        // Text field for postcode
        JTextField postcode = new JTextField();
        ((AbstractDocument) postcode.getDocument()).setDocumentFilter(new CharLengthFilter(8));
        postcode.setBounds(154, 406, 200, 23);
        postcode.setFont(new Font("Dialog", Font.PLAIN, 16));
        postcode.setColumns(20);
        panel.add(postcode);

        // Label for healthcare plan
        JLabel planLabel = new JLabel("Healthcare Plan:");
        planLabel.setBounds(30, 450, 118, 15);
        panel.add(planLabel);

        // ComboBox for healthcare plan
        JComboBox<Object> healthcarePlan = new JComboBox<>(
            HealthCarePlanQueries.getAllPlanName().toArray());
        healthcarePlan.setBounds(154, 445, 200, 24);
        panel.add(healthcarePlan);

        // If it is Edit, then display the patient details
        if (Objects.equals(label, "Edit")) {
            int row = patientTable.getSelectedRow();
            int patientID = Integer.valueOf(String.valueOf(patientTable.getValueAt(row, 0)));
            Patient patient = PatientQueries.getByID(patientID);
            Date dateOfBirth = patient.getDateOfBirth();
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateOfBirth);

            // Setting all the field
            comboTitle.setSelectedItem(patient.getTitle());
            foreName.setText(patient.getForename());
            surName.setText(patient.getSurname());
            comboDay.setSelectedItem(cal.get(Calendar.DAY_OF_MONTH));
            comboMonth.setSelectedItem(cal.get(Calendar.MONTH) + 1);
            comboYear.setSelectedItem(cal.get(Calendar.YEAR));
            phoneNo.setText(patient.getPhone());
            houseNo.setText(patient.getAddress().getHouseNo());
            street.setText(patient.getAddress().getStreet());
            district.setText(patient.getAddress().getDistrict());
            city.setText(patient.getAddress().getStreet());
            postcode.setText(patient.getAddress().getPostcode());
            healthcarePlan.setSelectedItem(patientTable.getValueAt(row, 6));
        }

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

            // If all fields are filled in then register or edit the new patient
            if (completed) {
                // Create address instance for the new patient
                Address address = new Address(
                    houseNo.getText(),
                    street.getText(),
                    district.getText(),
                    city.getText(),
                    postcode.getText()
                );

                // Ready to parse the input date as Date object
                String dobString = String.valueOf(comboYear.getSelectedItem()) + "-" + String
                    .valueOf(comboMonth.getSelectedItem()) + "-" + String
                    .valueOf(comboDay.getSelectedItem());

                // Register the new patient
                Date dateOfBirth = Date.valueOf(dobString);

                if (Objects.equals(label, "Add")) {
                    // Check if the same address has existed
                    if (AddressQueries.isUniqueAddress(houseNo.getText(), postcode.getText())) {
                        AddressQueries.insertAddress(address);
                    }

                    // Create an instance of the new registered patient
                    Patient patient = new Patient(
                        PatientQueries.getNewPatientID(),
                        String.valueOf(comboTitle.getSelectedItem()),
                        foreName.getText(),
                        surName.getText(),
                        dateOfBirth,
                        phoneNo.getText(),
                        address
                    );

                    // Insert the new patient into the database
                    PatientQueries.insertPatient(patient);

                    // Check if the patient wants to subscribe to plan
                    if (healthcarePlan.getSelectedIndex() != 0) {
                        HealthCarePlan subscribedPlan = HealthCarePlanQueries
                            .getPlan(String.valueOf(healthcarePlan.getSelectedItem()));
                        Calendar cal = Calendar.getInstance();
                        Date startDate = Date
                            .valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
                        cal.add(Calendar.YEAR, 1);
                        cal.add(Calendar.DATE, -1);
                        Date endDate = Date
                            .valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));

                        Subscription subscription = new Subscription(
                            patient.getPatientID(),
                            subscribedPlan.getPlanName(),
                            startDate,
                            endDate,
                            subscribedPlan.getCheckUp(),
                            subscribedPlan.getHygieneVisit(),
                            subscribedPlan.getRepairWork()
                        );

                        // Insert subscription into the database
                        SubscriptionQueries.insertSubscription(subscription);
                    }

                    // Add the new patient into the table
                    ((DefaultTableModel) patientTable.getModel()).addRow(
                        new Object[]{
                            patient.getPatientID(),
                            patient.getTitle(),
                            patient.getForename() + patient.getSurname(),
                            String.valueOf(comboDay.getSelectedItem()) + "-" + String
                                .valueOf(comboMonth.getSelectedItem()) + "-" + String
                                .valueOf(comboYear.getSelectedItem()),
                            patient.getPhone(),
                            address.getHouseNo() + ", " + address.getPostcode(),
                            healthcarePlan.getSelectedItem()
                        }
                    );

                } else {
                    // Old data
                    int row = patientTable.getSelectedRow();
                    int patientID = Integer.valueOf(String.valueOf(patientTable.getValueAt(row, 0)));
                    Patient oldPatient = PatientQueries.getByID(patientID);
                    String oldHouseNo = oldPatient.getAddress().getHouseNo();
                    String oldPostcode = oldPatient.getAddress().getPostcode();

                    Patient newPatient = new Patient(
                        oldPatient.getPatientID(),
                        String.valueOf(comboTitle.getSelectedItem()),
                        foreName.getText(),
                        surName.getText(),
                        dateOfBirth,
                        phoneNo.getText(),
                        address
                    );

                    // Update the address
                    AddressQueries.updateAddress(oldHouseNo, oldPostcode, address);

                    // Update the patient
                    PatientQueries.updatePatient(newPatient);

                    // Update subscription
                    if (healthcarePlan.getSelectedIndex() == 0) {
                        // Unsubscribe
                        SubscriptionQueries.deleteSubscription(newPatient.getPatientID());
                    } else {
                        // Upgrade to another plan or stay the same
                        if (healthcarePlan.getSelectedItem() != patientTable.getValueAt(row, 6)) {
                            HealthCarePlan upgradePlan = HealthCarePlanQueries
                                .getPlan(String.valueOf(healthcarePlan.getSelectedItem()));

                            // If the patient wants to subscribe a plan after registeration
                            if (SubscriptionQueries.getSubscription(newPatient.getPatientID()) == null) {
                                Calendar cal = Calendar.getInstance();
                                Date startDate = Date
                                    .valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
                                cal.add(Calendar.YEAR, 1);
                                cal.add(Calendar.DATE, -1);
                                Date endDate = Date
                                    .valueOf(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));

                                Subscription newSubscription = new Subscription(
                                    newPatient.getPatientID(),
                                    upgradePlan.getPlanName(),
                                    startDate,
                                    endDate,
                                    upgradePlan.getCheckUp(),
                                    upgradePlan.getHygieneVisit(),
                                    upgradePlan.getRepairWork()
                                );

                                SubscriptionQueries.insertSubscription(newSubscription);
                            } else {
                                // If the patient wants to upgrade his plan
                                Subscription oldSubscription = SubscriptionQueries.getSubscription(newPatient.getPatientID());

                                HealthCarePlan oldPlan = HealthCarePlanQueries
                                    .getPlan(oldSubscription.getPlanName());

                                Subscription newSubscription = new Subscription(
                                    oldSubscription.getPatientID(),
                                    upgradePlan.getPlanName(),
                                    oldSubscription.getStartDate(),
                                    oldSubscription.getEndDate(),
                                    oldSubscription.getCheckUpLeft() + Math.abs(oldPlan.getCheckUp() - upgradePlan.getCheckUp()),
                                    oldSubscription.getHygieneVisitLeft() + Math.abs(oldPlan.getHygieneVisit() - upgradePlan.getHygieneVisit()),
                                    oldSubscription.getRepairWorkLeft() +  Math.abs(oldPlan.getRepairWork() - upgradePlan.getRepairWork())
                                );

                                SubscriptionQueries.updateSubscription(newSubscription);
                            }
                        }
                    }

                    // Update the table
                    PatientQueries.getPatientList(patientTable);
                }

                // Close the add or editing frame
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
}
