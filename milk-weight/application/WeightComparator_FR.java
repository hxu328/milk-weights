/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a Comparator class which can be used
 * to sort farm reports based on weight
 */
package application;

import java.util.Comparator;

/**
 * A comparator implements Comparator<ReportByMonth>,
 * used to compare the milk weight between 2
 * instances of ReportByMonth
 * @author Hong Xu
 *
 */
public class WeightComparator_FR implements Comparator<ReportByMonth>{

	/**
	 * override method used to sort a list of ReportByMonth
     * by milk weight
     * @return negative if r1 is predecessor of r2, positive is r1 is successor of 
	 * r2
	 */
	@Override
	public int compare(ReportByMonth r1, ReportByMonth r2) {
		return r1.getWeight() - r2.getWeight();
	}

}
