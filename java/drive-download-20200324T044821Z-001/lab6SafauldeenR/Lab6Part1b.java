/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6part1b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Raghad Safauldeen
 */
public class Lab6Part1b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File inFile = new File("grades1.txt");
        Scanner input = null;
        try {
            input = new Scanner(inFile);
        } catch (FileNotFoundException fnf) {
            System.out.println("file not found");
        }
        int studentCounter = 0;
        double gradeTotal = 0;
        double gradeAverage = 0;
        double medianGrade = 0;
        double finalGrade = 0;
        double highest1 = -1;
        double highest2 = -1;
        double highest3 = -1;
        double highest4 = -1;
        double finalGrade1, finalGrade2, finalGrade3, finalGrade4, finalGrade5;
        double finalGrade6, finalGrade7, finalGrade8, finalGrade9, finalGrade10;
        double finalGrade11, finalGrade12;
        finalGrade1 = finalGrade2 = finalGrade3 = finalGrade4 = finalGrade5 = 0;
        finalGrade6 = finalGrade7 = finalGrade8 = finalGrade9 = finalGrade10 = 0;
        finalGrade11 = finalGrade12 = 0;
        double highestGrade = -1;
        double lowestGrade = 1000;
        double t1Pct = 0;
        double t2Pct = 0;
        double finalPct = 0;
        double q1Pct = 0;
        double q2Pct = 0;
        while (input.hasNext() && studentCounter < 12) {
            String lastName = input.next();
            double t1 = input.nextDouble();
            double t2 = input.nextDouble();
            double tFinal = input.nextDouble();
            double hw1 = input.nextDouble();
            double hw2 = input.nextDouble();
            double hw3 = input.nextDouble();
            double hw4 = input.nextDouble();
            double hw5 = input.nextDouble();
            double hw6 = input.nextDouble();
            double q1 = input.nextDouble();
            double q2 = input.nextDouble();
            int hwCount = input.nextInt();

            String firstName = input.nextLine();
            firstName = firstName.substring(1);

            if ((t1 >= 0) && (t1 <= 100)) {
                t1Pct = t1 * 0.1;
            } else {
                t1Pct = t1 * 0;
            }
            if ((t2 >= 0) && (t2 <= 100)) {
                t2Pct = t2 * 0.15;
            } else {
                t2Pct = t2 * 0;
            }
            if ((tFinal >= 0) && (tFinal <= 200)) {
                finalPct = tFinal * 0.25;
            } else {
                finalPct = tFinal * 0;

            }
            if ((hw1 < 0) || (hw1 > 50)) {
                hw1 = 0;
            }
            if ((hw2 < 0) || (hw2 > 50)) {
                hw2 = 0;
            }
            if ((hw3 < 0) || (hw3 > 50)) {
                hw3 = 0;
            }
            if ((hw4 < 0) || (hw4 > 50)) {
                hw4 = 0;
            }
            if ((hw5 < 0) || (hw5 > 50)) {
                hw5 = 0;
            }
            if ((hw6 < 0) || (hw6 > 50)) {
                hw6 = 0;
            }
            //if (((hw1 >= 0) && (hw1 < 51)) && ((hw2 >= 0) && (hw2 < 51)) && ((hw3 >= 0) && (hw3 < 51))
            //       && ((hw4 >= 0) && (hw4 < 51)) && ((hw5 >= 0) && (hw5 < 51)) && ((hw6 >= 0) && (hw6 < 51))) {
            if (highest1 < hw1) {
                highest1 = hw1;
            }
            if (highest1 < hw2) {
                highest1 = hw2;
            }
            if (highest1 < hw3) {
                highest1 = hw3;
            }
            if (highest1 < hw4) {
                highest1 = hw4;
            }
            if (highest1 < hw5) {
                highest1 = hw5;
            }
            if (highest1 < hw6) {
                highest1 = hw6;
            }
            if ((highest2 < hw1) && (hw1 != highest1)) {
                highest2 = hw1;
            }
            if ((highest2 < hw2) && (hw2 != highest1)) {
                highest2 = hw2;
            }
            if ((highest2 < hw3) && (hw3 != highest1)) {
                highest2 = hw3;
            }
            if ((highest2 < hw4) && (hw4 != highest1)) {
                highest2 = hw4;
            }
            if ((highest2 < hw5) && (hw5 != highest1)) {
                highest2 = hw5;
            }
            if ((highest2 < hw6) && (hw6 != highest1)) {
                highest2 = hw6;
            }
            if ((highest3 < hw1) && (hw1 != highest1) && (hw1 != highest2)) {
                highest3 = hw1;
            }
            if ((highest3 < hw2) && (hw2 != highest1) && (hw2 != highest2)) {
                highest3 = hw2;
            }
            if ((highest3 < hw3) && (hw3 != highest1) && (hw3 != highest2)) {
                highest3 = hw3;
            }
            if ((highest3 < hw4) && (hw4 != highest1) && (hw4 != highest2)) {
                highest3 = hw4;
            }
            if ((highest3 < hw5) && (hw5 != highest1) && (hw5 != highest2)) {
                highest3 = hw5;
            }
            if ((highest3 < hw6) && (hw6 != highest1) && (hw6 != highest2)) {
                highest3 = hw6;
            }

            if ((highest4 < hw1) && (hw1 != highest1) && (hw1 != highest2) && (hw1 != highest3)) {
                highest4 = hw1;
            }
            if ((highest4 < hw2) && (hw2 != highest1) && (hw2 != highest2) && (hw2 != highest3)) {
                highest4 = hw2;
            }
            if ((highest4 < hw3) && (hw3 != highest1) && (hw3 != highest2) && (hw3 != highest3)) {
                highest4 = hw3;
            }
            if ((highest4 < hw4) && (hw4 != highest1) && (hw4 != highest2) && (hw4 != highest3)) {
                highest4 = hw4;
            }
            if ((highest4 < hw5) && (hw5 != highest1) && (hw5 != highest2) && (hw5 != highest3)) {
                highest4 = hw5;
            }
            if ((highest4 < hw6) && (hw6 != highest1) && (hw6 != highest2) && (hw6 != highest3)) {
                highest4 = hw6;
            }

            if (hwCount == 6) {
                highest1 = highest1 * 0.12;
                highest2 = highest2 * 0.12;
                highest3 = highest3 * 0.12;
                highest4 = highest4 * 0.12;
            } else if (hwCount == 5) {
                highest1 = highest1 * 0.115;
                highest2 = highest2 * 0.115;
                highest3 = highest3 * 0.115;
                highest4 = highest4 * 0.115;
            } else if (hwCount == 4) {
                highest1 = highest1 * 0.10;
                highest2 = highest2 * 0.10;
                highest3 = highest3 * 0.10;
                highest4 = highest4 * 0.10;
            } else if (hwCount < 4) {
                highest1 = highest1 * 0.075;
                highest2 = highest2 * 0.075;
                highest3 = highest3 * 0.075;
                highest4 = highest4 * 0.075;
            }

            if ((q1 >= 0) && (q1 < 11)) {
                q1Pct = q1 * 0.01;
            } else {
                q1Pct = q1 * 0;
            }
            if ((q2 >= 0) && (q2 < 11)) {
                q2Pct = q2 * 0.01;
            } else {
                q2Pct = q2 * 0;
            }
            finalGrade = t1Pct + t2Pct + finalPct + highest1 + highest2 + highest3 + highest4
                    + q1Pct + q2Pct;
            /*
                System.out.printf("The highest hw is %.2f  the second highest "
                        + "is %.2f  the third highest is %.2f  the fourth highest"
                        + " is %.2f ",highest1, highest2, highest3, highest4);
             */
            //System.out.println("\n");
            System.out.printf("Test1 %5.2f  test2 %5.2f  final %5.2f  HW1 %5.2f  "
                    + "HW2 %5.2f  HW3 %5.2f  HW4 %5.2f  HW5 %5.2f  HW6 %5.2f "
                    + " quiz1 %5.2f"
                    + "  quiz2 %5.2f \n", t1, t2, tFinal, hw1, hw2, hw3, hw4,
                    +hw5, hw6, q1, q2);

            System.out.printf("%s, %s: the finnal grade is %.2f ", lastName, firstName, finalGrade);
            System.out.println("\n");

            gradeTotal = gradeTotal + finalGrade;
            gradeAverage = (gradeTotal / 12);
            studentCounter++;

            if (studentCounter != -1) {
                if (studentCounter == 1) {
                    finalGrade1 = finalGrade;
                    //System.out.println("finalGrade1 "+finalGrade1);
                }
                if (studentCounter == 2) {
                    finalGrade2 = finalGrade;
                    //System.out.println("finalGrade2 "+finalGrade2);
                }
                if (studentCounter == 3) {
                    finalGrade3 = finalGrade;
                    // System.out.println("finalGrade3 "+finalGrade3);
                }
                if (studentCounter == 4) {
                    finalGrade4 = finalGrade;
                    // System.out.println("finalGrade4 "+finalGrade4);
                }
                if (studentCounter == 5) {
                    finalGrade5 = finalGrade;
                    // System.out.println("finalGrade5 "+finalGrade5);
                }
                if (studentCounter == 6) {
                    finalGrade6 = finalGrade;
                    // System.out.println("finalGrade6 "+finalGrade6);
                }
                if (studentCounter == 7) {
                    finalGrade7 = finalGrade;
                    // System.out.println("finalGrade7 "+finalGrade7);
                }
                if (studentCounter == 8) {
                    finalGrade8 = finalGrade;
                    // System.out.println("finalGrade8 "+finalGrade8);
                }
                if (studentCounter == 9) {
                    finalGrade9 = finalGrade;
                    // System.out.println("finalGrade9 "+finalGrade9);
                }
                if (studentCounter == 10) {
                    finalGrade10 = finalGrade;
                    // System.out.println("finalGrade10 "+finalGrade10);
                }
                if (studentCounter == 11) {
                    finalGrade11 = finalGrade;
                    // System.out.println("finalGrade11 "+finalGrade11);
                }
                if (studentCounter == 12) {
                    finalGrade12 = finalGrade;
                    //System.out.println("finalGrade12 "+finalGrade12);
                }
            }
        }

        if (highestGrade < finalGrade1) {
            highestGrade = finalGrade1;
        }
        if (highestGrade < finalGrade2) {
            highestGrade = finalGrade2;

        }
        if (highestGrade < finalGrade3) {
            highestGrade = finalGrade3;
        }
        if (highestGrade < finalGrade4) {
            highestGrade = finalGrade4;
        }
        if (highestGrade < finalGrade5) {
            highestGrade = finalGrade5;
        }
        if (highestGrade < finalGrade6) {
            highestGrade = finalGrade6;
        }
        if (highestGrade < finalGrade7) {
            highestGrade = finalGrade7;
        }
        if (highestGrade < finalGrade8) {
            highestGrade = finalGrade8;
        }
        if (highestGrade < finalGrade9) {
            highestGrade = finalGrade9;
        }
        if (highestGrade < finalGrade10) {
            highestGrade = finalGrade10;
        }
        if (highestGrade < finalGrade11) {
            highestGrade = finalGrade11;
        }
        if (highestGrade < finalGrade12) {
            highestGrade = finalGrade12;
        }

        if (lowestGrade > finalGrade1) {
            lowestGrade = finalGrade1;
        }
        if (lowestGrade > finalGrade2) {
            lowestGrade = finalGrade2;
        }
        if (lowestGrade > finalGrade3) {
            lowestGrade = finalGrade3;
        }
        if (lowestGrade > finalGrade4) {
            lowestGrade = finalGrade4;
        }
        if (lowestGrade > finalGrade5) {
            lowestGrade = finalGrade5;
        }
        if (lowestGrade > finalGrade6) {
            lowestGrade = finalGrade6;
        }
        if (lowestGrade > finalGrade7) {
            lowestGrade = finalGrade7;
        }
        if (lowestGrade > finalGrade8) {
            lowestGrade = finalGrade8;
        }
        if (lowestGrade > finalGrade9) {
            lowestGrade = finalGrade9;
        }
        if (lowestGrade > finalGrade10) {
            lowestGrade = finalGrade10;
        }
        if (lowestGrade > finalGrade11) {
            lowestGrade = finalGrade11;
        }
        if (lowestGrade > finalGrade12) {
            lowestGrade = finalGrade12;
        }

        // System.out.printf("The number of student is %d \n",studentCounter);
        // System.out.printf("The total grade of the class is %.2f \n", gradeTotal);
        System.out.printf("The average grade of the class is %.2f \n", gradeAverage);
        System.out.printf("the highest grade is %.3f \n", highestGrade);
        System.out.printf("The lowest Grade %.3f \n", lowestGrade);
    }
}
