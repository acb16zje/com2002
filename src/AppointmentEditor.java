import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class AppointmentEditor extends JDialog {

    private JTable table;
    private JTextField startTime;
    private JTextField patientID;
    private JTextField id;
    private JTextField endTime;
    private JLabel idLabel;
    private JLabel startTimeLabel;
    private JLabel endTimeLabel;
    private JLabel patientIDLabel;

    /**
     * Create the dialog.
     */
    public AppointmentEditor() {
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPanel.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{53, 0, 15, 0};
        gbl_panel.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        idLabel = new JLabel("ID:");
        GridBagConstraints gbc_idLabel = new GridBagConstraints();
        gbc_idLabel.anchor = GridBagConstraints.EAST;
        gbc_idLabel.insets = new Insets(0, 0, 5, 5);
        gbc_idLabel.gridx = 0;
        gbc_idLabel.gridy = 1;
        panel.add(idLabel, gbc_idLabel);

        id = new JTextField();
        id.setColumns(10);
        GridBagConstraints gbc_id = new GridBagConstraints();
        gbc_id.anchor = GridBagConstraints.NORTHWEST;
        gbc_id.insets = new Insets(0, 0, 5, 5);
        gbc_id.gridx = 1;
        gbc_id.gridy = 1;
        panel.add(id, gbc_id);

        startTimeLabel = new JLabel("Start Time:");
        GridBagConstraints gbc_startTimeLabel = new GridBagConstraints();
        gbc_startTimeLabel.anchor = GridBagConstraints.EAST;
        gbc_startTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_startTimeLabel.gridx = 0;
        gbc_startTimeLabel.gridy = 2;
        panel.add(startTimeLabel, gbc_startTimeLabel);

        startTime = new JTextField();
        startTime.setColumns(10);
        GridBagConstraints gbc_startTime = new GridBagConstraints();
        gbc_startTime.anchor = GridBagConstraints.NORTHWEST;
        gbc_startTime.insets = new Insets(0, 0, 5, 5);
        gbc_startTime.gridx = 1;
        gbc_startTime.gridy = 2;
        panel.add(startTime, gbc_startTime);

        endTimeLabel = new JLabel("End Time:");
        GridBagConstraints gbc_endTimeLabel = new GridBagConstraints();
        gbc_endTimeLabel.anchor = GridBagConstraints.EAST;
        gbc_endTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_endTimeLabel.gridx = 0;
        gbc_endTimeLabel.gridy = 3;
        panel.add(endTimeLabel, gbc_endTimeLabel);

        endTime = new JTextField();
        GridBagConstraints gbc_endTime = new GridBagConstraints();
        gbc_endTime.anchor = GridBagConstraints.WEST;
        gbc_endTime.insets = new Insets(0, 0, 5, 5);
        gbc_endTime.gridx = 1;
        gbc_endTime.gridy = 3;
        panel.add(endTime, gbc_endTime);
        endTime.setColumns(10);

        patientIDLabel = new JLabel("patientID:");
        GridBagConstraints gbc_patientIDLabel = new GridBagConstraints();
        gbc_patientIDLabel.insets = new Insets(0, 0, 5, 5);
        gbc_patientIDLabel.anchor = GridBagConstraints.EAST;
        gbc_patientIDLabel.gridx = 0;
        gbc_patientIDLabel.gridy = 4;
        panel.add(patientIDLabel, gbc_patientIDLabel);

        patientID = new JTextField();
        patientID.setColumns(10);
        GridBagConstraints gbc_patientID = new GridBagConstraints();
        gbc_patientID.insets = new Insets(0, 0, 5, 5);
        gbc_patientID.anchor = GridBagConstraints.NORTHWEST;
        gbc_patientID.gridx = 1;
        gbc_patientID.gridy = 4;
        panel.add(patientID, gbc_patientID);

        JLabel partnerLabel = new JLabel("Partner:");
        GridBagConstraints gbc_partnerLabel = new GridBagConstraints();
        gbc_partnerLabel.insets = new Insets(0, 0, 5, 5);
        gbc_partnerLabel.gridx = 1;
        gbc_partnerLabel.gridy = 7;
        panel.add(partnerLabel, gbc_partnerLabel);

        ButtonGroup partnerGroup = new ButtonGroup();

        JRadioButton hygienistButton = new JRadioButton("Hygienist");
        GridBagConstraints gbc_hygienistButton = new GridBagConstraints();
        gbc_hygienistButton.insets = new Insets(0, 0, 5, 5);
        gbc_hygienistButton.gridx = 1;
        gbc_hygienistButton.gridy = 8;
        panel.add(hygienistButton, gbc_hygienistButton);
        partnerGroup.add(hygienistButton);

        JRadioButton dentistButton = new JRadioButton("Dentist");
        GridBagConstraints gbc_dentistButton = new GridBagConstraints();
        gbc_dentistButton.insets = new Insets(0, 0, 5, 5);
        gbc_dentistButton.gridx = 1;
        gbc_dentistButton.gridy = 9;
        panel.add(dentistButton, gbc_dentistButton);
        partnerGroup.add(dentistButton);

        JScrollPane scrollPane = new JScrollPane();
        contentPanel.add(scrollPane, BorderLayout.EAST);

        table = new JTable();
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

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        setBounds(100, 100, 700, 400);
        setLocationRelativeTo(null);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AppointmentEditor dialog = new AppointmentEditor();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
