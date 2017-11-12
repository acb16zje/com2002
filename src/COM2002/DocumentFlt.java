package COM2002;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

class DocumentFlt extends DocumentFilter{
    private static final long serialVersionUID = 1L;
    @Override
public void insertString(FilterBypass fb, int off
                    , String str, AttributeSet attr) 
                            throws BadLocationException 
{
    // remove non-digits
    fb.insertString(off, str.replaceAll("\\D++", ""), attr);
} 
@Override
public void replace(FilterBypass fb, int off
        , int len, String str, AttributeSet attr) 
                        throws BadLocationException 
{
    // remove non-digits
    fb.replace(off, len, str.replaceAll("\\D++", ""), attr);
}
}