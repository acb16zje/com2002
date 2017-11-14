import com.github.lgooddatepicker.components.DatePicker;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

public class EditPatient extends JDialog {

    private JPanel contentPane;
    private JTextField foreName;
    private JTextField surName;
    private JTextField phoneNo;
    private JTextField houseNo;
    private JTextField street;
    private JTextField district;
    private JTextField city;
    private JTextField postcode;

    /**
     * Create the frame.
     */
    public EditPatient() {
        setTitle("Patient Editor");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 409, 609);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{30, 124, 182, 0, 0};
        gbl_panel.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
            0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblTitle = new JLabel("Title:");
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.anchor = GridBagConstraints.WEST;
        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitle.gridx = 1;
        gbc_lblTitle.gridy = 1;
        panel.add(lblTitle, gbc_lblTitle);

        JComboBox Title = new JComboBox(title.values());
        GridBagConstraints gbc_Title = new GridBagConstraints();
        gbc_Title.anchor = GridBagConstraints.WEST;
        gbc_Title.insets = new Insets(0, 0, 5, 5);
        gbc_Title.gridx = 2;
        gbc_Title.gridy = 1;
        panel.add(Title, gbc_Title);

        JLabel lblForeName = new JLabel("Forename:");
        GridBagConstraints gbc_lblForeName = new GridBagConstraints();
        gbc_lblForeName.anchor = GridBagConstraints.WEST;
        gbc_lblForeName.insets = new Insets(0, 0, 5, 5);
        gbc_lblForeName.gridx = 1;
        gbc_lblForeName.gridy = 2;
        panel.add(lblForeName, gbc_lblForeName);

        foreName = new JTextField();
        foreName.setFont(new Font("Dialog", Font.PLAIN, 16));
        foreName.setColumns(10);
        GridBagConstraints gbc_foreName = new GridBagConstraints();
        gbc_foreName.fill = GridBagConstraints.HORIZONTAL;
        gbc_foreName.insets = new Insets(0, 0, 5, 5);
        gbc_foreName.gridx = 2;
        gbc_foreName.gridy = 2;
        panel.add(foreName, gbc_foreName);

        JLabel lblSurname = new JLabel("Surname:");
        GridBagConstraints gbc_lblSurname = new GridBagConstraints();
        gbc_lblSurname.anchor = GridBagConstraints.WEST;
        gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
        gbc_lblSurname.gridx = 1;
        gbc_lblSurname.gridy = 3;
        panel.add(lblSurname, gbc_lblSurname);

        surName = new JTextField();
        surName.setFont(new Font("Dialog", Font.PLAIN, 16));
        surName.setColumns(10);
        GridBagConstraints gbc_surName = new GridBagConstraints();
        gbc_surName.fill = GridBagConstraints.HORIZONTAL;
        gbc_surName.insets = new Insets(0, 0, 5, 5);
        gbc_surName.gridx = 2;
        gbc_surName.gridy = 3;
        panel.add(surName, gbc_surName);

