/* 
Dates. Create a data type Date that represents a date. You should be able to create a new Date by specifying the month, day, and year. It should supports methods to compute the number of days between two dates, return the day of the week that a day falls on, etc. 
*/

public class Date {
    
    private final int dd;
    private final int mm;
    private final int year;
	
    public Date(int da, int mo, int yr)
	{
		// check validity of entered date
		boolean lpYear = (((yr%4 == 0) && (yr%100 != 0)) || (yr%400 == 0));
		if ((mo<1)||(mo>12)||(da<1)||(da>31)||(yr<0)||((mo==2)&&(da>29)&& lpYear)||((mo==2)&&(da>28)&&(!lpYear))) {
			throw new RuntimeException("Illegal date. Please, check.");
		}

		else {
			mm = mo; 
			dd = da;
			year = yr;
		}
	}


    public String toString() {	
        return dd + "/"+mm + "/"+year;
    }
    
    public String printDDMMYYYY() {	
        if (dd < 10) {
	    if (mm < 10) {
		return "0" + dd + "/" + "0" + mm + "/" + year;
	    }
	    else return "0" + dd + "/" + mm + "/" + year;
	}
	else if (mm < 10) {
	    return dd + "/" + "0" + mm + "/" + year;
	} 
	else return dd + "/" + mm + "/" + year;
    }
    
    public boolean leapYear() {
	if ( ((year%4 == 0) && (year%100 != 0)) || (year%400 == 0) ) return true;
	else return false;
	    
    }
    
    public int daysInMonth() {
	int days = 0;
	switch(mm) {
	    case 1:
		days = 31; break;
	    case 2:
		if (leapYear()) days = 29; 
		else days = 28;
		break;
	    case 3:
		days = 31; break;
	    case 4:
		days = 30; break;
	    case 5:
		days = 31; break;
	    case 6:
		days = 30; break;
	    case 7:
		days = 31; break;
	    case 8:
		days = 31; break;
	    case 9:
		days = 30; break;
	    case 10:
		days = 31; break;
	    case 11:
		days = 30; break;
	    case 12:
		days = 31; break;
	}
	return days;
    }
    

    public int daysPassed(Date b) {
//	dd mm year;
//	b.dd b.mm b.year;
	Date minDate = null;
	Date maxDate = null;
	int days = 0; // counting days

	if (equals(b)) return days;
	else if (older(b)) {
	    minDate = new Date(b.dd, b.mm, b.year);
	    maxDate = new Date(dd, mm, year);
	}
	else {
	    minDate = new Date(dd, mm, year);
	    maxDate = new Date(b.dd, b.mm, b.year);   	
	}

	// add days of year if there is at least 1 whole year between dates
	if ((maxDate.year-minDate.year)>1) {
	    for (int y = maxDate.year; y > minDate.year; y--) {
		Date tempDate = new Date(1,1,y);
		if (tempDate.leapYear()) days += 356;
		else days += 355;
	    }	    
	}
	
	// add days of month from min date till the end of the year or till max date
	if (maxDate.older(minDate.endOfYear())) {
	    // maxDate is in another year, counting till the end of min year
	    // counting days in full months
	    if ((12 - minDate.mm) > 0) {
		for (int m = 12; m > minDate.mm; m--) {
		    Date tempDate = new Date(1,m,minDate.year);
		    days += tempDate.daysInMonth();
		}
	    }
	    // counting days of minDate month
	    days += (minDate.daysInMonth()-minDate.dd);
	    
	    // counting days in maxDate year
	    // counting days of maxDate month
	    days += (maxDate.dd);	    
	    if (maxDate.mm > 1) {
		    for (int m = 1; m < maxDate.mm; m++) {
			Date tempDate = new Date(1,m,maxDate.year);
			days += tempDate.daysInMonth();
		    }
	    }

	}    
	else {
	    // max date is in the same year as minDate, counting days till max date
	    if (minDate.mm == maxDate.mm) {
		days += maxDate.dd-minDate.dd;
	    }
	    else {
	    // in different monthes (but same year)
		// counting days in full months
		if ((maxDate.mm - minDate.mm) > 1) {
		    for (int m = (maxDate.mm - 1); m > minDate.mm; m--) {
			Date tempDate = new Date(1,m,minDate.year);
			days += tempDate.daysInMonth();
		    }
		}
		// counting days of minDate month
		days += (minDate.daysInMonth()-minDate.dd);	

		// counting days of maxDate month
		days += (maxDate.dd);
	    }
	}
	return days;
    }
    
    public boolean older(Date b) {
	if (year > b.year || ((year == b.year) && ((mm > b.mm) || ((mm == b.mm) && (dd >= b.dd))))) return true;
	else return false;
    }
   
    public boolean equals(Date b) {
	if (dd == b.dd && mm == b.mm && year == b.year) return true;
	else return false;
    }
    
    public Date endOfYear() {
	return new Date(31,12,year);
    }  
    
    public String dayOfWeek() {
	String weekDay = "";
	int remainder = 0;
	if (year >= 1990) {
	    Date tempDate = new Date (1,1,1990);
	    remainder = daysPassed(tempDate)%7;
	}
	else if (year > 1900) {
	    
	}
	else if (year > 0) {
	    
	}
	switch(remainder) {
	    case 0:
		weekDay = "Monday"; break; 	    
	    case 1:
		weekDay = "Monday"; break; 
	    case 2:
		weekDay = "Monday"; break; 
	    case 3:
		weekDay = "Monday"; break; 
	    case 4:
		weekDay = "Monday"; break; 
	    case 5:
		weekDay = "Monday"; break; 
	    case 6:
		weekDay = "Monday"; break; 

	}
	return weekDay;
    }

    public Date addDays(int days) {

	int newDay = dd;
	int newMonth = mm;
	int newYear = year;
	Date tempDate = new Date (newDay, newMonth, newYear);
	
	while (days > (tempDate.daysInMonth()-newDay)) {
	    days -= daysInMonth()-newDay;
	    if (newMonth == 12) {
		newMonth = 1;
		newYear += 1;
	    }
	    else newMonth += 1;
	    
	    newDay = 1;
	    tempDate = new Date (newDay, newMonth, newYear);
	}
	newDay += days;
	tempDate = new Date (newDay,newMonth,newYear);
	return tempDate;
    }	
  

    // sample client for testing
    public static void main(String[] args) {
        Date a = new Date(1, 1,2013);
        Date b = new Date(Integer.parseInt(args[0]), Integer.parseInt(args[1]),Integer.parseInt(args[2]));
	
        System.out.println("a            = " + a.printDDMMYYYY());
        System.out.println("b            = " + b.toString());
	System.out.println("Days passed: " + a.daysPassed(b));
	
	if (b.leapYear()) System.out.println("b is a leap year.");
	else System.out.println("b isn't a leap year.");
	
	if (a.equals(b)) System.out.println("Dates a and b are the same.");
	else if (a.older(b)) System.out.println("Date a is older."); 
	else System.out.println("Date b is older."); 
	
	System.out.println("60 days after " + b + " it will be " + b.addDays(60) + ".");
	System.out.println(b + " is " + b.dayOfWeek() + ".");
    }
    


}
