/*
 * Game of tic tac toe
 */
package lab8part1;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author RS
 */
public class Lab8Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" #######             #######                  ####### "
                + "                  #####                       ");
        System.out.println("    #    #  ####        #      ##    ####        #  "
                + "   ####  ######    #     #   ##   #    # ###### ");
        System.out.println("    #    # #    #       #     #  #  #    #       #  "
                + "  #    # #         #        #  #  ##  ## #      ");
        System.out.println("    #    # #            #    #    # #            #  "
                + "  #    # #####     #  #### #    # # ## # #####  ");
        System.out.println("    #    # #            #    ###### #            #  "
                + "  #    # #         #     # ###### #    # #      ");
        System.out.println("    #    # #    #       #    #    # #    #       #  "
                + "  #    # #         #     # #    # #    # #      ");
        System.out.println("    #    #  ####        #    #    #  ####        #  "
                + "   ####  ######     #####  #    # #    # ###### ");
        System.out.println("\n");
        String arrayPlace[] = new String[9];
        for (int n = 0; n < 9; n++) {
            arrayPlace[n] = "";
        }

        System.out.print("Please, enter your first name: ");
        String name = input.next();
        System.out.print("What letter do you want X/O: ");
        String letter1 = input.next();
        String player1 = name;
        letter1 = letter1.toUpperCase();
        int place1 = -1;
        if (!((letter1.equalsIgnoreCase("X")) || (letter1.equalsIgnoreCase("O")))) {
            System.out.println("This is not the expected letter");
            place1 = -1;

        } else if ((letter1.equalsIgnoreCase("X")) || (letter1.equalsIgnoreCase("O"))) {
            String player2 = "computer";
            String letter2 = "";
            System.out.println("   0   |   1   |   2   ");
            System.out.println("------------------------");
            System.out.println("   3   |   4   |   5   ");
            System.out.println("------------------------");
            System.out.println("   6   |   7   |   8    \n");
            boolean intNume = false;
            System.out.println("");
            int numberOfInput = 0;
            boolean continueGame = true;

            input.nextLine();
            while (continueGame) {
                // user part
                while (!intNume) {
                    System.out.printf("%s, look at the table above and enter a number that "
                            + "representing the place of your first mark: ", name);
                    String str = input.nextLine();
                    char placeStr = str.charAt(0);
                    if ((placeStr >= '0') && (placeStr < '9')) {
                        place1 = Integer.parseInt("" + placeStr);
                    }
                    if ((place1 >= 0) && (place1 < 9)) {
                        if ((arrayPlace[place1].equals(""))) {
                            numberOfInput++;
                            arrayPlace[place1] = letter1;
                            intNume = true;
                        } else {
                            System.out.println("choose an other number from the table or -1 to quit");
                            intNume = false;
                        }
                    } else {
                        System.out.println("This number is out of range, choose another"
                                + " number from the table or -1 to quit");
                        intNume = false;
                    }

                    if (numberOfInput >= 3) {
                        boolean win = winnerCheck(arrayPlace, letter1);
                        if (win) {
                            System.out.printf("\nCongratulations %s! \r\n\n", name);
                            // print the board
                            gameboard(arrayPlace);
                            continueGame = false;
                        } else {
                            continueGame = true;
                        }
                    }
                }

                // if user moved more than 4 times
                // game is drawn
                // set intNume to true to skip computer
                // set continue to false to exit
                if (continueGame && numberOfInput > 4) {
                    System.out.printf("\nIt’s a draw.  Good game, %s\r\n\n", name);
                    intNume = true;
                    continueGame = false;
                }
                intNume = false;
                //computer part
                while (continueGame && !intNume) {
                    if (letter1.equals("X")) {
                        letter2 = "O";
                    } else if (letter1.equals("O")) {
                        letter2 = "X";
                    }
                    int place2 = -9;
                    place2 = randomNumber();
                    if ((place2 == place1) || !(arrayPlace[place2].equals(""))) {
                        intNume = false;
                    } // arrayPlace=gameboard(place2 ,letter2);
                    else {
                        arrayPlace[place2] = letter2;
                        intNume = true;
                    }

                    boolean win2 = winnerCheck(arrayPlace, letter2);
                    if (win2) {
                        System.out.printf("\nThe computer is the winner\r\n\n");
                        // print the board
                        gameboard(arrayPlace);
                        continueGame = false;
                    } else {
                        continueGame = true;
                    }
                } // end of computer turn

                if (continueGame) {
                    //reset intNume to false for player
                    intNume = false;
                    // print the board
                    gameboard(arrayPlace);
                } else {
                    // Ask for play again
                    System.out.println("Do you want to play again? Y/N");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("N")) {
                        System.out.printf("It was nice game %s, see you soon\n\n", name);
                    } else if (answer.equalsIgnoreCase("Y")) {
                        numberOfInput = 0;
                        for (int n = 0; n < 9; n++) {
                            arrayPlace[n] = "";
                        }
                        continueGame = true;
                        intNume = false;
                        System.out.println("Do you want to use same name? Y/N");
                        String nameAnsuer = input.next();
                        if (nameAnsuer.equalsIgnoreCase("N")) {
                            System.out.println("Tipe the new name: ");
                            name = input.next();
                        }
                        System.out.println("Do you want to use same marke? Y/N");
                        String letterAnsuer = input.next();
                        if (letterAnsuer.equalsIgnoreCase("N")) {
                            System.out.println("Tipe the new marke O/X: ");
                            letter1 = input.next();
                            letter1 = letter1.toUpperCase();
                            if (!((letter1.equalsIgnoreCase("X")) || (letter1.equalsIgnoreCase("O")))) {
                                System.out.println("This is not the expected letter");
                            } else if ((letter1.equalsIgnoreCase("X")) || (letter1.equalsIgnoreCase("O"))) {
                                System.out.println("   0   |   1   |   2   ");
                                System.out.println("------------------------");
                                System.out.println("   3   |   4   |   5   ");
                                System.out.println("------------------------");
                                System.out.println("   6   |   7   |   8    \n");
                                numberOfInput = 0;
                                input.nextLine();
                            }

                        } else {

                            System.out.println("   0   |   1   |   2   ");
                            System.out.println("------------------------");
                            System.out.println("   3   |   4   |   5   ");
                            System.out.println("------------------------");
                            System.out.println("   6   |   7   |   8    \n");

                        }
                    }

                    input.nextLine();

                }
            }
        }
    }

    public static void gameboard(String[] arrayPlace) {
        System.out.print("   " + arrayPlace[0] + "   |   " + arrayPlace[1] + "   |  "
                + " " + arrayPlace[2] + "   \n");
        System.out.println("------------------------");
        System.out.print("   " + arrayPlace[3] + "   |   " + arrayPlace[4] + "   |  "
                + " " + arrayPlace[5] + "   \n");
        System.out.println("------------------------");
        System.out.print("   " + arrayPlace[6] + "   |   " + arrayPlace[7] + "   |   "
                + "" + arrayPlace[8] + "   \n\n\n");
        // return arrayPlace;
    }

    public static int randomNumber() {
        Random generator = new Random();
        int place2 = -9;
        place2 = generator.nextInt(8 - 0 + 1);
        return place2;
    }

    public static boolean winnerCheck(String arrayPlace[], String letter1) {
        int counter = 0;
        int[][] winner = {{1, 0, 0, 0, 1, 0, 0, 0, 1},
        {0, 0, 1, 0, 1, 0, 1, 0, 0},
        {1, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 1},
        {1, 0, 0, 1, 0, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 0, 0, 1, 0},
        {0, 0, 1, 0, 0, 1, 0, 0, 1}};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (arrayPlace[j] == letter1 && winner[i][j] == 1) {
                    counter++;
                }
            }
            if (counter == 3) {
                return true;
            } else {
                counter = 0;

            }
        }

        return false;
    }
}
