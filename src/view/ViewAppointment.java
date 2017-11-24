package view;

import static java.time.temporal.ChronoUnit.MINUTES;

import controller.PatientQueries;
import controller.RecordQueries;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import model.Appointment;

public class ViewAppointment extends JDialog {

    private JTable table;
    private JTextField startTime;
    private JTextField patientID;
    private JTextField endTime;
    private JLabel dateLabel;
    private JLabel startTimeLabel;
    private JLabel endTimeLabel;
    private JLabel patientIDLabel;
    private JPanel treatmentPanel;
    private JPanel totalCostPanel;
    private JLabel totalCostLabel;
    private JTextField totalCostTextField;
    private JTextField dateTextField;
    private JLabel typeLabel;
    private JRadioButton checkUpRadioButton;
    private JRadioButton treatmentRadioButton;
    private JLabel receiptLabel;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
    private JLabel lblPatientName;
    private JTextField patientName;

    /**
     * Create the dialog.
     */
    public ViewAppointment(Appointment app) {
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel infoPanel = new JPanel();
        contentPanel.add(infoPanel, BorderLayout.CENTER);
        GridBagLayout gbl_infoPanel = new GridBagLayout();
        gbl_infoPanel.columnWidths = new int[]{50, 119, 183, 128, 0, 0};
        gbl_infoPanel.rowHeights = new int[]{66, 40, 40, 40, 40, 40, 40, 40, 0, 0};
        gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
            Double.MIN_VALUE};
        infoPanel.setLayout(gbl_infoPanel);

        dateLabel = new JLabel("Date:");
        GridBagConstraints gbc_dateLabel = new GridBagConstraints();
        gbc_dateLabel.anchor = GridBagConstraints.WEST;
        gbc_dateLabel.insets = new Insets(0, 0, 5, 5);
        gbc_dateLabel.gridx = 1;
        gbc_dateLabel.gridy = 1;
        infoPanel.add(dateLabel, gbc_dateLabel);

        dateTextField = new JTextField();
        dateTextField.setEditable(false);
        dateTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        dateTextField.setText(timeFormat.format(app.getDate().getTime()));
        GridBagConstraints gbc_dateTextField = new GridBagConstraints();
        gbc_dateTextField.fill = GridBagConstraints.BOTH;
        gbc_dateTextField.insets = new Insets(0, 0, 5, 5);
        gbc_dateTextField.gridx = 2;
        gbc_dateTextField.gridy = 1;
        infoPanel.add(dateTextField, gbc_dateTextField);
        dateTextField.setColumns(10);

        startTimeLabel = new JLabel("Start Time:");
        GridBagConstraints gbc_startTimeLabel = new GridBagConstraints();
        gbc_startTimeLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_startTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_startTimeLabel.gridx = 1;
        gbc_startTimeLabel.gridy = 2;
        infoPanel.add(startTimeLabel, gbc_startTimeLabel);

        startTime = new JTextField();
        startTime.setEditable(false);
        startTime.setFont(new Font("Dialog", Font.PLAIN, 16));
        startTime.setColumns(10);
        startTime.setText(new SimpleDateFormat("HH:mm:ss").format(app.getStartTime()));
        GridBagConstraints gbc_startTime = new GridBagConstraints();
        gbc_startTime.fill = GridBagConstraints.BOTH;
        gbc_startTime.insets = new Insets(0, 0, 5, 5);
        gbc_startTime.gridx = 2;
        gbc_startTime.gridy = 2;
        infoPanel.add(startTime, gbc_startTime);

        endTimeLabel = new JLabel("End Time:");
        GridBagConstraints gbc_endTimeLabel = new GridBagConstraints();
        gbc_endTimeLabel.anchor = GridBagConstraints.WEST;
        gbc_endTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_endTimeLabel.gridx = 1;
        gbc_endTimeLabel.gridy = 3;
        infoPanel.add(endTimeLabel, gbc_endTimeLabel);

        endTime = new JTextField();
        endTime.setFont(new Font("Dialog", Font.PLAIN, 16));
        endTime.setEditable(false);
        endTime.setText(new SimpleDateFormat("HH:mm:ss").format(app.getEndTime()));
        GridBagConstraints gbc_endTime = new GridBagConstraints();
        gbc_endTime.fill = GridBagConstraints.BOTH;
        gbc_endTime.insets = new Insets(0, 0, 5, 5);
        gbc_endTime.gridx = 2;
        gbc_endTime.gridy = 3;
        infoPanel.add(endTime, gbc_endTime);
        endTime.setColumns(10);

        typeLabel = new JLabel("Type:");
        GridBagConstraints gbc_typeLabel = new GridBagConstraints();
        gbc_typeLabel.anchor = GridBagConstraints.WEST;
        gbc_typeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_typeLabel.gridx = 1;
        gbc_typeLabel.gridy = 4;
        infoPanel.add(typeLabel, gbc_typeLabel);

        checkUpRadioButton = new JRadioButton("Check-up / hygiene");
        checkUpRadioButton.setEnabled(false);
        GridBagConstraints gbc_checkUpRadioButton = new GridBagConstraints();
        gbc_checkUpRadioButton.anchor = GridBagConstraints.WEST;
        gbc_checkUpRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_checkUpRadioButton.gridx = 2;
        gbc_checkUpRadioButton.gridy = 4;
        infoPanel.add(checkUpRadioButton, gbc_checkUpRadioButton);

        treatmentRadioButton = new JRadioButton("Treatment");
        treatmentRadioButton.setEnabled(false);
        GridBagConstraints gbc_treatmentRadioButton = new GridBagConstraints();
        gbc_treatmentRadioButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_treatmentRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_treatmentRadioButton.gridx = 3;
        gbc_treatmentRadioButton.gridy = 4;
        infoPanel.add(treatmentRadioButton, gbc_treatmentRadioButton);

