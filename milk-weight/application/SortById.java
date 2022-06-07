/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to sort reports based on farm ID
 */
package application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * a class to sort reports based on farm ID
 * @author Hong Xu
 *
 */
public class SortById {
	/**
	 * sort reports based on farm ID
	 * @param reports
	 */
	public static void sortId(ArrayList<ReportById> reports) {
		Collections.sort(reports, new IdComparator());
	}
}
