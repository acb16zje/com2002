package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import util.WeekGenerator;

public class AppointmentListener implements ChangeListener {
	private static JTable table;
	private static JSpinner dentistYear;
	private static JSpinner dentistMonth;
	private static JComboBox dentistWeek;
	private static Calendar calendar;
	private static Date monDate;
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public AppointmentListener(JComboBox w,JSpinner m,JSpinner y, Calendar c,JTable table ,String s) {
		this.dentistWeek = w;
		this.dentistMonth = m;
		this.dentistYear = y;
		this.table = table;
		if (s == "year") {
			c.set(Calendar.YEAR, (int) y.getValue());
		}
		else if (s == "month") {
			c.set(Calendar.MONTH, (int) m.getValue()-1);
		}
		this.calendar = c;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		String selectedWeek = ((String) dentistWeek.getSelectedItem()).substring(0, 10);
        generateAppointmentTable(selectedWeek,table);
	}

	/**
     * Generate the days in the week
     *
     * @param selectedWeek The selected week
     */
    public static void generateAppointmentTable(String selectedWeek,JTable table) {
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
}
