/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2part4;

/**
 *
 * @author Raghad Safauldeen
 */
public class Lab2Part4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double boxHeightInFeet = 1.5;
        double boxWidthInFeet = 0.5;
        double boxDepthInFeet = 0.75;
        double boxWeightInKilograms = 4.5;
        double rouBoxHightInFeet;
        rouBoxHightInFeet = Math.round(boxHeightInFeet);
        double boxHeightInInch = 12 * rouBoxHightInFeet;
        double boxWidthInInch = 12 * boxWidthInFeet;
        double boxDepthInInch = 12 * boxDepthInFeet;
        System.out.printf("Box height in feet is %3.1f and Box height in inches"
                + " is %4.1f\n", rouBoxHightInFeet, boxHeightInInch);
        System.out.printf("Box width in feet is %3.1f and Box width in inches "
                + "is %3.1f\n", boxWidthInFeet, boxWidthInInch);
        System.out.printf("Box depth in feet is %4.2f and Box depth in inches "
                + "is %3.1f\n\n", boxDepthInFeet, boxDepthInInch);
        double volume = (boxHeightInInch * boxWidthInInch * boxDepthInInch);
        System.out.printf("Box volume in inches is %7.2f\n\n", volume);
        double boxWeightPerInch = (boxWeightInKilograms / volume);
        double boxWeightInLB = (2.2 * boxWeightInKilograms);
        System.out.printf("Box weight in Kg is %4.2f\n", boxWeightInKilograms);
        System.out.printf("Box weight in Kg per inch is %8.6f\n",
                boxWeightPerInch);
        System.out.printf("Box weight in Lb is %4.2f\n", boxWeightInLB);
    }
}
