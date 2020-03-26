/*
* practis and explore Java world
 */
package a;

import java.util.Scanner;

/**
 *
 * @author RS
 */
public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int classNumber = 20;
        double classNum2;
        double classNum1;
        classNum2 = 1.5;
        double tax = 5;
        System.out.println("the class's first number is " + classNumber
                + " and 2nd is " + classNum2);
        System.out.print("please enter a number: ");
        classNumber = input.nextInt();
        System.out.println("the user's number is: " + classNumber);
        System.out.print("enter another number: ");
        classNum1 = input.nextDouble();
        System.out.println("رغد أحمد " + classNum1);
        String str = "How Now Brown Cow?";
        String rag;
        rag = str.substring(1, 5);
        System.out.println("the result is " + rag);
        System.out.println("the substring at index of 1 to 5 of the string  " + str + " is " + rag);
        String uppr = str.toUpperCase();
        System.out.println("to change the string to upper case it will be: \n\n" + uppr);
        System.out.printf("the number with .01 is %.01f\n",tax );

    }
}
