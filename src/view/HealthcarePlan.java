package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HealthcarePlan extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField checkUpLeft;
    private JTextField startDate;
    private JTextField monthlyPay;
    private JTextField healthcarePlan;
    private JTextField endDate;
    private JTextField hygieneVisitLeft;
    private JTextField repairWork;

    /**
     * Create the dialog.
     */
    public HealthcarePlan() {
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0,
            Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);

        JLabel lblHealthcarePlan = new JLabel("Healthcare Plan:");
        GridBagConstraints gbc_lblHealthcarePlan = new GridBagConstraints();
        gbc_lblHealthcarePlan.anchor = GridBagConstraints.EAST;
        gbc_lblHealthcarePlan.insets = new Insets(0, 0, 5, 5);
        gbc_lblHealthcarePlan.gridx = 1;
        gbc_lblHealthcarePlan.gridy = 1;
        contentPanel.add(lblHealthcarePlan, gbc_lblHealthcarePlan);

        healthcarePlan = new JTextField();
        healthcarePlan.setEditable(false);
        GridBagConstraints gbc_healthcarePlan = new GridBagConstraints();
        gbc_healthcarePlan.insets = new Insets(0, 0, 5, 5);
        gbc_healthcarePlan.fill = GridBagConstraints.HORIZONTAL;
        gbc_healthcarePlan.gridx = 2;
        gbc_healthcarePlan.gridy = 1;
        contentPanel.add(healthcarePlan, gbc_healthcarePlan);
        healthcarePlan.setColumns(10);

        JLabel lblMonthlyPay = new JLabel("Monthly Pay:");
        GridBagConstraints gbc_lblMonthlyPay = new GridBagConstraints();
        gbc_lblMonthlyPay.anchor = GridBagConstraints.EAST;
        gbc_lblMonthlyPay.insets = new Insets(0, 0, 5, 5);
        gbc_lblMonthlyPay.gridx = 1;
        gbc_lblMonthlyPay.gridy = 2;
        contentPanel.add(lblMonthlyPay, gbc_lblMonthlyPay);

        monthlyPay = new JTextField();
        monthlyPay.setEditable(false);
        GridBagConstraints gbc_monthlyPay = new GridBagConstraints();
        gbc_monthlyPay.insets = new Insets(0, 0, 5, 5);
        gbc_monthlyPay.fill = GridBagConstraints.HORIZONTAL;
        gbc_monthlyPay.gridx = 2;
        gbc_monthlyPay.gridy = 2;
        contentPanel.add(monthlyPay, gbc_monthlyPay);
        monthlyPay.setColumns(10);

        JLabel lblStartDate = new JLabel("Start Date:");
        GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
        gbc_lblStartDate.anchor = GridBagConstraints.EAST;
        gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblStartDate.gridx = 1;
        gbc_lblStartDate.gridy = 3;
        contentPanel.add(lblStartDate, gbc_lblStartDate);

        startDate = new JTextField();
        startDate.setEditable(false);
        GridBagConstraints gbc_startDate = new GridBagConstraints();
        gbc_startDate.insets = new Insets(0, 0, 5, 5);
        gbc_startDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_startDate.gridx = 2;
        gbc_startDate.gridy = 3;
        contentPanel.add(startDate, gbc_startDate);
        startDate.setColumns(10);

        JLabel lblEndDate = new JLabel("End Date:");
        GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
        gbc_lblEndDate.anchor = GridBagConstraints.EAST;
        gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblEndDate.gridx = 4;
        gbc_lblEndDate.gridy = 3;
        contentPanel.add(lblEndDate, gbc_lblEndDate);

        endDate = new JTextField();
        endDate.setEditable(false);
        GridBagConstraints gbc_endDate = new GridBagConstraints();
        gbc_endDate.insets = new Insets(0, 0, 5, 0);
        gbc_endDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_endDate.gridx = 5;
        gbc_endDate.gridy = 3;
        contentPanel.add(endDate, gbc_endDate);
        endDate.setColumns(10);

        JLabel lblCheckUpLeft = new JLabel("Check Up Left:");
        GridBagConstraints gbc_lblCheckUpLeft = new GridBagConstraints();
        gbc_lblCheckUpLeft.anchor = GridBagConstraints.EAST;
        gbc_lblCheckUpLeft.insets = new Insets(0, 0, 5, 5);
        gbc_lblCheckUpLeft.gridx = 1;
        gbc_lblCheckUpLeft.gridy = 4;
        contentPanel.add(lblCheckUpLeft, gbc_lblCheckUpLeft);

        checkUpLeft = new JTextField();
        checkUpLeft.setEditable(false);
        GridBagConstraints gbc_checkUpLeft = new GridBagConstraints();
        gbc_checkUpLeft.insets = new Insets(0, 0, 5, 5);
        gbc_checkUpLeft.fill = GridBagConstraints.HORIZONTAL;
        gbc_checkUpLeft.gridx = 2;
        gbc_checkUpLeft.gridy = 4;
        contentPanel.add(checkUpLeft, gbc_checkUpLeft);
        checkUpLeft.setColumns(10);

        JLabel lblHygieneLeft = new JLabel("Hygiene Visit Left:");
        GridBagConstraints gbc_lblHygieneLeft = new GridBagConstraints();
        gbc_lblHygieneLeft.anchor = GridBagConstraints.EAST;
        gbc_lblHygieneLeft.insets = new Insets(0, 0, 5, 5);
        gbc_lblHygieneLeft.gridx = 1;
        gbc_lblHygieneLeft.gridy = 5;
        contentPanel.add(lblHygieneLeft, gbc_lblHygieneLeft);

        hygieneVisitLeft = new JTextField();
        hygieneVisitLeft.setEditable(false);
        GridBagConstraints gbc_hygieneVisitLeft = new GridBagConstraints();
        gbc_hygieneVisitLeft.insets = new Insets(0, 0, 5, 5);
        gbc_hygieneVisitLeft.fill = GridBagConstraints.HORIZONTAL;
        gbc_hygieneVisitLeft.gridx = 2;
        gbc_hygieneVisitLeft.gridy = 5;
        contentPanel.add(hygieneVisitLeft, gbc_hygieneVisitLeft);
        hygieneVisitLeft.setColumns(10);

        JLabel lblRepairLeft = new JLabel("Repair Work Left:");
        GridBagConstraints gbc_lblRepairLeft = new GridBagConstraints();
        gbc_lblRepairLeft.anchor = GridBagConstraints.EAST;
        gbc_lblRepairLeft.insets = new Insets(0, 0, 0, 5);
        gbc_lblRepairLeft.gridx = 1;
        gbc_lblRepairLeft.gridy = 6;
        contentPanel.add(lblRepairLeft, gbc_lblRepairLeft);

        repairWork = new JTextField();
        repairWork.setEditable(false);
        GridBagConstraints gbc_repairWork = new GridBagConstraints();
        gbc_repairWork.insets = new Insets(0, 0, 0, 5);
        gbc_repairWork.fill = GridBagConstraints.HORIZONTAL;
        gbc_repairWork.gridx = 2;
        gbc_repairWork.gridy = 6;
        contentPanel.add(repairWork, gbc_repairWork);
        repairWork.setColumns(10);

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

        setTitle("View Healthcare Plan");
        setBounds(100, 100, 450, 300);
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
