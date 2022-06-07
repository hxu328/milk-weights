/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to get min weight
 */
package application;

import java.util.ArrayList;

/**
 * this is a class to get min weight
 * @author Hong Xu
 *
 */
public class MinWeight {
	
	/**
	 * get min weight for farm reports
	 * @param reports
	 * @return min weight
	 */
	public static int getMinWeight_FR(ArrayList<ReportByMonth> reports) {
		SortByWeight_FR.sortWeight(reports);
		return reports.get(0).getWeight();
	}
	
	/**
	 * get min weight for "period reports": annual, monthly, date range reports
	 * @param reports
	 * @return min weight
	 */
	public static int getMinWeight_PR(ArrayList<ReportById> reports) {
		SortByWeight_PR.sortWeight(reports);
		return reports.get(0).getWeight();
	}
}
