package net.sourceforge.calendardate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Formats and parses CalendarDates in a locale-sensitive manner based on a
 * pattern string. <br>
 * For example for a date representing June 12, 2004:
 * <ul>
 * <li>a pattern of "dd-MMM-yyyy" will result in "12-Jun-2004"; while 
 * <li>a pattern of "EEEEE, MMMM dd yyyy" will result in 
 * "Saturday, June 12 2004".
 * </ul>
 * <p>
 * The pattern and format rules are the same as for java.text.SimpleDateFormat,
 * except that only the following pattern letters are useful: <blockquote>
 * <table border=1 cellspacing=0 cellpadding=2 summary="Chart shows pattern
 * letters, date/time component, presentation, and examples.">
 * <tr bgcolor="#ccccff">
 * <th align=left>Letter
 * <th align=left>Date Component
 * <th align=left>Examples
 * <tr>
 * <td><code>G</code>
 * <td>Era designator
 * <td><code>AD</code>
 * <tr bgcolor="#eeeeff">
 * <td><code>y</code>
 * <td>Year
 * <td><code>1996</code>;<code>96</code>
 * <tr>
 * <td><code>M</code>
 * <td>Month in year
 * <td><code>July</code>;<code>Jul</code>;<code>07</code>
 * <tr  bgcolor="#eeeeff">
 * <td><code>d</code>
 * <td>Day in month
 * <td><code>10</code>
 * <tr>
 * <td><code>E</code>
 * <td>Day in week
 * <td><code>Tuesday</code>;<code>Tue</code> </table> </blockquote>
 * 
 * @see java.text.SimpleDateFormat
 */
public class CalendarDateFormat {
    
    private SimpleDateFormat dateFormat;
    

    /**
     * Creates a format object based on the given date pattern.  The resulting format 
     * is NOT lenient (i.e. "32-Jan-2004" will result in a ParseException, rather than 
     * returning 01-Jan-2004)
     * @param pattern the pattern string - see class doc for more information    
     * @exception IllegalArgumentException if the given pattern is invalid
     */
    public CalendarDateFormat(String pattern) {
        dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(TimeZone.getDefault());
    }
    
    /**
     * Creates a format object based on the given simple date format.
     */
    public CalendarDateFormat(SimpleDateFormat format) {
        dateFormat = (SimpleDateFormat) format.clone();
        dateFormat.setTimeZone(TimeZone.getDefault());
    }
    
    
    
    /**
     * Creates a text-based representation of the given date
     * @param date The date to be formatted
     * @return The String form of the given date
     */
    public String format(CalendarDate date) {
        return dateFormat.format(date.toDate(dateFormat.getTimeZone()));
    }
    
    /**
     * Parses the given string to produce a CalendarDate.  
     * 
     * @param source The text to parse
     * @return A CalendarDate matching the given string
     * @throws java.text.ParseException If one of the following this true:
     * <ol>
     * <li>The String doesn't match the format of this pattern
     * <li>The date represented by <code>source</code> is outside the
     *     valid CalendarDate range
     * </ol>
     */
    public CalendarDate parse(String source) throws ParseException {
        TimeZone timeZone = dateFormat.getTimeZone();
		Date instant = dateFormat.parse(source);
		if (CalendarDate.isOutsideRange(timeZone, instant)) {
			throw new ParseException("Date is outside CalendarDate range", 0);
		}
		return new CalendarDate(timeZone, instant);
    }
}