        ButtonGroup type = new ButtonGroup();
        type.add(checkUpRadioButton);
        type.add(treatmentRadioButton);
        if (MINUTES.between(app.getStartTime().toLocalTime(), app.getEndTime().toLocalTime())
            == 60) {
            type.setSelected(treatmentRadioButton.getModel(), true);
        } else {
            type.setSelected(checkUpRadioButton.getModel(), true);
        }

        JLabel partnerLabel = new JLabel("Partner:");
        GridBagConstraints gbc_partnerLabel = new GridBagConstraints();
        gbc_partnerLabel.anchor = GridBagConstraints.WEST;
        gbc_partnerLabel.insets = new Insets(0, 0, 5, 5);
        gbc_partnerLabel.gridx = 1;
        gbc_partnerLabel.gridy = 5;
        infoPanel.add(partnerLabel, gbc_partnerLabel);

        JRadioButton dentistRadioButton = new JRadioButton("Dentist");
        dentistRadioButton.setEnabled(false);
        GridBagConstraints gbc_dentistRadioButton = new GridBagConstraints();
        gbc_dentistRadioButton.anchor = GridBagConstraints.WEST;
        gbc_dentistRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_dentistRadioButton.gridx = 2;
        gbc_dentistRadioButton.gridy = 5;
        infoPanel.add(dentistRadioButton, gbc_dentistRadioButton);

        JRadioButton hygienistRadioButton = new JRadioButton("Hygienist");
        hygienistRadioButton.setEnabled(false);
        GridBagConstraints gbc_hygienistRadioButton = new GridBagConstraints();
        gbc_hygienistRadioButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_hygienistRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_hygienistRadioButton.gridx = 3;
        gbc_hygienistRadioButton.gridy = 5;
        infoPanel.add(hygienistRadioButton, gbc_hygienistRadioButton);

        ButtonGroup partner = new ButtonGroup();
        partner.add(dentistRadioButton);
        partner.add(hygienistRadioButton);
        if (app.getPartnerID() == 0) {
            partner.setSelected(dentistRadioButton.getModel(), true);
        } else {
            partner.setSelected(hygienistRadioButton.getModel(), true);
        }

        patientIDLabel = new JLabel("Patient ID:");
        GridBagConstraints gbc_patientIDLabel = new GridBagConstraints();
        gbc_patientIDLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_patientIDLabel.insets = new Insets(0, 0, 5, 5);
        gbc_patientIDLabel.gridx = 1;
        gbc_patientIDLabel.gridy = 6;
        infoPanel.add(patientIDLabel, gbc_patientIDLabel);

        patientID = new JTextField();
        patientID.setEditable(false);
        patientID.setFont(new Font("Dialog", Font.PLAIN, 16));
        patientID.setColumns(10);
        patientID.setText(String.valueOf(app.getPatientID()));
        GridBagConstraints gbc_patientID = new GridBagConstraints();
        gbc_patientID.fill = GridBagConstraints.BOTH;
        gbc_patientID.insets = new Insets(0, 0, 5, 5);
        gbc_patientID.gridx = 2;
        gbc_patientID.gridy = 6;
        infoPanel.add(patientID, gbc_patientID);

        lblPatientName = new JLabel("Patient Name:");
        GridBagConstraints gbc_lblPatientName = new GridBagConstraints();
        gbc_lblPatientName.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblPatientName.insets = new Insets(0, 0, 5, 5);
        gbc_lblPatientName.gridx = 1;
        gbc_lblPatientName.gridy = 7;
        infoPanel.add(lblPatientName, gbc_lblPatientName);

        patientName = new JTextField();
        patientName.setEditable(false);
        GridBagConstraints gbc_patientName = new GridBagConstraints();
        gbc_patientName.fill = GridBagConstraints.BOTH;
        gbc_patientName.insets = new Insets(0, 0, 5, 5);
        gbc_patientName.gridx = 2;
        gbc_patientName.gridy = 7;
        infoPanel.add(patientName, gbc_patientName);
        patientName
            .setText(String.valueOf(PatientQueries.getByID(app.getPatientID()).getFullName()));
        patientName.setColumns(10);

        treatmentPanel = new JPanel();
        contentPanel.add(treatmentPanel, BorderLayout.EAST);
        treatmentPanel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        treatmentPanel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{
                "Treatment", "Cost"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        RecordQueries.generateTreatmentTable(table, app);

        totalCostPanel = new JPanel();
        FlowLayout fl_totalCostPanel = (FlowLayout) totalCostPanel.getLayout();
        fl_totalCostPanel.setAlignment(FlowLayout.RIGHT);
        treatmentPanel.add(totalCostPanel, BorderLayout.SOUTH);

        totalCostLabel = new JLabel("Total Cost: \u00A3");

        totalCostPanel.add(totalCostLabel);

        totalCostTextField = new JTextField();
        totalCostTextField.setEditable(false);
        totalCostTextField.setText(String.valueOf(RecordQueries.getTotalCost(app)));
        totalCostPanel.add(totalCostTextField);
        totalCostTextField.setColumns(8);

        receiptLabel = new JLabel("Receipt", SwingConstants.CENTER);
        receiptLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        treatmentPanel.add(receiptLabel, BorderLayout.NORTH);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton saveButton = new JButton("OK");
        saveButton.addActionListener(e -> dispose());
        saveButton.setActionCommand("OK");
        buttonPane.add(saveButton);
        getRootPane().setDefaultButton(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        setTitle("View Appointment");
        setBounds(100, 100, 987, 466);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
