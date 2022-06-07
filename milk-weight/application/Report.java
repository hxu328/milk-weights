package application;

/**
 * An ADT representing a report
 * @author Hong Xu
 *
 */
public interface Report {

	/**
	 * getter method to return report
	 * @return report
	 */
	String getReport();//abstract method to return a string representing a report

	/**
	 * getter method to return milk weight
	 * @return milkWeight
	 */
	int getWeight();//abstract method to return weight in the report
}
