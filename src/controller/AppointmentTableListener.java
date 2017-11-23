package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import util.WeekGenerator;

public class AppointmentTableListener implements ActionListener {

    private static Date monDate;
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
    private JTable table;
    private JComboBox partnerYear;
    private JComboBox partnerMonth;
    private JComboBox partnerWeek;
    private Calendar calendar;
    private JButton cancelButton;
    private JButton viewButton;
    private String changingSpinner;
    private int partnerID;

    public AppointmentTableListener(JComboBox w, JComboBox m, JComboBox y, Calendar c, JTable table,
        JButton cancelButton, JButton viewButton, String s, int partnerID) {
        this.partnerWeek = w;
        this.partnerMonth = m;
        this.partnerYear = y;
        this.table = table;
        this.calendar = c;
        this.cancelButton = cancelButton;
        this.viewButton = viewButton;
        this.changingSpinner = s;
        this.partnerID = partnerID;
    }

    /**
     * Disable the cancel and view button when it is clicked on empty slot
     *
     * @param partnerTable The partner table
     * @param cancelButton The cancel table
     * @param viewButton The view button
     */
    public static void buttonDisabler(JTable partnerTable, JButton cancelButton,
        JButton viewButton) {
        partnerTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int column = target.getSelectedColumn();
                int row = target.getSelectedRow();
                Object cell = partnerTable.getValueAt(row, column);
                if (column == 0 || cell == null) {
                    cancelButton.setEnabled(false);
                    viewButton.setEnabled(false);
                } else {
                    if (((String) cell).substring(0, 1).equals("0")) {
                        cancelButton.setEnabled(true);
                        viewButton.setEnabled(false);
                    } else {
                        cancelButton.setEnabled(true);
                        viewButton.setEnabled(true);
                    }
                }

            }
        });

        partnerTable.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                JTable target = (JTable) e.getSource();
                int column = target.getSelectedColumn();
                int row = target.getSelectedRow();
                Object cell = partnerTable.getValueAt(row, column);
                if (column == 0 || cell == null) {
                    cancelButton.setEnabled(false);
                    viewButton.setEnabled(false);
                } else {
                    if (((String) cell).substring(0, 1).equals("0")) {
                        cancelButton.setEnabled(true);
                        viewButton.setEnabled(false);
                    } else {
                        cancelButton.setEnabled(true);
                        viewButton.setEnabled(true);
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
    }

    public static void refreshTable(JTable partnerTable, String selectedWeek, int partnerID,
        JButton cancelButton, JButton viewButton) {
        Date monDate;
        try {
            monDate = timeFormat.parse(selectedWeek);
            Date[] daysInWeekList = WeekGenerator.daysInWeekList(monDate);
            partnerTable.setModel(
                new DefaultTableModel(WeekGenerator.appointmentList(), new String[]{"Time",
                    "Mon " + timeFormat.format(daysInWeekList[0]),
                    "Tue " + timeFormat.format(daysInWeekList[1]),
                    "Wed " + timeFormat.format(daysInWeekList[2]),
                    "Thu " + timeFormat.format(daysInWeekList[3]),
                    "Fri " + timeFormat.format(daysInWeekList[4])}) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                }
            );

            cancelButton.setEnabled(false);
            viewButton.setEnabled(false);

            // Performance problem is this
            for (int i = 0; i < 5; i++) {
                AppointmentQueries
                    .getDayAppointmentList(partnerTable, daysInWeekList[i], partnerID, i + 1);
            }
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        cancelButton.setEnabled(false);
        viewButton.setEnabled(false);
        partnerTable.getColumnModel().getColumn(0).setPreferredWidth(15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(changingSpinner, "year")) {
            calendar.set(Calendar.YEAR, (int) partnerYear.getSelectedItem());
            partnerWeek.setModel(new DefaultComboBoxModel<>(WeekGenerator.weekList(calendar)));
        } else if (Objects.equals(changingSpinner, "month")) {
            calendar.set(Calendar.MONTH, (int) partnerMonth.getSelectedItem() - 1);
            partnerWeek.setModel(new DefaultComboBoxModel<>(WeekGenerator.weekList(calendar)));
        }
        String selectedWeek = ((String) partnerWeek.getSelectedItem()).substring(0, 10);

        refreshTable(table, selectedWeek, partnerID, cancelButton, viewButton);
    }
}
