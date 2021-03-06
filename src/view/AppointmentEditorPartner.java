package view;

import static java.time.temporal.ChronoUnit.MINUTES;

import controller.PatientQueries;
import controller.RecordQueries;
import controller.SubscriptionQueries;
import controller.TreatmentQueries;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Objects;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import model.Appointment;
import model.Record;
import model.Subscription;

class AppointmentEditorPartner extends JDialog {

    /**
     * Create the dialog.
     */
    public AppointmentEditorPartner(String label, Appointment app) {
        // Main content panel
        getContentPane().setLayout(null);
        JPanel contentPanel = new JPanel();
        contentPanel.setBounds(0, 0, 476, 605);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel);
        contentPanel.setLayout(new BorderLayout(0, 0));

        // The info panel for displaying the appointment information
        JPanel infoPanel = new JPanel();
        contentPanel.add(infoPanel, BorderLayout.NORTH);
        GridBagLayout gbl_infoPanel = new GridBagLayout();
        gbl_infoPanel.columnWidths = new int[]{46, 115, 276, 47, 0};
        gbl_infoPanel.rowHeights = new int[]{43, 40, 40, 40, 40, 13, 0};
        gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        infoPanel.setLayout(gbl_infoPanel);

        // Label for patient ID
        JLabel idLabel = new JLabel("Patient ID:");
        GridBagConstraints gbc_idLabel = new GridBagConstraints();
        gbc_idLabel.anchor = GridBagConstraints.WEST;
        gbc_idLabel.insets = new Insets(0, 0, 5, 5);
        gbc_idLabel.gridx = 1;
        gbc_idLabel.gridy = 1;
        infoPanel.add(idLabel, gbc_idLabel);

        // Text field for displaying patient ID
        JTextField idTextField = new JTextField();
        idTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        idTextField.setEditable(false);
        GridBagConstraints gbc_idTextField = new GridBagConstraints();
        gbc_idTextField.insets = new Insets(0, 0, 5, 5);
        gbc_idTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_idTextField.gridx = 2;
        gbc_idTextField.gridy = 1;
        infoPanel.add(idTextField, gbc_idTextField);
        idTextField.setColumns(10);

        // Label for patient name
        JLabel nameLabel = new JLabel("Patient Name:");
        GridBagConstraints gbc_nameLabel = new GridBagConstraints();
        gbc_nameLabel.anchor = GridBagConstraints.WEST;
        gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nameLabel.gridx = 1;
        gbc_nameLabel.gridy = 2;
        infoPanel.add(nameLabel, gbc_nameLabel);

        // Text field for displaying patient name
        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        nameTextField.setEditable(false);
        GridBagConstraints gbc_nameTextField = new GridBagConstraints();
        gbc_nameTextField.insets = new Insets(0, 0, 5, 5);
        gbc_nameTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_nameTextField.gridx = 2;
        gbc_nameTextField.gridy = 2;
        infoPanel.add(nameTextField, gbc_nameTextField);
        nameTextField.setColumns(10);

        // Label for start time
        JLabel startTimeLabel = new JLabel("Start Time:");
        GridBagConstraints gbc_startTimeLabel = new GridBagConstraints();
        gbc_startTimeLabel.anchor = GridBagConstraints.WEST;
        gbc_startTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_startTimeLabel.gridx = 1;
        gbc_startTimeLabel.gridy = 3;
        infoPanel.add(startTimeLabel, gbc_startTimeLabel);

        // Text field for displaying start time
        JTextField startTimeTextField = new JTextField();
        startTimeTextField.setEditable(false);
        startTimeTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        GridBagConstraints gbc_startTimeTextField = new GridBagConstraints();
        gbc_startTimeTextField.insets = new Insets(0, 0, 5, 5);
        gbc_startTimeTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_startTimeTextField.gridx = 2;
        gbc_startTimeTextField.gridy = 3;
        infoPanel.add(startTimeTextField, gbc_startTimeTextField);
        startTimeTextField.setColumns(10);

