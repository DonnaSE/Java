/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author RS
 */
public class Lab7Part1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File inFile = new File("students1.txt");
        Scanner input = null;
        try {
            input = new Scanner(inFile);
        } catch (FileNotFoundException fnf) {
            System.out.println("file not found");
        }
        // 1.a.i)
        String lastName = "";
        String firstName = "";
        long utaID = 0;
        String major = "";
        String classYear = "";
        int birthdate = 0;
        double gpa = 0;
        int totalUTAhours = 0;
        double account = 0;
        boolean correct = true;
        int studentCounter = 0;
        double diffBtwnDates = 0;
        double years = 0;
        while (input.hasNextLine() && correct) { //loop will continue for all tle stuednts valid data
             
                if (input.hasNext()) {
                    input.useDelimiter(",\\s*");
                    lastName = input.next();
                } else {
                    correct = false;
                }
                if (input.hasNext()) {
                    input.useDelimiter("1");
                    firstName = input.next();
                    firstName = firstName.substring(2);
                } else {
                    correct = false;
                }
                input.reset();

                if (input.hasNextLong()) {
                    utaID = input.nextLong();
                } else {
                    correct = false;
                }
                if (input.hasNext()) {
                    major = input.next();
                } else {
                    correct = false;
                }
                if (input.hasNext()) {
                    classYear = input.next();
                } else {
                    correct = false;
                }
                if (input.hasNextInt()) {
                    birthdate = input.nextInt();
                } else {
                    correct = false;
                }
                if (input.hasNextDouble()) {
                    gpa = input.nextDouble();
                } else {
                    correct = false;
                }
                if (input.hasNextInt()) {
                    totalUTAhours = input.nextInt();
                } else {
                    correct = false;
                }
                if (input.hasNextDouble()) {
                    account = input.nextDouble();
                } else {
                    correct = false;
                }
         

              //1.a.ii)
            if (correct) {

                diffBtwnDates = Age(birthdate);
                years = diffBtwnDates / 365.0;
                //double m = diffBtwnDates%365;
                // double months= m/12;
                // double days = m%12;

                //1.a.iii)
                //1.a.iv) it will continue reading the data and do the same like 1.a.iii) for 
                // each student because the while loop
                System.out.printf("%s %s, ", firstName, lastName);
                System.out.printf("ID number %d, is ", utaID);
                System.out.printf("a %s major with ", major);
                System.out.printf("%d hours and a", totalUTAhours);
                System.out.printf(" %.3f GPA. \n", gpa);
                System.out.printf("%s is a %s, is %.2f years old with "
                        + "a birthday of %d and has an account balance of %.3f\n\n", firstName,
                        classYear, years, birthdate, account);

            }
            correct = true;
            input.nextLine(); // this code to go to the bigenning of the next line

            studentCounter++;
        }
    }

    public static double Age(int birthdate) { //mehtod to calculate the age of the student 
        GregorianCalendar currentTime = new GregorianCalendar(); // for current time
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");

        //  System.out.println(sdf.format(currentTime.getTime())); // format and print the current date
        int yy1 = Calendar.getInstance().get(Calendar.YEAR);

        // System.out.println(yy1);
        int mm1 = Calendar.getInstance().get(Calendar.MONTH);
        int dd1 = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int mm2 = birthdate / 10000;
        int ddyy2 = birthdate % 10000;
        int dd2 = ddyy2 / 100;
        int yy2 = ddyy2 % 100;
        yy2 = (1900 + yy2);

        double diffOfYears = (yy1 - yy2); //the difference between the two dates in year
        double diffOfYearsInDays = (diffOfYears * 365); //(the number of days in diffOfYears)
        //Now find how many days from the beginning of the yy2 until the exact
        // time in the date2 then subtract it from the diffOfYearsInDays.

        // calculat the number of the months from the current date until December 
        // of the current year
        double dayOfTheMonth = 0;
        double totalMonth2Days = 0;
        for (int i = mm2; i < 12; i++) {
            if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8)
                    || (i == 10) || (i == 12)) {
                dayOfTheMonth = 31;
            } else if ((i == 4) || (i == 6) || (i == 9) || (i == 11)) {
                dayOfTheMonth = 30;
            } else if ((i == 2) && (checkLeap(yy2))) {
                dayOfTheMonth = 29;
            } else if ((i == 2) && (!(checkLeap(yy2)))) {
                dayOfTheMonth = 28;
            }
            totalMonth2Days = totalMonth2Days + dayOfTheMonth;
        }

        double x;//x = yyyy2ToCurrentDate but i do not know why java does not like it!!!
        x = 365 - (totalMonth2Days - dd2);
        double daysFromCurrentDateToExpYear = diffOfYearsInDays - x;

        // Now calculating the time in days after the yy1 until the student birth date
        // Make a loop start from first month of the year (January) until mm1
        // which is the birth month In this loop will increment the number of
        // days in each months. Assign the result in mm1Days
        double dayOfTheMonthes1 = 0;
        double MM1Days = 0;
        for (int i = 1; i <= mm1; i++) {
            if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8)
                    || (i == 10) || (i == 12)) {
                dayOfTheMonthes1 = 31;
            } else if ((i == 4) || (i == 6) || (i == 9) || (i == 11)) {
                dayOfTheMonthes1 = 30;
            } else if ((i == 2) && (checkLeap(yy1))) {
                dayOfTheMonthes1 = 29;
            } else if ((i == 2) && (!(checkLeap(yy1)))) {
                dayOfTheMonthes1 = 28;
            }
            MM1Days = MM1Days + dayOfTheMonthes1;
        }
        double daysFromBirthYearToBirthDate = MM1Days + dd1;
        double diffBtwnDates = (daysFromCurrentDateToExpYear + daysFromBirthYearToBirthDate);

        return diffBtwnDates;
    }

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
