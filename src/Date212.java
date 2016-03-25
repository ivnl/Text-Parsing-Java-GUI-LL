

public class Date212 implements Comparable<Date212> { //note the implements Comparable thingy here
	
	private int year;
	private int month;
	private int day;
	private int date;
	
	/** 
	 * toString: necessary or else date nodes will print addresses instead of string values
	 * @return String converts month,day,year ints 
	 */ 
	
	public String toString() { /** convert months and days that are less than 10 so that there is a "0" in front of them, IE: 10/09/1991 **/
		String m=Integer.toString(month); //store string value of month to 'm'
		String d=Integer.toString(day); //store string value of day to 'd'
		
		if(month<10) m = "0" + month; //if month is less than 10, combine 0+month
		if(day<10) d = "0" + day; //same, note *** m and d are only touched if any of these two conditions are true ***
		
		return (m+"/"+d+"/"+year); //we can always return m and d because the initial values given to m and d are the original, untouched month and day
	}
	
	/** 
	 * isValidDate: used to verify dates and check boundaries of validity
	 * 			    if invalid detected, throw new IllegalDate212Exceptions
	 * @void
	 */ 
	public static void isValidDate(String s) {
		
		//check the length of string
		if (s.length() != 8) throw new IllegalDate212Exception ("Error in Entry: " + s + " - not 8 digits");

		int yearCheck = Integer.parseInt(s.substring(0, 4));
		int monthCheck = Integer.parseInt(s.substring(4, 6));
		int dayCheck = Integer.parseInt(s.substring(6, 8));

		if (yearCheck >= 2015 || yearCheck <= 0) throw new IllegalDate212Exception ("Error in Entry: " + s + " - year is out of range"); 
		if (monthCheck >= 12 || monthCheck <= 0)  throw new IllegalDate212Exception ("Error in Entry: " + s + " - month is out of range");

		if (monthCheck == 1 || monthCheck == 3 || monthCheck == 5 || monthCheck == 7 || monthCheck == 8 || monthCheck == 10 || monthCheck == 12) {
			if (dayCheck >= 31 || dayCheck <= 0) throw new IllegalDate212Exception ("Error in Entry: " + s + " - day is out of range");
		}

		if (monthCheck == 4 || monthCheck == 6 || monthCheck == 9 || monthCheck == 11) {
			if (dayCheck >= 30 || dayCheck <= 0) throw new IllegalDate212Exception ("Error in Entry: " + s + " - day is out of range");
		}

		if (monthCheck == 2) {
			if (dayCheck >= 28 || dayCheck <= 0) throw new IllegalDate212Exception ("Error in Entry: " + s + " - day is out of range");
		}

	}

	public Date212(String d) {

		isValidDate(d); //check if incoming date 'd' is valid with above method

		//convert and split string to Year, Month, Day
		year = Integer.parseInt(d.substring(0, 4));
		month = Integer.parseInt(d.substring(4, 6));
		day = Integer.parseInt(d.substring(6, 8));
	}


	/** 
	 * compareTo: used to compare values of current date node with incoming date node
	 * 			  first they are converted to strings and then compared again with built in string compareTo()
	 * @return int 1,-1,0 depending on comparison result
	 */ 
	public int compareTo(Date212 x) { //simple compare to after converting incoming & initial Date212 objects 'x' to strings
		
		return ((year*10000) + (month*100) + day) - ((x.year*10000) + (x.month*100) + (x.day));

	}
	
}
