/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class represent a report: month number, weight, percent
 * which can be used for farm reports
 */
package application;
/**
 * A data structure that stores data of the total milk
 * weight and percent of the total of a farm for each
 * month, used for ¡°Farm Report¡±
 * @author Hong Xu
 *
 */
public class ReportByMonth implements Report{
	private int month;
	private int milkWeight;
	private double percent;
	private String report;
	
	/**
	 * constructor
	 * @param month
	 * @param milkWeight
	 * @param percent
	 */
	public ReportByMonth(int month, int milkWeight, double percent) {
		this.month = month;
		this.milkWeight = milkWeight;
		this.percent = (int)(Math.round(percent * 100))/100.0;//Show only two digit after decimal

		report = "Month: " + month + ", " + milkWeight + " lbs" + ", " + this.percent + " %";
		
	}
	
	/**
	 * getter method to return report
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
	public int getMonth() {
		return month;
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
