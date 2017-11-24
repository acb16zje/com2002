package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

class ViewPatientOutstanding extends JDialog {

    /**
     * Create the dialog.
     */
    public ViewPatientOutstanding() {
        setTitle("Patient Outstandings");
        setResizable(false);
        setModal(true);
        setBounds(100, 100, 450, 600);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblPatientID = new JLabel("Patient ID:");
        lblPatientID.setBounds(40, 35, 75, 20);
        contentPanel.add(lblPatientID);

        JLabel patientId = new JLabel("");
        patientId.setBounds(0, 0, 0, 0);
        contentPanel.add(patientId);
        {
            Box box = new Box(BoxLayout.Y_AXIS);
            JPanel recordOwedPanel = new JPanel();
            recordOwedPanel.setBounds(10, 81, 424, 386);
            recordOwedPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
            contentPanel.add(recordOwedPanel);
            recordOwedPanel.setLayout(new BoxLayout(recordOwedPanel, BoxLayout.X_AXIS));

            JScrollPane scrollPane = new JScrollPane(box);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            recordOwedPanel.add(scrollPane);

            for (int i = 0; i < 5; i++) {
                JPanel panel = new JPanel();
                panel.setBorder(new LineBorder(new Color(0, 0, 0)));
                JLabel lblTreatment = new JLabel();
                lblTreatment.setText("Treatment " + i);
                JLabel lblOwed = new JLabel();
                lblOwed.setText(i + "00.00");
                JCheckBox paidCheckBox = new JCheckBox("Paid");
                panel.add(lblTreatment);
                panel.add(lblOwed);
                panel.add(paidCheckBox);
                panel.setMaximumSize(new Dimension(1080, 40));
                box.add(panel);
                box.revalidate();
            }
        }

        {
            JLabel lblTotalOwed = new JLabel("Total Owed:");
            lblTotalOwed.setBounds(160, 478, 78, 14);
            contentPanel.add(lblTotalOwed);
        }
        {
            JTextField textField = new JTextField();
            textField.setBounds(248, 475, 186, 20);
            textField.setEditable(false);
            contentPanel.add(textField);
            textField.setColumns(10);
        }
        {
            JButton btnUpdateCostOwed = new JButton("Update Cost Owed");
            btnUpdateCostOwed.setBounds(248, 504, 186, 23);
            contentPanel.add(btnUpdateCostOwed);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(arg0 -> dispose());
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(arg0 -> dispose());
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
