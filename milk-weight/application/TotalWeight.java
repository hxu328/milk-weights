/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to get total weight of reports
 */
package application;

import java.util.ArrayList;

/**
 * a class to get total weight of reports
 * @author Hong Xu
 *
 */
public class TotalWeight {
	
	/**
	 * get total weight of farm reports
	 * @param reports
	 * @return total weight
	 */
	public static int getTotalWeight_FR(ArrayList<ReportByMonth> reports) {
		int totalWeightForAllMonths = 0;
		for(int i = 0; i < reports.size(); i++) {
			totalWeightForAllMonths += reports.get(i).getWeight();
		}
		return totalWeightForAllMonths;
		
	}
	
	/**
	 * get total weight of "period reports"
	 * @param reports
	 * @return total weight
	 */
	public static int getTotalWeight_PR(ArrayList<ReportById> reports) {
		int totalWeightForAllFarms = 0;
		for(int i = 0; i < reports.size(); i++) {
			totalWeightForAllFarms += reports.get(i).getWeight();
		}
		return totalWeightForAllFarms;
	}
}
