/*
 * recursive function to calculate the exponential function
 */
package lab8part2;

import java.util.Scanner;

/**
 *
 * @author RS
 */
public class Lab8Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = -1;
        int exponent = -1;
        System.out.println("This program will help you to calculate the first "
                + "number (base) to the power of second number (exponent)");
        boolean invalid = true;
        String baseStr, expStr;
        char basech;
        int flag = 1;
        while (invalid) // loop will repeat if invalid input from the user for the base
        {
            flag = 1;
            System.out.printf("Please enter an integer between 1 and 9 as a base: ");
            baseStr = in.next();
            if (baseStr.length() > 1) {
                invalid = true;
                flag = 0;
            }
            basech = baseStr.charAt(0);
            if (flag == 1) {
                if (basech > '9' || basech < '0') {
                    invalid = true;
                    flag = 0;
                } else {
                    base = basech - '0';
                    // System.out.printf("%f\n", base);
                    flag = 1;
                    invalid = false;
                }
            }
        }

        char expch;
        flag = 1;
        invalid = true;
        while (invalid) // loop will repeat if invalid input from the user for theexponent
        {
            flag = 1;
            System.out.printf("Please enter an integer between 1 and 9 as an exponent: ");
            expStr = in.next();
            if (expStr.length() > 1) {
                invalid = true;
                flag = 0;
            }
            expch = expStr.charAt(0);
            if (flag == 1) {
                if (expch > '9' || expch < '0') {
                    invalid = true;
                    flag = 0;
                } else {
                    exponent = expch - '0';
                    //System.out.printf("%f\n", expp);
                    flag = 1;
                    invalid = false;
                }
            }
        }
        int result = calculateExponential(base, exponent);
        System.out.println("The result is " + result);
    }

    public static int calculateExponential(int x, int y) {
        // recursion function to calculat the exponent

        if (y == 1) // Terminating case
        {
            return x;
        } else if (y > 1) // Recursive step
        {
            return x * calculateExponential(x, y - 1);
        }

        return x;
    }
}
