import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class AppointmentEditor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField startTime;
	private JTextField patientID;
	private JTextField id;
	private JTextField endTime;

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

	/**
	 * Create the dialog.
	 */
	public AppointmentEditor() {
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{53, 0, 15, 0};
			gbl_panel.rowHeights = new int[]{20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel label = new JLabel("ID:");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 1;
				panel.add(label, gbc_label);
			}
			{
				id = new JTextField();
				id.setColumns(10);
				GridBagConstraints gbc_id = new GridBagConstraints();
				gbc_id.anchor = GridBagConstraints.NORTHWEST;
				gbc_id.insets = new Insets(0, 0, 5, 5);
				gbc_id.gridx = 1;
				gbc_id.gridy = 1;
				panel.add(id, gbc_id);
			}
			{
				JLabel label = new JLabel("Start Time:");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 2;
				panel.add(label, gbc_label);
			}
			{
				startTime = new JTextField();
				startTime.setColumns(10);
				GridBagConstraints gbc_startTime = new GridBagConstraints();
				gbc_startTime.anchor = GridBagConstraints.NORTHWEST;
				gbc_startTime.insets = new Insets(0, 0, 5, 5);
				gbc_startTime.gridx = 1;
				gbc_startTime.gridy = 2;
				panel.add(startTime, gbc_startTime);
			}
			{
				JLabel label = new JLabel("End Time:");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 0;
				gbc_label.gridy = 3;
				panel.add(label, gbc_label);
			}
			{
				endTime = new JTextField();
				GridBagConstraints gbc_endTime = new GridBagConstraints();
				gbc_endTime.anchor = GridBagConstraints.WEST;
				gbc_endTime.insets = new Insets(0, 0, 5, 5);
				gbc_endTime.gridx = 1;
				gbc_endTime.gridy = 3;
				panel.add(endTime, gbc_endTime);
				endTime.setColumns(10);
			}
			{
				JLabel label = new JLabel("patientID:");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.gridx = 0;
				gbc_label.gridy = 4;
				panel.add(label, gbc_label);
			}
			{
				patientID = new JTextField();
				patientID.setColumns(10);
				GridBagConstraints gbc_patientID = new GridBagConstraints();
				gbc_patientID.insets = new Insets(0, 0, 5, 5);
				gbc_patientID.anchor = GridBagConstraints.NORTHWEST;
				gbc_patientID.gridx = 1;
				gbc_patientID.gridy = 4;
				panel.add(patientID, gbc_patientID);
			}
			{
				JLabel lblPartner = new JLabel("Partner:");
				GridBagConstraints gbc_lblPartner = new GridBagConstraints();
				gbc_lblPartner.insets = new Insets(0, 0, 5, 5);
				gbc_lblPartner.gridx = 1;
				gbc_lblPartner.gridy = 7;
				panel.add(lblPartner, gbc_lblPartner);
			}
			ButtonGroup partnerGroup = new ButtonGroup();
			{
				JRadioButton hygienistButton = new JRadioButton("Hygienist");
				GridBagConstraints gbc_hygienistButton = new GridBagConstraints();
				gbc_hygienistButton.insets = new Insets(0, 0, 5, 5);
				gbc_hygienistButton.gridx = 1;
				gbc_hygienistButton.gridy = 8;
				panel.add(hygienistButton, gbc_hygienistButton);
				partnerGroup.add(hygienistButton);
			}
			{
				JRadioButton dentistButton = new JRadioButton("Dentist");
				GridBagConstraints gbc_dentistButton = new GridBagConstraints();
				gbc_dentistButton.insets = new Insets(0, 0, 5, 5);
				gbc_dentistButton.gridx = 1;
				gbc_dentistButton.gridy = 9;
				panel.add(dentistButton, gbc_dentistButton);
				partnerGroup.add(dentistButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.EAST);
			{
				table = new JTable();
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null},
						{null, null},
						{null, null},
						{null, null},
					},
					new String[] {
						"Treatment", "Cost"
					}
				));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
