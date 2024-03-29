//L00129017
//Aaron Clarke
//BSc Computing - Year 3
//Assignment 2
//30/11/2017

package ie.lyit.testers;

import ie.lyit.test.Date;
import java.util.Scanner;

public class DateTester{
	public static void main(String[] args) {
		Date d1 = new Date();
        System.out.println(d1);      

	    d1.setDay(4);
		d1.setMonth(6);
		d1.setYear(1941);
		
		System.out.println(d1);
      
		Date d2 = new Date(28, 12, 1982);
        System.out.println(d2);
      
		if(d1.equals(d2))
			System.out.println("Date's are equal.");
		else
			System.out.println("Date's are not equal.");
		
		Date myDate1 = new Date();
		int setDayTo=32, setMonthTo=13, setYearTo=-2009;
		boolean goodInput=false;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		
		do {
			try {
				// Set myDate1 to invalid values - Should throw an exception!
				myDate1.setDay(setDayTo);
				myDate1.setMonth(setMonthTo);
				myDate1.setYear(setYearTo);
				goodInput=true;
			}
			catch(IllegalArgumentException iEA){
				System.out.println("Incorrect day, month or year.");

				System.out.print("Enter day [1-31]:");
				setDayTo = keyboard.nextInt();
				System.out.print("Enter month [1-12]:");
				setMonthTo = keyboard.nextInt();
				System.out.print("Enter Year [above 1900]:");
				setYearTo = keyboard.nextInt();				
			}
		}while(!goodInput);
		
		goodInput=false;
		setDayTo=15;setMonthTo=33;setYearTo=2017;
		do {
			try {
				@SuppressWarnings("unused")
				Date myDate2 = new Date(setDayTo,setMonthTo,setYearTo);
			}
			catch(IllegalArgumentException iEA){
				System.out.println("Incorrect day, month or year.");
				
				System.out.print("Enter day [1-31]:");
				setDayTo = keyboard.nextInt();
				System.out.print("Enter month [1-12]:");
				setMonthTo = keyboard.nextInt();
				System.out.print("Enter Year [above 1900]:");
				setYearTo = keyboard.nextInt();				
			}
		}while(!goodInput);
   }
}
