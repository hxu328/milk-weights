/**
 * CS400 project name: Milk Weight
 * Lecture Number: 002
 * Name: Hong Xu
 * Email: hxu328@wisc.edu
 * this is a main class to run the GUI
 */
package application;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * main class to run the GUI
 * @author Hong Xu
 *
 */
public class Main extends Application {
	
	/**
	 * display farm reports sorted by weight
	 * (A single farm report: month, weight, percent)
	 * @param reportsVBox 
	 * @param csvReader
	 * @param name
	 * @param year
	 */
	private void displaySortedByWeight_FR(VBox reportsVBox, CSVReader csvReader, String name, int year){
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		
		if(!(Check.hasName(days, name) && Check.hasYear(days, year))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid name or year");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportByMonth> farmReports = calculator.getFarmReports(name, year);
		SortByWeight_FR.sortWeight(farmReports);
		for(int i = 0; i < farmReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(farmReports.get(i).getReport()));
		}
		
	}
	
	/**
	 * display farm reports sorted by month
	 * (A single farm report: month, weight, percent)
	 * @param reportsVBox
	 * @param csvReader
	 * @param name
	 * @param year
	 */
	private void displaySortedByMonth_FR(VBox reportsVBox, CSVReader csvReader, String name, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		
		if(!(Check.hasName(days, name) && Check.hasYear(days, year))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid name or year");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportByMonth> farmReports = calculator.getFarmReports(name, year);
		SortByMonth.sortMonth(farmReports);
		for(int i = 0; i < farmReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(farmReports.get(i).getReport()));
		}
	}
	
	/**
	 * display annual reports sorted by weight
	 * (A single annually report: farm ID, weight, percent)
	 * @param reportsVBox
	 * @param csvReader
	 * @param year
	 */
	private void displaySortedByWeight_AR(VBox reportsVBox, CSVReader csvReader, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		
		if(!Check.hasYear(days, year)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> annualReports = calculator.getAnnualReports(year);
		SortByWeight_PR.sortWeight(annualReports);
		for(int i = 0; i < annualReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(annualReports.get(i).getReport()));
		}
		
	}
	
	/**
	 * display annual reports sorted by farm ID
	 * (A single annually report: farm ID, weight, percent)
	 * @param reportsVBox
	 * @param csvReader
	 * @param year
	 */
	private void displaySortedByID_AR(VBox reportsVBox, CSVReader csvReader, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		
		if(!Check.hasYear(days, year)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> annualReports = calculator.getAnnualReports(year);
		SortById.sortId(annualReports);
		for(int i = 0; i < annualReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(annualReports.get(i).getReport()));
		}
	}
	
