package view;

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

public class PartnerHome extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Create the frame.
     */
    public PartnerHome(String partner) {
        setTitle("Sheffield Dentist Management Program");
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar currentCalendar = Calendar.getInstance();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{774, 0};
        gbl_contentPane.rowHeights = new int[]{121, 310, 54, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

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

        JLabel lblWeek = new JLabel(timeFormat.format(currentCalendar.getTime()));
        lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 18));
        GridBagConstraints gbc_lblWeek = new GridBagConstraints();
        gbc_lblWeek.anchor = GridBagConstraints.NORTH;
        gbc_lblWeek.insets = new Insets(0, 0, 0, 5);
        gbc_lblWeek.gridx = 2;
        gbc_lblWeek.gridy = 1;
        tableControlPanel.add(lblWeek, gbc_lblWeek);

        JLabel lblPartner = new JLabel(partner);
        lblPartner.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_lblPartner = new GridBagConstraints();
        gbc_lblPartner.anchor = GridBagConstraints.NORTH;
        gbc_lblPartner.insets = new Insets(0, 0, 5, 5);
        gbc_lblPartner.gridx = 2;
        gbc_lblPartner.gridy = 0;
        tableControlPanel.add(lblPartner, gbc_lblPartner);

        JButton lastWeekButton = new JButton("Yesterday");
        lastWeekButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lastWeekButton.addActionListener(e -> {
            currentCalendar.add(Calendar.DAY_OF_YEAR, -1);
            table.setModel(
                new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                    timeFormat.format(currentCalendar.getTime())}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
            lblWeek.setText(timeFormat.format(currentCalendar.getTime()));
        });
        GridBagConstraints gbc_lastWeekButton = new GridBagConstraints();
        gbc_lastWeekButton.fill = GridBagConstraints.BOTH;
        gbc_lastWeekButton.insets = new Insets(0, 0, 0, 5);
        gbc_lastWeekButton.gridx = 0;
        gbc_lastWeekButton.gridy = 1;
        tableControlPanel.add(lastWeekButton, gbc_lastWeekButton);

        JButton nextWeekButton = new JButton("Tomorrow");
        nextWeekButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nextWeekButton.addActionListener(e -> {
            currentCalendar.add(Calendar.DAY_OF_YEAR, 1);
            table.setModel(
                new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                    timeFormat.format(currentCalendar.getTime())}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
            lblWeek.setText(timeFormat.format(currentCalendar.getTime()));
        });

        GridBagConstraints gbc_nextWeekButton = new GridBagConstraints();
        gbc_nextWeekButton.fill = GridBagConstraints.BOTH;
        gbc_nextWeekButton.gridx = 4;
        gbc_nextWeekButton.gridy = 1;
        tableControlPanel.add(nextWeekButton, gbc_nextWeekButton);

        JScrollPane scrollPane = new JScrollPane();
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        contentPane.add(scrollPane, gbc_scrollPane);

        table = new JTable();
        table.setCellSelectionEnabled(true);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.setModel(new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                           timeFormat.format(currentCalendar.getTime())}) {
                           @Override
                           public boolean isCellEditable(int row, int column) {
                               return false;
                           }
                       }
        );
        scrollPane.setViewportView(table);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        contentPane.add(panel, gbc_panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JButton btnNewButton = new JButton("Edit Appointment");
        btnNewButton.addActionListener(e -> {
            AppointmentEditorPartner dialog = new AppointmentEditorPartner();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(btnNewButton);

    }
}
