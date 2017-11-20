package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
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
    private String changingSpinner;

    public AppointmentTableListener(JComboBox w, JComboBox m, JComboBox y, Calendar c, JTable table,
        String s) {
        this.partnerWeek = w;
        this.partnerMonth = m;
        this.partnerYear = y;
        this.table = table;
        this.calendar = c;
        this.changingSpinner = s;
    }

    /**
     * Generate the days in the week
     *
     * @param selectedWeek The selected week
     */
    public static void generateAppointmentTable(String selectedWeek, JTable table) {
        try {
            monDate = timeFormat.parse(selectedWeek);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        Date[] daysInWeekList = WeekGenerator.daysInWeekList(monDate);
        table.setModel(
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

        table.getColumnModel().getColumn(0).setPreferredWidth(15);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (changingSpinner == "year") {
            calendar.set(Calendar.YEAR, (int) partnerYear.getSelectedItem());
            partnerWeek.setModel(new DefaultComboBoxModel(WeekGenerator.weekList(calendar)));
        } else if (changingSpinner == "month") {
            calendar.set(Calendar.MONTH, (int) partnerMonth.getSelectedItem() - 1);
            partnerWeek.setModel(new DefaultComboBoxModel(WeekGenerator.weekList(calendar)));
        }
        String selectedWeek = ((String) partnerWeek.getSelectedItem()).substring(0, 10);
        generateAppointmentTable(selectedWeek, table);
    }
}
