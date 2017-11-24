package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import util.DateHandler;

public class BookingListener implements ActionListener {

    private JComboBox comboDay;
    private JComboBox comboMonth;
    private JComboBox comboYear;
    private JComboBox comboTime;
    private int type;
    private int partnerID;

    public BookingListener(JComboBox comboDay, JComboBox comboMonth, JComboBox comboYear,
        JComboBox comboTime, String type, int partnerID) {
        this.comboDay = comboDay;
        this.comboMonth = comboMonth;
        this.comboYear = comboYear;
        this.comboTime = comboTime;
        if (Objects.equals(type, "Start")) {
            this.type = 0;
        } else if (Objects.equals(type, "End")) {
            this.type = 1;
        }
        this.partnerID = partnerID;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int currentlySelected = (int) comboDay.getSelectedItem();
        String selectedMonth = String.valueOf(comboMonth.getSelectedItem());
        Calendar tempCal = new GregorianCalendar((int) comboYear.getSelectedItem(),
            Integer.parseInt(selectedMonth) - 1, 1);
        comboDay.setModel(new DefaultComboBoxModel());
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            comboDay.addItem(i);
        }
        if (tempCal.getActualMaximum(Calendar.DAY_OF_MONTH) >= currentlySelected) {
            comboDay.setSelectedItem(currentlySelected);
        } else {
            comboDay.setSelectedItem(tempCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        }

        Boolean[] avaibilityBoolean = AppointmentQueries.getAvailableTime(DateHandler
            .newDate((int) comboYear.getSelectedItem(), (int) comboMonth.getSelectedItem(),
                (int) comboDay.getSelectedItem()), partnerID);
        comboTime.setModel(new DefaultComboBoxModel());
        int cellValue = 0;
        if (type == 0) {
            for (int hour = 9; hour < 17; hour++) {
                for (int min = 0; min < 6; min += 2) {
                    if (avaibilityBoolean[cellValue]) {
                        if (hour == 9) {
                            comboTime
                                .addItem(
                                    "0" + String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                        } else {
                            comboTime
                                .addItem(String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                        }
                    }
                    cellValue++;
                }
            }
        } else {
            for (int hour = 9; hour <= 17; hour++) {
                if (hour == 9) {
                    for (int min = 2; min < 6; min += 2) {
                        if (avaibilityBoolean[cellValue]) {
                            comboTime
                                .addItem(
                                    "0" + String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                        }
                        cellValue++;
                    }
                } else if (hour == 17) {
                    if (avaibilityBoolean[cellValue]) {
                        comboTime.addItem("17:00");
                    }
                } else {
                    for (int min = 0; min < 6; min += 2) {
                        if (avaibilityBoolean[cellValue]) {
                            comboTime
                                .addItem(String.valueOf(hour) + ":" + String.valueOf(min) + "0");
                        }
                        cellValue++;
                    }
                }
            }
        }
    }
}