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


public class AppointmentSearch extends JDialog {

    private JTextField textField;

    /**
     * Create the dialog.
     */
    public AppointmentSearch() {
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);

        JLabel lblSearchAppointment = new JLabel("Search Appointment");
        lblSearchAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GridBagConstraints gbc_lblSearchAppointment = new GridBagConstraints();
        gbc_lblSearchAppointment.gridwidth = 2;
        gbc_lblSearchAppointment.insets = new Insets(0, 0, 5, 5);
        gbc_lblSearchAppointment.gridx = 1;
        gbc_lblSearchAppointment.gridy = 1;
        contentPanel.add(lblSearchAppointment, gbc_lblSearchAppointment);

        JLabel lblSearch = new JLabel("PatientID:");
        GridBagConstraints gbc_lblSearch = new GridBagConstraints();
        gbc_lblSearch.insets = new Insets(0, 0, 0, 5);
        gbc_lblSearch.anchor = GridBagConstraints.EAST;
        gbc_lblSearch.gridx = 1;
        gbc_lblSearch.gridy = 3;
        contentPanel.add(lblSearch, gbc_lblSearch);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 0, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 3;
        contentPanel.add(textField, gbc_textField);
        textField.setColumns(10);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        setTitle("Search Appointment");
        setBounds(100, 100, 450, 300);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Main method for running the appointment search frame
     *
     * @param args Command line arguments, not used
     */
    public static void main(String[] args) {
        try {
            AppointmentSearch dialog = new AppointmentSearch();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
