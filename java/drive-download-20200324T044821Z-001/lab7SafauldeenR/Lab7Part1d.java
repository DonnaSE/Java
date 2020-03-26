/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7part1d;

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
public class Lab7Part1d {

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
        String standing = "";
        String classYearOutput = "";
        int studentCount = 0;
        String studentData;
        String student[] = new String[9];
        boolean match = true;
//1.d.i)
        while ((input.hasNextLine())) { //loop will continue for all tle stuednts valid data
            studentData = input.nextLine();//read one line from the file
            student = studentData.split("\\t");//1D array
            if ((student.length == 9) && (lastName != ",")) {

                lastName = student[0];
                firstName = student[1];
//1.d.ii)       
                utaID = Long.parseLong(student[2]);
                birthdate = Integer.parseInt(student[5]);
                gpa = Double.parseDouble(student[6]);
                totalUTAhours = Integer.parseInt(student[7]);
                classYear = student[4];
                major = student[3];
                account = Double.parseDouble(student[8]);
                diffBtwnDates = Age(birthdate);
                age = diffBtwnDates / 365.0;

                if ((gpa < 2) && (gpa >= 0) && (totalUTAhours < 30)) {
                    standing = "On Probation";
                } else if ((gpa < 2) && (gpa >= 0) && (totalUTAhours >= 30)) {
                    standing = "On Dismissal";
                } else if ((gpa < 2.25) && (gpa <= 2) && (totalUTAhours >= 30)) {
                    standing = "On Probation";// I think we have to chose another words for this string
                } else {
                    standing = "Good";
                }
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
//1.d.vi)                
                // System.out.println("classYearOutput is "+classYearOutput);
                System.out.printf("%s %s ", firstName, lastName);
                System.out.printf("ID number %d, is ", utaID);
                System.out.printf("a %s major, and is %.2f years old with a ", major, age);
                if (birthdate < 100000) {
                    System.out.printf("birthday of 0%d.\n", birthdate);
                } else {
                    System.out.printf("birthday of %d.\n", birthdate);
                }

                System.out.printf("%s's academic standing is %s with %.3f GPA.\n", firstName, standing, gpa);

                System.out.printf("%s is a %s with %d hours.", firstName, classYearOutput, totalUTAhours);
//1.d.iii)
                if ((classYear.equalsIgnoreCase("FR")) && ((totalUTAhours >= 0) && (totalUTAhours <= 30))) {
                    match = true;
                } else if ((classYear.equalsIgnoreCase("SO")) && ((totalUTAhours >= 31) && (totalUTAhours <= 60))) {
                    match = true;
                } else if ((classYear.equalsIgnoreCase("JR")) && ((totalUTAhours >= 61) && (totalUTAhours <= 90))) {
                    match = true;
                } else if ((classYear.equalsIgnoreCase("SR")) && ((totalUTAhours >= 90))) {
                    match = true;
                } else if ((classYear.equalsIgnoreCase("SPEC")) || (classYear.equalsIgnoreCase("MS"))
                        || (classYear.equalsIgnoreCase("PHD")) || (classYear.equalsIgnoreCase("5TH"))) {
                    match = true;
                } else {
                    match = false;
                    System.out.print(" There is a mismatch in the data for class year and hours.");
                }
//1.d.iv)                
                if (((classYear.equalsIgnoreCase("5TH")) && (totalUTAhours > 150))
                        || ((classYear.equalsIgnoreCase("SR")) && (totalUTAhours > 150))) {
                    System.out.printf("\n%s is subject to non-resident tuition for excessive hours.", firstName);
                }
                System.out.printf("\n%s has an account balance of %.2f and ", firstName, account);
//1.d.v)                
                if (account < 0) {
                    System.out.printf("This student owes the %.2f amount of money.\n", account);
                } else {
                    System.out.println("has no outstanding charges at this time.");
                }

            } else {
                correct = false;
                input.nextLine();// this code to go to the bigenning of the next line
            }
            System.out.println("");
            correct = true;// resat the flage and make it true to state the loop again
            match = true;
//1.d.vii) continue reading the data of student and print it until last line 
            // because it is insid while loop            
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
