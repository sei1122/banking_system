/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author seikoigi
 *
 */
public class Date {

	private int day;
	private int month;
	private int year;
	private static HashMap<Integer, String> monthNames;

	private static final int START_DAY = 1;
	private static final int END_DAY = 31;
	private static final int INVALID = 1;
	private static final int START_MONTH = 1;
	private static final int END_MONTH = 12;
	private static final int START_YEAR = 1900;
	private static final int CURRENT_YEAR = 2017;

	/**
	 * constructor
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
		monthKEYAndValue();

	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(int day) {
		if ((day >= START_DAY) && (day <= END_DAY)) {
			this.day = day;
		} else {
			this.day = INVALID;
		}

	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(int month) {
		if ((month >= START_MONTH) && (month <= END_MONTH)) {
			this.month = month;
		} else {
			this.month = INVALID;
		}

	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		if ((year >= START_YEAR) && (year <= CURRENT_YEAR)) {
			this.year = year;
		} else {
			this.year = START_YEAR;
		}

	}
	
	/**
	 * populate the hash map
	 */
	private static void monthKEYAndValue() {
		// only do this onces
		if (monthNames == null) {
			monthNames = new HashMap<Integer, String>();
			monthNames.put(1, "January");
			monthNames.put(2, "February");
			monthNames.put(3, "March");
			monthNames.put(4, "April");
			monthNames.put(5, "May");
			monthNames.put(6, "June");
			monthNames.put(7, "July");
			monthNames.put(8, "August");
			monthNames.put(9, "September");
			monthNames.put(10, "October");
			monthNames.put(11, "November");
			monthNames.put(12, "December");
		}
	}
	
	/**
	 * formatted day, change to String
	 * @return day
	 */
	public String formattedDay() {
		if ((day > 0) && (day <= 9)) {
			return "0" + Integer.toString(day);
		} else {
			return Integer.toString(day);
		}
	}
	
	/**
	 * formatted month, change to String
	 * @return month
	 */
	public String formattedMonth() {
		if (month != 0 && monthNames.containsKey(month)) {
			return monthNames.get(month);
		} else {
			return null;
		}
	}
	
	/**
	 * formatted date 
	 * @return date
	 */
	public String formattedDate() {
		return formattedDay() + "/" + formattedMonth() + "/" + year;
	}
	
	/**
	 * create Date object from user's input
	 * @param scan
	 * @return date
	 */
	public static Date createUserInputDate(Scanner scan) {
		// ask the user to input a day a month and a year value
		int day = 0;
		int month = 0;
		int year = 0;

		boolean done = false;
		while (!done) {
			System.out.println("Please enter day");
			day = scan.nextInt();
			if (day >= START_DAY && day <= END_DAY) {
				done = true;
			} else {
				System.out.println("Invalid day");
			}
		}

		done = false;
		while (!done) {
			System.out.println("Please enter month");
			month = scan.nextInt();
			if (month >= START_MONTH && month <= END_MONTH) {
				done = true;
			} else {
				System.out.println("Invalid month");
			}
		}

		done = false;
		while (!done) {
			System.out.println("Please enter year");
			year = scan.nextInt();
			if (year >= START_YEAR && year <= CURRENT_YEAR) {
				done = true;
			} else {
				System.out.println("Invalid year");
			}
		}

		Date date = new Date(day, month, year);

		return date;
	}

}
