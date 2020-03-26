/*
 I will store each student data in two 2D arrays one of them is for the strings,
and the other one for doubles.
wish me good luck to do this correctly, finger cross.
 */
package lab7part1f;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author RS
 */
public class Lab7Part1f {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File inFile = new File("students2.txt");
        Scanner input = null;
        PrintWriter outFile = null;
        try {
            input = new Scanner(inFile);
            outFile = new PrintWriter("studentsOut.txt");
        } catch (FileNotFoundException fnf) {
            System.out.println("file not found");
        }
        boolean correct = true;
        String lastName[] = new String[1000];
        String firstName[] = new String[1000];
        long utaID[] = new long[1000];
        String major[] = new String[1000];
        String classYear[] = new String[1000];
        int birthdate[] = new int[1000];
        double gpa[] = new double[1000];
        int totalUTAhours[] = new int[1000];
        double account[] = new double[1000];
        double diffBtwnDates = 0;

        String standing = "";
        String classYearOutput = "";
        int studentCount = 0;
        boolean match = true;
        int studentCounter = 0;
        boolean find = true;
        String lastN = "";
        String coma = ",";
        double age[] = new double[1000];
        while ((input.hasNext()) && (find)) {
            // System.out.println("studentCounter "+studentCounter);
//1.f.i)    store all of the student data from the file by 1D-arrat, for each column of data  
            input.useDelimiter(",");
            input.useDelimiter("\\t");

            if (input.hasNext() && find) {

                lastName[studentCounter] = input.next();  //lastName
//                 System.out.println("lastName[studentCounter] " + lastName[studentCounter]);
                lastN = lastName[studentCounter];
                //else if (input.hasNext() && find) {
                if (lastN.equalsIgnoreCase(coma)) {
                    find = false;
                }
            } else {
                find = false;
            }
            if (input.hasNext() && find) {
                input.useDelimiter("1");
                input.useDelimiter("\\t");

                firstName[studentCounter] = input.next(); //firstName 
                //firstName[studentCounter]=removeBlancks(firstName[studentCounter]);

                //  System.out.println("firstName[studentCounter] " + firstName[studentCounter]);
            } else {
                find = false;
            }
            input.reset();
            input.useDelimiter("\\t");
            if (input.hasNextLong() && find) {
                utaID[studentCounter] = input.nextLong();  //utaID  
                //   System.out.println("utaID[studentCounter] " + utaID[studentCounter]);
            } else {
                find = false;
            }
            if (input.hasNext() && find) {
                input.useDelimiter("\\t");
                major[studentCounter] = input.next();  //major
                //       System.out.println(" major[studentCounter] " + major[studentCounter]);
            } else {
                find = false;
            }
            if (input.hasNext() && find) {
                input.useDelimiter("\\t");
                classYear[studentCounter] = input.next();  //classYear  
                //    System.out.println("classYear[studentCounter]  " + classYear[studentCounter]);
            } else {
                find = false;
            }
            if (input.hasNextInt() && find) {
                input.useDelimiter("\\t");
                birthdate[studentCounter] = input.nextInt();  //birthdate 
                //    System.out.println("birthdate[studentCounter]  " + birthdate[studentCounter]);
            } else {
                find = false;
            }
            if (input.hasNextDouble() && find) {
                input.useDelimiter("\\t");
                gpa[studentCounter] = input.nextDouble();   //gpa 
                //   System.out.println(" gpa[studentCounter] " + gpa[studentCounter]);
            } else {
                find = false;
            }
            if (input.hasNextInt() && find) {
                input.useDelimiter("\\t");
                totalUTAhours[studentCounter] = input.nextInt();  //totalUTAhours 
                //    System.out.println("totalUTAhours[studentCounter] " + totalUTAhours[studentCounter]);
            } else {
                find = false;
            }
            input.reset();
            // System.out.println("input.hasNextInt() is "+input.hasNextInt()+" and find is "+find);
            if (input.hasNextDouble() && find) {
                account[studentCounter] = input.nextDouble();//account
                //    System.out.println("input.nextDouble() " +account[studentCounter] );
                //        System.out.println("account[studentCounter]  " + account[studentCounter]);
            } else {
                find = false;
                //  System.out.println("\n");
            }

            input.nextLine();
            if (find) {

                studentCounter++;
                //   System.out.println("\n");
            }
            find = true;
        }
//        System.out.println("studentCounter is " + studentCounter);
//1.f.ii)
//sort the data by the highest GPA (bubble sort)
        int n;
        double max = gpa[0];
        int index = 0;
        for (n = 1; n < studentCounter; n++) {
            if (max < gpa[n]) {
                max = gpa[n];
                index = n;
            }
        }
        System.out.printf("The student(s) who got the highest GPA:\n");
        outFile.printf("The student(s) who got the highest GPA:\n");

