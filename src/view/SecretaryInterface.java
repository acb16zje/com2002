package view;

import controller.AppointmentTableListener;
import controller.PatientQueries;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import util.IntegerFilter;
import util.WeekGenerator;

public class SecretaryInterface extends JFrame {

    private JTable dentistTable;
    private JTable hygienistTable;

    /**
     * Create the frame.
     */
    public SecretaryInterface() {
        // Main content panel
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // The tabs
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        // UI for appointment
        JPanel dentistAppointment = new JPanel();
        tabbedPane.addTab("Dentist Appointment", null, dentistAppointment, null);
        dentistAppointment.setLayout(new BorderLayout(0, 0));

        // Contain Week Selector for Dentist
        JPanel dentistControlPanel = new JPanel();
        dentistAppointment.add(dentistControlPanel, BorderLayout.NORTH);
        dentistControlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // reminder that month works as 0-11(JAN,FEB,...,DEC)
        Calendar dentistCalendar = Calendar.getInstance();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        Calendar hygienistCalendar = Calendar.getInstance();

        String todayAsString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        // ComboBox for year select
        JComboBox dentistYear = new JComboBox();
        for (int i = 2000; i <= currentYear + 2; i++) {
            dentistYear.addItem(i);
        }
        dentistYear.setSelectedItem(currentYear);

        // ComboBox for month select
        JComboBox dentistMonth = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            dentistMonth.addItem(i);
        }
        dentistMonth.setSelectedItem(currentMonth + 1);
        dentistControlPanel.add(dentistMonth);

        // List of weeks to select in a month
        JComboBox dentistWeek = WeekGenerator.weekSpinner(dentistCalendar);

        // Add all combobox into the top panel
        dentistControlPanel.add(dentistWeek);
        dentistControlPanel.add(dentistMonth);
        dentistControlPanel.add(dentistYear);

        // Dentist appointment table
        dentistTable = new JTable();
        dentistTable.setCellSelectionEnabled(true);
        dentistTable.setGridColor(Color.GRAY);
        dentistTable.getTableHeader().setReorderingAllowed(false);
        dentistTable.setRowHeight(30);
        dentistTable.setFillsViewportHeight(true);
        JScrollPane dentistScrollPane = new JScrollPane(dentistTable);
        dentistAppointment.add(dentistScrollPane, BorderLayout.CENTER);

        // Bottom panel, contain all the buttons
        JPanel dentistAppointmentPanel = new JPanel();
        dentistAppointment.add(dentistAppointmentPanel, BorderLayout.SOUTH);

        // Book appointment button for dentist
        JButton dentistBookButton = new JButton("Book Appointment");
        dentistBookButton.addActionListener(e -> {
            BookAppointment dialog = new BookAppointment("Check-up");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setVisible(true);
        });
        dentistAppointmentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        dentistAppointmentPanel.add(dentistBookButton);

