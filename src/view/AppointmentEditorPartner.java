package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AppointmentEditorPartner extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private JTextField nameTextField;
    private JTextField idTextField;
    private JTextField startTimeTextField;
    private JTextField endTimeTextField;

    /**
     * Create the dialog.
     */
    public AppointmentEditorPartner() {
        // Main content panel
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 476, 561);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(new BorderLayout(0, 0));

        // The info panel for displaying the appointment information
        JPanel infoPanel = new JPanel();
        contentPanel.add(infoPanel, BorderLayout.NORTH);
        GridBagLayout gbl_infoPanel = new GridBagLayout();
        gbl_infoPanel.columnWidths = new int[]{23, 115, 276, 47, 0};
        gbl_infoPanel.rowHeights = new int[]{40, 40, 40, 40, 40, 0};
        gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        infoPanel.setLayout(gbl_infoPanel);

        // Label for patient name
        JLabel nameLabel = new JLabel("Patient Name:");
        GridBagConstraints gbc_nameLabel = new GridBagConstraints();
        gbc_nameLabel.anchor = GridBagConstraints.WEST;
        gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nameLabel.gridx = 1;
        gbc_nameLabel.gridy = 0;
        infoPanel.add(nameLabel, gbc_nameLabel);

        // Text field for displaying patient name
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        nameTextField.setEditable(false);
        GridBagConstraints gbc_nameTextField = new GridBagConstraints();
        gbc_nameTextField.insets = new Insets(0, 0, 5, 5);
        gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nameTextField.gridx = 2;
        gbc_nameTextField.gridy = 0;
        infoPanel.add(nameTextField, gbc_nameTextField);
        nameTextField.setColumns(10);

        // Label for patient ID
        JLabel idLabel = new JLabel("Patient ID:");
        GridBagConstraints gbc_idLabel = new GridBagConstraints();
        gbc_idLabel.anchor = GridBagConstraints.WEST;
        gbc_idLabel.insets = new Insets(0, 0, 5, 5);
        gbc_idLabel.gridx = 1;
        gbc_idLabel.gridy = 1;
        infoPanel.add(idLabel, gbc_idLabel);

        // Text field for displaying patient ID
        idTextField = new JTextField();
        idTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        idTextField.setEditable(false);
        GridBagConstraints gbc_idTextField = new GridBagConstraints();
        gbc_idTextField.insets = new Insets(0, 0, 5, 5);
        gbc_idTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_idTextField.gridx = 2;
        gbc_idTextField.gridy = 1;
        infoPanel.add(idTextField, gbc_idTextField);
        idTextField.setColumns(10);

        // Label for start time
        JLabel startTimeLabel = new JLabel("Start Time:");
        GridBagConstraints gbc_startTimeLabel = new GridBagConstraints();
        gbc_startTimeLabel.anchor = GridBagConstraints.WEST;
        gbc_startTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_startTimeLabel.gridx = 1;
        gbc_startTimeLabel.gridy = 2;
        infoPanel.add(startTimeLabel, gbc_startTimeLabel);

        // Text field for displaying start time
        startTimeTextField = new JTextField();
        startTimeTextField.setEditable(false);
        startTimeTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        GridBagConstraints gbc_startTimeTextField = new GridBagConstraints();
        gbc_startTimeTextField.insets = new Insets(0, 0, 5, 5);
        gbc_startTimeTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_startTimeTextField.gridx = 2;
        gbc_startTimeTextField.gridy = 2;
        infoPanel.add(startTimeTextField, gbc_startTimeTextField);
        startTimeTextField.setColumns(10);

        // Label for end time
        JLabel endTimeLabel = new JLabel("End Time:");
        GridBagConstraints gbc_endTimeLabel = new GridBagConstraints();
        gbc_endTimeLabel.anchor = GridBagConstraints.WEST;
        gbc_endTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_endTimeLabel.gridx = 1;
        gbc_endTimeLabel.gridy = 3;
        infoPanel.add(endTimeLabel, gbc_endTimeLabel);

        // Text field for displaying end time
        endTimeTextField = new JTextField();
        endTimeTextField.setEditable(false);
        endTimeTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        GridBagConstraints gbc_endTimeTextField = new GridBagConstraints();
        gbc_endTimeTextField.insets = new Insets(0, 0, 5, 5);
        gbc_endTimeTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_endTimeTextField.gridx = 2;
        gbc_endTimeTextField.gridy = 3;
        infoPanel.add(endTimeTextField, gbc_endTimeTextField);
        endTimeTextField.setColumns(10);

        // Button for adding another treatment row
        JButton btnAddTreatmentRow = new JButton("Add Treatment Row");
        GridBagConstraints gbc_btnAddTreatmentRow = new GridBagConstraints();
        gbc_btnAddTreatmentRow.gridwidth = 4;
        gbc_btnAddTreatmentRow.insets = new Insets(0, 0, 0, 5);
        gbc_btnAddTreatmentRow.gridx = 0;
        gbc_btnAddTreatmentRow.gridy = 4;
        infoPanel.add(btnAddTreatmentRow, gbc_btnAddTreatmentRow);
        btnAddTreatmentRow.addActionListener(e ->
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{}));

        // Scroll pane for the treatment table
        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setCellSelectionEnabled(true);
        table.setRowHeight(30);
        table.setModel(new DefaultTableModel(
            new Object[][]{
                {null},
            },
            new String[]{
                "Treatment"
            }
        ));
        scrollPane.setViewportView(table);

        // Panel for finalizing the appointment
        JPanel finalPanel = new JPanel();
        contentPanel.add(finalPanel, BorderLayout.SOUTH);
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.X_AXIS));

        // Checkbox to mark the appointment as completed
        JCheckBox chckbxAppointmentCompleted = new JCheckBox("Appointment Completed");
        finalPanel.add(chckbxAppointmentCompleted);

        // Button panel for Finish and Cancel
        JPanel buttonPanel = new JPanel();
        finalPanel.add(buttonPanel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // The Finish button
        JButton okButton = new JButton("Finish");
        buttonPanel.add(okButton);
        okButton.addActionListener(e ->  {
        	int count= table.getModel().getRowCount(); 
        	boolean hasTreatment = false;
        	for (int i=0; i<count;i++) {
        		if (table.getModel().getValueAt(i, 0) != null) {
        			hasTreatment = true;
        			dispose();
        		}
        	}
        	if (!hasTreatment) {
        		JOptionPane.showMessageDialog(null, "No Treatment Inserted");
        	}
        });
        okButton.setActionCommand("OK");
        getRootPane().setDefaultButton(okButton);

        // The Cancel button
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(e -> dispose());

        // Basic settings
        setResizable(false);
        setTitle("Edit Appointment");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 478, 600);
    }
}
