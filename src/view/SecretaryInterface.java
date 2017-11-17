package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AppointmentListener;
import util.WeekGenerator;

public class SecretaryInterface extends JFrame {

    private Date monDate;
    private JTable dentistTable;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
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

        JPanel dentistControlPanel = new JPanel();
        dentistAppointment.add(dentistControlPanel, BorderLayout.NORTH);
        dentistControlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // reminder that month works as 0-11(JAN,FEB,...,DEC)
        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentMonth = currentCalendar.get(Calendar.MONTH);
        String todayAsString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        JSpinner dentistYear = new JSpinner();
        dentistYear
            .setModel(new SpinnerNumberModel(currentYear, currentYear - 20, currentYear + 1, 1));
        JSpinner.NumberEditor dentistEditor = new JSpinner.NumberEditor(dentistYear, "#");
        dentistYear.setEditor(dentistEditor);

        JSpinner dentistMonth = new JSpinner();
        dentistMonth.setModel(new SpinnerNumberModel(currentMonth + 1, 1, 12, 1));

        JComboBox dentistWeek = WeekGenerator.weekSpinner(currentCalendar);

        dentistControlPanel.add(dentistWeek);
        dentistControlPanel.add(dentistMonth);
        dentistControlPanel.add(dentistYear);

        // Listeners for dates
        dentistMonth.addChangeListener((new AppointmentListener(dentistWeek,dentistMonth,dentistYear,currentCalendar,dentistTable,"year")));

        dentistYear.addChangeListener((new AppointmentListener(dentistWeek,dentistMonth,dentistYear,currentCalendar,dentistTable,"month")));

        dentistWeek.addActionListener(e -> {
            String selectedWeek = ((String) dentistWeek.getSelectedItem()).substring(0, 10);
            AppointmentListener.generateAppointmentTable(selectedWeek,dentistTable);
        });

        dentistTable = new JTable();
        dentistTable.setCellSelectionEnabled(true);
        dentistTable.setGridColor(Color.GRAY);
        dentistTable.getTableHeader().setReorderingAllowed(false);
        dentistTable.setRowHeight(20);
        dentistTable.setFillsViewportHeight(true);
        JScrollPane dentistScrollPane = new JScrollPane(dentistTable);
        dentistAppointment.add(dentistScrollPane, BorderLayout.CENTER);

        AppointmentListener.generateAppointmentTable(todayAsString,dentistTable);

        JPanel dentistAppointmentPanel = new JPanel();
        dentistAppointment.add(dentistAppointmentPanel, BorderLayout.SOUTH);