        // Label for end time
        JLabel endTimeLabel = new JLabel("End Time:");
        GridBagConstraints gbc_endTimeLabel = new GridBagConstraints();
        gbc_endTimeLabel.anchor = GridBagConstraints.WEST;
        gbc_endTimeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_endTimeLabel.gridx = 1;
        gbc_endTimeLabel.gridy = 4;
        infoPanel.add(endTimeLabel, gbc_endTimeLabel);

        // Text field for displaying end time
        JTextField endTimeTextField = new JTextField();
        endTimeTextField.setEditable(false);
        endTimeTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
        GridBagConstraints gbc_endTimeTextField = new GridBagConstraints();
        gbc_endTimeTextField.insets = new Insets(0, 0, 5, 5);
        gbc_endTimeTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_endTimeTextField.gridx = 2;
        gbc_endTimeTextField.gridy = 4;
        infoPanel.add(endTimeTextField, gbc_endTimeTextField);
        endTimeTextField.setColumns(10);

        JPanel treatmentPanel = new JPanel();
        contentPanel.add(treatmentPanel, BorderLayout.CENTER);

        JLabel checkUpHygieneLabel = new JLabel();
        checkUpHygieneLabel.setBounds(50, 42, 115, 28);
        treatmentPanel.setLayout(null);
        checkUpHygieneLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        treatmentPanel.add(checkUpHygieneLabel);

        JSpinner checkUpHygieneSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        checkUpHygieneSpinner.setBounds(353, 41, 76, 28);
        checkUpHygieneSpinner.setFont(new Font("Dialog", Font.PLAIN, 20));
        treatmentPanel.add(checkUpHygieneSpinner);

        JLabel silverAmalgamLabel = new JLabel("Silver amalgam filling:");
        silverAmalgamLabel.setBounds(50, 116, 188, 19);
        silverAmalgamLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        treatmentPanel.add(silverAmalgamLabel);

        JSpinner silverAmalgamSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        silverAmalgamSpinner.setBounds(353, 111, 76, 28);
        silverAmalgamSpinner.setFont(new Font("Dialog", Font.PLAIN, 20));
        treatmentPanel.add(silverAmalgamSpinner);

        JLabel whiteCompositeLabel = new JLabel("White composite resin filling:");
        whiteCompositeLabel.setBounds(50, 186, 268, 19);
        whiteCompositeLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        treatmentPanel.add(whiteCompositeLabel);

        JSpinner whiteCompositeSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        whiteCompositeSpinner.setBounds(353, 181, 76, 28);
        whiteCompositeSpinner.setFont(new Font("Dialog", Font.PLAIN, 20));
        treatmentPanel.add(whiteCompositeSpinner);

        JLabel goldCrownLabel = new JLabel("Fitting gold crown:");
        goldCrownLabel.setBounds(50, 258, 166, 19);
        goldCrownLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        treatmentPanel.add(goldCrownLabel);

        JSpinner goldCrownSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        goldCrownSpinner.setBounds(353, 254, 76, 28);
        goldCrownSpinner.setFont(new Font("Dialog", Font.PLAIN, 20));
        treatmentPanel.add(goldCrownSpinner);

        // Panel for finalizing the appointment
        JPanel finalPanel = new JPanel();
        contentPanel.add(finalPanel, BorderLayout.SOUTH);
        finalPanel.setLayout(new BoxLayout(finalPanel, BoxLayout.X_AXIS));

        // Checkbox to mark the appointment as completed
        JCheckBox chckbxAppointmentCompleted = new JCheckBox("Appointment Completed");
        finalPanel.add(chckbxAppointmentCompleted);

