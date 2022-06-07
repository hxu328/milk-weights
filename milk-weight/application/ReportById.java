/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class represent a report: farm ID, weight, percent
 */
package application;

/**
 * A data structure that stores total weight and
 * percent of total weight of all farms by farm for a
 * specific period
 * @author Hong Xu
 *
 */
public class ReportById implements Report{
	private String name;
	private int milkWeight;
	private double percent;
	private String report;
	
	
	/**
	 * constructor
	 * @param name
	 * @param milkWeight
	 * @param percent
	 */
	public ReportById(String name, int milkWeight, double percent) {
		this.name = name;
		this.milkWeight = milkWeight;
		this.percent = (int)(Math.round(percent * 100))/100.0;//Show only two digit after decimal
		this.report = name + ", " + milkWeight + " lbs" + ", " + this.percent + " %";
	}
	
	/**
	 * getter method to get report
	 * @return report
	 */
	@Override
	public String getReport() {
		return report;
	}
	
	/**
	 * getter method to return month
	 * @return month
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getter method to return milk weight
	 * @return milkWeight
	 */
	@Override
	public int getWeight() {
		return milkWeight;
	}
	
	/**
	 * getter method to return percent
	 * @return percent
	 */
	public double getPercent() {
		return percent;
	}
}
