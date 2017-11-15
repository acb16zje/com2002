import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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

    /**
     * Create the dialog.
     */
    public ViewAppointment() {
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel infoPanel = new JPanel();
        contentPanel.add(infoPanel, BorderLayout.CENTER);
        GridBagLayout gbl_infoPanel = new GridBagLayout();
        gbl_infoPanel.columnWidths = new int[]{50, 92, 132, 0, 15, 0};
        gbl_infoPanel.rowHeights = new int[]{38, 40, 40, 40, 40, 40, 40, 36, 0};
        gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
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
        GridBagConstraints gbc_dateTextField = new GridBagConstraints();
        gbc_dateTextField.insets = new Insets(0, 0, 5, 5);
        gbc_dateTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_dateTextField.gridx = 2;
        gbc_dateTextField.gridy = 1;
        infoPanel.add(dateTextField, gbc_dateTextField);
        dateTextField.setColumns(10);

        startTimeLabel = new JLabel("Start Time:");
        GridBagConstraints gbc_startTimeLabel = new GridBagConstraints();
        gbc_startTimeLabel.anchor = GridBagConstraints.WEST;
        gbc_startTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_startTimeLabel.gridx = 1;
        gbc_startTimeLabel.gridy = 2;
        infoPanel.add(startTimeLabel, gbc_startTimeLabel);

        startTime = new JTextField();
        startTime.setEditable(false);
        startTime.setFont(new Font("Dialog", Font.PLAIN, 16));
        startTime.setColumns(10);
        GridBagConstraints gbc_startTime = new GridBagConstraints();
        gbc_startTime.fill = GridBagConstraints.HORIZONTAL;
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
        GridBagConstraints gbc_endTime = new GridBagConstraints();
        gbc_endTime.fill = GridBagConstraints.HORIZONTAL;
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
        gbc_treatmentRadioButton.anchor = GridBagConstraints.WEST;
        gbc_treatmentRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_treatmentRadioButton.gridx = 3;
        gbc_treatmentRadioButton.gridy = 4;
        infoPanel.add(treatmentRadioButton, gbc_treatmentRadioButton);

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
        gbc_hygienistRadioButton.anchor = GridBagConstraints.WEST;
        gbc_hygienistRadioButton.insets = new Insets(0, 0, 5, 5);
        gbc_hygienistRadioButton.gridx = 3;
        gbc_hygienistRadioButton.gridy = 5;
        infoPanel.add(hygienistRadioButton, gbc_hygienistRadioButton);

        patientIDLabel = new JLabel("Patient ID:");
        GridBagConstraints gbc_patientIDLabel = new GridBagConstraints();
        gbc_patientIDLabel.insets = new Insets(0, 0, 5, 5);
        gbc_patientIDLabel.anchor = GridBagConstraints.WEST;
        gbc_patientIDLabel.gridx = 1;
        gbc_patientIDLabel.gridy = 6;
        infoPanel.add(patientIDLabel, gbc_patientIDLabel);

        patientID = new JTextField();
        patientID.setEditable(false);
        patientID.setFont(new Font("Dialog", Font.PLAIN, 16));
        patientID.setColumns(10);
        GridBagConstraints gbc_patientID = new GridBagConstraints();
        gbc_patientID.fill = GridBagConstraints.HORIZONTAL;
        gbc_patientID.insets = new Insets(0, 0, 5, 5);
        gbc_patientID.gridx = 2;
        gbc_patientID.gridy = 6;
        infoPanel.add(patientID, gbc_patientID);

        ButtonGroup partnerGroup = new ButtonGroup();

        treatmentPanel = new JPanel();
        contentPanel.add(treatmentPanel, BorderLayout.EAST);
        treatmentPanel.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        treatmentPanel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(20);
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
                "Treatment", "Cost", "Amount Paid"
            }
        ));

        totalCostPanel = new JPanel();
        FlowLayout fl_totalCostPanel = (FlowLayout) totalCostPanel.getLayout();
        fl_totalCostPanel.setAlignment(FlowLayout.RIGHT);
        treatmentPanel.add(totalCostPanel, BorderLayout.SOUTH);

        totalCostLabel = new JLabel("Total Cost: £");
        totalCostPanel.add(totalCostLabel);

        totalCostTextField = new JTextField();
        totalCostTextField.setEditable(false);
        totalCostPanel.add(totalCostTextField);
        totalCostTextField.setColumns(8);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        saveButton.setActionCommand("OK");
        buttonPane.add(saveButton);
        getRootPane().setDefaultButton(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        setTitle("View Appointment");
        setBounds(100, 100, 915, 389);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ViewAppointment dialog = new ViewAppointment();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
