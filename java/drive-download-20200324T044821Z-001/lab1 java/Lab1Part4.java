/*
 * get two integer from the user 
 */
package lab1part4;

import java.util.Scanner;

/**
 *
 * @author Raghad Safauldeen
 */
public class Lab1Part4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        int a;
        int b;
        System.out.print("Please enter a number ");
        a = myscanner.nextInt();
        System.out.print("Please enter another number ");
        b = myscanner.nextInt();
        double c = Math.pow(a, b);
        System.out.println("Value = " + c);
    }
}
