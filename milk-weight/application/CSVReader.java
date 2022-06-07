/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a class to read data from .csv files
 */
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Read data from files into an 
 * ArrayList of SingleDayMilk instances
 * @author Hong Xu
 *
 */
public class CSVReader {
	private ArrayList<SingleDayMilk> days;
	private String fileName;
	private Scanner s;
	
	
	
	/**
	 * constructor
	 */
	public CSVReader() {
		days = new ArrayList();
		fileName = null;
	}
	
	/**
	 * read data from CSV files  and store data into ArrayList
	 * @param fileName name of file
	 * @throws Exception 
	 */
	public void readIn(String fileName) throws Exception {
		try{
			File file = new File(fileName);
			s = new Scanner(file);
			
			while(s.hasNextLine()) {
				String singleLine = s.nextLine();//raw string of a single line
				String[] singleDayData = singleLine.split(","); // splitted strings
				if(singleDayData.length != 3) {// skip if does not has 3 column
					continue;
				}
				
				String[] date = singleDayData[0].split("-");
				if(date.length != 3) {// skip if the first column cannot be splitted into 3 parts
					continue;
				}
				
				try {// skip if the first part of the first column does not represent a year
			        Integer.parseInt(date[0]);
			    }catch(Exception e) {
			        continue;
			    }
				
				try {// skip if the second part of the first column does not represent a month
			        int month = Integer.parseInt(date[1]);
			        if(month < 1 || month > 12) {
			        	continue;
			        }
			    }catch(Exception e) {
			        continue;
			    }
				
				try {// skip if the third part of the first column does not represent a day
			        int day = Integer.parseInt(date[2]);
			        if(day < 1 || day > 31) {
			        	continue;
			        }
			    }catch(Exception e) {
			        continue;
			    }
				
				try {// skip if the third column does not represent a milk weight
					int weight = Integer.parseInt(singleDayData[2]);
					if(weight < 0) {
						continue;
					}
				}catch(Exception e) {
					continue;
				}
				
				int[] time = new int[3];
				String farmId = singleDayData[1];
				int weight = Integer.parseInt(singleDayData[2]);
				for(int i = 0; i < 3; i++) {
					time[i] = Integer.parseInt(date[i]);
				}
				days.add(new SingleDayMilk(time, farmId, weight));
				
			}
		}catch(Exception e) {
			throw new Exception();
		}finally {
			if(s != null) {
				s.close();
			}
		}
		
		
	}
	
	/**
	 * remove data with specific farm ID
	 * @param farmID the name of farm needed to remove
	 * @throws Exception if there is no such farm ID
	 */
	public void removeFarm(String farmID) throws Exception {
		int count = 0;
		for(int i = 0; i < this.days.size(); i ++) {
			if(days.get(i).getID().equals(farmID)) {
				days.remove(days.get(i));
				i --;
				count ++;
			}
		}
		if(count == 0) {
			throw new Exception();//throw an exception if there is no existing farm ID in the data
		}
	}
	
	/**
	 * getter method to get data
	 * @return days
	 */
	public ArrayList<SingleDayMilk> getDays(){
		return days;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
