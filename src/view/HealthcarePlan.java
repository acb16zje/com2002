package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HealthcarePlan extends JDialog {

    /**
     * Create the dialog.
     */
    public HealthcarePlan() {
        // Main contel panel
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{35, 149, 254, 0};
        gbl_contentPanel.rowHeights = new int[]{20, 40, 40, 40, 40, 40, 40, 40, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);

        // Label for healthcare plan
        JLabel lblHealthcarePlan = new JLabel("Healthcare Plan:");
        GridBagConstraints gbc_lblHealthcarePlan = new GridBagConstraints();
        gbc_lblHealthcarePlan.anchor = GridBagConstraints.WEST;
        gbc_lblHealthcarePlan.insets = new Insets(0, 0, 5, 5);
        gbc_lblHealthcarePlan.gridx = 1;
        gbc_lblHealthcarePlan.gridy = 1;
        contentPanel.add(lblHealthcarePlan, gbc_lblHealthcarePlan);

        // Text field for displaying the patient subscribed plan
        JTextField healthcarePlan = new JTextField();
        healthcarePlan.setFont(new Font("Dialog", Font.PLAIN, 16));
        healthcarePlan.setEditable(false);
        GridBagConstraints gbc_healthcarePlan = new GridBagConstraints();
        gbc_healthcarePlan.fill = GridBagConstraints.HORIZONTAL;
        gbc_healthcarePlan.insets = new Insets(0, 0, 5, 0);
        gbc_healthcarePlan.gridx = 2;
        gbc_healthcarePlan.gridy = 1;
        contentPanel.add(healthcarePlan, gbc_healthcarePlan);
        healthcarePlan.setColumns(10);

        // Label for the monthly amount
        JLabel lblMonthlyPay = new JLabel("Monthly Pay:");
        GridBagConstraints gbc_lblMonthlyPay = new GridBagConstraints();
        gbc_lblMonthlyPay.anchor = GridBagConstraints.WEST;
        gbc_lblMonthlyPay.insets = new Insets(0, 0, 5, 5);
        gbc_lblMonthlyPay.gridx = 1;
        gbc_lblMonthlyPay.gridy = 2;
        contentPanel.add(lblMonthlyPay, gbc_lblMonthlyPay);

        // Text field for displaying the monthly amount
        JTextField monthlyPay = new JTextField();
        monthlyPay.setFont(new Font("Dialog", Font.PLAIN, 16));
        monthlyPay.setEditable(false);
        GridBagConstraints gbc_monthlyPay = new GridBagConstraints();
        gbc_monthlyPay.fill = GridBagConstraints.HORIZONTAL;
        gbc_monthlyPay.insets = new Insets(0, 0, 5, 0);
        gbc_monthlyPay.gridx = 2;
        gbc_monthlyPay.gridy = 2;
        contentPanel.add(monthlyPay, gbc_monthlyPay);
        monthlyPay.setColumns(10);

        // Label for start date
        JLabel lblStartDate = new JLabel("Start Date:");
        GridBagConstraints gbc_lblStartDate = new GridBagConstraints();
        gbc_lblStartDate.anchor = GridBagConstraints.WEST;
        gbc_lblStartDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblStartDate.gridx = 1;
        gbc_lblStartDate.gridy = 3;
        contentPanel.add(lblStartDate, gbc_lblStartDate);

        // Text field for displaying the plan start date
        JTextField startDate = new JTextField();
        startDate.setFont(new Font("Dialog", Font.PLAIN, 16));
        startDate.setEditable(false);
        GridBagConstraints gbc_startDate = new GridBagConstraints();
        gbc_startDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_startDate.insets = new Insets(0, 0, 5, 0);
        gbc_startDate.gridx = 2;
        gbc_startDate.gridy = 3;
        contentPanel.add(startDate, gbc_startDate);
        startDate.setColumns(10);

        // Label for end date
        JLabel lblEndDate = new JLabel("End Date:");
        GridBagConstraints gbc_lblEndDate = new GridBagConstraints();
        gbc_lblEndDate.anchor = GridBagConstraints.WEST;
        gbc_lblEndDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblEndDate.gridx = 1;
        gbc_lblEndDate.gridy = 4;
        contentPanel.add(lblEndDate, gbc_lblEndDate);

        // Text field for displaying the plan end date
        JTextField endDate = new JTextField();
        endDate.setFont(new Font("Dialog", Font.PLAIN, 16));
        endDate.setEditable(false);
        GridBagConstraints gbc_endDate = new GridBagConstraints();
        gbc_endDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_endDate.insets = new Insets(0, 0, 5, 0);
        gbc_endDate.gridx = 2;
        gbc_endDate.gridy = 4;
        contentPanel.add(endDate, gbc_endDate);
        endDate.setColumns(10);

        // Label for amount of check up left
        JLabel lblCheckUpLeft = new JLabel("Check Up Left:");
        GridBagConstraints gbc_lblCheckUpLeft = new GridBagConstraints();
        gbc_lblCheckUpLeft.anchor = GridBagConstraints.WEST;
        gbc_lblCheckUpLeft.insets = new Insets(0, 0, 5, 5);
        gbc_lblCheckUpLeft.gridx = 1;
        gbc_lblCheckUpLeft.gridy = 5;
        contentPanel.add(lblCheckUpLeft, gbc_lblCheckUpLeft);

        // Text field to display the amount of check up left
        JTextField checkUpLeft = new JTextField();
        checkUpLeft.setFont(new Font("Dialog", Font.PLAIN, 16));
        checkUpLeft.setEditable(false);
        GridBagConstraints gbc_checkUpLeft = new GridBagConstraints();
        gbc_checkUpLeft.fill = GridBagConstraints.HORIZONTAL;
        gbc_checkUpLeft.insets = new Insets(0, 0, 5, 0);
        gbc_checkUpLeft.gridx = 2;
        gbc_checkUpLeft.gridy = 5;
        contentPanel.add(checkUpLeft, gbc_checkUpLeft);
        checkUpLeft.setColumns(10);

        // Label of amount of hygiene visit left
        JLabel lblHygieneLeft = new JLabel("Hygiene Visit Left:");
        GridBagConstraints gbc_lblHygieneLeft = new GridBagConstraints();
        gbc_lblHygieneLeft.anchor = GridBagConstraints.WEST;
        gbc_lblHygieneLeft.insets = new Insets(0, 0, 5, 5);
        gbc_lblHygieneLeft.gridx = 1;
        gbc_lblHygieneLeft.gridy = 6;
        contentPanel.add(lblHygieneLeft, gbc_lblHygieneLeft);

        // Text field to display the amount of hygiene visit left
        JTextField hygieneVisitLeft = new JTextField();
        hygieneVisitLeft.setFont(new Font("Dialog", Font.PLAIN, 16));
        hygieneVisitLeft.setEditable(false);
        GridBagConstraints gbc_hygieneVisitLeft = new GridBagConstraints();
        gbc_hygieneVisitLeft.fill = GridBagConstraints.HORIZONTAL;
        gbc_hygieneVisitLeft.insets = new Insets(0, 0, 5, 0);
        gbc_hygieneVisitLeft.gridx = 2;
        gbc_hygieneVisitLeft.gridy = 6;
        contentPanel.add(hygieneVisitLeft, gbc_hygieneVisitLeft);
        hygieneVisitLeft.setColumns(10);

        // Label for amount of repair work left
        JLabel lblRepairLeft = new JLabel("Repair Work Left:");
        GridBagConstraints gbc_lblRepairLeft = new GridBagConstraints();
        gbc_lblRepairLeft.anchor = GridBagConstraints.WEST;
        gbc_lblRepairLeft.insets = new Insets(0, 0, 0, 5);
        gbc_lblRepairLeft.gridx = 1;
        gbc_lblRepairLeft.gridy = 7;
        contentPanel.add(lblRepairLeft, gbc_lblRepairLeft);

        // Text field to display the amount of repair work left
        JTextField repairWork = new JTextField();
        repairWork.setFont(new Font("Dialog", Font.PLAIN, 16));
        repairWork.setEditable(false);
        GridBagConstraints gbc_repairWork = new GridBagConstraints();
        gbc_repairWork.fill = GridBagConstraints.HORIZONTAL;
        gbc_repairWork.gridx = 2;
        gbc_repairWork.gridy = 7;
        contentPanel.add(repairWork, gbc_repairWork);
        repairWork.setColumns(10);

        // Panel for OK button
        JPanel buttonPane = new JPanel();
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        // OK button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> dispose());
        buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        // Basic settings
        setTitle("View Patient Plan");
        setBounds(100, 100, 488, 384);
        setResizable(false);
        setLocationRelativeTo(null);
    }

}
