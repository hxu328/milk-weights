/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to calculate the average weight
 */
package application;

import java.util.ArrayList;

/**
 * this is a class to calculate the average weight
 * @author Hong Xu
 *
 */
public class AverageWeight {
	/**
	 * calculate average weight for farm reports
	 * @param reports farm reports
	 * @return the average weight
	 */
	public static int getAverageWeight_FR(ArrayList<ReportByMonth> reports) {
		int totalWeightForAllMonths = 0;
		for(int i = 0; i < reports.size(); i++) {
			totalWeightForAllMonths += reports.get(i).getWeight();
		}
		return totalWeightForAllMonths/reports.size();
	}
	
	/**
	 * calculate average weight for "period reports",
	 * aka: annual reports, monthly reports and data range reports
	 * @param reports "period reports"
	 * @return the average weight for all farms during the specific period
	 */
	public static int getAverageWeight_PR(ArrayList<ReportById> reports) {
		int totalWeightForAllFarms = 0;
		for(int i = 0; i < reports.size(); i++) {
			totalWeightForAllFarms += reports.get(i).getWeight();
		}
		return totalWeightForAllFarms/reports.size();
	}
}
