package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class IntegerFilter extends DocumentFilter {

    private int limit;

    public IntegerFilter(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(DocumentFilter.FilterBypass fp, int offset, String string,
        AttributeSet aset) throws BadLocationException {
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                isValidInteger = false;
                break;
            }
        }

        if (isValidInteger) {
            super.insertString(fp, offset, string, aset);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string,
        AttributeSet aset) throws BadLocationException {
        int len = string.length();
        boolean isValidInteger = true;

        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(string.charAt(i))) {
                isValidInteger = false;
                break;
            }
        }

        if (isValidInteger && fb.getDocument().getLength() + string.length() <= limit) {
            super.replace(fb, offset, length, string, aset);
        }
    }
}
