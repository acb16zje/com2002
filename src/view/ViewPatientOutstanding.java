package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.RecordQueries;
import model.Record;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

class ViewPatientOutstanding extends JDialog {

    /**
     * Create the dialog.
     */
    public ViewPatientOutstanding(int patientID) {
        setTitle("Patient Outstandings");
        setResizable(false);
        setModal(true);
        setBounds(100, 100, 500, 600);
        getContentPane().setLayout(new BorderLayout());
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblPatientID = new JLabel("Patient ID: "+patientID);
        lblPatientID.setBounds(40, 35, 75, 20);
        contentPanel.add(lblPatientID);
        
        
            JLabel lblTotalOwed = new JLabel("Total Owed:");
            lblTotalOwed.setBounds(210, 478, 78, 14);
            contentPanel.add(lblTotalOwed);
        
        
            JTextField textField = new JTextField();
            textField.setBounds(298, 475, 186, 20);
            textField.setEditable(false);
            contentPanel.add(textField);
            textField.setColumns(10);
        
        
        JLabel patientId = new JLabel(String.valueOf(patientID));
        patientId.setBounds(0, 0, 0, 0);
        contentPanel.add(patientId);
        
            Box box = new Box(BoxLayout.Y_AXIS);
            JPanel recordOwedPanel = new JPanel();
            recordOwedPanel.setBounds(10, 81, 474, 386);
            recordOwedPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
            contentPanel.add(recordOwedPanel);
            recordOwedPanel.setLayout(new BoxLayout(recordOwedPanel, BoxLayout.X_AXIS));

            JScrollPane scrollPane = new JScrollPane(box);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            recordOwedPanel.add(scrollPane);
            
            RecordQueries.generateOutstandingList(patientID,box,textField);   
        
        
            JButton btnUpdateCostOwed = new JButton("Update Cost Owed");
            btnUpdateCostOwed.addActionListener(e-> {
            	Component[] components = box.getComponents();
	            for (Component comp : components) {
	            	if (comp instanceof Container) {
	            		Component[] treatment = ((Container) comp).getComponents();
	            		if (((JCheckBox)treatment[3]).isSelected()) {
	            			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
	            			System.out.println(((JLabel)treatment[0]).getText().substring(6, 16));
	            			System.out.println(((JLabel)treatment[0]).getText().substring(17, 25));
	            			System.out.println(((JLabel)treatment[1]).getText().substring(11));
	            			try {
	            				java.sql.Date tempDate = new java.sql.Date(timeFormat.parse(((JLabel)treatment[0]).getText().substring(6, 16)).getTime());
								Time tempTime = Time.valueOf(((JLabel)treatment[0]).getText().substring(17, 25));
								String treatmentGiven = ((JLabel)treatment[1]).getText().substring(11);
								Record tempRecord = RecordQueries.getRecordByName(treatmentGiven,tempDate,tempTime);
								tempRecord.setAmountOwed(0);
								RecordQueries.updateRecord(RecordQueries.getRecordByName(treatmentGiven,tempDate,tempTime), tempRecord);  
	            			} catch (ParseException e1) {
								e1.printStackTrace();
	            			}
	            		}
	                }
	            	box.remove(comp);
	            }   
	            scrollPane.repaint();
	            RecordQueries.generateOutstandingList(patientID,box,textField); 
            });
            btnUpdateCostOwed.setBounds(298, 506, 186, 23);
            contentPanel.add(btnUpdateCostOwed);
        
        
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            
            JButton okButton = new JButton("OK");
            okButton.addActionListener(e -> { 
	            dispose();
            });
            okButton.setActionCommand("OK");
            buttonPane.add(okButton);
            getRootPane().setDefaultButton(okButton);
        
        
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(arg0 -> dispose());
            cancelButton.setActionCommand("Cancel");
            buttonPane.add(cancelButton);        
    }
}
