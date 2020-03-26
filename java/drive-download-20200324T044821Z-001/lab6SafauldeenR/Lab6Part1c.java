/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6part1c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Raghad Safauldeen
 */
public class Lab6Part1c {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double grades[] = new double[12];
        String names[] = new String[2];

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
        double medianGrade;
        double finalGrade = 0;
        double highest1 = -1;
        double highest2 = -1;
        double highest3 = -1;
        double highest4 = -1;
        double gradesPct1 = 0;
        double gradesPct2 = 0;
        double gradesPctFinal = 0;
        double gradesPctQ1 = 0;
        double gradesPctQ2 = 0;

        double finalGrade1, finalGrade2, finalGrade3, finalGrade4, finalGrade5;
        double finalGrade6, finalGrade7, finalGrade8, finalGrade9, finalGrade10;
        double finalGrade11, finalGrade12;
        finalGrade1 = finalGrade2 = finalGrade3 = finalGrade4 = finalGrade5 = 0;
        finalGrade6 = finalGrade7 = finalGrade8 = finalGrade9 = finalGrade10 = 0;
        finalGrade11 = finalGrade12 = 0;
        double highestGrade = -1;
        double lowestGrade = 1000;
        while (input.hasNext() && studentCounter < 12) {//loop will continue for 12 stuednt valid data

            {
                names[0] = input.next();
                grades[0] = input.nextDouble();
                grades[1] = input.nextDouble();
                grades[2] = input.nextDouble();
                grades[3] = input.nextDouble();
                grades[4] = input.nextDouble();
                grades[5] = input.nextDouble();
                grades[6] = input.nextDouble();
                grades[7] = input.nextDouble();
                grades[8] = input.nextDouble();
                grades[9] = input.nextDouble();
                grades[10] = input.nextDouble();
                grades[11] = input.nextDouble();
                names[1] = input.nextLine();
                names[1] = names[1].substring(1);

                //String firstName = input.nextLine();
                if ((grades[0] >= 0) && (grades[0] <= 100)) {
                    gradesPct1 = (grades[0] * 0.1);

                } else {
                    gradesPct1 = grades[0] * 0;
                    grades[0] = 0;
                }
                if ((grades[1] >= 0) && (grades[1] <= 100)) {
                    gradesPct2 = grades[1] * 0.15;
                } else {
                    gradesPct2 = grades[1] * 0;
                    grades[1] = 0;
                }
                if ((grades[2] >= 0) && (grades[2] <= 200)) {
                    gradesPctFinal = grades[2] * 0.25;
                } else {
                    gradesPctFinal = grades[2] * 0;
                    grades[2] = 0;
                }
                if ((grades[3] < 0) || (grades[3] > 50)) {
                    grades[3] = 0;
                }
                if ((grades[4] < 0) || (grades[4] > 50)) {
                    grades[4] = 0;
                }
                if ((grades[5] < 0) || (grades[5] > 50)) {
                    grades[5] = 0;
                }
                if ((grades[6] < 0) || (grades[6] > 50)) {
                    grades[6] = 0;
                }
                if ((grades[7] < 0) || (grades[7] > 50)) {
                    grades[7] = 0;
                }
                if ((grades[8] < 0) || (grades[8] > 50)) {
                    grades[8] = 0;
                }
                //if (((grades[3] >= 0) && (grades[3] < 51)) && ((grades[4] >= 0) && (grades[4] < 51)) && ((grades[5] >= 0) && (grades[5] < 51))
                  //      && ((grades[6] >= 0) && (grades[6] < 51)) && ((grades[7] >= 0) && (grades[7] < 51)) && ((grades[8] >= 0) && (grades[8] < 51))) {
                    if (highest1 < grades[3]) {
                        highest1 = grades[3];
                    }
                    if (highest1 < grades[4]) {
                        highest1 = grades[4];
                    }
                    if (highest1 < grades[5]) {
                        highest1 = grades[5];
                    }
                    if (highest1 < grades[6]) {
                        highest1 = grades[6];
                    }
                    if (highest1 < grades[7]) {
                        highest1 = grades[7];
                    }
                    if (highest1 < grades[8]) {
                        highest1 = grades[8];
                    }

                    if ((highest2 < grades[3]) && (grades[3] != highest1)) {
                        highest2 = grades[3];
                    }
                    if ((highest2 < grades[4]) && (grades[4] != highest1)) {
                        highest2 = grades[4];
                    }
                    if ((highest2 < grades[5]) && (grades[5] != highest1)) {
                        highest2 = grades[5];
                    }
                    if ((highest2 < grades[6]) && (grades[6] != highest1)) {
                        highest2 = grades[6];
                    }
                    if ((highest2 < grades[7]) && (grades[7] != highest1)) {
                        highest2 = grades[7];
                    }
                    if ((highest2 < grades[8]) && (grades[8] != highest1)) {
                        highest2 = grades[8];
                    }
                    if ((highest3 < grades[3]) && (grades[3] != highest1) && (grades[3] != highest2)) {
                        highest3 = grades[3];
                    }
                    if ((highest3 < grades[4]) && (grades[4] != highest1) && (grades[4] != highest2)) {
                        highest3 = grades[4];
                    }
                    if ((highest3 < grades[5]) && (grades[5] != highest1) && (grades[5] != highest2)) {
                        highest3 = grades[5];
                    }
                    if ((highest3 < grades[6]) && (grades[6] != highest1) && (grades[6] != highest2)) {
                        highest3 = grades[6];
                    }
                    if ((highest3 < grades[7]) && (grades[7] != highest1) && (grades[7] != highest2)) {
                        highest3 = grades[7];
                    }
                    if ((highest3 < grades[8]) && (grades[8] != highest1) && (grades[8] != highest2)) {
                        highest3 = grades[8];
                    }

                    if ((highest4 < grades[3]) && (grades[3] != highest1) && (grades[3] != highest2) && (grades[3] != highest3)) {
                        highest4 = grades[3];
                    }
                    if ((highest4 < grades[4]) && (grades[4] != highest1) && (grades[4] != highest2) && (grades[4] != highest3)) {
                        highest4 = grades[4];
                    }
                    if ((highest4 < grades[5]) && (grades[5] != highest1) && (grades[5] != highest2) && (grades[5] != highest3)) {
                        highest4 = grades[5];
                    }
                    if ((highest4 < grades[6]) && (grades[6] != highest1) && (grades[6] != highest2) && (grades[6] != highest3)) {
                        highest4 = grades[6];
                    }
                    if ((highest4 < grades[7]) && (grades[7] != highest1) && (grades[7] != highest2) && (grades[7] != highest3)) {
                        highest4 = grades[7];
                    }
                    if ((highest4 < grades[8]) && (grades[8] != highest1) && (grades[8] != highest2) && (grades[8] != highest3)) {
                        highest4 = grades[8];
                    }

                    if (grades[11] == 6) {
                        highest1 = highest1 * 0.12;
                        highest2 = highest2 * 0.12;
                        highest3 = highest3 * 0.12;
                        highest4 = highest4 * 0.12;
                    } else if (grades[11] == 5) {
                        highest1 = highest1 * 0.115;
                        highest2 = highest2 * 0.115;
                        highest3 = highest3 * 0.115;
                        highest4 = highest4 * 0.115;
                    } else if (grades[11] == 4) {
                        highest1 = highest1 * 0.10;
                        highest2 = highest2 * 0.10;
                        highest3 = highest3 * 0.10;
                        highest4 = highest4 * 0.10;
                    } else if (grades[11] < 4) {
                        highest1 = highest1 * 0.075;
                        highest2 = highest2 * 0.075;
                        highest3 = highest3 * 0.075;
                        highest4 = highest4 * 0.075;
                    }

                    if ((grades[9] >= 0) && (grades[9] < 11)) {
                        gradesPctQ1 = grades[9] * 0.01;
                    } else {
                        gradesPctQ1 = grades[9] * 0;
                    }
                    if ((grades[10] >= 0) && (grades[10] < 11)) {
                        gradesPctQ2 = grades[10] * 0.01;
                    } else {
                        gradesPctQ2 = grades[10] * 0;
                    }
                    finalGrade = (gradesPct1 + gradesPct2 + gradesPctFinal + highest1 + highest2 + highest3 + highest4
                            + gradesPctQ1 + gradesPctQ2);
                    /*
                System.out.printf("The highest hw is %.2f  the second highest "
                        + "is %.2f  the third highest is %.2f  the fourth highest"
                        + " is %.2f ",highest1, highest2, highest3, highest4);
                     */

                    //System.out.println("\n");
                    System.out.printf("Test1 %5.2f  test2 %5.2f  final %5.2f  HW1 %5.2f  "
                            + "HW2 %5.2f  HW3 %5.2f  HW4 %5.2f  HW5 %5.2f  HW6 %5.2f "
                            + " quiz1 %5.2f"
                            + "  quiz2 %5.2f \n", grades[0], grades[1], grades[2], + +grades[3], grades[4], grades[5], grades[6], + +grades[7], grades[8], grades[9], grades[10]);

                    System.out.printf("%s, %s: the finnal grade is %.2f ", names[0], names[1], finalGrade);
                    System.out.println("\n");

                    gradeTotal = gradeTotal + finalGrade;

                    studentCounter++;
                }
                if (studentCounter != -1) {
                    if (studentCounter == 1) {
                        finalGrade1 = finalGrade;
                        //   System.out.println("finalGrade1 "+finalGrade1);
                    }
                    if (studentCounter == 2) {
                        finalGrade2 = finalGrade;
                        //    System.out.println("finalGrade2 "+finalGrade2);
                    }
                    if (studentCounter == 3) {
                        finalGrade3 = finalGrade;
                        //     System.out.println("finalGrade3 "+finalGrade3);
                    }
                    if (studentCounter == 4) {
                        finalGrade4 = finalGrade;
                        //     System.out.println("finalGrade4 "+finalGrade4);
                    }
                    if (studentCounter == 5) {
                        finalGrade5 = finalGrade;
                        //     System.out.println("finalGrade5 "+finalGrade5);
                    }
                    if (studentCounter == 6) {
                        finalGrade6 = finalGrade;
                        //   System.out.println("finalGrade6 "+finalGrade6);
                    }
                    if (studentCounter == 7) {
                        finalGrade7 = finalGrade;
                        //  System.out.println("finalGrade7 "+finalGrade7);
                    }
                    if (studentCounter == 8) {
                        finalGrade8 = finalGrade;
                        //    System.out.println("finalGrade8 "+finalGrade8);
                    }
                    if (studentCounter == 9) {
                        finalGrade9 = finalGrade;
                        //   System.out.println("finalGrade9 "+finalGrade9);
                    }
                    if (studentCounter == 10) {
                        finalGrade10 = finalGrade;
                        //   System.out.println("finalGrade10 "+finalGrade10);
                    }
                    if (studentCounter == 11) {
                        finalGrade11 = finalGrade;
                        //   System.out.println("finalGrade11 "+finalGrade11);
                    }
                    if (studentCounter == 12) {
                        finalGrade12 = finalGrade;
                        //    System.out.println("finalGrade12 "+finalGrade12);
                    }
                }
            }
        
        gradeAverage = (gradeTotal / 12);
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
