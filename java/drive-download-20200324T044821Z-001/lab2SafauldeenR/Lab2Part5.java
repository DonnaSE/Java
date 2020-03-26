/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2part5;

import java.util.Scanner;

/**
 *
 * @author Raghad Safauldeen
 */
public class Lab2Part5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("please enter a floating point number for the height "
                + "of the box in feet: ");
        double boxHeightInFeet = in.nextDouble();
        System.out.print("please enter a floating point number for the width of"
                + " the box in feet: ");
        double boxWidthInFeet = in.nextDouble();
        System.out.print("please enter a floating point number for the depth of"
                + " the box in feet: ");
        double boxDepthInFeet = in.nextDouble();

        System.out.print("please enter a floating point number for the weight "
                + "of the box in Kilograms: ");
        double boxWeightInKilograms = in.nextDouble();
        double rouBoxHightInFeet = Math.round(boxHeightInFeet);
        double boxHeightInInch = (12 * rouBoxHightInFeet);
        double boxWidthInInch = (12 * boxWidthInFeet);
        double boxDepthInInch = (12 * boxDepthInFeet);
        double volumeInch = (boxHeightInInch * boxWidthInInch * boxDepthInInch);
        double volumeFeet = (boxHeightInFeet * boxWidthInFeet * boxDepthInFeet);
        double boxWeightPerInch = (boxWeightInKilograms / volumeInch);
        double boxWeightInLB = (2.2 * boxWeightInKilograms);

        System.out.printf("\n%10s %10s %10s %10s %10s\n", "Unit", "Height",
                "Width", "Depth", "Volume");
        System.out.printf("%10s %10.1f %10.1f %10.1f %10.1f\n", "Inches",
                boxHeightInInch, boxWidthInInch, boxDepthInInch, volumeInch);

        System.out.printf("%10s %10.2f %10.2f %10.2f %10.2f\n\n", "Feet",
                boxHeightInFeet, boxWidthInFeet, boxDepthInFeet, volumeFeet);
        System.out.printf("%10s %10s %10s\n", "Weight in Pounds", " Kilograms",
                "Kg per In");
        System.out.printf("%10.4f    %10.4f %10.4f\n", boxWeightInLB,
                boxWeightInKilograms, boxWeightPerInch);
    }

}
