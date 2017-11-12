
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AbstractDocument;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

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
	private enum title {MR,MRS,MS};

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

	/**
	 * Create the frame.
	 */
	public EditPatient() {
		setTitle("Patient Editor");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTitle = new JLabel("Title:");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		panel.add(lblTitle, gbc_lblTitle);
		
		JComboBox Title = new JComboBox(title.values());
		GridBagConstraints gbc_Title = new GridBagConstraints();
		gbc_Title.fill = GridBagConstraints.HORIZONTAL;
		gbc_Title.insets = new Insets(0, 0, 5, 5);
		gbc_Title.gridx = 2;
		gbc_Title.gridy = 0;
		panel.add(Title, gbc_Title);
		
		JLabel lblForeName = new JLabel("Forename:");
		GridBagConstraints gbc_lblForeName = new GridBagConstraints();
		gbc_lblForeName.anchor = GridBagConstraints.EAST;
		gbc_lblForeName.insets = new Insets(0, 0, 5, 5);
		gbc_lblForeName.gridx = 1;
		gbc_lblForeName.gridy = 1;
		panel.add(lblForeName, gbc_lblForeName);
		
		foreName = new JTextField();
		foreName.setColumns(10);
		GridBagConstraints gbc_foreName = new GridBagConstraints();
		gbc_foreName.fill = GridBagConstraints.HORIZONTAL;
		gbc_foreName.insets = new Insets(0, 0, 5, 5);
		gbc_foreName.gridx = 2;
		gbc_foreName.gridy = 1;
		panel.add(foreName, gbc_foreName);
		
		JLabel lblSurname = new JLabel("Surname:");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 3;
		gbc_lblSurname.gridy = 1;
		panel.add(lblSurname, gbc_lblSurname);
		
		surName = new JTextField();
		surName.setColumns(10);
		GridBagConstraints gbc_surName = new GridBagConstraints();
		gbc_surName.fill = GridBagConstraints.HORIZONTAL;
		gbc_surName.insets = new Insets(0, 0, 5, 5);
		gbc_surName.gridx = 4;
		gbc_surName.gridy = 1;
		panel.add(surName, gbc_surName);
		
		JLabel lblDoB = new JLabel("Date Of Birth:");
		GridBagConstraints gbc_lblDoB = new GridBagConstraints();
		gbc_lblDoB.anchor = GridBagConstraints.WEST;
		gbc_lblDoB.insets = new Insets(0, 0, 5, 5);
		gbc_lblDoB.gridx = 1;
		gbc_lblDoB.gridy = 3;
		panel.add(lblDoB, gbc_lblDoB);
		
		//reminder that month works as 0-11(JAN,FEB,...,DEC)
		JSpinner year = new JSpinner();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		year.setModel(new SpinnerNumberModel(currentYear, 1920, currentYear, 1));
		GridBagConstraints gbc_year = new GridBagConstraints();
		gbc_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_year.insets = new Insets(0, 0, 5, 5);
		gbc_year.gridx = 4;
		gbc_year.gridy = 3;
		panel.add(year, gbc_year);
		
		JSpinner month = new JSpinner();
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		month.setModel(new SpinnerNumberModel(currentMonth+1,1,12,1));
		GridBagConstraints gbc_month = new GridBagConstraints();
		gbc_month.fill = GridBagConstraints.HORIZONTAL;
		gbc_month.insets = new Insets(0, 0, 5, 5);
		gbc_month.gridx = 3;
		gbc_month.gridy = 3;
		panel.add(month, gbc_month);
		
		JSpinner day = new JSpinner();
		Calendar daycal = new GregorianCalendar(currentYear, currentMonth, 1);
		int daysInMonth = daycal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int currentDay = Calendar.getInstance().get(Calendar.DATE);
		day.setModel(new SpinnerNumberModel(currentDay,1,daysInMonth,1));
		GridBagConstraints gbc_day = new GridBagConstraints();
		gbc_day.fill = GridBagConstraints.HORIZONTAL;
		gbc_day.insets = new Insets(0, 0, 5, 5);
		gbc_day.gridx = 2;
		gbc_day.gridy = 3;
		panel.add(day, gbc_day);
		
		//Listeners for dates
		month.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int newMonth = (int) month.getValue();
				Calendar cal = new GregorianCalendar(currentYear, newMonth-1, 1);
				int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				day.setModel(new SpinnerNumberModel(currentDay,1,daysInMonth,1));
			}
		});
		year.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int newYear = (int) year.getValue();
				Calendar cal = new GregorianCalendar(newYear, (int)month.getValue()-1, 1);
				int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				day.setModel(new SpinnerNumberModel(currentDay,1,daysInMonth,1));
			}
		});
		
		JLabel lblphoneNo = new JLabel("Phone No:");
		GridBagConstraints gbc_lblphoneNo = new GridBagConstraints();
		gbc_lblphoneNo.anchor = GridBagConstraints.EAST;
		gbc_lblphoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblphoneNo.gridx = 1;
		gbc_lblphoneNo.gridy = 5;
		panel.add(lblphoneNo, gbc_lblphoneNo);
		
		phoneNo = new JTextField();
		((AbstractDocument)phoneNo.getDocument()).setDocumentFilter(new IntegerFlt()); 
		phoneNo.setColumns(13);
		GridBagConstraints gbc_phoneNo = new GridBagConstraints();
		gbc_phoneNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNo.gridx = 2;
		gbc_phoneNo.gridy = 5;
		panel.add(phoneNo, gbc_phoneNo);
		
		JLabel lblHealthPlan = new JLabel("Healthcare Plan:");
		GridBagConstraints gbc_lblHealthPlan = new GridBagConstraints();
		gbc_lblHealthPlan.anchor = GridBagConstraints.EAST;
		gbc_lblHealthPlan.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealthPlan.gridx = 3;
		gbc_lblHealthPlan.gridy = 5;
		panel.add(lblHealthPlan, gbc_lblHealthPlan);
		
		JComboBox healthcarePlan = new JComboBox();
		GridBagConstraints gbc_healthcarePlan = new GridBagConstraints();
		gbc_healthcarePlan.insets = new Insets(0, 0, 5, 5);
		gbc_healthcarePlan.fill = GridBagConstraints.HORIZONTAL;
		gbc_healthcarePlan.gridx = 4;
		gbc_healthcarePlan.gridy = 5;
		panel.add(healthcarePlan, gbc_healthcarePlan);
		
		JCheckBox chckbxUpdateHealthcarePlan = new JCheckBox("Update Healthcare Plan");
		chckbxUpdateHealthcarePlan.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_chckbxUpdateHealthcarePlan = new GridBagConstraints();
		gbc_chckbxUpdateHealthcarePlan.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUpdateHealthcarePlan.gridx = 4;
		gbc_chckbxUpdateHealthcarePlan.gridy = 6;
		panel.add(chckbxUpdateHealthcarePlan, gbc_chckbxUpdateHealthcarePlan);
		
		JLabel lblHouseNo = new JLabel("House No:");
		GridBagConstraints gbc_lblHouseNo = new GridBagConstraints();
		gbc_lblHouseNo.anchor = GridBagConstraints.EAST;
		gbc_lblHouseNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblHouseNo.gridx = 1;
		gbc_lblHouseNo.gridy = 7;
		panel.add(lblHouseNo, gbc_lblHouseNo);
		
		houseNo = new JTextField();
		((AbstractDocument)houseNo.getDocument()).setDocumentFilter(new IntegerFlt()); 
		houseNo.setColumns(5);
		GridBagConstraints gbc_houseNo = new GridBagConstraints();
		gbc_houseNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_houseNo.insets = new Insets(0, 0, 5, 5);
		gbc_houseNo.gridx = 2;
		gbc_houseNo.gridy = 7;
		panel.add(houseNo, gbc_houseNo);
		
		JLabel lblStreet = new JLabel("Street:");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.anchor = GridBagConstraints.EAST;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 1;
		gbc_lblStreet.gridy = 8;
		panel.add(lblStreet, gbc_lblStreet);
		
		street = new JTextField();
		street.setColumns(20);
		GridBagConstraints gbc_street = new GridBagConstraints();
		gbc_street.fill = GridBagConstraints.HORIZONTAL;
		gbc_street.insets = new Insets(0, 0, 5, 5);
		gbc_street.gridx = 2;
		gbc_street.gridy = 8;
		panel.add(street, gbc_street);
		
		JLabel lblDistrict = new JLabel("District:");
		GridBagConstraints gbc_lblDistrict = new GridBagConstraints();
		gbc_lblDistrict.anchor = GridBagConstraints.EAST;
		gbc_lblDistrict.insets = new Insets(0, 0, 5, 5);
		gbc_lblDistrict.gridx = 1;
		gbc_lblDistrict.gridy = 9;
		panel.add(lblDistrict, gbc_lblDistrict);
		
		district = new JTextField();
		district.setColumns(20);
		GridBagConstraints gbc_district = new GridBagConstraints();
		gbc_district.fill = GridBagConstraints.HORIZONTAL;
		gbc_district.insets = new Insets(0, 0, 5, 5);
		gbc_district.gridx = 2;
		gbc_district.gridy = 9;
		panel.add(district, gbc_district);
		
		JLabel lblCity = new JLabel("City:");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 1;
		gbc_lblCity.gridy = 10;
		panel.add(lblCity, gbc_lblCity);
		
		city = new JTextField();
		city.setColumns(20);
		GridBagConstraints gbc_city = new GridBagConstraints();
		gbc_city.fill = GridBagConstraints.HORIZONTAL;
		gbc_city.insets = new Insets(0, 0, 5, 5);
		gbc_city.gridx = 2;
		gbc_city.gridy = 10;
		panel.add(city, gbc_city);
		
		JLabel lblPostcode = new JLabel("Postcode:");
		GridBagConstraints gbc_lblPostcode = new GridBagConstraints();
		gbc_lblPostcode.anchor = GridBagConstraints.EAST;
		gbc_lblPostcode.insets = new Insets(0, 0, 0, 5);
		gbc_lblPostcode.gridx = 1;
		gbc_lblPostcode.gridy = 11;
		panel.add(lblPostcode, gbc_lblPostcode);
		
		postcode = new JTextField();
		postcode.setColumns(20);
		GridBagConstraints gbc_postcode = new GridBagConstraints();
		gbc_postcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_postcode.insets = new Insets(0, 0, 0, 5);
		gbc_postcode.gridx = 2;
		gbc_postcode.gridy = 11;
		panel.add(postcode, gbc_postcode);
		
		JPanel confirmPanel = new JPanel();
		contentPane.add(confirmPanel, BorderLayout.SOUTH);
		
		JButton doneButton = new JButton("Done");
		
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            Component[] components = panel.getComponents();
	            boolean completed = true;
	            for (Component comp : components) {
	                // Cast comp to JComboBox / JTextField to get the values
	                if((comp instanceof JTextField)){
	                	if (((JTextField)comp).getText().equals("")) {
	                		JOptionPane.showMessageDialog(null,"Please Complete");
	                		completed = false;
	                		break;
	                	}
	                	else
	                		JOptionPane.showMessageDialog(null,((JTextField)comp).getText());
	                }
	            }
	            if (completed) {
	            	dispose();
	            }
			}
		});
		
	
		confirmPanel.add(doneButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		confirmPanel.add(cancelButton);
	}

}
