package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class DateListener implements ActionListener {

    private JComboBox comboDay;
    private JComboBox comboMonth;
    private JComboBox comboYear;

    public DateListener(JComboBox comboDay, JComboBox comboMonth, JComboBox comboYear) {
        this.comboDay = comboDay;
        this.comboMonth = comboMonth;
        this.comboYear = comboYear;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentlySelected = String.valueOf(comboDay.getSelectedItem());
        String selectedMonth = String.valueOf(comboMonth.getSelectedItem());
        Calendar tempCal = new GregorianCalendar((int) comboYear.getSelectedItem(),
            Integer.parseInt(selectedMonth) - 1, 1);
        String[] newArray = new String[tempCal.getActualMaximum(Calendar.DAY_OF_MONTH)];
        for (int i = 1; i <= tempCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            newArray[i - 1] = String.valueOf(i);
        }
        comboDay.setModel(new DefaultComboBoxModel(newArray));
        if (tempCal.getActualMaximum(Calendar.DAY_OF_MONTH) >= Integer
            .parseInt(currentlySelected)) {
            comboDay.setSelectedItem(currentlySelected);
        } else {
            comboDay.setSelectedItem(tempCal.getActualMaximum(Calendar.DAY_OF_MONTH));
        }

    }
}
