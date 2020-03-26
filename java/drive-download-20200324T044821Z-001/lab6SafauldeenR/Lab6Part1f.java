/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6part1f;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author RS
 */
public class Lab6Part1f {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //double grades[] = new double[12];
        // String names[] = new String[2];

        File inFile = new File("grades1.txt");
        Scanner input = null;

        PrintWriter outFile = null;//new PrintWriter(gradesOut.txt);
        try {
            input = new Scanner(inFile);
            outFile = new PrintWriter("gradesOut.txt");
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
        int highestLable=0;
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
        String nameSortArray[] = new String[33];
        int lable[] = new int[33];
        int tempLable=0;
        int i, j;
        i = j = 0;
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
            outFile.printf("Test1 %5.2f  test2 %5.2f  final %5.2f  HW1 %5.2f  "
                    + "HW2 %5.2f  HW3 %5.2f  HW4 %5.2f  HW5 %5.2f  HW6 %5.2f "
                    + " quiz1 %5.2f"
                    + "  quiz2 %5.2f \n", grades2D[studentCounter][0], grades2D[studentCounter][1],
                    grades2D[studentCounter][2], grades2D[studentCounter][3], grades2D[studentCounter][4],
                    grades2D[studentCounter][5], grades2D[studentCounter][6], grades2D[studentCounter][7],
                    grades2D[studentCounter][8], grades2D[studentCounter][9], grades2D[studentCounter][10]);

            outFile.printf("%s, %s: the finnal grade is %.2f ", names2D[studentCounter][0],
                    names2D[studentCounter][1], finalGradeArray[studentCounter]);
            outFile.printf("\n\n");
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
         
//       if (studentCounter % 2 == 0) {
//          medianGrade = finalGradeArray[gradeAverage/2];
//        } else {
       
// creating a new copy array for finalGradeArray[]
double [] finalGradeArrayTemp = new double [33];
int u;
for (u = 0; u<33; u++ )
{
    finalGradeArrayTemp[u] = finalGradeArray[u];
        }

double median = medianCount(finalGradeArrayTemp, studentCounter);
   
        // System.out.printf("The number of student is %d \n",studentCounter);
        // System.out.printf("The total grade of the class is %.2f \n", gradeTotal);
        System.out.printf("The average grade of the class is %.2f \n", gradeAverage);
        System.out.printf("the highest grade is %.3f \n", highestGrade);
        System.out.printf("The lowest Grade %.3f \n", lowestGrade);
        System.out.printf("The median is %.3f\n\n", median);

        outFile.printf("The average grade of the class is %.2f \n", gradeAverage);
        outFile.printf("the highest grade is %.3f \n", highestGrade);
        outFile.printf("The lowest Grade %.3f \n", lowestGrade);
        outFile.printf("The median is %.3f\n\n", median);

        // sorting the student by the last name.              
        // Bubble Sort algorithm
        String tempname[]=new String[33];
      double tempGrades[]=new double [33];
      double tempAllGrades=0;
        for (i = 0; i < 33; i++) 
        {
            for (j = 0; j < 33 - 1; j++) 
            {
                if ((names2D[j][0]).compareTo(names2D[j + 1][0]) > 0) 
                {
                    tempname[j] = names2D[j + 1][0];
                    names2D[j + 1][0] = names2D[j][0];
                    names2D[j][0] = tempname[j];
                  for (int m=0 ; m<12; m++ ){
                    tempAllGrades= grades2D[j+1][m];
                    grades2D[j+1][m]=grades2D[j][m];
                    grades2D[j][m]=tempAllGrades;
                          }
                    tempname[j] = names2D[j + 1][1];
                    names2D[j + 1][1] = names2D[j][1];
                    names2D[j][1] = tempname[j];
                    
                   tempGrades[j]=finalGradeArray[j+1];
                   finalGradeArray[j+1]=finalGradeArray[j];
                   finalGradeArray[j]=tempGrades[j];
                }
            }
        }
         
    System.out.printf("\nThe sorted data by the last name: \n\n");
    outFile.printf("\nThe sorted data by the last name: \n\n");
      
        for (i = 0; i < 33; i++) 
        {
              
            System.out.printf("The grades of %s, %s: \n",names2D[i][0],names2D[i][1]);
                outFile.printf("The grades of %s, %s: \n",names2D[i][0],names2D[i][1]);
            for (j=0; j<12 ;j++){
             System.out.print(grades2D[i][j]+"\t");
             outFile.print(grades2D[i][j]+"\t");
            }
         System.out.printf("\n");
         outFile.printf("\n");
//            System.out.printf(" %s,", names2D[i][0]);
//            System.out.printf(" %s:  ", names2D[i][1]);
            System.out.printf("and the final grade:  %.2f \n", finalGradeArray[i]);
            System.out.println(" ");

        
//            outFile.printf(" %s", names2D[i][0]);
//            outFile.printf(" %s:  ", names2D[i][1]);
            outFile.printf("and the final grade is: %.2f \n", finalGradeArray[i]);
        }
        
        outFile.close();
    }
//    public static void printAllGrades(double grades2D[][]){
//         for (int i = 0; i < 33; i++) {
//            for (int j = 0; j < 33 - 1; j++) {
//          System.out.printf("student grades is: %f",grades2D[][]);
//            }}}
    
    public static double medianCount(double finalGradeArray[], int studentCounter){
        double median=0;
         //sort the final grades by booble sort
       double tempFinalGrades[]=new double [33];
       // make another temp array for sorted grades to calculate the median
       double tempFinalGradesSort[]=new double [33];
       for (int i = 0; i < 33; i++) {
            for (int j = 0; j < 33 - 1; j++) {
                if ((finalGradeArray[j])>(finalGradeArray[j+1])) {
                          tempFinalGrades[j]=finalGradeArray[j+1];
                   finalGradeArray[j+1]=finalGradeArray[j];
                   finalGradeArray[j]=tempFinalGrades[j];
            }
            }
       }  
         median = finalGradeArray[(((studentCounter - 1) / 2) + ((studentCounter + 1) / 2)) / 2];
        return median;
    }
}