        // Cancel appointment button for dentist
        JButton dentistCancelButton = new JButton("Cancel Appointment");
        dentistCancelButton.setEnabled(false);
        dentistCancelButton.addActionListener(e -> {
            int rowSelected = dentistTable.getSelectedRow();
            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select an appointment!");
            } else {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    // insert delete plan SQL stuff here
                }
            }
        });
        dentistAppointmentPanel.add(dentistCancelButton);

        // View appointment button for dentist
        JButton dentistViewButton = new JButton("View Appointment");
        dentistViewButton.setEnabled(false);
        dentistViewButton.addActionListener(e -> {
            int rowSelected = dentistTable.getSelectedRow();
            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select an appointment!");
            } else {
                ViewAppointment dialog = new ViewAppointment();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });
        dentistAppointmentPanel.add(dentistViewButton);

        // Generate the appointment table for dentist
        AppointmentTableListener dentistAppointmentTable = new AppointmentTableListener(
            dentistTable, dentistCancelButton, dentistViewButton);
        dentistAppointmentTable
            .generateAppointmentTable(todayAsString, dentistTable, dentistCancelButton,
                dentistViewButton);

        // Listeners for dates
        dentistMonth.addActionListener(
            new AppointmentTableListener(dentistWeek, dentistMonth, dentistYear, dentistCalendar,
                dentistTable, dentistCancelButton, dentistViewButton, "month"));

        dentistYear.addActionListener(
            new AppointmentTableListener(dentistWeek, dentistMonth, dentistYear, dentistCalendar,
                dentistTable, dentistCancelButton, dentistViewButton, "year"));

        dentistWeek.addActionListener(
            new AppointmentTableListener(dentistWeek, dentistMonth, dentistYear, dentistCalendar,
                dentistTable, dentistCancelButton, dentistViewButton, "week"));

        // Disable the cancel and view appointment button when it is clicked on empty slot
        AppointmentTableListener
            .buttonDisabler(dentistTable, dentistCancelButton, dentistViewButton);

        // Search appointment button for dentist
        JButton dentistSearchButton = new JButton("Search Appointment");
        dentistAppointmentPanel.add(dentistSearchButton);
        dentistSearchButton.addActionListener(e -> {
            AppointmentSearch dialog = new AppointmentSearch();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setVisible(true);
        });

        // Main panel for hygienist appointment
        JPanel hygienistAppointment = new JPanel();
        tabbedPane.addTab("Hygienist Appointment", null, hygienistAppointment, null);
        hygienistAppointment.setLayout(new BorderLayout(0, 0));

        // Contain date selector for hygienist
        JPanel hygienistControlPanel = new JPanel();
        hygienistAppointment.add(hygienistControlPanel, BorderLayout.NORTH);

        // ComboBox to show list of weeks in this month
        JComboBox hygienistWeek = WeekGenerator.weekSpinner(hygienistCalendar);
        hygienistControlPanel.add(hygienistWeek);

        // ComboBox for 12 months
        JComboBox hygienistMonth = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            hygienistMonth.addItem(i);
        }
        hygienistMonth.setSelectedItem(hygienistCalendar.get(Calendar.MONTH) + 1);
        hygienistControlPanel.add(hygienistMonth);

        // ComboBox for year
        JComboBox hygienistYear = new JComboBox();
        for (int i = 2000; i <= currentYear + 2; i++) {
            hygienistYear.addItem(i);
        }
        hygienistYear.setSelectedItem(currentYear);
        hygienistControlPanel.add(hygienistYear);

        // Hygienist timetable
        hygienistTable = new JTable();
        hygienistTable.setRowHeight(30);
        hygienistTable.setCellSelectionEnabled(true);
        hygienistTable.getTableHeader().setReorderingAllowed(false);
        hygienistTable.setGridColor(Color.GRAY);
        hygienistTable.setFillsViewportHeight(true);
        JScrollPane hygienistScrollPane = new JScrollPane(hygienistTable);
        hygienistAppointment.add(hygienistScrollPane, BorderLayout.CENTER);

        // Contain book, cancel, view and search appointment button
        JPanel hygienistAppointmentPanel = new JPanel();
        hygienistAppointment.add(hygienistAppointmentPanel, BorderLayout.SOUTH);

        JButton hygienistBookButton = new JButton("Book Appointment");
        hygienistBookButton.addActionListener(e -> {
            BookAppointment dialog = new BookAppointment("Hygiene");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setVisible(true);
        });
        hygienistAppointmentPanel.add(hygienistBookButton);

        // Hygienist cancel button
        JButton hygienistCancelButton = new JButton("Cancel Appointment");
        hygienistCancelButton.setEnabled(false);
        hygienistCancelButton.addActionListener(e -> {
            int rowSelected = hygienistTable.getSelectedRow();
            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select an appointment!");
            } else {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    // insert delete plan SQL stuff here
                }
            }
        });
        hygienistAppointmentPanel.add(hygienistCancelButton);

        // Hygienist view appointment button
        JButton hygienistViewButton = new JButton("View Appointment");
        hygienistViewButton.setEnabled(false);
        hygienistViewButton.addActionListener(e -> {
            int rowSelected = hygienistTable.getSelectedRow();
            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select an appointment!");
            } else {
                ViewAppointment dialog = new ViewAppointment();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });
        hygienistAppointmentPanel.add(hygienistViewButton);

        // Generate the appointment table for hygienist
        AppointmentTableListener hygienistAppointmentTable = new AppointmentTableListener(
            hygienistTable, hygienistCancelButton, hygienistViewButton);
        hygienistAppointmentTable
            .generateAppointmentTable(todayAsString, hygienistTable, hygienistCancelButton,
                hygienistViewButton);

        // Listeners for dates
        hygienistWeek.addActionListener(
            new AppointmentTableListener(hygienistWeek, hygienistMonth, hygienistYear,
                hygienistCalendar, hygienistTable, hygienistCancelButton, hygienistViewButton,
                "week"));

        hygienistMonth.addActionListener(
            new AppointmentTableListener(hygienistWeek, hygienistMonth, hygienistYear,
                hygienistCalendar, hygienistTable, hygienistCancelButton, hygienistViewButton,
                "month"));

        hygienistYear.addActionListener(
            new AppointmentTableListener(hygienistWeek, hygienistMonth, hygienistYear,
                hygienistCalendar, hygienistTable, hygienistCancelButton, hygienistViewButton,
                "year"));

        // Disable the cancel and view appointment button when it is clicked on empty slot
        AppointmentTableListener
            .buttonDisabler(hygienistTable, hygienistCancelButton, hygienistViewButton);

        // Hygienist search button
        JButton hygienistSearchButton = new JButton("Search Appointment");
        hygienistSearchButton.addActionListener(e -> {
            AppointmentSearch dialog = new AppointmentSearch();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setVisible(true);
        });
        hygienistAppointmentPanel.add(hygienistSearchButton);

        // UI for patient, separate tab
        JPanel patient = new JPanel();
        tabbedPane.addTab("Patient", null, patient, null);
        patient.setLayout(new BorderLayout(0, 0));

        // Top panel
        JPanel searchPatientPanel = new JPanel();
        patient.add(searchPatientPanel, BorderLayout.NORTH);

        // Label for patient ID
        JLabel lblPatientId = new JLabel("Patient ID:");
        searchPatientPanel.add(lblPatientId);

        // Text field for patient ID
        JTextField patientID = new JTextField();
        ((AbstractDocument) patientID.getDocument()).setDocumentFilter(new IntegerFilter());
        searchPatientPanel.add(patientID);
        patientID.setColumns(20);

        // Search button
        JButton searchPatientButton = new JButton("Search");
        searchPatientPanel.add(searchPatientButton);

        // Panel for table
        JPanel patientPanel = new JPanel();
        patient.add(patientPanel, BorderLayout.SOUTH);

        // List of registered patients
        JTable patientTable = new JTable();
        patientTable.setRowHeight(25);
        patientTable.getTableHeader().setReorderingAllowed(false);
        patient.add(new JScrollPane(patientTable), BorderLayout.CENTER);
        patientTable.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{
                "Patient ID", "Title", "Name", "Date Of Birth", "Phone No", "Address",
                "Healthcare Plan"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        patientTable.setFillsViewportHeight(true);
        patientTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        patientTable.getColumnModel().getColumn(1).setPreferredWidth(10);
        patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.X_AXIS));

        // Get the list of patients from Database
        PatientQueries.getPatientList(patientTable);

        // Bottom panel
        JPanel editorPanel = new JPanel();
        patientPanel.add(editorPanel);

        // Add a new patient button
        JButton addPatientButton = new JButton("Add Patient");
        editorPanel.add(addPatientButton);
        addPatientButton.addActionListener(e -> {
            PatientEditor frame = new PatientEditor("Add");
            frame.setModal(true);
            frame.setVisible(true);
        });

        // Edit patient button
        JButton editPatientButton = new JButton("Edit Patient");
        editPatientButton.setEnabled(false);
        editorPanel.add(editPatientButton);
        editPatientButton.addActionListener(e -> {
            int rowSelected = patientTable.getSelectedRow();
            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select a patient!");
            } else {
                PatientEditor frame = new PatientEditor("Edit");
                frame.setModal(true);
                frame.setVisible(true);
            }
        });

        // Delete patient button
        JButton deletePatientButton = new JButton("Delete Patient");
        deletePatientButton.setEnabled(false);
        editorPanel.add(deletePatientButton);
        deletePatientButton.addActionListener(e -> {
            int rowSelected = patientTable.getSelectedRow();
            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select a patient!");
            } else {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    // insert delete patient sql stuff here
                }
            }
        });

        // View the patient registered plan
        JPanel planPanel = new JPanel();
        patientPanel.add(planPanel);

        // View the patient registered plan button
        JButton viewPatientPlanButton = new JButton("View Patient Plan");
        viewPatientPlanButton.setEnabled(false);
        planPanel.add(viewPatientPlanButton);
        viewPatientPlanButton.addActionListener(e -> {
            HealthcarePlan dialog = new HealthcarePlan();
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });

        // Disable the edit patient, delete button and view patient plan button when
        patientTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                editPatientButton.setEnabled(true);
                deletePatientButton.setEnabled(true);
                viewPatientPlanButton.setEnabled(true);
            }
        });

        // Basic settings
        setTitle("Sheffield Dental Care - Secretary");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 878);
        setLocationRelativeTo(null);
    }

}
