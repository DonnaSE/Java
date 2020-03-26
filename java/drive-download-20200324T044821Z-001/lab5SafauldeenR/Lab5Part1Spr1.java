/*
 *   Intro to Programming CSE 1310
 * University of Texas at Arlington
 */
package lab5part1spr1;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author jcmtiernan
 */
public class Lab5Part1Spr1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LoggingExamples.class.getName());
        logger.setLevel(Level.OFF);  //INFO is on; OFF is off         

        Scanner keybd = new Scanner(System.in);
        JCMTtime myTime = new JCMTtime();  //  This value will have the current time in it
        // Lunar module Eagle landed on the moon on July 20, 1969, at 20:18 UTC.
        JCMTtime landedTime = new JCMTtime();
        landedTime.setYear(1969);
        landedTime.setMonth(6);
        landedTime.setDayOfMonth(20);
        landedTime.setMinute(18);
        landedTime.setHourInMil(20);
        // July 21, 1969 at 02:56:15 UTC First person steps on the moon
        JCMTtime firstStepTime = new JCMTtime(1969, 6, 21, 2, 56);

        // 3.a) instantiate the birthTime value with YOUR birth date and time
        JCMTtime birthTime = new JCMTtime(2000, 0, 1, 0, 0);
        birthTime.setYear(1982);
        birthTime.setMonth(6);
        birthTime.setDayOfMonth(30);
        birthTime.setMinute(10);
        birthTime.setHourInMil(7);
        // If you do not know your birth time, put in noon for the time
        String myName = "Raghad Safauldeen"; // and 3.a) initialize this String to YOUR name.

        int inMo = -1;
        int inDay = -1;
        int inYr = -1;
        int inHr = -1;
        int inMin = -1;

        System.out.println("Please enter the expiration date and time of your coupon.\n");
        System.out.println("The format should be month (space) day (space) year (space) hour (space) min");
        System.out.println("like MM dd yyyy HH mm.  The coupon year must be between 1970 and 2020. ");
        System.out.println("The hour should be in military time from 0 to 23. Invalid values will be ");
        System.out.println("replaced with the current time values. Example: For a coupon that expires one");
        System.out.println("minute before midnight on Halloween the input would be 10 31 2017 23 59.  \n");
        System.out.print("Enter your coupon expiration date and time here: ");

        inMo = keybd.nextInt();
        inDay = keybd.nextInt();
        inYr = keybd.nextInt();
        inHr = keybd.nextInt();
        inMin = keybd.nextInt();

        System.out.println("\nYour input was " + inMo + "/" + inDay + "/" + inYr + " at " + inHr + ":" + inMin);

        JCMTtime expDate = new JCMTtime(2000, 0, 1, 0, 0);   // 3.b) initialize the coupon date with the user's inputs
        expDate.setYear(inYr);
        expDate.setMonth(inMo);
        expDate.setDayOfMonth(inDay);
        expDate.setMinute(inMin);
        expDate.setHourInMil(inHr);

        System.out.println("Your error-checked input is " + expDate.toStringMDYHM());

        System.out.println("\nNow we will check if this coupon is still valid and how many\n"
                + "days longer it is valid or that it has been expired. ");
        System.out.println("");
        System.out.println("The current time is " + myTime.toStringMDYHM());

        /* 
            3.d) Call the daysBetween method here using your coupon input in expDate 
            and the current date in myTime
            Print the number of days between that are returned from the method call
         */
        double numberOfDaysBtwn = daysBetween(expDate, myTime);

        System.out.println("The number of days between the coupon date and the current date is " + numberOfDaysBtwn);

        System.out.println("Please enter the expiration date and time of your next coupon.\n");
        System.out.println("The format should be month (space) day (space) year (space) hour (space) min");
        System.out.println("like MM dd yyyy HH mm.  If your MM, dd, yyyy, HH, or mm values are out of");
        System.out.println("range, the program will resolve them into valid values and then check the ");
        System.out.print("coupon expiration.  Enter your coupon expiration date and time here: ");

        inMo = keybd.nextInt();
        inDay = keybd.nextInt();
        inYr = keybd.nextInt();
        inHr = keybd.nextInt();
        inMin = keybd.nextInt();

        System.out.println("\nYour input was " + inMo + "/" + inDay + "/" + inYr + " at " + inHr + ":" + inMin);

        /* 
            3.f) Call the method dateResolution here using the inputs read from the user and assign
            the resulting JCMTtime value to the object expDate.  
         */
        expDate = dateResolution(inMin, inHr, inDay, inMo, inYr);  // call dateResolution and assign it to expDate

        System.out.println("Your error-checked and resolved input is " + expDate.toStringMDYHM());

        System.out.println("\nNow we will check if this 2nd coupon is still valid and how many\n"
                + "days longer it is valid or that it has been expired. ");
        System.out.println("");
        System.out.println("The current time is " + myTime.toStringMDYHM());
        /* 
            3.g) Call the daysBetween method here using your coupon input in expDate 
            and the current date in myTime
            Print the number of days between that are returned from the method call
         */
        double DaysBtwnResolvAndCurrent = daysBetween(expDate, myTime);
        System.out.println("The difference between the resolved value of the "
                + "expire date and the current date is: " + DaysBtwnResolvAndCurrent);

        // after calling daysBetween and printing its output then print:
        System.out.println("");
        System.out.println("The Eagle lunar module landed on the moon at " + landedTime.toStringMDYHM());
        System.out.println("The first person, Neil Armstrong, stepped on the moon at " + firstStepTime.toStringMDYHM());
        System.out.println("The birth date and time of " + myName + " is "
                + birthTime.getMonthName() + " " + birthTime.getDayOfMonth() + ", "
                + birthTime.getYear() + " at " + birthTime.getHourInMil() + ":"
                + twoPlaces(birthTime.getMinute()));

    }
    // 3.d) Write the method daysBetween here

    public static double daysBetween(JCMTtime date1, JCMTtime date2) {
        double difference = 0;
        int yyyy1 = date1.getYear();
        int MM1 = date1.getMonth();
        int dd1 = date1.getDayOfMonth();
        double hh1 = date1.getHourInMil();
        double mm1 = date1.getMinute();

        int yyyy2 = date2.getYear();
        int MM2 = date2.getMonth();
        int dd2 = date2.getDayOfMonth();
        double hh2 = date2.getHourInMil();
        double mm2 = date2.getMinute();

        double diffOfYears = (yyyy1 - yyyy2); //the difference between the two dates in year
        double diffOfYearsInDays = (diffOfYears * 365); //(the number of days in diffOfYears)
        //Now find how many days from the beginning of the yyyy2 until the exact
        // time in the date2 then subtract it from the diffOfYearsInDays.

        // calculat the number of the months from the current date until December 
        // of the current year
        double dayOfTheMonth = 0;
        double totalMonth2Days = 0;
        for (int i = MM2; i < 12; i++) {
            if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8)
                    || (i == 10) || (i == 12)) {
                dayOfTheMonth = 31;
            } else if ((i == 4) || (i == 6) || (i == 9) || (i == 11)) {
                dayOfTheMonth = 30;
            } else if ((i == 2) && (checkLeap(yyyy2))) {
                dayOfTheMonth = 29;
            } else if ((i == 2) && (!(checkLeap(yyyy2)))) {
                dayOfTheMonth = 28;
            }
            totalMonth2Days = totalMonth2Days + dayOfTheMonth;
        }

        // Convert hours' unit to days' unit 
        double hh2ToDay = (hh2 / 24);
        // Convert minutes' unit to days' unit 
        double mm2ToDay = mm2 / (60 * 24);
        //double yyyyToCurrentDate =365â€“(totalMonth2Daysâ€“dd2â€“hh2ToDayâ€“mm2ToDay);
        double x;//x = yyyy2ToCurrentDate but i do not know why java does not like it!!!
        x = 365 - (totalMonth2Days - dd2 - hh2ToDay - mm2ToDay);
        double daysFromCurrentDateToExpYear = diffOfYearsInDays - x;

        // Now calculating the time in days after the yyyy1 until the expire date
        // Make a loop start from first month of the year (January) until MM1
        // which is the expire month In this loop will increment the number of
        // days in each months. Assign the result in MM1Days
        double dayOfTheMonthes1 = 0;
        double MM1Days = 0;
        for (int i = 1; i <= MM1; i++) {
            if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8)
                    || (i == 10) || (i == 12)) {
                dayOfTheMonthes1 = 31;
            } else if ((i == 4) || (i == 6) || (i == 9) || (i == 11)) {
                dayOfTheMonthes1 = 30;
            } else if ((i == 2) && (checkLeap(yyyy1))) {
                dayOfTheMonthes1 = 29;
            } else if ((i == 2) && (!(checkLeap(yyyy1)))) {
                dayOfTheMonthes1 = 28;
            }
            MM1Days = MM1Days + dayOfTheMonthes1;
        }

        // Convert hours' unit to days' unit 
        double hh1ToDay = (hh1 / 24);
        // Convert minutes' unit to days' unit 
        double mm1ToDay = mm1 / (60 * 24);
        double daysFromExpYearToExpDate = MM1Days + dd1 + hh1ToDay + mm1ToDay;
        double diffBtwnDates = daysFromCurrentDateToExpYear + daysFromExpYearToExpDate;
        return diffBtwnDates;
    }

    // 3.f) Write the method dateResolution here
    public static JCMTtime dateResolution(int mm, int hh, int dd, int MM, int yy) {
        // int ss = 0;
        // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        // GregorianCalendar check= new GregorianCalendar(yy, MM-1, dd, hh, mm);
        //System.out.println("chech = "+ sdf.format(check.getTime()));
        int m;
        int h;
        int M;
        int d;
        int y;
        //Now check for the second ss
        // if (ss > 59) {
        //   m = ss / 60;
        //    mm = mm + m;
        // }
        //Now check for the minutes mm 
        if (mm > 59) {
            h = mm / 60;
            mm = mm % 60;

            hh = hh + h;
        }

        if (hh > 23) {
            d = hh / 24;
            hh = hh % 24;
            dd = dd + d;
        }

        // Check for the days dd
        if (MM > 12) {
            y = MM / 12;
            MM = MM % 12;
            yy = yy + y;

        }
        if (((MM == 1) || (MM == 3) || (MM == 5) || (MM == 7) || (MM == 8) || (MM == 10)
                || (MM == 12)) && (dd > 31)) {
            M = dd / 31;
            dd = dd % 31;
            MM = MM + M;

        } else if (((MM == 4) || (MM == 6) || (MM == 9) || (MM == 11)) && (dd > 30)) {
            M = dd / 30;
            dd = dd % 30;
            MM = MM + M;
        } else if (((MM == 2) && (checkLeap(yy))) && (dd > 29)) {
            M = dd / 29;
            dd = dd % 29;
            MM = MM + M;

        } else if (((MM == 2) && (!(checkLeap(yy)))) && (dd > 28)) {
            M = dd / 28;
            dd = dd % 28;
            MM = MM + M;
        }

        //Now check for months MM:    
        if (MM > 12) {
            y = MM / 12;
            MM = MM % 12;
            yy = yy + y;

        }

        JCMTtime correctDate = new JCMTtime(yy, MM, dd, hh, mm);
        //System.out.println("the correctDate" +correctDate);

        return correctDate;
    }

    /**
     * Write a method that prints the minutes properly when the value is less
     * than 10. This means that your method will take in HH and mm of 3 and 4
     * and output 3:04 NOT 3:4.
     *
     */
    static public String twoPlaces(int min) {

        String mins = "";
        if (min < 10) {
            String StringMin = Integer.toString(min);
            // 3.h) make the correct string here to print the minutes
            mins = ("0" + StringMin);
        } else {
            mins = Integer.toString(min);
        }
        return mins;

    }

    //boolean valid = true;
    public static boolean checkLeap(int year) {
        boolean leap = false;

        if ((year % 4) == 0) {
            if ((year % 100) != 0) // leap year b/c yr is div by 4 but not by 100
            {
                leap = true;
            } else if ((year % 400) == 0) // leap year b/c yr is div by 400
            {
                leap = true;
            }
        }
        return leap;
    }
}
