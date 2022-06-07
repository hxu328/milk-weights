/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a Comparator class which can be used
 * to sort "period reports" based on weight
 */
package application;

import java.util.Comparator;

/**
 * A comparator implements Comparator<ReportById>,
 * used to compare the milk weight between 2
 * instances of ReportById
 * @author Hong Xu
 *
 */
public class WeightComparator_PR implements Comparator<ReportById>{

	/**
	 * override method used to sort a list of ReportById
     * by milk weight
     * @return negative if r1 is predecessor of r2, positive is r1 is successor of 
	 * r2
	 */
	@Override
	public int compare(ReportById r1, ReportById r2) {
		return r1.getWeight() - r2.getWeight();
	}

}