	/**
	 * display monthly reports sorted by weight
	 * (A single monthly report: farm ID, weight, percent)
	 * @param reportsVBox
	 * @param csvReader
	 * @param year
	 * @param month
	 */
	private void displaySortedByWeight_MR(VBox reportsVBox, CSVReader csvReader, int year, int month) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		
		if(!Check.hasMonth(days, year, month)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year and month pair");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> monthlyReports = calculator.getMonthlyReport(year, month);
		SortByWeight_PR.sortWeight(monthlyReports);
		for(int i = 0; i < monthlyReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(monthlyReports.get(i).getReport()));
		}
	}
	
	/**
	 * display monthly reports sorted by farm ID
	 * (A single monthly report: farm ID, weight, percent)
	 * @param reportsVBox
	 * @param csvReader
	 * @param year
	 * @param month
	 */
	private void displaySortedByID_MR(VBox reportsVBox, CSVReader csvReader, int year, int month) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		
		if(!Check.hasMonth(days, year, month)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year and month pair");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> monthlyReports = calculator.getMonthlyReport(year, month);
		SortById.sortId(monthlyReports);
		for(int i = 0; i < monthlyReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(monthlyReports.get(i).getReport()));
		}
	}
	
	/**
	 * display date range reports sorted by weight
	 * (A single date range report: farm ID, weight, percent)
	 * @param reportsVBox
	 * @param csvReader
	 * @param start_year
	 * @param start_month
	 * @param start_day
	 * @param end_year
	 * @param end_month
	 * @param end_day
	 */
	private void displaySortedByWeight_DR(VBox reportsVBox, CSVReader csvReader, int start_year, 
			int start_month, int start_day, int end_year, int end_month, int end_day) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		if((start_year > end_year) || ((start_year == end_year) && (start_month > end_month)) ||
				((start_year == end_year) && (start_month == end_month) && (start_day > end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "End date should not be earlier than start date!");
			alert.showAndWait();
			return;
		}
		
		if(!(Check.hasDate(start_month, start_day) && Check.hasDate(end_month, end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid month or day number!");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> dateRangeReports = calculator.getDateRangeReport(start_year, start_month, start_day, end_year, end_month, end_day);
		SortByWeight_PR.sortWeight(dateRangeReports);
		for(int i = 0; i < dateRangeReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(dateRangeReports.get(i).getReport()));
		}
	}
	
	/**
	 * display date range reports sorted by farm ID
	 * (A single date range report: farm ID, weight, percent)
	 * @param reportsVBox
	 * @param csvReader
	 * @param start_year
	 * @param start_month
	 * @param start_day
	 * @param end_year
	 * @param end_month
	 * @param end_day
	 */
	private void displaySortedByID_DR(VBox reportsVBox, CSVReader csvReader, int start_year, 
			int start_month, int start_day, int end_year, int end_month, int end_day) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		if((start_year > end_year) || ((start_year == end_year) && (start_month > end_month)) ||
				((start_year == end_year) && (start_month == end_month) && (start_day > end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "End date should not be earlier than start date!");
			alert.showAndWait();
			return;
		}
		
		if(!(Check.hasDate(start_month, start_day) && Check.hasDate(end_month, end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid month or day number!");
			alert.showAndWait();
			return;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> dateRangeReports = calculator.getDateRangeReport(start_year, start_month, start_day, end_year, end_month, end_day);
		SortById.sortId(dateRangeReports);
		for(int i = 0; i < dateRangeReports.size(); i++) {
			reportsVBox.getChildren().add(new Label(dateRangeReports.get(i).getReport()));
		}
	}
	
	/**
	 * get minimum weight of farm reports
	 * @param csvReader
	 * @param name
	 * @param year
	 * @return minimum weight
	 */
	private int getMin_FR(CSVReader csvReader, String name, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int min;
		if(!(Check.hasName(days, name) && Check.hasYear(days, year))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid name or year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportByMonth> farmReports = calculator.getFarmReports(name, year);
		min = MinWeight.getMinWeight_FR(farmReports);
		return min;
	}
	
	/**
	 * get maximum weight of farm reports
	 * @param csvReader
	 * @param name
	 * @param year
	 * @return maximum weight
	 */
	private int getMax_FR(CSVReader csvReader, String name, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int max;
		if(!(Check.hasName(days, name) && Check.hasYear(days, year))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid name or year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportByMonth> farmReports = calculator.getFarmReports(name, year);
		max = MaxWeight.getMaxWeight_FR(farmReports);
		return max;
	}
	
	/**
	 * get average weight of farm reports
	 * @param csvReader
	 * @param name
	 * @param year
	 * @return average weight
	 */
	private int getAverage_FR(CSVReader csvReader, String name, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int average;
		if(!(Check.hasName(days, name) && Check.hasYear(days, year))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid name or year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportByMonth> farmReports = calculator.getFarmReports(name, year);
		average = AverageWeight.getAverageWeight_FR(farmReports);
		return average;
	}
	
	/**
	 * get total weight of farm reports
	 * @param csvReader
	 * @param name
	 * @param year
	 * @return total weight
	 */
	private int getTotal_FR(CSVReader csvReader, String name, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int total;
		if(!(Check.hasName(days, name) && Check.hasYear(days, year))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid name or year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportByMonth> farmReports = calculator.getFarmReports(name, year);
		total = TotalWeight.getTotalWeight_FR(farmReports);
		return total;
	}
	
	/**
	 * get minimum weight of annual reports
	 * @param csvReader
	 * @param year
	 * @return minimum weight
	 */
	private int getMin_AR(CSVReader csvReader, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int min;
		if(!Check.hasYear(days, year)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> annualReports = calculator.getAnnualReports(year);
		min = MinWeight.getMinWeight_PR(annualReports);
		return min;
	}
	
	/**
	 * get maximum weight of annual reports
	 * @param csvReader
	 * @param year
	 * @return maximum weight
	 */
	private int getMax_AR(CSVReader csvReader, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int max;
		if(!Check.hasYear(days, year)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> annualReports = calculator.getAnnualReports(year);
		max = MaxWeight.getMaxWeight_PR(annualReports);
		return max;
	}
	
	/**
	 * get average weight of annual reports
	 * @param csvReader
	 * @param year
	 * @return average weight
	 */
	private int getAverage_AR(CSVReader csvReader, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int average;
		if(!Check.hasYear(days, year)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> annualReports = calculator.getAnnualReports(year);
		average = AverageWeight.getAverageWeight_PR(annualReports);
		return average;
	}
	
	/**
	 * get total weight of annual reports
	 * @param csvReader
	 * @param year
	 * @return total weight
	 */
	private int getTotal_AR(CSVReader csvReader, int year) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int total;
		if(!Check.hasYear(days, year)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> annualReports = calculator.getAnnualReports(year);
		total = TotalWeight.getTotalWeight_PR(annualReports);
		return total;
	}
	
	/**
	 * get minimum weight of monthly reports
	 * @param csvReader
	 * @param year
	 * @param month
	 * @return minimum weight
	 */
	private int getMin_MR(CSVReader csvReader, int year, int month) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int min;
		if(!Check.hasMonth(days, year, month)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year and month pair");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> monthlyReports = calculator.getMonthlyReport(year, month);
		min = MinWeight.getMinWeight_PR(monthlyReports);
		return min;
	}
	
	/**
	 * get maximum weight of monthly reports
	 * @param csvReader
	 * @param year
	 * @param month
	 * @return maximum weight
	 */
	private int getMax_MR(CSVReader csvReader, int year, int month) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int max;
		if(!Check.hasMonth(days, year, month)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year and month pair");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> monthlyReports = calculator.getMonthlyReport(year, month);
		max = MaxWeight.getMaxWeight_PR(monthlyReports);
		return max;
	}
	
	/**
	 * get average weight of monthly reports
	 * @param csvReader
	 * @param year
	 * @param month
	 * @return average weight
	 */
	private int getAverage_MR(CSVReader csvReader, int year, int month) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int average;
		if(!Check.hasMonth(days, year, month)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year and month pair");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> monthlyReports = calculator.getMonthlyReport(year, month);
		average = AverageWeight.getAverageWeight_PR(monthlyReports);
		return average;
	}
	
	/**
	 * get total weight of monthly reports
	 * @param csvReader
	 * @param year
	 * @param month
	 * @return total weight
	 */
	private int getTotal_MR(CSVReader csvReader, int year, int month) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int total;
		if(!Check.hasMonth(days, year, month)) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid year and month pair");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> monthlyReports = calculator.getMonthlyReport(year, month);
		total = TotalWeight.getTotalWeight_PR(monthlyReports);
		return total;
	}
	
	/**
	 * get minimum weight of date range reports
	 * @param csvReader
	 * @param start_year
	 * @param start_month
	 * @param start_day
	 * @param end_year
	 * @param end_month
	 * @param end_day
	 * @return minimum weight of date range reports
	 */
	private int getMin_DR(CSVReader csvReader, int start_year, 
			int start_month, int start_day, int end_year, int end_month, int end_day) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int min;
		if((start_year > end_year) || ((start_year == end_year) && (start_month > end_month)) ||
				((start_year == end_year) && (start_month == end_month) && (start_day > end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "End date should not be earlier than start date!");
			alert.showAndWait();
			return -1;
		}
		
		if(!(Check.hasDate(start_month, start_day) && Check.hasDate(end_month, end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid month or day number!");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> dateRangeReports = calculator.getDateRangeReport(start_year, start_month, start_day, end_year, end_month, end_day);
		min = MinWeight.getMinWeight_PR(dateRangeReports);
		return min;
	}
	
	/**
	 * get max weight of date range reports
	 * @param csvReader
	 * @param start_year
	 * @param start_month
	 * @param start_day
	 * @param end_year
	 * @param end_month
	 * @param end_day
	 * @return max weight
	 */
	private int getMax_DR(CSVReader csvReader, int start_year, 
			int start_month, int start_day, int end_year, int end_month, int end_day) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int max;
		if((start_year > end_year) || ((start_year == end_year) && (start_month > end_month)) ||
				((start_year == end_year) && (start_month == end_month) && (start_day > end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "End date should not be earlier than start date!");
			alert.showAndWait();
			return -1;
		}
		
		if(!(Check.hasDate(start_month, start_day) && Check.hasDate(end_month, end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid month or day number!");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> dateRangeReports = calculator.getDateRangeReport(start_year, start_month, start_day, end_year, end_month, end_day);
		max = MaxWeight.getMaxWeight_PR(dateRangeReports);
		return max;
	}
	
	/**
	 * get average weight of date range reports
	 * @param csvReader
	 * @param start_year
	 * @param start_month
	 * @param start_day
	 * @param end_year
	 * @param end_month
	 * @param end_day
	 * @return average weight of date
	 */
	private int getAverage_DR(CSVReader csvReader, int start_year, 
			int start_month, int start_day, int end_year, int end_month, int end_day) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int average;
		if((start_year > end_year) || ((start_year == end_year) && (start_month > end_month)) ||
				((start_year == end_year) && (start_month == end_month) && (start_day > end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "End date should not be earlier than start date!");
			alert.showAndWait();
			return -1;
		}
		
		if(!(Check.hasDate(start_month, start_day) && Check.hasDate(end_month, end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid month or day number!");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> dateRangeReports = calculator.getDateRangeReport(start_year, start_month, start_day, end_year, end_month, end_day);
		average = AverageWeight.getAverageWeight_PR(dateRangeReports);
		return average;
	}
	
	/**
	 * get total weight of date range reports
	 * @param csvReader
	 * @param start_year
	 * @param start_month
	 * @param start_day
	 * @param end_year
	 * @param end_month
	 * @param end_day
	 * @return total weight
	 */
	private int getTotal_DR(CSVReader csvReader, int start_year, 
			int start_month, int start_day, int end_year, int end_month, int end_day) {
		ArrayList<SingleDayMilk> days = csvReader.getDays();
		int total;
		if((start_year > end_year) || ((start_year == end_year) && (start_month > end_month)) ||
				((start_year == end_year) && (start_month == end_month) && (start_day > end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "End date should not be earlier than start date!");
			alert.showAndWait();
			return -1;
		}
		
		if(!(Check.hasDate(start_month, start_day) && Check.hasDate(end_month, end_day))) {
			Alert alert = new Alert(AlertType.ERROR, 
                    "Invalid month or day number!");
			alert.showAndWait();
			return -1;
		}
		InfoCalculator calculator = new InfoCalculator(days);
		ArrayList<ReportById> dateRangeReports = calculator.getDateRangeReport(start_year, start_month, start_day, end_year, end_month, end_day);
		total = TotalWeight.getTotalWeight_PR(dateRangeReports);
		return total;
	}
	
	/**
	 * an override method to run the GUI
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Scene 1: Home Page
		ArrayList<String> fileNames= new ArrayList<String>();
		CSVReader csvReader = new CSVReader();
		primaryStage.setTitle("Milk Weight Home Page");
		BorderPane mainPane = new BorderPane();
		Label introLabel = new Label("Welcome to Milk Weight!");
		introLabel.setFont(new Font("Arial", 24));
		mainPane.setTop(introLabel);
		Scene mainScene = new Scene(mainPane, 600, 500);
		primaryStage.setScene(mainScene);
		Label file_Label = new Label("Please enter the absolute path of your csv file to load data:");
		Label farm_Label = new Label("You can remove a specifc farm by entering its name:");
		TextField farmID_Field = new TextField();
		Button farm_removeButton = new Button("Remove");
		TextField fileField = new TextField();
		VBox fileLabels = new VBox();
		VBox farmIDLabels = new VBox();
		//Home Page: "Add" Button, "Remove Button
		Button addButton = new Button("Add");
		addButton.setOnAction(event -> {
			String userFile = fileField.getText();
			if(fileNames.contains(userFile)) {
				Alert alert = new Alert(AlertType.ERROR, 
                        "Do not enter an existing file name!");
				alert.showAndWait();
				return;
			}
			try {
				csvReader.readIn(userFile);
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR, 
                        "File is not found!");
				alert.showAndWait();
				return;
			}
			fileNames.add(userFile);
			Label file = new Label(userFile + " is loaded");
			fileLabels.getChildren().add(file);
		}
				);
		farm_removeButton.setOnAction(event ->{
			String userFarm = farmID_Field.getText();
			try {
				csvReader.removeFarm(userFarm);
				farmIDLabels.getChildren().add(new Label(userFarm + " is moved"));
			}catch(Exception e) {
				Alert alert = new Alert(AlertType.ERROR, 
                        "Farm is not existing");
				alert.showAndWait();
				return;
			}
		});
		
		
		
		HBox hBox_1 = new HBox();
		hBox_1.getChildren().add(file_Label);
		hBox_1.getChildren().add(fileField);
		hBox_1.getChildren().add(addButton);
		HBox hBox_2 = new HBox();
		hBox_2.getChildren().add(farm_Label);
		hBox_2.getChildren().add(farmID_Field);
		hBox_2.getChildren().add(farm_removeButton);
		VBox main_vbox = new VBox();
		main_vbox.getChildren().add(hBox_1);
		main_vbox.getChildren().add(hBox_2);
		main_vbox.getChildren().add(fileLabels);
		main_vbox.getChildren().add(farmIDLabels);
		mainPane.setLeft(main_vbox);
		
		
    	
    	
    	//Home Page: "Continue" and "Close" Buttons
    	Button ContinueButton = new Button("Continue");
    	Button CloseButton = new Button("Close");
    	HBox homeButtons = new HBox();
    	homeButtons.getChildren().add(ContinueButton);
    	homeButtons.getChildren().add(CloseButton);
    	CloseButton.setOnAction(event -> primaryStage.close());
    	mainPane.setBottom(homeButtons);
    	
    	//Scene 2: Select Page
    	BorderPane selectPane = new BorderPane();
    	Scene selectScene = new Scene(selectPane, 300, 200);
    	ContinueButton.setOnAction(event ->{
    		primaryStage.setScene(selectScene);
    		primaryStage.setTitle("Select Type of Report");
    	}
    			);
    	Button farmButton = new Button("Farm Report");
    	Button annualButton = new Button("Annual Report");
    	Button monthlyButton = new Button("Monthly Report");
    	Button rangeButton = new Button("Date Range Report");
    	GridPane selectGrid = new GridPane();
    	selectGrid.add(farmButton, 0, 0);
    	selectGrid.add(annualButton, 1, 0);
    	selectGrid.add(monthlyButton, 0, 1);
    	selectGrid.add(rangeButton, 1, 1);
    	Insets gridPadding = null;
    	gridPadding = new Insets(15, 15, 15, 15); // Padding values for top, right, bottom, and left
        selectGrid.setPadding(gridPadding);         // Set padding around  grid
        selectGrid.setHgap(15);                     // Spacing between columns
        selectGrid.setVgap(15); 
    	selectPane.setCenter(selectGrid);
    	
    	Button selectHome = new Button("Home");
    	Button selectClose = new Button("Close");
    	HBox selectHBox = new HBox();
    	selectHBox.getChildren().add(selectHome);
    	selectHBox.getChildren().add(selectClose);
    	selectPane.setBottom(selectHBox);
    	
    	//Select Page: set button actions
    	selectHome.setOnAction(event ->{
    		primaryStage.setScene(mainScene);
    		primaryStage.setTitle("Milk Weight Home Page");
    	});
    	selectClose.setOnAction(event ->{
    		primaryStage.close();
    	});
    	
    	//Scene 3: Farm Report page
    	BorderPane farmPane = new BorderPane();
    	Scene farmScene = new Scene(farmPane, 500, 400);
    	
    	
    	Label farmIDLabel = new Label("Please Enter the Farm ID:");
    	Label farmYearLabel = new Label("Please Enthe the Year:");
    	TextField farmIDField = new TextField();
    	farmIDField.setEditable(true);
    	farmIDField.setPrefColumnCount(4);
    	TextField farmYearField = new TextField();
    	farmYearField.setEditable(true);
    	farmYearField.setPrefColumnCount(4);
    	Button farmSortWeight = new Button("Sort by Weight");
    	Button farmSortMonth = new Button("Sort by Month");
    	Button farmMin = new Button("Min");
    	Button farmMax = new Button("Max");
    	Button farmAverage = new Button("Average");
    	Button farmTotal = new Button("Total");
    	TextField farmValue = new TextField();
    	farmValue.setEditable(false);
    	farmValue.setPrefColumnCount(8);
    	VBox farmReportsVBox = new VBox();
    	Button farmHome = new Button("Home");
    	Button farmClose = new Button("Close");
    	HBox farmHBox = new HBox();
    	GridPane farmGrid = new GridPane();
    	HBox h1 = new HBox();
    	h1.getChildren().add(farmIDLabel);
    	h1.getChildren().add(farmIDField);
    	HBox h2 = new HBox();
    	h2.getChildren().add(farmYearLabel);
    	h2.getChildren().add(farmYearField);
    	farmGrid.add(h1, 0, 0);
    	farmGrid.add(h2, 0, 1);
    	farmGrid.add(farmSortWeight, 0, 2);
    	farmGrid.add(farmSortMonth, 0, 3);
    	HBox h = new HBox();
    	h.getChildren().add(farmMin);
    	h.getChildren().add(farmMax);
    	h.getChildren().add(farmAverage);
    	h.getChildren().add(farmTotal);
    	h.getChildren().add(farmValue);
    	farmGrid.add(h, 0, 4);
    	
    	farmGrid.setPadding(gridPadding);
    	farmGrid.setHgap(15);
    	farmGrid.setVgap(15);
    	
    	farmHBox.getChildren().add(farmHome);
    	farmHBox.getChildren().add(farmClose);
    	farmPane.setLeft(farmGrid);;
    	farmPane.setBottom(farmHBox);
    	farmPane.setRight(farmReportsVBox);
    	
    	farmButton.setOnAction(event ->{
    		primaryStage.setScene(farmScene);
    		primaryStage.setTitle("Farm Report");
    	});
    	
    	//Farm Report Page: set actions
    	farmHome.setOnAction(event->{
    		primaryStage.setScene(mainScene);
    		primaryStage.setTitle("Milk Weight Home Page");
    	});
    	farmClose.setOnAction(event->{primaryStage.close();});
    	farmSortWeight.setOnAction(event->{
    		farmReportsVBox.getChildren().clear();
    		String name = farmIDField.getText();
    		int year = Integer.parseInt(farmYearField.getText());
    		displaySortedByWeight_FR(farmReportsVBox, csvReader, name, year);
    	});
    	farmSortMonth.setOnAction(event->{
    		farmReportsVBox.getChildren().clear();
    		String name = farmIDField.getText();
    		int year = Integer.parseInt(farmYearField.getText());
    		displaySortedByMonth_FR(farmReportsVBox, csvReader, name, year);
    	});
    	farmMin.setOnAction(event->{
    		int min;
    		String name = farmIDField.getText();
    		int year = Integer.parseInt(farmYearField.getText());
    		min = getMin_FR(csvReader, name, year);
    		farmValue.setText(Integer.toString(min));
    		
    	});
    	farmMax.setOnAction(event->{
    		int max;
    		String name = farmIDField.getText();
    		int year = Integer.parseInt(farmYearField.getText());
    		max = getMax_FR(csvReader, name, year);
    		farmValue.setText(Integer.toString(max));
    	});
    	farmAverage.setOnAction(event ->{
    		int average;
    		String name = farmIDField.getText();
    		int year = Integer.parseInt(farmYearField.getText());
    		average = getAverage_FR(csvReader, name, year);
    		farmValue.setText(Integer.toString(average));
    	});
    	farmTotal.setOnAction(event ->{
    		int total;
    		String name = farmIDField.getText();
    		int year = Integer.parseInt(farmYearField.getText());
    		total = getTotal_FR(csvReader, name, year);
    		farmValue.setText(Integer.toString(total));
    	});
    	
    	//Scene 4: Annual Report Page
    	BorderPane annualPane = new BorderPane();
    	Scene annualScene = new Scene(annualPane, 500, 400);
    	
    	
    	Label annualYearLabel = new Label("Please Enter the Year:");
    	TextField annualField = new TextField();
    	annualField.setEditable(true);
    	annualField.setPrefColumnCount(4);
    	TextField annualValue = new TextField();
    	annualValue.setEditable(false);
    	annualValue.setPrefColumnCount(8);
    	Button annualSortWeight = new Button("Sort by Weight");
    	Button annualSortID = new Button("Sort by Farm ID");
    	Button annualMin = new Button("Min");
    	Button annualMax = new Button("Max");
    	Button annualAverage = new Button("Average");
    	Button annualTotal = new Button("Total");
    	Button annualHome = new Button("Home");
    	Button annualClose = new Button("Close");
    	HBox annual_h1 = new HBox();
    	annual_h1.getChildren().add(annualYearLabel);
    	annual_h1.getChildren().add(annualField);
    	HBox annual_h2 = new HBox();
    	annual_h2.getChildren().add(annualMin);
    	annual_h2.getChildren().add(annualMax);
    	annual_h2.getChildren().add(annualAverage);
    	annual_h2.getChildren().add(annualTotal);
    	annual_h2.getChildren().add(annualValue);
    	HBox annual_h3 = new HBox();
    	annual_h3.getChildren().add(annualHome);
    	annual_h3.getChildren().add(annualClose);
    	GridPane annualGrid = new GridPane();
    	annualGrid.add(annual_h1, 0, 0);
    	annualGrid.add(annualSortWeight, 0, 1);
    	annualGrid.add(annualSortID, 0, 2);
    	annualGrid.add(annual_h2, 0, 3);
    	annualGrid.setPadding(gridPadding);
    	annualGrid.setHgap(15);
    	annualGrid.setVgap(15);
    	VBox annualReportVBox = new VBox();
    	annualPane.setLeft(annualGrid);
    	annualPane.setRight(annualReportVBox);
    	annualPane.setBottom(annual_h3);
    	
    	
    	
		
		//Annual Report Page: set actions
    	annualButton.setOnAction(event ->{
    		primaryStage.setScene(annualScene);
    		primaryStage.setTitle("Annual Report");
    	});
    	annualHome.setOnAction(event->{
    		primaryStage.setScene(mainScene);
    		primaryStage.setTitle("Milk Weight Home Page");
    	});
    	annualClose.setOnAction(event->{
    		primaryStage.close();
    	});
    	annualSortWeight.setOnAction(event->{
    		annualReportVBox.getChildren().clear();
    		int year = Integer.parseInt(annualField.getText());
    		displaySortedByWeight_AR(annualReportVBox, csvReader, year);
    	});
    	annualSortID.setOnAction(event->{
    		annualReportVBox.getChildren().clear();
    		int year = Integer.parseInt(annualField.getText());
    		displaySortedByID_AR(annualReportVBox, csvReader, year);
    	});
		annualMin.setOnAction(event ->{
			int min;
    		int year = Integer.parseInt(annualField.getText());
    		min = getMin_AR(csvReader, year);
    		annualValue.setText(Integer.toString(min));
		});
		annualMax.setOnAction(event ->{
			int max;
			int year = Integer.parseInt(annualField.getText());
			max = getMax_AR(csvReader, year);
			annualValue.setText(Integer.toString(max));
		});
		annualAverage.setOnAction(event->{
			int average;
			int year = Integer.parseInt(annualField.getText());
			average = getAverage_AR(csvReader, year);
			annualValue.setText(Integer.toString(average));
		});
		annualTotal.setOnAction(event ->{
			int total;
			int year = Integer.parseInt(annualField.getText());
			total = getTotal_AR(csvReader, year);
			annualValue.setText(Integer.toString(total));
		});
		
		//Scene 5: Monthly Report Page
		BorderPane monthlyPane = new BorderPane();
		Scene monthlyScene = new Scene(monthlyPane, 500, 400);
		
		Label monthlyYear = new Label("Please Enter the Year:");
		Label monthlyMonth = new Label("Please Enter the Month");
		TextField monthlyYearField = new TextField();
		monthlyYearField.setEditable(true);
		monthlyYearField.setPrefColumnCount(4);
		TextField monthlyMonthField = new TextField();
		monthlyMonthField.setEditable(true);
		monthlyMonthField.setPrefColumnCount(4);
		Button monthlySortWeight = new Button("Sort by Weight");
		Button monthlySortID = new Button("Sort by Farm ID");
		Button monthlyMin = new Button("Min");
		Button monthlyMax = new Button("Max");
		Button monthlyAverage = new Button("Average");
		Button monthlyTotal = new Button("Total");
		Button monthlyHome = new Button("Home");
		Button monthlyClose = new Button("Close");
		TextField monthlyValue = new TextField();
		monthlyValue.setEditable(false);
		monthlyValue.setPrefColumnCount(8);
		VBox monthlyReportVBox = new VBox();
		HBox monthly_h1 = new HBox();
		monthly_h1.getChildren().add(monthlyYear);
		monthly_h1.getChildren().add(monthlyYearField);
		HBox monthly_h2 = new HBox();
		monthly_h2.getChildren().add(monthlyMonth);
		monthly_h2.getChildren().add(monthlyMonthField);
		HBox monthly_h3 = new HBox();
		monthly_h3.getChildren().add(monthlyMin);
		monthly_h3.getChildren().add(monthlyMax);
		monthly_h3.getChildren().add(monthlyAverage);
		monthly_h3.getChildren().add(monthlyTotal);
		monthly_h3.getChildren().add(monthlyValue);
		HBox monthly_h4 = new HBox();
		monthly_h4.getChildren().add(monthlyHome);
		monthly_h4.getChildren().add(monthlyClose);
		GridPane monthlyGrid = new GridPane();
		monthlyGrid.setPadding(gridPadding);
		monthlyGrid.setHgap(15);
		monthlyGrid.setVgap(15);
		monthlyGrid.add(monthly_h1, 0, 0);
		monthlyGrid.add(monthly_h2, 0, 1);
		monthlyGrid.add(monthlySortWeight, 0, 2);
		monthlyGrid.add(monthlySortID, 0, 3);
		monthlyGrid.add(monthly_h3, 0, 4);
		monthlyPane.setLeft(monthlyGrid);
		monthlyPane.setRight(monthlyReportVBox);
		monthlyPane.setBottom(monthly_h4);
		
		//Monthly Report Page: set actions
		monthlyButton.setOnAction(event->{
			primaryStage.setScene(monthlyScene);
    		primaryStage.setTitle("Monthly Report");
		});
		monthlyHome.setOnAction(event ->{
			primaryStage.setScene(mainScene);
    		primaryStage.setTitle("Milk Weight Home Page");
		});
		monthlyClose.setOnAction(event ->{
			primaryStage.close();
		});
		monthlySortWeight.setOnAction(event ->{
			monthlyReportVBox.getChildren().clear();
			int year = Integer.parseInt(monthlyYearField.getText());
			int month = Integer.parseInt(monthlyMonthField.getText());
			displaySortedByWeight_MR(monthlyReportVBox, csvReader, year, month);
		});
		monthlySortID.setOnAction(event -> {
			monthlyReportVBox.getChildren().clear();
			int year = Integer.parseInt(monthlyYearField.getText());
			int month = Integer.parseInt(monthlyMonthField.getText());
			displaySortedByID_MR(monthlyReportVBox, csvReader, year, month);
		});
		monthlyMin.setOnAction(event ->{
			int min;
			int year = Integer.parseInt(monthlyYearField.getText());
			int month = Integer.parseInt(monthlyMonthField.getText());
			min = getMin_MR(csvReader, year, month);
			monthlyValue.setText(Integer.toString(min));
		});
		monthlyMax.setOnAction(event ->{
			int max;
			int year = Integer.parseInt(monthlyYearField.getText());
			int month = Integer.parseInt(monthlyMonthField.getText());
			max = getMax_MR(csvReader, year, month);
			monthlyValue.setText(Integer.toString(max));
		});
		monthlyAverage.setOnAction(event ->{
			int average;
			int year = Integer.parseInt(monthlyYearField.getText());
			int month = Integer.parseInt(monthlyMonthField.getText());
			average = getAverage_MR(csvReader, year, month);
			monthlyValue.setText(Integer.toString(average));
		});
		monthlyTotal.setOnAction(event ->{
			int total;
			int year = Integer.parseInt(monthlyYearField.getText());
			int month = Integer.parseInt(monthlyMonthField.getText());
			total = getTotal_MR(csvReader, year, month);
			monthlyValue.setText(Integer.toString(total));
		});
		
		//Scene 6: Date Range Report Page
		BorderPane datePane = new BorderPane();
		Scene dateScene = new Scene(datePane, 500 ,400);
		
		Label startDateLabel = new Label("Start Date (yyyy-mm-dd):");
		Label endDateLabel = new Label("End date (yyyy-mm-dd):");
		Label a1 = new Label("-");
		Label a2 = new Label("-");
		Label b1 = new Label("-");
		Label b2 = new Label("-");
		TextField startYear = new TextField();
		TextField startMonth = new TextField();
		TextField startDay = new TextField();
		TextField endYear = new TextField();
		TextField endMonth = new TextField();
		TextField endDay = new TextField();
		startYear.setEditable(true);
		startMonth.setEditable(true);
		startDay.setEditable(true);
		endYear.setEditable(true);
		endMonth.setEditable(true);
		endDay.setEditable(true);
		startYear.setPrefColumnCount(3);
		startMonth.setPrefColumnCount(2);
		startDay.setPrefColumnCount(2);
		endYear.setPrefColumnCount(3);
		endMonth.setPrefColumnCount(2);
		endDay.setPrefColumnCount(2);
		HBox date_h1 = new HBox();
		date_h1.getChildren().add(startDateLabel);
		date_h1.getChildren().add(startYear);
		date_h1.getChildren().add(a1);
		date_h1.getChildren().add(startMonth);
		date_h1.getChildren().add(a2);
		date_h1.getChildren().add(startDay);
		HBox date_h2 = new HBox();
		date_h2.getChildren().add(endDateLabel);
		date_h2.getChildren().add(endYear);
		date_h2.getChildren().add(b1);
		date_h2.getChildren().add(endMonth);
		date_h2.getChildren().add(b2);
		date_h2.getChildren().add(endDay);
		
		Button dateSortWeight = new Button("Sort by Weight");
		Button dateSortID = new Button("Sort by Farm ID");
		Button dateMin = new Button("Min");
		Button dateMax = new Button("Max");
		Button dateAverage = new Button("Average");
		Button dateTotal = new Button("Total");
		TextField dateValue = new TextField();
		dateValue.setEditable(false);
		dateValue.setPrefColumnCount(8);
		Button dateHome = new Button("Home");
		Button dateClose = new Button("Close");
		HBox date_h3 = new HBox();
		date_h3.getChildren().add(dateMin);
		date_h3.getChildren().add(dateMax);
		date_h3.getChildren().add(dateAverage);
		date_h3.getChildren().add(dateTotal);
		date_h3.getChildren().add(dateValue);
		HBox date_h4 = new HBox();
		date_h4.getChildren().add(dateHome);
		date_h4.getChildren().add(dateClose);
		VBox dateRangeReportsVBox = new VBox();
		GridPane dateGrid = new GridPane();
		dateGrid.setPadding(gridPadding);
		dateGrid.setHgap(15);
		dateGrid.setVgap(15);
		dateGrid.add(date_h1, 0, 0);
		dateGrid.add(date_h2, 0, 1);
		dateGrid.add(dateSortWeight, 0, 2);
		dateGrid.add(dateSortID, 0, 3);
		dateGrid.add(date_h3, 0, 4);
		datePane.setLeft(dateGrid);
		datePane.setRight(dateRangeReportsVBox);
		datePane.setBottom(date_h4);
		
		//Date Range Report Page: set actions
		rangeButton.setOnAction(event ->{
			primaryStage.setScene(dateScene);
			primaryStage.setTitle("Date Range Report");
		});
		dateHome.setOnAction(event ->{
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Milk Weight Home Page");
		});
		dateClose.setOnAction(event ->{
			primaryStage.close();
		});
		dateSortWeight.setOnAction(event ->{
			dateRangeReportsVBox.getChildren().clear();
			int start_year = Integer.parseInt(startYear.getText());
			int start_month = Integer.parseInt(startMonth.getText());
			int start_day = Integer.parseInt(startDay.getText());
			int end_year = Integer.parseInt(endYear.getText());
			int end_month = Integer.parseInt(endMonth.getText());
			int end_day = Integer.parseInt(endDay.getText());
			displaySortedByWeight_DR(dateRangeReportsVBox, csvReader, start_year, start_month, start_day,
					end_year, end_month, end_day);
		});
		dateSortID.setOnAction(event ->{
			dateRangeReportsVBox.getChildren().clear();
			int start_year = Integer.parseInt(startYear.getText());
			int start_month = Integer.parseInt(startMonth.getText());
			int start_day = Integer.parseInt(startDay.getText());
			int end_year = Integer.parseInt(endYear.getText());
			int end_month = Integer.parseInt(endMonth.getText());
			int end_day = Integer.parseInt(endDay.getText());
			displaySortedByID_DR(dateRangeReportsVBox, csvReader, start_year, start_month, start_day,
					end_year, end_month, end_day);
		});
		dateMin.setOnAction(event ->{
			int min;
			int start_year = Integer.parseInt(startYear.getText());
			int start_month = Integer.parseInt(startMonth.getText());
			int start_day = Integer.parseInt(startDay.getText());
			int end_year = Integer.parseInt(endYear.getText());
			int end_month = Integer.parseInt(endMonth.getText());
			int end_day = Integer.parseInt(endDay.getText());
			min = getMin_DR(csvReader, start_year, start_month, start_day,
					end_year, end_month, end_day);
			dateValue.setText(Integer.toString(min));
		});
		dateMax.setOnAction(event ->{
			int max;
			int start_year = Integer.parseInt(startYear.getText());
			int start_month = Integer.parseInt(startMonth.getText());
			int start_day = Integer.parseInt(startDay.getText());
			int end_year = Integer.parseInt(endYear.getText());
			int end_month = Integer.parseInt(endMonth.getText());
			int end_day = Integer.parseInt(endDay.getText());
			max = getMax_DR(csvReader, start_year, start_month, start_day,
					end_year, end_month, end_day);
			dateValue.setText(Integer.toString(max));
		});
		dateAverage.setOnAction(event ->{
			int average;
			int start_year = Integer.parseInt(startYear.getText());
			int start_month = Integer.parseInt(startMonth.getText());
			int start_day = Integer.parseInt(startDay.getText());
			int end_year = Integer.parseInt(endYear.getText());
			int end_month = Integer.parseInt(endMonth.getText());
			int end_day = Integer.parseInt(endDay.getText());
			average = getAverage_DR(csvReader, start_year, start_month, start_day,
					end_year, end_month, end_day);
			dateValue.setText(Integer.toString(average));
		});
		dateTotal.setOnAction(event ->{
			int total;
			int start_year = Integer.parseInt(startYear.getText());
			int start_month = Integer.parseInt(startMonth.getText());
			int start_day = Integer.parseInt(startDay.getText());
			int end_year = Integer.parseInt(endYear.getText());
			int end_month = Integer.parseInt(endMonth.getText());
			int end_day = Integer.parseInt(endDay.getText());
			total = getTotal_DR(csvReader, start_year, start_month, start_day,
					end_year, end_month, end_day);
			dateValue.setText(Integer.toString(total));
		});
		
		
		
		// show the stage
    	primaryStage.show();
    	
		
	}

	/**
	 * main method to run the program
	 * @param args
	 */
	public static void main(String[] args) {
		   launch(args);
	}
}