        // Button panel for Finish and Cancel
        JPanel buttonPanel = new JPanel();
        finalPanel.add(buttonPanel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // Set value of JSpinner if the appointment is already completed
        if (RecordQueries.recordAlreadyExist(app)) {
            checkUpHygieneSpinner.setEnabled(false);
            silverAmalgamSpinner.setEnabled(false);
            whiteCompositeSpinner.setEnabled(false);
            goldCrownSpinner.setEnabled(false);
            chckbxAppointmentCompleted.setEnabled(false);
            chckbxAppointmentCompleted.setSelected(true);

            if (Objects.equals(label, "Dentist")) {
                // Get the record of the completed appointment of dentist
                if (MINUTES
                    .between(app.getStartTime().toLocalTime(), app.getEndTime().toLocalTime())
                    == 60) {
                    int silverAmalgamAmount = RecordQueries
                        .getQuantityOwedByName("Silver Amalgam Filling", app);
                    int whiteCompositeAmount = RecordQueries
                        .getQuantityOwedByName("White Composite Resin Filling", app);
                    int goldCrownAmount = RecordQueries
                        .getQuantityOwedByName("Gold Crown Fitting", app);

                    silverAmalgamSpinner.setValue(silverAmalgamAmount);
                    whiteCompositeSpinner.setValue(whiteCompositeAmount);
                    goldCrownSpinner.setValue(goldCrownAmount);
                } else {
                    int checkUpAmount = RecordQueries.getQuantityOwedByName("Check Up", app);
                    checkUpHygieneSpinner.setValue(checkUpAmount);
                }
            } else {
                // Get the record of the competed appointment of hygienist
                int hygieneAmount = RecordQueries.getQuantityOwedByName("Hygiene", app);
                checkUpHygieneSpinner.setValue(hygieneAmount);
            }
        }

        // Check if the dentist appointment is check up or treatment
        if (MINUTES.between(app.getStartTime().toLocalTime(), app.getEndTime().toLocalTime())
            == 60) {
            checkUpHygieneLabel.setVisible(false);
            checkUpHygieneSpinner.setVisible(false);
            checkUpHygieneSpinner.setEnabled(false);
        } else {
            silverAmalgamLabel.setVisible(false);
            silverAmalgamSpinner.setVisible(false);
            silverAmalgamSpinner.setEnabled(false);
            whiteCompositeLabel.setVisible(false);
            whiteCompositeSpinner.setVisible(false);
            whiteCompositeSpinner.setEnabled(false);
            goldCrownLabel.setVisible(false);
            goldCrownSpinner.setVisible(false);
            goldCrownSpinner.setEnabled(false);
        }

        // The Finish button
        JButton okButton = new JButton("Finish");
        okButton.setEnabled(false);
        okButton.addActionListener(e -> {
            // Check if there is a treatment recorded
            Component[] components = treatmentPanel.getComponents();
            int sumOfTreatment = 0;
            for (Component comp : components) {
                if (comp instanceof JSpinner) {
                    sumOfTreatment += (Integer) ((JSpinner) comp).getValue();
                }
            }

            if (sumOfTreatment == 0) {
                JOptionPane.showMessageDialog(null, "Please record a treatment");
            } else {
                Subscription patientPlan = SubscriptionQueries.getSubscription(app.getPatientID());

                if (Objects.equals(label, "Dentist")) {
                    if ((Integer) (checkUpHygieneSpinner.getValue()) > 0) {
                        if (patientPlan == null || patientPlan.getCheckUpLeft() == 0) {
                            RecordQueries.insertRecord(new Record(
                                "Check Up",
                                app.getStartTime(),
                                app.getDate(),
                                0,
                                (Integer) (checkUpHygieneSpinner.getValue()),
                                totalCost("Check Up", (Integer) (checkUpHygieneSpinner.getValue()))
                            ));
                        } else {
                            int prepaid =
                                patientPlan.getCheckUpLeft() - (Integer) (checkUpHygieneSpinner
                                    .getValue());

                            if (prepaid >= 0) {
                                RecordQueries.insertRecord(new Record(
                                    "Check Up",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (checkUpHygieneSpinner.getValue()),
                                    totalCost("Check Up", 0)
                                ));
                            } else {
                                RecordQueries.insertRecord(new Record(
                                    "Check Up",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (checkUpHygieneSpinner.getValue()),
                                    totalCost("Check Up", Math.abs(prepaid))
                                ));
                            }

                            if (prepaid <= 0) {
                                patientPlan.setCheckUpLeft(0);
                            } else {
                                patientPlan.setCheckUpLeft(prepaid);
                            }
                        }
                    }

                    if ((Integer) (silverAmalgamSpinner.getValue()) > 0) {
                        if (patientPlan == null || patientPlan.getRepairWorkLeft() == 0) {
                            RecordQueries.insertRecord(new Record(
                                "Silver Amalgam Filling",
                                app.getStartTime(),
                                app.getDate(),
                                0,
                                (Integer) (silverAmalgamSpinner.getValue()),
                                totalCost("Silver Amalgam Filling",
                                    (Integer) (silverAmalgamSpinner.getValue()))
                            ));
                        } else {
                            int prepaid =
                                patientPlan.getRepairWorkLeft() - (Integer) (silverAmalgamSpinner
                                    .getValue());

                            if (prepaid >= 0) {
                                RecordQueries.insertRecord(new Record(
                                    "Silver Amalgam Filling",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (silverAmalgamSpinner.getValue()),
                                    totalCost("Silver Amalgam Filling", 0)
                                ));
                            } else {
                                RecordQueries.insertRecord(new Record(
                                    "Silver Amalgam Filling",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (silverAmalgamSpinner.getValue()),
                                    totalCost("Silver Amalgam Filling", Math.abs(prepaid))
                                ));
                            }

                            if (prepaid <= 0) {
                                patientPlan.setRepairWorkLeft(0);
                            } else {
                                patientPlan.setRepairWorkLeft(prepaid);
                            }
                        }
                    }

                    if ((Integer) (whiteCompositeSpinner.getValue()) > 0) {
                        if (patientPlan == null || patientPlan.getRepairWorkLeft() == 0) {
                            RecordQueries.insertRecord(new Record(
                                "White Composite Resin Filling",
                                app.getStartTime(),
                                app.getDate(),
                                0,
                                (Integer) (whiteCompositeSpinner.getValue()),
                                totalCost("White Composite Resin Filling",
                                    (Integer) (whiteCompositeSpinner.getValue()))
                            ));
                        } else {
                            int prepaid =
                                patientPlan.getRepairWorkLeft() - (Integer) (whiteCompositeSpinner
                                    .getValue());

                            if (prepaid >= 0) {
                                RecordQueries.insertRecord(new Record(
                                    "White Composite Resin Filling",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (whiteCompositeSpinner.getValue()),
                                    totalCost("White Composite Resin Filling", 0)
                                ));
                            } else {
                                RecordQueries.insertRecord(new Record(
                                    "White Composite Resin Filling",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (whiteCompositeSpinner.getValue()),
                                    totalCost("White Composite Resin Filling", Math.abs(prepaid))
                                ));
                            }

                            if (prepaid <= 0) {
                                patientPlan.setRepairWorkLeft(0);
                            } else {
                                patientPlan.setRepairWorkLeft(prepaid);
                            }
                        }
                    }

                    if ((Integer) (goldCrownSpinner.getValue()) > 0) {
                        if (patientPlan == null || patientPlan.getRepairWorkLeft() == 0) {
                            RecordQueries.insertRecord(new Record(
                                "Gold Crown Fitting",
                                app.getStartTime(),
                                app.getDate(),
                                0,
                                (Integer) (goldCrownSpinner.getValue()),
                                totalCost("Gold Crown Fitting",
                                    (Integer) (goldCrownSpinner.getValue()))
                            ));
                        } else {
                            int prepaid =
                                patientPlan.getRepairWorkLeft() - (Integer) (goldCrownSpinner
                                    .getValue());

                            if (prepaid >= 0) {
                                RecordQueries.insertRecord(new Record(
                                    "Gold Crown Fitting",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (goldCrownSpinner.getValue()),
                                    totalCost("Gold Crown Fitting", 0)
                                ));
                            } else {
                                RecordQueries.insertRecord(new Record(
                                    "Gold Crown Fitting",
                                    app.getStartTime(),
                                    app.getDate(),
                                    0,
                                    (Integer) (goldCrownSpinner.getValue()),
                                    totalCost("Gold Crown Fitting", Math.abs(prepaid))
                                ));
                            }

                            if (prepaid <= 0) {
                                patientPlan.setRepairWorkLeft(0);
                            } else {
                                patientPlan.setRepairWorkLeft(prepaid);
                            }
                        }
                    }

                    // Update the patient plan, deducting the prepaid amount
                    SubscriptionQueries.updateSubscription(patientPlan);
                } else {
                    if ((Integer) (checkUpHygieneSpinner.getValue()) > 0) {
                        if (patientPlan == null || patientPlan.getHygieneVisitLeft() == 0) {
                            RecordQueries.insertRecord(new Record(
                                "Hygiene",
                                app.getStartTime(),
                                app.getDate(),
                                1,
                                (Integer) (checkUpHygieneSpinner.getValue()),
                                totalCost("Hygiene", (Integer) (checkUpHygieneSpinner.getValue()))
                            ));
                        } else {
                            int prepaid =
                                patientPlan.getHygieneVisitLeft() - (Integer) (checkUpHygieneSpinner
                                    .getValue());

                            if (prepaid >= 0) {
                                RecordQueries.insertRecord(new Record(
                                    "Hygiene",
                                    app.getStartTime(),
                                    app.getDate(),
                                    1,
                                    (Integer) (checkUpHygieneSpinner.getValue()),
                                    totalCost("Hygiene", 0)
                                ));
                            } else {
                                RecordQueries.insertRecord(new Record(
                                    "Hygiene",
                                    app.getStartTime(),
                                    app.getDate(),
                                    1,
                                    (Integer) (checkUpHygieneSpinner.getValue()),
                                    totalCost("Hygiene", Math.abs(prepaid))
                                ));
                            }

                            if (prepaid <= 0) {
                                patientPlan.setHygieneVisitLeft(0);
                            } else {
                                patientPlan.setHygieneVisitLeft(prepaid);
                            }
                        }

                        SubscriptionQueries.updateSubscription(patientPlan);
                    }
                }

                // Close the dialog after all operations
                dispose();
            }
        });
        buttonPanel.add(okButton);
        okButton.setActionCommand("OK");
        getRootPane().setDefaultButton(okButton);

        // The Cancel button
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(e -> dispose());

        // Set all the details
        idTextField.setText(String.valueOf(app.getPatientID()));
        nameTextField.setText(PatientQueries.getNameByID(app.getPatientID()));
        startTimeTextField.setText(String.valueOf(app.getStartTime()));
        endTimeTextField.setText(String.valueOf(app.getEndTime()));

        // Checkbox listener
        chckbxAppointmentCompleted.addActionListener(e -> {
            if (chckbxAppointmentCompleted.isSelected()) {
                okButton.setEnabled(true);
            } else {
                okButton.setEnabled(false);
            }
        });

        // Dentist and Hygienist variation
        if (Objects.equals(label, "Dentist")) {
            checkUpHygieneLabel.setText("Check-up");
        } else {
            checkUpHygieneLabel.setText("Hygiene");
            silverAmalgamLabel.setEnabled(false);
            silverAmalgamLabel.setVisible(false);
            silverAmalgamSpinner.setEnabled(false);
            silverAmalgamSpinner.setVisible(false);
            whiteCompositeLabel.setEnabled(false);
            whiteCompositeLabel.setVisible(false);
            whiteCompositeSpinner.setEnabled(false);
            whiteCompositeSpinner.setVisible(false);
            goldCrownLabel.setEnabled(false);
            goldCrownLabel.setVisible(false);
            goldCrownSpinner.setEnabled(false);
            goldCrownSpinner.setVisible(false);
        }

        // Basic settings
        setResizable(false);
        setTitle("Edit Appointment");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 478, 632);
        setModal(true);
    }

    private int totalCost(String treatmentName, int amount) {
        return TreatmentQueries.getCost(treatmentName) * amount;
    }
}
