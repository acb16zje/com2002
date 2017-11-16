package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
        dentistMonth.addChangeListener(e -> {
            currentCalendar.set(Calendar.MONTH, (int) dentistMonth.getValue() - 1);
            dentistWeek.setModel(new DefaultComboBoxModel(WeekGenerator.weekList(currentCalendar)));
            String selectedWeek = ((String) dentistWeek.getSelectedItem()).substring(0, 10);
            generateDentistAppointmentTable(selectedWeek);
        });

        dentistYear.addChangeListener(e -> {
            currentCalendar.set(Calendar.YEAR, (int) dentistYear.getValue());
            dentistWeek.setModel(new DefaultComboBoxModel(WeekGenerator.weekList(currentCalendar)));
            String selectedWeek = ((String) dentistWeek.getSelectedItem()).substring(0, 10);
            generateDentistAppointmentTable(selectedWeek);
        });

        dentistWeek.addActionListener(e -> {
            String selectedWeek = ((String) dentistWeek.getSelectedItem()).substring(0, 10);
            generateDentistAppointmentTable(selectedWeek);
        });

        dentistTable = new JTable();
        dentistTable.setCellSelectionEnabled(true);
        dentistTable.setGridColor(Color.GRAY);
        dentistTable.getTableHeader().setReorderingAllowed(false);
        dentistTable.setRowHeight(20);
        dentistTable.setFillsViewportHeight(true);
        JScrollPane dentistScrollPane = new JScrollPane(dentistTable);
        dentistAppointment.add(dentistScrollPane, BorderLayout.CENTER);
        generateDentistAppointmentTable(todayAsString);

        JPanel dentistAppointmentPanel = new JPanel();
        dentistAppointment.add(dentistAppointmentPanel, BorderLayout.SOUTH);

        JButton dentistBookButton = new JButton("Book Appointment");
        dentistBookButton.addActionListener(e -> {
            BookAppointment.main(null);
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
        dentistViewButton.addActionListener(e -> ViewAppointment.main(null));
        dentistAppointmentPanel.add(dentistViewButton);

        JButton dentistSearchButton = new JButton("Search Appointment");
        dentistAppointmentPanel.add(dentistSearchButton);
        dentistSearchButton.setFont(new Font("Dialog", Font.BOLD, 12));
        dentistSearchButton.addActionListener(e -> AppointmentSearch.main(null));

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
        hygienistYear
            .setModel(new SpinnerNumberModel(currentYear, currentYear - 20, currentYear + 1, 1));
        hygienistControlPanel.add(hygienistYear);
        JSpinner.NumberEditor hygienistEditor = new JSpinner.NumberEditor(hygienistYear, "#");
        hygienistYear.setEditor(hygienistEditor);

        // Listeners for dates
        hygienistMonth.addChangeListener(e -> {
            currentCalendar.set(Calendar.MONTH, (int) hygienistMonth.getValue() - 1);
            hygienistWeek
                .setModel(new DefaultComboBoxModel(WeekGenerator.weekList(currentCalendar)));
            String selectedWeek = ((String) hygienistWeek.getSelectedItem()).substring(0, 10);
            generateHygienistAppointmentTable(selectedWeek);
        });

        hygienistYear.addChangeListener(e -> {
            currentCalendar.set(Calendar.YEAR, (int) dentistYear.getValue());
            hygienistWeek
                .setModel(new DefaultComboBoxModel(WeekGenerator.weekList(currentCalendar)));
            String selectedWeek = ((String) hygienistWeek.getSelectedItem()).substring(0, 10);
            generateHygienistAppointmentTable(selectedWeek);
        });

        hygienistWeek.addActionListener(e -> {
            String selectedWeek = ((String) hygienistWeek.getSelectedItem()).substring(0, 10);
            generateHygienistAppointmentTable(selectedWeek);
        });

        hygienistTable = new JTable();
        hygienistTable.setRowHeight(20);
        hygienistTable.setCellSelectionEnabled(true);
        hygienistTable.setGridColor(Color.GRAY);
        hygienistTable.setFillsViewportHeight(true);
        JScrollPane hygienistScrollPane = new JScrollPane(hygienistTable);
        hygienistAppointment.add(hygienistScrollPane, BorderLayout.CENTER);
        generateHygienistAppointmentTable(todayAsString);

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
        viewPatientPlanButton.addActionListener(e -> HealthcarePlan.main(null));
        patientEditPanel.add(viewPatientPlanButton);

        JButton editPatientButton = new JButton("Edit");
        editPatientButton.addActionListener(e -> EditPatient.main(null));
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
        addPatientButton.addActionListener(e -> EditPatient.main(null));
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
        /**

         JPanel planPanel = new JPanel();
         healthcarePlan.add(planPanel, BorderLayout.EAST);
         planPanel.setLayout(new BoxLayout(planPanel, BoxLayout.Y_AXIS));

         JButton btnCreateNewPlan = new JButton("Create New Plan");
         btnCreateNewPlan.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         HealthcarePlanEditors.main(null);
         }
         });
         planPanel.add(btnCreateNewPlan);

         JPanel planEditPanel = new JPanel();
         FlowLayout fl_planEditPanel = (FlowLayout) planEditPanel.getLayout();
         fl_planEditPanel.setAlignment(FlowLayout.LEFT);
         fl_planEditPanel.setAlignOnBaseline(true);
         healthcarePlan.add(planEditPanel, BorderLayout.SOUTH);

         JButton removePlan = new JButton("Remove Healthcare Plan");
         removePlan.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
         if(a==JOptionPane.YES_OPTION){
         //insert delete plan sql stuff here
         }
         }
         });

         JButton editPlan = new JButton("Edit Healthcare Plan");
         editPlan.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         HealthcarePlanEditor.main(null);
         }
         });
         planEditPanel.add(editPlan);
         planEditPanel.add(removePlan);
         **/

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

    /**
     * Generate the days in the week
     *
     * @param selectedWeek The selected week
     */
    private void generateDentistAppointmentTable(String selectedWeek) {
        try {
            monDate = timeFormat.parse(selectedWeek);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        Date[] daysInWeekList = WeekGenerator.daysInWeekList(monDate);
        dentistTable.setModel(
            new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                "Mon " + timeFormat.format(daysInWeekList[0]),
                "Tue " + timeFormat.format(daysInWeekList[1]),
                "Wed " + timeFormat.format(daysInWeekList[2]),
                "Thu " + timeFormat.format(daysInWeekList[3]),
                "Fri " + timeFormat.format(daysInWeekList[4])}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            }
        );

        dentistTable.getColumnModel().getColumn(0).setPreferredWidth(15);
    }

    /**
     * Generate the days in the week
     *
     * @param selectedWeek The selected week
     */
    private void generateHygienistAppointmentTable(String selectedWeek) {
        try {
            monDate = timeFormat.parse(selectedWeek);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        Date[] daysInWeekList = WeekGenerator.daysInWeekList(monDate);
        hygienistTable.setModel(
            new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                "Mon " + timeFormat.format(daysInWeekList[0]),
                "Tue " + timeFormat.format(daysInWeekList[1]),
                "Wed " + timeFormat.format(daysInWeekList[2]),
                "Thu " + timeFormat.format(daysInWeekList[3]),
                "Fri " + timeFormat.format(daysInWeekList[4])}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            }
        );

        hygienistTable.getColumnModel().getColumn(0).setPreferredWidth(15);
    }
}
