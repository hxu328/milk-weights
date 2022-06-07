/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to get max weight
 */
package application;

import java.util.ArrayList;

/**
 * this is a class to get max weight
 * @author Hong Xu
 *
 */
public class MaxWeight {
	
	/**
	 * get max weight for farm reports
	 * @param reports
	 * @return max weight
	 */
	public static int getMaxWeight_FR(ArrayList<ReportByMonth> reports) {
		SortByWeight_FR.sortWeight(reports);
		return reports.get(reports.size() - 1).getWeight();
	}
	
	/**
	 * get max weight for "period reports": annual, monthly, date range reports
	 * @param reports
	 * @return max weight
	 */
	public static int getMaxWeight_PR(ArrayList<ReportById> reports) {
		SortByWeight_PR.sortWeight(reports);
		return reports.get(reports.size() - 1).getWeight();
	}
}
