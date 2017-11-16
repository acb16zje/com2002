package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AppointmentEditorPartner extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable table;

    /**
     * Create the dialog.
     */
    public AppointmentEditorPartner() {
        setBounds(100, 100, 450, 600);
        getContentPane().setLayout(null);
        contentPanel.setBounds(0, 0, 434, 561);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{434, 0};
        gbl_contentPanel.rowHeights = new int[]{129, 372, 48, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JPanel panel = new JPanel();
            GridBagConstraints gbc_panel = new GridBagConstraints();
            gbc_panel.fill = GridBagConstraints.BOTH;
            gbc_panel.insets = new Insets(0, 0, 5, 0);
            gbc_panel.gridx = 0;
            gbc_panel.gridy = 0;
            contentPanel.add(panel, gbc_panel);
            GridBagLayout gbl_panel = new GridBagLayout();
            gbl_panel.columnWidths = new int[]{30, 68, 88, 68, 0};
            gbl_panel.rowHeights = new int[]{14, 14, 14, 23, 0};
            gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
            gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
            panel.setLayout(gbl_panel);
            {
                JLabel lblNewLabel = new JLabel("Patient Name:");
                GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
                gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
                gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
                gbc_lblNewLabel.gridx = 1;
                gbc_lblNewLabel.gridy = 0;
                panel.add(lblNewLabel, gbc_lblNewLabel);
            }

            JLabel lblPatientid = new JLabel("PatientID:");
            GridBagConstraints gbc_lblPatientid = new GridBagConstraints();
            gbc_lblPatientid.anchor = GridBagConstraints.NORTH;
            gbc_lblPatientid.fill = GridBagConstraints.HORIZONTAL;
            gbc_lblPatientid.insets = new Insets(0, 0, 5, 5);
            gbc_lblPatientid.gridx = 1;
            gbc_lblPatientid.gridy = 1;
            panel.add(lblPatientid, gbc_lblPatientid);

            JLabel lblStartTime = new JLabel("Start Time:");
            GridBagConstraints gbc_lblStartTime = new GridBagConstraints();
            gbc_lblStartTime.anchor = GridBagConstraints.NORTH;
            gbc_lblStartTime.fill = GridBagConstraints.HORIZONTAL;
            gbc_lblStartTime.insets = new Insets(0, 0, 5, 5);
            gbc_lblStartTime.gridx = 1;
            gbc_lblStartTime.gridy = 2;
            panel.add(lblStartTime, gbc_lblStartTime);

            JLabel lblEndTime = new JLabel("End Time:");
            GridBagConstraints gbc_lblEndTime = new GridBagConstraints();
            gbc_lblEndTime.anchor = GridBagConstraints.NORTH;
            gbc_lblEndTime.fill = GridBagConstraints.HORIZONTAL;
            gbc_lblEndTime.insets = new Insets(0, 0, 5, 0);
            gbc_lblEndTime.gridx = 3;
            gbc_lblEndTime.gridy = 2;
            panel.add(lblEndTime, gbc_lblEndTime);

            JCheckBox chckbxAppointmentCompleted = new JCheckBox("Appointment Completed");
            GridBagConstraints gbc_chckbxAppointmentCompleted = new GridBagConstraints();
            gbc_chckbxAppointmentCompleted.anchor = GridBagConstraints.NORTH;
            gbc_chckbxAppointmentCompleted.fill = GridBagConstraints.HORIZONTAL;
            gbc_chckbxAppointmentCompleted.gridwidth = 3;
            gbc_chckbxAppointmentCompleted.gridx = 1;
            gbc_chckbxAppointmentCompleted.gridy = 3;
            panel.add(chckbxAppointmentCompleted, gbc_chckbxAppointmentCompleted);
        }
        {
            JScrollPane scrollPane = new JScrollPane();
            GridBagConstraints gbc_scrollPane = new GridBagConstraints();
            gbc_scrollPane.fill = GridBagConstraints.BOTH;
            gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
            gbc_scrollPane.gridx = 0;
            gbc_scrollPane.gridy = 1;
            contentPanel.add(scrollPane, gbc_scrollPane);
            {
                table = new JTable();
                table.setCellSelectionEnabled(true);
                table.setRowHeight(30);
                table.setModel(new DefaultTableModel(
                    new Object[][]{
                        {null},
                        {null},
                    },
                    new String[]{
                        "Treatment"
                    }
                ));
                scrollPane.setViewportView(table);
            }
        }
        {

            JPanel panel_1 = new JPanel();
            GridBagConstraints gbc_panel_1 = new GridBagConstraints();
            gbc_panel_1.anchor = GridBagConstraints.NORTH;
            gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
            gbc_panel_1.gridx = 0;
            gbc_panel_1.gridy = 2;
            contentPanel.add(panel_1, gbc_panel_1);
            GridBagLayout gbl_panel_1 = new GridBagLayout();
            gbl_panel_1.columnWidths = new int[]{91, 96, 0, 0, 0, 0, 0, 0};
            gbl_panel_1.rowHeights = new int[]{48, 0, 0};
            gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE};
            gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
            panel_1.setLayout(gbl_panel_1);
            {
                JButton okButton = new JButton("OK");
                GridBagConstraints gbc_okButton = new GridBagConstraints();
                gbc_okButton.fill = GridBagConstraints.BOTH;
                gbc_okButton.insets = new Insets(0, 0, 5, 5);
                gbc_okButton.gridx = 0;
                gbc_okButton.gridy = 0;
                panel_1.add(okButton, gbc_okButton);
                okButton.addActionListener(e -> dispose());
                okButton.setActionCommand("OK");
                getRootPane().setDefaultButton(okButton);
            }
            JButton cancelButton = new JButton("Cancel");
            GridBagConstraints gbc_cancelButton = new GridBagConstraints();
            gbc_cancelButton.insets = new Insets(0, 0, 5, 5);
            gbc_cancelButton.fill = GridBagConstraints.BOTH;
            gbc_cancelButton.gridx = 1;
            gbc_cancelButton.gridy = 0;
            panel_1.add(cancelButton, gbc_cancelButton);
            cancelButton.setActionCommand("Cancel");

            JButton btnAddTreatmentRow = new JButton("Add Treatment Row");
            btnAddTreatmentRow.addActionListener(
                e -> ((DefaultTableModel) table.getModel()).addRow(new Object[]{}));
            GridBagConstraints gbc_btnAddTreatmentRow = new GridBagConstraints();
            gbc_btnAddTreatmentRow.fill = GridBagConstraints.VERTICAL;
            gbc_btnAddTreatmentRow.insets = new Insets(0, 0, 5, 0);
            gbc_btnAddTreatmentRow.gridx = 6;
            gbc_btnAddTreatmentRow.gridy = 0;
            panel_1.add(btnAddTreatmentRow, gbc_btnAddTreatmentRow);
            cancelButton.addActionListener(e -> dispose());
        }
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AppointmentEditorPartner dialog = new AppointmentEditorPartner();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
