/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class a single line data of .csv files
 * includes: year, month, day, farm ID, weight
 */
package application;
/**
 * A data structure that stores data from single line 
 * of the input file, representing a single day record
 *  of a farm
 * @author Hong Xu
 *
 */
public class SingleDayMilk {

	private int year;
	private int month;
	private int day;
	private String farm_id;
	private int milk_weight;
	
	/**
	 * Constructor
	 * @param times an int array containing year, month, day
	 * @param id	the farm ID
	 * @param weight the weight of milk (lbs)
	 */
	public SingleDayMilk(int[] times, String id, int weight) {
		year = times[0];
		month = times[1];
		day = times[2];
		farm_id = id;
		milk_weight = weight;
	}
	
	/**
	 * getter method for year
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * getter method for month
	 * @return
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * getter method for day
	 * @return day
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * getter method for farm ID
	 * @return farm_id
	 */
	public String getID() {
		return farm_id;
	}
	
	/**
	 * getter method for milk weight
	 * @return milk_weight
	 */
	public int getWeight() {
		return milk_weight;
	}
	
	
	
	
	
	
	
	
}
