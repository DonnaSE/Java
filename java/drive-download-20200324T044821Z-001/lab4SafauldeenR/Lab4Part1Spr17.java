/*
 *   Intro to Programming CSE 1310
 * University of Texas at Arlington
 */
package lab4part1spr17;

import java.util.Scanner;

/**
 *
 * @author jcmtiernan
 */
public class Lab4Part1Spr17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Change the names below to better, more meaningful names for the 
        // variables 
        String monthName;  // monthName, was  previously moth
        String weekDay;    // weekDay, was previously a 
        int year;          // year, was previously ear
        int day = 0;       // day, was previously aBer
        int datesCounter = 0;  // datesCounter, was previously count
        int monthNumber = 0;   // monthNumber, was previousl mthct
        System.out.println();

        System.out.println("Give a date input in the form of "
                + "\"Tuesday February 21 2017\".\n  "
                + "If finished, enter \"Done\" :  ");

        weekDay = input.next();   // weekDay was previously a

        // Fill in the needed control statement and test condition so that 
        // the program can read multiple date inputs from the user
        while (!weekDay.equalsIgnoreCase("done")) // weekDay was previously a
        {
            monthName = input.next();  // monthName, was previously moth
            day = input.nextInt();     // day, was previously aBer
            year = input.nextInt();    // year, was previously ear
            // Fill in the variable that should be used to control the switch
            switch (monthName) // monthName, was previously moth  
            {
                // How many possible categories of cases would there 
                //     be for this switch where May, may, and MAY are
                //     considered to be all ONE category?              
                // The possible cantegories of cases is to be 13 cases because 
                // there are 12 months in the year + the default one
                // Add ALL the other needed cases to complete the switch 
                // using the statements below as the outputs.
                // Slow as molasses in January
                case "january":
                case "JANUARY":
                case "January":
                    System.out.println("Slow as molasses in January");
                    monthNumber = 1;     // monthNumber was previousl mthct
                    break;
         // February is merely as long as is needed to pass the time until March
                case "february":
                case "FEBRUARY":
                case "February":
                    System.out.println("February is merely as long as is needed"
                            + " to pass the time until March");
                    monthNumber = 2;         // monthNumber, was previousl mthct
                    break;
                // March of the Penguins
                case "march":
                case "MARCH":
                case "March":
                    System.out.println("March of the Penguins");
                    monthNumber = 3;         // monthNumber, was previousl mthct
                    break;
                // Complete the missing case statements for April and June.
                case "april":
                case "APRIL":
                case "April":
                    System.out.println("April showers");
                    monthNumber = 4;         // monthNumber, was previousl mthct
                    break;
                // Add the missing action in the May case.
                case "may":
                case "MAY":
                case "May":
                    System.out.println("The merry month of May");
                    monthNumber = 5;         // monthNumber, was previousl mthct 
                    break;
                case "june":
                case "JUNE":
                case "June":
                    System.out.println("Moon, swoon, June");
                    monthNumber = 6;         // monthNumber, was previousl mthct
                    break;
                // Born on the 4th of July
                case "july":
                case "JULY":
                case "July":
                    System.out.println("Born on the 4th of July");
                    monthNumber = 7;         // monthNumber, was previousl mthct
                    break;
                // Augustus Caesar
                case "august":
                case "AUGUST":
                case "August":
                    System.out.println("Augustus Caesar");
                    monthNumber = 8;         // monthNumber, was previousl mthct
                    break;
                // Thirty days hath September
                // Try to remember the kind of September
                case "september":
                case "SEPTEMBER":
                case "September":
                    System.out.println("Thirty days hath September");
                    monthNumber = 9;         // monthNumber, was previousl mthct
                    break;
                // October Sky
                case "october":
                case "OCTOBER":
                case "October":
                    System.out.println("October Sky");
                    monthNumber = 10;        // monthNumber, was previousl mthct
                    break;
                // November, n. The eleventh twelfth of a weariness.
                case "november":
                case "NOVEMBER":
                case "November":
                    System.out.println("November, n. The eleventh twelfth of a "
                            + "weariness.");
                    monthNumber = 11;        // monthNumber, was previousl mthct
                    break;
                // It is December, and nobody asked if I was ready
                case "december":
                case "DECEMBER":
                case "December":
                    System.out.println("It is December, and nobody asked if I "
                            + "was ready");
                    monthNumber = 12;        // monthNumber, was previousl mthct
                    break;
                default:
                    System.out.println("Not a month");
                    break;
            }
            System.out.println("Give a date input in the form of "
                    + "\"Tuesday February 21, 2017\".\n  "
                    + "If finished, enter \"Done\" :  ");
            weekDay = input.next();  //weekDay, was previously a
            datesCounter++;          // datesCounter, was previously count
        }
// Write a meaningful message in the output statement below with count(datesCounter)
        System.out.println("The number of dates that the user entered is: " 
                + datesCounter);
        // datesCounter, was previously count   
    }

}
