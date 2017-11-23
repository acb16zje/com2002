package util;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class MoneyFilter extends DocumentFilter {

    @Override
    public void insertString(DocumentFilter.FilterBypass fp, int offset, String string,
        AttributeSet aset)
        throws BadLocationException {

        if (isValidMoney(string)) {
            super.insertString(fp, offset, string, aset);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fp, int offset, int length, String string,
        AttributeSet aset)
        throws BadLocationException {

        if (isValidMoney(string)) {
            super.replace(fp, offset, length, string, aset);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    private static boolean isValidMoney(String money)	{
    	if(money == null || money == "")	{
    		return false;
    	}
    	String[] parts = money.split("\\.");
    	if(parts.length > 2)	{
    		return false;
    	} else if(parts.length == 1)	{
    		String string = parts[0];
    		return checkDigits(string);
    	} else {
    		if(parts[1].length() != 2 || parts[0].length() > 8)	{
    			return false;
    		}
    		for (int j = 0; j < 2; j++)	{
    			String string = parts[j];
    			if(!checkDigits(string))	{
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private static boolean checkDigits(String string)	{
    	for (int i = 0; i < string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
    	return true;
    }
    
    public static void main(String[] args)	{
    	System.out.println(MoneyFilter.isValidMoney("12345"));
    	System.out.println(MoneyFilter.isValidMoney("123.45"));
    	System.out.println(MoneyFilter.isValidMoney("123209123.45"));
    	System.out.println(MoneyFilter.isValidMoney("123.45.02"));
    	System.out.println(MoneyFilter.isValidMoney(".45"));
    	System.out.println(MoneyFilter.isValidMoney("123.4"));
    	System.out.println(MoneyFilter.isValidMoney("123.456"));
    	System.out.println(MoneyFilter.isValidMoney("hello"));
    	System.out.println(MoneyFilter.isValidMoney("123.hello"));
    }
    
}
