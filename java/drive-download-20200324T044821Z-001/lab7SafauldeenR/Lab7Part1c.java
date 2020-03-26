/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1c;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author RS
 */
public class Lab7Part1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File inFile = new File("students2.txt");
        Scanner input = null;
        //PrintWriter outFile = null;
        try {
            input = new Scanner(inFile);
            //outFile = new PrintWriter("gradesOut.txt");
        } catch (FileNotFoundException fnf) {
            System.out.println("file not found");
        }
        boolean correct = true;
        String lastName = "";
        String firstName = "";
        long utaID = 0;
        String major = "";
        String classYear = "";
        int birthdate = 0;
        double gpa = 0;
        int totalUTAhours = 0;
        double account = 0;
        double diffBtwnDates = 0;
        double age = 0;
        int studentCounter = 0;
        String standing = "";
        String classYearOutput = "";
        double maxLong = 9999999999.0;
//1.c.i) 
        while ((input.hasNextLine()) && (correct)) { //loop will continue for all tle stuednts valid data
            String studentData = input.nextLine();
            //reading the entire line of data in as a single string
//1.c.ii)            
            // System.out.println("String line is "+studentData);
            Scanner in = new Scanner(studentData);// make a scanner to read the line
            in.useDelimiter(",\\s* ");
            if (in.hasNext()) {
                lastName = in.next();
                //System.out.println("***last name is "+lastName);
            } else {
                correct = false;
            }
            if (in.hasNext()) {
                in.useDelimiter(" 1");
                firstName = in.next();
                firstName = firstName.substring(2);
                // System.out.println("first name is "+firstName);
            } else {
                correct = false;
            }
            in.reset();
            if (in.hasNextLong()) {
                utaID = in.nextLong();
                if (utaID > maxLong) {
                    correct = false;
                }
                //    System.out.println(utaID);
            } else {
                correct = false;
            }
            if (in.hasNext()) {
                major = in.next();
                if ((major.length() > 4) || (major.length() < 2)) {
                    correct = false;
                }
            } else {
                correct = false;
            }
            if (in.hasNext()) {
                classYear = in.next();
            } else {
                correct = false;
            }
            if (in.hasNextInt()) {
                birthdate = in.nextInt();
                if ((birthdate <= 999999) && (birthdate >= 10000)) {
                    correct = true;
                } else {
                    correct = false;
                }
            } else {
                correct = false;
            }
            if (in.hasNextDouble()) {
                gpa = in.nextDouble();
            } else {
                correct = false;
            }
            if (in.hasNextInt()) {
                totalUTAhours = in.nextInt();
            } else {
                correct = false;
            }
            if (in.hasNextDouble()) {
                account = in.nextDouble();
            } else {
                correct = false;
            }

            diffBtwnDates = Age(birthdate);
            age = diffBtwnDates / 365.0;
            //double m = diffBtwnDates%365;
            // double months= m/12;
            // double days = m%12;
//        System.out.printf("The age of the student is  %.0f years, %.0f months, "
//                + "and %.0f days ",diffBtwnDates, months,days );
//1.c.iii)
            if (correct) {
                if ((gpa < 2) && (gpa >= 0) && (totalUTAhours < 30)) {
                    standing = "On Probation";
                    //System.out.println("****standing "+ standing);
                } else if ((gpa < 2) && (gpa >= 0) && (totalUTAhours >= 30)) {
                    standing = "On Dismissal";
                    //  System.out.println("****standing "+ standing);
                } else if ((gpa < 2.25) && (gpa <= 2) && (totalUTAhours >= 30)) {
                    standing = "On Probation";// I think we have to chose another words for this string
                } else {
                    standing = "Good";
                }
//1.c.iv)Create a string classYearOutput 
                //  System.out.println("****standing "+ standing); 
                if (classYear.equalsIgnoreCase("FR")) {
                    classYearOutput = "freshman";
                } else if (classYear.equalsIgnoreCase("SO")) {
                    classYearOutput = "sophomore";
                } else if (classYear.equalsIgnoreCase("JR")) {
                    classYearOutput = "junior";
                } else if (classYear.equalsIgnoreCase("SR")) {
                    classYearOutput = "senior";
                } else if (classYear.equalsIgnoreCase("5TH")) {
                    classYearOutput = "second baccalaureate student";
                } else if (classYear.equalsIgnoreCase("MS")) {
                    classYearOutput = "master’s student";
                } else if (classYear.equalsIgnoreCase("PHD")) {
                    classYearOutput = "doctoral student";
                } else if (classYear.equalsIgnoreCase("SPEC")) {
                    classYearOutput = "special student";
                }
                // System.out.println("classYearOutput is "+classYearOutput);
//1.c.iv) printing data
//1.c.v Continue reading the data and printing output until all data is read 
// from the file because it is in a while loop 

                System.out.printf("%s %s, ", firstName, lastName);
                System.out.printf("ID number %d, is ", utaID);
                System.out.printf("a %s major with ", major);
                System.out.printf("%d hours and a", totalUTAhours);
                System.out.printf(" %.3f GPA. \n", gpa);
                System.out.printf("%s's academic standing is %s. %s is a %s is %.2f years old with ", firstName, standing, firstName, classYearOutput, age);
                if (birthdate < 100000) {
                    System.out.printf("a birthday of 0%d and has an account balance of %.2f\n\n", birthdate, account);
                } else {
                    System.out.printf("a birthday of %d and has an account balance of %.2f\n\n", birthdate, account);
                }
            }
            // in.nextLine(); // this code to go to the bigenning of the next line
            correct = true;// resat the flage and make it true to state the loop again
            studentCounter++;
        }

    }

    public static double Age(int birthdate) { //mehtod to calculate the age of the student 
        GregorianCalendar currentTime = new GregorianCalendar(); // for current time
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");

        // System.out.println(sdf.format(currentTime.getTime())); // format and print the current date
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
