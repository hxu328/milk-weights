/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to check whether the original data contains
 * a specific farm ID, year, month or date
 */
package application;

import java.util.ArrayList;

/**
 * this is a class to check whether the original data contains
 * a specific farm ID, year, month or date
 * @author Hong Xu
 *
 */
public class Check {
	
	/**
	 * this is a method to check whether the original data contains
	 * a specific farm ID
	 * @param days original data
	 * @param name a specific name of farm
	 * @return true if it contains
	 */
	public static boolean hasName(ArrayList<SingleDayMilk> days, String name) {
		for(int i = 0; i < days.size(); i++) {
			if(days.get(i).getID().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * this is a method to check whether the original data contains
	 * a specific year
	 * @param days original data
	 * @param year a specific year
	 * @return true if it contains the year
	 */
	public static boolean hasYear(ArrayList<SingleDayMilk> days, int year) {
		for(int i = 0; i < days.size(); i++) {
			if(days.get(i).getYear() == year) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * this is a method to check whether the original data contains
	 * a specific year and month
	 * @param days original data
	 * @param year a specific year
	 * @param month  a specific month
	 * @return true if it contains the specific year and month
	 */
	public static boolean hasMonth(ArrayList<SingleDayMilk> days, int year,int month) {
		for(int i = 0; i < days.size(); i++) {
			if((days.get(i).getYear()==year) && (days.get(i).getMonth() == month)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * this is a method to check whether the date is valid
	 * @param month the number of the month
	 * @param day the number of the day
	 * @return true if valid
	 */
	public static boolean hasDate(int month, int day) {
		if((month > 12) || (month < 1)) {
			return false;
		}
		if((day > 31) || (day < 1)) {
			return false;
		}
		return true;
	}
}
