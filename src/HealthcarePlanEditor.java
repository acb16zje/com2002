import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

public class HealthcarePlanEditor extends JDialog {

    /**
     * Create the frame.
     */
    public HealthcarePlanEditor() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        NumberFormat integerNumberInstance = NumberFormat.getIntegerInstance();
        integerNumberInstance.setMaximumIntegerDigits(13);
        integerNumberInstance.setGroupingUsed(false);
        NumberFormat moneyNumberInstance = NumberFormat.getIntegerInstance();
        moneyNumberInstance.setMaximumIntegerDigits(13);
        moneyNumberInstance.setMinimumFractionDigits(2);
        moneyNumberInstance.setMaximumFractionDigits(2);

        JPanel editPanel = new JPanel();
        contentPane.add(editPanel, BorderLayout.CENTER);
        GridBagLayout gbl_editPanel = new GridBagLayout();
        gbl_editPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_editPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_editPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_editPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            Double.MIN_VALUE};
        editPanel.setLayout(gbl_editPanel);

        JLabel lblPlanName = new JLabel("Plan Name:");
        GridBagConstraints gbc_lblPlanName = new GridBagConstraints();
        gbc_lblPlanName.anchor = GridBagConstraints.EAST;
        gbc_lblPlanName.insets = new Insets(0, 0, 5, 5);
        gbc_lblPlanName.gridx = 1;
        gbc_lblPlanName.gridy = 1;
        editPanel.add(lblPlanName, gbc_lblPlanName);

        JFormattedTextField planName = new JFormattedTextField();
        GridBagConstraints gbc_planName = new GridBagConstraints();
        gbc_planName.insets = new Insets(0, 0, 5, 5);
        gbc_planName.fill = GridBagConstraints.HORIZONTAL;
        gbc_planName.gridx = 2;
        gbc_planName.gridy = 1;
        editPanel.add(planName, gbc_planName);

        JLabel lblCost = new JLabel("Cost:");
        GridBagConstraints gbc_lblCost = new GridBagConstraints();
        gbc_lblCost.insets = new Insets(0, 0, 5, 5);
        gbc_lblCost.anchor = GridBagConstraints.EAST;
        gbc_lblCost.gridx = 1;
        gbc_lblCost.gridy = 3;
        editPanel.add(lblCost, gbc_lblCost);

        JTextField cost = new JTextField();
        cost.setColumns(10);
        ((AbstractDocument) cost.getDocument()).setDocumentFilter(new MoneyFlt());
        GridBagConstraints gbc_cost = new GridBagConstraints();
        gbc_cost.anchor = GridBagConstraints.WEST;
        gbc_cost.insets = new Insets(0, 0, 5, 5);
        gbc_cost.gridx = 2;
        gbc_cost.gridy = 3;
        editPanel.add(cost, gbc_cost);

        JLabel lblCheckUp = new JLabel("Check Up:");
        GridBagConstraints gbc_lblCheckUp = new GridBagConstraints();
        gbc_lblCheckUp.insets = new Insets(0, 0, 5, 5);
        gbc_lblCheckUp.anchor = GridBagConstraints.EAST;
        gbc_lblCheckUp.gridx = 1;
        gbc_lblCheckUp.gridy = 5;
        editPanel.add(lblCheckUp, gbc_lblCheckUp);

        JTextField checkUp = new JTextField();
        ((AbstractDocument) checkUp.getDocument()).setDocumentFilter(new IntegerFlt());
        checkUp.setColumns(5);
        GridBagConstraints gbc_checkUp = new GridBagConstraints();
        gbc_checkUp.anchor = GridBagConstraints.WEST;
        gbc_checkUp.insets = new Insets(0, 0, 5, 5);
        gbc_checkUp.gridx = 2;
        gbc_checkUp.gridy = 5;
        editPanel.add(checkUp, gbc_checkUp);

        JLabel lblHygienevisit = new JLabel("Hygiene Visit:");
        GridBagConstraints gbc_lblHygienevisit = new GridBagConstraints();
        gbc_lblHygienevisit.insets = new Insets(0, 0, 5, 5);
        gbc_lblHygienevisit.anchor = GridBagConstraints.EAST;
        gbc_lblHygienevisit.gridx = 1;
        gbc_lblHygienevisit.gridy = 6;
        editPanel.add(lblHygienevisit, gbc_lblHygienevisit);

        JTextField hygieneVisit = new JTextField();
        ((AbstractDocument) hygieneVisit.getDocument()).setDocumentFilter(new IntegerFlt());
        hygieneVisit.setColumns(5);
        GridBagConstraints gbc_hygieneVisit = new GridBagConstraints();
        gbc_hygieneVisit.anchor = GridBagConstraints.WEST;
        gbc_hygieneVisit.insets = new Insets(0, 0, 5, 5);
        gbc_hygieneVisit.gridx = 2;
        gbc_hygieneVisit.gridy = 6;
        editPanel.add(hygieneVisit, gbc_hygieneVisit);

        JLabel lblRepairWork = new JLabel("Repair Work:");
        GridBagConstraints gbc_lblRepairWork = new GridBagConstraints();
        gbc_lblRepairWork.insets = new Insets(0, 0, 5, 5);
        gbc_lblRepairWork.anchor = GridBagConstraints.EAST;
        gbc_lblRepairWork.gridx = 1;
        gbc_lblRepairWork.gridy = 7;
        editPanel.add(lblRepairWork, gbc_lblRepairWork);

        JTextField repairVisit = new JTextField();
        ((AbstractDocument) repairVisit.getDocument()).setDocumentFilter(new IntegerFlt());
        repairVisit.setColumns(5);
        GridBagConstraints gbc_repairVisit = new GridBagConstraints();
        gbc_repairVisit.anchor = GridBagConstraints.WEST;
        gbc_repairVisit.insets = new Insets(0, 0, 5, 5);
        gbc_repairVisit.gridx = 2;
        gbc_repairVisit.gridy = 7;
        editPanel.add(repairVisit, gbc_repairVisit);

        GridBagConstraints gbc_frmtdtxtfldJjj = new GridBagConstraints();
        gbc_frmtdtxtfldJjj.insets = new Insets(0, 0, 0, 5);
        gbc_frmtdtxtfldJjj.fill = GridBagConstraints.HORIZONTAL;
        gbc_frmtdtxtfldJjj.gridx = 2;
        gbc_frmtdtxtfldJjj.gridy = 8;

        JPanel selectPanel = new JPanel();
        contentPane.add(selectPanel, BorderLayout.SOUTH);

        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean completed = true;
                Component[] components = editPanel.getComponents();
                for (Component comp : components) {
                    // Cast comp to JComboBox / JTextField to get the values
                    if ((comp instanceof JTextField)) {
                        if (((JTextField) comp).getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Please Complete");
                            completed = false;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, ((JTextField) comp).getText());
                        }
                    }
                }
                if (completed) {
                    dispose();
                }
            }
        });
        selectPanel.add(doneButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        selectPanel.add(cancelButton);

        setTitle("Healthcare Plan Editor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HealthcarePlanEditor frame = new HealthcarePlanEditor();
                    frame.setModal(true);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
