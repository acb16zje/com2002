package view;

import controller.AppointmentTableListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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

        JPanel dentistControlPanel = new JPanel();
        dentistAppointment.add(dentistControlPanel, BorderLayout.NORTH);
        dentistControlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // reminder that month works as 0-11(JAN,FEB,...,DEC)
        Calendar dentistCalendar = Calendar.getInstance();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        Calendar hygienistCalendar = Calendar.getInstance();

        String todayAsString = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        JComboBox dentistYear = new JComboBox();
        for (int i = 2000; i <= currentYear + 2; i++) {
            dentistYear.addItem(i);
        }
        dentistYear.setSelectedItem(currentYear);

        JComboBox dentistMonth = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            dentistMonth.addItem(i);
        }
        dentistMonth.setSelectedItem(currentMonth + 1);
        dentistControlPanel.add(dentistMonth);

        JComboBox dentistWeek = WeekGenerator.weekSpinner(dentistCalendar);

        dentistControlPanel.add(dentistWeek);
        dentistControlPanel.add(dentistMonth);
        dentistControlPanel.add(dentistYear);

        dentistTable = new JTable();
        dentistTable.setCellSelectionEnabled(true);
        dentistTable.setGridColor(Color.GRAY);
        dentistTable.getTableHeader().setReorderingAllowed(false);
        dentistTable.setRowHeight(30);
        dentistTable.setFillsViewportHeight(true);
        JScrollPane dentistScrollPane = new JScrollPane(dentistTable);
        dentistAppointment.add(dentistScrollPane, BorderLayout.CENTER);
        AppointmentTableListener.generateAppointmentTable(todayAsString, dentistTable);

        // Listeners for dates
        dentistMonth.addActionListener(
            new AppointmentTableListener(dentistWeek, dentistMonth, dentistYear, dentistCalendar,
                dentistTable, "month"));

        dentistYear.addActionListener(
            new AppointmentTableListener(dentistWeek, dentistMonth, dentistYear, dentistCalendar,
                dentistTable, "year"));

        dentistWeek.addActionListener(
            new AppointmentTableListener(dentistWeek, dentistMonth, dentistYear, dentistCalendar,
                dentistTable, "week"));

        JPanel dentistAppointmentPanel = new JPanel();
        dentistAppointment.add(dentistAppointmentPanel, BorderLayout.SOUTH);

        JButton dentistBookButton = new JButton("Book Appointment");
        dentistBookButton.addActionListener(e -> {
            BookAppointment dialog = new BookAppointment("Check-up");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setVisible(true);
        });
        dentistAppointmentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        dentistAppointmentPanel.add(dentistBookButton);

        JButton dentistCancelButton = new JButton("Cancel Appointment");
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

        JButton dentistViewButton = new JButton("View Appointment");
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

        JButton dentistSearchButton = new JButton("Search Appointment");
        dentistAppointmentPanel.add(dentistSearchButton);
        dentistSearchButton.setFont(new Font("Dialog", Font.BOLD, 12));
        dentistSearchButton.addActionListener(e -> {
            AppointmentSearch dialog = new AppointmentSearch();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setVisible(true);
        });

        JPanel hygienistAppointment = new JPanel();
        tabbedPane.addTab("Hygienist Appointment", null, hygienistAppointment, null);
        hygienistAppointment.setLayout(new BorderLayout(0, 0));

        JPanel hygienistControlPanel = new JPanel();
        hygienistAppointment.add(hygienistControlPanel, BorderLayout.NORTH);

        JComboBox hygienistWeek = WeekGenerator.weekSpinner(hygienistCalendar);
        hygienistControlPanel.add(hygienistWeek);

        JComboBox hygienistMonth = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            hygienistMonth.addItem(i);
        }
        hygienistMonth.setSelectedItem(hygienistCalendar.get(Calendar.MONTH) + 1);
        hygienistControlPanel.add(hygienistMonth);

        JComboBox hygienistYear = new JComboBox();
        for (int i = 2000; i <= currentYear + 2; i++) {
            hygienistYear.addItem(i);
        }
        hygienistYear.setSelectedItem(currentYear);
        hygienistControlPanel.add(hygienistYear);

        hygienistTable = new JTable();
        hygienistTable.setRowHeight(30);
        hygienistTable.setCellSelectionEnabled(true);
        hygienistTable.getTableHeader().setReorderingAllowed(false);
        hygienistTable.setGridColor(Color.GRAY);
        hygienistTable.setFillsViewportHeight(true);
        JScrollPane hygienistScrollPane = new JScrollPane(hygienistTable);
        hygienistAppointment.add(hygienistScrollPane, BorderLayout.CENTER);
        AppointmentTableListener.generateAppointmentTable(todayAsString, hygienistTable);

        // Listeners for dates
        hygienistMonth.addActionListener(
            new AppointmentTableListener(hygienistWeek, hygienistMonth, hygienistYear, hygienistCalendar,
                hygienistTable, "month"));

        hygienistYear.addActionListener(
            new AppointmentTableListener(hygienistWeek, hygienistMonth, hygienistYear, hygienistCalendar,
                hygienistTable, "year"));

        hygienistWeek.addActionListener(
            new AppointmentTableListener(hygienistWeek, hygienistMonth, hygienistYear, hygienistCalendar,
                hygienistTable, "week"));

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

        JButton hygienistCancelButton = new JButton("Cancel Appointment");
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

        JButton hygienistViewButton = new JButton("View Appointment");
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

        JButton hygienistSearchButton = new JButton("Search Appointment");
        hygienistSearchButton.addActionListener(e -> {
            AppointmentSearch dialog = new AppointmentSearch();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setVisible(true);
        });
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

        JPanel patientPanel = new JPanel();
        patient.add(patientPanel, BorderLayout.SOUTH);

        JTable patientTable = new JTable();
        patientTable.setRowHeight(25);
        patientTable.getTableHeader().setReorderingAllowed(false);
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
        patientPanel.setLayout(new BoxLayout(patientPanel, BoxLayout.X_AXIS));

        JPanel editorPanel = new JPanel();
        patientPanel.add(editorPanel);

        JButton addPatientButton = new JButton("Add Patient");
        editorPanel.add(addPatientButton);
        addPatientButton.addActionListener(e -> {
            PatientEditor frame = new PatientEditor("Add");
            frame.setModal(true);
            frame.setVisible(true);
        });

        JButton editPatientButton = new JButton("Edit Patient");
        editorPanel.add(editPatientButton);

        JButton deletePatientButton = new JButton("Delete Patient");
        editorPanel.add(deletePatientButton);

        JPanel planPanel = new JPanel();
        patientPanel.add(planPanel);

        JButton viewPatientPlanButton = new JButton("View Patient Plan");
        planPanel.add(viewPatientPlanButton);
        viewPatientPlanButton.addActionListener(e -> {
            HealthcarePlan dialog = new HealthcarePlan();
            dialog.setModal(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
        deletePatientButton.addActionListener(e -> {
            int rowSelected = patientTable.getSelectedRow();
            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(null, "Select a patient!");
            } else {
                int a = JOptionPane.showConfirmDialog(deletePatientButton, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    // insert delete patient sql stuff here
                }
            }
        });
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
        setBounds(100, 100, 914, 878);
        setLocationRelativeTo(null);
    }
}
