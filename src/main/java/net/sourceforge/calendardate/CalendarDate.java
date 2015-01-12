package net.sourceforge.calendardate;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * This class represents a date in the Gregorian calendar (for example, December
 * 20, 1998). It is designed to be a simpler, immutable version of
 * <code>java.util.GregorianCalendar</code>.
 * <p>
 * <b>Don't confuse this class with <code>java.util.Date</code>! </b> They
 * represent two separate things:
 * <ul>
 * <li><code>CalendarDate</code> represents a 'date in the calendar' (e.g.
 * "John Smith's birthday") while
 * <li><code>java.util.Date</code> represent an 'instant in time' (e.g. "When
 * order 23711 was received"). A better name for this class would have been
 * 'DateTime'.
 * </ul>
 * These two ways of recording time are not directly related: For any given
 * 'instant in time' the corresponding 'date in the calendar' depends on the
 * timezone. Similiarly the 'instant in time' when a 'date in the calendar'
 * begins depends on the timezone. (This is why you must supply a
 * <code>java.util.TimeZone</code> when converting between instances of
 * <code>CalendarDate</code> and <code>Date</code>.)
 * <p>
 * This class is thread-safe and immutable.
 * <p>
 * 
 * @see java.util.Date
 * @see java.util.GregorianCalendar
 */
public final class CalendarDate implements Comparable, Serializable {

	static final long serialVersionUID = 8577551385869073340L;

	/** The value returned by getDayOfWeek() representing Sunday */
	public static final int SUNDAY = 1;

	/** The value returned by getDayOfWeek() representing Monday */
	public static final int MONDAY = 2;

	/** The value returned by getDayOfWeek() representing Tuesday */
	public static final int TUESDAY = 3;

	/** The value returned by getDayOfWeek() representing Wednesday */
	public static final int WEDNESDAY = 4;

	/** The value returned by getDayOfWeek() representing Thursday */
	public static final int THURSDAY = 5;

	/** The value returned by getDayOfWeek() representing Friday */
	public static final int FRIDAY = 6;

	/** The value returned by getDayOfWeek() representing Saturday */
	public static final int SATURDAY = 7;

	/** The value returned by getMonth() representing January */
	public static final int JANUARY = 1;

	/** The value returned by getMonth() representing February */
	public static final int FEBRUARY = 2;

	/** The value returned by getMonth() representing March */
	public static final int MARCH = 3;

	/** The value returned by getMonth() representing April */
	public static final int APRIL = 4;

	/** The value returned by getMonth() representing May */
	public static final int MAY = 5;

	/** The value returned by getMonth() representing June */
	public static final int JUNE = 6;

	/** The value returned by getMonth() representing July */
	public static final int JULY = 7;

	/** The value returned by getMonth() representing August */
	public static final int AUGUST = 8;

	/** The value returned by getMonth() representing September */
	public static final int SEPTEMBER = 9;

	/** The value returned by getMonth() representing October */
	public static final int OCTOBER = 10;

	/** The value returned by getMonth() representing November */
	public static final int NOVEMBER = 11;

	/** The value returned by getMonth() representing December */
	public static final int DECEMBER = 12;

	/** Days since 1 Jan, 1 A.D., or -1 if not calculated yet */
	private transient int daysSinceEpoch = -1;

	private int year;

	private int month;

	private int dayOfMonth;

	/**
	 * The number of days in the year up to (but not including) a month.
	 */
	private static final int[] cumulDaysToMonth = { 0, // Jan
			31, // Feb
			59, // Mar
			90, // Apr
			120, // May
			151, // Jun
			181, // Jul
			212, // Aug
			243, // Sep
			273, // Oct
			304, // Nov
			334 // Dec
	};

	private static final int[] daysInMonth = { 31, // Jan
			28, // Feb
			31, // Mar
			30, // Apr
			31, // May
			30, // Jun
			31, // Jul
			31, // Aug
			30, // Sep
			31, // Oct
			30, // Nov
			31, // Dec
	};

	/**
	 * The earliest date that can be represented by this class (Januray 1, 1600
	 * A.D.)
	 * <p>
	 * Note: This date may change to before 1600 in later releases of
	 * CalendarDate.
	 */
	public static final CalendarDate EARLIEST = new CalendarDate(1600, 1, 1);

	/**
	 * The latest date that can be represented by this class (December 31, 2999
	 * A.D.)
	 * <p>
	 * Note: This date may change to after 2999 in later releases of
	 * CalendarDate.
	 */
	public static final CalendarDate LATEST = new CalendarDate(2999, 12, 31);

	/**
	 * Creates a date represented by the given year, month and day.
	 * 
	 * @param year
	 *            The year of the date to create
	 * @param month
	 *            The month of the date to create (1 = January, 12 = December)
	 * @param dayOfMonth
	 *            The day of the month of the date to create.
	 * @throws IllegalArgumentException
	 *             if the year, month and dayOfMonth combination are not valid
	 *             in a Gregorian calendar.
	 */
	public CalendarDate(int year, int month, int dayOfMonth) {
		this(year, month, dayOfMonth, false);
	}

	/**
	 * Creates a CalendarDate representing the date in the given timezone at the
	 * given instant in time.
	 * <p>
	 * <b>Think carefully about what timezone to use!</b> Often you will want
	 * to use the timezone of the 'user' - which is not always represented by
	 * <code>TimeZone.getDefault()</code>
	 * 
	 * @param tzone
	 *            The timezone to be considered
	 * @param instantInTime
	 *            The instant in time to be considered
	 * @throws IllegalArgumentException
	 *             if the instant in time is out of range in the given timezone
	 * @see #isOutsideRange(TimeZone, Date)
	 */
	public CalendarDate(TimeZone tzone, Date instantInTime) {
		GregorianCalendar cal = new GregorianCalendar(tzone);
		cal.setTime(instantInTime);
		init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * Creates a CalendarDate representing the current date in the given
	 * timezone. Equivalent to <code>CalendarDate(tzone, new Date())</code>
	 * 
	 * @param tzone
	 *            The timezone to be considered
	 */
	public CalendarDate(TimeZone tzone) {
		this(tzone, new Date());
	}

	/**
	 * Returns true if the given instant in time is before EARLIEST or after
	 * LATEST in the given timezone.
	 */
	public static boolean isOutsideRange(TimeZone tzone, Date instantInTime) {
		GregorianCalendar cal = new GregorianCalendar(tzone);
		cal.setTime(instantInTime);
		return yearOutOfRange(cal.get(Calendar.YEAR));
	}

	/**
	 * 
	 * @param year
	 * @param month
	 * @param dayOfMonth
	 * @param lenient
	 */
	private CalendarDate(int year, int month, int dayOfMonth, boolean lenient) {
		if (!lenient) {
			checkValidYearMonthDay(year, month, dayOfMonth);
		}
		init(year, month, dayOfMonth);
	}

	private void init(int year, int month, int dayOfMonth) {
		this.year = year;
		this.month = month;
		this.dayOfMonth = dayOfMonth;
		correctNonLenientFieldsIfNecessary();
		if (yearOutOfRange(getYear())) {
			throw new IllegalArgumentException("Date year out of range: " + year);
		}
	}

	private void correctNonLenientFieldsIfNecessary() {
		if (!isValidYearMonthDay(year, month, dayOfMonth)) {
			GregorianCalendar cal = new GregorianCalendar(year, month - 1, dayOfMonth);
			this.year = cal.get(Calendar.YEAR);
			this.month = cal.get(Calendar.MONTH) + 1;
			this.dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		}

	}

	private static boolean isValidYearMonthDay(int year, int month, int dayOfMonth) {
		if ((dayOfMonth == 29) && (month == 2) && isLeapYear(year)) {
			return true;
		}
		if ((month <= 0) || (month > 12)) {
			return false;
		}
		if ((dayOfMonth <= 0) || (dayOfMonth > daysInMonth[month - 1])) {
			return false;
		}
		return true;
	}

	private static boolean yearOutOfRange(int year) {
		return (year < 1600) || (year >= 3000);
	}

	/**
	 * Throws an exception if the input isn't a valid day in the Gregorian
	 * Calendar
	 */
	private void checkValidYearMonthDay(int year, int month, int dayOfMonth) {
		if (!isValidYearMonthDay(year, month, dayOfMonth)) {
			throw new IllegalArgumentException("Year/month/day combination is invalid: " + year
					+ "/" + month + "/" + dayOfMonth);
		}
	}

	/**
	 * The day of the month
	 * 
	 * @return The day of the month (in range 1 to 31)
	 */
	public synchronized int getDayOfMonth() {
		return dayOfMonth;
	}

	/**
	 * The day of the week for this date
	 * 
	 * @return Day of week in range 1 (Sunday) to 7 (Saturday)
	 */
	public synchronized int getDayOfWeek() {
		return getDaysSinceEpoch() % 7 + 1;
	}

	/**
	 * The month of this date
	 * 
	 * @return Month in range 1 to 12
	 */
	public synchronized int getMonth() {
		return month;
	}

	/**
	 * The year of this date
	 * 
	 * @return The year
	 */
	public synchronized int getYear() {
		return year;
	}

	/**
	 * Returns a new date which is this date offset by numDays.
	 * 
	 * @param numDays
	 *            the number of days to be added to this date (can be negative)
	 * @return A new date offset by numDays
	 * @throws IllegalArgumentException
	 *             if the resulting day would be before EARLIEST or after
	 *             LATEST. That is, if numDays &lt; this.daysUntil(EARLIEST) or
	 *             numDays &gt; this.daysUntil(LATEST)
	 */
	public CalendarDate addDays(int numDays) {
		return new CalendarDate(getYear(), getMonth(), getDayOfMonth() + numDays, true);
	}

	/**
	 * Returns the number of days until the given date
	 * 
	 * @param otherDay
	 *            The date to compare to
	 * @return The number of days until otherDay (can be negative)
	 */
	public int daysUntil(CalendarDate otherDay) {
		return otherDay.getDaysSinceEpoch() - this.getDaysSinceEpoch();
	}

	/**
	 * Returns the number of month changes until the given day. Note that this
	 * means there is just one 'month' between 1 November and 31 December.
	 * 
	 * @param otherDay
	 *            The date to compare to
	 * @return The number of month changes until the given day
	 */
	public int monthsUntil(CalendarDate otherDay) {
		return (otherDay.getMonth() - this.getMonth())
				+ (12 * (otherDay.getYear() - this.getYear()));
	}

	/**
	 * Days since epoch (1 Jan, 1 A.D.)
	 */
	private synchronized int getDaysSinceEpoch() {
		if (daysSinceEpoch == -1) {
			int year = getYear();
			int month = getMonth();
			int daysThisYear = cumulDaysToMonth[month - 1] + getDayOfMonth() - 1;
			if ((month > 2) && isLeapYear(year)) {
				daysThisYear++;
			}

			daysSinceEpoch = daysToYear(year) + daysThisYear;
		}
		return daysSinceEpoch;
	}

	/**
	 * Number of days up to, but not including, the given year since epoch.
	 * 
	 * @param year
	 * @return
	 */
	static int daysToYear(int year) {
		return (365 * year) + numLeapsToYear(year);
	}

	/**
	 * Returns the number of leap years from the epoch until (but not including)
	 * the given year. The epoch begins on 1 Jan, 1AD
	 * 
	 * @param year
	 * @return The number of leap years
	 */
	static int numLeapsToYear(int year) {
		int num4y = (year - 1) / 4;
		int num100y = (year - 1) / 100;
		int num400y = (year - 1) / 400;
		int numLeaps = num4y - num100y + num400y;
		return numLeaps;
	}

	/**
	 * Returns true if the year is a leap year in the Gregorian calendar
	 * 
	 * @param year
	 *            The year to consider
	 * @return True if <code>year</code> is a leap year
	 */
	public static boolean isLeapYear(int year) {
		return (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
	}

	/**
	 * If the given object is a CalendarDate:
	 * <ol>
	 * <li>returns less than 0 if this date is before the given date
	 * <li>returns 0 if this date is equal to the given date
	 * <li>returns more than 0 if this date is after the given date
	 * </ol>
	 * 
	 * @param other
	 *            the date to compare this one to
	 * @throws ClassCastException
	 *             if <code>other</code> is not an instance of CalendarDate
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object other) {
		return this.getDaysSinceEpoch() - ((CalendarDate) other).getDaysSinceEpoch();
	}

	/**
	 * Returns true if this date is before the given date
	 * 
	 * @param other
	 *            The date to consider
	 * @return true if this date is before the given date
	 */
	public boolean isBefore(CalendarDate other) {
		return compareTo(other) < 0;
	}

	/**
	 * Returns true if this date is after the given date
	 * 
	 * @param other
	 *            The date to consider
	 * @return true if this date is after the given date
	 */
	public boolean isAfter(CalendarDate other) {
		return compareTo(other) > 0;
	}

	/**
	 * Returns true if the given object is a CalendarDate representing the same
	 * date as this object
	 * 
	 * @param other
	 *            The date to test against
	 * @return true if this is the same date as <code>other</code>
	 */
	public boolean equals(Object other) {
		if (other instanceof CalendarDate) {
			return (this.compareTo(other) == 0);
		}
		return false;
	}

	public int hashCode() {
		return (375 * getYear()) + (35 * getMonth()) + getDayOfMonth();
	}

	/**
	 * Returns a string form of this date in the form "2004-9-23"
	 * 
	 * @return A string form of this date
	 */
	public String toString() {
		return new StringBuffer().append(getYear()).append("-").append(getMonth()).append("-")
				.append(getDayOfMonth()).toString();
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeInt(getYear());
		out.writeInt(getMonth());
		out.writeInt(getDayOfMonth());
		out.writeInt(daysSinceEpoch);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		init(in.readInt(), in.readInt(), in.readInt());
		daysSinceEpoch = in.readInt();
	}

	/**
	 * Returns the instant in time when this day begins in the given timezone.
	 * 
	 * @param timezone
	 *            The timezone to consider
	 * @return the instant in time when this day begins
	 */
	public Date toDate(TimeZone timezone) {
		return toDate(timezone, 0, 0, 0);
	}

	/**
	 * Returns the instant in time when the given time of day is reached in the
	 * given timezone. If the time occurs twice on this date (as may happen when
	 * coming out of daylight savings time) the second occurrence will be
	 * returned.
	 * 
	 * @param timezone
	 *            The timezone to for which the date applies
	 * @param hour
	 *            The hour of the day in range 0 - 23
	 * @param min
	 *            The minute of the day in range 0 - 59
	 * @param sec
	 *            The second of the day in range 0 - 60 (60 is for leap-seconds)
	 * @return The instant in time when the given time of day is reached in the
	 *         given timezone
	 * @throws IllegalArgumentException
	 *             if the hour, min or sec parameters are outside the correct
	 *             range
	 */
	public Date toDate(TimeZone timezone, int hour, int min, int sec) {
		checkHourMinSec(hour, min, sec);
		GregorianCalendar cal = new GregorianCalendar(timezone);
		cal.clear();
		cal.set(getYear(), getMonth() - 1, getDayOfMonth(), hour, min, sec);
		return cal.getTime();
	}

	private void checkHourMinSec(int hour, int min, int sec) {
		if ((hour < 0) || (hour >= 24)) {
			throw new IllegalArgumentException("Hour out of range: " + hour);
		}
		if ((min < 0) || (min >= 60)) {
			throw new IllegalArgumentException("Minute out of range: " + min);
		}
		// Leap seconds mean some minutes are 61 seconds long!
		if ((sec < 0) || (sec >= 61)) {
			throw new IllegalArgumentException("Second out of range: " + hour);
		}
	}

	/**
	 * Returns the number of days in the given month.
	 * 
	 * @param year
	 *            The year
	 * @param month
	 *            The month in range 1 - 12
	 * @return The number of days in the given month
	 */
	public static int daysInMonth(int year, int month) {
		int result = daysInMonth[month - 1];
		if ((month == 2) && (isLeapYear(year))) {
			result++;
		}
		return result;
	}

	/**
	 * Adds a given number of months to the date while attempting to keep the
	 * day of the month. Note that this method is NOT transitive. For example:
	 * <ul>
	 * <li><code>new CalendarDate(2005, 12, 31).addMonths(2).addMonths(1)</code>
	 * results in "March 28, 2006"; but,
	 * <li><code>new CalendarDate(2005, 12, 31).addMonths(3)</code> results
	 * in "March 31, 2006"
	 * </ul>
	 * 
	 * @param numMonths
	 *            the number of months to be added (can be negative)
	 * @return A new date representing an offset of months from this date
	 */
	public CalendarDate addMonths(int numMonths) {
		int newMonthsSinceEpoch = getYear() * 12 + getMonth() + numMonths - 1;
		int newYear = newMonthsSinceEpoch / 12;
		int newMonth = (newMonthsSinceEpoch % 12) + 1;
		int newDay = Math.min(getDayOfMonth(), daysInMonth(newYear, newMonth));
		return new CalendarDate(newYear, newMonth, newDay);
	}

}

