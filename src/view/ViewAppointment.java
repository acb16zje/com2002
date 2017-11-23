package view;

import static java.time.temporal.ChronoUnit.MINUTES;

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

import controller.PatientQueries;
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
        infoPanel.setLayout(null);

        dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 82, 27, 14);
        infoPanel.add(dateLabel);

        dateTextField = new JTextField();
        dateTextField.setBounds(142, 76, 159, 27);
        dateTextField.setEditable(false);
        dateTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        dateTextField.setText(timeFormat.format(app.getDate().getTime()));
        infoPanel.add(dateTextField);
        dateTextField.setColumns(10);

        startTimeLabel = new JLabel("Start Time:");
        startTimeLabel.setBounds(50, 122, 53, 14);
        infoPanel.add(startTimeLabel);

        startTime = new JTextField();
        startTime.setBounds(142, 116, 159, 27);
        startTime.setEditable(false);
        startTime.setFont(new Font("Dialog", Font.PLAIN, 16));
        startTime.setColumns(10);
        startTime.setText(new SimpleDateFormat("HH:mm:ss").format(app.getStartTime()));
        infoPanel.add(startTime);

        endTimeLabel = new JLabel("End Time:");
        endTimeLabel.setBounds(50, 162, 47, 14);
        infoPanel.add(endTimeLabel);

        endTime = new JTextField();
        endTime.setBounds(142, 156, 159, 27);
        endTime.setFont(new Font("Dialog", Font.PLAIN, 16));
        endTime.setEditable(false);
        endTime.setText(new SimpleDateFormat("HH:mm:ss").format(app.getEndTime()));
        infoPanel.add(endTime);
        endTime.setColumns(10);

        typeLabel = new JLabel("Type:");
        typeLabel.setBounds(50, 202, 28, 14);
        infoPanel.add(typeLabel);

        checkUpRadioButton = new JRadioButton("Check-up / hygiene");
        checkUpRadioButton.setBounds(142, 198, 119, 23);
        checkUpRadioButton.setEnabled(false);
        infoPanel.add(checkUpRadioButton);

        treatmentRadioButton = new JRadioButton("Treatment");
        treatmentRadioButton.setBounds(306, 198, 75, 23);
        treatmentRadioButton.setEnabled(false);
        infoPanel.add(treatmentRadioButton);

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
        partnerLabel.setBounds(50, 242, 40, 14);
        infoPanel.add(partnerLabel);

        JRadioButton dentistRadioButton = new JRadioButton("Dentist");
        dentistRadioButton.setBounds(142, 238, 59, 23);
        dentistRadioButton.setEnabled(false);
        infoPanel.add(dentistRadioButton);

        JRadioButton hygienistRadioButton = new JRadioButton("Hygienist");
        hygienistRadioButton.setBounds(306, 238, 69, 23);
        hygienistRadioButton.setEnabled(false);
        infoPanel.add(hygienistRadioButton);

        ButtonGroup partner = new ButtonGroup();
        partner.add(dentistRadioButton);
        partner.add(hygienistRadioButton);
        if (app.getPartnerID() == 0) {
            partner.setSelected(dentistRadioButton.getModel(), true);
        } else {
            partner.setSelected(hygienistRadioButton.getModel(), true);
        }

        patientIDLabel = new JLabel("Patient ID:");
        patientIDLabel.setBounds(50, 282, 52, 14);
        infoPanel.add(patientIDLabel);

        patientID = new JTextField();
        patientID.setBounds(142, 276, 159, 27);
        patientID.setEditable(false);
        patientID.setFont(new Font("Dialog", Font.PLAIN, 16));
        patientID.setColumns(10);
        patientID.setText(String.valueOf(app.getPatientID()));
        infoPanel.add(patientID);
        
        lblPatientName = new JLabel("Patient Name:");
        lblPatientName.setBounds(50, 326, 68, 14);
        infoPanel.add(lblPatientName);
        
        patientName = new JTextField();
        patientName.setEditable(false);
        patientName.setBounds(142, 320, 159, 27);
        infoPanel.add(patientName);
        patientName.setText(String.valueOf(PatientQueries.getByID(app.getPatientID()).getFullName()));
        patientName.setColumns(10);

        treatmentPanel = new JPanel();
        contentPanel.add(treatmentPanel, BorderLayout.EAST);
        treatmentPanel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        treatmentPanel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(20);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][]{
                {null, null},
                {null, null},
                {null, null},
                {null, null},
            },
            new String[]{
                "Treatment", "Cost"
            }
        ));

        totalCostPanel = new JPanel();
        FlowLayout fl_totalCostPanel = (FlowLayout) totalCostPanel.getLayout();
        fl_totalCostPanel.setAlignment(FlowLayout.RIGHT);
        treatmentPanel.add(totalCostPanel, BorderLayout.SOUTH);

        totalCostLabel = new JLabel("Total Cost: \u00A3");
        totalCostPanel.add(totalCostLabel);

        totalCostTextField = new JTextField();
        totalCostTextField.setEditable(false);
        totalCostPanel.add(totalCostTextField);
        totalCostTextField.setColumns(8);

        receiptLabel = new JLabel("Receipt", SwingConstants.CENTER);
        receiptLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        treatmentPanel.add(receiptLabel, BorderLayout.NORTH);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> dispose());
        saveButton.setActionCommand("OK");
        buttonPane.add(saveButton);
        getRootPane().setDefaultButton(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        setTitle("View Appointment");
        setBounds(100, 100, 915, 466);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
