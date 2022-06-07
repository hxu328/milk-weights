README

email: hxu328@wisc.edu

Other notes or comments to the grader:

Step 1:
Run Main.java to start

Step 2:
launch Milk Weight Home Page:
At the home page, user need to enter a absolute path to a csv file, 
then click "Add" button to load the data in the file. (to load sample data, you can just
type in relative path like "2019-1.csv", "2019-2.csv" .....)
User can load differet files by entering different file names each time. Duplicate file names
 are not allowed, and will be warned if it is entered.
User can also remove all data of a specifc farm ID in the home page through entering the name.
Then, click "Continue" to go to "Select Type of Report" page. 

Step 3:
launch "Select Type of Report" page:
User can select 4 types of reports in this page: Farm Report, Annual Report, Monthly Report, Date Range Report
by clicking matched buttons on the page

a. In the "Farm Report" page, user can enter farm id and year to get reports of 12 months, the list of
reports can be sorted by weight and month number by clicking "Sort by Weight", and " Sort by Month",
After entering the farmid and year, clicking four buttons including "Min", "Max", "Average", "Total" to
get minium, maximum, average and total weight of milk for 12 months.

b. In the "Annual Report" page, user can enter year number to get annual reports, the list of reports can be 
sorted by farm ID and weight by clicking "Sort by ID" and "Sort by Weight". After entering the year, clicking 
four buttons including "Min", "Max", "Average", "Total" to get minium, maximum, average and total weight 
of milk for every farm within the specific year.

c. In the "Month Report" page, user can enter year number and month number to get monthly reports, 
the list of reports can be sorted by farm ID and weight by clicking "Sort by ID" and "Sort by Weight".
After entering the month and year number, cliking four buttons including "Min", "Max", "Average", "Total"
to get minium, maximum, average and total weight of milk for every farm within the specifc year and month.

d. In the "Date Range Report", user can enter start date and end date to get reports during that period.
the list of reports can be sorted by farm ID and weight by clicking "Sort by ID" and "Sort by Weight".
After entering the start date and end date (yyyy/mm/dd), cliking four buttons including "Min", "Max", 
"Average", "Total"to get minium, maximum, average and total weight of milk for every farm within the
specifc date range.

Bug report:
1. In the "Date Range Report Range", the program does not check whether the entered date is an existing
date on the calender because I does not use java.util.Date to implement the program.
2. If the generated report contains to many farms, the window will not expand the window automatically.

Furture work section:
1.Use java.util.Date to emplement the program, thus the program can check whether the user-entered date
is valid.
2. Check the number of farm for Annual, Monthly and Date Range report, then the program can expend the
window automatically, and show the whole report to the user.
3. The user can only select "Sort by Weight" in ascending order. I will add a functionality which allows user to
sort weight in descending order. 