        for (n = 0; n < studentCounter; n++) {
            if (gpa[n] == max) {
                System.out.printf("%s %s, major: %s. GPA: %.3f \n",
                        lastName[n], firstName[n], major[n], max);
                outFile.printf("%s %s, major: %s. GPA: %.3f \n",
                        lastName[n], firstName[n], major[n], max);

            }
        }
        System.out.println("\nThe students in the order they are stored: ");
        outFile.println("\nThe students in the order they are stored: ");
        for (int i = 0; i < studentCounter; i++) {
            System.out.printf("%s %s. major: %s. GPA: %.3f \n",
                    lastName[i], firstName[i], major[i], gpa[i]);
            outFile.printf("%s %s. major: %s. GPA: %.3f \n",
                    lastName[i], firstName[i], major[i], gpa[i]);
        }
        //  System.out.println("studentCounter "+studentCounter);
//1.f.iii)       
        String tempFirstName = "";
        String tempLastName = "";
        String tempMajor = "";

        System.out.println("\n");
        outFile.println("\n");
        for (int i = 0; i < studentCounter; i++) {
            for (int j = 0; j < studentCounter - 1; j++) {

                if ((lastName[j]).compareTo(lastName[j + 1]) > 0 && (find)) {
                    tempLastName = lastName[j + 1];
                    lastName[j + 1] = lastName[j];
                    lastName[j] = tempLastName;

                    tempLastName = firstName[j + 1];
                    firstName[j + 1] = firstName[j];
                    firstName[j] = tempLastName;

                    tempMajor = major[j + 1];
                    major[j + 1] = major[j];
                    major[j] = tempMajor;

                }
            }
        }
        System.out.println("The sorted data by last name is: ");
        outFile.println("The sorted data by last name is: ");
        for (int i = 0; i < studentCounter; i++) {
            System.out.printf("%s %s his major is %s \n", lastName[i], firstName[i], major[i]);
            outFile.printf("%s %s his major is %s\n", lastName[i], firstName[i], major[i]);
        }
        double tempGpa;
        System.out.println("\n");
        outFile.println("\n");
        for (int i = 0; i < studentCounter; i++) {
            for (int j = 0; j < studentCounter - 1; j++) {

                if ((firstName[j]).compareTo(firstName[j + 1]) > 0 && (find)) {
                    tempLastName = firstName[j + 1];
                    firstName[j + 1] = firstName[j];
                    firstName[j] = tempLastName;

                    tempLastName = lastName[j + 1];
                    lastName[j + 1] = lastName[j];
                    lastName[j] = tempLastName;

                    tempMajor = major[j + 1];
                    major[j + 1] = major[j];
                    major[j] = tempMajor;

                }
            }
        }
        System.out.println("The sorted data by first name is:");
        outFile.println("The sorted data by first name is:");
        for (int i = 0; i < studentCounter; i++) {
            System.out.printf("%s %s his major is %s\n", lastName[i],
                    firstName[i], major[i]);
            outFile.printf("%s %s his major is %s\n", lastName[i],
                    firstName[i], major[i]);
        }
        System.out.println("\n");
        outFile.println("\n");
        for (int i = 0; i < studentCounter; i++) {
            for (int j = 0; j < studentCounter - 1; j++) {

                if ((major[j]).compareTo(major[j + 1]) > 0 && (find)) {
                    tempLastName = firstName[j + 1];
                    firstName[j + 1] = firstName[j];
                    firstName[j] = tempLastName;

                    tempLastName = lastName[j + 1];
                    lastName[j + 1] = lastName[j];
                    lastName[j] = tempLastName;

                    tempMajor = major[j + 1];
                    major[j + 1] = major[j];
                    major[j] = tempMajor;

                    tempGpa = gpa[j + 1];
                    gpa[j + 1] = gpa[j];
                    gpa[j] = tempGpa;
                }
            }
        }

