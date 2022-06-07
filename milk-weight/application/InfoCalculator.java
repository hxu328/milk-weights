/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to calculate results based on
 * types of reports needed
 */
package application;

import java.util.ArrayList;
/**
 * a class can get statistical data 
 * through traversing the ArrayList 
 * of SingleDayMilk instances 
 * @author Hong Xu
 *
 */
public class InfoCalculator {
	private ArrayList<SingleDayMilk> days;
	
	/**
	 * private helper method to add every farm name within the period
	 * @param ids a list of farm names
	 * @param id farm names
	 */
	private void addID(ArrayList<String> ids, String id){
		for(int i = 0; i < ids.size(); i++) {
			if(ids.get(i).equals(id)) {
				return;
			}
		}
		ids.add(id);
	}
	
	/**
	 * constructor
	 * @param days list of data which have been read in from the files
	 */
	public InfoCalculator(ArrayList<SingleDayMilk> days) {
		this.days = days;
	}
	
	/**
	 * generate a list of farm reports based on the given name and year
	 * @param name farm name
	 * @param year a specific year
	 * @return an ArrayList of farm reports
	 */
	public ArrayList<ReportByMonth> getFarmReports(String name, int year){
		ArrayList<ReportByMonth> reports = new ArrayList<ReportByMonth>();
		int total_1 = 0;
		int total_2 = 0;
		int total_3 = 0;
		int total_4 = 0;
		int total_5 = 0;
		int total_6 = 0;
		int total_7 = 0;
		int total_8 = 0;
		int total_9 = 0;
		int total_10 = 0;
		int total_11 = 0;
		int total_12 = 0;
		for(int i = 0; i < days.size(); i++) {
			if(days.get(i).getID().equals(name) && days.get(i).getYear() == year) {
				switch(days.get(i).getMonth()) {
					case 1:
						total_1 += days.get(i).getWeight();
						break;
					case 2:
						total_2 += days.get(i).getWeight();
						break;
					case 3:
						total_3 += days.get(i).getWeight();
						break;
					case 4:
						total_4 += days.get(i).getWeight();
						break;
					case 5:
						total_5 += days.get(i).getWeight();
						break;
					case 6:
						total_6 += days.get(i).getWeight();
						break;
					case 7:
						total_7 += days.get(i).getWeight();
						break;
					case 8:
						total_8 += days.get(i).getWeight();
						break;
					case 9:
						total_9 += days.get(i).getWeight();
						break;
					case 10:
						total_10 += days.get(i).getWeight();
						break;
					case 11:
						total_11 += days.get(i).getWeight();
						break;
					case 12:
						total_12 += days.get(i).getWeight();
						break;
					default:
						break;
					
				}
			}
		}
		// compute the total weight for 12 months
		int totalWeight = total_1 + total_2 + total_3 + total_4 + total_5 + total_6 +
				total_7 + total_8 + total_9 + total_10 + total_11 + total_12;
		// add reports to the ArrayList<ReportByMonth>
		reports.add(new ReportByMonth(1, total_1, 100 * ((double)total_1)/((double)totalWeight)));
		reports.add(new ReportByMonth(2, total_2, 100 * ((double)total_2)/((double)totalWeight)));
		reports.add(new ReportByMonth(3, total_3, 100 *((double)total_3)/((double)totalWeight)));
		reports.add(new ReportByMonth(4, total_4, 100 * ((double)total_4)/((double)totalWeight)));
		reports.add(new ReportByMonth(5, total_5, 100 * ((double)total_5)/((double)totalWeight)));
		reports.add(new ReportByMonth(6, total_6, 100 * ((double)total_6)/((double)totalWeight)));
		reports.add(new ReportByMonth(7, total_7, 100 * ((double)total_7)/((double)totalWeight)));
		reports.add(new ReportByMonth(8, total_8, 100 * ((double)total_8)/((double)totalWeight)));
		reports.add(new ReportByMonth(9, total_9, 100 * ((double)total_9)/((double)totalWeight)));
		reports.add(new ReportByMonth(10, total_10, 100 * ((double)total_10)/((double)totalWeight)));
		reports.add(new ReportByMonth(11, total_11, 100 * ((double)total_11)/((double)totalWeight)));
		reports.add(new ReportByMonth(12, total_12, 100 * ((double)total_12)/((double)totalWeight)));
		
		return reports;
		
	}
	