        JButton dentistBookButton = new JButton("Book Appointment");
        dentistBookButton.addActionListener(e -> {
            BookAppointment dialog = new BookAppointment();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
        dentistAppointmentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        dentistAppointmentPanel.add(dentistBookButton);

        JButton dentistCancelButton = new JButton("Cancel Appointment");
        dentistCancelButton.addActionListener(e -> {
            int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (a == JOptionPane.YES_OPTION) {
                // insert delete plan SQL stuff here
            }
        });
        dentistAppointmentPanel.add(dentistCancelButton);

        JButton dentistViewButton = new JButton("View Appointment");
        dentistViewButton.addActionListener(e -> {
            ViewAppointment dialog = new ViewAppointment();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
        dentistAppointmentPanel.add(dentistViewButton);

        JButton dentistSearchButton = new JButton("Search Appointment");
        dentistAppointmentPanel.add(dentistSearchButton);
        dentistSearchButton.setFont(new Font("Dialog", Font.BOLD, 12));
        dentistSearchButton.addActionListener(e -> {
            AppointmentSearch dialog = new AppointmentSearch();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });

        JPanel hygienistAppointment = new JPanel();
        tabbedPane.addTab("Hygienist Appointment", null, hygienistAppointment, null);
        hygienistAppointment.setLayout(new BorderLayout(0, 0));

        JPanel hygienistControlPanel = new JPanel();
        hygienistAppointment.add(hygienistControlPanel, BorderLayout.NORTH);

        JComboBox hygienistWeek = WeekGenerator.weekSpinner(currentCalendar);
        hygienistControlPanel.add(hygienistWeek);

        JSpinner hygienistMonth = new JSpinner();
        hygienistMonth.setModel(new SpinnerNumberModel(currentMonth + 1, 1, 12, 1));
        hygienistControlPanel.add(hygienistMonth);

        JSpinner hygienistYear = new JSpinner();
        hygienistYear.setModel(new SpinnerNumberModel(currentYear, currentYear - 20, currentYear + 1, 1));
        hygienistControlPanel.add(hygienistYear);
        JSpinner.NumberEditor hygienistEditor = new JSpinner.NumberEditor(hygienistYear, "#");
        hygienistYear.setEditor(hygienistEditor);

        // Listeners for dates
        hygienistMonth.addChangeListener(new AppointmentListener(hygienistWeek,hygienistMonth,hygienistYear,currentCalendar,hygienistTable,"year"));

        hygienistYear.addChangeListener(new AppointmentListener(hygienistWeek,hygienistMonth,hygienistYear,currentCalendar,hygienistTable,"month"));

        hygienistWeek.addActionListener(e -> {
            String selectedWeek = ((String) hygienistWeek.getSelectedItem()).substring(0, 10);
            AppointmentListener.generateAppointmentTable(selectedWeek,hygienistTable);
        });

        hygienistTable = new JTable();
        hygienistTable.setRowHeight(20);
        hygienistTable.setCellSelectionEnabled(true);
        hygienistTable.setGridColor(Color.GRAY);
        hygienistTable.setFillsViewportHeight(true);
        JScrollPane hygienistScrollPane = new JScrollPane(hygienistTable);
        hygienistAppointment.add(hygienistScrollPane, BorderLayout.CENTER);
        AppointmentListener.generateAppointmentTable(todayAsString,hygienistTable);

        JPanel hygienistAppointmentPanel = new JPanel();
        hygienistAppointment.add(hygienistAppointmentPanel, BorderLayout.SOUTH);

        JButton hygienistBookButton = new JButton("Book Appointment");
        hygienistAppointmentPanel.add(hygienistBookButton);

        JButton hygienistCancelButton = new JButton("Cancel Appointment");
        hygienistAppointmentPanel.add(hygienistCancelButton);

        JButton hygienistViewButton = new JButton("View Appointment");
        hygienistAppointmentPanel.add(hygienistViewButton);

        JButton hygienistSearchButton = new JButton("Search Appointment");
        hygienistAppointmentPanel.add(hygienistSearchButton);

        // UI for patient
        JPanel patient = new JPanel();
        tabbedPane.addTab("Patient", null, patient, null);
        patient.setLayout(new BorderLayout(0, 0));

        JPanel searchPatientPanel = new JPanel();
        patient.add(searchPatientPanel, BorderLayout.NORTH);

        JLabel lblPatientId = new JLabel("Patient ID:");
        searchPatientPanel.add(lblPatientId);

        JTextField patientID = new JTextField();
        searchPatientPanel.add(patientID);
        patientID.setColumns(20);

        JButton searchPatientButton = new JButton("Search");
        searchPatientPanel.add(searchPatientButton);

        JPanel patientEditPanel = new JPanel();
        patient.add(patientEditPanel, BorderLayout.SOUTH);
        FlowLayout fl_patientEditPanel = (FlowLayout) patientEditPanel.getLayout();
        fl_patientEditPanel.setAlignment(FlowLayout.LEADING);
        fl_patientEditPanel.setAlignOnBaseline(true);

        JButton viewPatientPlanButton = new JButton("View Healthcare Plan");
        viewPatientPlanButton.addActionListener(e -> {
            HealthcarePlan dialog = new HealthcarePlan();
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
        patientEditPanel.add(viewPatientPlanButton);

        JButton editPatientButton = new JButton("Edit");
        editPatientButton.addActionListener(e -> {
            PatientEditor frame = new PatientEditor("Edit");
            frame.setModal(true);
            frame.setVisible(true);
        });
        patientEditPanel.add(editPatientButton);

        JButton deletePatientButton = new JButton("Delete");
        deletePatientButton.addActionListener(e -> {
            int a = JOptionPane.showConfirmDialog(deletePatientButton, "Are you sure?");
            if (a == JOptionPane.YES_OPTION) {
                // insert delete patient sql stuff here
            }
        });
        patientEditPanel.add(deletePatientButton);

        JPanel patientPanel = new JPanel();
        patient.add(patientPanel, BorderLayout.EAST);

        JButton addPatientButton = new JButton("Add Patient");
        addPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientEditor frame = new PatientEditor("Add");
                frame.setModal(true);
                frame.setVisible(true);
            }
        });
        patientPanel.add(addPatientButton);

        JTable patientTable = new JTable();
        patientTable.setRowHeight(20);
        patient.add(new JScrollPane(patientTable), BorderLayout.CENTER);
        patientTable.setModel(new DefaultTableModel(
            new Object[][]{
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
            },
            new String[]{
                "Patient ID", "Name", "Date Of Birth", "Phone No", "Address", "Healthcare Plan"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        patientTable.setFillsViewportHeight(true);

        // UI for healthcare plan tab (work in progress)
        JPanel healthcarePlan = new JPanel();
        tabbedPane.addTab("Healthcare Plan", null, healthcarePlan, null);
        healthcarePlan.setLayout(new BorderLayout(0, 0));
        JPanel searchPlanPanel = new JPanel();
        healthcarePlan.add(searchPlanPanel, BorderLayout.NORTH);

        JLabel healthCarePlan = new JLabel("Plan ID:");
        searchPlanPanel.add(healthCarePlan);

        JTextField searchBox = new JTextField();
        searchBox.setColumns(20);
        searchPlanPanel.add(searchBox);

        JButton searchPlan = new JButton("Search");
        searchPlanPanel.add(searchPlan);

        JTable planTable = new JTable();
        planTable.setFillsViewportHeight(true);
        healthcarePlan.add(planTable, BorderLayout.CENTER);

        // Basic settings
        setTitle("Sheffield Dental Care - Secretary");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 914, 638);
        setLocationRelativeTo(null);
    }

    /**
     * Main method for creating the secretary interface frame
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                SecretaryInterface frame = new SecretaryInterface();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
