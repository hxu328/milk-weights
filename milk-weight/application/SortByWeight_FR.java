/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to sort farm reports based on weight
 */
package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * class to sort farm reports based on weight
 * @author Hong Xu
 *
 */
public class SortByWeight_FR {
	
	/**
	 * sort farm reports based on weight
	 * @param reports
	 */
	public static void sortWeight(ArrayList<ReportByMonth> reports) {
		Collections.sort(reports, new WeightComparator_FR());
	}
}
