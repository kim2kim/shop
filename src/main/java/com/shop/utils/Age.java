package com.shop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class Age {
	private final static Logger log = Logger.getLogger(Age.class);

	private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
	static {
		simpleDateFormat.applyPattern("MM/dd/yyyy");
	}

	public static int get(Date birthday) {

		int day = 1, month = 0, year = 1, ageYears, ageMonths, ageDays;

		String[] tmp = StringUtils.split(StringUtils.split(birthday.toString(),
				" ")[0], "-");
		month = Integer.valueOf(tmp[1]);
		day = Integer.valueOf(tmp[2]);
		year = Integer.valueOf(tmp[0]);

		Calendar cd = Calendar.getInstance();
		try {
			if (year > cd.get(Calendar.YEAR)) {
				return 0;
			}
			if (month < 1 || month > 12) {
				return 0;
			} else {
				month--;
				if (year == cd.get(Calendar.YEAR)) {
					if (month > cd.get(Calendar.MONTH)) {
						return 0;
					}
				}
			}
			if (month == 0 || month == 2 || month == 4 || month == 6
					|| month == 7 || month == 9 || month == 11) {
				if (day > 31 || day < 1) {
					return 0;
				}
			} else if (month == 3 || month == 5 || month == 8 || month == 10) {
				if (day > 30 || day < 1) {
					System.exit(0);
				}
			} else {
				if (new GregorianCalendar().isLeapYear(year)) {
					if (day < 1 || day > 29) {
						return 0;
					}
				} else if (day < 1 || day > 28) {
					return 0;
				}
			}
			if (year == cd.get(Calendar.YEAR)) {
				if (month == cd.get(Calendar.MONTH)) {
					if (day > cd.get(Calendar.DAY_OF_MONTH)) {
						return 0;
					}
				}
			}
		} catch (NumberFormatException ne) {
			return 0;
		}
		Calendar bd = new GregorianCalendar(year, month, day);
		ageYears = cd.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
		if (cd.before(new GregorianCalendar(cd.get(Calendar.YEAR), month, day))) {
			ageYears--;
			ageMonths = (12 - (bd.get(Calendar.MONTH) + 1))
					+ (bd.get(Calendar.MONTH));
			if (day > cd.get(Calendar.DAY_OF_MONTH)) {
				ageDays = day - cd.get(Calendar.DAY_OF_MONTH);
			} else if (day < cd.get(Calendar.DAY_OF_MONTH)) {
				ageDays = cd.get(Calendar.DAY_OF_MONTH) - day;
			} else {
				ageDays = 0;
			}
		} else if (cd.after(new GregorianCalendar(cd.get(Calendar.YEAR), month,
				day))) {
			ageMonths = (cd.get(Calendar.MONTH) - (bd.get(Calendar.MONTH)));
			if (day > cd.get(Calendar.DAY_OF_MONTH))
				ageDays = day - cd.get(Calendar.DAY_OF_MONTH) - day;
			else if (day < cd.get(Calendar.DAY_OF_MONTH)) {
				ageDays = cd.get(Calendar.DAY_OF_MONTH) - day;
			} else
				ageDays = 0;
		} else {
			ageYears = cd.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
			ageMonths = 0;
			ageDays = 0;
		}
		log.debug("Age of the person : " + ageYears + " year, " + ageMonths
				+ " months and " + ageDays + " days.");
		return ageYears;
	}
}
