package view;

import controller.PartnerListener;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import util.WeekGenerator;

public class PartnerInterface extends JFrame {

    /**
     * Create the frame.
     */
    public PartnerInterface(String partner) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar currentCalendar = Calendar.getInstance();

        // Main content panel
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{774, 0};
        gbl_contentPane.rowHeights = new int[]{121, 310, 54, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        // Panel for Yesterday and Tomorrow button
        JPanel tableControlPanel = new JPanel();
        GridBagConstraints gbc_tableControlPanel = new GridBagConstraints();
        gbc_tableControlPanel.fill = GridBagConstraints.BOTH;
        gbc_tableControlPanel.insets = new Insets(0, 0, 5, 0);
        gbc_tableControlPanel.gridx = 0;
        gbc_tableControlPanel.gridy = 0;
        contentPane.add(tableControlPanel, gbc_tableControlPanel);
        GridBagLayout gbl_tableControlPanel = new GridBagLayout();
        gbl_tableControlPanel.columnWidths = new int[]{140, 99, 274, 101, 140, 0};
        gbl_tableControlPanel.rowHeights = new int[]{20, 76, 0};
        gbl_tableControlPanel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0,
            Double.MIN_VALUE};
        gbl_tableControlPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        tableControlPanel.setLayout(gbl_tableControlPanel);

        // Label for the current day
        JLabel dayLabel = new JLabel(
            new SimpleDateFormat("EEEE").format(currentCalendar.getTime()) + " " + timeFormat
                .format(currentCalendar.getTime()));
        dayLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GridBagConstraints gbc_dayLabel = new GridBagConstraints();
        gbc_dayLabel.anchor = GridBagConstraints.NORTH;
        gbc_dayLabel.insets = new Insets(0, 0, 0, 5);
        gbc_dayLabel.gridx = 2;
        gbc_dayLabel.gridy = 1;
        tableControlPanel.add(dayLabel, gbc_dayLabel);

        // Label for dentist or hygienist
        JLabel partnerLabel = new JLabel(partner);
        partnerLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        GridBagConstraints gbc_partnerLabel = new GridBagConstraints();
        gbc_partnerLabel.anchor = GridBagConstraints.NORTH;
        gbc_partnerLabel.insets = new Insets(0, 0, 5, 5);
        gbc_partnerLabel.gridx = 2;
        gbc_partnerLabel.gridy = 0;
        tableControlPanel.add(partnerLabel, gbc_partnerLabel);

        // Scroll pane for the timetable
        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        contentPane.add(scrollPane, gbc_scrollPane);

        // A table of today appointments
        JTable timetable = new JTable();
        timetable.setCellSelectionEnabled(true);
        timetable.setFillsViewportHeight(true);
        timetable.setRowHeight(20);
        timetable
            .setModel(new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                          timeFormat.format(currentCalendar.getTime())}) {
                          @Override
                          public boolean isCellEditable(int row, int column) {
                              return false;
                          }
                      }
            );
        scrollPane.setViewportView(timetable);

        // Yesterday button
        JButton yesterdayButton = new JButton("Yesterday");
        yesterdayButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        yesterdayButton
            .addActionListener(new PartnerListener(-1, currentCalendar, timetable, dayLabel));
        GridBagConstraints gbc_yesterdayButton = new GridBagConstraints();
        gbc_yesterdayButton.fill = GridBagConstraints.BOTH;
        gbc_yesterdayButton.insets = new Insets(0, 0, 0, 5);
        gbc_yesterdayButton.gridx = 0;
        gbc_yesterdayButton.gridy = 1;
        tableControlPanel.add(yesterdayButton, gbc_yesterdayButton);

        // Tomorrow button
        JButton tomorrowButton = new JButton("Tomorrow");
        tomorrowButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tomorrowButton
            .addActionListener(new PartnerListener(1, currentCalendar, timetable, dayLabel));
        GridBagConstraints gbc_tomorrowButton = new GridBagConstraints();
        gbc_tomorrowButton.fill = GridBagConstraints.BOTH;
        gbc_tomorrowButton.gridx = 4;
        gbc_tomorrowButton.gridy = 1;
        tableControlPanel.add(tomorrowButton, gbc_tomorrowButton);

        // Bottom panel for Edit Appointment button
        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        contentPane.add(panel, gbc_panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JButton editAppointmentButton = new JButton("Edit Appointment");
        editAppointmentButton.addActionListener(e -> {
            AppointmentEditorPartner dialog = new AppointmentEditorPartner();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
        editAppointmentButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(editAppointmentButton);

        // Basic settings
        setTitle("Sheffield Dental Care");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        setLocationRelativeTo(null);
    }
}
