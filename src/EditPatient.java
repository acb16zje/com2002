import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(30, 50, 36, 15);
        panel.add(titleLabel);

        JComboBox comboTitle = new JComboBox(title.values());
        comboTitle.setBounds(154, 45, 62, 24);
        panel.add(comboTitle);

        JLabel forenameLabel = new JLabel("Forename:");
        forenameLabel.setBounds(30, 90, 76, 15);
        panel.add(forenameLabel);

        foreName = new JTextField();
        foreName.setBounds(154, 86, 255, 23);
        foreName.setFont(new Font("Dialog", Font.PLAIN, 16));
        foreName.setColumns(10);
        panel.add(foreName);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(30, 130, 68, 15);
        panel.add(surnameLabel);

        surName = new JTextField();
        surName.setBounds(154, 126, 255, 23);
        surName.setFont(new Font("Dialog", Font.PLAIN, 16));
        surName.setColumns(10);
        panel.add(surName);

        JLabel dobLabel = new JLabel("Date Of Birth:");
        dobLabel.setBounds(30, 170, 97, 15);
        panel.add(dobLabel);

        JComboBox comboDay = new JComboBox();
        comboDay.setBounds(154, 165, 50, 24);
        panel.add(comboDay);
        for (int i = 1; i <= 31; i++) {
            comboDay.addItem(i);
        }

        JComboBox comboMonth = new JComboBox();
        comboMonth.setBounds(216, 165, 105, 24);
        panel.add(comboMonth);
        String[] months = new DateFormatSymbols().getMonths();
        for (int i = 0; i < 12; i++) {
            comboMonth.addItem(months[i]);
        }

        JComboBox comboYear = new JComboBox();
        comboYear.setBounds(333, 165, 76, 24);
        panel.add(comboYear);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1930; i <= currentYear; i++) {
            comboYear.addItem(i);
        }
        comboYear.setSelectedIndex(comboYear.getItemCount() - 1);

        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoLabel.setBounds(30, 210, 73, 15);
        panel.add(phoneNoLabel);

        phoneNo = new JTextField();
        phoneNo.setBounds(154, 206, 255, 23);
        phoneNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        ((AbstractDocument) phoneNo.getDocument()).setDocumentFilter(new IntegerFlt());
        phoneNo.setColumns(13);
        panel.add(phoneNo);

        JLabel houseNoLabel = new JLabel("House No:");
        houseNoLabel.setBounds(30, 250, 73, 15);
        panel.add(houseNoLabel);

        houseNo = new JTextField();
        houseNo.setBounds(154, 246, 255, 23);
        houseNo.setFont(new Font("Dialog", Font.PLAIN, 16));
        ((AbstractDocument) houseNo.getDocument()).setDocumentFilter(new IntegerFlt());
        houseNo.setColumns(5);
        panel.add(houseNo);

        JLabel streetLabel = new JLabel("Street:");
        streetLabel.setBounds(30, 290, 50, 15);
        panel.add(streetLabel);

        street = new JTextField();
        street.setBounds(154, 286, 255, 23);
        street.setFont(new Font("Dialog", Font.PLAIN, 16));
        street.setColumns(20);
        panel.add(street);

        JLabel districtLabel = new JLabel("District:");
        districtLabel.setBounds(30, 330, 56, 15);
        panel.add(districtLabel);

        district = new JTextField();
        district.setBounds(154, 326, 255, 23);
        district.setFont(new Font("Dialog", Font.PLAIN, 16));
        district.setColumns(20);
        panel.add(district);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(30, 370, 32, 15);
        panel.add(cityLabel);

        city = new JTextField();
        city.setBounds(154, 366, 255, 23);
        city.setFont(new Font("Dialog", Font.PLAIN, 16));
        city.setColumns(20);
        panel.add(city);

        JLabel postcodeLabel = new JLabel("Postcode:");
        postcodeLabel.setBounds(30, 410, 71, 15);
        panel.add(postcodeLabel);

        postcode = new JTextField();
        postcode.setBounds(154, 406, 255, 23);
        postcode.setFont(new Font("Dialog", Font.PLAIN, 16));
        postcode.setColumns(20);
        panel.add(postcode);

        JLabel planLabel = new JLabel("Healthcare Plan:");
        planLabel.setBounds(30, 450, 118, 15);
        panel.add(planLabel);

        JComboBox healthcarePlan = new JComboBox();
        healthcarePlan.setBounds(154, 445, 255, 24);
        panel.add(healthcarePlan);

        JCheckBox updatePlanCheckBox = new JCheckBox("Update Healthcare Plan");
        updatePlanCheckBox.setBounds(154, 488, 194, 23);
        updatePlanCheckBox.setForeground(new Color(128, 128, 128));
        panel.add(updatePlanCheckBox);

        JPanel confirmPanel = new JPanel();
        contentPane.add(confirmPanel, BorderLayout.SOUTH);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean completed = true;

                // Check if birth date is valid
                String inputDay = comboDay.getSelectedItem().toString();
                String inputMonth = String.valueOf(comboMonth.getSelectedIndex() + 1);
                String inputYear = comboYear.getSelectedItem().toString();
                String inputDate = inputDay + "-" + inputMonth + "-" + inputYear;

                if (isValidDate(inputDate)) {
                    JOptionPane.showMessageDialog(null, inputDate);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid date");
                }

                // Check if all field are filled in
                Component[] components = panel.getComponents();
                for (Component comp : components) {
                    // Cast comp to JComboBox / JTextField to get the values
                    if (comp instanceof JTextField) {
                        if (((JTextField) comp).getText().isEmpty()) {
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

        setTitle("Patient Editor");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 451, 609);
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

    private boolean isValidDate(String date) {
        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        try {
            //parse the inDate parameter
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }

        return true;
    }

    private enum title {MR, MRS, MS, MISS}

}