	/**
	 * generate a list of annual reports based on the given year
	 * @param year a specific year
	 * @return an ArrayList of annual reports
	 */
	public ArrayList<ReportById> getAnnualReports(int year){
		if(days.size() == 0) return null;
		ArrayList<ReportById> reports = new ArrayList<ReportById>();
		ArrayList<String> ids = new ArrayList<String>();
		
		
		String id = days.get(0).getID();
		ids.add(id);
		
		//store different IDs
		for(int i = 0; i<days.size(); i++) {
			addID(ids, days.get(i).getID());
		}
		
		//store milk weight for different IDs
		int[] weights = new int[ids.size()];
		for(int i = 0; i<days.size(); i++) {
			//check the year
			if(days.get(i).getYear() == year) {
				for(int j = 0; j < ids.size(); j++) {
					if(ids.get(j).equals(days.get(i).getID())) {
						weights[j] += days.get(i).getWeight();
					}
				}
			}
		}
		
		//store percent for different IDs
		double[] percents = new double[weights.length];
		int totalWeight = 0;
		for(int i = 0; i < weights.length; i++) {
			totalWeight += weights[i];//compute the total weight for all farms
		}
		for(int i = 0; i < percents.length; i++) {
			percents[i] = 100 * ((double)weights[i])/((double)totalWeight); //store percent for all farms
		}
		
		//add reports to an ArrayList;
		for(int i = 0; i < ids.size(); i++) {
			reports.add(new ReportById(ids.get(i), weights[i], percents[i]));
		}
		
		return reports;
	}
	
	/**
	 * generate a list of monthly report based on the given year and month
	 * @param year a specific year
	 * @param month a specific month
	 * @return an ArrayList of montly reports
	 */
	public ArrayList<ReportById> getMonthlyReport(int year, int month){
		if(days.size() == 0) return null;
		ArrayList<ReportById> reports = new ArrayList<ReportById>();
		ArrayList<String> ids = new ArrayList<String>();
		
		
		String id = days.get(0).getID();
		ids.add(id);
		
		//store different IDs
		for(int i = 0; i<days.size(); i++) {
			addID(ids, days.get(i).getID());
		}
		
		//store milk weight for different IDs
		int[] weights = new int[ids.size()];
		for(int i = 0; i<days.size(); i++) {
			//check the year and month
			if(days.get(i).getYear() == year && days.get(i).getMonth() == month) {
				for(int j = 0; j < ids.size(); j++) {
					if(ids.get(j).equals(days.get(i).getID())) {
						weights[j] += days.get(i).getWeight();
					}
				}
			}
		}
		
		//store percent for different IDs
		double[] percents = new double[weights.length];
		int totalWeight = 0;
		for(int i = 0; i < weights.length; i++) {
			totalWeight += weights[i];//compute the total weight for all farms
		}
		for(int i = 0; i < percents.length; i++) {
			percents[i] = 100 * ((double)weights[i])/((double)totalWeight); //store percent for all farms
		}
		
		//add reports to an ArrayList;
		for(int i = 0; i < ids.size(); i++) {
			reports.add(new ReportById(ids.get(i), weights[i], percents[i]));
		}
		
		return reports;
	}

	/**
	 * generate a list of date range report based on the start date and end date
	 * @param start_year  the start year
	 * @param start_month the start month
	 * @param start_day   the start day
	 * @param end_year    the end year
	 * @param end_month   the end month
	 * @param end_day     the end day
	 * @return an ArrayList of date range reports
	 */
	public ArrayList<ReportById> getDateRangeReport(int start_year, int start_month, int start_day,
			int end_year, int end_month, int end_day){
		if(days.size() == 0) return null;
		ArrayList<ReportById> reports = new ArrayList<ReportById>();
		ArrayList<String> ids = new ArrayList<String>();
		
		
		String id = days.get(0).getID();
		ids.add(id);
		
		//store different IDs
		for(int i = 0; i<days.size(); i++) {
			addID(ids, days.get(i).getID());
		}
		
		//store milk weight for different IDs
		int[] weights = new int[ids.size()];
		for(int i = 0; i<days.size(); i++) {
			//check the start date and end date
			if((!(
				(days.get(i).getYear() < start_year) || 
				((days.get(i).getYear() == start_year) && (days.get(i).getMonth() < start_month)) ||
				((days.get(i).getYear() == start_year) && (days.get(i).getMonth() == start_month)
						&& (days.get(i).getDay() < start_day )))) &&
					
			   (!(
				(days.get(i).getYear() > end_year) ||
				((days.get(i).getYear() == end_year) && (days.get(i).getMonth() >end_month)) ||
				((days.get(i).getYear() == end_year) && (days.get(i).getMonth() == end_month)
						&& (days.get(i).getDay() > end_day ))))) {
				for(int j = 0; j < ids.size(); j++) {
					if(ids.get(j).equals(days.get(i).getID())) {
						weights[j] += days.get(i).getWeight();
					}
				}
			}
		}
		
		//store percent for different IDs
		double[] percents = new double[weights.length];
		int totalWeight = 0;
		for(int i = 0; i < weights.length; i++) {
			totalWeight += weights[i];//compute the total weight for all farms
		}
		for(int i = 0; i < percents.length; i++) {
			percents[i] = 100 * ((double)weights[i])/((double)totalWeight); //store percent for all farms
		}
		
		//add reports to an ArrayList;
		for(int i = 0; i < ids.size(); i++) {
			reports.add(new ReportById(ids.get(i), weights[i], percents[i]));
		}
		
		return reports;
	}
}
