/*
 * Lab3 Part1
 */
package lab3part1;

import java.util.Scanner;

/**
 *
 * @author jcmtiernan
 */
public class Lab3Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // choose car based on init cost, mpg, $ per gallon, 15Kmiles yrly, 10 yr
        double priceCar1;
        double priceCar2;
        double mpgCar1;
        double mpgCar2;
        double costPerGallon = 2.75;
        double milesPerYear = 15000;
        double years = 10;
        double oldMaint = .1;
        double newMaint = .04;
        int maintYear = 2007;

        double totalCar1;
        double totalCar2;
        String nameCar1;
        String nameCar2;
        int yearCar1;
        int yearCar2;
        double maintenance1 = 235.00;
        double maintenance2 = 235.00;
        Scanner input = new Scanner(System.in);

        String tempString1;
        String tempString2;
        double tempDouble1;
        double tempDouble2;
        char nl = '\n';

        priceCar1 = 965;
        priceCar2 = 2643;
        mpgCar1 = 19;
        mpgCar2 = 14;
        nameCar1 = "Yugo Cabrio";
        nameCar2 = "Suzuki Samarai";
        maintenance1 = priceCar1 * .04;
        maintenance2 = priceCar2 * .04;
        yearCar1 = 1991;
        yearCar2 = 1995;

        System.out.println("This program will help you choose a car "
                + "based on cost over time.");
        System.out.println();
        System.out.print("Please enter, on one line, the make, model and year"
                + nl + " of the first comparison car: ");
        tempString1 = input.nextLine();
        nameCar1 = inputCheckCar((tempString1.split(" ").length < 3),
                "make and model", tempString1, nameCar1);
        if (tempString1.split(" ").length == 3) {
            try {
                tempDouble1 = Integer.parseInt(tempString1.split(" ")[2]);
                yearCar1 = (int) inputCheck((tempDouble1 < 1900),
                        "year", tempDouble1, yearCar1);
            } catch (NumberFormatException nfe) {
                yearCar1 = (int) inputCheck(true,
                        "year", -1, yearCar1);
            }
        }

        System.out.print("Please enter the make, model, and year of the "
                + "second comparison car: ");
        tempString2 = input.nextLine();
        nameCar2 = inputCheckCar((tempString2.split(" ").length < 3),
                "make and model", tempString2, nameCar2);
        if (tempString2.split(" ").length == 3) {
            try {
                tempDouble2 = Integer.parseInt(tempString2.split(" ")[2]);
                yearCar2 = (int) inputCheck((tempDouble2 < 1900),
                        "year", tempDouble2, yearCar2);
            } catch (NumberFormatException nfe) {
                yearCar2 = (int) inputCheck(true,
                        "year", -1, yearCar2);
            }
        }

        System.out.print("Please enter the price and the "
                + "average miles per gallon of the " + nameCar1 + ": ");
        tempDouble1 = input.nextDouble();
        priceCar1 = inputCheck((tempDouble1 < 0),
                "price", tempDouble1, priceCar1);

        tempDouble1 = input.nextDouble();
        mpgCar1 = inputCheck((tempDouble1 < 0),
                "mpg", tempDouble1, mpgCar1);

        System.out.print("Please enter the price and the "
                + "average miles per gallon of the " + nameCar2 + ": ");
        tempDouble2 = input.nextDouble();
        priceCar2 = inputCheck((tempDouble2 < 0),
                "price", tempDouble2, priceCar2);

        tempDouble2 = input.nextDouble();
        mpgCar2 = inputCheck((tempDouble2 < 0),
                "mpg", tempDouble2, mpgCar2);

        /*
            1.a. Allow the user to specify the year to separate "old" cars
                 and "new" cars.  Error check the year to make sure it 
                 is meaningful.
         */
        System.out.print("\nPlease enter a four-digit year which you consider"
                + " as an old year for a car: ");
        maintYear = input.nextInt();

        while (maintYear < 1900 || maintYear > 2017) {
            System.out.println("invalid year. ");
            System.out.print(" Enter a valid year: ");
            maintYear = input.nextInt();
        }

        /* 
        1.b. Have user select a percentage of original price to 
                 assign for maintenance cost of "new" cars and "old" cars.
                 No error checking is needed for this question.
         */
        System.out.print("\nWhat percentage of the original price of the new car "
                + "that you want to assign for maintenance? ");
        newMaint = input.nextDouble();
        System.out.print("\nWhat percentage of the original price of the old car "
                + "that you want to assign for maintenance? ");
        oldMaint = input.nextDouble();

        if (yearCar1 >= maintYear) {
            maintenance1 = priceCar1 * newMaint;
        } else {
            maintenance1 = priceCar1 * oldMaint;
        }
        if (yearCar2 >= maintYear) {
            maintenance2 = priceCar2 * newMaint;
        } else {
            maintenance2 = priceCar2 * oldMaint;
        }

        /*
            1.c. Allow the user to specify the number of years to consider for cost
                 No error checking is needed for this question. 
         */
        System.out.print("\nHow long do you want to keep the car in order to "
                + "calculate the cost for the car? (enter the number of the years) ");
        years = input.nextDouble();  // ex. may be the user want to keep the car  
        // for five years and a half.

        /*
            1.d. Accept the costPerGallon from user IF desired
                 No error checking is needed for this question.
         */
        System.out.println("\nDo you want the program to calculate the cost per "
                + "gallon as 2.75? \n if you are fine with that enter yes, "
                + "else enter no.");
        String userAnswer = input.next();
        if (userAnswer.equalsIgnoreCase("yes")) {
            costPerGallon = costPerGallon;
        } else if (userAnswer.equalsIgnoreCase("no")) {
            System.out.print("\n What is your number as cost per gallon? ");
            costPerGallon = input.nextDouble();
        }
        /*
        else 
        {
            System.out.println("Invalid input");
        }
         */
        // cost for car is init price plus cost per year times 10
        // cost per year is miles per year divided by mpg times cost per gallon

        totalCar1 = (milesPerYear / mpgCar1 * costPerGallon
                + maintenance1) * years + priceCar1;
        totalCar2 = (milesPerYear / mpgCar2 * costPerGallon
                + maintenance2) * years + priceCar2;

        System.out.println();
        System.out.println("The comparison of of car costs is the initial price \n"
                + "plus cost per year over " + (int) years + " years with an average \nof "
                + (int) milesPerYear + " miles per year and a price of "
                + costPerGallon + " per gallon of gas plus a \n"
                + "yearly maintenance cost of %"
                + (newMaint * 100) + " of the original car cost \n"
                + "for cars newer than " + maintYear + " and %"
                + (oldMaint * 100) + " for older.");
        System.out.println();
        System.out.print("Total cost for the " + nameCar1 + " is ");
        System.out.printf("%.2f\n", totalCar1);

        System.out.print("Total cost for the " + nameCar2 + " is ");
        System.out.printf("%.2f\n", totalCar2);
        System.out.println();

    }

    public static String inputCheckCar(boolean test, String item,
            String tempStr, String defStr) {
        String t1, t2;
        if (test) {
            System.out.println("This is an invalid " + item + ".");
            System.out.println("Default " + item + " of " + defStr + " will be used.");
            return defStr;
        } else {
            t1 = tempStr.split(" ")[0];
            t2 = tempStr.split(" ")[1];
            return t1 + " " + t2;
        }
    }

    public static double inputCheck(boolean test, String item, double tempDouble, double defDouble) {
        if (test) {
            System.out.println("This is an invalid " + item + ".");
            System.out.println("Default " + item + " of " + defDouble + " will be used.");
            return defDouble;
        } else {
            return tempDouble;
        }
    }

}