        JLabel lblDoB = new JLabel("Date Of Birth:");
        GridBagConstraints gbc_lblDoB = new GridBagConstraints();
        gbc_lblDoB.anchor = GridBagConstraints.WEST;
        gbc_lblDoB.insets = new Insets(0, 0, 5, 5);
        gbc_lblDoB.gridx = 1;
        gbc_lblDoB.gridy = 4;
        panel.add(lblDoB, gbc_lblDoB);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        Calendar daycal = new GregorianCalendar(currentYear, currentMonth, 1);
        int daysInMonth = daycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DATE);

        DatePicker datePicker = new DatePicker();
        datePicker.getComponentDateTextField().setFont(new Font("Dialog", Font.PLAIN, 16));
        GridBagConstraints gbc_datePicker = new GridBagConstraints();
        gbc_datePicker.insets = new Insets(0, 0, 5, 5);
        gbc_datePicker.fill = GridBagConstraints.HORIZONTAL;
        gbc_datePicker.gridx = 2;
        gbc_datePicker.gridy = 4;
        panel.add(datePicker, gbc_datePicker);

        JLabel lblphoneNo = new JLabel("Phone No:");
        GridBagConstraints gbc_lblphoneNo = new GridBagConstraints();
        gbc_lblphoneNo.anchor = GridBagConstraints.WEST;
        gbc_lblphoneNo.insets = new Insets(0, 0, 5, 5);
        gbc_lblphoneNo.gridx = 1;
        gbc_lblphoneNo.gridy = 5;
        panel.add(lblphoneNo, gbc_lblphoneNo);

        phoneNo = new JTextField();
        phoneNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        ((AbstractDocument) phoneNo.getDocument()).setDocumentFilter(new IntegerFlt());
        phoneNo.setColumns(13);
        GridBagConstraints gbc_phoneNo = new GridBagConstraints();
        gbc_phoneNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_phoneNo.insets = new Insets(0, 0, 5, 5);
        gbc_phoneNo.gridx = 2;
        gbc_phoneNo.gridy = 5;
        panel.add(phoneNo, gbc_phoneNo);

        JLabel lblHouseNo = new JLabel("House No:");
        GridBagConstraints gbc_lblHouseNo = new GridBagConstraints();
        gbc_lblHouseNo.anchor = GridBagConstraints.WEST;
        gbc_lblHouseNo.insets = new Insets(0, 0, 5, 5);
        gbc_lblHouseNo.gridx = 1;
        gbc_lblHouseNo.gridy = 6;
        panel.add(lblHouseNo, gbc_lblHouseNo);

        houseNo = new JTextField();
        houseNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        ((AbstractDocument) houseNo.getDocument()).setDocumentFilter(new IntegerFlt());
        houseNo.setColumns(5);
        GridBagConstraints gbc_houseNo = new GridBagConstraints();
        gbc_houseNo.fill = GridBagConstraints.HORIZONTAL;
        gbc_houseNo.insets = new Insets(0, 0, 5, 5);
        gbc_houseNo.gridx = 2;
        gbc_houseNo.gridy = 6;
        panel.add(houseNo, gbc_houseNo);

        JLabel lblStreet = new JLabel("Street:");
        GridBagConstraints gbc_lblStreet = new GridBagConstraints();
        gbc_lblStreet.anchor = GridBagConstraints.WEST;
        gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
        gbc_lblStreet.gridx = 1;
        gbc_lblStreet.gridy = 7;
        panel.add(lblStreet, gbc_lblStreet);

        street = new JTextField();
        street.setFont(new Font("Dialog", Font.PLAIN, 16));
        street.setColumns(20);
        GridBagConstraints gbc_street = new GridBagConstraints();
        gbc_street.fill = GridBagConstraints.HORIZONTAL;
        gbc_street.insets = new Insets(0, 0, 5, 5);
        gbc_street.gridx = 2;
        gbc_street.gridy = 7;
        panel.add(street, gbc_street);

        JLabel lblDistrict = new JLabel("District:");
        GridBagConstraints gbc_lblDistrict = new GridBagConstraints();
        gbc_lblDistrict.anchor = GridBagConstraints.WEST;
        gbc_lblDistrict.insets = new Insets(0, 0, 5, 5);
        gbc_lblDistrict.gridx = 1;
        gbc_lblDistrict.gridy = 8;
        panel.add(lblDistrict, gbc_lblDistrict);

        district = new JTextField();
        district.setFont(new Font("Dialog", Font.PLAIN, 16));
        district.setColumns(20);
        GridBagConstraints gbc_district = new GridBagConstraints();
        gbc_district.fill = GridBagConstraints.HORIZONTAL;
        gbc_district.insets = new Insets(0, 0, 5, 5);
        gbc_district.gridx = 2;
        gbc_district.gridy = 8;
        panel.add(district, gbc_district);

        JLabel lblCity = new JLabel("City:");
        GridBagConstraints gbc_lblCity = new GridBagConstraints();
        gbc_lblCity.anchor = GridBagConstraints.WEST;
        gbc_lblCity.insets = new Insets(0, 0, 5, 5);
        gbc_lblCity.gridx = 1;
        gbc_lblCity.gridy = 9;
        panel.add(lblCity, gbc_lblCity);

        city = new JTextField();
        city.setFont(new Font("Dialog", Font.PLAIN, 16));
        city.setColumns(20);
        GridBagConstraints gbc_city = new GridBagConstraints();
        gbc_city.fill = GridBagConstraints.HORIZONTAL;
        gbc_city.insets = new Insets(0, 0, 5, 5);
        gbc_city.gridx = 2;
        gbc_city.gridy = 9;
        panel.add(city, gbc_city);

        JLabel lblPostcode = new JLabel("Postcode:");
        GridBagConstraints gbc_lblPostcode = new GridBagConstraints();
        gbc_lblPostcode.anchor = GridBagConstraints.WEST;
        gbc_lblPostcode.insets = new Insets(0, 0, 5, 5);
        gbc_lblPostcode.gridx = 1;
        gbc_lblPostcode.gridy = 10;
        panel.add(lblPostcode, gbc_lblPostcode);

        postcode = new JTextField();
        postcode.setFont(new Font("Dialog", Font.PLAIN, 16));
        postcode.setColumns(20);
        GridBagConstraints gbc_postcode = new GridBagConstraints();
        gbc_postcode.fill = GridBagConstraints.HORIZONTAL;
        gbc_postcode.insets = new Insets(0, 0, 5, 5);
        gbc_postcode.gridx = 2;
        gbc_postcode.gridy = 10;
        panel.add(postcode, gbc_postcode);

        JLabel lblHealthPlan = new JLabel("Healthcare Plan:");
        GridBagConstraints gbc_lblHealthPlan = new GridBagConstraints();
        gbc_lblHealthPlan.anchor = GridBagConstraints.WEST;
        gbc_lblHealthPlan.insets = new Insets(0, 0, 5, 5);
        gbc_lblHealthPlan.gridx = 1;
        gbc_lblHealthPlan.gridy = 11;
        panel.add(lblHealthPlan, gbc_lblHealthPlan);

        JComboBox healthcarePlan = new JComboBox();
        GridBagConstraints gbc_healthcarePlan = new GridBagConstraints();
        gbc_healthcarePlan.insets = new Insets(0, 0, 5, 5);
        gbc_healthcarePlan.fill = GridBagConstraints.HORIZONTAL;
        gbc_healthcarePlan.gridx = 2;
        gbc_healthcarePlan.gridy = 11;
        panel.add(healthcarePlan, gbc_healthcarePlan);

        JCheckBox chckbxUpdateHealthcarePlan = new JCheckBox("Update Healthcare Plan");
        chckbxUpdateHealthcarePlan.setForeground(new Color(128, 128, 128));
        GridBagConstraints gbc_chckbxUpdateHealthcarePlan = new GridBagConstraints();
        gbc_chckbxUpdateHealthcarePlan.insets = new Insets(0, 0, 0, 5);
        gbc_chckbxUpdateHealthcarePlan.gridx = 2;
        gbc_chckbxUpdateHealthcarePlan.gridy = 12;
        panel.add(chckbxUpdateHealthcarePlan, gbc_chckbxUpdateHealthcarePlan);

        JPanel confirmPanel = new JPanel();
        contentPane.add(confirmPanel, BorderLayout.SOUTH);

        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Component[] components = panel.getComponents();
                boolean completed = true;
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

        confirmPanel.add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        confirmPanel.add(cancelButton);
        
        setLocationRelativeTo(null);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EditPatient frame = new EditPatient();
                    frame.setModal(true);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private enum title {MR, MRS, MS, MISS}

}