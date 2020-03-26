/*
 *   Intro to Programming CSE 1310
 * University of Texas at Arlington
 */
package lab4part2spr17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author jcmtiernan
 */
public class Lab4Part2Spr17 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String sign;
        String dayOfWeekName;
        String monthName;
        String dayNumber;
        int year;
        int dayOfMonth;
        int monthNumber;
        String dateFile;
        System.out.println();
        System.out.println("This program reads birthdates"
                + "from a file in the form of "
                + "\"Tuesday February 21, 2017\".\n  "
                + "and then determines the zodiac sign of this birthdate.\n\n"
                + "Please enter the name of your input file (with no blanks) :  ");
        dateFile = input.next();
        System.out.println();
        boolean fileFound = false;
        //File datesFile;  // connect this File object to the users input
        File datesFile = new File(dateFile);
        Scanner inFile = null;  // initialize this Scanner
        try 
        {   // Connect inFile to the input data file
            inFile = new Scanner(datesFile);
            fileFound = true;
        } 
        catch (FileNotFoundException fnf) 
        {
            System.out.println("Input file " + dateFile + " not found");
        }
        boolean outFound = false;
        // use a try-catch to connect the output file to the Printwriter object
        String outputFile = "signOutput.txt";
        PrintWriter outFile = null;
        try 
        {   // Connect inFile to the input data file
            outFile = new PrintWriter(outputFile);
        } catch (FileNotFoundException fnf) {
            System.out.println("file not found");
        }
        if (fileFound) 
        {
            while (inFile.hasNext()) 
            {
                dayOfWeekName = inFile.next();
                monthName = inFile.next();
                dayNumber = inFile.next();
                // What was read in for dayNumber? It reads the day of the month 
                // What does makeNum do?(convert string to int) takes a string
           //(dayNumber) and return an integer which will be saved in dayOfMonth
                dayOfMonth = makeNum(dayNumber);
                year = inFile.nextInt();
                // Use a method to find the month number from the month name                
                monthNumber = findMoNum(monthName);
                /*
                //2.g) call for method moDayCheck and send to the method month(monthNumber), 
                // and days(dayOfMonth); the method will return integer (mo)
                int mo = moDayCheck(monthNumber, dayOfMonth);
                 */
                // Print the numeric format then                
                System.out.println("You entered " + monthNumber + "/" + dayOfMonth + "/" + year);
                // Use a method to find the astrological sign of the birthdate                 
                sign = findSign(monthNumber, dayOfMonth);
                // Return the sign and print that                
                System.out.println("This date's astrological sign is " + sign);
                System.out.println();
                // if the output file was found, then output the same info
                // to the PrintWriter output file
                outFile.println("You entered " + monthNumber + "/" + dayOfMonth + "/" + year);
                if ( (monthNumber == 0) || (dayOfMonth > 31) ) 
                {
                    outFile.println("This date is invalid.");
                }
                outFile.println("This date's astrological sign is " + sign);
                outFile.println();
            }
        }
        // if the output file was found, close the file here
        outFile.close();
    }

    public static int makeNum(String numCm) 
    {
        int num = numCm.length();
        String tNum = numCm.substring(0, num - 1);
        try 
        {
            num = Integer.parseInt(tNum);
        } 
        catch (InputMismatchException im) 
        {
            num = 0;
        }
        return num;
    }

    public static int findMoNum(String moName) {
        int moNum = 0;
        // Assume that for any string input, the user might enter 
        // the first three letters as an abbreviation or the entire word and 
        // the entire word might be capitalized or not and
        // the abbreviation could be capitalized or not, and 
        // with a period or not.  For example, the word "giraffe" could be 
        // entered as "Gir.", "gir.", "Gir", "gir", "Giraffe", or "giraffe"
        // Write the needed code to accept the input String and find the 
        // correct number to go with the String
        if ((moName.equalsIgnoreCase("January")) || (moName.equalsIgnoreCase("Jan"))
                || (moName.equalsIgnoreCase("jan."))) {
            moNum = 1;
        } else if ((moName.equalsIgnoreCase("February")) || (moName.equalsIgnoreCase("Feb"))
                || (moName.equalsIgnoreCase("Feb."))) {
            moNum = 2;
        } else if ((moName.equalsIgnoreCase("March")) || (moName.equalsIgnoreCase("Mar"))
                || (moName.equalsIgnoreCase("Mar."))) {
            moNum = 3;
        } else if ((moName.equalsIgnoreCase("April")) || (moName.equalsIgnoreCase("Apr"))
                || (moName.equalsIgnoreCase("Apr."))) {
            moNum = 4;
        } else if ((moName.equalsIgnoreCase("May")) || (moName.equalsIgnoreCase("May."))) {
            moNum = 5;
        } else if ((moName.equalsIgnoreCase("June")) || (moName.equalsIgnoreCase("Jun"))
                || (moName.equalsIgnoreCase("Jun."))) {
            moNum = 6;
        } else if ((moName.equalsIgnoreCase("July")) || (moName.equalsIgnoreCase("Jul"))
                || (moName.equalsIgnoreCase("Jul."))) {
            moNum = 7;
        } else if ((moName.equalsIgnoreCase("August")) || (moName.equalsIgnoreCase("Aug"))
                || (moName.equalsIgnoreCase("Aug."))) {
            moNum = 8;
        } else if ((moName.equalsIgnoreCase("September")) || (moName.equalsIgnoreCase("Sep"))
                || (moName.equalsIgnoreCase("Sep."))) {
            moNum = 9;
        } else if ((moName.equalsIgnoreCase("October")) || (moName.equalsIgnoreCase("Oct"))
                || (moName.equalsIgnoreCase("Oct."))) {
            moNum = 10;
        } else if ((moName.equalsIgnoreCase("November")) || (moName.equalsIgnoreCase("Nov"))
                || (moName.equalsIgnoreCase("Nov."))) {
            moNum = 11;
        } else if ((moName.equalsIgnoreCase("December")) || (moName.equalsIgnoreCase("Dec"))
                || (moName.equalsIgnoreCase("Dec."))) {
            moNum = 12;
        } 
        return moNum;
    }

    public static String findSign(int mo, int day) 
    {
        String sign = "Unclear";
        // error checking for valid month and day in month
        mo = moDayCheck(mo, day);
        // Look up the zodiac signs and use them to fill in the switch below
        // One sign is shown below
        switch (mo) 
        {
            case 1:
                if ( ((mo == 12) && (day >= 22)) || ((mo == 1) && (day <= 19)) ) 
                {
                    return "Capricorn";
                }
            case 2:
                if ((mo == 1) || (day <= 18)) {
                    return "Aquarius";
                }
            case 3:
                if ((mo == 2) || (day <= 20)) {
                    return "Pisces";
                }
            case 4:
                if ((mo == 3) || (day <= 19)) {
                    return "Aries";
                }
            case 5:
                if ((mo == 4) || (day <= 20)) {
                    return "Taurus";
                }
            case 6:
                if ((mo == 5) || (day <= 20)) {
                    return "Gemini";
                }
            case 7:
                if ((mo == 6) || (day <= 22)) {
                    return "Cancer";
                }
            case 8:
                if ((mo == 7) || (day <= 22)) {
                    return "Leo";
                }
            case 9:
                if ((mo == 8) || (day <= 22)) {
                    return "Virgo";
                }
            case 10:
                if ((mo == 9) || (day <= 22)) {
                    return "Libra";
                }
            case 11:
                if ((mo == 10) || (day <= 21)) {
                    return "Scorpio";
                }
            case 12:
                if ((mo == 11) || (day <= 21)) {
                    return "Sagittarius";
                }
            case 0:
                System.out.println("This date is invalid.");
        }
        return sign;
    }
    // Write method moDayCheck that takes in the month and day
    // as input parameters.  It should check for the validity of 
    // the day and month as given below.  Use the algorithm for 
    // checking date to write the method.
    // If the date is invalid the method should return a value of 0. 
    // Otherwise return the month value that was passed in.

    // Valid dates:
    // 12 months in a year Jan (1) to Dec (12)
    // 31 days Jan., Mar., May, Jul., Aug., Oct., Dec.        
    // 30 days Sept., April, June, Nov.
    // 28 days Feb. (ignoring leap year)
    
    // Algorithm for checking date
    // if month is NOT a valid number, then
    //    set mo to 0
    // else check if day is invalid for any month.  if so, then
    //    set mo to 0
    // else if mo is Feb and day is too large, then
    //    set mo to 0
    // else if there are more than 30 days and mo is Sep, Apr, Jun, or Nov,
    //    set mo to 0
    // return mo
    public static int moDayCheck(int month, int days) 
    {
        int mo = month;;
        if ((month < 1) || (month > 12)) 
        {
            mo = 0;
        } 
        else if ( ((month == 1) && ((days > 31) || (days < 1))) ||
                ((month == 3) && ((days > 31) || (days < 1))) || 
                ((month == 5) && ((days > 31) || (days < 1))) || 
                ((month == 7) && ((days > 31) || (days < 1))) || 
                ((month == 8) && ((days > 31) || (days < 1))) || 
                ((month == 10) && ((days > 31) || (days < 1))) || 
                ((month == 12) && ((days > 31) || (days < 1))) ) 
        {
            mo = 0;
        } 
        else if ( (month == 2) && ((days > 28) || (days < 1)) ) 
        {
            mo = 0;
        }
        else if ( ((month == 4) && ((days > 30) || (days < 1))) || 
                ((month == 6) && ((days > 30) || (days < 1))) || 
                ((month == 9) && ((days > 30) || (days < 1))) || 
                ((month == 11) && ((days > 30) || (days < 1))) ) 
        {
            mo = 0;
        } 
        return mo;
    }
}
