/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3part3a;

import java.util.Scanner;

/**
 *
 * @author Raghad Safauldeen
 */
public class Lab3Part3a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double price = 0;
        int quantity = 0;
        double groceryBill = 0;
        double runningSum = 0;
        int itemCount = 0;
        double highestPrice = 0;
        int largestQuantity = 0;

        while (price != -1) {
            System.out.printf("\nPlease enter the price for your "
                    + "grocery, then enter an integer for the quantity, enter -1 to quit: ");
            price = input.nextDouble();
            if (price != -1) {
                quantity = input.nextInt();

                if (price < 0 || quantity < 0) {
                    System.out.println("invalid input.");
                    System.out.println("Please enter positive numbers.");

                } else if ((price > 0) && (quantity > 0)) {
                    groceryBill = price * quantity;
                    System.out.printf("The total cost for this product is $%.2f\n", groceryBill);
                    runningSum = runningSum + groceryBill;
                    itemCount = itemCount + 1;
                    if (price > highestPrice) {
                        highestPrice = price;
                    }
                    if (quantity > largestQuantity) {
                        largestQuantity = quantity;
                    }
                }
                System.out.printf("The total grocery bill is $%.2f\n", runningSum);
                System.out.println("The quantity is " + itemCount);
                System.out.printf("The most expensive item costs $%.2f\n", highestPrice);
                System.out.println("The largest quantity of any item you "
                        + "bought is " + largestQuantity);
            }
        }
    }
}