        System.out.println("The sorted data by major is: ");
        outFile.println("The sorted data by major is: ");
        for (int i = 0; i < studentCounter; i++) {
            System.out.printf("%s %s his major is %s\n", lastName[i], firstName[i], major[i]);
            outFile.printf("%s %s his major is %s\n", lastName[i], firstName[i], major[i]);
        }
//1.f.iv)            
        System.out.println("\n");
        outFile.println("\n");
        int tempBirth;
        for (int i = 0; i < studentCounter; i++) {
            for (int j = 0; j < studentCounter - 1; j++) {

                if (Age(birthdate[j]) > Age(birthdate[j + 1]) && (find)) {
                    tempBirth = birthdate[j + 1];
                    birthdate[j + 1] = birthdate[j];
                    birthdate[j] = tempBirth;

                    tempLastName = firstName[j + 1];
                    firstName[j + 1] = firstName[j];
                    firstName[j] = tempLastName;

                    tempLastName = lastName[j + 1];
                    lastName[j + 1] = lastName[j];
                    lastName[j] = tempLastName;

                    tempMajor = major[j + 1];
                    major[j + 1] = major[j];
                    major[j] = tempMajor;

                }
            }
        }
        System.out.println("The sorted data by birthdate from the youngest to "
                + "the oldest including (first name, last name, and birth date): ");
        outFile.println("The sorted data by birthdate from the youngest to "
                + "the oldest including (first name, last name, and birth date): ");
        for (int i = 0; i < studentCounter; i++) {
            System.out.printf("%s %s. date of birth is %d \n", lastName[i],
                    firstName[i], birthdate[i]);
            outFile.printf("%s %s. date of birth is %d \n", lastName[i],
                    firstName[i], birthdate[i]);

        }

        System.out.println("\n");
        outFile.println("\n");

        for (int i = 0; i < studentCounter; i++) {
            for (int j = 0; j < studentCounter - 1; j++) {

                if ((lastName[j]).compareTo(lastName[j + 1]) > 0 && (find)) {
                    tempBirth = birthdate[j + 1];
                    birthdate[j + 1] = birthdate[j];
                    birthdate[j] = tempBirth;

                    tempLastName = firstName[j + 1];
                    firstName[j + 1] = firstName[j];
                    firstName[j] = tempLastName;

                    tempLastName = lastName[j + 1];
                    lastName[j + 1] = lastName[j];
                    lastName[j] = tempLastName;

                    tempMajor = major[j + 1];
                    major[j + 1] = major[j];
                    major[j] = tempMajor;

                }
            }
        }
        System.out.println("The sorted data by last name. this data include"
                + "(last name, first name, and birth date):");
        outFile.println("The sorted data by last name. this data include"
                + "(last name, first name, and birth date):");
        for (int i = 0; i < studentCounter; i++) {
            System.out.printf("%s %s. date of birth is %d \n", lastName[i],
                    firstName[i], birthdate[i]);
            outFile.printf("%s %s. date of birth is %d \n", lastName[i],
                    firstName[i], birthdate[i]);

        }
        System.out.println("\n");
        outFile.println("\n");

        for (int i = 0; i < studentCounter; i++) {
            for (int j = 0; j < studentCounter - 1; j++) {

                if ((firstName[j]).compareTo(firstName[j + 1]) > 0 && (find)) {
                    tempBirth = birthdate[j + 1];
                    birthdate[j + 1] = birthdate[j];
                    birthdate[j] = tempBirth;

                    tempLastName = firstName[j + 1];
                    firstName[j + 1] = firstName[j];
                    firstName[j] = tempLastName;

                    tempLastName = lastName[j + 1];
                    lastName[j + 1] = lastName[j];
                    lastName[j] = tempLastName;

                    tempMajor = major[j + 1];
                    major[j + 1] = major[j];
                    major[j] = tempMajor;

                }
            }
        }
        System.out.println("The sorted data by first name. this data include"
                + "(last name, first name, and birth date):");
        outFile.println("The sorted data by first name. this data include"
                + "(last name, first name, and birth date):");
        for (int i = 0; i < studentCounter; i++) {
            System.out.printf("%s %s. date of birth is %d \n", lastName[i],
                    firstName[i], birthdate[i]);
            outFile.printf("%s %s. date of birth is %d \n", lastName[i],
                    firstName[i], birthdate[i]);

        }

        outFile.close();
    }

    public static double Age(int birthdate) {  //mehtod to calculate the age of the student 
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
