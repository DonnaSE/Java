/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6part1d;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author RS
 */
public class Lab6Part1d {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //double grades[] = new double[12];
        //String names[] = new String[2];

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
        double grades2D[][] = new double[33][14];
        String names2D[][] = new String[33][14];
        double finalGradeArray[] = new double[33];
        int i = 0;
        while (input.hasNext()) { //loop will continue for all tle stuednts valid data
            names2D[studentCounter][0] = input.next();
            grades2D[studentCounter][0] = input.nextDouble();
            grades2D[studentCounter][1] = input.nextDouble();
            grades2D[studentCounter][2] = input.nextDouble();
            grades2D[studentCounter][3] = input.nextDouble();
            grades2D[studentCounter][4] = input.nextDouble();
            grades2D[studentCounter][5] = input.nextDouble();
            grades2D[studentCounter][6] = input.nextDouble();
            grades2D[studentCounter][7] = input.nextDouble();
            grades2D[studentCounter][8] = input.nextDouble();
            grades2D[studentCounter][9] = input.nextDouble();
            grades2D[studentCounter][10] = input.nextDouble();
            grades2D[studentCounter][11] = input.nextDouble();
            names2D[studentCounter][1] = input.nextLine();
            names2D[studentCounter][1] = names2D[studentCounter][1].substring(1);

            if ((grades2D[studentCounter][0] >= 0) && (grades2D[studentCounter][0] <= 100)) {
                gradesPct1 = (grades2D[studentCounter][0] * 0.1);
            } else {
                gradesPct1 = grades2D[studentCounter][0] = 0;
            }
            if ((grades2D[studentCounter][1] >= 0) && (grades2D[studentCounter][1] <= 100)) {
                gradesPct2 = grades2D[studentCounter][1] * 0.15;
            } else {
                gradesPct2 = grades2D[studentCounter][1] = 0;
            }
            if ((grades2D[studentCounter][2] >= 0) && (grades2D[studentCounter][2] <= 200)) {
                gradesPctFinal = grades2D[studentCounter][2] * 0.25;
            } else {
                gradesPctFinal = grades2D[studentCounter][2] = 0;

            }
            if ((grades2D[studentCounter][3] < 0) || (grades2D[studentCounter][3] > 50)) {
                grades2D[studentCounter][3] = 0;
            }
            if ((grades2D[studentCounter][4] < 0) || (grades2D[studentCounter][4] > 50)) {
                grades2D[studentCounter][4] = 0;
            }
            if ((grades2D[studentCounter][5] < 0) || (grades2D[studentCounter][5] > 50)) {
                grades2D[studentCounter][5] = 0;
            }
            if ((grades2D[studentCounter][6] < 0) || (grades2D[studentCounter][6] > 50)) {
                grades2D[studentCounter][6] = 0;
            }
            if ((grades2D[studentCounter][7] < 0) || (grades2D[studentCounter][7] > 50)) {
                grades2D[studentCounter][7] = 0;
            }
            if ((grades2D[studentCounter][8] < 0) || (grades2D[studentCounter][8] > 50)) {
                grades2D[studentCounter][8] = 0;
            }
            //            if (((grades2D[studentCounter][3] >= 0) && (grades2D[studentCounter][3] < 51))
//                    && ((grades2D[studentCounter][4] >= 0) && (grades2D[studentCounter][4] < 51))
//                    && ((grades2D[studentCounter][5] >= 0) && (grades2D[studentCounter][5] < 51))
//                    && ((grades2D[studentCounter][6] >= 0) && (grades2D[studentCounter][6] < 51))
//                    && ((grades2D[studentCounter][7] >= 0) && (grades2D[studentCounter][7] < 51))
//                    && ((grades2D[studentCounter][8] >= 0) && (grades2D[studentCounter][8] < 51))) {
            if (highest1 < grades2D[studentCounter][3]) {
                highest1 = grades2D[studentCounter][3];
            }
            if (highest1 < grades2D[studentCounter][4]) {
                highest1 = grades2D[studentCounter][4];
            }
            if (highest1 < grades2D[studentCounter][5]) {
                highest1 = grades2D[studentCounter][5];
            }
            if (highest1 < grades2D[studentCounter][6]) {
                highest1 = grades2D[studentCounter][6];
            }
            if (highest1 < grades2D[studentCounter][7]) {
                highest1 = grades2D[studentCounter][7];
            }
            if (highest1 < grades2D[studentCounter][8]) {
                highest1 = grades2D[studentCounter][8];
            }
            if ((highest2 < grades2D[studentCounter][3]) && (grades2D[studentCounter][3] != highest1)) {
                highest2 = grades2D[studentCounter][3];
            }
            if ((highest2 < grades2D[studentCounter][4]) && (grades2D[studentCounter][4] != highest1)) {
                highest2 = grades2D[studentCounter][4];
            }
            if ((highest2 < grades2D[studentCounter][5]) && (grades2D[studentCounter][5] != highest1)) {
                highest2 = grades2D[studentCounter][5];
            }
            if ((highest2 < grades2D[studentCounter][6]) && (grades2D[studentCounter][6] != highest1)) {
                highest2 = grades2D[studentCounter][6];
            }
            if ((highest2 < grades2D[studentCounter][7]) && (grades2D[studentCounter][7] != highest1)) {
                highest2 = grades2D[studentCounter][7];
            }
            if ((highest2 < grades2D[studentCounter][8]) && (grades2D[studentCounter][8] != highest1)) {
                highest2 = grades2D[studentCounter][8];
            }

            if ((highest3 < grades2D[studentCounter][3]) && (grades2D[studentCounter][3] != highest1)
                    && (grades2D[studentCounter][3] != highest2)) {
                highest3 = grades2D[studentCounter][3];
            }
            if ((highest3 < grades2D[studentCounter][4]) && (grades2D[studentCounter][4] != highest1)
                    && (grades2D[studentCounter][4] != highest2)) {
                highest3 = grades2D[studentCounter][4];
            }
            if ((highest3 < grades2D[studentCounter][5]) && (grades2D[studentCounter][5] != highest1)
                    && (grades2D[studentCounter][5] != highest2)) {
                highest3 = grades2D[studentCounter][5];
            }
            if ((highest3 < grades2D[studentCounter][6]) && (grades2D[studentCounter][6] != highest1)
                    && (grades2D[studentCounter][6] != highest2)) {
                highest3 = grades2D[studentCounter][6];
            }
            if ((highest3 < grades2D[studentCounter][7]) && (grades2D[studentCounter][7] != highest1)
                    && (grades2D[studentCounter][7] != highest2)) {
                highest3 = grades2D[studentCounter][7];
            }
            if ((highest3 < grades2D[studentCounter][8]) && (grades2D[studentCounter][8] != highest1)
                    && (grades2D[studentCounter][8] != highest2)) {
                highest3 = grades2D[studentCounter][8];
            }

            if ((highest4 < grades2D[studentCounter][3]) && (grades2D[studentCounter][3] != highest1)
                    && (grades2D[studentCounter][3] != highest2) && (grades2D[studentCounter][3] != highest3)) {
                highest4 = grades2D[studentCounter][3];
            }
            if ((highest4 < grades2D[studentCounter][4]) && (grades2D[studentCounter][4] != highest1)
                    && (grades2D[studentCounter][4] != highest2) && (grades2D[studentCounter][4] != highest3)) {
                highest4 = grades2D[studentCounter][4];
            }
            if ((highest4 < grades2D[studentCounter][5]) && (grades2D[studentCounter][5] != highest1)
                    && (grades2D[studentCounter][5] != highest2) && (grades2D[studentCounter][5] != highest3)) {
                highest4 = grades2D[studentCounter][5];

            }
            if ((highest4 < grades2D[studentCounter][6]) && (grades2D[studentCounter][6] != highest1)
                    && (grades2D[studentCounter][6] != highest2)
                    && (grades2D[studentCounter][6] != highest3)) {
                highest4 = grades2D[studentCounter][6];
            }
            if ((highest4 < grades2D[studentCounter][7]) && (grades2D[studentCounter][7] != highest1)
                    && (grades2D[studentCounter][7] != highest2)
                    && (grades2D[studentCounter][7] != highest3)) {
                highest4 = grades2D[studentCounter][7];
            }

            if ((highest4 < grades2D[studentCounter][8]) && (grades2D[studentCounter][8] != highest1)
                    && (grades2D[studentCounter][8] != highest2) && (grades2D[studentCounter][8] != highest3)) {
                highest4 = grades2D[studentCounter][8];
            }

            if (grades2D[studentCounter][11] == 6) {
                highest1 = highest1 * 0.12;
                highest2 = highest2 * 0.12;
                highest3 = highest3 * 0.12;
                highest4 = highest4 * 0.12;
            } else if (grades2D[studentCounter][11] == 5) {
                highest1 = highest1 * 0.115;
                highest2 = highest2 * 0.115;
                highest3 = highest3 * 0.115;
                highest4 = highest4 * 0.115;
            } else if (grades2D[studentCounter][11] == 4) {
                highest1 = highest1 * 0.10;
                highest2 = highest2 * 0.10;
                highest3 = highest3 * 0.10;
                highest4 = highest4 * 0.10;
            } else if (grades2D[studentCounter][11] < 4) {
                highest1 = highest1 * 0.075;
                highest2 = highest2 * 0.075;
                highest3 = highest3 * 0.075;
                highest4 = highest4 * 0.075;
            }

            if ((grades2D[studentCounter][9] >= 0) && (grades2D[studentCounter][9] < 11)) {
                gradesPctQ1 = grades2D[studentCounter][9] * 0.01;
            } else {
                grades2D[studentCounter][9] = 0;
                gradesPctQ1 = 0;
            }
            if ((grades2D[studentCounter][10] >= 0) && (grades2D[studentCounter][10] < 11)) {
                gradesPctQ2 = grades2D[studentCounter][10] * 0.01;
            } else {
                grades2D[studentCounter][10] = 0;
                gradesPctQ2 = 0;
            }

            finalGradeArray[studentCounter] = (gradesPct1 + gradesPct2 + gradesPctFinal + highest1
                    + highest2 + highest3 + highest4 + gradesPctQ1 + gradesPctQ2);

//                System.out.printf("The highest hw is %.2f  the second highest "
//                        + "is %.2f  the third highest is %.2f  the fourth highest"
//                        + " is %.2f ",highest1, highest2, highest3, highest4);
            //System.out.println("\n");
            System.out.printf("Test1 %5.2f  test2 %5.2f  final %5.2f  HW1 %5.2f  "
                    + "HW2 %5.2f  HW3 %5.2f  HW4 %5.2f  HW5 %5.2f  HW6 %5.2f "
                    + " quiz1 %5.2f"
                    + "  quiz2 %5.2f \n", grades2D[studentCounter][0], grades2D[studentCounter][1],
                    grades2D[studentCounter][2], grades2D[studentCounter][3], grades2D[studentCounter][4],
                    grades2D[studentCounter][5], grades2D[studentCounter][6], grades2D[studentCounter][7],
                    grades2D[studentCounter][8], grades2D[studentCounter][9], grades2D[studentCounter][10]);

            System.out.printf("%s, %s: the finnal grade is %.2f ", names2D[studentCounter][0],
                    names2D[studentCounter][1], finalGradeArray[studentCounter]);
            System.out.println("\n");
            studentCounter++;
        }

        for (i = 0; i < studentCounter; i++) {
            gradeTotal = gradeTotal + finalGradeArray[i];
            gradeAverage = (gradeTotal / studentCounter);

            if (highestGrade < finalGradeArray[i]) {
                highestGrade = finalGradeArray[i];
            }
            if (lowestGrade > finalGradeArray[i]) {
                lowestGrade = finalGradeArray[i];
            }
        }
        if (studentCounter % 2 == 0) {
            medianGrade = studentCounter / 2;
        } else {
            medianGrade = (((studentCounter - 1) / 2) + ((studentCounter + 1) / 2)) / 2;
        }

        //System.out.printf("The number of student is %d \n", studentCounter);
        // System.out.printf("The total grade of the class is %.2f \n", gradeTotal);
        System.out.printf("The average grade of the class is %.2f \n", gradeAverage);
        System.out.printf("the highest grade is %.3f \n", highestGrade);
        System.out.printf("The lowest Grade %.3f \n", lowestGrade);
        System.out.println("The median is " + medianGrade);

    }
}
