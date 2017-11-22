package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CharacterFilter extends DocumentFilter {

    private int limit;

    public CharacterFilter(int limit) {
        this.limit = limit;
    }

    @Override
    public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as)
        throws BadLocationException {
        for (int n = string.length(); n > 0; n--) {
            // Get a single character of the string
            char c = string.charAt(n - 1);

            // If its an alphabetic character or white space
            if ((Character.isAlphabetic(c) || c == ' ') && fb.getDocument().getLength() + string.length() <= limit) {
                // Allow update to take place for the given character
                super.replace(fb, i, i1, String.valueOf(c), as);
            }
        }
    }

    @Override
    public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
        super.remove(fb, i, i1);
    }

    @Override
    public void insertString(FilterBypass fb, int i, String string, AttributeSet as)
        throws BadLocationException {
        super.insertString(fb, i, string, as);
    }
}
