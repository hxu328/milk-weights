/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to sort reports based on month
 */
package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * a class to sort reports based on month
 * @author Hong Xu
 *
 */
public class SortByMonth {
	
	/**
	 * a class to sort reports based on month
	 * @param reports
	 */
	public static void sortMonth(ArrayList<ReportByMonth> reports) {
		Collections.sort(reports, new MonthComparator());
	}
}
