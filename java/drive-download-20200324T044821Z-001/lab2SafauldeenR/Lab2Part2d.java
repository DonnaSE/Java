/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2part2d;

import java.util.Scanner;

/**
 *
 * @author Raghad Safauldeen
 */
public class Lab2Part2d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * ** **
         * Declare the needed input object here using the names shown below in
         * the program. Also add any other needed lines to make the input object
         * function. * ** *
         */
        Scanner input = new Scanner(System.in);
        //input here should be "1310 or 1320"
        System.out.print("Please enter a 4-digit course number of 1310 or"
                + " 1320: ");
        String courseNum = input.next();

        System.out.print("Please enter the current semester (Fall, Spring,"
                + " or Summer): ");
        String sem = input.next();
        String dept = "CSE";
        char comma = ',';
        String sectionNum = "005";
        char dash = '-';
        int year = 2017;
        String sp = " ";
        // output should be semester, year, comma, space, 
        // then dept, course number then section number  
        System.out.println("The course is " + sem + sp + year + comma + sp
                + dept + courseNum + dash + sectionNum);
    }
}
